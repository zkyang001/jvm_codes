package cn.com.ccxi.test.jvm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 1����java�����ڼ䣬һ�����Ψһ�������౾��binary name���ͼ��ظ���Ķ������������ͬȷ���ģ�class loader��
 * ���һ������������ͬ������������أ���������ļ���·����ͬ���������������Ҳ����������ͬ���ࡣ����.class��ͬ�����Ҵ���ͬ��λ�ü���Ҳ����ˡ�
 * 
 * 2������޸�������������ļ���·�������������ִ��  java -Dsun.boot.class.path=./ cn.com.ccxi.test.jvm.TestCode23�ᱨ��
 * ��Ϊ java.lang.Object��Ϊ������ĸ��࣬�䱾��������������������صģ��޸��������������·�����޷����ظ���
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
         * �����������
         * 1�������������������
         *  a:�����������������������õĻ����룬����C++��д�ģ���JVM����ʱ���������ClassLoader�������ƽ̨��ص�Java��
         *    ��Ϊ�����������ڣ���Ҳ�������չ���������ϵͳ�������
         *  b:���������������Java�࣬������������java��
         *    �Զ�����������ض���ƽ̨�Ļ���ָ�����������صĹ���
         *  c:��������������˸�����ظ���Java��ļ�����֮�⣬�����������jre������صĸ��ֻ���������Լ������������������صĸ�����������
         */
        System.out.println(System.getProperty("sun.boot.class.path"));
        /**
         * ��չ�������
         */
        System.out.println(System.getProperty("java.ext.dirs"));
        /**
         * ϵͳ�������
         */
        System.out.println(System.getProperty("java.class.path"));
        
        /**
         * �����
         */
        System.out.println("--------------------------------------------------------------------------");
        
        /**
         * 1���ڲ�ָ�� java.system.class.loader ����ֵ֮ǰ�� Ĭ�ϵ�ϵͳ���������AppClassLoader����eclipse�����²鿴����̨��ӡ
         * --------------------------------------------------------------------------------------------------------------------------------------1
         * null
         * sun.misc.Launcher$AppClassLoader@337b5179
         * sun.misc.Launcher$AppClassLoader@337b5179
         * --------------------------------------------------------------------------------------------------------------------------------------1
         * 
         * 2�������������ʱ�� ͨ��ָ�� java.system.class.loader���鿴��ӡ���
         * �����ԭ���ǣ����Ҫ�� java.system.class.loaderָ��ĳ���Զ������������Ϊ�����Ļ���
         * ���Զ�����������б������һ������ΪClasssLoader�Ĺ��캯�����Դ�ʵ��˫��ί�л��� 
         * --------------------------------------------------------------------------------------------------------------------------------------2
         * java -Djava.system.class.loader=cn.com.ccxi.test.jvm.TestCode16_Revise cn.com.ccxi.test.jvm.TestCode23
         * Error occurred during initialization of VM
         * java.lang.Error: java.lang.NoSuchMethodException: cn.com.ccxi.test.jvm.TestCode16_Revise.<init>(java.lang.ClassLoader)
         * --------------------------------------------------------------------------------------------------------------------------------------2
         * 
         * 3����TestCode16_Revise�Զ������У���Ӳ���ΪClassLoader�Ĺ��캯����
         * �ͻ������в鿴�����  java -Djava.system.class.loader=cn.com.ccxi.test.jvm.TestCode16_Revise cn.com.ccxi.test.jvm.TestCode23
         * ������Կ��� ClassLoader.getSystemClassLoader()��ϵͳ��������Ѿ�����������Զ�����������
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
