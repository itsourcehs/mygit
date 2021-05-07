package cn.itcast.demo09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FileOutPutStream 文件续写与换行
 * 续写: FileOutPutStream的构造方法,第二个参数加上true
 *
 * 在文件中,写入换行,符号换行 \r\n
 * \r\n可以写在上一行的结尾,或者下一行的开头
 */
public class FileOutPutStreamDemo01 {
    public static void main(String[] args) throws IOException {
        // 1.创建文件对象
        File f = new File("C:\\Users\\Administrator\\IdeaProjects\\HelloWorld\\README.txt");
        // 2.创建流对象
        FileOutputStream fos = new FileOutputStream(f,true);

        // 3.写入
        fos.write("hello".getBytes());
        /*
        fos.write("hello\r\n".getBytes());
         */

        // 3.1换行写入
        fos.write("\r\nworld".getBytes());

        // 4.关闭流对象
        fos.close();

    }
}
