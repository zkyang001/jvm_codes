package cn.com.ccxi.test;


public abstract class ABSDemoClass {

	public abstract Integer maxNum(Integer[] nums);
	
	public Integer sum(Integer... num1) {
		int res = 0;
		for (int i = 0; i < num1.length; i++) {
			res += i;
		}
		return res;
	}
}
