package com.mall.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 校验验证码服务
 */
@Service
public class PhoneSmsCodeService {


    /**
     * 校验手机验证码信息
     *
     * @param phone
     * @param code
     * @return
     */
    public boolean checkSmsCode(String phone, String code) {
        return StringUtils.endsWithIgnoreCase("15000000000", phone) && StringUtils.endsWithIgnoreCase("888888", code);
    }

}
