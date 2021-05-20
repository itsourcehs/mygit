package com.company.hotel;
/*
 姓名 工号 工作方法
 */
public  abstract class Employee {
    private String name;
    private String id;
    //空参构造器
    public Employee(){}

    //满参构造器
    public Employee(String name,String id){
        this.name = name;
        this.id = id;
    }
    //工作方法
    public abstract void work();

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
}
