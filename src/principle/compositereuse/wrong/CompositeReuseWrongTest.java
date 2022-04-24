package principle.compositereuse.wrong;

public class CompositeReuseWrongTest {
    public static void main(String[] args) {
        Car c1 = new WhiteEleCar("白色电车");
        Car c2 = new WhiteGasCar("白色汽车");
        Car c3 = new BlackEleCar("黑色电车");
        Car c4 = new BlackGasCar("黑色汽车");
        c1.move();
        c2.move();
        c3.move();
        c4.move();
    }
}

abstract class Car{
    private String name;
    public Car(String name) {
        this.name = name;
    }

    public void move(){
        System.out.println(this.name+"飙起来");
    }
}

class GasCar extends Car {
    public GasCar(String name) {
        super(name);
    }
}

class EleCar extends Car {
    public EleCar(String name) {
        super(name);
    }
}

class WhiteGasCar extends GasCar{
    public WhiteGasCar(String name) {
        super(name);
    }
}

class BlackGasCar extends GasCar {
    public BlackGasCar(String name) {
        super(name);
    }
}

class WhiteEleCar extends EleCar {
    public WhiteEleCar(String name) {
        super(name);
    }
}

class BlackEleCar extends EleCar {
    public BlackEleCar(String name) {
        super(name);
    }
}