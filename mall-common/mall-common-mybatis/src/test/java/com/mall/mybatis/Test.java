package com.mall.mybatis;

import com.github.pagehelper.Page;
import com.mall.mybatis.domain.OrderItem;
import com.mall.mybatis.page.PageQuery;

public class Test {
    public static void main(String[] args) {
        PageQuery query = new PageQuery();
        Page<OrderItem> build = query.build();
        System.out.println(build);

    }
}
