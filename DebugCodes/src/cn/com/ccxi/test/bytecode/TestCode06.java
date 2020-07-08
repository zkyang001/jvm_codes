package cn.com.ccxi.test.bytecode;

public class TestCode06 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        
        apple.test();
        orange.test();
    }
}
class Fruit {
    public void test() {
        System.out.println("Fruit;");
    }
}
class Apple extends Fruit {
    @Override
    public void test() {
        System.out.println("Apple;");
    }
}
class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange;");
    }
}
