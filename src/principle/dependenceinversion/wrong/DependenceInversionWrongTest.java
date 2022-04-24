package principle.dependenceinversion.wrong;

//如果张三有一天要开大众, 还要增加一个大众车类, 同时还得挂载司机名下.
//不是所有的人都要开奔驰, 开宝马. 开大众.

public class DependenceInversionWrongTest {
        public static void main(String[] args) {
        Benz benz = new Benz();
        BM bm = new BM();
        Driver driver = new Driver("张三");
        driver.driver(benz);
        driver.driver(bm);
    }
}

class Benz {
    public void run() {
        System.out.println("奔驰跑起来了!");
    }
}

class BM {
    public void run() {
        System.out.println("宝马跑起来了!");
    }
}

class Driver {
    private String name;
    public Driver(String name) {
        this.name = name;
    }

    public void driver(Benz benz) {
        benz.run();
    }

    public void driver(BM bm) {
        bm.run();
    }

}