package cn.com.ccxi.test.staticproxy;

public class IPhoneFactory implements PhoneFactory {
    @Override
    public void sell(int count) {
        System.out.println("IPhone售价8999元。");
    }
}
