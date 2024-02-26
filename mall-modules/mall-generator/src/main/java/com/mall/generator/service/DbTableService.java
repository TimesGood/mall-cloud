package com.mall.generator.service;


import com.mall.core.domain.Page;
import com.mall.generator.domain.DbTable;
import com.mall.mybatis.page.PageQuery;

import java.util.List;
/**
 * 业务 服务层
 */
public interface DbTableService {

    /**
     * 查询据库列表
     *
     * @param genTable 业务信息
     * @return 数据库表集合
     */
    Page<DbTable> selectPageDbTableList(DbTable genTable, PageQuery pageQuery);
    /**
     * 根据多个表名查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    List<DbTable> selectDbTableListByNames(String[] tableNames);

    /**
     * 生成代码
     *
     * @param tableName 表名称
     * @return 数据
     */
    void generatorCode(String tableName);

}
