package com.company;

public class ArrayDemo {
    public static void main(String[] args){
        // 数据类型[] 变量名 = new 数据类型[存储元素的个数]
        //int[] arr = new int[3]; // 存3个整数的容器(数组)
        int [] arr_1 = {1,2,3,4,5,6};
        System.out.println(arr_1.length);//6
        System.out.println(arr_1[5]);//6
        arr_1[2] = 213;
        System.out.println(arr_1[2]);
        //1.数组越界异常
        //2.数组空指针异常 加null表示不在保存arr_1的内存地址
        arr_1 = null;

    }
}
