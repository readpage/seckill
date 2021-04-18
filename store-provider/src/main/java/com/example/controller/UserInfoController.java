package com.example.controller;

import com.example.entity.UserInfo;
import com.example.response.Result;
import com.example.service.impl.UserInfoServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户详细信息")
@RequestMapping("/userInfo")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @ApiOperation("分页查询用户信息")
    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<UserInfo> selectAll(@PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        return userInfoService.selectAll(pageSize,pageNum);
    }

    @ApiOperation("通过id查询用户信息")
    @GetMapping("/findById/{id}")
    public UserInfo findById(@PathVariable Integer id) {
        return userInfoService.findById(id);
    }

    @ApiOperation("添加用户信息")
    @PostMapping("/add")
    public Result add(@RequestBody UserInfo userInfo) {
        return userInfoService.add(userInfo);
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        return userInfoService.deleteById(id);
    }

    @ApiOperation("修改用户信息")
    @PutMapping("/update")
    public Result updateById(@RequestBody UserInfo userInfo) {
        return userInfoService.updateById(userInfo);
    }
}
