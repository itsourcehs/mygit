package com.evan.wj.error;

import org.springframework.boot.web.server.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Classname ErrorConfig
 * @Description TODO
 * @Date 2021/6/30 10:50
 * @Created by 123456
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
        registry.addErrorPages(error404Page);
    }
}
