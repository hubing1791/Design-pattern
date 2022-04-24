package structural.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        DProxy dProxy = new DProxy();
        Subject subject = dProxy.getInstance(new RealSubject());
        subject.Request();
    }
}

//抽象主题
interface Subject {
    void Request();
}

//真实主题
class RealSubject implements Subject {
    public void Request() {
        System.out.println("核心过程");
    }
}

//动态代理
class DProxy implements InvocationHandler{
    private Subject subject;

    public Subject getInstance(Subject subject){
        this.subject = subject;
        Class<?> clazz = subject.getClass();
        return (Subject) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preRequest();
        Object result = method.invoke(this.subject,args);
        postRequest();
        return result;
    }

        private void preRequest() {
        System.out.println("预处理。");
    }
    private void postRequest() {
        System.out.println("后续处理。");
    }
}