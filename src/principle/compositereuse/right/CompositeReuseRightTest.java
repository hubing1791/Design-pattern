package principle.compositereuse.right;

public class CompositeReuseRightTest {
    public static void main(String[] args) {
        Colour white = new Colour("白色");
        Colour black = new Colour("黑色");
        Car c1 = new EleCar("电车", white);
        Car c2 = new GasCar("汽车", white);
        Car c3 = new EleCar("电车", black);
        Car c4 = new GasCar("汽车", black);
        c1.move();
        c2.move();
        c3.move();
        c4.move();
    }
}

abstract class Car {
    private String name;
    private Colour colour;

    public Car(String name, Colour colour) {
        this.name = name;
        this.colour = colour;
    }

    public void move() {
        System.out.println(this.colour.getColour() + this.name + "飙起来");
    }
}

class Colour {
    private String colour;

    public Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}

class GasCar extends Car {
    public GasCar(String name, Colour colour) {
        super(name, colour);
    }
}

class EleCar extends Car {
    public EleCar(String name, Colour colour) {
        super(name, colour);
    }
}