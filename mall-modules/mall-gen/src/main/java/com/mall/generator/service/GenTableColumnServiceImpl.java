package com.mall.generator.service;

import com.mall.generator.dao.GenTableColumnDao;
import com.mall.generator.domain.GenTableColumn;
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
public class GenTableColumnServiceImpl implements IGenTableColumnService {
    private final GenTableColumnDao genTableColumnDao;

    /**
     * 查询业务字段列表
     *
     * @param tableId 业务字段编号
     * @return 业务字段集合
     */
    @Override
    public List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId) {
        return genTableColumnDao.selectGenTableColumnListByTableId(tableId);
    }
    /**
     * 查询库表字段列表
     *
     * @param tableName 表名
     * @return 字段集合
     */
    @Override
    public List<GenTableColumn> selectDbTableColumnsByName(String tableName) {
        return genTableColumnDao.selectDbTableColumnsByName(tableName);
    }
}
