package com.evan.wj.utils;

import java.util.Random;

/**
 * @Classname StringUtils
 * @Description TODO
 * @Date 2021/7/5 15:46
 * @Created by 123456
 */
public class StringUtils {
    public static String getRandomString(int length){
        String base = "abcdefghigklmno" +
                "pqrstuvwxyz" +
                "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            int num = random.nextInt(base.length());
            sb.append(base.charAt(num));
        }
        return sb.toString();
    }
}
