package cn.com.ccxi.test.jvm;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;


/**
 * 1、线程上下文类加载器的使用模式：获取->使用->还原
 * 获取：ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * 使用：Thread.currentThread().setContextClassLoader(newClassLoader);
 *     method() 使用上下文类加载器处理一些事情.
 * 还原:Thread.currentThread().setContextClassLoader(classLoader)
 * -----------------------------------------------------------------------------------1
 * 2、线程上下文类加载器破坏了双亲委托模型机制
 * 	 当高层提供了接口由低层去实现，同时高层的类需要访问低层类时，就必须使用线程上下文类加载器来帮助高层类去访问低层类。
 * 
 * 
 *
 */
public class TestCode26 {
    
    
    /**
     * class：class sun.jdbc.odbc.JdbcOdbcDriver，loader：null
     * class：class com.mysql.jdbc.Driver，loader：sun.misc.Launcher$AppClassLoader@1978b0f9
     * 当前线程上下文类加载器：sun.misc.Launcher$AppClassLoader@1978b0f9
     * ServiceLoader的类加载器：null
     * @param args
     */
    public static void main(String[] args) {
        
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while(iterator.hasNext()) {
            Driver next = iterator.next();
            System.out.println("class：" + next.getClass() + "，loader：" + next.getClass().getClassLoader());
        }
        
        System.out.println("当前线程上下文类加载器：" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());
        
    }

}
