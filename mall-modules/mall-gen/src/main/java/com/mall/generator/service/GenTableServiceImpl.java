package com.mall.generator.service;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mall.core.domain.Page;
import com.mall.core.exception.ServiceException;
import com.mall.generator.constant.GenConstants;
import com.mall.generator.dao.GenTableColumnDao;
import com.mall.generator.dao.GenTableColumnMapper;
import com.mall.generator.dao.GenTableDao;
import com.mall.generator.dao.GenTableMapper;
import com.mall.generator.domain.GenTable;
import com.mall.generator.domain.GenTableColumn;
import com.mall.generator.domain.GenTableColumnExample;
import com.mall.generator.domain.GenTableExample;
import com.mall.generator.mbg.MybatisGeneratorBridge;
import com.mall.generator.mbg.model.DatabaseConfig;
import com.mall.generator.mbg.model.GeneratorConfig;
import com.mall.generator.utils.GenUtils;
import com.mall.generator.utils.VelocityInitializer;
import com.mall.generator.utils.VelocityUtils;
import com.mall.mybatis.page.PageQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.mybatis.generator.config.ColumnOverride;
import org.mybatis.generator.config.IgnoredColumn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 业务 服务层实现
 *
 * @author ruoyi
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class GenTableServiceImpl implements IGenTableService {

    private final GenTableMapper baseMapper;
    private final GenTableDao genTableDao;
    private final GenTableColumnMapper genTableColumnMapper;
    private final GenTableColumnDao genTableColumnDao;

    /**
     * 查询业务信息
     *
     * @param id 业务ID
     * @return 业务信息
     */
    @Override
    public GenTable selectGenTableById(Long id) {
        GenTable genTable = baseMapper.selectByPrimaryKey(id);
//        setTableFromOptions(genTable);
        return genTable;
    }

    @Override
    public Page<GenTable> selectPageGenTableList(GenTable genTable, PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNum(),pageQuery.getPageSize());
        List<GenTable> genTables = baseMapper.selectByExample(buildGenTableQueryExample(genTable));
        return Page.restPage(genTables);
    }

    private GenTableExample buildGenTableQueryExample(GenTable genTable) {
        GenTableExample example = new GenTableExample();
        GenTableExample.Criteria criteria = example.createCriteria();
        if(StrUtil.isNotEmpty(genTable.getTableName())) criteria.andTable_nameLike(genTable.getTableName());
        if(StrUtil.isNotEmpty(genTable.getTableComment())) criteria.andTable_commentLike(genTable.getTableComment());
        return example;
    }


    @Override
    public Page<GenTable> selectPageDbTableList(GenTable genTable, PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPageNum(),pageQuery.getPageSize());
        List<GenTable> page = genTableDao.selectPageDbTableList(genTable);
        return Page.restPage(page);
    }

    /**
     * 查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */
    @Override
    public List<GenTable> selectDbTableListByNames(String[] tableNames) {
        return genTableDao.selectDbTableListByNames(tableNames);
    }

    /**
     * 查询所有表信息
     *
     * @return 表信息集合
     */
    @Override
    public List<GenTable> selectGenTableAll() {
        return genTableDao.selectGenTableAll();
    }

    /**
     * 修改业务
     *
     * @param genTable 业务信息
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateGenTable(GenTable genTable) {
        String options = JSON.toJSONString(genTable.getParams());
        genTable.setOptions(options);
        int row = baseMapper.updateByPrimaryKey(genTable);
        if (row > 0) {
            for (GenTableColumn cenTableColumn : genTable.getColumns()) {
//                genTableColumnMapper.updateById(cenTableColumn);
            }
        }
    }

    /**
     * 删除业务对象
     *
     * @param tableIds 需要删除的数据ID
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteGenTableByIds(Long[] tableIds) {
        List<Long> ids = Arrays.asList(tableIds);
        GenTableExample example = new GenTableExample();
        example.createCriteria().andTable_idIn(ids);
        baseMapper.deleteByExample(example);
        GenTableColumnExample genTableColumnExample = new GenTableColumnExample();
        genTableColumnExample.createCriteria().andTable_idIn(ids);
        genTableColumnMapper.deleteByExample(genTableColumnExample);
    }

    /**
     * 导入表结构
     *
     * @param tableList 导入表列表
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importGenTable(List<GenTable> tableList) {
        String operName = "测试";
        try {
            for (GenTable table : tableList) {
                String tableName = table.getTableName();
                GenUtils.initTable(table, operName);
                int row = baseMapper.insert(table);
                if (row > 0) {
                    // 保存列信息
                    List<GenTableColumn> genTableColumns = genTableColumnDao.selectDbTableColumnsByName(tableName);
                    List<GenTableColumn> saveColumns = new ArrayList<>();
                    for (GenTableColumn column : genTableColumns) {
                        GenUtils.initColumnField(column, table);
                        saveColumns.add(column);
                        genTableColumnDao.insertGenTableColumn(column);
                    }
                    // TODO:待完善批量导入
//                    if (CollUtil.isNotEmpty(saveColumns)) {
//                        genTableColumnDao.insertGenTableColumn(saveColumns);
//                    }
                }
            }
        } catch (Exception e) {
            throw new ServiceException("导入失败：" + e.getMessage());
        }
    }

    /**
     * 预览代码
     *
     * @param tableId 表编号
     * @return 预览数据列表
     */
    @Override
    public Map<String, String> previewCode(Long tableId) {
        Map<String, String> dataMap = new LinkedHashMap<>();
        // 查询表信息
        GenTable table = genTableDao.selectGenTableById(tableId);
        List<GenTable> genTables = genTableDao.selectDbTableListByNames(new String[]{"cms_help"});
        table = genTables.get(0);
        List<GenTableColumn> cmsHelp = genTableColumnDao.selectDbTableColumnsByName("cms_help");
        table.setTplCategory(GenConstants.TPL_CRUD);
        table.setPackageName("com.mall");
        table.setColumns(cmsHelp);
        // 设置主子表信息
        setSubTable(table);
        // 设置主键列信息
        setPkColumn(table);
        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        for (String template : templates)
        {
            if("vm/xml/mapper.xml.vm".equals(template)) {
                // 渲染模板
                StringWriter sw = new StringWriter();
                Template tpl = Velocity.getTemplate(template, "UTF-8");
                tpl.merge(context, sw);
                dataMap.put(template, sw.toString());
            }
        }
        return dataMap;
    }

    /**
     * 生成代码（下载方式）
     *
     * @param tableName 表名称
     * @return 数据
     */
    @Override
    public byte[] downloadCode(String tableName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        generatorCode(tableName, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 生成代码（自定义路径）
     *
     * @param tableName 表名称
     */
    @Override
    public void generatorCode(String tableName) {
        GeneratorConfig generatorConfig = new GeneratorConfig();
        DatabaseConfig databaseConfig = new DatabaseConfig();
        generatorConfig.setTableName("gen_table_column"); //表名
        generatorConfig.setDomainObjectName("GenTableColumn"); //表实体类名
        generatorConfig.setProjectFolder("D:/test"); //项目根目录
        generatorConfig.setModelPackage("com.mall.gen.domain"); //实体类包名
        generatorConfig.setGenerateKeys(null); //主键
        generatorConfig.setModelPackageTargetFolder("src/main/java"); //实体类存放目录
        generatorConfig.setDaoPackage("com.mall.gen.dao"); //Mapper接口包名
        generatorConfig.setDaoTargetFolder("src/main/java"); //Mapper接口存放目录
        generatorConfig.setMapperName(null); //Mapper接口名
        generatorConfig.setMappingXMLPackage("com.test"); //xml映射文件包名
        generatorConfig.setMappingXMLTargetFolder("src/main/resources"); //xml映射文件存放目录
        generatorConfig.setOffsetLimit(true); //limit分页
        generatorConfig.setComment(true); //注释
        generatorConfig.setOverrideXML(true); //覆盖xml文件
        generatorConfig.setNeedToStringHashcodeEquals(true); //toString方法
        generatorConfig.setUseLombokPlugin(true); //lombok插件
        generatorConfig.setUseTableNameAlias(false); //字段别名使用表名
        generatorConfig.setNeedForUpdate(true);
        generatorConfig.setAnnotationDAO(true); //dao注解
        generatorConfig.setAnnotation(true); //JPA注解
        generatorConfig.setUseActualColumnNames(false); //实际列名（默认驼峰，开启则使用实际列名）
        generatorConfig.setEncoding("UTF-8");
        generatorConfig.setUseExample(true); //生成Example类
        generatorConfig.setUseDAOExtendStyle(true);
        generatorConfig.setUseSchemaPrefix(false); //Schema前缀
        generatorConfig.setJsr310Support(true);//日期时间
        databaseConfig.setName("测试");
        databaseConfig.setDbType("MySQL");
        databaseConfig.setHost("localhost");
        databaseConfig.setPort("3306");
        databaseConfig.setUsername("root");
        databaseConfig.setPassword("root");
        databaseConfig.setSchema("mall");
        databaseConfig.setEncoding("UTF-8");
        List<IgnoredColumn> ignoredColumns = new ArrayList<>();
        List<ColumnOverride> columnOverrides = new ArrayList<>();
        if (!checkDirs(generatorConfig)) {
            return;
        }
        MybatisGeneratorBridge bridge = new MybatisGeneratorBridge();
        bridge.setGeneratorConfig(generatorConfig);
        bridge.setDatabaseConfig(databaseConfig);
        bridge.setIgnoredColumns(ignoredColumns);
        bridge.setColumnOverrides(columnOverrides);
        try {
            bridge.generate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkDirs(GeneratorConfig config) {
        List<String> dirs = new ArrayList<>();
        dirs.add(config.getProjectFolder());
        dirs.add(config.getProjectFolder().concat("/").concat(config.getModelPackageTargetFolder()));
        dirs.add(config.getProjectFolder().concat("/").concat(config.getDaoTargetFolder()));
        dirs.add(config.getProjectFolder().concat("/").concat(config.getMappingXMLTargetFolder()));
        boolean haveNotExistFolder = false;
        for (String dir : dirs) {
            File file = new File(dir);
            if (!file.exists()) {
                haveNotExistFolder = true;
            }
        }
        if (haveNotExistFolder) {

            for (String dir : dirs) {
                try {
                    FileUtils.forceMkdir(new File(dir));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        return true;
    }

    /**
     * 查询表信息并生成代码
     */
    private void generatorCode(String tableName, ZipOutputStream zip) {
        // 查询表信息
        GenTable table = genTableDao.selectGenTableByName(tableName);
        List<GenTable> genTables = genTableDao.selectDbTableListByNames(new String[]{"cms_help"});
        table = genTables.get(0);
        GenUtils.initTable(table, "测试");
        List<GenTableColumn> cmsHelp = genTableColumnDao.selectDbTableColumnsByName("cms_help");
        for (GenTableColumn column : cmsHelp) {
            GenUtils.initColumnField(column, table);
        }
        table.setTplCategory(GenConstants.TPL_SUB);
        table.setPackageName("com.mall");
        table.setColumns(cmsHelp);
        Snowflake snowflake = IdUtil.getSnowflake();
        List<Long> menuIds = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            menuIds.add(snowflake.nextId());
        }
        table.setMenuIds(menuIds);
        // 设置主子表信息
        table.setSubTableName("cms_help_category");
        setSubTable(table);
        // 设置主键列信息
        setPkColumn(table);

        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        for (String template : templates) {
//            if(!"vm/xml/mapper.xml.vm".equals(template)) continue;
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                // 添加到zip
                zip.putNextEntry(new ZipEntry(VelocityUtils.getFileName(template, table)));
                IoUtil.write(zip, StandardCharsets.UTF_8, false, sw.toString());
                IoUtil.close(sw);
                zip.flush();
                zip.closeEntry();
            } catch (IOException e) {
                log.error("渲染模板失败，表名：" + table.getTableName(), e);
            }
        }
    }

    /**
     * 同步数据库
     *
     * @param tableName 表名称
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void synchDb(String tableName) {

    }

    /**
     * 批量生成代码（下载方式）
     *
     * @param tableNames 表数组
     * @return 数据
     */
    @Override
    public byte[] downloadCode(String[] tableNames) {
        return null;
    }

    /**
     * 修改保存参数校验
     *
     * @param genTable 业务信息
     */
    @Override
    public void validateEdit(GenTable genTable) {
        baseMapper.updateByPrimaryKeySelective(genTable);
    }
    /**
     * 设置主键列信息
     *
     * @param table 业务表信息
     */
    public void setPkColumn(GenTable table) {
        for (GenTableColumn column : table.getColumns()) {
            if (column.isPk()) {
                table.setPkColumn(column);
                break;
            }
        }
        if (ObjectUtil.isNull(table.getPkColumn())) {
            table.setPkColumn(table.getColumns().get(0));
        }
        if (GenConstants.TPL_SUB.equals(table.getTplCategory())) {
            for (GenTableColumn column : table.getSubTable().getColumns()) {
                if (column.isPk()) {
                    table.getSubTable().setPkColumn(column);
                    break;
                }
            }
            if (ObjectUtil.isNull(table.getSubTable().getPkColumn())) {
                table.getSubTable().setPkColumn(table.getSubTable().getColumns().get(0));
            }
        }
    }

    /**
     * 设置主子表信息
     *
     * @param table 业务表信息
     */
    public void setSubTable(GenTable table) {
        String subTableName = table.getSubTableName();
        if (StrUtil.isNotEmpty(subTableName)) {
            table.setSubTable(genTableDao.selectGenTableByName(subTableName));
            GenTable genTable = genTableDao.selectDbTableListByNames(new String[]{"cms_help_category"}).get(0);
            GenUtils.initTable(genTable,"ccc");
            table.setSubTableFkName("id");
            table.setSubTableName("cms_help_category");
            table.setSubTable(genTable);
            List<GenTableColumn> genTableColumns = genTableColumnDao.selectDbTableColumnsByName(subTableName);
            List<GenTableColumn> saveColumns = new ArrayList<>();
            for (GenTableColumn column : genTableColumns) {
                GenUtils.initColumnField(column, genTable);
                saveColumns.add(column);
            }
            genTable.setColumns(saveColumns);
        }
    }
}
