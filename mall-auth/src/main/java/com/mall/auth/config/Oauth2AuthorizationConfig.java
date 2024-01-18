package com.mall.auth.config;

import com.mall.auth.service.AuthClientDetailService;
import com.mall.auth.service.AuthUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
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
    private TokenEnhancer tokenEnhancer;
    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;
//    /**
//     * 令牌服务配置
//     */
//    @Bean
//    public AuthorizationServerTokenServices tokenService() {
//        DefaultTokenServices service = new DefaultTokenServices();
//        service.setClientDetailsService(authClientDetailService);//客户端详情服务
//        service.setSupportRefreshToken(true);//允许令牌自动刷新
//        service.setTokenStore(tokenStore);//令牌存储策略
//
//        //令牌增强
//        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
//        List<TokenEnhancer> delegates = new ArrayList<>();
//        delegates.add(accessTokenConverter);
//        delegates.add(tokenEnhancer);
//        enhancerChain.setTokenEnhancers(delegates); //配置JWT的内容增强器
//        service.setTokenEnhancer(enhancerChain);
//        service.setAccessTokenValiditySeconds(60 * 60 * 2);//令牌默认有效期2小时
//        service.setRefreshTokenValiditySeconds(60 * 60 * 24 * 3);//刷新令牌默认有效期3天
//        return service;
//    }
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
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")//oauth/token_key
                .checkTokenAccess("permitAll()")//oauth/check_token
                .allowFormAuthenticationForClients();//允许表单认证，申请令牌
    }

    /**
     * 客户端详情服务
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(authClientDetailService);
    }

    /**
     * 令牌访问端点
     * @param endpoints
     * @throws Exception
     */

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //令牌增强
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(tokenEnhancer);
        delegates.add(accessTokenConverter);
        enhancerChain.setTokenEnhancers(delegates); //配置JWT的内容增强器

        endpoints.authenticationManager(authenticationManager)//认证管理器
                .userDetailsService(userDetailsService)//密码模式服务
                .authorizationCodeServices(authorizationCodeServices())//授权码模式服务管理
                .tokenStore(tokenStore)//token存储策略
                .accessTokenConverter(accessTokenConverter)
                .tokenEnhancer(enhancerChain)
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);//允许POST请求方式
    }

}
