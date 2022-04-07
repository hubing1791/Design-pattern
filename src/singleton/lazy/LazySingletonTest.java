package singleton.lazy;

public class LazySingletonTest {
    public static void main(String[] args){
        //单线程的情况下,预期结果应当是true
        LazySingleton ins1 = LazySingleton.getInstance();
        LazySingleton ins2 = LazySingleton.getInstance();
        System.out.println(ins1==ins2);
    }
}
