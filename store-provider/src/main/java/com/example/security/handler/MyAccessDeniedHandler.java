package com.example.security.handler;


import com.example.response.Result;
import com.example.response.ResultCode;
import com.example.response.ResultUtils;
import com.example.utlis.JsonUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//权限不足处理器
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        Result result= ResultUtils.error(ResultCode.NO_PERMISSION);
        JsonUtils.toJson(httpServletRequest, httpServletResponse, result);
    }
}
