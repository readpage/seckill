package com.example.controller;

import com.example.output.Info;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.InfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "信息查询")
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @ApiOperation("信息统计")
    @GetMapping("/data")
    public Info data() {
        return infoService.selectInfo();
    }

    @ApiOperation("用户信息")
    @GetMapping("/user")
    public Result user(Authentication authentication) {
        return ResultUtils.ok().data(authentication);
    }
}
