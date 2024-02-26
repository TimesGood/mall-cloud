package com.mall.generator.mbg.model;

import lombok.Data;

/**
 * 生成器配置（不包含数据库配置）
 */
@Data
public class GeneratorConfig {

	/**
	 * 本配置的名称
	 */
	private String name;

	/**
	 * 驱动jar包路径
	 */
	private String connectorJarPath;

	/**
	 * 项目根目录
	 */
	private String projectFolder;

	/**
	 * 实体类包名
	 */
	private String modelPackage;

	/**
	 * 实体类存放路径
	 */
	private String modelTargetFolder;

	/**
	 * mapper包名
	 */
	private String mapperPackage;

	/**
	 * mapper存放路径
	 */
	private String mapperTargetFolder;

	/**
	 * mapper接口名（默认表名+Mapper）
	 */
	private String mapperName;

	/**
	 * xml映射文件包名
	 */
	private String xmlPackage;

	/**
	 * xml映射文件存放路径
	 */
	private String xmlTargetFolder;

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 实体类名
	 */
	private String domainName;

	/**
	 * 是否开启分页
	 */
	private boolean offsetLimit;

	/**
	 * 是否开启注释
	 */
	private boolean comment;

	/**
	 * 是否覆盖已存在的xml（默认追加）
	 */
	private boolean overrideXML;

	/**
	 * 是否需要生成toString
	 */
	private boolean needToString;

	/**
	 * 是否使用Lombok
	 */
	private boolean useLombokPlugin;

	/**
	 * 是否使用ForUpdate（行锁）
	 */
	private boolean needForUpdate;

	/**
	 * 是否使用@Repository
	 */
	private boolean annotationDAO;

	/**
	 * jpa注解
	 */
	private boolean jpaAnnotation;

	/**
	 * 是否使用实际列名（默认驼峰式）
	 */
	private boolean useActualColumnNames;

	/**
	 * 是否使用Example
	 */
	private boolean useExample;

	/**
	 * 主键
	 */
	private String generateKeys;

	/**
	 * 表编码
	 */
	private String encoding;

	/**
	 * 是否使用表名为字段别名
	 */
	private boolean useTableNameAlias;

	/**
	 * 是否生成公共基类
	 * public interface MyBatisBaseDao<Model, PK extends Serializable, E> {}
	 */
	private boolean useDAOExtendStyle;

	/**
	 * 是否施一公模式后缀
	 */
    private boolean useSchemaPrefix;

	/**
	 * 是否使用jsr310日期规范
	 */
    private boolean jsr310Support;

}
