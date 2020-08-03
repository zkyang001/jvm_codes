package cn.com.ccxi.test.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ShopPhoneClass {
    public static void main(String[] args) {
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 创建目标对象
        PhoneInterface phoneInterface = new SamPhoneFactory();
        // 创建 调度器，传入目标对象
        InvocationHandler invocationHandle = new SamInvocationHandle(phoneInterface);
        // 创建代理对象
        PhoneInterface newProxyInstance = 
                (PhoneInterface)Proxy.newProxyInstance(phoneInterface.getClass().getClassLoader(), 
                phoneInterface.getClass().getInterfaces(), invocationHandle);
        //int sellPhone = newProxyInstance.sellPhone("S4", 1000.0, 5);
        System.out.println(newProxyInstance.hashCode());
    }
}
