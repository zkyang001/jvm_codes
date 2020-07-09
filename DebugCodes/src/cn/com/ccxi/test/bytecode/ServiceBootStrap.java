package cn.com.ccxi.test.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Objects;

public class ServiceBootStrap {
	public static void main(String[] args) {
		// 设置以下参数，可以在本地磁盘生成 com.sun.proxy.$Proxy0 的字节码文件，
		// 如果不设置或者为false，则不会生成，只会存在内存中。
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		ServiceInterface sInterface = Objects.requireNonNull(new ServiceImpl());
		InvocationHandler ih = new MyInvocationHandler(sInterface);
		ServiceInterface proxy = (ServiceInterface)Proxy.newProxyInstance(sInterface.getClass().getClassLoader(), 
				sInterface.getClass().getInterfaces(), ih);
		proxy.print();
		System.out.println(proxy.getClass()); // class com.sun.proxy.$Proxy0
		System.out.println(proxy.getClass().getSuperclass());// class java.lang.reflect.Proxy
	}
}
