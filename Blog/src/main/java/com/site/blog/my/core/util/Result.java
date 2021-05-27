package com.site.blog.my.core.util;

import java.io.Serializable;

/**
 * @program: Blog
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-26 20:16
 **/

public class Result<T> implements Serializable {
    /**实现序列化接口,自定义序列号*/
    private static final long serialVersionUID = 1L;
    /**响应码*/
    private int resultCode;
    /**响应信息*/
    private String message;
    private T data;

    public Result(){

    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
