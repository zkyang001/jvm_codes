package cn.com.ccxi.test.jvm;

/**
 * ���´����ִ��˳��:
 * ��������ļ��غ����ӣ�����׼���Ĺ��̣��������еľ�̬������ֵ
 * int a = 0; MyParent06 mp = null, int b = 0;
 * ��ִ�� MyParent06.a ʱ�������˴���ľ�̬��������������ĳ�ʼ��
 * ����ᰴ�մ���������˳�򣬴������£����ζԾ�̬������ֵ
 * int a û�б����壬�������0
 * mp ����ֵ��new MyParent06(),��λ���ù��췽����a++, b++�����ú�ֵΪa = 1, b = 1
 * int b = 0, ���±���ֵΪ0
 * ���ԣ�����a = 1, b = 0
 * 
 * ���int b = 0, �� MyParent06 mp = new MyParent06() ����֮ǰ�������һ����a = 1, b = 1
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
