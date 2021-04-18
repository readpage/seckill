package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @ApiOperation("分页查询数据")
    @GetMapping("/pageHelper/{pageSize}/{pageNum}")
    public PageInfo<User> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> user = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(user);
        return pageInfo;
    }

    @ApiOperation("模糊查询用户")
    @GetMapping("/like/{username}/{pageSize}/{pageNum}")
    public PageInfo<User> findByUsernameLike(@PathVariable String username, @PathVariable Integer pageSize, @PathVariable Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userMapper.findByUsernameLike(username));
    }

    @ApiOperation("通过id查询用户")
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        return userMapper.findById(id);
    }

    @ApiOperation("通过username查询用户")
    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable String username) {
        return userMapper.findByUsername(username);
    }

    @ApiOperation("添加用户")
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        Integer n = userMapper.add(user);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @ApiOperation("删除用户")
    @PostMapping("/delete/{id}")
    public Result add(@PathVariable Integer id) {
        Integer n = userMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @ApiOperation("修改用户")
    @PutMapping("/updateById")
    public Result updateById(@RequestBody User user) {
        Integer n = userMapper.updateById(user);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
