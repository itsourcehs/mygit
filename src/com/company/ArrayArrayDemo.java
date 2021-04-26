package com.company;
// 公司销售总和
public class ArrayArrayDemo {
    public static void main(String[] args){
        int [][] arr = {{11,12},{21,22,23},{32,11,22,13}};
        int sum = 0;
        int groupSum = 0;
        for (int i =0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                groupSum += arr[i][j];
            }
            System.out.println("每个小组总金额:"+groupSum);
            sum += groupSum;
            groupSum = 0;
        }
        // sout + 回车
        System.out.println("公司总额:"+sum);
    }
}
