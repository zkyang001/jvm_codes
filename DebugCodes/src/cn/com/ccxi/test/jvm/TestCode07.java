package cn.com.ccxi.test.jvm;

public class TestCode07 {
	public static void main(String[] args) throws ClassNotFoundException {
		// ���������������java.lang.String, �����÷���Ϊ null
		Class<?> clazz = Class.forName("java.lang.String");
		System.out.println(clazz.getClassLoader());// null
		
		// ϵͳ������� ApplicationClassLoader�Ǹ��ڲ���
		Class<?> clazz2 = Class.forName("cn.com.ccxi.test.jvm.A");
		System.out.println(clazz2.getClassLoader());// sun.misc.Launcher$AppClassLoader@2fdb3aac
	}

}

class A{
	
}
