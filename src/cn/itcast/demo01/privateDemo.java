package cn.itcast.demo01;
/*
1.私有关键字只能对成员变量(类属性)进行修饰,不能对局部变量修饰
2.修饰以后的变量,必需定义set***和get***方法进行设置和读取
3.this关键字: 用于区分成员变量和局部变量
    方法中调用 this.成员变量
4.子类重写父类的方法:子类方法权限需大于或等于父类方法权限
    public>protect>default>private
 */
public class privateDemo {
    private String name="校长";
    private int age = 18;

    public static void main(String[] args) {
        //speak();
    }
    public void setAge(int age){

    }
    public int getAge() {
        return age;
    }
    public  void speak(){
        String name = "我";
        int age = 22;
        System.out.println(name+"今年: "+age);
        System.out.println(this.name+"今年: "+this.age);
    }
}
