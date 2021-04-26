package com.company;
import java.util.Scanner;
/*
学习Scanner 类 和 引用数据类型
类型 变量名 = new 类型();  变量名.方法名()
Scanner类 作用是让我们在命令行接受键盘的输入
 */
public class ScannerDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);//键盘输入
        // nextInt() 接受键盘输入,必须为整数
        int i = sc.nextInt();
        System.out.println(i);
        // next() 接受键盘输入的字符串
        String s = sc.next();
        System.out.println(s);
    }

}
