package cn.com.ccxi.test.jvm;

public class MySample {
    
    public MySample() {
        System.out.println(getClass().getClassLoader());
        new MyCat();
        
        // Ϊ����֤�����ռ�5�����⣬����1-4��ע�͵�
        System.out.println("MyCat��" + MyCat.class);
    }

}
