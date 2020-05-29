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
		// �˴������Ǽ��أ�����������ĳ�ʼ��
		Class<?> loadClass = systemClassLoader.loadClass("cn.com.ccxi.test.jvm.Goo");
		System.out.println(loadClass);
		
		System.out.println("===");
		// �����������ʹ�ø��࣬�������ĳ�ʼ��
		Class<?> clazz = Class.forName("cn.com.ccxi.test.jvm.Goo");
		System.out.println(clazz);
		
	}

}
