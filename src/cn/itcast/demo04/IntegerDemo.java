package cn.itcast.demo04;

public class IntegerDemo {
    public static void main(String[] args) {
        //fuc();
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);
        //fucti();

        // 数据在byte(-128~127)范围内,jvm不会new新对象
        Integer aa = 127; // Integer aa = new Integer(127)
        Integer bb = 127; // Integer bb = aa;
        System.out.println(aa == bb);//true
        System.out.println(aa.equals(bb));//true
    }
    /*
     * 静态方法parseInt中，参数字符串必须是数字格式
     */
    public static void fuc(){
        int i = Integer.parseInt("12");
        System.out.println(i/2);
    }

    /*
     * parseInt(String s, int radix)
     * radix 表示进制数(2，8，10，16)
     */
    public static void fuc_1(){
        int i = Integer.parseInt("110",2);
        System.out.println(i);
    }

    /*
     * 构造方法 Integer
     * Integer(String s)
     */
    public static void fuc_2(){
        Integer in = new Integer("100");
        //intValue 返回 int
        int i = in.intValue();
        System.out.println(i--);
    }

    /*
     * jdk 1.5及以后特性
     * 自动装箱 基本类型转为对象
     * Integer in = 1; == Integer in = new Integer();
     * 打印引用类型数据,必调用toString 方法
     * 自动拆箱 将引用类型数据转回基本数据类型,方便计算
     * in = in + 1;
     *
     * 自动装箱 自动拆箱 可能出现空指针异常
     * 数据在byte(-128~127)范围内,jvm不会new新对象
     */
    public static void fucti(){
        Integer in = 1;
        System.out.println(in.toString());
        in = in +1;
        System.out.println(in); //2
    }






}
