package com.mall.gen.controller;

import com.mall.core.domain.Page;
import com.mall.core.domain.R;
import com.mall.gen.domain.GenTable;
import com.mall.gen.domain.GenTableColumn;
import com.mall.gen.service.IGenTableColumnService;
import com.mall.gen.service.IGenTableService;
import com.mall.mybatis.page.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/gen_table")
public class GenTableController {
    @Autowired
    IGenTableService genTableService;

    @Autowired
    IGenTableColumnService genTableColumnService;

    /**
     * 查询代码生成列表
     */
    @GetMapping("/list")
    @ResponseBody
    public Page<GenTable> genList(GenTable genTable, PageQuery pageQuery) {
        return genTableService.selectPageGenTableList(genTable, pageQuery);
    }

    /**
     * 查询数据库列表
     */
    @GetMapping("/db/list")
    @ResponseBody
    public Page<GenTable> dataList(GenTable genTable, PageQuery pageQuery) {
        return genTableService.selectPageDbTableList(genTable, pageQuery);
    }

    @GetMapping(value = "/column/{tableId}")
    @ResponseBody
    public List<GenTableColumn> columnList(@PathVariable("tableId") Long tableId) {
        return genTableColumnService.selectGenTableColumnListByTableId(tableId);
    }

    /**
     * 生成代码

     */
    @GetMapping("/genCode/{tableId}")
    @ResponseBody
    public R<Void> genCode(@PathVariable("tableId") Long tableId) {
        genTableService.generatorCode("");
        return R.ok();
    }
}
