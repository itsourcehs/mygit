package cn.itcast.demo12;

import java.io.*;

/**
 * @program: IO流对象, 实现对象Person序列化, 和反序列化
 * @description: ObjectOutputStream 写对象,实现序列化
 *  ObjectInputStream 读取对象,实现反序列化
 * @author: Mr.Huang
 * @create: 2021-05-11 22:00
 **/

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        writeObject();
        readObject();
    }

    /**
     * @Description: ObjectInputStream
     * 构造方法: ObjectInputStream(InputStream in)
     * 传递任意的字节输入流,输入封装文件,必须是序列化的文件
     * Object readObject() 读取对象
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void readObject() throws IOException,ClassNotFoundException{
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("c:\\person.txt");

        //创建反序列化流,构造方法中传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(fis);

        //调用反序列化流方法 readObject读取对象
        Object obj = ois.readObject();
        System.out.println(obj);
        ois.close();

    }

    /**
     * @Description: ObjectOutputStream
     * 构造方法: ObjectOutputStream(OutputStream out)
     * 传递任意的字节输出流, void writeObject(Object obj) --》 将对象写出到文件的方法,文件将会变成序列化文件
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/11
     */
    public static void writeObject() throws IOException {
        FileOutputStream fos = new FileOutputStream("c:\\person.txt");
        // 创建将对象写出到文件的序列化流对象,构造方法传入字节输出流
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Person p = new Person("lisi",25);

        //调用序列化流对象方法writeObject,写出对象到文件
        oos.writeObject(p);
        oos.close();
    }
}
