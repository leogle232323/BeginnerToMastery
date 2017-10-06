package leogle.chapter17.EnumAndGenericity;

import org.junit.Test;

/**
 * 1.尝试定义一个枚举类型类，使用switch语句获取枚举类型的值
 */
enum EnumEx1 {
	A, B, C;
}

public class Exercise1 {
	public void doIt(EnumEx1 para) {
		switch (para) {
		case A:
			System.out.println("doIt() A");
			break;
		case B:
			System.out.println("doIt() B");
			break;
		default:
			System.out.println("没有匹配项！");
			break;
		}
	}

	@Test
	public void test() {
		doIt(EnumEx1.A);
	}
}
