package cn.com.ccxi.test.jvm;

/**
 * �����ڱ����ڼ��޷�ȷ��ֵ�ó�����java��������������ڼ�ȷ��������ֵ��
 * ���ڵ��ó������࣬����������ڼ䣬������ȥ���ö����ࣨParent03���ĳ�������˻���������ĳ�ʼ��
 * ������⣬��ʱ���������ÿ�����Ϊ�˳�������Ҳ��static������̬�ģ����������ĳ�ʼ��
 * @author yang_zk
 *
 */
public class TestCode03 {
	public static void main(String[] args) {
		System.out.println(Parent03.constant);
		System.out.println(Parent03.constant);
	}
}

class Parent03 {
	public static final String constant = String.valueOf(System.currentTimeMillis());
	static {
		System.out.println("parent is inited");
	}
}
