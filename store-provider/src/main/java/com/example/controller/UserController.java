package com.example.controller;


import com.example.entity.User;
import com.example.input.InUser;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author f1dao
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/user/")
@Api(tags = "用户信息管理")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("分页查询数据")
    @GetMapping("/page/{pageNum}/{pageSize}")
    public PageInfo<User> page(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        return userService.page(pageNum, pageSize);
    }

    @ApiOperation(value = "注册用户")
    @PostMapping("/register")
    public Result register(@RequestBody InUser inUser) throws Exception {
        if (userService.register(new User(inUser))) {
            return ResultUtils.ok().message("注册成功😂");
        }
        return ResultUtils.error().message("注册失败😂!");
    }

    @ApiOperation(value = "修改用户", notes = "参数只需添加<em>id,username,password</em>")
    @PutMapping("/update")
    public Result updateById(@RequestBody User user) {
        return userService.myUpdateById(user);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/delete/{id}")
    public Result DeleteById(@PathVariable Integer id) {
        return userService.myDeleteById(id);
    }

    @ApiOperation("模糊查询用户名")
    @GetMapping("/like/{username}")
    public List<User> like(@PathVariable String username) {
        return userService.like(username);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/deleteBatchId/{list}")
    public Result DeleteBatchId(@PathVariable List<Integer> list) {
        return userService.myDeleteBatchId(list);
    }
    
    @ApiOperation("查询用户")
    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @ApiOperation("查询用户名是否存在")
    @GetMapping("/selectIsUsername")
    public boolean selectIsUsername(String username) {
        return userService.selectIsUsername(username);
    }

    @ApiOperation("查询用户数量")
    @GetMapping("/selectUserCount")
    public int selectUserCount() {
        return userService.selectUserCount();
    }
}

