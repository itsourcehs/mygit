package cn.itcast.demo13.demoexercise;

import java.util.concurrent.Callable;

/**
 * @program: HelloWorld
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-13 21:46
 **/

public class getSumCallable implements Callable<Integer> {
    private int a;
    public getSumCallable(int a){
        this.a = a;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1;i<=a;i++){
            sum += i;
        }
        return sum;
    }
}
