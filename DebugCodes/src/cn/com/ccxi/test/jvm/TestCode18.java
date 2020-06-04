package cn.com.ccxi.test.jvm;

/**
 * 查看启动类加载起，扩展类加载，系统类加载器的加载路径
 * @author 86135
 *
 */
public class TestCode18 {
    
    public static void main(String[] args) {
        /**
         * 1、获取启动类加载器的类加载路径
         * C:\software\java7\jdk\jre\lib\resources.jar;
         * C:\software\java7\jdk\jre\lib\rt.jar;
         * C:\software\java7\jdk\jre\lib\sunrsasign.jar;
         * C:\software\java7\jdk\jre\lib\jsse.jar;
         * C:\software\java7\jdk\jre\lib\jce.jar;
         * C:\software\java7\jdk\jre\lib\charsets.jar;
         * C:\software\java7\jdk\jre\lib\jfr.jar;
         * C:\software\java7\jdk\jre\classes
         */
        System.out.println(System.getProperty("sun.boot.class.path"));
        
        /**
         * 2、获取扩展类加载器的加载路径
         * C:\software\java7\jdk\jre\lib\ext;
         * C:\WINDOWS\Sun\Java\lib\ext
         */
        System.out.println(System.getProperty("java.ext.dirs"));
        
        /**
         * 3、获取系统类加载器的加载路径
         * D:\github\DebugCodes\bin
         */
        System.out.println(System.getProperty("java.class.path"));
    }

}
