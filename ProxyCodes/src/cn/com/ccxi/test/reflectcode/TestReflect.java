package cn.com.ccxi.test.reflectcode;

import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws Exception {
        // 第1个参数表示方法名称，第2个参数之后所有，表示该方法的所有参数类型,是类型而不是实际数值
        Method method = TestInterface.class.getMethod("testMethod", String.class, int.class);
        TestInterface target = new TestImpl();
        // 第1个参数表示调用方法的所属对象，第2个参数之后所有，表示该方法的所有参数实际数值
        method.invoke(target, "", 3);
    }
}
