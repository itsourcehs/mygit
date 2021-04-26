package com.company;
/*
Random类学习  产生随机数
类型 变量 = new 类型();
变量.方法名();
 */

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args){
        Random ran = new Random();
        // Random 产生随机数的方法 nextInt()
        int i = ran.nextInt(100); // 产生一个0-99的随机int 数
        //System.out.println(i);
        // Random 产生浮点随机数的方法 nextDouble()
        double s = ran.nextDouble();
        System.out.println(s);
    }
}
