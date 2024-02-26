package com.mall.generator.service;


import com.mall.generator.domain.DbTableColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 业务 服务层
 */
public interface DbTableColumnService {
    /**
     * 根据表名查询字段列表
     * @param tableName 表名
     * @param dataName 数据库名
     * @return 字段集合
     */
    List<DbTableColumn> selectDbTableColumnsByName(@Param("tableName") String tableName);
}
