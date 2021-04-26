package com.company;

import java.util.Scanner;

/*

 */
public class Shopp {
    public static void main(String[] args){
        /*System.out.println("------商城库存清单---------------");
        System.out.println("品牌型号    尺寸    价格   库存数量");
        // 定义表格中的数据变量
        // 品牌型号 String,尺寸,价格 double,库存数 int
        String macBrand = "MacBookAir";
        double macSize = 13.3;
        double macPrice = 6998.88;
        int macCount = 5;

        String thinkBrand = "thinkPad";
        double thinkSize = 14;
        double thinkPrice = 6998.88;
        int thinkCount = 10;

        String asusBrand = "ASUS";
        double asusSize = 13.3;
        double asusPrice = 6998.88;
        int asusCount = 5;
        System.out.println(macBrand+" "+macSize+"  "+macPrice+"  "+macCount);
        System.out.println(thinkBrand+"  "+thinkSize+"   "+thinkPrice+"  "+thinkCount);
        System.out.println(asusBrand+"    "+asusSize+"     "+asusPrice+"  "+asusCount);

        // 计算库存总数
        int totalCount = macCount+thinkCount+asusCount;
        // 所有商品库存的总金额
        double totalMoney = macCount*macPrice+thinkCount*thinkPrice+asusCount*asusPrice;
        // 输出表格底部
        System.out.println("总库存数: "+totalCount);
        System.out.println("商品库存总金额: "+totalMoney);

         */
        String[] brand = {"MacBook","Thinkpad"};
        double[] size = {12.2,12.6};
        double[] price = {9999.2,2345.6};
        int[] count = {0,0};
        while (true){
        int choose = chooseFuction();
        switch (choose) {
            case 1:
                //调用查看库存清单方法
                printStore(brand,size,price,count);
                break;
            case 2:
                //调用修改库存的方法
                update(brand,count);
                break;
            case 3:
                return;
            default:
                System.out.println("没有这个功能");
            break;
        }
        }

    }
    // 用户选择功能 无参数返回int
    public static int chooseFuction(){
        System.out.println("----------库存管理------------");
        System.out.println("1.查看库存清单");
        System.out.println("2.修改商品库存数量");
        System.out.println("3.退出");
        System.out.println("请输入需要执行的序号:");
        Scanner sc = new Scanner(System.in);
        int choosenumber = sc.nextInt(10);
        return choosenumber;
    }
    // 遍历数组清单 无返回 有参数:数组
    public static void printStore(String[] brand,double[] size,double[] price,int[] count){
        System.out.println("------商城库存清单---------------");
        System.out.println("品牌型号    尺寸    价格   库存数量");
        int totalCount = 0;
        int totalMoney = 0;
        //将所有商品信息打印出来
        for(int i=0;i<brand.length;i++){
            System.out.println(brand[i]+" "+size[i]+"  "+price[i]+"  "+count[i]);
            totalCount += count[i];
            totalMoney += totalCount*price[i];
        }
        System.out.println("总库存数: "+totalCount);
        System.out.println("商品库存总金额: "+totalMoney);
    }
    //修改所有商品库存 返回没有 有参数:库存数的数组,商品名称
    public static void update(String[] brand,int[] count){
        // 接收键盘输入 遍历数组
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<brand.length;i++){
            System.out.println("请输入"+brand[i]+"的库存数");
            int newNumber = sc.nextInt();
            count[i] = newNumber;
        }
    }
}
