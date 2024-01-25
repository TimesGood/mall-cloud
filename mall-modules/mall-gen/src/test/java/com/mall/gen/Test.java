package com.mall.gen;

import com.mall.gen.mbg.model.DatabaseConfig;
import com.mall.gen.mbg.model.GeneratorConfig;
import com.mall.gen.mbg.MybatisGeneratorBridge;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.mybatis.generator.config.ColumnOverride;
import org.mybatis.generator.config.IgnoredColumn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
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
    static boolean checkDirs(GeneratorConfig config) {
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
}
