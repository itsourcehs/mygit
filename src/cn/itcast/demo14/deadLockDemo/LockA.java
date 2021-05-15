package cn.itcast.demo14.deadLockDemo;

/**
 * @program: HelloWorld
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-14 21:45
 **/

public class LockA {
    private LockA(){}

    public static final LockA locka = new LockA();
}
