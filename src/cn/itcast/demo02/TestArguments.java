package cn.itcast.demo02;

import com.company.hotel.ChuShi;
import com.company.hotel.FuWuYuan;
import com.company.hotel.JingLi;

public class TestArguments {
    public static void main(String[] args) {
        //调用抽象类Animall的静态方法
        /*Animall a = Animall.getInstance();//返回子类对象
        a.eat();

        Calendar c = Calendar.getInstance();
        System.out.println(c);

         */
        /* 创建一个经理 两个服务员 */
        JingLi jl = new JingLi("小明","董事会001",3456.4);
        jl.work();
        FuWuYuan f1 = new FuWuYuan("催化","服务部");
        FuWuYuan f2 = new FuWuYuan("酸菜","服务部");
        f1.work();
        f1.service();
        f2.work();
        f2.service();

        ChuShi c1 = new ChuShi("老干妈","后厨001");
        ChuShi c2 = new ChuShi("老干爹","后厨001");
        c1.work();
        c1.service();
        c2.work();
        c2.service();


    }
}
