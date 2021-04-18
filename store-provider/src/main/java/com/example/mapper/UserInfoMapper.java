package com.example.mapper;

import com.example.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {
    List<UserInfo> selectAll();

    UserInfo findById(Integer id);

    Integer  add(UserInfo userInfo);

    Integer  deleteById(Integer  id);

    Integer updateById(UserInfo userInfo);
}
