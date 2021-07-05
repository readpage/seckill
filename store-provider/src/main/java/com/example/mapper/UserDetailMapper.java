package com.example.mapper;


import com.example.entity.UserDetail;

public interface UserDetailMapper {
    UserDetail findByUsername(String username);

}
