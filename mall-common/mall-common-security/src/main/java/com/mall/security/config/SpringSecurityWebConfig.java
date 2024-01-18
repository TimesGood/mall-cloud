package com.mall.security.config;

import com.mall.security.filter.SecurityAuthTokenFilter;
import com.mall.security.handler.AuthAuthenticationEntryPoint;
import com.mall.security.handler.PathAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.context.SecurityContextHolderFilter;

@EnableWebSecurity
public class SpringSecurityWebConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private IgnoreUrlsConfig ignoreUrlsConfig;

        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            //白名单
            String[] permits = ignoreUrlsConfig.getUrls().toArray(new String[0]);

            httpSecurity.formLogin().disable();//禁用表单登陆
            //登陆异常处理
            httpSecurity.exceptionHandling()
                    .accessDeniedHandler(new PathAccessDeniedHandler())
                    .authenticationEntryPoint(new AuthAuthenticationEntryPoint());
            //路由
            httpSecurity.authorizeRequests()
                    .antMatchers("/**").authenticated()//需要鉴权的路径
                    .antMatchers(permits).permitAll()//白名单
                    .and().csrf().disable()//关闭跨域检查
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//关闭生成session
            //登陆校验
            httpSecurity.addFilterAfter(new SecurityAuthTokenFilter(), SecurityContextHolderFilter.class);
        }
    }
