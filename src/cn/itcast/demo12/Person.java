package cn.itcast.demo12;

import java.io.Serializable;

/**
 * @program: HelloWorld
 * @description: 无
 * @author: Mr.Huang
 * @create: 2021-05-11 21:54
 **/

public class Person implements Serializable {
    public String name; //String 也有个序列号
    public /*transient瞬态关键字起到阻止成员变量序列化,这个关键字也只能修饰成员变量*/int age;

    //类自定义序列号,编译器不会计算序列号
    static final long serialVersionUID = 42L;

    public Person(){}

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
