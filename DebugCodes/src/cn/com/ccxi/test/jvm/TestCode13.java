package cn.com.ccxi.test.jvm;

// ϵͳ�������
// ��չ�������
// null (�����������)
public class TestCode13 {
	
	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println(classLoader);

		while(classLoader != null) {
			classLoader = classLoader.getParent();
			System.out.println(classLoader);
		}
		
	}
}
