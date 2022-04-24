package com.hs.utils;

import java.util.Random;

/**
 * @Description 生成指定长度随机字符串
 */
public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghigklmno" +
                "pqrstuvwxyz" +
                "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(base.length());
            sb.append(base.charAt(num));
        }
        return sb.toString();
    }
}
