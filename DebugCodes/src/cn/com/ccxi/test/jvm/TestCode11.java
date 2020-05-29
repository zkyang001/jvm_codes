package cn.com.ccxi.test.jvm;

class Eoo {
	public static int a = 4;
	
	static  {
		System.out.println("--Eoo--");
	}
	
	public static void doSomeThing() {
		System.out.println("do some");
	}
}

class Foo extends Eoo {
	public static int b = 5;
	static {
		System.out.println("--Foo--");
	}
}

// --Eoo--
// 4
// ===
// do some

public class TestCode11 {
	public static void main(String[] args) {
		System.out.println(Foo.a);
		System.out.println("===");
		Foo.doSomeThing();
	}

}
