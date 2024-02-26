package com.mall.generator.controller;

import com.mall.generator.domain.GeneratorConfig;
import com.mall.generator.service.GeneratorConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/generatorConfig")
public class GeneratorConfigController {
    @Autowired
    GeneratorConfigService generatorConfigService;

    @GetMapping(value = "/selectList")
    @ResponseBody
    public List<GeneratorConfig> selectList() {
        return generatorConfigService.selectList();
    }

}
