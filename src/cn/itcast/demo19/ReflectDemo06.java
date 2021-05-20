package cn.itcast.demo19;

import java.lang.reflect.Method;

/**
 * @program: HelloWorld
 * @description: 反射获取成员方法并运行
 * public void eat()
 * @author: Mr.Huang
 * @create: 2021-05-18 21:15
 **/

public class ReflectDemo06 {
    public static void main(String[] args) throws Exception{
        Class c = Class.forName("cn.itcast.demo19.Person");
        Object obj = c.newInstance();
        /**
         * 获取class对象中的成员方法
         * Method[] getMethods() -- 获得的是class文件中的所有的公共的成员方法,包括从其父类继承过来的方法
         * Method类是用来描述成员方法的对象
         *         Method[] methods = c.getMethods();
         *         for(Method method : methods){
         *             System.out.println(method); //将会打印出从父类Object类继承过来的方法
         *         }
         */

        /**
         * 获取指定的空参方法eat()运行
         * Method getMethod(String methodName,Class...c)
         * String methodName:字符串类型的方法名
         * Class...c:方法的参数列表
         *
         * 运行:
         *  Method类中方法: Object invoke(Object obj,Object...o)
         *  Object obj:实例对象
         *  Object...o:获取到的那个方法的返回类型
         *
         * public void eat():
         * Method method = c.getMethod("eat");
         * method.invoke(obj);
         */

        /**
         * 获取指定的有参方法sleep()运行
         *
         */
        Method method = c.getMethod("sleep", String.class, int.class, double.class);
        method.invoke(obj,"休眠",100,234.5);

    }
}
