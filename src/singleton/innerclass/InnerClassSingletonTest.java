package singleton.innerclass;

import singleton.hungry.HungrySingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        new Thread(() -> {
            InnerClassSingleton ins3 = InnerClassSingleton.getInstance();
            System.out.println(ins3);
        } ).start();
        new Thread(() -> {
            InnerClassSingleton ins3 = InnerClassSingleton.getInstance();
            System.out.println(ins3);
        } ).start();

         //反射攻击
        Constructor<InnerClassSingleton> declaredConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton ins0 = declaredConstructor.newInstance();

        InnerClassSingleton ins1 = InnerClassSingleton.getInstance();
        System.out.println(ins1);
        System.out.println(ins0);






    }
}
