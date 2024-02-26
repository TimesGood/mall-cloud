package com.mall.mybatis.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Tree基类
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class TreeEntity<T> extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父菜单名称
     */

    private String parentName;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 子菜单
     */

    private List<T> children = new ArrayList<>();

}
