package com.company;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class ShoppManager {
    public static void main(String[] args) {
        ArrayList<Shopp_new> array = new ArrayList<Shopp_new>();
        addGoods(array);
        //进入到死循环中
        while (true){
            int number = chooseFuction();
            switch (number){
                case 1:
                    printStore(array);
                break;

                case 2:
                    update(array);
                break;

                case 3:
                return;

                default:
                    System.out.println("无此功能");
                break;
            }
        }
    }
    //方法1 将商品信息存储到集合中
    public static void addGoods(ArrayList<Shopp_new> array){
        //创建Goods类型的变量
        Shopp_new g1 = new Shopp_new();
        Shopp_new g2 = new Shopp_new();
        //赋值
        g1.brand = "MacBook";
        g1.size = 13.1;
        g1.price = 9999.2;
        g1.count = 3;

        g2.brand = "MacBook";
        g2.size = 15.1;
        g2.price = 2999.2;
        g2.count = 1;

        // 存储至集合中
        array.add(g1);
        array.add(g2);
    }

    //方法2 查看库存清单,遍历集合
    public static void printStore(ArrayList<Shopp_new> array){
        //遍历集合
        int totalCount = 0;
        double totalMoney = 0;
        for(int i=0;i<array.size();i++){
            //使用Shopp_new 类型变量,接收get方法结果
            Shopp_new s = array.get(i);
            System.out.println(s.brand+"  "+s.size+"  "+s.price+"  "+s.count);
            totalCount += s.count;
            totalMoney += totalCount*s.price;
        }
    }

    //方法3 修改商品的库存
    public static void update(ArrayList<Shopp_new> array){
        Scanner sc = new Scanner(System.in);
        //遍历集合,获取集合中的每个元素
        for (int i =0;i<array.size();i++){
            Shopp_new s = array.get(i);
            //对count进行修改
            System.out.println("请输入"+s.brand+"的库存数:");
            s.count = sc.nextInt();
        }
    }

    //方法4 实现选择的菜单
    public static int chooseFuction(){
        System.out.println("----------库存管理------------");
        System.out.println("1.查看库存清单");
        System.out.println("2.修改商品库存数量");
        System.out.println("3.退出");
        System.out.println("请输入需要执行的序号:");
        Scanner sc = new Scanner(System.in);
        int number_1 = sc.nextInt();
        return number_1;
    }
}
