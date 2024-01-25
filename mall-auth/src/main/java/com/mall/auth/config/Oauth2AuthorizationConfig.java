package com.mall.auth.config;

import com.mall.auth.service.AuthClientDetailService;
import com.mall.auth.service.AuthUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthClientDetailService authClientDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthUserDetailService userDetailsService;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    @Autowired
    private AuthorizationServerTokenServices tokenServices;

    /**
     * 设置授权码模式（authorization_code）的授权码如何获取
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }

    /*----------------------------------------------------------------------------------------------------------------------*/
    /**
     * 令牌端点安全约束
     * 配置对获取授权码，检查token等某些路径进行放行
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")//oauth/token_key 公开，获取公钥需要访问该端点
                .checkTokenAccess("isAuthenticated()")//oauth/check_token 需授权，校验Token需要请求该端点
                .allowFormAuthenticationForClients();//允许表单认证，申请令牌
    }

    /**
     * 客户端详情服务
     * 客户端（浏览器...）向授权服务器获取授权码或令牌时需要提交的参数配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(authClientDetailService);
    }

    /**
     * 令牌访问端点
     * 配置如何管理授权码(内存或jdbc)，如何管理令牌（存储方式，有效时间等）
     * @param endpoints
     * @throws Exception
     */

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)//认证管理器
                .userDetailsService(userDetailsService)//密码模式服务
                .authorizationCodeServices(authorizationCodeServices())//授权码模式服务管理
                .tokenStore(tokenStore)//token存储策略
                .accessTokenConverter(accessTokenConverter)
                .tokenServices(tokenServices)
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);//允许POST请求方式
    }
}
