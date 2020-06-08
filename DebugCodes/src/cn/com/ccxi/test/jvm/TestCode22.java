package cn.com.ccxi.test.jvm;

/**
 * 该类用于测试扩展类加载器的加载路径
 * 扩展类加载器无法直接加载.class文件，只能加载jar包中的class文件
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
     * 测试1：在 cmd中启动， 命令修改为 java -Djava.ext.dirs=./ cn.com.ccxi.test.jvm.TestCode22
     * 加载器是AppClassLoader是因为，扩展类加载器无法直接加载class文件
     * ------------------------------------------------------------------------------------------------------1
     * TestCode22 inited!
     * sun.misc.Launcher$AppClassLoader@6276e1db
     * sun.misc.Launcher$AppClassLoader@6276e1db
     * ------------------------------------------------------------------------------------------------------1
     * 
     * 测试2：将TestCode01打包成jar包： jar cvf testjvm.jar ./cn/com/ccxi/test/jvm/TestCode01.class
     * 在 cmd中启动， 命令修改为 java -Djava.ext.dirs=./ cn.com.ccxi.test.jvm.TestCode22
     * ------------------------------------------------------------------------------------------------------2
     * TestCode22 inited!
     * sun.misc.Launcher$AppClassLoader@302b2c81
     * sun.misc.Launcher$ExtClassLoader@6276e1db -->AppClassLoader委托给父类ExtClassLoader加载器去加载该类
     * ------------------------------------------------------------------------------------------------------2
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(TestCode22.class.getClassLoader());
        
        System.out.println(TestCode01.class.getClassLoader());
    }
}
