package creational.pattern.prototype.deepcopy;

public class DeepCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProductInfo productInfo = new ProductInfo("好吃的很");
        Product product = new Product("西瓜",productInfo);
        Product clone = product.clone();
        product.getInfo().setInfo("不好吃");
        System.out.println(product);
        System.out.println(clone);
    }
}

class ProductInfo implements Cloneable {
    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    public ProductInfo(String info) {
        this.info = info;
    }

    @Override
    protected ProductInfo clone() throws CloneNotSupportedException {
        return (ProductInfo) super.clone();
    }

    @Override
    public String toString() {
        return this.info;
    }
}

class Product implements Cloneable {
    private String name;
    private ProductInfo info;

    public Product(String name, ProductInfo info) {
        this.name = name;
        this.info = info;
    }

    public void setInfo(ProductInfo info) {
        this.info = info;
    }

    public ProductInfo getInfo() {
        return info;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        Product clone = (Product) super.clone();
        ProductInfo cloneInfo = this.info.clone();
        clone.setInfo(cloneInfo);
        return clone;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode())+
                "\nproduct name:"+this.name +"\tinfo:"+this.info.toString()+
                "@"+Integer.toHexString(this.info.hashCode());
    }
}
