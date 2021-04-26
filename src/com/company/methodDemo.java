package com.company;

public class methodDemo {
    public static void main(String[] args) {
        // 在main中调用getArea方法
        /*int areaCount = getArea(3,5);
        System.out.println("面积是:"+areaCount);

         */
        printRect();
    }

    public static int getArea(int width, int height){
        return width*height;
    }

    public static void printRect(){
        for(int i =0;i<3;i++){
            for (int j =0;j<3;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
