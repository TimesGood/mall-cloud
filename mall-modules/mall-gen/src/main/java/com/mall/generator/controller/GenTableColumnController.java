package com.mall.generator.controller;

import com.mall.generator.domain.GenTableColumn;
import com.mall.generator.service.IGenTableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gen_table_column")
public class GenTableColumnController {
    @Autowired
    IGenTableColumnService genTableColumnService;

    @GetMapping(value = "/{tableId}")
    @ResponseBody
    public List<GenTableColumn> columnList(@PathVariable("tableId") Long tableId) {
        return genTableColumnService.selectGenTableColumnListByTableId(tableId);
    }

}
