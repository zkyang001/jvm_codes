package cn.com.ccxi.test.jvm;

import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class TestCode27 {
    
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://127.0.0.1/ccxiproject?jdbcCompliantTruncation=false&useUnicode=true&characterEncoding=UTF-8", "ccxi", "ccxi");
        
    }

}
