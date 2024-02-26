package com.mall.generator.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author
 * 代码生成业务表
 */
@Data
public class GenTableBack implements Serializable {
    /**
     * 编号
     */

    private Long table_id;

    /**
     * 表名称
     */
    private String table_name;

    /**
     * 表描述
     */
    private String table_comment;

    /**
     * 关联子表的表名
     */
    private String sub_table_name;

    /**
     * 子表关联的外键名
     */
    private String sub_table_fk_name;

    /**
     * 实体类名称
     */
    private String class_name;

    /**
     * 使用的模板（crud单表操作 tree树表操作）
     */
    private String tpl_category;

    /**
     * 生成包路径
     */
    private String package_name;

    /**
     * 生成模块名
     */
    private String module_name;

    /**
     * 生成业务名
     */
    private String business_name;

    /**
     * 生成功能名
     */
    private String function_name;

    /**
     * 生成功能作者
     */
    private String function_author;

    /**
     * 生成代码方式（0zip压缩包 1自定义路径）
     */
    private String gen_type;

    /**
     * 生成路径（不填默认项目路径）
     */
    private String gen_path;

    /**
     * 其它生成选项
     */
    private String options;

    /**
     * 创建者
     */
    private String create_by;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 更新者
     */
    private String update_by;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}
