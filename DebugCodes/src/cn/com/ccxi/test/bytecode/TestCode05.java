package cn.com.ccxi.test.bytecode;

public class TestCode05 {
    public void test(Grandpa01 arg) {
        System.out.println("Grandpa01");
    }
    public void test(Parent01 arg) {
        System.out.println("Parent01");
    }
    public void test(Son01 arg) {
        System.out.println("Son01");
    }
    public static void main(String[] args) {
        TestCode05 test = new TestCode05();
        Grandpa01 vo1 = new Parent01();
        Grandpa01 vo2 = new Son01();
        test.test(vo1);
        test.test(vo2);
    }
}
class Grandpa01{}
class Parent01 extends Grandpa01{}
class Son01 extends Parent01{}
