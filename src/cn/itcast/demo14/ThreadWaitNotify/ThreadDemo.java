package cn.itcast.demo14.ThreadWaitNotify;

/**
 * @program: HelloWorld
 * @description: 开启2个线程
 * @author: Mr.Huang
 * @create: 2021-05-14 22:22
 **/

public class ThreadDemo {
    public static void main(String[] args) {
        Resource r = new Resource();
        Input in = new Input(r);
        Output out = new Output(r);

        Thread tin = new Thread(in);
        Thread tout = new Thread(out);

        tin.start();tout.start();
    }
}
