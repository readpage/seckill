package com.example.security.service;


import com.example.entity.UserDetail;
import com.example.mapper.UserDetailMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    UserDetailMapper userDetailMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetail user = userDetailMapper.findByUsername(s);
        if (user==null) {
            throw new UsernameNotFoundException("");
        }
        return user;
    }
}
