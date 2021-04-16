package com.example.mapper;

import com.example.entity.User;

import java.util.List;

public interface UserMapper {
    User findByUsername(String username);

    User findById(Integer id);

    List<User> selectAll();

    int add(User user);

    int deleteById(int id);

    int updateById(User user);
}
