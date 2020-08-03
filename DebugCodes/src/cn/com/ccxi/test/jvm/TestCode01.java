package cn.com.ccxi.test.jvm;

/**
 * ldc:将String，int，float类型的常量从常量池中推送至栈顶
 * iconst_1 将整型 1 推送至栈顶（1-5）
 * bipush 将-128到127之间的短整型数字推送至栈顶
 * sipush 将（-32768~32767）之间的数字推送至栈顶
 * 此处涉及 常量传播优化  
 */
public class TestCode01 {
    public static void main(String[] args) {
        System.out.println(Poo.a);
    }
}
class Poo {
    public static final String a = "hello";
    
    static {
        System.out.println("静态代码块");
    }
}
