package cn.com.ccxi.test.jvm;

import java.util.UUID;

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
	}
}
class Parent03 {
	public static final String constant = UUID.randomUUID().toString();
	static {
		System.out.println("parent03 is inited");
	}
}