package creational.pattern.factory.simplefactory;

// 简单工厂不符合开闭原则
public class SimpleFactory {
    public static Product createProduct(int type){
        if (type == 0){
            return new ProductA();
        } else if (type == 1){
            return new ProductB();
        }else{
            return null;
        }
    }
}


// 产品的抽象接口
interface Product {
    void method1();
}

//具体产品
class ProductA implements Product{
    public void method1(){
        System.out.println("productA.method1 executed");
    }
}

//具体产品
class ProductB implements Product{
    public void method1(){
        System.out.println("productB.method1 executed");
    }
}