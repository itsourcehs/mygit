package cn.itcast.demo19;

/**
 * @program: HelloWorld
 * @description: 反射
 * 1.对象获取
 * 2.类名获取
 * 3.Class类的静态方法获取
 * == 在引用类型中是比较两个对象的内存地址
 * @author: Mr.Huang
 * @create: 2021-05-18 08:42
 **/

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException{
        //1.对象获取
        Person p = new Person();
        //调用Person类的父类方法getClass
        Class c = p.getClass();
        System.out.println(c);

        /**2.类名获取
         * 每个类型,包括基本和引用,都会赋予这个类型一个静态属性,属性名称class
         */
        Class c1 = Person.class;
        System.out.println(c1);
        System.out.println(c==c1);//true
        /**3.Class类的静态方法获取forName(字符串的类名)
         * 必须包名.类名
         */
        Class c2 = Class.forName("cn.itcast.demo19.Person");
        System.out.println(c2);
        System.out.println(c1==c2);//true
    }
}
