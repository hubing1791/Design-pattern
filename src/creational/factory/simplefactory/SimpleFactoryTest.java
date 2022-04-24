package creational.factory.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args){
        Application application = new Application();
        Product productB = application.getObject(1);
        productB.method1();
    }
}

class Application {
    private Product createProduct(int type){
        return SimpleFactory.createProduct(type);
    }

    Product getObject(int type){
        Product product = createProduct(type);
        return product;
    }
}