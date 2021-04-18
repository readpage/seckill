package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> user = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(user);
        return pageInfo;
    }

    @Override
    public PageInfo<User> findByUsernameLike(String username, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userMapper.findByUsernameLike(username));
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Result add(User user) {
        Integer n = userMapper.add(user);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @Override
    public Result delete(Integer id) {
        Integer n = userMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @Override
    public Result updateById(User user) {
        Integer n = userMapper.updateById(user);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
