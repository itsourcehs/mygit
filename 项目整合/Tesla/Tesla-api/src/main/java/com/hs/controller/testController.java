package com.hs.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/test")
public class testController {

    private final static Logger logger = LoggerFactory.getLogger(testController.class);

    @RequestMapping("/log2")
    public String testLog2() {
        log.info("你好.");
        return "success";
    }


    @RequestMapping("/log")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.code.com";
        String str2 = "blog.baidu.net/";
        logger.info("======个人博客：{}；博客：{}", str1, str2);

        return "success";
    }
}
