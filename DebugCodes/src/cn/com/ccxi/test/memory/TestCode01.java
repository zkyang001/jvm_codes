package cn.com.ccxi.test.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM �������ã�
 * -Xms10m ��С���ڴ�
 * -Xmx10m �����ڴ� 
 * -XX:+HeapDumpOnOutOfMemoryError ���ɶ�ת���ļ�
 */
public class TestCode01 {
	public static void main(String[] args) {
		List<TestCode01> list = new ArrayList<>();
		for ( ; ; ) {
			list.add(new TestCode01());
			System.gc();
		}
	}
}
