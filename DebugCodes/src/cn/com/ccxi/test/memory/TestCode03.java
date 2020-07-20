package cn.com.ccxi.test.memory;

public class TestCode03 {
	public static void main(String[] args) {
//		new Thread(() -> A.method(),  "thread-A").start();
//		new Thread(() -> B.method(),  "thread-B").start();
	}
}
class A {
	public static synchronized void method() {
		System.out.println(" class A method .");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		B.method();
	}
}
class B {
	public static synchronized void method() {
		System.out.println(" class B method .");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		A.method();
	}
}
