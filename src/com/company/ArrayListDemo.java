package com.company;
import java.util.ArrayList;
/*
1.集合 ArrayList<数据类型> 变量名 = new ArrayList<数据类型>();
注意:
  1.必须指定存储的数据类型
  2.集合只存储引用类型,不存储基本类型(要想存储基本类型需写基本类型对应的引用类型)
2.集合中的方法:
    add(参数) -- 参数类型需与定义集合时的类型一致
    get(参数) -- 取出集合元素,写入索引(int)
    size()   -- 返回集合的长度
    add(索引 值) -- 在索引*位置上添加一个元素
    set(索引 值) -- 修改索引上的值
    remove(索引 值) -- 删除指定索引上的元素
    clear() -- 清空集合中的所有元素
3.集合的遍历:
    for(int i=0;i<array.size();i++)
    1.size
    2.()不能少
*/
public class ArrayListDemo {
    public static void main(String[] args) {
        //创建集合容器，指定数据类型
        ArrayList<String> array = new ArrayList<String>();
        //创建集合容器,指定数据类型int
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        //存储字符串元素
        array.add("abc");
        array.add("it");
        array.add("love");
        array.add("java");
        //输出集合的长度
        int size_2 = array.size();
        //System.out.println(size_2);
        //获取集合中的 1 索引的元素
        String num = array.get(1);
        //System.out.println(num);
        //集合的遍历
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }
    }
}
