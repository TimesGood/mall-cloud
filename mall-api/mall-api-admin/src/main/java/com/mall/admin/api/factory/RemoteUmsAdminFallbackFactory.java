//package com.mall.admin.api.factory;
//
//import com.mall.admin.api.RemoteUmsAdminService;
//import com.mall.core.domain.model.UserDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.openfeign.FallbackFactory;
//import org.springframework.stereotype.Component;
//
///**
// * 服务调用失败回调处理
// */
//@Component
//public class RemoteUmsAdminFallbackFactory implements FallbackFactory<RemoteUmsAdminService>
//{
//    private static final Logger log = LoggerFactory.getLogger(RemoteUmsAdminFallbackFactory.class);
//
//    public RemoteUmsAdminService create(Throwable throwable) {
//        log.error("用户服务调用失败:{}", throwable.getMessage());
//        return new RemoteUmsAdminService() {
//            public UserDto loadUserByUsername(String username) {return null;}
//        };
//    }
//}
