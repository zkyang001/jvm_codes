package cn.com.ccxi.test.jvm;

import java.util.Random;

/**
 * 接口中的属性默认是 public static final 的，依照阿里代码规范，省略修饰词
 * 接口中的属性无法被赋值, Child05.b = 11 //禁止赋值，因为是final
 * -----------可以根据 thread里面的打印值确定，有没有被初始化--------------
 * 当一个接口被初始化的时候，其父接口不会被初始化；
 * 只有在真正使用到父类接口的时候（调用父类中定义的常量，且此产量是在运行期确定的），才会被初始化
 * 接口中，变量默认是 public static final
 * 接口中，方法默认是 public abstract
 * 
 * @author yang_zk
 *
 */
public class TestCode05 {
	public static void main(String[] args) {
		System.out.println(Child05.c);
	}
}

interface Parent05 {
	int a = (int)System.currentTimeMillis();
	int c = 9;
	Thread thread = new Thread(){{
		System.out.println(" -- Parent05被执行--");
	}};
}

interface Child05 extends Parent05 {
	int b = new Random().nextInt();
	Thread thread = new Thread(){{
		System.out.println(" -- Child05被执行--");
	}};
}

interface Po {
	int y = 0;
}
