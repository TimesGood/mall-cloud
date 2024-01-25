package com.mall.auth.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SpringSecurity配置
 */
@Configuration
@EnableWebSecurity
public class SecurityTestConfig{

    /**
     * 密码加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()//关闭csrf跨域检查
//                .authorizeRequests()
//                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
//                .antMatchers("/rsa/publicKey").permitAll()
//                .antMatchers("/v2/api-docs").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()//关闭csrf跨域检查
                .authorizeRequests()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .antMatchers("/rsa/publicKey").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
        return http.build();
    }
}
