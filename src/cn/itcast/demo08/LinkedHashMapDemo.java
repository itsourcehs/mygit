package cn.itcast.demo08;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String,String> link = new LinkedHashMap<String,String>();
        link.put("1","a");
        link.put("2","b");
        link.put("3","c");
        link.put("4","d");

        System.out.println(link);

    }

}
