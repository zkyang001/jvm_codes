package cn.com.ccxi.test.dynamicproxy;

public class SamPhoneFactory implements PhoneInterface {
    @Override
    public int sellPhone(String type, Double price, int count) {
        System.out.println("目标类的方法调用！");
        return 1000;
    }
    @Override
    public int hashCode() {
        return 1111111;
    }
}
