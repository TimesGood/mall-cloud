package com.mall.generator.service;


import com.mall.generator.domain.GenTableColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 业务 服务层
 */
public interface IGenTableColumnService {
    /**
     * 根据表id查询业务字段列表
     * @param tableId 业务字段编号
     * @return 业务字段集合
     */
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);
    /**
     * 根据表名查询字段列表
     * @param tableName 表名
     * @param dataName 数据库名
     * @return 字段集合
     */
    List<GenTableColumn> selectDbTableColumnsByName(@Param("tableName") String tableName);
}
