package com.mall.generator.domain;


import com.mall.mybatis.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper = true)
public class DbTableColumn extends BaseEntity {

    /**
     * 列名称
     */
    private String columnName;

    /**
     * 列描述
     */

    private String columnComment;

    /**
     * 列类型
     */
    private String columnType;

    /**
     * 是否主键（1是）
     */
    private String isPk;

    /**
     * 是否自增（1是）
     */
    private String isIncrement;

    /**
     * 排序
     */
    private Integer sort;
}
