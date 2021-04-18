package com.example.service.impl;

import com.example.entity.UserInfo;
import com.example.mapper.UserInfoMapper;
import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageInfo<UserInfo> selectAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userInfoMapper.selectAll());
    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoMapper.findById(id);
    }

    @Override
    public Result add(UserInfo userInfo) {
        Integer n = userInfoMapper.add(userInfo);
        if (n==1) {
            return ResultUtils.ok().message("添加成功!");
        }
        return ResultUtils.error().message("添加失败!");
    }

    @Override
    public Result deleteById(Integer id) {
        Integer n = userInfoMapper.deleteById(id);
        if (n==1) {
            return ResultUtils.ok().message("删除成功!");
        }
        return ResultUtils.error().message("删除失败!");
    }

    @Override
    public Result updateById(UserInfo userInfo) {
        Integer n = userInfoMapper.updateById(userInfo);
        if (n==1) {
            return ResultUtils.ok().message("修改成功!");
        }
        return ResultUtils.error().message("修改失败!");
    }
}
