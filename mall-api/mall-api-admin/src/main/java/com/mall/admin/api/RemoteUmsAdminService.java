package com.mall.admin.api;

import com.mall.core.domain.model.UserDto;

public interface RemoteUmsAdminService {

    UserDto loadUserByUsername(String username);
}
