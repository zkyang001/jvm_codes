package cn.com.ccxi.test.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private ServiceInterface obj;
    public MyInvocationHandler(ServiceInterface obj) {
        this.obj = obj;
    };
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置功能增强。。。");
        Object invoke = method.invoke(obj, args);;
        System.out.println("后置功能增强。。。");
        return invoke;
    }
}
