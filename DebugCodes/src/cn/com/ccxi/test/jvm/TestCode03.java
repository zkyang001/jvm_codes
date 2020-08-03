package cn.com.ccxi.test.jvm;

import java.util.UUID;

/**
 * 对于在编译期间无法确定值得常量，java虚拟机会在运行期间确定常量的值。
 * 对于调用常量的类，则会在运行期间，主动的去调用定义类（Parent03）的常量，因此会引起定义类的初始化
 * 个人理解，此时的主动调用可以认为此常量本身也是static，即静态的，会引起此类的初始化
 * @author yang_zk
 *
 */
public class TestCode03 {
    public static void main(String[] args) {
        System.out.println(Parent03.constant);
    }
}
class Parent03 {
    public static final String constant = UUID.randomUUID().toString();
    static {
        System.out.println("parent03 is inited");
    }
}