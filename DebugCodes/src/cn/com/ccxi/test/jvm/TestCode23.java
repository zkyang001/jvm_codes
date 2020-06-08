package cn.com.ccxi.test.jvm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 1、在java运行期间，一个类的唯一性是由类本身（binary name）和加载该类的定义类加载器共同确定的（class loader）
 * 如果一个类由两个不同的类加载器加载，即便是类的加载路径相同，他们在虚拟机中也属于两个不同的类。即便.class相同，并且从相同的位置加载也是如此。
 * 
 * 2、如果修改启动类加载器的加载路径，如在命令端执行  java -Dsun.boot.class.path=./ cn.com.ccxi.test.jvm.TestCode23会报错
 * 因为 java.lang.Object作为所有类的父类，其本身是由启动类加载器加载的，修改启动类加载器的路径后，无法加载该类
 * ----------------------------------------------------------------------------------------------------------------------
 * Error occurred during initialization of VM
 * java/lang/NoClassDefFoundError: java/lang/Object
 * ----------------------------------------------------------------------------------------------------------------------
 * @author 86135
 *
 */
public class TestCode23 {
    
    public static void main(String[] args) {
        /**
         * 启动类加载器
         * 1、关于启动类加载器：
         *  a:启动类加载器是虚拟机中内置的机器码，即由C++编写的，在JVM启动时，负责加载ClassLoader类和其他平台相关的Java类
         *    作为类加载器的入口，它也会加载扩展类加载器和系统类加载器
         *  b:启动类加载器不是Java类，其他加载器是java类
         *    自动类加载器是特定于平台的机器指令，负责开启类加载的过程
         *  c:启动类加载器除了负责加载各种Java类的加载器之外，还负责加载与jre运行相关的各种基本组件，以及与虚拟机自身运行相关的各种依赖包。
         */
        System.out.println(System.getProperty("sun.boot.class.path"));
        /**
         * 扩展类加载器
         */
        System.out.println(System.getProperty("java.ext.dirs"));
        /**
         * 系统类加载器
         */
        System.out.println(System.getProperty("java.class.path"));
        
        /**
         * 间隔符
         */
        System.out.println("--------------------------------------------------------------------------");
        
        /**
         * 1、在不指定 java.system.class.loader 的数值之前， 默认的系统类加载器是AppClassLoader，如eclipse启动下查看控制台打印
         * --------------------------------------------------------------------------------------------------------------------------------------1
         * null
         * sun.misc.Launcher$AppClassLoader@337b5179
         * sun.misc.Launcher$AppClassLoader@337b5179
         * --------------------------------------------------------------------------------------------------------------------------------------1
         * 
         * 2、在命令端启动时， 通过指定 java.system.class.loader，查看打印结果
         * 报错的原因是，如果要给 java.system.class.loader指定某个自定义类加载器作为参数的话，
         * 此自定义类加载器中必须包含一个参数为ClasssLoader的构造函数，以此实现双亲委托机制 
         * --------------------------------------------------------------------------------------------------------------------------------------2
         * java -Djava.system.class.loader=cn.com.ccxi.test.jvm.TestCode16_Revise cn.com.ccxi.test.jvm.TestCode23
         * Error occurred during initialization of VM
         * java.lang.Error: java.lang.NoSuchMethodException: cn.com.ccxi.test.jvm.TestCode16_Revise.<init>(java.lang.ClassLoader)
         * --------------------------------------------------------------------------------------------------------------------------------------2
         * 
         * 3、在TestCode16_Revise自定义类中，添加参数为ClassLoader的构造函数，
         * 客户端运行查看结果：  java -Djava.system.class.loader=cn.com.ccxi.test.jvm.TestCode16_Revise cn.com.ccxi.test.jvm.TestCode23
         * 结果可以看到 ClassLoader.getSystemClassLoader()中系统类加载器已经变成了我们自定义的类加载器
         * --------------------------------------------------------------------------------------------------------------------------------------3 
         * cn.com.ccxi.test.jvm.TestCode16_Revise
         * sun.misc.Launcher$AppClassLoader@4335236e
         * cn.com.ccxi.test.jvm.TestCode16_Revise@40f186b8
         * --------------------------------------------------------------------------------------------------------------------------------------3
         */
        System.out.println(System.getProperty("java.system.class.loader"));
        
        System.out.println(TestCode23.class.getClassLoader());
        
        System.out.println(ClassLoader.getSystemClassLoader());
    }

}
