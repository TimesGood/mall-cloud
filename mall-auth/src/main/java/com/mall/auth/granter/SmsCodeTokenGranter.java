package com.mall.auth.granter;

import cn.hutool.core.util.StrUtil;
import com.mall.auth.service.PhoneSmsCodeService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 手机验证码授权者
 */
public class SmsCodeTokenGranter extends AbstractTokenGranter {

    /// 授权模式类型，需要与请求字段grant_type的值相等才会进入处理
    private static final String GRANT_TYPE = "sms_code";
    // 验证手机与验证码信息是否匹配，这里只是简单的进行匹配处理，判断是否是否为15000000000，验证码是否为：888888
    // 具体可视情况在某服务上进行验证
    private final PhoneSmsCodeService phoneSmsCodeService;

    public SmsCodeTokenGranter(AuthorizationServerTokenServices tokenServices,
                               ClientDetailsService clientDetailsService,
                               OAuth2RequestFactory requestFactory,
                               PhoneSmsCodeService phoneSmsCodeService) {
        super(tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
        this.phoneSmsCodeService = phoneSmsCodeService;
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {

        Map<String, String> parameters = new LinkedHashMap(tokenRequest.getRequestParameters());

        String mobile = parameters.get("mobile"); // 手机号
        String code = parameters.get("code"); // 短信验证码
        ///对参数进行基础校验
        if (StrUtil.isEmpty(mobile) || StrUtil.isEmpty(code)) {
            throw new InvalidGrantException("授权请求参数异常");
        }
        /// 校验手机验证码是否符合要求
        if (!phoneSmsCodeService.checkSmsCode(mobile, code)) {
            throw new InvalidGrantException("授权请求参数异常");
        }

        /// 这里为了简单直接硬编码写入用户信息，通常需要在数据库中取出用户相关信息
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add( new SimpleGrantedAuthority("user"));
        User user = new User(mobile, "", roles);
        /// 授权模式
        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(user, null, roles);
        OAuth2Request storedOAuth2Request = this.getRequestFactory()
                .createOAuth2Request(client, tokenRequest);
        return new OAuth2Authentication(storedOAuth2Request, userAuth);
    }
}


