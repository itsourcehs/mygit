package cn.itcast.hotel;
/*
 类继承员工,实现接口
 */
public class ChuShi extends Employee implements VIP {
    public ChuShi(){}
    public ChuShi(String name,String id){
        super(name, id);//
    }

    @Override
    public void work(){
        System.out.println("厨师炒菜");
    }
    public void service(){
        System.out.println("厨师做菜加量");
    }

}
