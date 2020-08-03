package cn.com.ccxi.test.jvm;

public class MyCat {
    
    public MyCat() {
        System.out.println(this.getClass().getClassLoader());
        
        // ->验证命名空间4：所加载的类，其他几种情况可以注释掉
        // System.out.println("MySample：" + MySample.class);
    }

}
