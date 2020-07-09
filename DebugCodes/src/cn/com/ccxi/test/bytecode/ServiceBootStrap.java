package cn.com.ccxi.test.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Objects;

public class ServiceBootStrap {
	public static void main(String[] args) {
		// �������²����������ڱ��ش������� com.sun.proxy.$Proxy0 ���ֽ����ļ���
		// ��������û���Ϊfalse���򲻻����ɣ�ֻ������ڴ��С�
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
