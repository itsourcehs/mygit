package com.evan.wj.result;

/**
 * @Classname ResultCode
 * @Description TODO
 * @Date 2021/7/5 18:04
 * @Created by 123456
 */
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);
    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
