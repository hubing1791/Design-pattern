package structural.facade.facade;

public class Facade {
    public static void main(String[] args) {
        SystemFacade facade = new SystemFacade();
        facade.facade();
    }
}

//外观角色
class SystemFacade {
    Broom broom = new Broom();
    Kettle kettle = new Kettle();
    Computer computer = new Computer();

    public void facade() {
        broom.sweepFloor();
        kettle.boilWater();
        computer.searchVideo();
        System.out.println("开始播放电影！");
    }
}

class Computer {
    public void searchVideo() {
        System.out.println("电脑正在查找电影！");
        System.out.println("电脑查找电影完成！");
    }
}

class Kettle {
    public void boilWater() {
        System.out.println("烧水壶正在接水！");
        System.out.println("烧水壶正在烧水！");
    }
}

class Broom {
    public void sweepFloor() {
        System.out.println("扫帚正在扫地！");
    }
}

