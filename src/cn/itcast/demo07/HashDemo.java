package cn.itcast.demo07;
/*
 * 对象的哈希值,实际就是十进制整数
 * 父类Object 方法；public int hashCode()
 */
public class HashDemo {
    public static void main(String[] args) {
        Person p = new Person();
        int i = p.hashCode();
        System.out.println(i);
    }
}
