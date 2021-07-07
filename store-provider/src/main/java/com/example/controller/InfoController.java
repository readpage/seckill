package com.example.controller;

import com.example.entity.User;
import com.example.output.Info;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.InfoService;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;

@RestController
@Api(tags = "信息查询")
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @Autowired
    private UserService userService;

    @ApiOperation("信息统计")
    @GetMapping("/data")
    public Info data() {
        return infoService.selectInfo();
    }

    @ApiOperation("查询当前用户信息")
    @GetMapping("/user")
    public Result user(@ApiIgnore Authentication authentication) {
        HashMap<String, String> map = new HashMap<>();
        return ResultUtils.ok().data(infoService.selectByUsername(authentication.getName()));
    }

    @ApiOperation("修改个人信息")
    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User user, @ApiIgnore Authentication authentication) {
        if (userService.updateByUsername(user, authentication.getName())) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }

}
