package com.mall.mybatis.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.mybatis.page.PageQuery;

/**
 * 分页工具类
 */
public class PageUtils extends PageHelper
{
    /**
     * 设置请求分页数据
     */
    public static void startPage()
    {
        Page<Object> page = new PageQuery().startPage();
        Integer pageNum = page.getPageNum();
        Integer pageSize = page.getPageSize();
        String orderBy = SqlUtil.escapeOrderBySql(page.getOrderBy());
        PageHelper.startPage(pageNum, 10, orderBy).setReasonable(true);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage()
    {
        PageHelper.clearPage();
    }
}
