package cn.itcast.demo03;
/*
 * 与正则表达式相关的String类方法
 * boolean matches(String 正则规则)
 * String[] split(String 正则规则)
 * String replaceAll(String 正则规则,String 字符串)
 */
public class RegexDemo {
    public static void main(String[] args) {
        //checkQQ();
        //checkMobile();
        //splitString();
        //splitString_1();
        //replace();
        checkEmail();
    }
    /*
     * 检查qq号是否合法
     * 0不能开头,全数字,位数5,10位
     */
    public static void checkQQ(){
        String qq = "12345678987";
        boolean b = qq.matches("[1-9][0-9]{4,9}");
        System.out.println(b);
    }
    /*
     * 检查手机号 1开头 34578  0-9固定11位
     */
    public static void checkMobile(){
        String mobile = "13086111112";
        boolean b = mobile.matches("1[34578][0-9]{9}");
        System.out.println(b);
    }

    /*
     * 对 12-23-23-112 切割
     */
    public static void splitString(){
        String str = "12-23-23-112";
        String [] strarr = str.split("-");
        for(int i =0;i<strarr.length;i++){
            System.out.println(strarr[i]);
        }
    }

    /*
     * 对 18  19    12       20      11切割
     * 使用X+匹配空格出现一次或多次
     */
    public static void splitString_1(){
        String str = "18  19    12       20      11";
        String [] strarr = str.split(" +");
        for(int i =0;i<strarr.length;i++){
            System.out.println(strarr[i]);
        }
    }

    /*
     * 将"hello12345world789012"中所有数字替换掉
     */
    public static void replace(){
        String str = "hello12345world789012";
        str = str.replaceAll("[0-9+]","#");
        System.out.println(str);
    }


    /*
     * 检查邮箱地址是否合法
     * 123457@qq.com
     * mymail@sina.com
     * nimai@163.com
     * wodemail@yahoo.com.cn
     */
    public static void checkEmail(){
        String email = "abc123@sina.com.cn.org";
        boolean b = email.matches("[a-zA-Z0-9_]+@[0-9a-z]+(\\.[a-z]+)+");
        System.out.println(b);
    }



}
