package cn.com.ccxi.test.jvm;

/**
 * �鿴�������������չ����أ�ϵͳ��������ļ���·��
 * @author 86135
 *
 */
public class TestCode18 {
    
    public static void main(String[] args) {
        /**
         * 1����ȡ������������������·��
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
         * 2����ȡ��չ��������ļ���·��
         * C:\software\java7\jdk\jre\lib\ext;
         * C:\WINDOWS\Sun\Java\lib\ext
         */
        System.out.println(System.getProperty("java.ext.dirs"));
        
        /**
         * 3����ȡϵͳ��������ļ���·��
         * D:\github\DebugCodes\bin
         */
        System.out.println(System.getProperty("java.class.path"));
    }

}
