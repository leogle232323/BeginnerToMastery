package leogle.chapter17.EnumAndGenericity;

import org.junit.Test;

//将常量放置在接口中
interface Constants {
	public static final int Constants_A = 1;
	public static final int Constants_B = 2;
}

// 将常量放置在枚举类型中
enum Constants2 {
	Constants_A, Constants_B
}

// 在类中定义枚举类型
class EnumClass {
	enum Constatns3 {
		A, B
	}
}

public class EnumAndInterface {
	// 定义一个参数对象是int型的方法
	public static void doit(int c) {
		switch (c) {
		case Constants.Constants_A:
			System.out.println("doit() Constants_A:" + c);
			break;
		case Constants.Constants_B:
			System.out.println("doit() Constants_B:" + c);
			break;
		}
	}

	// 定义一个参数对象是枚举类型的方法
	public static void doit2(Constants2 c) {
		switch (c) {
		case Constants_A:
			System.out.println("doit2() Constatns_A:" + c);
			break;
		case Constants_B:
			System.out.println("doit2() Constatns_B:" + c);
			break;
		}
	}

	@Test
	public void test() {
		// 使用接口定义的常量
		doit(Constants.Constants_A);
		doit(3);
		// 使用枚举定义的常量
		doit2(Constants2.Constants_A);
		doit2(Constants2.Constants_B);
		// doit2(3);
		// 输出类中定义的枚举类型
		System.out.println(EnumClass.Constatns3.A);
	}

}
