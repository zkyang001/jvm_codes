package cn.com.ccxi.test.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestCode16_Revise extends ClassLoader {
	
	private String classLoaderName;
	
	private String rootPath;
	
	private final String SUFFIX = ".class";
	
	public TestCode16_Revise(String classLoaderName) {
		super();
		this.classLoaderName = classLoaderName;
	}
	
	public TestCode16_Revise(String classLoaderName, ClassLoader parent) {
		super(parent);
		this.classLoaderName = classLoaderName;
	}
	
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException {
	    System.out.println("---自定义的累加器被执行-----");
		byte[] bytes = loadClassData(className);
		return defineClass(className, bytes, 0, bytes.length);
	}

	private byte[] loadClassData(String className) {
		className = className.replace(".", "\\");
		InputStream is = null;
		byte[] bytes = null;
		ByteArrayOutputStream baos = null;
		try {
			String path = rootPath + className + SUFFIX;
			is = new FileInputStream(new File(path));
			baos = new ByteArrayOutputStream();
			
			int len;
			while(-1 != (len = is.read())) {
				baos.write(len);
			}
			bytes = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				baos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bytes;
	}
	
	public static void main(String[] args) throws Exception {
		TestCode16_Revise testCode16 = new TestCode16_Revise("loder1"); //����Ϊnull�����������Ϊ��
		//testCode16.setRootPath("D:\\github\\DebugCodes\\bin\\cn\\com\\ccxi\\test\\jvm\\");
		testCode16.setRootPath("D:\\test\\jvm\\");
		Class<?> clazz = testCode16.loadClass("cn.com.ccxi.test.jvm.TestCode01");
		System.out.println(clazz + "@@" + clazz.hashCode());
		System.out.println(clazz.getClassLoader());
		Object object = clazz.newInstance();
		System.out.println(object);
		testCode16 = null;
		clazz = null;
		object = null;
		
		System.out.println("=====================================================");
		TestCode16_Revise testCode1601 = new TestCode16_Revise("loder2");
		//testCode1601.setRootPath("D:\\github\\DebugCodes\\bin\\cn\\com\\ccxi\\test\\jvm\\");
		testCode1601.setRootPath("D:\\test\\jvm\\");
		Class<?> clazz1 = testCode1601.loadClass("cn.com.ccxi.test.jvm.TestCode01");
		System.out.println(clazz1 + "@@" + clazz1.hashCode());
		System.out.println(clazz1.getClassLoader());
		System.out.println(clazz1.newInstance());
		
//		System.out.println("=====================================================");
//		TestCode16_Revise testCode1602 = new TestCode16_Revise("loder3", testCode16);
//		testCode1602.setRootPath("D:\\test\\");
//		Class<?> clazz2 = testCode1602.loadClass("cn.com.ccxi.test.jvm.TestCode01");
//		System.out.println(clazz2 + "@@" + clazz2.hashCode());
//		System.out.println(clazz2.getClassLoader());
//		System.out.println(clazz2.newInstance());
		
	}
	

}
