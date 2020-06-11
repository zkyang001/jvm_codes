package cn.com.ccxi.test.jvm;

public class TestCode24 {
    /**
     * 1、当前类加载器：
     *   每个类都会使用加载自身的类加载器去加载自身所引用到的其他类，前提是所引用的类尚未被加载。
     *   
     * 2、线程上下文类加载器
     *   上下文类加载器是从JDK1.2之后引入的，Thread类中提供了
     *   getContextClassLoader()：获取线程上下文类加载器
     *   setContextClassLoader(cl)：设置线程上下文类加载器
     *   
     *   如果没有设置线程的上下文类加载，线程会默认继承其父类的线程上下文类加载。
     *   Java初始运行的线程的上下文类加载器是AppClassLoader，线程的运行的代码可以通过该类加载器加载
     *   
     * 3、线程上下文类加载器出现的原因及优势
     *  原因：在SPI(Service Provider Interfade，即服务提供接口)中，比如jdbc，jdk提供了具体规范的接口，由数据库厂商去实现。
     *      父类ClassLoader所加载的类可以使用线程上下文类加载器(Thread.currentThread().getContextClassLoader())所加载的类，
     *      这就违背了父类加载器无法访问子类加载器或其他无关类加载器所加载的类的情况，即违背了双亲委托模型机制。
     *  线程上下文类加载器就是当前线程的当前类加载器
     *  
     *  在双亲委托模型情况下，下层的类加载器会委托父类加载器去加载累的请求，但是对于SPI来说，java核心库的规范接口是由启动类加载器所加载的，
     *  但是这些接口的实现类可能是由具体厂商实现的jar包，启动类加载器是不会去加载这些第三方jar包的，这就造成启动类加载起所加载的类可能无法访问到具体的实现类。
     *  这样双亲委托模型就无法满足SPI的要求。而通过设置线程上下文类加载器，就可以满足对于接口的实现类的加载和其他类加载器的访问。
     *   
     */
    
    
    public static void main(String[] args) {
        /**
         * 获取当前现场的上下文类加载 --> AppClassLoader
         */
        System.out.println(Thread.currentThread().getContextClassLoader());
        /**
         * 获取线程类的类加载器 -->根类加载器null
         */
        System.out.println(Thread.class.getClassLoader());
        
    }

}
