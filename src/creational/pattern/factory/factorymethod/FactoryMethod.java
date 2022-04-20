package creational.pattern.factory.factorymethod;

public class FactoryMethod {
    public static void main(String[] args) {
        AbstractFactory abs1 = new FactoryA();
        Product pr1 = abs1.newProduct();
        pr1.method1();
        AbstractFactory abs2 = new FactoryB();
        Product pr2 = abs2.newProduct();
        pr2.method1();
    }
}

// 产品的抽象接口
interface Product {
    void method1();
}

//具体产品
class ProductA implements Product {
    public void method1(){
        System.out.println("productA.method1 executed");
    }
}

//具体产品
class ProductB implements Product {
    public void method1(){
        System.out.println("productB.method1 executed");
    }
}

// 抽象工厂
interface AbstractFactory {
    public Product newProduct();
}

// 具体工厂
class FactoryA implements AbstractFactory{

    @Override
    public Product newProduct() {
        return new ProductA();
    }
}

//具体工厂
class FactoryB implements AbstractFactory{

    @Override
    public Product newProduct() {
        return new ProductB();
    }
}


