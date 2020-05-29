package cn.com.ccxi.test.jvm;

public class TestCode02 {
	public static void main(String[] args) {
		System.out.println(Child.n);
	}
}

class Parent {
	public static String a = "hello";
	static {
		System.out.println("parent");
	}
}
class Child extends Parent {
	public static String n = "hello";
	static {
		System.out.println("child");
	}
	
}