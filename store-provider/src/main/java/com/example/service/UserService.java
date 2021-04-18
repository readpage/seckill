package com.example.service;

import com.example.entity.User;
import com.example.response.Result;
import com.github.pagehelper.PageInfo;

public interface UserService {

    PageInfo<User> selectAll(int pageNum, int pageSize);

    PageInfo<User> findByUsernameLike(String username, Integer pageSize, Integer pageNum);

    User findById(Integer id);

    User findByUsername(String username);

    Result add(User user);

    Result delete(Integer id);

    Result updateById(User user);
}
