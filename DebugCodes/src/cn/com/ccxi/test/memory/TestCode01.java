package cn.com.ccxi.test.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM 参数设置：
 * -Xms10m 最小堆内存
 * -Xmx10m 最大堆内存 
 * -XX:+HeapDumpOnOutOfMemoryError 生成堆转储文件
 */
public class TestCode01 {
	public static void main(String[] args) {
		List<TestCode01> list = new ArrayList<>();
		for ( ; ; ) {
			list.add(new TestCode01());
			System.gc();
		}
	}
}
