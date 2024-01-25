package com.mall.gen.service;

import com.alibaba.fastjson.JSON;
import com.mall.core.domain.Page;
import com.mall.gen.dao.GenTableColumnDao;
import com.mall.gen.dao.GenTableColumnMapper;
import com.mall.gen.dao.GenTableDao;
import com.mall.gen.dao.GenTableMapper;
import com.mall.gen.domain.GenTable;
import com.mall.gen.domain.GenTableColumn;
import com.mall.gen.domain.GenTableExample;
import com.mall.mybatis.page.PageQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 业务 服务层实现
 *
 * @author ruoyi
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

        return null;
//        return genTableColumnDao.selectList(new LambdaQueryWrapper<GenTableColumn>()
//            .eq(GenTableColumn::getTableId, tableId)
//            .orderByAsc(GenTableColumn::getSort));
    }
    @Override
    public List<GenTableColumn> selectDbTableColumnsByName(String tableName, String dataName) {
        return genTableColumnDao.selectDbTableColumnsByName(tableName,dataName);
    }
}
