package com.example.security.handler;

import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.service.UserService;
import com.example.utlis.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String username=authentication.getName();
        Result result= ResultUtils.ok().data(userService.findByUsername(username)).message("登录成功");
        JsonUtils.toJson(httpServletRequest, httpServletResponse, result);
    }
}
