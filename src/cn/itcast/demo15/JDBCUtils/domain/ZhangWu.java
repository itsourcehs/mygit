package cn.itcast.demo15.JDBCUtils.domain;

/**
 * @program: HelloWorld
 * @description:
 * @author: Mr.Huang
 * @create: 2021-05-15 13:42
 **/

public class ZhangWu {
    private int id;
    private String zname;
    private double zmoney;

    public ZhangWu(){}

    public ZhangWu(int id, String zname, double zmoney) {
        this.id = id;
        this.zname = zname;
        this.zmoney = zmoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }

    public double getZmoney() {
        return zmoney;
    }

    public void setZmoney(double zmoney) {
        this.zmoney = zmoney;
    }

    @Override
    public String toString() {
        return "ZhangWu{" +
                "id=" + id +
                ", zname='" + zname + '\'' +
                ", zmoney=" + zmoney +
                '}';
    }
}
