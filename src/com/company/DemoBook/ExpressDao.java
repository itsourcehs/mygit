package com.company.DemoBook;

import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class ExpressDao {
    static Random random = new Random();
    /*
     * 存快递
     * 参数
     */
    public boolean add(Express e , boolean[][] cabinet,
                              HashMap<Integer,Express> data){
        //随机数

        int size = data.size();
        //判断是否存满
        if(size >= 100){
            return false;
        }
        int x = -1,y = -1;
        while (true) {
            x = random.nextInt(10);
            y = random.nextInt(10);
            if (cabinet[x][y] == false) {
                break;
            }
        }
        //获取未重复的取件码
        int code = randomCode(data.values());
        e.setCode(code);
        e.posX = x; //快递存放位置
        e.posY = y;
        size++; // 快递数+1
        cabinet[x][y] = true; // 此位置已被占用
        data.put(code,e);
        return true;
    }

    public static int randomCode(Collection<Express> expresses) {
        while (true){
           int code = random.nextInt(900000)+100000;
           Express e = findByCode(code,expresses);
           if (e == null){
               return code;
           }
        }
    }

    public static Express findByCode(int code,Collection<Express> expresses) {
        for(Express e : expresses) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
        }

    public Express findByNumber(String number,Collection<Express> expresses){
        for (Express e : expresses){
            if(e.getNumber().equals(number)){
                return e;
            }
        }
        return null;
    }


    public void update(Express oldExpress, Express newExpress,
                       boolean[][] cabinet,
                       HashMap<Integer,Express> data) {
        delete(oldExpress,cabinet,data);
        add(newExpress,cabinet,data);
    }

    public void delete(Express e, boolean[][] cabinet, HashMap<Integer,Express> data) {
        data.remove(e.getCode());
        cabinet[e.posX][e.posY] = false;
    }










}
