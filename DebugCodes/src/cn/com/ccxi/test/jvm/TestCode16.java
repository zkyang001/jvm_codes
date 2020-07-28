package cn.com.ccxi.test.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestCode16 extends ClassLoader{
    
    private String classLoaderName;
    
    private static final String SUFFIX = ".class";
    
    public TestCode16(String classLoaderName) {
        super(); // 这里使用 getSystemClassLoader() 获取到系统类加载器作为本类的父类加载器
        this.classLoaderName = classLoaderName;
    }
    
    public TestCode16(String classLoaderName, ClassLoader parent) {
        super(parent); // 自定义的父类加载器
        this.classLoaderName = classLoaderName;
    }
    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }
    
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] bytes = loadClassData("D:/develop/CCXI/DebugCodes/bin/cn/com/ccxi/test/jvm/TestCode01");
        Class<?> clazz = defineClass(className, bytes, 0, bytes.length);
        return clazz;
    }
    
    
    public byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] bytes = null;
        ByteArrayOutputStream baos = null;
        try {
            name = name.replaceAll("\\.", "/");
            is = new FileInputStream(name + SUFFIX);
            baos = new ByteArrayOutputStream();
            int len = -1;
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
    private static Object test01(ClassLoader classLoader) throws Exception {
        Class clazz = classLoader.loadClass("cn.com.ccxi.test.jvm.TestCode01");
        Object newInstance = clazz.newInstance();
        return newInstance;
    }
    
    public static void main(String[] args) throws Exception {
        TestCode16 one = new TestCode16("myClassLoader");
        Class<?> clazz1 = one.findClass("cn.com.ccxi.test.jvm.TestCode01");
    }
}
