package cn.com.ccxi.test.jvm;



/**
 * 查看线程上下文类加载器及其父类加载器
 * -----------------------------------------------------1
 * --> class sun.misc.Launcher$AppClassLoader
 * parent --> class sun.misc.Launcher$ExtClassLoader
 * -----------------------------------------------------1
 * @author Administrator
 *
 */
public class TestCode25 implements Runnable {
	
	private Thread thread;
	
	public TestCode25() {
		this.thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		ClassLoader contextClassLoader = thread.getContextClassLoader();
		thread.setContextClassLoader(contextClassLoader);
		
		System.out.println("--> " + contextClassLoader.getClass());
		System.out.println("parent --> " + contextClassLoader.getParent().getClass());
		
	}
	
	public static void main(String[] args) {
		new TestCode25();
	}

}
