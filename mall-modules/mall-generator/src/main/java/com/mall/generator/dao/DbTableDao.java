package com.mall.generator.dao;

import com.mall.generator.domain.DbTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 业务 数据层
 *
 */

public interface DbTableDao {

    List<DbTable> selectPageDbTableList(@Param("dbTable") DbTable dbTable);

    /**
     * 查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    List<DbTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 根据表明查询库表
     *
     * @param tableName 表名称
     * @return 业务信息
     */
    DbTable selectGenTableByName(String tableName);

}
