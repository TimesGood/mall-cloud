package com.mall.gen.dao;


import com.mall.gen.domain.GenTableColumn;
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
    List<GenTableColumn> selectDbTableColumnsByName(@Param("tableName") String tableName, @Param("dataName") String dataName);


}
