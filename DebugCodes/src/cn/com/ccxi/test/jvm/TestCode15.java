package cn.com.ccxi.test.jvm;

public class TestCode15 {
	
	public static void main(String[] args) {
		String[] arys1 = new String[2];
		System.out.println(arys1.getClass().getClassLoader()); // null，代表启动类加载器
		
		System.out.println("----------------");
		
		TestCode15[] arys2 = new TestCode15[3];
		System.out.println(arys2.getClass().getClassLoader());// AppClassLoader 系统类加载器
		
		System.out.println("----------------");
		
		int[] arys3 = new int[4];
		System.out.println(arys3.getClass().getClassLoader());// null 没有类加载器
		
		System.out.println("----------------");
		
		Integer[] arys4 = new Integer[5];
		System.out.println(arys4.getClass().getClassLoader()); // null，启动类加载器
		
		
		
	}

}
