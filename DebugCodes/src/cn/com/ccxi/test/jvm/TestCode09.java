package cn.com.ccxi.test.jvm;

class Aoo{
	public static int a = 1;
	static {
		System.out.println("---Aoo---");
	}
}

class Boo extends Aoo {
	public static int b = 2;
	static {
		System.out.println("---Boo---");
	}
}

// ---TestCode09---
// ---Aoo---
// ---Boo---
// 2

public class TestCode09 {
	static {
		System.out.println("---TestCode09---");
	}
	
	public static void main(String[] args) {
		System.out.println(Boo.b);
	}
}
