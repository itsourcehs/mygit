package cn.itcast.demo10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 通过字节流 字节数组实现提升文件复制效率
 *
 */
public class FileCopyByBytes {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        //1.定义2个流对象变量
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //2.创建两个流对象,绑定数据源和数据目的
            fis = new FileInputStream("c:\\a.txt");
            fos = new FileOutputStream("d:\\a.txt");

            //3.字节输入流,字节数组
            byte[] bytes = new byte[1024*10];
            int len = 0;
            while ((len = fis.read(bytes)) != -1){
                fos.write(bytes,0,len);
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
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
}
