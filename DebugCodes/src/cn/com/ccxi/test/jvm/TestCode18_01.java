package cn.com.ccxi.test.jvm;

/**
 * ��Ҫ���ص�class�ļ�����bootstrap����صļ���·���£��鿴�Ƿ��ܱ������������������
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
         * ��bootstrap��������ļ���·���� C:\software\java7\jdk\jre\classes�������Ҫ�������class�ļ�
         * ���� TestCode01�����ʱ����classpath���������£��Ƿ�ɾ��TestCode01.class�ļ������յ��������������bootstrap�������
         * ��Ϊ�������Զ����������� TestCode16_Revise������ϵͳ�������AppClassLoader���յ����ظ��������ʱ��
         * ͨ��˫��ί�л��ƣ����Ὣ��������ί������㣺�������������
         * ����������������ļ���·���£�ȷʵ�� cn.com.ccxi.test.jvm.TestCode01����Ϊ����֮ǰ������ȥ�ˣ������Լ��سɹ�������null
         */
        System.out.println("hashcode��" + clazz.hashCode());
        System.out.println(clazz.getClassLoader());
    }

}
