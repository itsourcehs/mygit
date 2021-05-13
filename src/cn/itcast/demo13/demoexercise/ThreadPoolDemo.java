package cn.itcast.demo13.demoexercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: HelloWorld
 * @description: 使用线程池技术实现求和
 * 两个线程 1个线程计算1+100 1+200
 * 多线程的异步计算
 * @author: Mr.Huang
 * @create: 2021-05-13 21:44
 **/

public class ThreadPoolDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> f = es.submit(new getSumCallable(100));
        Future<Integer> f1 = es.submit(new getSumCallable(200));

        System.out.println(f.get());
        System.out.println(f1.get());

        es.shutdown();

    }

}
