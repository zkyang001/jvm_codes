package cn.com.ccxi.test.staticproxy;

public class JD implements PhoneFactory{

    private PhoneFactory phoneFactory = new IPhoneFactory();;
    
    @Override
    public void sell(int count) {
        System.out.println("检查手机是否有问题！"); // 前置功能增强
        phoneFactory.sell(1);
        System.out.println("提供发票，赠送耳机！"); // 后置功能增强
    }
}
