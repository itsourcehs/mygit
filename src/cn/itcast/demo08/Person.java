package cn.itcast.demo08;

import java.util.Objects;

public class Person {
    /*
     * 父类的HashCode方法没有重写,每次运行结果都是不同整数
     */
    /*public int hashCode(){
        return 1;
    }

     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){}

    @Override
    public String toString(){
        return name+"..."+age;
    }



    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    /*public int hashCode(){
        return name.hashCode()+age;
    }

     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
