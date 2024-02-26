package com.mall.generator.service;

import com.mall.generator.dao.DbTableColumnDao;
import com.mall.generator.domain.DbTableColumn;
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
public class DbTableColumnServiceImpl implements DbTableColumnService {
    private final DbTableColumnDao dbTableColumnDao;

    @Override
    public List<DbTableColumn> selectDbTableColumnsByName(String tableName) {
        return dbTableColumnDao.selectDbTableColumnsByName(tableName);
    }
}
