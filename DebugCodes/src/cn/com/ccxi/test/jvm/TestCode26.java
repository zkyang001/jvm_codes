package cn.com.ccxi.test.jvm;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;


/**
 * 1���߳����������������ʹ��ģʽ����ȡ->ʹ��->��ԭ
 * ��ȡ��ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
 * ʹ�ã�Thread.currentThread().setContextClassLoader(newClassLoader);
 *     method() ʹ�������������������һЩ����.
 * ��ԭ:Thread.currentThread().setContextClassLoader(classLoader)
 * -----------------------------------------------------------------------------------1
 * 2���߳���������������ƻ���˫��ί��ģ�ͻ���
 * 	 ���߲��ṩ�˽ӿ��ɵͲ�ȥʵ�֣�ͬʱ�߲������Ҫ���ʵͲ���ʱ���ͱ���ʹ���߳���������������������߲���ȥ���ʵͲ��ࡣ
 * 
 * 
 *
 */
public class TestCode26 {
    
    
    /**
     * class��class sun.jdbc.odbc.JdbcOdbcDriver��loader��null
     * class��class com.mysql.jdbc.Driver��loader��sun.misc.Launcher$AppClassLoader@1978b0f9
     * ��ǰ�߳����������������sun.misc.Launcher$AppClassLoader@1978b0f9
     * ServiceLoader�����������null
     * @param args
     */
    public static void main(String[] args) {
        
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while(iterator.hasNext()) {
            Driver next = iterator.next();
            System.out.println("class��" + next.getClass() + "��loader��" + next.getClass().getClassLoader());
        }
        
        System.out.println("��ǰ�߳����������������" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader�����������" + ServiceLoader.class.getClassLoader());
        
    }

}
