package creational.pattern.prototype.shallowcopy;

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product product = new Product("s1","s2","s3");
        Product clone = product.clone();
        System.out.println(clone);
        System.out.println(product);

        clone.changeStr1("ssssss1");
        System.out.println(clone);
        System.out.println(product);
    }
}


// 通过继承使得方法可以实现浅克隆
class Product implements Cloneable {
    private  String str1;
    private  final String str2;
    private  final String str3;

    public Product(String str1, String str2, String str3) {
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    public void changeStr1(String str){
        this.str1 = str;
    }


    @Override
    public String toString() {
        return  getClass().getName() + "@" + Integer.toHexString(hashCode())+"\tstrs:"+str1 + "\t"+str2+"\t"+str3;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        return (Product)super.clone();
    }
}
