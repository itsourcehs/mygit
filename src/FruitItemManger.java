/*
1.商品数据初始化
2.用户菜单选择
3.根据选择执行不同功能
    3.1 查看
    3.2 增加
    3.3 删除
    3.4 修改
 */

import java.util.ArrayList;
import java.util.Scanner;

public class FruitItemManger {
    public static void main(String[] args) {
        ArrayList<FruitItem> array = new ArrayList<FruitItem>();
        //商品数据初始化
        init(array);
        //
        while (true){
            //主菜单
            mainMenu();
            //用户选择序号
            int number = choose();
            switch (number){
                case 1:
                    //调用货物清单
                    showFruitList(array);
                break;
                case 2:
                    //添加商品
                    addFriut(array);
                    System.out.println("添加商品成功!!!");
                break;

                case 3:
                    //删除商品
                    deleteFruit(array);
                break;

                case 4:
                    //修改商品
                    updateFruit(array);
                break;

                case 5:
                return ;

            }
        }
    }
    // 1. 商品数据初始化 无返回 参数: 集合
    public static void init(ArrayList<FruitItem> array){
        //创建对象
        FruitItem f1 = new FruitItem();
        f1.ID = 9527;
        f1.name = "少林酥饼";
        f1.price = 12.5;

        FruitItem f2 = new FruitItem();
        f2.ID = 1527;
        f2.name = "牡丹饼";
        f2.price = 111.8;

        FruitItem f3 = new FruitItem();
        f3.ID = 9517;
        f3.name = "哈密瓜";
        f3.price = 122.5;
        array.add(f1);
        array.add(f2);
        array.add(f3);
    }

    //2. 主菜单 返回无 参数:无
    public static void mainMenu(){
        System.out.println("===========欢迎光临神仙超市==============");
        System.out.println("1.货物清单 2.添加货物 3.删除货物 4.修改货物 5.退出");
        System.out.println("请输入要操作的序号:");
    }

    //3.接受用户输入 返回编号
    public static int choose(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    //4.显示货物清单
    public static void showFruitList(ArrayList<FruitItem> array){
        System.out.println();
        System.out.println("============商品库存清单================");
        for (int i =0;i<array.size();i++){
            // get
            FruitItem item = array.get(i);
            System.out.println(item.ID+"     "+item.name+"     "+item.price);
        }
    }

    //5.添加商品功能 返回无 参数:集合
    //提示用户选择的是哪个商品，和输入的是什么
    public static void addFriut(ArrayList<FruitItem> array){
        System.out.println("选择的是添加商品功能");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入商品的编号:");
        int ID = sc.nextInt();
        System.out.println("请输入商品的名称:");
        String name = sc.next();
        System.out.println("请输入商品的单价:");
        double price = sc.nextDouble();
        //创建FruitItem对象
        FruitItem item = new FruitItem();
        item.ID = ID;
        item.name = name;
        item.price = price;
        array.add(item);
    }

    //6.删除商品功能 返回无 参数:集合
    /*提示用户选择的是删除功能 键盘输入商品的编号

    */
    public static void deleteFruit(ArrayList<FruitItem> array){
        System.out.println("选择的是删除功能");
        System.out.println("请输入商品的编号:");
        Scanner sc = new Scanner(System.in);
        int ID = sc.nextInt();
        //遍历集合
        for(int i =0;i<array.size();i++){
            //获取所有的FruitItem对象
            FruitItem item = array.get(i);
            //比较用户输入的id与调用的商品id
            if(item.ID == ID){
                array.remove(i);
                System.out.println("删除成功!!!");
                return;
            }
        }
        System.out.println("----警告------");
        System.out.println("遍历完了,你输入的商品不存在!!!");
    }

    /*7.修改商品功能 返回无 参数:集合
    提示用户输入需要修改的商品编号
    */
    public static void updateFruit(ArrayList<FruitItem> array){
        System.out.println("选择的是修改功能");
        System.out.println("请输入商品的编号:");
        Scanner sc = new Scanner(System.in);
        int ID = sc.nextInt();
        //遍历集合
        for(int i =0;i<array.size();i++) {
            //获取所有的FruitItem对象
            FruitItem item = array.get(i);
            //比较用户输入的id与调用的商品id
            if (item.ID == ID) {
                System.out.println("输入新的商品编号:");
                item.ID = sc.nextInt();
                System.out.println("输入新的商品名称:");
                item.name = sc.next();
                System.out.println("输入新的商品价格:");
                item.price = sc.nextDouble();
                System.out.println(item.name + "商品修改成功!!");
                return;
            }
        }
        System.out.println("----警告------");
        System.out.println("遍历完了,你输入的商品不存在!!!");
    }

}
