package com.example.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetail implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private List<Role> roles;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    //当前账户是否未过期,默认是false
    public boolean isAccountNonExpired() {
        return true;
    }

    //当前账户是否未锁定
    public boolean isAccountNonLocked() {
        return true;
    }

    //当前账户密码是否未过期
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //当前账户是否可用
    public boolean isEnabled() {
        return true;
    }
}
