//package com.mall.auth.handler;
//
//import cn.hutool.json.JSONUtil;
//import com.mall.core.domain.R;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 客户端认证失败处理
// */
//@Slf4j
//public class AuthAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//        response.setStatus(HttpStatus.OK.value());
//        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//        String body= JSONUtil.toJsonStr(R.unauthorized(authException.getMessage()));
//        response.getWriter().print(body);
//        response.getWriter().flush();
//    }
//}
