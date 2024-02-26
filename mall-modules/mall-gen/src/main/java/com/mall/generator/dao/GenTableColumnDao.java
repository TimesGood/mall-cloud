package com.mall.generator.dao;


import com.mall.generator.domain.GenTableColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GenTableColumnDao {
    /**
     * 根据表名称查询列信息
     *
     * @param tableName 表名称
     * @param dataName 数据源名
     * @return 列信息
     */
    List<GenTableColumn> selectDbTableColumnsByName(@Param("tableName") String tableName);

    /**
     * 根据表id查询业务字段列表
     * @param tableId 业务字段编号
     * @return 业务字段集合
     */
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);

    /**
     * 新增业务字段
     *
     * @param genTableColumn 业务字段信息
     * @return 结果
     */
    int insertGenTableColumn(GenTableColumn genTableColumn);

}
