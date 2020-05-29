package cn.com.ccxi.test.jvm;

class Goo {
	
	static {
		System.out.println("---Goo---");
	}
}

// cn.com.ccxi.test.jvm.Goo
// ===
// ---Goo---
// cn.com.ccxi.test.jvm.Goo

public class TestCode12 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		// 此处仅仅是加载，不会引起类的初始化
		Class<?> loadClass = systemClassLoader.loadClass("cn.com.ccxi.test.jvm.Goo");
		System.out.println(loadClass);
		
		System.out.println("===");
		// 反射调用主动使用该类，引起该类的初始化
		Class<?> clazz = Class.forName("cn.com.ccxi.test.jvm.Goo");
		System.out.println(clazz);
		
	}

}
