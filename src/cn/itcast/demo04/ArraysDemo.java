package cn.itcast.demo04;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        fuc_2();
    }
    /*
     * 对数组升序排列
     */
    public static void fuc(){
        int arr[] = {1,24,34,11,2};
        Arrays.sort(arr);
        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    /*
     * 数组的二分查找
     * 如果数不存在,则返回 (- 的插入点 -1)
     */
    public static void fuc_1(){
        int arr[] = {1,4,5,7,9};
        int index = Arrays.binarySearch(arr,7);
        System.out.println(index);
    }

    /*
     * 将数组转为字符串
     */
    public static void fuc_2(){
        int arr[] = {1,4,5,7,9};
        String index = Arrays.toString(arr);
        System.out.println(index); //[1, 4, 5, 7, 9]
    }

    /*
     * 定义方法 接受输入 存储10个成绩 将最后三个成绩存储到新的数组,
     * 返回新的数组
     */
    public static void fuc_3(int arr[]){
        int result [] = new int[3];
        System.arraycopy(arr,0,result,0,3);
    }















}
