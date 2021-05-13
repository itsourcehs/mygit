package cn.itcast.demo14.ticketsFuctionDemo;

/**
 * @program: HelloWorld
 * @description: 通过线程休眠体现安全问题
 * 解决安全问题,java提供了同步技术
 * 公式: synchronized(任意对象){
 *     线程需要操作的共享!!数据
 * }
 * @author: Mr.Huang
 * @create: 2021-05-13 22:49
 **/

public class Tickets implements Runnable {
    //定义票源
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true){
            //线程共享数据
            synchronized (obj){
                //对票数判断,大于0可以出售
                if(ticket>0){
                    try{
                        Thread.sleep(10);
                    }catch (Exception ex){
                    }
                    System.out.println(Thread.currentThread().getName()
                            +" 出售第 "+ticket--);
                }
            }
        }
    }
}
