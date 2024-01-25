package com.mall.gen.mbg.model;

/**
 * 生成器配置（不包含数据库配置）
 */
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
	private String modelPackageTargetFolder;

	/**
	 * mapper包名
	 */
	private String daoPackage;

	/**
	 * mapper存放路径
	 */
	private String daoTargetFolder;

	/**
	 * mapper接口名（默认表名+Mapper）
	 */
	private String mapperName;

	/**
	 * xml映射文件包名
	 */
	private String mappingXMLPackage;

	/**
	 * xml映射文件存放路径
	 */
	private String mappingXMLTargetFolder;

	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 实体类名
	 */
	private String domainObjectName;

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
	private boolean needToStringHashcodeEquals;

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
	 * 注释
	 */
	private boolean annotation;

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

    public boolean isJsr310Support() {
        return jsr310Support;
    }

    public void setJsr310Support(boolean jsr310Support) {
        this.jsr310Support = jsr310Support;
    }

    public boolean isUseSchemaPrefix() {
        return useSchemaPrefix;
    }

    public void setUseSchemaPrefix(boolean useSchemaPrefix) {
        this.useSchemaPrefix = useSchemaPrefix;
    }

	public boolean isUseExample() {
		return useExample;
	}

	public void setUseExample(boolean useExample) {
		this.useExample = useExample;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getDomainObjectName() {
		return domainObjectName;
	}

	public void setDomainObjectName(String domainObjectName) {
		this.domainObjectName = domainObjectName;
	}

	public String getConnectorJarPath() {
		return connectorJarPath;
	}

	public void setConnectorJarPath(String connectorJarPath) {
		this.connectorJarPath = connectorJarPath;
	}

	public String getProjectFolder() {
		return projectFolder;
	}

	public void setProjectFolder(String projectFolder) {
		this.projectFolder = projectFolder;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getModelPackageTargetFolder() {
		return modelPackageTargetFolder;
	}

	public void setModelPackageTargetFolder(String modelPackageTargetFolder) {
		this.modelPackageTargetFolder = modelPackageTargetFolder;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

	public String getDaoTargetFolder() {
		return daoTargetFolder;
	}

	public void setDaoTargetFolder(String daoTargetFolder) {
		this.daoTargetFolder = daoTargetFolder;
	}

	public String getMappingXMLPackage() {
		return mappingXMLPackage;
	}

	public void setMappingXMLPackage(String mappingXMLPackage) {
		this.mappingXMLPackage = mappingXMLPackage;
	}

	public String getMappingXMLTargetFolder() {
		return mappingXMLTargetFolder;
	}

	public void setMappingXMLTargetFolder(String mappingXMLTargetFolder) {
		this.mappingXMLTargetFolder = mappingXMLTargetFolder;
	}

	public boolean isOffsetLimit() {
		return offsetLimit;
	}

	public void setOffsetLimit(boolean offsetLimit) {
		this.offsetLimit = offsetLimit;
	}

	public boolean isComment() {
		return comment;
	}

	public void setComment(boolean comment) {
		this.comment = comment;
	}

    public boolean isNeedToStringHashcodeEquals() {
        return needToStringHashcodeEquals;
    }

    public void setNeedToStringHashcodeEquals(boolean needToStringHashcodeEquals) {
        this.needToStringHashcodeEquals = needToStringHashcodeEquals;
    }

	public boolean isUseLombokPlugin() {
		return useLombokPlugin;
	}

	public void setUseLombokPlugin(boolean useLombokPlugin) {
		this.useLombokPlugin = useLombokPlugin;
	}

	public boolean isNeedForUpdate() {
		return needForUpdate;
	}

	public void setNeedForUpdate(boolean needForUpdate) {
		this.needForUpdate = needForUpdate;
	}

	public boolean isAnnotationDAO() {
		return annotationDAO;
	}

	public void setAnnotationDAO(boolean annotationDAO) {
		this.annotationDAO = annotationDAO;
	}

	public boolean isAnnotation() {
		return annotation;
	}

	public void setAnnotation(boolean annotation) {
		this.annotation = annotation;
	}

	public boolean isUseActualColumnNames() {
		return useActualColumnNames;
	}

	public void setUseActualColumnNames(boolean useActualColumnNames) {
		this.useActualColumnNames = useActualColumnNames;
	}

	public String getMapperName() {
		return mapperName;
	}

	public void setMapperName(String mapperName) {
		this.mapperName = mapperName;
	}

	public String getGenerateKeys() {
		return generateKeys;
	}

	public void setGenerateKeys(String generateKeys) {
		this.generateKeys = generateKeys;
	}

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

	public boolean getUseTableNameAlias() {
		return useTableNameAlias;
	}

	public void setUseTableNameAlias(boolean useTableNameAlias) {
		this.useTableNameAlias = useTableNameAlias;
	}

	public boolean isUseTableNameAlias() {
		return useTableNameAlias;
	}

	public boolean isOverrideXML() {
		return overrideXML;
	}

	public void setOverrideXML(boolean overrideXML) {
		this.overrideXML = overrideXML;
	}

	public void setUseDAOExtendStyle(boolean useDAOExtendStyle) {
		this.useDAOExtendStyle = useDAOExtendStyle;
	}

	public boolean isUseDAOExtendStyle() {
		return useDAOExtendStyle;
	}
}
