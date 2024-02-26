package com.mall.generator.mbg.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * 追加行锁MySql for update 行锁条件查询
 */
public class MySQLForUpdatePlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * 生成example时追加内容
     */
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        PrimitiveTypeWrapper booleanWrapper = FullyQualifiedJavaType.getBooleanPrimitiveInstance().getPrimitiveTypeWrapper();
        Field forUpdate = new Field("forUpdate",booleanWrapper);
        forUpdate.setVisibility(JavaVisibility.PRIVATE);
        forUpdate.setType(booleanWrapper);
        topLevelClass.addField(forUpdate);

        Method setForUpdate = new Method("setForUpdate");
        setForUpdate.setVisibility(JavaVisibility.PUBLIC);
        setForUpdate.addParameter(new Parameter(booleanWrapper, "forUpdate"));
        setForUpdate.addBodyLine("this.forUpdate = forUpdate;");
        topLevelClass.addMethod(setForUpdate);

        Method getForUpdate = new Method("getForUpdate");
        getForUpdate.setVisibility(JavaVisibility.PUBLIC);
        getForUpdate.setReturnType(booleanWrapper);
        getForUpdate.addBodyLine("return forUpdate;");
        topLevelClass.addMethod(getForUpdate);

        return true;
    }

    /**
     * mapper中追加sql语句
     */
    private void appendForUpdate(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement forUpdateElement = new XmlElement("if");
        forUpdateElement.addAttribute(new Attribute("test", "forUpdate != null and forUpdate == true"));
        forUpdateElement.addElement(new TextElement("for update"));
        element.addElement(forUpdateElement);
    }


    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        appendForUpdate(element, introspectedTable);
        return true;
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        appendForUpdate(element, introspectedTable);
        return true;
    }
}
