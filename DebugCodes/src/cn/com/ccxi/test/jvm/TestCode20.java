package cn.com.ccxi.test.jvm;

import java.lang.reflect.Method;

/**
 * ����Ŀ���ǲ���ͬһ������ͬһ������ؼ���ʱ�����ɵ�Class�����Ƿ���ȣ��Ѿ��ܷ���ͬ����ǿ��ת��
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
         * û��ָ���Զ�����������ļ���·��������clazz1��clazz2�������������AppClassLoader
         * ��clazz1���ɹ�����֮�󣬾ͻ��ŵ��������У�������MyPerson������� 
         * clazz2������ʱ�������ظ����м��ض��������ǽ��������е�MyPerson�����ֱ�ӷ���
         * ���Ϊ True
         */
        System.out.println(clazz1 == clazz2);
        
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        
        /**
         * �����ȡMyPerson��� setMyPerson����
         */
        /**
         * ���Խ�����Գɹ�ִ��
         */
        Method method = clazz1.getMethod("setMyPerson", Object.class);
        /**
         * object1�������õ�ʵ������
         * object2��setMyPerson�ķ�������
         */
        method.invoke(object1, object2);
        
    }

}
