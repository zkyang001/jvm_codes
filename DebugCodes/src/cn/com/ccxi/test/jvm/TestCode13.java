package cn.com.ccxi.test.jvm;

// 系统类加载器
// 扩展类加载器
// null (启动类加载器)
public class TestCode13 {
	
	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println(classLoader);

		while(classLoader != null) {
			classLoader = classLoader.getParent();
			System.out.println(classLoader);
		}
		
	}
}
