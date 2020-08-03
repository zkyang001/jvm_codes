package cn.com.ccxi.test.jvm;

public class MySample {
    
    public MySample() {
        System.out.println(getClass().getClassLoader());
        new MyCat();
        
        // 为了验证命名空间5的问题，其他1-4可注释掉
        System.out.println("MyCat：" + MyCat.class);
    }

}
