package cn.itcast.demo14.deadLockDemo;

/**
 * @program: HelloWorld
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-14 21:46
 **/

public class deadLockTest {
    public static void main(String[] args) {
        //Runnable接口实现类对象作为参数传入Thread
        deadLock dead = new deadLock();

        Thread t0 = new Thread(dead);
        Thread t1 = new Thread(dead);

        //开启线程
        t0.start();t1.start();


    }
}
/**
 * 运行结果解释:
 * if...locka
 * if...lockb
 * else...lockb
 * if...locka
 *
 * 1.A同步 -- --  B同步
 * 2.B同步 -- --  A同步
 *
 * 先进入1的A同步,再进入1的B同步,,,2的B同步抢到锁,期望将进入2的A同步
 * 但是却被1的A同步抢了导致死锁
 */
