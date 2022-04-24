package structural.adapter.classadapter;

public class ClassAdapter {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

//目标接口，也就是需要改造的接口
interface Target {
    public void request();
}


//适配者接口，可以认为是实际需要的内容
class Adaptee {
    public void specificRequest()
    {
        System.out.println("业务逻辑");
    }
}
//类适配器类
class Adapter extends Adaptee implements Target {
    public void request()
    {
        specificRequest();
    }
}
