package creational.builder.builder;

public class Builder {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.makeProduct("烤鱼", "3斤", "新鲜出锅");
        System.out.println(product);
    }
}


// 产品
class Product {
    private String pName;
    private String pWeight;
    private String pTime;

    public Product() {
    }


    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public void setpWeight(String pWeight) {
        this.pWeight = pWeight;
    }

    public String toString() {
        return "商品：" + this.pName + "\t\t重量：" + this.pWeight + "\t\t出锅时间：" + this.pTime;
    }
}

//抽象构造器
abstract class AbstractBuilder {
    protected Product product = new Product();

    abstract void buildPName(String pName);

    abstract void buildPWeight(String pWeight);

    abstract void buildPTime(String pTime);

    public Product getResult() {
        return product;
    }
}

//具体建造者
class ConcreteBuilder extends AbstractBuilder {
    @Override
    public void buildPName(String pName) {
        product.setpName(pName);
    }

    @Override
    public void buildPWeight(String pWeight) {
        product.setpWeight(pWeight);
    }

    @Override
    public void buildPTime(String pTime) {
        product.setpTime(pTime);
    }
}

// 指挥者
class Director {
    private AbstractBuilder builder;

    //提供一个构造函数
    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String pName, String pWeight, String pTime) {
        builder.buildPName(pName);
        builder.buildPWeight(pWeight);
        builder.buildPTime(pTime);
        return builder.getResult();
    }
}