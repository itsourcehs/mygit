package cn.itcast.demo13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: HelloWorld
 * @description: 实现线程的第三个方式
 * 实现步骤:
 *  使用工厂类 Executors中的静态方法创建线程对象,指定线程的个数
 *  返回的是 ExecutorService接口的实现类(线程池对象),调用方法submit提交线程任务
 *  submit(Callable c)
 * @author: Mr.Huang
 * @create: 2021-05-13 21:26
 **/

public class ThreadPoolCallableDemo {
    public static void main(String[] args) throws Exception {
        // 1.调用工厂类方法,创建线程池对象(接口类型)
        ExecutorService es = Executors.newFixedThreadPool(2);

        // 2.提交线程任务的方法submit方法返回Future接口的实现类
        Future<String> f = es.submit(new ThreadPoolCallable());

        //
        String s = f.get();
        System.out.println(s);
    }
}
