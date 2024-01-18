package com.mall.admin.dubbo;

import com.mall.admin.api.RemoteUmsAdminService;
import com.mall.admin.service.UmsAdminService;
import com.mall.core.domain.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@DubboService
public class RemoteAdminServiceImpl implements RemoteUmsAdminService {
    private final UmsAdminService adminService;
    @Override
    public UserDto loadUserByUsername(String username) {
        return adminService.loadUserByUsername(username);
    }
}
