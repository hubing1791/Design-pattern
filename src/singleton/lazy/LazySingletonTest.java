package singleton.lazy;

public class LazySingletonTest {
    public static void main(String[] args){
        /*//单线程的情况下,预期结果应当是true
        LazySingleton ins1 = LazySingleton.getInstance();
        LazySingleton ins2 = LazySingleton.getInstance();
        System.out.println(ins1==ins2);

         */

        //多线程模式下会发现初始版本没有实现单例,一开始按视频里设置的睡眠时间还是太短了。
        //需要给LazySingleton
        new Thread(()->{
            LazySingleton ins3 = LazySingleton.getInstance1();
            System.out.println(ins3);
        }).start();
        new Thread(()->{
            LazySingleton ins3 = LazySingleton.getInstance1();
            System.out.println(ins3);
        }).start();
    }
}
