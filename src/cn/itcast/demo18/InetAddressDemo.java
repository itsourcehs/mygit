package cn.itcast.demo18;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: HelloWorld
 * @description: 互联网中的ip地址类
 * java.net.InetAddress
 * 静态方法:
 *      static InetAddress getLocalHost()
 *      static InetAddress getByName(String hostName) 传递其他主机名
 * 非静态方法:
 *      String getHostAddress()
 *      String getHostName()
 * @author: Mr.Huang
 * @create: 2021-05-16 13:39
 **/

public class InetAddressDemo {
    public static void main(String[] args) throws IOException {
        fuc();
    }
    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: Mr.Huang
     * @Date: 2021/5/16
     */
    public static void fuc() throws UnknownHostException {
        InetAddress inet = InetAddress.getLocalHost();
        System.out.println(inet);

        String ip = inet.getHostAddress();
        String name = inet.getHostName();
        System.out.println(ip+"  "+name);
    }

}
