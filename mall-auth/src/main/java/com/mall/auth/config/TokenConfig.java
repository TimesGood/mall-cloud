package com.mall.auth.config;

import com.mall.auth.domain.SecurityUser;
import com.mall.auth.service.AuthClientDetailService;
import com.mall.auth.service.AuthUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.security.KeyPair;
import java.util.*;

@Configuration
public class TokenConfig {

    @Autowired
    private AuthClientDetailService authClientDetailService;
    @Autowired
    private AuthUserDetailService userDetailsService;

    /**
     * token存储方案
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    /**
     * token转换器
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setKeyPair(keyPair());
        return jwtAccessTokenConverter;
    }

    /**
     * 证书文件
     *
     * @return
     */
    @Bean
    public KeyPair keyPair() {
        //从classpath下的证书中获取秘钥对
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
        return keyStoreKeyFactory.getKeyPair("jwt", "123456".toCharArray());
    }


    /**
     * token内容增强
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
            Map<String, Object> info = new HashMap<>();
            //把用户ID设置到JWT中
            info.put("user_id", securityUser.getId());
            info.put("client_id", securityUser.getClientId());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
            return accessToken;
        };
    }

    /**
     * 令牌服务配置
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices defaultTokenService = new DefaultTokenServices();
        defaultTokenService.setTokenStore(tokenStore());//令牌存储策略
        defaultTokenService.setSupportRefreshToken(true);//允许令牌刷新
        defaultTokenService.setClientDetailsService(authClientDetailService);//客户端详情服务
        //令牌增强
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(accessTokenConverter());
        delegates.add(tokenEnhancer());
        enhancerChain.setTokenEnhancers(delegates); //配置JWT的内容增强器
        defaultTokenService.setTokenEnhancer(enhancerChain);
        defaultTokenService.setAccessTokenValiditySeconds(60 * 60 * 2);//令牌默认有效期2小时
        defaultTokenService.setRefreshTokenValiditySeconds(60 * 60 * 24 * 3);//刷新令牌默认有效期3天

        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
        provider.setPreAuthenticatedUserDetailsService(new UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken>(userDetailsService));
        defaultTokenService.setAuthenticationManager(new ProviderManager(Arrays.<AuthenticationProvider> asList(provider)));
        return defaultTokenService;
    }
}
