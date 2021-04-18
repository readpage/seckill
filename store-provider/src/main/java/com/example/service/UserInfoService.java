package com.example.service;

import com.example.entity.UserInfo;
import com.example.response.Result;
import com.github.pagehelper.PageInfo;

public interface UserInfoService {

    PageInfo<UserInfo> selectAll(Integer pageSize, Integer pageNum);

    UserInfo findById(Integer id);

    Result add(UserInfo userInfo);

    Result deleteById(Integer id);

    Result updateById(UserInfo userInfo);
}
