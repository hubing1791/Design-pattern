package principle.singleresponsibility.wrong;

//首先: 张三只扫地, 但是他需要重写买菜方法, 李四不需要扫地, 但是李四也要重写扫地方法.
//第二: 这也不符合开闭原则. 增加一种类型做饭, 要修改3个类. 这样当逻辑很复杂的时候, 很容易引起意外错误.

public class SingleResponsibilityWrongTest {
    public static void main(String[] args) {
        HouseWork zhangSan =new ZhangSan();
        HouseWork liSi =new LiSi();
        zhangSan.sweepFloor();
        liSi.shopping();
    }


}

interface HouseWork {
    // 扫地
    void sweepFloor();

    // 购物
    void shopping();
}

class ZhangSan implements HouseWork{
    @Override
    public void sweepFloor() {
        System.out.println("扫地了");
    }

    @Override
    public void shopping() {

    }
}

class LiSi implements HouseWork{
    @Override
    public void sweepFloor() {

    }

    @Override
    public void shopping() {
        System.out.println("购物了");
    }
}