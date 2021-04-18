package com.example.controller;

import com.example.entity.UserInfo;
import com.example.mapper.UserInfoMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "用户详细信息")
@RequestMapping("/userInfo")
@RestController
public class UserInfoController {

    @Resource
    UserInfoMapper userInfoMapper;

    @ApiOperation("分页查询用户信息")
    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<UserInfo> selectAll(@PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userInfoMapper.selectAll());
    }

    @ApiOperation("通过id查询用户信息")
    @GetMapping("/findById/{id}")
    public UserInfo findById(@PathVariable Integer id) {
        return userInfoMapper.findById(id);
    }

    @ApiOperation("添加用户信息")
    @PostMapping("/add")
    public Result add(@RequestBody UserInfo userInfo) {
        Integer n = userInfoMapper.add(userInfo);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        Integer n = userInfoMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @ApiOperation("修改用户信息")
    @PutMapping("/update")
    public Result updateById(@RequestBody UserInfo userInfo) {
        Integer n = userInfoMapper.updateById(userInfo);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
