package structural.adapter.twowayadapter;

public class TwoWayAdapter {
    public static void main(String[] args) {
        TwoWayAdaptee adaptee=new AdapteeRealize();
        TwoWayTarget target=new Adapter(adaptee);
        target.request();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
        target=new TargetRealize();
        adaptee=new Adapter(target);
        adaptee.specificRequest();
    }
}

//目标接口
interface TwoWayTarget {
    public void request();
}
//目标实现
class TargetRealize implements TwoWayTarget {
    public void request()
    {
        System.out.println("目标代码被调用！");
    }
}


//适配者接口
interface TwoWayAdaptee {
    public void specificRequest();
}
//适配者实现
class AdapteeRealize implements TwoWayAdaptee {
    public void specificRequest()
    {
        System.out.println("适配者代码被调用！");
    }
}

class Adapter  implements TwoWayTarget,TwoWayAdaptee
{
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;
    public Adapter(TwoWayTarget target)
    {
        this.target=target;
    }
    public Adapter(TwoWayAdaptee adaptee)
    {
        this.adaptee=adaptee;
    }

    //相当于装配到了一起
    public void request()
    {
        adaptee.specificRequest();
    }
    public void specificRequest()
    {
        target.request();
    }
}