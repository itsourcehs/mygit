package cn.itcast.demo04;

public class SystemDemo {
    public static void main(String[] args) {
        fuc();
    }

    /*
     * 获取当前毫秒值
     * static long currentTimeMillis()
     */
    public static void fuc(){
        long start = System.currentTimeMillis();
        for(int i =0;i<10000;i++){
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

















}
