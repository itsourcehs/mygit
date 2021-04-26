package Demo02;
/*
构造方法第一行,写this()还是super()

无论如何,子类所有的构造方法,直接或间接必须调用到父类构造方法
 */
public class Student extends Person {
    //1. 继承
    /*public Student(){
        super(2);//2.必须在构造方法第一行
    }
     */
    public Student(String s){
        super(2);
    }
    //public Person(){}
    public Student(){
        this("abc");
    }
}
