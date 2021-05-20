package com.company.hotel;
/*
属于员工类,不实现接口,但有奖励
 */
public class JingLi extends Employee{
    //空参构造器
    public JingLi(){}
    //有参构造器
    public JingLi(String name,String id,double money){
        super(name, id);
        this.money = money;
    }




    //独有属性
    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void work(){
        System.out.println("管理,谁出错我罚谁");
    }

}
