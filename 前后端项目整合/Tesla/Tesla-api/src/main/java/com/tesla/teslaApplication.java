package com.tesla;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 *
 */

@MapperScan("com.tesla.dao")
@SpringBootApplication
public class teslaApplication {
    public static void main(String[] args) {
        SpringApplication.run(teslaApplication.class,args);
    }
}
