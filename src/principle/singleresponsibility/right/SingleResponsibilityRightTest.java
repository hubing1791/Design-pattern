package principle.singleresponsibility.right;


public class SingleResponsibilityRightTest {
    public static void main(String[] args) {
        SweepFloor zhangSan =new ZhangSan();
        Shopping liSi =new LiSi();
        zhangSan.sweepFlooring();
        liSi.shopping();
    }

}

interface HouseWork {
}

interface Shopping extends HouseWork {
    // 购物
    void shopping();
}

interface SweepFloor extends HouseWork {
    // 扫地
    void sweepFlooring();
}

class ZhangSan implements SweepFloor{

    @Override
    public void sweepFlooring() {
        System.out.println("扫地");
    }
}

class LiSi implements Shopping{
    @Override
    public void shopping() {
        System.out.println("购物了");
    }
}