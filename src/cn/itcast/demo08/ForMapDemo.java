package cn.itcast.demo08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Map接口定义方法 keySet
 * 所有的键,存储到集合
 */
public class ForMapDemo {
    public static void main(String[] args) {
            /*
             *1.调用map集合的keySet方法,所有的键,存储到集合
             * 2.遍历Set集合,获取出集合中的所有元素
             * 3.调用map集合的方法get,通过键获取到值
             *
             */
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);

        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            //it.next();
            String key = it.next();
            Integer value = map.get(key);
            System.out.println(key+"..."+value);

            /*增强for*/
            for(String key1 : map.keySet()){
                Integer value1 = map.get(key1);
                System.out.println(value1);
            }
        }
    }






}
