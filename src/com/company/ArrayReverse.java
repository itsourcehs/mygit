package com.company;
/* 1.数组逆序
需要两个指针(java并没有指针概念) 大指针 = 最大索引 小指针 = 0索引
当最大索引<= 0(最小索引)时,停止交换(使用tem暂存)
2.选择排序:数组中的每个元素进行比较
3.冒泡排序:数组中的相邻元素进行比较
*/


public class ArrayReverse {
    public static void main(String[] args) {
        int [] arr = {8,1,21,3,4,10};
        //调用数组逆序方法
        //reverse(arr);
        //selectSort(arr);
        bubbleSort(arr);
        //遍历数组
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        //System.out.println(arr[0]);


    }

    //数组逆序
    public static void reverse(int[] arr){
        //定义两个变量,最后两个变量++ --
        for(int min =0,max = arr.length-1;min<max;min++,max--){
            //使用临时变量交换位置
            //先把最小索引使用temp保存
            int temp = arr[min];
            //再将最大索引的值赋值给最小索引上
            arr[min] = arr[max];
            //最后将temp赋值给最大索引上
            arr[max] = temp;
        }
    }

    //选择排序 外循环 = 总比较次数 内循环 = 每次比较了多少元素
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            //内循环每次在减少,修改变量的定义
            for(int j=i+1;j<arr.length;j++){
                //对元素判断
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i =0;i<arr.length;i++){
            //内循环每次都在减少
            for(int j =0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
