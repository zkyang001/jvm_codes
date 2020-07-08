package cn.com.ccxi.test;

public class TestOq3 {
	public static void main(String[] args) {
		System.out.println(Child3.b);
	}
}

interface Parent09 {
	String a = "2"; 
}

class Child3 implements Parent09{
	public static String b = "3";
}
