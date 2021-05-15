package cn.itcast.demo14.deadLockDemo;

/**
 * @program: HelloWorld
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-14 21:45
 **/

public class LockB {

    private LockB(){}

    public static final LockB lockb = new LockB();
}
