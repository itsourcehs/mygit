package com.evan.wj.result;

import lombok.Data;

/**
 * @Classname Result
 * @Description TODO
 * @Date 2021/6/29 15:53
 * @Created by 123456
 */

@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
}
