package com.example.service;

import com.example.output.Info;
import com.example.output.UserInfo;

public interface InfoService {
    Info selectInfo();

    UserInfo selectByUsername(String username);
}
