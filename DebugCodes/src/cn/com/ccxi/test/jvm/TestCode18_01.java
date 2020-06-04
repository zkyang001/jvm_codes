package cn.com.ccxi.test.jvm;

/**
 * 将要加载的class文件放在bootstrap类加载的加载路径下，查看是否能被启动类加载器所加载
 * C:\software\java7\jdk\jre\classes
 * @author 86135
 *
 */
public class TestCode18_01 {
    
    public static void main(String[] args) throws Exception {
        TestCode16_Revise loader1 = new TestCode16_Revise("loader1");
        loader1.setRootPath("D:\\test\\jvm\\");
        
        Class<?> clazz = loader1.loadClass("cn.com.ccxi.test.jvm.TestCode01");
        
        /**
         * 在bootstrap类加载器的加载路径下 C:\software\java7\jdk\jre\classes，添加所要加载类的class文件
         * 无论 TestCode01类加载时，在classpath环境变量下，是否删除TestCode01.class文件，最终的类加载器都会是bootstrap类加载器
         * 因为不管是自定义的类加载器 TestCode16_Revise，还是系统类加载器AppClassLoader接收到加载该类的请求时，
         * 通过双亲委托机制，都会将加载请求委托至最顶层：启动类加载器，
         * 而在启动类加载器的加载路径下，确实有 cn.com.ccxi.test.jvm.TestCode01（因为我们之前拷贝进去了），所以加载成功，返回null
         */
        System.out.println("hashcode：" + clazz.hashCode());
        System.out.println(clazz.getClassLoader());
    }

}
