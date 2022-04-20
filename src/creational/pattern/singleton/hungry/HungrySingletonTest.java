package creational.pattern.singleton.hungry;

public class HungrySingletonTest {
    public static void main(String[] args){
        HungrySingleton ins1 = HungrySingleton.getInstance();
        HungrySingleton ins2 = HungrySingleton.getInstance();
        System.out.println(ins1==ins2);

        new Thread(() -> {
            HungrySingleton ins3 = HungrySingleton.getInstance();
            System.out.println(ins3);
        } ).start();
        new Thread(() -> {
            HungrySingleton ins3 = HungrySingleton.getInstance();
            System.out.println(ins3);
        } ).start();
    }

}
