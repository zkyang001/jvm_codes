package cn.com.ccxi.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TestOq2 {
	public static void main(String[] args) {
		System.out.println(child.b);
	}
}

interface parent {
	int a = new Random().nextInt();
	Map map = new HashMap(){{
		System.out.println(111);
	}};
}
class child extends Object {
	public static int b = 5;
}
class Object{
	static {
		System.out.println(33);
	}
}