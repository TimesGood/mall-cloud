package com.mall.generator.controller;

import cn.hutool.core.io.IoUtil;
import com.mall.core.domain.Page;
import com.mall.generator.domain.GenTable;
import com.mall.generator.domain.GenTableColumn;
import com.mall.generator.service.IGenTableColumnService;
import com.mall.generator.service.IGenTableService;
import com.mall.generator.utils.VelocityInitializer;
import com.mall.mybatis.emnu.DataBaseType;
import com.mall.mybatis.page.PageQuery;
import com.mall.mybatis.utils.DataBaseHelper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    IGenTableService genTableService;
    @Autowired
    IGenTableColumnService genTableColumnService;

    @GetMapping("/testV")
    @ResponseBody
    public String testV(){
        DataBaseType dataBaseType = DataBaseHelper.getDataBaseType();
        // 渲染模板
        VelocityInitializer.initVelocity();
        StringWriter sw = new StringWriter();
        Template tpl = Velocity.getTemplate("vm/java/test.java.vm", "UTF-8");
        List<String> data = new ArrayList<>();
        data.add("test1");
        data.add("test2");
        data.add("test3");
        data.add("test4");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("columns", data);
        tpl.merge(velocityContext, sw);
        return sw.toString();
    }
    @GetMapping("/testA")
    @ResponseBody
    public Page<GenTable> testA(){
        PageQuery query = new PageQuery();
        query.setPageSize(20);
        return genTableService.selectPageDbTableList(new GenTable(),query);
    }

    @GetMapping("/testB")
    @ResponseBody
    public List<GenTable> testB(){
        return genTableService.selectDbTableListByNames(new String[]{"cms_help"});
    }

    @GetMapping("/testC")
    @ResponseBody
    public List<GenTableColumn> testC(){
        return genTableColumnService.selectDbTableColumnsByName("cms_help");
    }

    @GetMapping("/testTem")
    @ResponseBody
    public Map<String, String> testTem() {
        return genTableService.previewCode(1L);
    }
    @GetMapping("/downloadCode")
    public void downloadCode(HttpServletResponse response) {
        byte[] cmsHelps = genTableService.downloadCode("cms_help");
        try {
            genCode(response,cmsHelps);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 生成zip文件
     */
    private void genCode(HttpServletResponse response, byte[] data) throws IOException {
        response.reset();
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setHeader("Content-Disposition", "attachment; filename=\"ruoyi.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IoUtil.write(response.getOutputStream(), false, data);
    }

}
