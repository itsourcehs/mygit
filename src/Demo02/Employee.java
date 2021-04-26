package Demo02;
//员工类 抽取子类相同
public abstract class Employee {
    private String name;
    private String id;
    //alt+ins快速生成get 和set
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //构造器
    public Employee(String name,String id){
        this.name = name;
        this.id = id;
    }
    public abstract void work();//抽象方法无花括号
}
