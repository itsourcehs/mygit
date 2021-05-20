package cn.itcast.demo19;

import java.lang.reflect.Field;

/**
 * @program: HelloWorld
 * @description: 反射获取成员变量,并修改值
 * 使用 : Person类中的String name
 * @author: Mr.Huang
 * @create: 2021-05-18 20:56
 **/

public class ReflectDemo05 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.itcast.demo19.Person");
        Object obj = c.newInstance();

        /**
         * 获取成员变量 :
         *  Class类中的方法 Field[] getFields()
         *  class文件中的所有的公共的成员变量
         *  返回值: Field[] -- Field类是用来描述成员变量的类
         *  Field[] fields = c.getFields();
         */

        /**
         * 获取指定的公共的成员变量 String name
         * Class类中的方法 Field getField(传递字符串类型的变量名)
         * 获取指定的私有的成员变量 -- c.getDeclaredField()
         *
         * Field类的方法 void set(Object obj,Object value) -- 修改成员变量的值
         * Object obj: 必须有对象的支持
         * Object value: 修改后的值
         */
        Field field = c.getField("name"); //如果成员变量是私有的,则会抛NoSuch异常
        field.set(obj,"王五");
        System.out.println(obj); //Person [name=王五, age=0]

    }
}
