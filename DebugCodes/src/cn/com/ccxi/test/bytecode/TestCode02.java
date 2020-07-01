package cn.com.ccxi.test.bytecode;

public class TestCode02 implements TestInterface01 {
    String str = "hello world";
    private int x = 5;
    public static Double num = 4.5;
    public static void main(String[] args) {
        TestCode02 testCode02 = new TestCode02();
        testCode02.setX(10);
        num = 9.9;
    }
    public void setX(int x) {
        this.x = x;
    }
}

