package cn.itcast.demo5;

import java.math.BigInteger;

public class BigIntegerDemo {
    public static void main(String[] args) {
        fuc_1();
    }

    /*
     * BigInteger类的构造方法
     */
    public static void fuc(){
        BigInteger b = new BigInteger("233121412414144141441214");
        System.out.println(b);
        BigInteger b1 = new BigInteger("233121412414144141441214");
        System.out.println(b1);
    }

    /*
     * Bigintger对象的四则运算
     */
    public static void fuc_1(){
        BigInteger b = new BigInteger("233121412414144141441214");
//        System.out.println(b);
        BigInteger b1 = new BigInteger("233121412414144141441214");
//        System.out.println(b1);
        BigInteger res = b.add(b1);
        System.out.println(res);
    }


}
