package cn.com.ccxi.test.reflectcode;

public class TestImpl implements TestInterface {
    @Override
    public void testMethod(String a, int b) {
        System.out.println("实现类的方法调用！");
    }
}
