package cn.itcast.demo14.ticketsFuctionDemo;

/**
 * @program: HelloWorld
 * @description: 通过线程休眠体现安全问题
 * 解决安全问题,java提供了同步技术
 * 公式: synchronized(任意对象){
 *     线程需要操作的共享!!数据
 * }
 *
 *
 * 采用同步方法的形式,解决线程的安全问题
 *  好处: 代码简洁
 *  将线程共享数据和同步,抽取到一个方法中
 *  在方法的声明加上同步关键字
 *
 *  注意: (非静态)同步方法的对象锁是: 本类对象引用 this
 *      (静态)同步方法的对象锁是: 本类自己.class属性 Tickets.class
 * @author: Mr.Huang
 * @create: 2021-05-13 22:49
 **/

public class Tickets implements Runnable {
    //定义票源
    private int ticket = 100;
    //private Object obj = new Object();

    @Override
    public void run() {
        while (true){
            payTicket();
        }
    }

    /**
     * @Description: 非静态同步方法
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/13
     */
    public synchronized void payTicket(){
        //线程共享数据
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
