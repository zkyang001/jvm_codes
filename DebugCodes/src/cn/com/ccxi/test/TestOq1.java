package cn.com.ccxi.test;

public abstract class TestOq1 {
	private TestOq1() {
		// TODO Auto-generated constructor stub
	}
	public TestOq1(String one) {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
	}
}
