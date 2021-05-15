package cn.itcast.demo14.ThreadWaitNotify;

/**
 * @program: HelloWorld
 * @description: 对资源对象Resource中成员变量输出打印-线程2
 * @author: Mr.Huang
 * @create: 2021-05-14 22:20
 **/

public class Output implements Runnable{
    private Resource r;

    public Output(Resource r){
        this.r = r;
    }

    @Override
    public void run() {
        while (true){
            synchronized (r){
                //判断标记,是false则等待
                if(!r.flag){
                    try{r.wait();}catch (Exception ex){}
                }
                System.out.println(r.name+".."+r.sex);
                //将标记改为false,唤醒对方线程
                r.flag = false;
                r.notify();
            }
        }
    }
}
