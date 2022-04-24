package structural.decorator.decorator;


// 在网上发现了一个用手抓饼作为讲解的例子很好，借鉴了代码
// https://blog.csdn.net/lena7/article/details/116354866
public class Decorator {
    public static void main(String[] args) {
        Cake cake = new HandCake();
        System.out.println("手抓饼："+cake.cost());
        Egg egg = new Egg(cake);
        System.out.println("+1个鸡蛋："+egg.cost());
        Ham ham = new Ham(egg);
        System.out.println("+1片火腿："+ham.cost());
        Becon becon = new Becon(ham);
        System.out.println("+1份培根："+becon.cost());
        Egg egg2 = new Egg(becon);
        System.out.println("再+一个鸡蛋："+egg2.cost());
        Egg egg3 = new Egg(egg2);
        System.out.println("再+一个鸡蛋："+egg3.cost());
    }
}

//抽象构件
abstract class Cake {
    abstract int cost();
}


//具体构件
class HandCake extends Cake {
    @Override
    int cost() {
        return 4;
    }
}


//抽象装饰
class Seasoning extends Cake {
    private Cake cake;
    Seasoning(Cake cake){
        this.cake=cake;
    }
    @Override
    int cost() {
        return cake.cost();
    }
}

//具体装饰
class Egg extends Seasoning {
    Egg(Cake cake) {
        super(cake);
    }
    int cost(){
        return super.cost()+2;
    }
}

class Ham extends Seasoning{
    Ham(Cake cake) {
        super(cake);
    }
    int cost(){
        return super.cost()+2;
    }
}

class Becon extends Seasoning {
    Becon(Cake cake) {
        super(cake);
    }
    int cost(){
        return super.cost()+2;
    }
}
