package cn.com.ccxi.test.jvm;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class TestCode14 {
	public static void main(String[] args) throws IOException {
		// 获取当前线程上下文类加载器
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		String resource = "cn/com/ccxi/test/jvm/TestCode13.class";
		System.out.println(contextClassLoader);// AppClassLoader -- 默认值
		
		Enumeration<URL> resources = contextClassLoader.getResources(resource);
		while(resources.hasMoreElements()) {
			URL nextElement = resources.nextElement();
			System.out.println(nextElement); // class文件地址
		}
		
		
		Class<?> clazz = TestCode14.class;
		System.out.println(clazz.getClassLoader());// 自定义类的加载器--> 系统类加载器
		
		Class<?> clazz2 = ClassLoader.class;
		System.out.println(clazz2.getClassLoader());// 启动类加载器，引用返回 null
		
	}

}
