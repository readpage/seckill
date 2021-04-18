package com.example.mapper;

import com.example.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    List<User> findByUsernameLike(String username);

    User findByUsername(String username);

    User findById(Integer id);

    Integer add(User user);

    Integer deleteById(Integer id);

    Integer updateById(User user);

}
