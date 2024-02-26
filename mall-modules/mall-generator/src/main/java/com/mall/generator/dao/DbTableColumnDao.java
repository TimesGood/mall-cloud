package com.mall.generator.dao;


import com.mall.generator.domain.DbTableColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DbTableColumnDao {
    /**
     * 根据表名称查询列信息
     *
     * @param tableName 表名称
     * @param dataName 数据源名
     * @return 列信息
     */
    List<DbTableColumn> selectDbTableColumnsByName(@Param("tableName") String tableName);


}
