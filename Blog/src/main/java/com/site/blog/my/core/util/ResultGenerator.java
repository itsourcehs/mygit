package com.site.blog.my.core.util;

import org.springframework.util.StringUtils;

/**
 * @program: Blog
 * @description: 响应结果生成类
 * @author: Mr.Huang
 * @create: 2021-05-26 20:19
 **/

public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public static Result result = new Result();

    /**
     * @Description: 响应成功返回 200
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/26
     */
    public static Result genSuccessResult(){

        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    /**
     * @Description: 响应成功方法重载
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/26
     */
    public static Result genSuccessResult(String message){

        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(message);
        return result;
    }

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/26
     */
    public static Result genSuccessResult(Object data){

        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    /**
     * @Description: 响应失败返回 500
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/26
     */
    public static Result genFailResult(String message){

        result.setResultCode(RESULT_CODE_SERVER_ERROR); //500
        if(StringUtils.isEmpty(message)){
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        }else {
            result.setMessage(message);
        }
        return result;
    }

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/26
     */
    public static Result genErrorResult(int code,String message){

        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }



}
