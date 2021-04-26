package com.company.DemoBook;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class Main {
    private  static Views v = new Views();
    private static ExpressDao dao = new ExpressDao();

    //程序入口
    public static void main(String[] args) throws
            IOException,ClassNotFoundException {
        //二维数组表示快递柜
        boolean[][] cabinet = new boolean[10][];
        //HashMap表示快递柜
        HashMap<Integer,Express> data;
        //存放所有快递信息
        Collection<Express> expresses;
        for(int i =0;i<10;i++){
            cabinet[i] = new boolean[10];

        }
        //当前快递存储数量 初始化0
        int size = 0;
        try(FileInputStream fis = new
                FileInputStream("SerializedData.txt")){
            ObjectInputStream ois = new
                    ObjectInputStream(fis);
            data = (HashMap<Integer,Express>) ois.readObject();
            ois.close();
        }catch (IOException e ){
            data = new HashMap<>();
        }
        expresses = data.values();
        for(Express e : expresses){
            cabinet[e.posX][e.posY] = true;
        }
        m:
        while (true){
            //调用身份选择菜单
            int menu = v.menu();
            switch (menu){
                case 0:
                    break m;
                case 1:
                    //调用管理员客户端
                    adminClient(data.size(),cabinet,data);
                    break;
                case 2:
                    //调用用户客户端
                    userClient(data.size(), cabinet,data);
                    break;
            }
        }
        FileOutputStream fos = new
                FileOutputStream("SerializedData.txt");
        ObjectOutputStream oos = new
                ObjectOutputStream(fos);
        oos.writeObject(data);
        oos.close();
    }


    public static void userClient(int size,
                                   boolean[][] cabinet,
                                   HashMap<Integer,Express> data){
        //获取所有快递对象,方便遍历
        Collection<Express> expresses = data.values();
        //获取取件码
        int code = Views.userMenu();
        //根据取件码取出快递
        Express e = ExpressDao.findByCode(code,expresses);
        if(e == null){
            v.printNull();
        }else {
            v.success();
            v.printExpress(e);
            dao.delete(e,cabinet,data);
        }

    }

    public static void adminClient(int size,
                                   boolean[][] cabinet,
                                   HashMap<Integer,Express> data){
        while (true){
            int menu = v.adminMenu();
            switch (menu){
                case 0:
                return;
                case 1:{ //录入快递
                    //提示输入快递信息
                    Express e =v.addExpress();
                    //此快递是否已经存储过了
                    Express e2 = dao.findByNumber(e.getNumber(),
                            data.values());
                    //存储快递
                    if(e2 == null){
                        dao.add(e,cabinet,data);
                        v.printCode(e);
                    }else {
                        v.expressExist();
                    }
                    break;
                }
                case 2:{ //修改快递
                    //1.提示输入快递信息
                    String number = v.findByNumber();
                    //2.查找数据
                    Express e1 = dao.findByNumber(number, data.values());
                    //3.打印快递信息
                    if(e1 == null){
                        v.printNull();
                    }else {
                        v.printExpress(e1);
                        //4.提示修改
                        v.updateExpress(e1); //修改过了
                        //强调 删除 --> 修改的过程
                        dao.update(e1,e1,cabinet,data);
                        v.printExpress(e1);
                    }
                    break;
                }
                case 3:{//删除
                    //1.输入快递单号
                    String number = v.findByNumber();
                    //2.查找快递对象
                    Express e = dao.findByNumber(number,
                            data.values());
                    if(e == null){
                        v.printNull();
                    }else {
                        v.printExpress(e);
                        int type = v.confirmDelete();
                        if(type == 1){
                            dao.delete(e,cabinet,data);

                        }else {
                            v.success();
                        }
                    }
                    break;
                }
                case 4:{//查看所有
                    //在视图层展示
                    v.printAll(data.values());
                    break;
                }
            }
        }

    }
}
