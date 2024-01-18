package com.mall.admin.api.fallback;

import com.mall.admin.api.RemoteUmsAdminService;
import com.mall.core.domain.model.UserDto;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务调用失败具体处理逻辑
 */
@Slf4j
public class RemoteUmsAdminFallbackImpl implements RemoteUmsAdminService {
    @Setter
    private Throwable cause;

    @Override
    public UserDto loadUserByUsername(String username) {
        log.error("feign 调用{}出错", username, cause);
        log.error("异常信息: {}", cause);
        return null;
    }
}
