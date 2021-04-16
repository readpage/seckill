package com.example.mapper;

import com.example.entity.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    UserInfo findById(Integer id);

    List<UserInfo> selectAll(UserInfo userInfo);

    int add(UserInfo userInfo);

    int deleteById(int id);

    int updateById(UserInfo userInfo);
}
