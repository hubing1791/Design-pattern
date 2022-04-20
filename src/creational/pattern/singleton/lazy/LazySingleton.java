package creational.pattern.singleton.lazy;

public class LazySingleton {
    //关于为什么用volatile，getInstance1下面的注释
    private volatile static  LazySingleton instance;
    private  LazySingleton(){

    }
    //在方法上加synchronized会造成没必要的加锁，这个方法解决了问题，但是影响了性能
    public synchronized static LazySingleton getInstance(){
        if (instance==null){
            //java的Thread.sleep()需要抛出中断异常让代码具有响应中断信号的能力
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return  instance;
    }

    //在方法上加synchronized会造成没必要的加锁，这个方法解决了问题，但是影响了性能
    public static LazySingleton getInstance1(){
        if (instance==null){
            //判断为空才需要加锁
            synchronized (LazySingleton.class){
                //再次判断为空才需要新建实例
                if (instance ==null){
                    instance = new LazySingleton();
                }
                /* 字节码层
                JIT.CPU
                1.分配空间
                2.初始化
                3.引用赋值
                2.3在编译时可能会指令重排，在单线程时没有影响。
                但是多线程时，如果2.3颠倒了。A线程已经先引用赋值了，
                但还没有初始化。B线程此时刚好走到了检查instance的时候，发现不为空
                直接返回，但是实际上instance还没初始化，就会引起空指针问题

                 */
            }
        }
        return  instance;
    }

}
