package cn.itcast.demo13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: HelloWorld
 * @description: 线程池
 * JDK 1.5新特性,实现线程池程序
 *  使用工厂类 Executors中的静态方法创建线程对象,指定线程的个数
 *      static ExecutorService newFixedThreadPool(int 个数)返回线程池对象
 *      返回的是 ExecutorService接口的实现类(线程池对象)
 *
 *      接口实现类对象,调用方法Submit(Runnable r)提交线程执行任务
 * @author: Mr.Huang
 * @create: 2021-05-13 21:01
 **/

public class ThreadPoolDemo {
    public static void main(String[] args) {

        // 1.调用工厂类方法,创建线程池对象(接口类型)
        ExecutorService es = Executors.newFixedThreadPool(2);

        // 2.调用线程池对象es中的方法submit提交线程任务,传递参数为Runnable接口实现类对象
        es.submit(new ThreadPoolRunnable());
        es.submit(new ThreadPoolRunnable());
        es.submit(new ThreadPoolRunnable());

    }
}
