package cn.itcast.demo13;

/**
 * @program: HelloWorld
 * @description: 实现Runnable接口开启线程
 * 重写run()
 * @author: Mr.Huang
 * @create: 2021-05-13 08:37
 **/

public class SubRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println("run..."+i);
        }
    }
}
