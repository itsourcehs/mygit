package cn.itcast.demo03;

public class TestEquals {
    public static void main(String[] args) {
        //Person
        Person p = new Person("李四",25);
        Person p1 = new Person("张三",20);
        //equals比较引用数据类型返回内存地址比较
        boolean b = p.equals(p1);
        //System.out.println(b);
        //调用toString
        Person p2 = new Person("张三",20);
        String s = p2.toString();
        //System.out.println(p2);
        //System.out.println(s);//Person{name='张三', age=20}

        String str = "itcast";//String类重写了toString
        System.out.println(str);


    }
}
