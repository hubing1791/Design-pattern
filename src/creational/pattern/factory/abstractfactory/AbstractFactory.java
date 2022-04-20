package creational.pattern.factory.abstractfactory;

public class AbstractFactory {
    public static void main(String[] args) {
        Factory greeFactory = new Gree();
        Refrigerator greeF = greeFactory.getRefrigerator();
        Television greeT = greeFactory.getTelevision();
        greeF.refrigerate();
        greeT.showTV();
    }
}

// 产品的抽象接口
interface Refrigerator {
    void refrigerate();
}

// 产品的抽象接口
interface Television {
    void showTV();
}

// 工厂的抽象接口
interface Factory {
    Refrigerator getRefrigerator();
    Television getTelevision();
}

class HaierRefrigerator implements Refrigerator{

    @Override
    public void refrigerate() {
        System.out.println("haier cold");
    }
}

class HaierTelevision implements Television{

    @Override
    public void showTV() {
        System.out.println("haier show");
    }
}

class GreeRefrigerator implements Refrigerator{

    @Override
    public void refrigerate() {
        System.out.println("gree cold");
    }
}

class GreeTelevision implements Television{

    @Override
    public void showTV() {
        System.out.println("gree show");
    }
}

class Gree implements Factory{

    @Override
    public Refrigerator getRefrigerator() {
        return new GreeRefrigerator();
    }

    @Override
    public Television getTelevision() {
        return new GreeTelevision();
    }
}

class Haier implements Factory{

    @Override
    public Refrigerator getRefrigerator() {
        return new HaierRefrigerator();
    }

    @Override
    public Television getTelevision() {
        return new HaierTelevision();
    }
}