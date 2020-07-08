package cn.com.ccxi.test.bytecode;

public class TestCode02 implements TestInterface01 {
    String str = "welcome";
    private int x = 5;
    public static Integer num = 4;
    public static void main(String[] args) {
        TestCode02 testCode02 = new TestCode02();
        testCode02.setX(10);
        num = 9;
    }
    public synchronized void setX(int x) {
        this.x = x;
    }
    private void test(String str) {
        synchronized (str) {
            System.out.println("hello world");
        }
    }
    private synchronized static void test2() {
        
    }
}


