package creational.singleton.innerclass;

public class InnerClassSingleton {
    private  static  class  InnerClassHolder{
        public static InnerClassSingleton instance = new InnerClassSingleton();
    }
    private InnerClassSingleton(){
        //防止利用反射加载多个实例
        if (InnerClassHolder.instance!= null){
            throw new RuntimeException("单例不允许多个实例");
        }
    }
    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }
}
