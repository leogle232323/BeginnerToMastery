package leogle.chapter17.EnumAndGenericity;

import org.junit.Test;

enum PETS {
	DOG, CAT
}

public class EnumMethods {
	@Test
	public void test() {
		// 1.values() 将枚举类型成员以数组的形式返回
		Object[] values = PETS.values();
		System.out.println("枚举类型成员为：");
		for (Object value : values) {
			System.out.print(value + " ");
		}
		System.out.println();
		// 2.valueOf() 将普通字符串转换为枚举实例
		PETS petDog = PETS.valueOf("DOG");
		System.out.println("枚举类型为：" + petDog);
		// 3.compareTo() 该方法用于比较两个枚举对象在定义时的顺序
		PETS petCat = PETS.valueOf("CAT");
		int compare = petCat.compareTo(PETS.valueOf("DOG"));
		System.out.println("CAT与DOG在枚举对象中比较结果为：" + compare);
		// 4.ordinal() 该方法用于得到枚举成员的位置索引
		int indexDog = petDog.ordinal();
		System.out.println("枚举成员DOG的位置为：" + indexDog);
	}
}
