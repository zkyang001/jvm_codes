package cn.com.ccxi.test.jvm;

import java.util.Random;

class E {
	// bipush        8
	public static final int x = 8;
	// getstatic     #22                 // Field cn/com/ccxi/test/jvm/E.y:I
	public static final int y = new Random().nextInt();
	static {
		System.out.println("A的静态代码块");
	}
}

// 主要看反编译的源码,通过反编译的源码查看是否符合常量传播优化
public class TestCode08 {
	public static void main(String[] args) {
		System.out.println(E.y);
	}
}
