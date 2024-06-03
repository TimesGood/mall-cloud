package com.mall.swagger.config.properties;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SwaggerProperties {
    private String groupName;

    /**
     * 项目应用名
     */
    private String applicationName;

    /**
     * 项目版本信息
     */
    private String version;

    /**
     * 项目描述信息
     */
    private String description;
}
