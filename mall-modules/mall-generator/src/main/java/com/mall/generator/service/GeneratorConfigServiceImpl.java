package com.mall.generator.service;

import com.mall.generator.dao.DbTableColumnDao;
import com.mall.generator.dao.GeneratorConfigDao;
import com.mall.generator.domain.DbTableColumn;
import com.mall.generator.domain.GeneratorConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务 服务层实现
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class GeneratorConfigServiceImpl implements GeneratorConfigService {
    private final GeneratorConfigDao generatorConfigDao;

    @Override
    public List<GeneratorConfig> selectList() {
        return generatorConfigDao.selectList();
    }
}
