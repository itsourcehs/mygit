/*
1.final 可修饰 类,成员方法,成员变量,局部变量
2.成员变量的赋值只能通过
    1. 定义的时候直接写等于值
    2. 采用构造器进行赋值
3.static 可修饰 成员方法,成员变量
    实现对象的数据共享 在变量前加入static
    name,age,shoolname(共享数据)
    静态方法中不能调用非静态变量,且静态方法中不能使用this和super
    静态方法(先人)优先于内存中,只能后人方法调用先人方法

    public static final double PI = 3.14; //静态常量
4.接口中的每个成员变量都默认使用public static final修饰,必须赋值
5.匿名对象 new Person(); new Person().方法名;
6.protected 只给同包下的子类调用,其他不同包类下调用直接方法名()
7.
    public 权限修饰符，公共访问, 类,方法,成员变量
    protected 权限修饰符，受保护访问, 方法,成员变量
    默认什么也不写 也是一种权限修饰符，默认访问, 类,方法,成员变量
    private 权限修饰符，私有访问, 方法,成员变量
    static 静态修饰符  方法,成员变量
    final 最终修饰符   类,方法,成员变量,局部变量
    abstract 抽象修饰符  类 ,方法

    abstract 不能与 private,static,final同用
*/
/*package Demo02;
public class FinalStatic {
    final int age;
    static String shoolName;//对象共享数据
    public FinalStatic(int age){
        this.age = age;
    }

}
 */

public class FinalStatic {
    /**
     *
     */
}