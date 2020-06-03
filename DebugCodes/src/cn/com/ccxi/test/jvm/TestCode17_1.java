package cn.com.ccxi.test.jvm;

public class TestCode17_1 {
    
    public static void main(String[] args) throws Exception {
        TestCode16_Revise loader1 = new TestCode16_Revise("loader1");
        loader1.setRootPath("D:\\test\\jvm\\");
        Class<?> clazz = loader1.loadClass("cn.com.ccxi.test.jvm.MySample");
        
        /**
         * 1���� D:\\test\\jvm\\ ���� MySample �� MyCat ��class�ļ�����ɾ�����������У�ԭʼ�� MySample �� MyCat ��class�ļ�    
         * ��ӡ����ǣ����ص������඼��ʹ���Զ����������� TestCode16_Revise
         * ------------------------------------------------------------------------
         * ==>�Զ�������������ִ��<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@60f38b42
         * ==>�Զ�������������ִ��<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@60f38b42
         * ------------------------------------------------------------------------------------------------------------------------------------------------1
         * 
         * 2���� D:\\test\\jvm\\ ���� MySample �� MyCat ��class�ļ���������ɾ������������ԭʼ�� MyCat ��class�ļ�
         * ��ӡ�Ľ���� MySample����Ա�AppClassLoader�������أ������ڼ���Mycat��ʱ���ᱨ��ClassNotFountException����
         * ��Ϊ��MySample���캯���У���ʹ��AppClassLoaderȥ����MyCat�࣬����MyCat.class�ļ��Ѿ���classpath���������б�ɾ�������Իᱨ��
         * ------------------------------------------------------------------------
         * sun.misc.Launcher$AppClassLoader@6521f956
         * Exception in thread "main" java.lang.NoClassDefFoundError: cn/com/ccxi/test/jvm/MyCat
         * ------------------------------------------------------------------------------------------------------------------------------------------------2
         * 
         * 3����D:\\test\\jvm\\ ����MySamle �� MyCat ��class �ļ���������ɾ������������ԭʼ��MySample��class�ļ�
         * ��ӡ�Ľ����MySample��ᱻ�Զ����������� TestCode16_Revise ���أ�����MyCat��ᱻAppClassLoader�����������
         * ��Ϊ��MySample�Ĺ��캯���У���ʹ���Զ����������ȥ����MyCat��ʱ������˫��ί�л��ƣ��Զ������������ί�и��������AppClassLoader������ȥ����
         * ------------------------------------------------------------------------
         * ==>�Զ�������������ִ��<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@60f38b42
         * sun.misc.Launcher$AppClassLoader@1978b0f9
         * ------------------------------------------------------------------------------------------------------------------------------------------------3
         * 
         * 4�����������ռ�����⣺������������丸������������ص��๹�ɣ��Ӽ����������ص�����Է��ʸ������������ص��࣬���Ǹ������������ص����ǲ��ܷ��ʵ��Լ����������ص���
         * ��MyCat�������� ���MySample��ĵ���,�� D:\\test\\jvm\\ ���� MySample �� MyCat ��class�ļ���������ɾ�����������е�MySample.class�ļ�
         * ��� MySample����Ա��Զ����������������أ�MyCat�ᱻAppClassLoader������������أ�������MyCat�������е���MySample��ʱ�ᱨ��ԭ��
         * AppClassLoader���Զ�����������ĸ��࣬MyCat���޷����õ�����������������صĵ��࣬��ΪMySample���Լ����������ص��࣬MyCat�ɸ������������ء�
         * ��ӡ�����
         * ------------------------------------------------------------------------
         * ==>�Զ�������������ִ��<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@6c908f05
         * sun.misc.Launcher$AppClassLoader@337b5179
         * Exception in thread "main" java.lang.NoClassDefFoundError: cn/com/ccxi/test/jvm/MySample
         * ------------------------------------------------------------------------------------------------------------------------------------------------4
         * 
         * 5��ע�͵�MyCat�ж�MySample�����ã�����MySample����Ӷ�MyCat������
         * �� D:\\test\\jvm\\ ���� MySample �� MyCat ��class�ļ���������ɾ�����������е�MySample.class�ļ�
         * MySample�ᱻ�Զ��������������أ�MyCat�ᱻAppClassLoader������
         * MySample�е���MyCatҲ���ᱨ����Ϊ������������ص�����ø�������������ص���
         * ��ӡ���
         * ------------------------------------------------------------------------
         * ==>�Զ�������������ִ��<==
         * cn.com.ccxi.test.jvm.TestCode16_Revise@60f38b42
         * sun.misc.Launcher$AppClassLoader@1978b0f9
         * MyCat��class cn.com.ccxi.test.jvm.MyCat
         * ------------------------------------------------------------------------------------------------------------------------------------------------5
         */
        clazz.newInstance();
        
    }

}
