package cn.com.ccxi.test.jvm;

/**
 * ldc:��String��int��float���͵ĳ����ӳ�������������ջ��
 * iconst_1 ������ 1 ������ջ����1-5��
 * bipush ��-128��127֮��Ķ���������������ջ��
 * sipush ����-32768~32767��֮�������������ջ��
 * �˴��漰 ���������Ż�  
 */
public class TestCode01 {
	public static void main(String[] args) {
		System.out.println(Poo.a);
	}
}
class Poo {
	public static final String a = "hello";
	
	static {
		System.out.println("��̬�����");
	}
}
