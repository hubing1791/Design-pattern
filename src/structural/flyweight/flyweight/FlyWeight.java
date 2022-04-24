package structural.flyweight.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyWeight {
    public static void main(String[] args) {
        IFlyweight flyweight1 = FlyweightFactory.getFlyweight("aa");
        IFlyweight flyweight2 = FlyweightFactory.getFlyweight("aa");
        IFlyweight flyweight3 = FlyweightFactory.getFlyweight("cc");
        flyweight1.operation("wwwww");
        flyweight2.operation("ttttt");
        flyweight3.operation("wwwww");
    }
}


//抽象享元角色

interface IFlyweight {

    void operation(String extrinsicState);

}

//具体享元角色
class ConcreteFlyweight implements IFlyweight {

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("object address: " + System.identityHashCode(this));
        System.out.println("extrinsicState: " + extrinsicState);
        System.out.println("intrinsicState: " + intrinsicState);
    }
}

//享元工厂
class FlyweightFactory {

    public static Map<String, IFlyweight> pool = new ConcurrentHashMap<>();

    public static IFlyweight getFlyweight(String intrinsicState) {
        if (!pool.containsKey(intrinsicState)) {
            IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState, flyweight);
        }
        return pool.get(intrinsicState);
    }
}


