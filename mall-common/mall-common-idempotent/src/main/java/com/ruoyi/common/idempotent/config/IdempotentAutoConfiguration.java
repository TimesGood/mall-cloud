package com.ruoyi.common.idempotent.config;

import com.mall.redis.config.RedisConfiguration;
import com.ruoyi.common.idempotent.aspectj.RepeatSubmitAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 幂等功能配置
 */
@AutoConfiguration(after = RedisConfiguration.class)
public class IdempotentAutoConfiguration {

	@Bean
	public RepeatSubmitAspect repeatSubmitAspect() {
		return new RepeatSubmitAspect();
	}

}
