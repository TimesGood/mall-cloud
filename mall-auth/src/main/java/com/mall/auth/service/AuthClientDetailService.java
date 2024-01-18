package com.mall.auth.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * 客户端用户服务

 */
@Service
public class AuthClientDetailService implements ClientDetailsService {

    private ClientDetailsService clientDetailsService;


    /**
     * 目前基于内存方式
     */
    public AuthClientDetailService() {
        InMemoryClientDetailsServiceBuilder builder = new InMemoryClientDetailsServiceBuilder();
        builder.withClient("admin-app")//client_id
                .secret(new BCryptPasswordEncoder().encode("123456"))//客户端密钥
                .resourceIds("admin")//客户端拥有的资源列表
                .authorizedGrantTypes("authorization_code","password","client_credentials","implicit", "refresh_token")//允许的授权类型
                .accessTokenValiditySeconds(60 * 60 * 2) // 令牌默认有效期2小时
                .refreshTokenValiditySeconds(60 * 60 * 24 * 3) // 刷新令牌默认有效期3天
                .scopes("all") // 允许授权范围
                .autoApprove(false) // 跳转授权页面
                .redirectUris("http://www.baidu.com");//授权回调地址
        try {
            this.clientDetailsService = builder.build();
        } catch (Exception e) {
            System.exit(-1);
        }
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return this.clientDetailsService.loadClientByClientId(clientId);
    }
}
