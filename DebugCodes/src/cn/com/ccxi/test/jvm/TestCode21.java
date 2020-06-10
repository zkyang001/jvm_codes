package cn.com.ccxi.test.jvm;

import java.lang.reflect.Method;

/**
 * 该类用于测试，同一个类由不同类加载器所加载时，类型转换是否相等及是否互相可见
 * 
 * ----------------------------------------------------------------------------------------------------------
 * 双亲委托机制的好处：
 * 1、可以确保Java核心库的类型安全：所有的Java应用都至少会引用java.lang.Object类，即在运行期间，java.lang.Object类会被加载到
 *   java虚拟机中，如果加载过程可以被自定义的类加载器完成，那么在JVM虚拟机中会存在多个版本的java.lang.Object类，并且互相之间不可兼容，
 *   不可见（由于命名空间不同）
 * 2、确保Java核心类库所提供的类不会被自定义的类所替代
 * 3、不同的类加载器可以为相同名称的类（binary name）创建不同的命名空间。相同名称的类可以并存在Java虚拟机中，只需要不同的类加载器去加载
 *   即可。不同类加载器所加载的类之间是不兼容的。这就相当于在Java虚拟机中，创建了多个相互隔离的java类空间，这类技术在很多框架中都得到了应用.
 * @author 86135
 *
 */
public class TestCode21 {
    
    /**
     * 指定自定义类加载的加载路径 D:\\test\\jvm\\，并删除AppClassLoader对应环境变量下的class文件
     * clazz1 == clazz2 为false，因为两者是由自定义的类加载器loader1和loader2加载，命名空间不同，两个类不可见，所以不想等。
     * method.invoke(object1, object2); 会报错，报错代码  this.myPerson = (MyPerson)myPerson;
     * 因为两者的命名空间不同，所以互相不可见，在方法区中是两个不同的Class对象，所以类型强制转换的时候会报错。
     * ----------------------------------------------------------------------------------------------------------1
     * ==>自定义的类加载器被执行<==
     * ==>自定义的类加载器被执行<==
     * false
     * Exception in thread "main" java.lang.reflect.InvocationTargetException
     * ....
     * Caused by: java.lang.ClassCastException: cn.com.ccxi.test.jvm.MyPerson cannot be cast to cn.com.ccxi.test.jvm.MyPerson
     * ---------------------------------------------------------------------------------------------------------- 2
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
