package cn.itcast.demo08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/*
 * 斗地主
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //创建Map集合,键是编号,值是牌
        HashMap<Integer,String> pk = new HashMap<Integer, String>();
        //创建List集合存储编号 全为整数
        ArrayList<Integer> num = new ArrayList<Integer>();

        //创建数组存储13个点数
        String[] points = {"2","A","K","Q",
                "J","10", "9","8",
                "7","6","5","4","3"};

        //创建数组存储4种花色
        String[] colors = {"♠","♥","♣","♦"};

        //定义整数变量,作为键
        int index = 2;
        //遍历数组,花色+点数的组合,存储到Map集合
        for(String point : points){
            for(String color : colors){
                pk.put(index,point+color);// 2,♠2
                num.add(index);//忘记添加数字到List集合
                index++;
            }
        }

        //存储大小王
        pk.put(0,"大王");
        num.add(0); // 添加到编号集合
        pk.put(1,"小王");
        num.add(1); // 添加到编号集合

        //洗牌 == 打乱编号的顺序 工具类
        Collections.shuffle(num);

        //发牌
        ArrayList<Integer> play1 = new ArrayList<Integer>();
        ArrayList<Integer> play2 = new ArrayList<Integer>();
        ArrayList<Integer> play3 = new ArrayList<Integer>();
        ArrayList<Integer> bottom = new ArrayList<Integer>();

        //发牌采用集合索引%3 {1,5,2,3,6}
        for(int i =0;i<num.size();i++){
            if(i<3){
                //存到底牌集合
                bottom.add(num.get(i));
            }else if(i % 3 ==0){
                //发给玩家1
                play1.add(num.get(i));
            }else if(i % 3 ==1){
                //发给玩家2
                play2.add(num.get(i));
            }else if(i % 3 == 2){
                //发给玩家3
                play3.add(num.get(i));
            }
        }

        //对玩家手上的编号排序
        Collections.sort(play1);
        Collections.sort(play2);
        Collections.sort(play3);

        //看牌 将玩家手中的编号,到Map集合中去查找
        //定义方法实现
        look("刘德华:",play1,pk);
        System.out.println("=====================");
        look("张曼玉:",play2,pk);
        System.out.println("=====================");
        look("林青霞:",play3,pk);
        System.out.println("=====================");
        look("底牌:",bottom,pk);
    }

    private static void look(String name, ArrayList<Integer> play, HashMap<Integer, String> pk) {
        System.out.print(name+" ");
        for(Integer key : play){
            String value = pk.get(key);
            System.out.print(value+" ");
        }
        System.out.println();



    }


}
