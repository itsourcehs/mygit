package cn.itcast.demo13;

/**
 * @program: HelloWorld
 * @description: Thread类的子类
 * 定义子类,继承Thread,重写run()
 * @author: Mr.Huang
 * @create: 2021-05-12 21:11
 **/

public class SubThread extends Thread {
    @Override
    public void run() {
        //super.run();
        for(int i=0;i<50;i++){
            System.out.println("run..."+i);
        }
    }
}
