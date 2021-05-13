package cn.itcast.demo13;

import java.util.concurrent.Callable;

/**
 * @program: HelloWorld
 * @description: Callable接口实现类,作为线程提交任务出现
 * 使用方法返回值
 * @author: Mr.Huang
 * @create: 2021-05-13 21:27
 **/

public class ThreadPoolCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "abc";
    }
}
