package cn.com.ccxi.test.jvm;

/**
 * 该类的作用是 实例化了扩展类加载器所加载的类，
 * 但是在启动程序时，通过指定修改扩展类加载器默认的加载的路径，程序会报错，ClassNotFound
 * AESKeyGenerator 是由扩展类加载器所默认加载的，
 * 本实例无法进行的原因是因为AESKeyGenerator类无法被引入，jar包没找
 * @author 86135
 *
 */
public class TestCode19 {
    
    public static void main(String[] args) {
        // AESKeyGenerator  one = new AESKeyGenerator();
    }

}
