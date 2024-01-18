package com.mall.security.filter;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.core.constant.AuthConstant;
import com.mall.security.model.BlogAuthentication;
import com.nimbusds.jose.JWSObject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 安全验证Token过滤器
 * 网关已经对权限资源进行校验，这里只需要查看token过期与否即可
 */
public class SecurityAuthTokenFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(AuthConstant.JWT_TOKEN_HEADER);
        if (StrUtil.isEmpty(token)) {
            /// 继续处理
            filterChain.doFilter(request, response);
            return;
        }
        String userStr = "";
        try {
            //从token中解析用户信息
            String realToken = token.replace(AuthConstant.JWT_TOKEN_PREFIX, "");
            JWSObject jwsObject = JWSObject.parse(realToken);
            userStr = jwsObject.getPayload().toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //解析json数据
        JSONObject tokenJson = JSONObject.parseObject(userStr);
        //用户资源
        List<String> resourceIds = new ArrayList<>();
        if (tokenJson.containsKey("aud")) {
            JSONArray auds = tokenJson.getJSONArray("aud");
            if (!auds.isEmpty()) {
                resourceIds.addAll(auds.toList(String.class));
            }
        }
        String userId = tokenJson.getString("user_id");
        String clientId = tokenJson.getString("client_id");
        //用户权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (tokenJson.containsKey("authorities")) {
            JSONArray authors = tokenJson.getJSONArray("authorities");
            if (!authors.isEmpty()) {
                authorities.addAll(authors.toList(String.class).stream()
                        .map(SimpleGrantedAuthority::new).collect(
                                Collectors.toList()));
            }
        }
        BlogAuthentication authentication = new BlogAuthentication(userId, clientId, authorities);
        authentication.setResourceIds(resourceIds);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
