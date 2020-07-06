package cn.com.ccxi.test.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

public class TestCode03 {
    
    public void test() {
        try {
            InputStream is = new FileInputStream("test.txt");
            ServerSocket ss = new ServerSocket(8081);
            ss.accept();
        } catch (FileNotFoundException a) {
            
        } catch (IOException b) {
            
        } catch (Exception e) {
            
        } finally {
            System.out.println("hello world");
        }
    }
}
