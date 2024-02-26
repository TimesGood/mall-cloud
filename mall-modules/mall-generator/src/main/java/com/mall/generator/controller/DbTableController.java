package com.mall.generator.controller;

import com.mall.core.domain.Page;
import com.mall.core.domain.R;
import com.mall.generator.domain.DbTable;
import com.mall.generator.service.DbTableService;
import com.mall.mybatis.page.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dbTable")
public class DbTableController {
    @Autowired
    DbTableService dbTableService;


    /**
     * 查询数据库列表
     */
    @GetMapping("/list")
    @ResponseBody
    public Page<DbTable> dataList(DbTable dbTable, PageQuery pageQuery) {
        return dbTableService.selectPageDbTableList(dbTable, pageQuery);
    }

    /**
     * 生成代码

     */
    @GetMapping("/genCode/{tableName}")
    @ResponseBody
    public R<Void> genCode(@PathVariable("tableName") String tableName) {
        dbTableService.generatorCode(tableName);
        return R.ok();
    }
}
