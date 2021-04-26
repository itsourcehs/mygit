package DemoForNote;

public class Computer {
    public void openComputer(){
        System.out.println("笔记本开机");
    }
    public void closeComputer(){
        System.out.println("笔记本关机");
    }
    //使用USB设备方法,哪个设备
    public void useUSB(USB usb){
        usb.open();
        usb.close();
    }
}
