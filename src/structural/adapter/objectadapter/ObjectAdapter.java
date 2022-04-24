package structural.adapter.objectadapter;

public class ObjectAdapter {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
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

class Adapter implements Target
{
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    public void request()
    {
        adaptee.specificRequest();
    }
}