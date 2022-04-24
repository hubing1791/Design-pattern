package principle.liskovsubstitution.right;


public class LiskovSubstitutionRightTest {
    public static void main(String[] args) {
        Animal swallow = new Swallow();
        Animal brownKiwi = new BrownKiwi();
        swallow.setSpeed(120);
        brownKiwi.setSpeed(50);
        System.out.println("如果移动300公里：");
        try {
            System.out.println("燕子将" + swallow.moveWay()+swallow.getMoveTime(300) + "小时.");
            System.out.println("几维鸟将" +brownKiwi.moveWay() +brownKiwi.getMoveTime(300) + "小时。");
        } catch (Exception err) {
            System.out.println("发生错误了!");
        }
    }
}

//定义更一般的父类
class Animal {
    double Speed;

    public void setSpeed(double speed) {
        Speed = speed;
    }

    public double getMoveTime(double distance) {
        return (distance / Speed);
    }
    public String moveWay(){
        return "移动";
    }
}

//定义一个飞行鸟类
class FlyBird extends Animal {
    public String moveWay() {
        return "飞行";
    }
}

//燕子类
class Swallow extends FlyBird {
}

//定义一个奔跑鸟类
class RunBird extends Animal {
    public String moveWay() {
        return "奔跑";
    }
}

//几维鸟类
class BrownKiwi extends RunBird {
}

