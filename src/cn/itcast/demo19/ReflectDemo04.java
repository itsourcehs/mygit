package cn.itcast.demo19;

import java.lang.reflect.Constructor;

/**
 * @program: HelloWorld
 * @description: 反射获取私有的构造方法并运行
 * 不推荐使用,破坏了程序的封装性,安全性
 * 暴力反射
 * @author: Mr.Huang
 * @create: 2021-05-18 20:30
 **/

public class ReflectDemo04 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.itcast.demo19.Person");

        /**
         * Constructor[] getDeclaredConstructors -- 获取所有的构造方法,包括私有的
         * Constructor[] cons = c.getDeclaredConstructors();
         * for(Constructor con : cons){
         *     System.out.println(con);
         * }
         */


        /**Constrcutor getDeclaredConstructor(Class...c)
         * 获取到指定参数列表的构造方法
         */
        Constructor con = c.getDeclaredConstructor(int.class,String.class);
        System.out.println(con); //private cn.itcast.demo19.Person(int,java.lang.String)


        /**
         * Constructor类的父类AccessibleObject,父类方法setAccessible(boolean b)
         */
        con.setAccessible(true);

        Object obj = con.newInstance(18,"lisi");
        System.out.println(obj);


    }
}
