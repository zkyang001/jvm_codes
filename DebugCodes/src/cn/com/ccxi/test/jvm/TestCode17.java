package cn.com.ccxi.test.jvm;

public class TestCode17 {
    
    
    /**
     * �������Ԥ�ȼ���ĳ�����ܻ�ʹ�õ����࣬�����ǵȵ��״�����ʹ��ʱ�ż��ظ���
     * ����ڼ��ع����г����쳣������ClassNotFound���쳣���������������ᱨ�����ǵȵ�����ʹ�ø���ʱ����
     * 
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //cn.com.ccxi.test.jvm.TestCode01
        TestCode16_Revise loader1 = new TestCode16_Revise("loader1");
        Class<?> clazz = loader1.loadClass("cn.com.ccxi.test.jvm.MySample");
        System.out.println(clazz.getClassLoader().hashCode());
        
        // ���´���������ǣ�ͨ��������ƣ�����clazz������ʵ������cn.com.ccxi.test.jvm.MySample�ࣩ
        // ������ʵ������ʱ������ø�ʵ������Ĺ��췽������ MySample ��Ĺ��췽��������ӡ�����������˫��ί�л��ƿ���ȷ���������ΪAppClassLoader
        // MySample��Ĺ������е�����Mycat�ഴ��ʵ���������Ҳ�����Mycatʵ������Ĺ��췽��������ӡ�������ΪAppClassloader
        // MySample�౻���غ󣬻�ʹ�ü�����������������ȥ���ع��캯������������ʵ�������������࣬��Mycat��
        clazz.newInstance();
    }

}
  