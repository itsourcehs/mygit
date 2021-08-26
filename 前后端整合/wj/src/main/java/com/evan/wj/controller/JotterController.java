package com.evan.wj.controller;

import com.evan.wj.pojo.JotterArticle;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.JotterArticleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: wj
 * @description:
 * @author: Mr.Huang
 * @create: 2021-08-01 22:44
 **/

@Controller
public class JotterController {
    @Resource
    private JotterArticleService jotterArticleService;

    @PostMapping("/api/admin/content/article")
//    @ResponseBody
    public Result saveArticle(@RequestBody JotterArticle article){
        jotterArticleService.addOrUpdate(article);
        return ResultFactory.buildSuccessResult("保存成功");
    }

    @GetMapping("/api/article/{size}/{page}")
    public Page listArticles(@PathVariable("size") int size,@PathVariable("page") int page){
        return jotterArticleService.list(page-1,size);
    }
}
