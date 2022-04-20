package creational.pattern.singleton.enumsingleton;

public enum EnumSingleton {
    INSTANCE;
    public void print(){
        System.out.println(this.hashCode());
    }
}
