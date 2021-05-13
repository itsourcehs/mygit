package cn.itcast.demo13;

/**
 * @program: HelloWorld
 * @description: Runnable接口实现类
 * @author: Mr.Huang
 * @create: 2021-05-13 21:11
 **/

public class ThreadPoolRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 线程提交任务");
    }
}
