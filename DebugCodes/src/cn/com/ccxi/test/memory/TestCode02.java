package cn.com.ccxi.test.memory;

/**
 * -Xss100k ���õ����߳�ջ�ڴ��С�������߳�ջ�ڴ��С�����ϵͳ��jdk�汾�й�ϵ��
 */
public class TestCode02 {
    private int len;
    public int getLen() {
        return len;
    }
    public void test(){
        len ++ ;
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }
    public static void main(String[] args) {
        TestCode02 testCode02 = new TestCode02();
        try {
            testCode02.test();
        } catch (Throwable tw) {
            System.out.println(testCode02.getLen());
            tw.printStackTrace();
        }
    }
}
