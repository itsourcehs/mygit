package cn.itcast.demo01;
/*
构造方法 1.方法名需与类名一致 2.不要写 void
3.构造方法在new时自动运行 仅运行一次
4.空参调有参方法传实际参数,实现代码效率 this(实参1,实参2,..)
this()必须写在方法下第一行
 */
public class constructorDemo {
    String name;
    int age;
    public constructorDemo(){
        //String name = "张三";
        //int age = 18;
        this("张三",20);
    }
    public constructorDemo(String name,int age){
        this.name = name;
        this.age = age;
    }
}
