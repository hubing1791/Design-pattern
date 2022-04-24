package creational.prototype.deepcopyserialization;

import java.io.*;

public class DeepCopySerialize {
        public static void main(String[] args) throws CloneNotSupportedException {
        ProductInfo productInfo = new ProductInfo("酸的");
        Product product = new Product("西瓜",productInfo);
        Product clone = product.clone();
        product.getInfo().setInfo("甜的");
        System.out.println(product);
        System.out.println(clone);
    }
}

// 类及其里面的有必要的子类都必须implements 序列化标记
class ProductInfo implements Cloneable,Serializable {
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

class Product implements Cloneable, Serializable {
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
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)){
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(byteArrayInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Product readObject = (Product)ois.readObject();
            return readObject;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode())+
                "\nproduct name:"+this.name +"\tinfo:"+this.info.toString()+
                "@"+Integer.toHexString(this.info.hashCode());
    }
}