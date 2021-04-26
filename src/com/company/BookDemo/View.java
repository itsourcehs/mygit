package com.company.BookDemo;

import java.util.Scanner;

public class View {
    static Book book = new Book();
    Scanner sc = new Scanner(System.in);

    /*
     * 选择菜单 参数无 返回 int
     */
    public int menu(){
        int menu = -1;
        System.out.println("1.图书新增\n2.图书修改\n3.图书删除\n" +
                "4.根据图书名称模糊查找图书\n5.查看所有图书\n0.退出");
        String text = sc.nextLine();
        try{
            menu = Integer.parseInt(text);
        }catch (NumberFormatException e ){
            System.out.println("请输入对应序号: ");
            return menu();
        }
        if (menu<0 || menu>5){
            System.out.println("输入有误,请重新输入!");
            return menu();
        }
        return menu;
    }
}
