package cn.com.ccxi.test.jvm;

import java.lang.reflect.Method;

/**
 * 该类目的是测试同一个类由同一个类加载加载时，生成的Class对象是否相等，已经能否相同类型强制转换
 * @author 86135
 *
 */
public class TestCode20 {
    public static void main(String[] args) throws Exception {
        TestCode16_Revise loader1 = new TestCode16_Revise("loader1");
        TestCode16_Revise loader2 = new TestCode16_Revise("loader2");
        
        Class<?> clazz1 = loader1.loadClass("cn.com.ccxi.test.jvm.MyPerson");
        Class<?> clazz2 = loader2.loadClass("cn.com.ccxi.test.jvm.MyPerson");
        /**
         * 没有指定自定义类加载器的加载路径，所有clazz1和clazz2的类加载器都是AppClassLoader
         * 在clazz1被成功加载之后，就会存放到方法区中，并生成MyPerson的类对象， 
         * clazz2被加载时，不会重复进行加载动作，而是将方法区中的MyPerson类对象直接返回
         * 结果为 True
         */
        System.out.println(clazz1 == clazz2);
        
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        
        /**
         * 反射获取MyPerson类的 setMyPerson方法
         */
        /**
         * 测试结果可以成功执行
         */
        Method method = clazz1.getMethod("setMyPerson", Object.class);
        /**
         * object1，被调用的实例对象
         * object2，setMyPerson的方法参数
         */
        method.invoke(object1, object2);
        
    }

}
