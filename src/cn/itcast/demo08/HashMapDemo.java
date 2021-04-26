package cn.itcast.demo08;

import java.util.HashMap;
import java.util.Map;

/*
 * 使用HashMap集合,存储自定义对象
 * 自定义对象可以作为键出现,也可以作为值出现
 */
public class HashMapDemo {

    public static void main(String[] args) {
        fuc1();

    }
    /*
     *　HashMap集合,存储自定义对象　作为值
     */
    public static void fuc(){
        HashMap<String,Person> map = new HashMap<String,Person>();
        map.put("beijing",new Person("a",20));
        map.put("tianjing",new Person("b",22));
        map.put("shanghai",new Person("c",24));

        for(String key : map.keySet()){
            Person value = map.get(key);
            System.out.println(key+".."+value);
        }

        for(Map.Entry<String,Person> entry : map.entrySet()){
            String key = entry.getKey();
            Person value = entry.getValue();
            System.out.println(key+".."+value);
        }

    }


    /*
     * HashMap集合,存储自定义对象　作为键
     * 保证键的唯一性 自定义对象需重写 hashCode() equals()
     */
    public static void fuc1(){
        HashMap<Person,String> map = new HashMap<Person,String>();
        map.put(new Person("a",20),"里约热内卢");
        map.put(new Person("b",12),"索马里");
        map.put(new Person("b",12),"索马里");
        map.put(new Person("c",11),"百莫大");

        for(Person key : map.keySet()){
            String value = map.get(key);
            System.out.println(key+".."+value);
        }

        for(Map.Entry<Person,String> entry : map.entrySet()){
            Person key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key+".."+value);
        }


    }



}
