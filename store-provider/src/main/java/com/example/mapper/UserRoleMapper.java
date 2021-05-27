package com.example.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int insert(@Param("uid") Long uid, @Param("rid") Integer rid);
}
