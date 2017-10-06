package leogle.chapter17.EnumAndGenericity;

import org.junit.Test;

enum Enum1 {
	C_A("我是枚举成员A"), C_B("我是枚举成员B"), C_C("我是枚举成员C"), C_D(3), C_E;

	private String description;
	private int i = 4;

	// 不带参数的构造方法
	private Enum1() {

	}

	// 参数为String类型的构造方法
	private Enum1(String description) {
		this.description = description;
	}

	// 参数为int型的构造方法
	private Enum1(int i) {
		this.i = i;
	}

	// 获取description的值
	public String getDescription() {
		return description;
	}

	// 获取i的值
	public int getI() {
		return i;
	}

}

public class EnumConstructors {
	@Test
	public void test() {
		for (int i = 0; i < Enum1.values().length; i++) {
			if ((Enum1.values()[i].compareTo(Enum1.valueOf("C_D")) == 0)) {
				System.out.println("枚举类型" + Enum1.values()[i] + "i字段内容为：" + Enum1.values()[i].getI());
			} else if (Enum1.C_E.equals(Enum1.values()[i])) {
				System.out.println("枚举类型" + Enum1.values()[i] + "字段description为" + Enum1.values()[i].getDescription()
						+ ",字段i为：" + Enum1.values()[i].getI());
			} else {
				System.out.println(
						"枚举类型" + Enum1.values()[i] + "" + "description字段内容为：" + Enum1.values()[i].getDescription());
			}
		}

	}
}
