package com.mall.gen.service;


import com.mall.core.domain.Page;
import com.mall.gen.domain.GenTable;
import com.mall.gen.domain.GenTableColumn;
import com.mall.mybatis.page.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 业务 服务层
 */
public interface IGenTableColumnService {
    /**
     * 查询业务字段列表
     *
     * @param tableId 业务字段编号
     * @return 业务字段集合
     */
    List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);
    List<GenTableColumn> selectDbTableColumnsByName(@Param("tableName") String tableName, @Param("dataName") String dataName);
}
