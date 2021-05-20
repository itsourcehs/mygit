package cn.itcast.demo19;

public class Person {
	public String name;
	private int age;

	
	/*static{
		System.out.println("��̬�����");
	}*/
	
	public Person(){
	}
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	private Person(int age,String name){
		this.name = name;
		this.age = age;
	}
	
	public void eat(){
		System.out.println("�˳Է�");
	}

	public void sleep(String s, int a,double d){
		System.out.println("����˯��"+s+"....."+a+"....."+d);
	}
	private void playGame(){
		System.out.println("���ڴ���Ϸ");
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
