package com.mall.generator.controller;

import com.mall.generator.domain.DbTableColumn;
import com.mall.generator.service.DbTableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dbTableColumn")
public class DbTableColumnController {
    @Autowired
    DbTableColumnService dbTableColumnService;

    @GetMapping(value = "/{tableName}")
    @ResponseBody
    public List<DbTableColumn> columnList(@PathVariable("tableName") String tableName) {
        return dbTableColumnService.selectDbTableColumnsByName(tableName);
    }

}
