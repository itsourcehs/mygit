package cn.itcast.demo11;

import java.io.*;

/**
 * @program: 使用缓冲流对象, 复制文本文件
 * @description: 数据源 BufferedReader+FileReader读取  数据目的 BufferedWriter+FileWriter写入
 * 读一行写一行,写换行
 * @author: Mr.Huang
 * @create: 2021-05-10 22:04
 **/

public class Copy1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new
                BufferedReader(new FileReader("c:\\w.log"));
        BufferedWriter bfw = new
                BufferedWriter(new FileWriter("d:\\w.log"));
        //读一行写一行,写换行
        String line = null;
        while ((line = bfr.readLine()) != null){
            bfw.write(line);
            bfw.newLine();
            bfw.flush();
        }
        bfw.close();
        bfr.close();
    }
}
