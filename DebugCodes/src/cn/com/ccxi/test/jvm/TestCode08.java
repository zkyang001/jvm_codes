package cn.com.ccxi.test.jvm;

import java.util.Random;

class E {
	// bipush        8
	public static final int x = 8;
	// getstatic     #22                 // Field cn/com/ccxi/test/jvm/E.y:I
	public static final int y = new Random().nextInt();
	static {
		System.out.println("A�ľ�̬�����");
	}
}

// ��Ҫ���������Դ��,ͨ���������Դ��鿴�Ƿ���ϳ��������Ż�
public class TestCode08 {
	public static void main(String[] args) {
		System.out.println(E.y);
	}
}
