package com.mall.generator.dao;


import com.mall.generator.domain.GeneratorConfig;

import java.util.List;


public interface GeneratorConfigDao {
    List<GeneratorConfig> selectList();
}
