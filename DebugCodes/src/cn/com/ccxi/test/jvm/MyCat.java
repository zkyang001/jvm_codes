package cn.com.ccxi.test.jvm;

public class MyCat {
    
    public MyCat() {
        System.out.println(this.getClass().getClassLoader());
        
        // ->��֤�����ռ�4�������ص��࣬���������������ע�͵�
        // System.out.println("MySample��" + MySample.class);
    }

}
