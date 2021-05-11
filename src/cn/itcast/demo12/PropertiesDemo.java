package cn.itcast.demo12;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @program: 集合对象Properties类, 继承Hashtable, 实现Map接口
 * @description: 可以和io对象结合使用,实现数据的持久存储
 * @author: Mr.Huang
 * @create: 2021-05-11 08:35
 **/

public class PropertiesDemo {
    public static void main(String[] args) {
        fuc1();
    }
    
    /**
     * @Description: 使用Properties集合,存储键值对
     * @Param: setProperty方法等同于Map接口中的put  setProperty(String key,String value)
     * @return: 通过键获取值, getProperty(String key)
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc1(){
        // 1.Properties集合对象,不能使用泛型
        Properties pro = new Properties();
        // 2.必须存储String类型的键和String类型的值,键对象必须重写hashCode和equals(String对象已重写)
        pro.setProperty("a","1");
        pro.setProperty("b","2");
        pro.setProperty("c","3");
        System.out.println(pro);

        // 3.通过键获取值
        System.out.println(pro.getProperty("c"));

        // 3.1方法stringPropertyNames,将集合中的键存储到Set集合,类似于Map接口的方法keySet
        Set<String> sets = pro.stringPropertyNames();
        for(String key : sets){
            System.out.println(key+"..."+pro.getProperty(key));
        }
    }

    /**
     * @Description: Properties集合特有方法load - 流对象读取文件中的键值对,保存到集合
     * 读取的文件必须以properties为后缀,里面的内容像 name=123,不能有空格 注释为前面加上#
     * @Param: load(InputStream in)  load(Reader r) 传递任意的字节或字符输入流
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc2() throws IOException{
        Properties pro = new Properties();
        FileReader fr = new FileReader("c:\\pro.properties");
        // 1.调用集合的方法load,传递字符输入流
        pro.load(fr);
        fr.close();
        System.out.println(pro);
    }

    /**
     * @Description: Properties集合特有方法store - 接受所有的字节或者字符的输出流,将集合值的键值对,写回文件保存
     * @Param: store(OutputStream out) store(Writer w)
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void fuc3() throws IOException{
        Properties pro = new Properties();
        pro.setProperty("name","zhangsan");
        pro.setProperty("age","31");
        pro.setProperty("email","10213@qq.com");

        // 创建流对象,作数据源
        FileWriter fw = new FileWriter("c:\\pro.properties");

        pro.store(fw,"");
        fw.close();

    }
}
