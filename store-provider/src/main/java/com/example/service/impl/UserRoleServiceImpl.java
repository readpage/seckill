package com.example.service.impl;

import com.example.mapper.UserRoleMapper;
import com.example.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean insert(Long uid, Integer rid) {
        return userRoleMapper.insert(uid, rid)>0;
    }
}
