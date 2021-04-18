package com.example.mapper;

import com.example.entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    List<UserInfo> selectAll();

    UserInfo findById(Integer id);

    Integer  add(UserInfo userInfo);

    Integer  deleteById(Integer  id);

    Integer updateById(UserInfo userInfo);
}
