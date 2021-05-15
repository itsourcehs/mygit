package cn.itcast.demo14.ThreadWaitNotify;

/**
 * @program: HelloWorld
 * @description: 实现线程等待与唤醒案例:
 * 定义资源类,有两个成员变量 name,sex
 * 同时有两个线程,对资源中的变量操作  1个线程对name,sex赋值  1个线程对name,sex输出打印
 * @author: Mr.Huang
 * @create: 2021-05-14 22:08
 **/

public class Resource {
    public String name;
    public String sex;
    public boolean flag = false;

}
