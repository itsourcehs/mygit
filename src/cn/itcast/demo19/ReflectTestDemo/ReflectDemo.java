package cn.itcast.demo19.ReflectTestDemo;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @program: HelloWorld
 * @description: 定义集合类,泛型String,要求向集合中添加Integer类型
 * 反射方式,获取出集合ArrayList类的class文件对象
 * 通过class文件对象,调用add方法
 *
 * 对反射调用方法是否理解
 * @author: Mr.Huang
 * @create: 2021-05-18 21:48
 **/

public class ReflectDemo {
    public static void main(String[] args) throws Exception{
        ArrayList<String> array = new ArrayList<String>();
        array.add("a");

        /**
         * 通过反射方式,获取集合ArrayList类的class文件对象
         */
        Class c = array.getClass();

        /**
         * 获取ArrayList.class文件中的方法add
         * 使用invoke运行获取到的方法
         */
        Method method = c.getMethod("add",Object.class);
        method.invoke(array,150);
        method.invoke(array,1500);
        method.invoke(array,15000);
        System.out.println(array); //[a, 150, 1500, 15000] 无法使用增强for和迭代器遍历

        for(Object arr : array){
            System.out.println(arr);
        }
    }
}
