package cn.itcast.demo10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 将数据源 c:\\a.txt 复制到 d:\\a.txt
 * 字节输入流,绑定数据源
 * 字节输出流,绑定数据目的
 *
 * 输入,读取1个字节
 * 输出,写入1个字节
 *
 * 效率太慢,读一个写一个
 */
public class FileCopy {
    public static void main(String[] args) {
        //1.定义2个流对象变量
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //2.创建两个流对象,绑定数据源和数据目的
            fis = new FileInputStream("c:\\a.txt");
            fos = new FileOutputStream("d:\\a.txt");

            //3.字节输入流,读一个字节,输出流写1个字节
            int len = 0;
            while ((len = fis.read()) != -1){
                fos.write(len);
            }
        }catch (IOException ex){
            System.out.println(ex);
            throw new RuntimeException("文件复制失败");
        }finally {
            try{
                //判空
                if(fos != null)
                    fis.close();
            }catch (IOException ex){
                //System.out.println(ex);
                throw new RuntimeException("释放输出流资源失败");
            }finally {
                try{
                    if(fos != null)
                        fos.close();
                }catch (IOException ex){
                    throw new RuntimeException("释放输入流资源失败");
                }
            }
        }
    }
}
