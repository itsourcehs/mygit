package cn.itcast.demo14.deadLockDemo;

/**
 * @program: HelloWorld
 * @description: 实现死锁现象  A,B同步   B,A同步
 * @author: Mr.Huang
 * @create: 2021-05-14 21:45
 **/

public class deadLock  implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        while (true){
            if(i%2 == 0){
                //先进入A同步,再进入B同步
               synchronized (LockA.locka){
                   System.out.println("if...locka");
                   synchronized (LockB.lockb){
                       System.out.println("if...lockb");
                   }
               }
            }else {
                //先进入B同步,再进入A同步
                synchronized (LockB.lockb){
                    System.out.println("else...lockb");
                    synchronized (LockA.locka){
                        System.out.println("else...locka");
                    }
                }
            }
            i++;
        }
    }
}
