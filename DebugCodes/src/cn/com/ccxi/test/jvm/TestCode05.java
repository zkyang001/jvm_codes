package cn.com.ccxi.test.jvm;

import java.util.Random;

/**
 * �ӿ��е�����Ĭ���� public static final �ģ����հ������淶��ʡ�����δ�
 * �ӿ��е������޷�����ֵ, Child05.b = 11 //��ֹ��ֵ����Ϊ��final
 * -----------���Ը��� thread����Ĵ�ӡֵȷ������û�б���ʼ��--------------
 * ��һ���ӿڱ���ʼ����ʱ���丸�ӿڲ��ᱻ��ʼ����
 * ֻ��������ʹ�õ�����ӿڵ�ʱ�򣨵��ø����ж���ĳ������Ҵ˲�������������ȷ���ģ����Żᱻ��ʼ��
 * �ӿ��У�����Ĭ���� public static final
 * �ӿ��У�����Ĭ���� public abstract
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
		System.out.println(" -- Parent05��ִ��--");
	}};
}

interface Child05 extends Parent05 {
	int b = new Random().nextInt();
	Thread thread = new Thread(){{
		System.out.println(" -- Child05��ִ��--");
	}};
}

interface Po {
	int y = 0;
}
