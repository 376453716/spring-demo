package com.xh.jwt.config.auth;

import com.alibaba.fastjson.JSON;
import com.xh.jwt.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        try (PrintWriter writer = response.getWriter()) {
            ResponseResult result = new ResponseResult(HttpServletResponse.SC_UNAUTHORIZED, "未登录或登录已过期");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setCharacterEncoding("UTF-8");
            String content = JSON.toJSONString(result);
            writer.println(content);
            writer.flush();
        } finally {
        }
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}

