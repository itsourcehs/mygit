package cn.itcast.demo07;

import java.util.LinkedList;

/*
 * 子类特有的功能,不能多态调用
 */
public class LinkedListDemo {
    public static void main(String[] args) {

    }
    /*
     * addFirst(E)
     * addLast(E)
     * E getFirst()
     * E getLast()
     * E removeFirst()
     * E removeLast()
     */
    public static void fuc(){
        LinkedList<String> link = new LinkedList<String>();
        link.add("abc");
        link.add("bcd");

        link.addFirst("itcast");
        System.out.println(link);
    }

    public static void fuc1(){
        LinkedList<String> link = new LinkedList<String>();
        link.add("abc");
        link.add("bcd");
        if(!link.isEmpty()) {
            String first = link.getFirst();
            String last = link.getLast();
        }
    }




}
