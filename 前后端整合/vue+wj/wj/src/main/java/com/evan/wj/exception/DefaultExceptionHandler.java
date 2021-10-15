package com.evan.wj.exception;

import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname DefaultExceptionHandler
 * @Description TODO
 * @Date 2021/7/26 18:12
 * @Created by 123456
 */

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleAuthorizationException(UnauthorizedException e) {
        String message = "权限认证失败";
        return ResultFactory.buildFailResult(message);
    }
}
