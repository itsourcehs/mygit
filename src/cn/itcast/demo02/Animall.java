package cn.itcast.demo02;

public abstract class Animall {
    public abstract void eat();

    //要求:定义方法,返回值为Animal类型
    public static Animall getInstance(){
        return new Cat();
    }
}
