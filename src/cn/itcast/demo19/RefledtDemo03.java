package cn.itcast.demo19;

/**
 * @program: HelloWorld
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-18 20:02
 **/

/**
 * protected -- 子类专用
 * public -- 公共可用
 * private -- 私有的
 * default -- 只能本包内可用
 */


public class RefledtDemo03 {
    public static void main(String[] args) throws Exception{
        /**
         * 反射获取构造方法并运行的快捷方式
         * 两个前提: 1.必须具有空参构造方法 2.必须(构造方法权限)public
         */
        Class c = Class.forName("cn.itcast.demo19.Person");
        /**Class类中方法: T newInstance()
         * 直接创建被反射类的对象实例
         */
        Object obj = c.newInstance();
        System.out.println(obj);
    }
}
