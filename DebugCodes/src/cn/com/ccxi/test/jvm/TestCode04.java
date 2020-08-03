package cn.com.ccxi.test.jvm;

/**
 * 1、在创建数组实例的时候，并不会引起其元素类型的初始化
 *  创建数组实例的时候，虚拟机会隐式的创建一个[cn.com.ccxi.test.jvm.Parent04的类，
 *  如果是多维度数组，会创建[[cn.com.ccxi.test.jvm.Parent04的类
 *  对于数组，虚拟机创建的数组类型的父类都是java.lang.Object类
 *  数组的组件指的是，数组在去掉一个维度后的类型
 * 
 * --anewarray--创建一个引用类型的数组，并将其压入栈顶
 * --newarray---创建一个原始类型(int, shor, byte)的数组，并将其压入栈顶
 * --multianewarray--- 创建一个多维度的数组，并将其压入栈顶
 * @author yang_zk
 *
 */
public class TestCode04 {

    public static void main(String[] args) {
        Parent04 p1 = new Parent04(); // --初始化
        Parent04[] ps = new Parent04[23]; // 不会引起Parent04类的初始化
        Parent04[][] pss = new Parent04[3][4];// 不会引起Parent04的初始化
        System.out.println(ps.getClass()); // class [Lcn.com.ccxi.test.jvm.Parent04
        System.out.println(ps.getClass().getSuperclass()); // class java.lang.Object
        System.out.println(ps.getClass().getSuperclass().getSuperclass()); // null
        System.out.println(pss.getClass()); // class [[Lcn.com.ccxi.test.jvm.Parent04;
        System.out.println(pss.getClass().getSuperclass());// class java.lang.Object
        
        int[] a = new int[4];
        System.out.println(a.getClass()); // class [I
        Integer[] aa = new Integer[4];
        System.out.println(aa.getClass()); // class [Ljava.lang.Integer;
        
        byte[] b = new byte[3];
        System.out.println(b.getClass()); // class [B
        Byte[] bb = new Byte[3];
        System.out.println(bb.getClass()); // class [Ljava.lang.Byte;
        
        int[][] t1 = new int[2][2]; // multianewarray
        int[][][] t2 = new int[2][2][4]; // multianewarray
        
    }
}


class Parent04 {
    
    static {
        System.out.println("---Parent04----初始化");
    }
    
}
