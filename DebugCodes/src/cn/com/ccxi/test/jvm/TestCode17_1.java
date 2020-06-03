package cn.com.ccxi.test.jvm;

public class TestCode17_1 {
    
    public static void main(String[] args) throws Exception {
        TestCode16_Revise loader1 = new TestCode16_Revise("loader1");
        loader1.setRootPath("D:\\test\\jvm\\");
        Class<?> clazz = loader1.loadClass("cn.com.ccxi.test.jvm.MySample");
        
        /**
         * 1、在 D:\\test\\jvm\\ 拷贝 MySample 和 MyCat 的class文件，并删除环境变量中，原始的 MySample 和 MyCat 的class文件    
         * 打印结果是，加载的两个类都会使用自定义的类加载器 TestCode16_Revise
         * ------------------------------------------------------------------------
         * ==>自定义的类加载器被执行<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@60f38b42
         * ==>自定义的类加载器被执行<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@60f38b42
         * ------------------------------------------------------------------------------------------------------------------------------------------------1
         * 
         * 2、在 D:\\test\\jvm\\ 拷贝 MySample 和 MyCat 的class文件，并仅仅删除环境变量中原始的 MyCat 的class文件
         * 打印的结果是 MySample类可以被AppClassLoader正常加载，但是在加载Mycat类时，会报错（ClassNotFountException），
         * 因为在MySample构造函数中，会使用AppClassLoader去加载MyCat类，但是MyCat.class文件已经在classpath环境变量中被删除，所以会报错
         * ------------------------------------------------------------------------
         * sun.misc.Launcher$AppClassLoader@6521f956
         * Exception in thread "main" java.lang.NoClassDefFoundError: cn/com/ccxi/test/jvm/MyCat
         * ------------------------------------------------------------------------------------------------------------------------------------------------2
         * 
         * 3、在D:\\test\\jvm\\ 拷贝MySamle 和 MyCat 的class 文件，并仅仅删除环境变量中原始的MySample的class文件
         * 打印的结果是MySample类会被自定义的类加载器 TestCode16_Revise 加载，但是MyCat类会被AppClassLoader类加载器加载
         * 因为在MySample的构造函数中，在使用自定义类加载器去加载MyCat类时，根据双亲委托机制，自定义类加载器会委托父类加载器AppClassLoader加载器去加载
         * ------------------------------------------------------------------------
         * ==>自定义的类加载器被执行<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@60f38b42
         * sun.misc.Launcher$AppClassLoader@1978b0f9
         * ------------------------------------------------------------------------------------------------------------------------------------------------3
         * 
         * 4、关于命名空间的问题：由类加载器及其父类加载器所加载的类构成，子加载器所加载的类可以访问父加载器所加载的类，但是父加载器所加载的类是不能访问到自加载器所加载的类
         * 在MyCat构造其中 添加MySample类的调用,在 D:\\test\\jvm\\ 拷贝 MySample 和 MyCat 的class文件，并仅仅删除环境变量中的MySample.class文件
         * 结果 MySample类可以被自定义的类加载器所加载，MyCat会被AppClassLoader类加载器所加载，但是在MyCat构造器中调用MySample类时会报错，原因：
         * AppClassLoader是自定义类加载器的父类，MyCat中无法调用到子类加载器中所加载的的类，因为MySample被自加载器所加载的类，MyCat由父加载器所加载。
         * 打印结果：
         * ------------------------------------------------------------------------
         * ==>自定义的类加载器被执行<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@6c908f05
         * sun.misc.Launcher$AppClassLoader@337b5179
         * Exception in thread "main" java.lang.NoClassDefFoundError: cn/com/ccxi/test/jvm/MySample
         * ------------------------------------------------------------------------------------------------------------------------------------------------4
         * 
         * 5、注释掉MyCat中对MySample的引用，而在MySample中添加对MyCat的引用
         * 在 D:\\test\\jvm\\ 拷贝 MySample 和 MyCat 的class文件，并仅仅删除环境变量中的MySample.class文件
         * MySample会被自定义的类加载器加载，MyCat会被AppClassLoader所加载
         * MySample中调用MyCat也不会报错，因为子类加载器加载的类调用父类加载器所加载的类
         * 打印结果
         * ------------------------------------------------------------------------
         * ==>自定义的类加载器被执行<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@60f38b42
         * sun.misc.Launcher$AppClassLoader@1978b0f9
         * MyCat：class cn.com.ccxi.test.jvm.MyCat
         * ------------------------------------------------------------------------------------------------------------------------------------------------5
         */
        clazz.newInstance();
        
    }

}
