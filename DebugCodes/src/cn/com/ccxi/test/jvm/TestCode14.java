package cn.com.ccxi.test.jvm;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class TestCode14 {
	public static void main(String[] args) throws IOException {
		// ��ȡ��ǰ�߳��������������
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		String resource = "cn/com/ccxi/test/jvm/TestCode13.class";
		System.out.println(contextClassLoader);// AppClassLoader -- Ĭ��ֵ
		
		Enumeration<URL> resources = contextClassLoader.getResources(resource);
		while(resources.hasMoreElements()) {
			URL nextElement = resources.nextElement();
			System.out.println(nextElement); // class�ļ���ַ
		}
		
		
		Class<?> clazz = TestCode14.class;
		System.out.println(clazz.getClassLoader());// �Զ�����ļ�����--> ϵͳ�������
		
		Class<?> clazz2 = ClassLoader.class;
		System.out.println(clazz2.getClassLoader());// ����������������÷��� null
		
	}

}
