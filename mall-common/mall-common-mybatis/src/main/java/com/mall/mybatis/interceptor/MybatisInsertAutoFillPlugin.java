package com.mall.mybatis.interceptor;

import cn.hutool.core.util.ReflectUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Properties;

/**
 * 插入自动填充
 */
@Intercepts({
		@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
public class MybatisInsertAutoFillPlugin implements Interceptor {
	private String[] fields;

	private String[] values;

	private String[] expressions;

	@Override
	public Object plugin(Object target) {
		return Interceptor.super.plugin(target);
	}

	@Override
	public void setProperties(Properties properties) {
		this.fields = properties.stringPropertyNames().toArray(new String[0]);
		expressions = new String[fields.length];
		values = new String[fields.length];
		for (int i = 0; i < expressions.length; i++) {
			expressions[i] = properties.getProperty(fields[i]);
			values[i] = "?";
		}
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		SqlCommandType commandType = mappedStatement.getSqlCommandType();
		if (commandType == SqlCommandType.INSERT) {
			Object p = invocation.getArgs()[1];
			SpelExpressionParser parser = new SpelExpressionParser();
			for (int i = 0; i < this.fields.length; i++) {
				ReflectUtil.setFieldValue(p, this.fields[i], parser.parseExpression(this.expressions[i]).getValue());
			}
		}
		return invocation.proceed();
	}
}
