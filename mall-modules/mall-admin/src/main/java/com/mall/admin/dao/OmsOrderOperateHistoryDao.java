package com.mall.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.mall.mbg.model.OmsOrderOperateHistory;

import java.util.List;

/**
 * 订单操作记录自定义Dao
 */
@Mapper
public interface OmsOrderOperateHistoryDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<OmsOrderOperateHistory> orderOperateHistoryList);
}
