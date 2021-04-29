package cn.itcast.demo09;
/*
 * OutPutStream 抽象类 关注他的方法和子类
 * 字节输出流 --- 从程序写出文件
 * 字节: 每次只操作文件中的1个字节
 * 只针对文件,不能针对文件夹
 * write(int b) : 写入一个字节
 * write(btye[] b)： 写入一个字节数组
 * write(byte[] b, int ,int) : 第一个int表示开始写入的索引,第二个int表示写几个
 *
 *  close() 关闭流对象,释放与次流相关的资源
 * 子类 FileOutPutStream
 */
public class OutPutDemo {
}
