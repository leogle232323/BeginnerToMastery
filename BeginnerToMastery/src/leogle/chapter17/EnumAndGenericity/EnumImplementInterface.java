package leogle.chapter17.EnumAndGenericity;

import org.junit.Test;

interface d {
	public String getDescription();

	public int getI();
}

enum AnyEnum implements d {
	// 在枚举类型成员内部设置方法
	Enum_A {

		@Override
		public String getDescription() {
			return "我是枚举成员A";
		}

		@Override
		public int getI() {
			return i;
		}
	},
	Enum_B {
		@Override
		public String getDescription() {
			return "我是枚举成员B";
		}

		@Override
		public int getI() {
			return i;
		}
	},
	Enum_C {
		@Override
		public String getDescription() {
			return "我是枚举成员C";
		}

		@Override
		public int getI() {
			return i;
		}
	},
	Enum_D {
		@Override
		public String getDescription() {
			return "我是枚举成员D";
		}

		@Override
		public int getI() {
			return i;
		}
	};

	private static int i = 5;

}

public class EnumImplementInterface {
	@Test
	public void test() {
		int length = AnyEnum.values().length;
		for (int i = 0; i < length; i++) {
			AnyEnum tmp = AnyEnum.values()[i];
			System.out.println(
					"枚举类型" + tmp + "调用getDescription()方法为：" + tmp.getDescription() + ",调用getI()方法为:" + tmp.getI());
		}
	}
}
