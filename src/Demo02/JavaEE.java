package Demo02;
//定义javaee工程师
public class JavaEE extends Developer {
    public JavaEE(String name,String id){
        super(name, id);

    }
    //重写abstract抽象方法
    public void work(){
        System.out.println(super.getName()+"  "+super.getId());

    }
}
