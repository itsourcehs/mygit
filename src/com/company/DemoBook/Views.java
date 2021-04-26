package com.company.DemoBook;

import java.util.Collection;
import java.util.Scanner;

public class Views {
    static Scanner sc = new Scanner(System.in);
    /*
     * 选择身份菜单功能
     */
    public static void welcome(){
        System.out.println("----------欢迎使用----------");
    }

    public static void bye(){
        System.out.println("---------欢迎下次使用---------");
    }

    /*
     * 身份选择菜单  参数 无 返回:int
     */
    public static int menu(){
        System.out.println("请选择身份：");
        System.out.println("1.快递员");
        System.out.println("2.用户");
        System.out.println("0.退出");
        String index = sc.nextLine();
        int num = -1;
        try {
           num = Integer.parseInt(index);
        }catch (NumberFormatException e){
            System.out.println("请输入数字: ");
        }
        if( num <0 || num > 2){
            System.out.println("请重新输入。");
            return menu();
        }
        return num;
    }

    /*
     * 管理员菜单 参数 无 返回:int
     *
     */
    public int adminMenu(){
        System.out.println("请选择操作序号：");
        System.out.println("1.添加快递");
        System.out.println("2.删除快递");
        System.out.println("3.修改快递");
        System.out.println("4.查看所有快递");
        System.out.println("0.返回上一层");
        String text = sc.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("请输入数字。");
        }
        if (num < 0 || num > 4) {
            System.out.println("请重新输入");
            return adminMenu();
        }
        return num;
    }

    /*
     * 添加快递信息 参数无 返回快递对象 Express
     */
    public Express addExpress(){
        System.out.println("请输入快递单号：");
        String num = sc.nextLine();
        System.out.println("请输入快递公司：");
        String company = sc.nextLine();
        Express e = new Express();
        e.setNumber(num);
        e.setCompany(company);
        return e;
    }

    /*
     * 更新快递信息 参数快递对象 返回无
     */
    public void updateExpress(Express e ){
        System.out.println("请输入新的快递单号：");
        String num = sc.nextLine();
        System.out.println("请输入新的快递公司：");
        String company = sc.nextLine();
//        Express e = new Express();
        e.setNumber(num);
        e.setCompany(company);
    }

    /*
     *　确认删除 参数无 返回int
     */
    public int confirmDelete(){
        System.out.println("确认是否删除：");
        System.out.println("1.确认删除");
        System.out.println("2.取消删除");
        System.out.println("0.退出");
        String text = sc.nextLine();
        int num = -1;
        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return confirmDelete();
        }
        if (num < 0 || num > 2) {
            return confirmDelete();
        }
        return num;
    }

    /*
     * 获取所有快递信息
     * 参数 所有快递,集合 返回无
     */
    public void printAll(Collection<Express> es){
        for(Express e : es){
            System.out.println("第"+(e.posX)+"行,"+
                    "第"+(e.posY)+"列.");
            System.out.println(e);
        }
    }

    /*
     * 获取某一个快递
     * 参数 快递对象e 返回无
     */
    public void printExpress(Express e ){
        if (e == null){
            System.out.println("快递信息不存在");
        }
        System.out.println("快递信息");
        System.out.println("快递公司为: "+e.getCompany());
        System.out.println("快递单号为: "+e.getNumber());
        System.out.println("取件码为: "+e.getCode());

    }

    /*
     * 用户选择菜单 参数无 返回int
     */
    public static int userMenu(){
        System.out.println("请根据提示取件 ");
        System.out.println("请输入取件码: ");
        int num = -1;
        String text = sc.nextLine();
        try {
            num = Integer.parseInt(text);
        }catch (NumberFormatException e ){
            System.out.println("输入有误,请重新输入: ");
            return userMenu();
        }
        return num;
    }
    /*
     *
     */
    public  void expressExist(){
        System.out.println("此快递单号已存在,请勿重复存储");
    }
    /*
     * 打印快递取件码
     * 参数 快递对象 返回无
     */
    public void printCode(Express e){
        System.out.println("新的快递的取件码为: "+e.getCode());
    }
    /*
     * 操作成功
     */
    public void success(){
        System.out.println("操作成功!");
    }
    /*
     * 快递不存在时提示
     */
    public void printNull(){
        System.out.println("快递不存在,请检查输入");
    }

    /*
     * 根据快递单号查询信息
     * 参数无 返回String
     */
    public String findByNumber(){
        System.out.println("请根据提示输入快递信息");
        System.out.println("请输入需要操作的快递单号: ");
        String num = sc.nextLine();
        return num;
    }


}
