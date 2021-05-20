package com.company.hotel;
/*
类继承员工,实现接口
 */
public class FuWuYuan extends Employee implements VIP {
    //空参构造器
    public FuWuYuan(){}

    //有参构造器
    public FuWuYuan(String name,String id){
        super(name, id);
    }

    public void work(){
        System.out.println("服务员上菜");
    }
    public void service(){
        System.out.println("服务员倒酒");
    }
}
