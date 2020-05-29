package cn.com.ccxi.test.jvm;

class Coo {
	public static int a = 2;
	static {
		System.out.println("--Coo--init--");
	}
}

class Doo extends Coo {
	public static int b = 4;
	static {
		System.out.println("--Doo--init--");
	}
}
// --TestCode10--
// =======
// --Coo--init--
// =======
// 2
// =======
// --Doo--init--
// 4

public class TestCode10 {
	static {
		System.out.println("--TestCode10--");
	}
	
	public static void main(String[] args) {
		Coo coo;
		System.out.println("=======");
		coo = new Coo();
		System.out.println("=======");
		System.out.println(Coo.a);
		System.out.println("=======");
		System.out.println(Doo.b);
	}

}
