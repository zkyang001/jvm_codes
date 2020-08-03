package cn.com.ccxi.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SamInvocationHandle implements InvocationHandler {
    private PhoneInterface phoneInterface;
    public SamInvocationHandle(PhoneInterface phoneInterface) {
        this.phoneInterface = phoneInterface;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置功能增强：检查机器情况。。。");
        Object res = method.invoke(phoneInterface, args);
        System.out.println("后置功能增强，提供维修服务。。。");
        return (int)res + 500;
    }
}
