package com.mall.mybatis.config;

import com.mall.mybatis.interceptor.MybatisInsertAutoFillPlugin;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan({"com.mall.mbg.mapper", "com.mall.*.dao"})//扫描mapper接口
public class MyBatisConfig {
}
