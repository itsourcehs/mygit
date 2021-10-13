package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Classname MyBatisConfig
 * @Description MyBatis相关配置
 * @Date 2021/10/13 18:14
 * @Created by 123456
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.example.demo.mbg.mapper"})
public class MyBatisConfig {
}
