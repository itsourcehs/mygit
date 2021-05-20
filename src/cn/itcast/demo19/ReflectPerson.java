package cn.itcast.demo19;

import java.lang.reflect.Constructor;

/**
 * @program: HelloWorld
 * @description: 反射Person类获取空参构造器并使用
 * 运行构造器方法,创建对象
 *  1.获取class文件对象
 *  2.从class文件对象中,获取需要的成员
 *
 * Constructor - --描述构造方法对象类
 * @author: Mr.Huang
 * @create: 2021-05-18 09:08
 **/

public class ReflectPerson {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.itcast.demo19.Person");
        //1.使用class文件对象获取类中的构造方法
        /**
         * Constructor[] getConstructor --- 获取class文件对象中的所有public构造器
         */

        /**
         * 获取指定的构造方法,空参的构造方法
         * Constructor getConstructor()
         */
        Constructor con = c.getConstructor();
        /**运行空参构造方法,
         * Constructor类方法 newInstance() --- 返回一个Object类型的
         *
         */
        Object obj = con.newInstance();
        System.out.println(obj.toString());
        Person p = (Person) obj;
        p.eat();

    }
}
