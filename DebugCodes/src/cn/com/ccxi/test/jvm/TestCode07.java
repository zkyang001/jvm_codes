package cn.com.ccxi.test.jvm;

public class TestCode07 {
	public static void main(String[] args) throws ClassNotFoundException {
		// 启动类加载器加载java.lang.String, 其引用返回为 null
		Class<?> clazz = Class.forName("java.lang.String");
		System.out.println(clazz.getClassLoader());// null
		
		// 系统类加载器 ApplicationClassLoader是个内部类
		Class<?> clazz2 = Class.forName("cn.com.ccxi.test.jvm.A");
		System.out.println(clazz2.getClassLoader());// sun.misc.Launcher$AppClassLoader@2fdb3aac
	}

}

class A{
	
}
