package cn.com.ccxi.test.jvm;

import java.lang.reflect.Method;

/**
 * �������ڲ��ԣ�ͬһ�����ɲ�ͬ�������������ʱ������ת���Ƿ���ȼ��Ƿ���ɼ�
 * @author 86135
 *
 */
public class TestCode21 {
    
    /**
     * ָ���Զ�������صļ���·�� D:\\test\\jvm\\����ɾ��AppClassLoader��Ӧ���������µ�class�ļ�
     * clazz1 == clazz2 Ϊfalse����Ϊ���������Զ�����������loader1��loader2���أ������ռ䲻ͬ�������಻�ɼ������Բ���ȡ�
     * method.invoke(object1, object2); �ᱨ���������  this.myPerson = (MyPerson)myPerson;
     * ��Ϊ���ߵ������ռ䲻ͬ�����Ի��಻�ɼ����ڷ���������������ͬ��Class������������ǿ��ת����ʱ��ᱨ��
     * ----------------------------------------------------------------------------------------------------------
     * ==>�Զ�������������ִ��<==
     * ==>�Զ�������������ִ��<==
     * false
     * Exception in thread "main" java.lang.reflect.InvocationTargetException
     * ....
     * Caused by: java.lang.ClassCastException: cn.com.ccxi.test.jvm.MyPerson cannot be cast to cn.com.ccxi.test.jvm.MyPerson
     * ---------------------------------------------------------------------------------------------------------- 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TestCode16_Revise loader1 = new TestCode16_Revise("loader1");
        TestCode16_Revise loader2 = new TestCode16_Revise("loader2");
        
        loader1.setRootPath("D:\\test\\jvm\\");
        loader2.setRootPath("D:\\test\\jvm\\");
        
        Class<?> clazz1 = loader1.loadClass("cn.com.ccxi.test.jvm.MyPerson");
        Class<?> clazz2 = loader2.loadClass("cn.com.ccxi.test.jvm.MyPerson");
        
        System.out.println(clazz1 == clazz2);
        
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        
        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
        
        
    }

}
