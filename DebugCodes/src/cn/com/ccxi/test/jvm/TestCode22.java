package cn.com.ccxi.test.jvm;

/**
 * �������ڲ�����չ��������ļ���·��
 * ��չ��������޷�ֱ�Ӽ���.class�ļ���ֻ�ܼ���jar���е�class�ļ�
 * 
 * @author 86135
 *
 */
public class TestCode22 {
    
    static {
        System.out.println("TestCode22 inited!");
    }

    /**
     * 
     * ����1���� cmd�������� �����޸�Ϊ java -Djava.ext.dirs=./ cn.com.ccxi.test.jvm.TestCode22
     * ��������AppClassLoader����Ϊ����չ��������޷�ֱ�Ӽ���class�ļ�
     * ------------------------------------------------------------------------------------------------------1
     * TestCode22 inited!
     * sun.misc.Launcher$AppClassLoader@6276e1db
     * sun.misc.Launcher$AppClassLoader@6276e1db
     * ------------------------------------------------------------------------------------------------------1
     * 
     * ����2����TestCode01�����jar���� jar cvf testjvm.jar ./cn/com/ccxi/test/jvm/TestCode01.class
     * �� cmd�������� �����޸�Ϊ java -Djava.ext.dirs=./ cn.com.ccxi.test.jvm.TestCode22
     * ------------------------------------------------------------------------------------------------------2
     * TestCode22 inited!
     * sun.misc.Launcher$AppClassLoader@302b2c81
     * sun.misc.Launcher$ExtClassLoader@6276e1db -->AppClassLoaderί�и�����ExtClassLoader������ȥ���ظ���
     * ------------------------------------------------------------------------------------------------------2
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(TestCode22.class.getClassLoader());
        
        System.out.println(TestCode01.class.getClassLoader());
    }
}
