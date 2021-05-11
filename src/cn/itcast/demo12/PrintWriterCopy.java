package cn.itcast.demo12;

import java.io.*;

/**
 * @program: HelloWorld
 * @description: 打印流实现文本复制
 * 读取数据源 : BufferedReader+FileReader
 * 写入数据目的 : PrintWriter+println 自动刷新
 * @author: Mr.Huang
 * @create: 2021-05-11 23:03
 **/

public class PrintWriterCopy {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("c:\\a.txt"));
        PrintWriter pw = new PrintWriter(
                new FileWriter("d:\\a.txt"),true);

        String line = null;

        while ((line = bfr.readLine()) != null){
            pw.println(line);
        }
        pw.close();
        bfr.close();
    }
}
