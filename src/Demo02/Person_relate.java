package Demo02;
// 私有成员变量可通过get set进行调用
public class Person_relate {
    private String name;
    private int age;
    //get set
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setage(int age){
        this.age = age;
    }

    //构造器
    public Person_relate(String name,int age){
        this.name = name;
        this.age = age;
    }
}
