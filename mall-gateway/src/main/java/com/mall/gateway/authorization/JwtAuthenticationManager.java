//package com.mall.gateway.authorization;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.ReactiveAuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
//import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//@Component
//public class JwtAuthenticationManager implements ReactiveAuthenticationManager {\
//
//    @Autowired
//
//    @Override
//    public Mono<Authentication> authenticate(Authentication authentication) {
//        return Mono.justOrEmpty(authentication)
//                .filter(p -> p instanceof BearerTokenAuthenticationToken)
//                .cast(BearerTokenAuthenticationToken.class)
//                .map(BearerTokenAuthenticationToken::getToken)
//                .flatMap(accessToken -> {
////解析令牌
//                    OAuth2AccessToken oAuth2AccessToken = this.tokenStore.readAccessToken(accessToken);
//                    if (oAuth2AccessToken == null) {
//                        return Mono.error(new InvalidBearerTokenException("无效的token"));
//                    } else if (oAuth2AccessToken.isExpired()) {
//                        return Mono.error(new InvalidBearerTokenException("token已过期"));
//                    }
//                    OAuth2Authentication oAuth2Authentication = this.tokenStore.readAuthentication(accessToken);
//                    if (oAuth2Authentication == null) {
//                        return Mono.error(new InvalidBearerTokenException("无效的token"));
//                    } else {
//                        return Mono.just(oAuth2Authentication);
//                    }
//                }).cast(Authentication.class);
//    }
//}
