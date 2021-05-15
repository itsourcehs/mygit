package cn.itcast.demo14.ThreadWaitNotify;

/**
 * @program: HelloWorld
 * @description: 对资源对象中成员变量赋值-线程1
 * 第一次赋值 张三 男  第二次赋值 lisi nv
 * @author: Mr.Huang
 * @create: 2021-05-14 22:11
 **/

public class Input implements Runnable {
    private Resource r;

    public Input(Resource r){
        this.r = r;
    }


    @Override
    public void run() {
        int i = 0;
        while (true){
            synchronized (r){
                // 标记flag为true,则等待
                if(r.flag){
                    try{r.wait();}catch (Exception ex){}
                }
                if(i%2 ==0){
                    r.name = "张三";
                    r.sex = "男";
                }else {
                    r.name = "lisi";
                    r.sex = "nv";
                }
                //将对方线程唤醒,并将标记改为true
                r.flag = true;
                r.notify();

            }
            i++;
        }

    }
}
