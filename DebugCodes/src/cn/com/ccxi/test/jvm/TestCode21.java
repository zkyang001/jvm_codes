package cn.com.ccxi.test.jvm;

import java.lang.reflect.Method;

/**
 * 该类用于测试，同一个类由不同类加载器所加载时，类型转换是否相等及是否互相可见
 * @author 86135
 *
 */
public class TestCode21 {
    
    /**
     * 指定自定义类加载的加载路径 D:\\test\\jvm\\，并删除AppClassLoader对应环境变量下的class文件
     * clazz1 == clazz2 为false，因为两者是由自定义的类加载器loader1和loader2加载，命名空间不同，两个类不可见，所以不想等。
     * method.invoke(object1, object2); 会报错，报错代码  this.myPerson = (MyPerson)myPerson;
     * 因为两者的命名空间不同，所以互相不可见，在方法区中是两个不同的Class对象，所以类型强制转换的时候会报错。
     * ----------------------------------------------------------------------------------------------------------
     * ==>自定义的类加载器被执行<==
     * ==>自定义的类加载器被执行<==
     * false
     * Exception in thread "main" java.lang.reflect.InvocationTargetException
     * ....
     * Caused by: java.lang.ClassCastException: cn.com.ccxi.test.jvm.MyPerson cannot be cast to cn.com.ccxi.test.jvm.MyPerson
     * ---------------------------------------------------------------------------------------------------------- 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TestCode16_Revise loader1 = new TestCode16_Revise("loader1");
        TestCode16_Revise loader2 = new TestCode16_Revise("loader2");
        
        loader1.setRootPath("D:\\test\\jvm\\");
        loader2.setRootPath("D:\\test\\jvm\\");
        
        Class<?> clazz1 = loader1.loadClass("cn.com.ccxi.test.jvm.MyPerson");
        Class<?> clazz2 = loader2.loadClass("cn.com.ccxi.test.jvm.MyPerson");
        
        System.out.println(clazz1 == clazz2);
        
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        
        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
        
        
    }

}
