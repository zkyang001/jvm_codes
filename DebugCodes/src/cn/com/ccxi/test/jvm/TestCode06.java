package cn.com.ccxi.test.jvm;

/**
 * 以下代码的执行顺序:
 * 首先是类的加载和连接，包含准备的过程，即给所有的静态变量赋值
 * int a = 0; MyParent06 mp = null, int b = 0;
 * 在执行 MyParent06.a 时，调用了此类的静态变量，会引起类的初始化
 * 程序会按照代码上下文顺序，从上往下，依次对静态变量赋值
 * int a 没有被定义，结果还是0
 * mp 被赋值，new MyParent06(),这次会调用构造方法，a++, b++，调用后值为a = 1, b = 1
 * int b = 0, 从新被赋值为0
 * 所以，最终a = 1, b = 0
 * 
 * 如果int b = 0, 在 MyParent06 mp = new MyParent06() 代码之前，结果不一样，a = 1, b = 1
 * @author yang_zk
 *
 */
public class TestCode06 {
	public static void main(String[] args) {
	    MyParent06 instance = MyParent06.getInstance();
		System.out.println("a : " + instance.a);//1
		System.out.println("b : " + instance.b);//0
	}
}

class MyParent06 {
	public static int a;
	public static MyParent06 mp = new MyParent06();
	public static int b = 0;
	
	public MyParent06() {
		a ++ ;
		b ++ ;
	}
	
	public static MyParent06 getInstance() {
		return mp;
	}
}
