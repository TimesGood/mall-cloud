package com.mall.mbg.mapper;

import com.mall.mbg.model.UmsMenu;
import com.mall.mbg.model.UmsMenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UmsMenuMapper {
    long countByExample(UmsMenuExample example);

    int deleteByExample(UmsMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMenu record);

    int insertSelective(UmsMenu record);

    List<UmsMenu> selectByExample(UmsMenuExample example);

    UmsMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMenu record, @Param("example") UmsMenuExample example);

    int updateByExample(@Param("record") UmsMenu record, @Param("example") UmsMenuExample example);

    int updateByPrimaryKeySelective(UmsMenu record);

    int updateByPrimaryKey(UmsMenu record);
}
