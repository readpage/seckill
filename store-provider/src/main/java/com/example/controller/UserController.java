package com.example.controller;

import com.example.entity.User;
import com.example.response.Result;
import com.example.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation("分页查询数据")
    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<User> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return userService.selectAll(pageNum, pageSize);
    }

    @ApiOperation("模糊查询用户")
    @GetMapping("/like/{username}/{pageSize}/{pageNum}")
    public PageInfo<User> findByUsernameLike(@PathVariable String username, @PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        return userService.findByUsernameLike(username, pageSize, pageNum);
    }

    @ApiOperation("通过id查询用户")
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @ApiOperation("通过username查询用户")
    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @ApiOperation("添加用户")
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        return add(user);
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @ApiOperation("修改用户")
    @PutMapping("/updateById")
    public Result updateById(@RequestBody User user) {
        return userService.updateById(user);
    }
}
