package creational.singleton.enumsingleton;

public class EnumSingletonTest {
    public static void main(String[] args){
        EnumSingleton ins1 = EnumSingleton.INSTANCE;
        EnumSingleton ins2 = EnumSingleton.INSTANCE;
        System.out.println(ins1==ins2);
    }
}
