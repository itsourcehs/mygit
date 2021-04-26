package cn.itcast.demo5;

import java.math.BigDecimal;

/*
 * 计算浮点数四则运算,不会丢失精度
 * 必须传String 参数  BigDecimal(String)
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        fuc1();
    }

    public static void fuc(){
        // 加法
        BigDecimal b = new BigDecimal("0.09");
        BigDecimal b1 = new BigDecimal("0.01");
        BigDecimal res = b.add(b1);
        System.out.println(res);
    }

    /*
     * 除法
     * divide(BigDecimal divisor，int scale,int roundingMode)
     * int scale:保留几位小数
     * int roundingMode: 保留模式 参考API文档
     *   static int ROUND_UP
     */
    public static void fuc1(){
        BigDecimal b1 = new BigDecimal("1.301");
        BigDecimal b2 = new BigDecimal("100");
        BigDecimal res = b1.divide(b2,2,BigDecimal.ROUND_UP);
        System.out.println(res);

    }









}
