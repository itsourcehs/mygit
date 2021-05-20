package com.company.hotel;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 将酒店员工,厨师,服务员,经理,存储到三个集合
 * 定义方法,同时遍历三个集合,遍历的同时调用工作方法
 */
public class GenericTest {
    public static void main(String[] args) {
        ArrayList<ChuShi> cs = new ArrayList<ChuShi>();
        ArrayList<FuWuYuan> fwy = new ArrayList<FuWuYuan>();
        ArrayList<JingLi> jl = new ArrayList<JingLi>();

        //集合存储元素
        cs.add(new ChuShi("张三","后厨001"));
        cs.add(new ChuShi("张三1","后厨002"));

        fwy.add(new FuWuYuan("四1","服务部001"));
        fwy.add(new FuWuYuan("四2","服务部002"));

        jl.add(new JingLi("王五","董事001",12345.8));
        jl.add(new JingLi("王五1","董事002",223455.8));

        fuc(jl);
        fuc(fwy);
        fuc(cs);

    }
    /*
     * 方法参数: 控制,可以传递Employee对象,也可传递Employee子类对象
     * 泛型的限定；父类固定Employee，但是子类可以无限
     * ? extends Employee 限制的是父类,上限限定,可以传递Employee对象,也可传递Employee子类对象
     * ? super Employee 限制的是子类,下限限定,可以传递Employee对象,也可传递Employee父类对象
     */

    public static void fuc(ArrayList<? extends Employee> array){
        Iterator<? extends Employee> it = array.iterator();
        while (it.hasNext()){
            Employee e = it.next();
            e.work();
        }

    }




}
