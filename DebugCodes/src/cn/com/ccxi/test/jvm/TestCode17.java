package cn.com.ccxi.test.jvm;

public class TestCode17 {
    
    
    /**
     * 虚拟机会预先加载某个可能会使用到的类，而不是等到首次主动使用时才加载该类
     * 如果在加载过程中出现异常，比如ClassNotFound的异常或错误，虚拟机并不会报错，而是等到主动使用该类时报错
     * 
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //cn.com.ccxi.test.jvm.TestCode01
        TestCode16_Revise loader1 = new TestCode16_Revise("loader1");
        Class<?> clazz = loader1.loadClass("cn.com.ccxi.test.jvm.MySample");
        System.out.println(clazz.getClassLoader().hashCode());
        
        // 以下代码的作用是，通过反射机制，创建clazz类对象的实例对象（cn.com.ccxi.test.jvm.MySample类）
        // 创建该实例对象时，会调用该实例对象的构造方法，即 MySample 类的构造方法，并打印起类加载器，双亲委托机制可以确定其加载器为AppClassLoader
        // MySample类的构造器中调用了Mycat类创建实例对象，因此也会调用Mycat实例对象的构造方法，并打印其加载器为AppClassloader
        // MySample类被加载后，会使用加载自身类的类加载器去加载构造函数中所创建的实例对象所属的类，即Mycat。
        clazz.newInstance();
    }

}
  