package cn.com.ccxi.test;

/**
 * ‐XX:+PrintGCDetails 开启垃圾回收控制台打印
 */
public class TestCode02 {
    // 每一个TestCode02的实例对象，都固定占用2M内存大小
    private byte[] size = new byte[1024 * 1024 * 2];
    private TestCode02 attribute;
    public static void main(String[] args) throws Exception {
        // 创建两个 TestCode02 的实例
        TestCode02 one = new TestCode02();
        TestCode02 two = new TestCode02();
        // 给两个实例对象的 attribute 属性设置为另外一个对象
        one.attribute = two;
        two.attribute = one;
        // 两个实例引用赋空
        one = two = null;
        // 执行一次垃圾回收
        System.gc();
        System.out.println("--------------------------");
        Thread.sleep(500);
        System.gc();
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize()被执行。。");
        attribute = this;
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            System.out.println(i + " / " + Integer.MAX_VALUE);
//        }
    }
}
