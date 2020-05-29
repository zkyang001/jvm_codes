package cn.com.ccxi.test;

import java.io.IOException;

/**
 * @author yang_zk
 *
 */
public class TestCode01 {

	public static void main(String[] args) throws IOException {
		One one = new One();
		System.out.println(one.name);//12
		One anoOne = new One();
		anoOne.name = "~~~~~";
		System.out.println(anoOne.name);//~~
		System.out.println(one.name);//12
	}
} 
