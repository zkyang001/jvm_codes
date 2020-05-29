package cn.com.ccxi.test.jvm;

/**
 * 1���ڴ�������ʵ����ʱ�򣬲�����������Ԫ�����͵ĳ�ʼ��
 * 	��������ʵ����ʱ�����������ʽ�Ĵ���һ��[cn.com.ccxi.test.jvm.Parent04���࣬
 * 	����Ƕ�ά�����飬�ᴴ��[[cn.com.ccxi.test.jvm.Parent04����
 * 	�������飬������������������͵ĸ��඼��java.lang.Object��
 * 	��������ָ���ǣ�������ȥ��һ��ά�Ⱥ������
 * 
 * --anewarray--����һ���������͵����飬������ѹ��ջ��
 * --newarray---����һ��ԭʼ����(int, shor, byte)�����飬������ѹ��ջ��
 * --multianewarray--- ����һ����ά�ȵ����飬������ѹ��ջ��
 * @author yang_zk
 *
 */
public class TestCode04 {

	public static void main(String[] args) {
		Parent04 p1 = new Parent04(); // --��ʼ��
		Parent04[] ps = new Parent04[23]; // ��������Parent04��ĳ�ʼ��
		Parent04[][] pss = new Parent04[3][4];// ��������Parent04�ĳ�ʼ��
		System.out.println(ps.getClass()); // class [Lcn.com.ccxi.test.jvm.Parent04
		System.out.println(ps.getClass().getSuperclass()); // class java.lang.Object
		System.out.println(ps.getClass().getSuperclass().getSuperclass()); // null
		System.out.println(pss.getClass()); // class [[Lcn.com.ccxi.test.jvm.Parent04;
		System.out.println(pss.getClass().getSuperclass());// class java.lang.Object
		
		int[] a = new int[4];
		System.out.println(a.getClass()); // class [I
		Integer[] aa = new Integer[4];
		System.out.println(aa.getClass()); // class [Ljava.lang.Integer;
		
		byte[] b = new byte[3];
		System.out.println(b.getClass()); // class [B
		Byte[] bb = new Byte[3];
		System.out.println(bb.getClass()); // class [Ljava.lang.Byte;
		
		int[][] t1 = new int[2][2]; // multianewarray
		int[][][] t2 = new int[2][2][4]; // multianewarray
		
	}
}


class Parent04 {
	
	static {
		System.out.println("---Parent04----��ʼ��");
	}
	
}
