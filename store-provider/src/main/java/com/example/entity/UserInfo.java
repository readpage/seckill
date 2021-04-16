package com.example.entity;

import java.util.Date;

public class UserInfo {
    private Integer id;
    private String avatar;
    private Date register_date;
    private Integer login_count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Integer getLogin_count() {
        return login_count;
    }

    public void setLogin_count(Integer login_count) {
        this.login_count = login_count;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", register_date=" + register_date +
                ", login_count=" + login_count +
                '}';
    }
}
