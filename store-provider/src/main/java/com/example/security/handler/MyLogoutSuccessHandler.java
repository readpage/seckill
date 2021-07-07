package com.example.security.handler;

import com.example.response.Result;
import com.example.response.ResultUtils;
import com.example.utlis.JsonUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销成功处理器
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Result result= ResultUtils.ok().message("注销成功");
        JsonUtils.toJson(httpServletRequest, httpServletResponse, result);
    }
}
