package principle.dependenceinversion.right;

public class DependenceInversionRightTest {
    public static void main(String[] args) {
        IDriver driver = new Driver();
        driver.driver(new Benz());
        driver.driver(new BM());
    }
}

interface ICar {
    public void run();
}

class Benz implements ICar{
    public void run() {
        System.out.println("奔驰跑起来了!");
    }
}

class BM implements ICar{
    public void run() {
        System.out.println("宝马跑起来了!");
    }
}

interface IDriver {
    public void driver(ICar car);
}

class Driver implements IDriver{

    @Override
    public void driver(ICar car) {
        car.run();
    }
}