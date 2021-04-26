package cn.itcast.demo08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map集合获取方式
 * entrySet方法,
 * 1.调用map集合方法entrySet将集合中的映射关系对象存储到Set集合
 *   Set<Entry<K,V>>
 * 2.遍历Set集合
 * 3.获取出的Set集合中的元素,是映射关系对象
 * 4.通过映射关系对象方法 getKey,getValue获取键值对
 */
public class MapEntrySetDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"abc");
        map.put(2,"bcd");
        map.put(3,"cde");

        //1  创建内部类对象  外部类.内部类  Map.Entry
        Set<Map.Entry<Integer,String>> set = map.entrySet();

        //2
        Iterator<Map.Entry<Integer,String>> it = set.iterator();
        while (it.hasNext()){
            //3
            //it.next
            Map.Entry<Integer,String> entry = it.next();
            Integer key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key+"..."+value);
            /*增强for循环  警告: Iterator不能遍历Map集合*/
            for(Map.Entry<Integer,String> entry1 : map.entrySet()){
                System.out.println(entry1.getKey()+"..."+entry1.getValue());
            }


        }



    }



}
