package cn.itcast.demo13;

/**
 * @program: HelloWorld
 * @description: 创建Thread子类对象
 * 子类对象调用父类方法strat() - 让线程程序执行,JVM调用线程中的run()
 * @author: Mr.Huang
 * @create: 2021-05-12 21:14
 **/

public class ThreadDemo {
    public static void main(String[] args) {
        /*继承类方式的线程*/
        /*SubThread st = new SubThread();
        st.start();
        for(int i=0;i<50;i++){
            System.out.println("main..."+i);
        }

         */

        /*
         * 实现接口方式的线程
         * 创建Thread对象,构造方法中传递Runnable接口实现类对象
         * 调用Thread类方法start()
         */
        SubRunnable sr = new SubRunnable();
        Thread t= new Thread(sr);
        t.start();
    }
}
