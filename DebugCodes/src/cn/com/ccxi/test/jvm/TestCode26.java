package cn.com.ccxi.test.jvm;


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
	

}
