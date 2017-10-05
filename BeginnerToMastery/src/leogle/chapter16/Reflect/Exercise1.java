package leogle.chapter16.Reflect;

import java.lang.reflect.Array;

import org.junit.Test;

/**
 * 1.利用反射实现通用扩展数组长度的方法
 * 
 */
public class Exercise1 {
	/**
	 * 通用扩展数组长度
	 * 
	 * @param Object
	 * 
	 */
	static Object goodArrayGrow(Object a) {
		// 1.获得对象的类型
		Class<?> c = a.getClass();
		if (!c.isArray()) {
			return null;
		}
		// 2.获得数组组成元素的类型
		Class<?> componentType = c.getComponentType();
		// 3.获得数组长度
		int length = Array.getLength(a);
		// 4.生存新的数组长度
		int newLength = length + 10;
		// 5.创建新的数组对象
		Object newArray = Array.newInstance(componentType, newLength);
		// 6.复制老的数组到新的数组中
		System.arraycopy(a, 0, newArray, 0, length);
		return newArray;
	}

	@Test
	public void test() {
		int[] arr = new int[] { 3, 4, 4, 6 };
		System.out.println("扩展之前数组长度为：" + arr.length);
		System.out.println("数组元素为：");
		for (Integer value : arr) {
			System.out.print(value + "  ");
		}
		System.out.println();

		int[] newArr = (int[]) goodArrayGrow(arr);
		System.out.println("扩展之后数组长度为：" + newArr.length);
		System.out.println("数组元素为：");
		for (Integer value : newArr) {
			System.out.print(value + "  ");
		}
	}
}
