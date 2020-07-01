package cn.com.ccxi.test.jvm;

public class TestCode02 {
	public static void main(String[] args) {
		System.out.println(Child.n);
	}
}
class Parent {
	public static String a = "parent str ==";
	static {
		System.out.println("parent init");
	}
}
class Child extends Parent {
	public static String n = "child str ==";
	static {
		System.out.println("child init");
	}
}