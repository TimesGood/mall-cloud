package com.mall.generator.service;


import com.mall.generator.domain.DbTableColumn;
import com.mall.generator.domain.GeneratorConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 业务 服务层
 */
public interface GeneratorConfigService {
    List<GeneratorConfig> selectList();
}
