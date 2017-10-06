package leogle.chapter17.EnumAndGenericity;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//1.定义泛型时声明多个类型
class MutiOverClass<T1, T2> {
	private T1 t1;
	private T2 t2;

	public void setT1(T1 t1) {
		this.t1 = t1;
	}

	public void setT2(T2 t2) {
		this.t2 = t2;
	}

	public T1 getT1() {
		return t1;
	}

	public T2 getT2() {
		return t2;
	}
}

// 2.定义泛型类时声明数组类型
class ArrayClass<T> {
	// 定义泛型数组
	private T[] array;
	// 不可以使用泛型建立数组实例
	// private T[] arr = new T[10];

	public void setT(T[] array) {
		this.array = array;
	}

	public T[] getT() {
		return array;
	}
}

// 3.集合类声明容器的元素
class CollectionClass<K, V> {
	// 定义一个集合HashMap实例
	public Map<K, V> m = new HashMap<>();

	public void put(K key, V value) {
		m.put(key, value);
	}

	public V get(K key) {
		return m.get(key);
	}

}

public class GenericCommonUse {
	// 1.定义泛型声明多个类型
	@Test
	public void test1() {

		MutiOverClass<Boolean, Float> m = new MutiOverClass<>();
		m.setT1(true);
		m.setT2(222.2f);
		System.out.println("t1值为：" + m.getT1());
		System.out.println("t2值为：" + m.getT2());
	}

	// 2.定义泛型时声明数组类型
	@Test
	public void test2() {
		ArrayClass<String> arr = new ArrayClass<>();
		String[] arrStr = { "aaa", "bbb", "ccc", "ddd" };
		arr.setT(arrStr);
		System.out.println("数组中的值为：");
		for (int i = 0; i < arr.getT().length; i++) {
			System.out.print(arr.getT()[i] + "  ");
		}
		System.out.println();
	}

	// 3.集合类声明容器的元素
	@Test
	public void test3() {
		CollectionClass<Integer, String> m = new CollectionClass<>();
		for (int i = 0; i < 5; i++) {
			m.put(i, "我是集合成员" + i);
		}
		for (int i = 0; i < m.m.size(); i++) {
			System.out.print(m.get(i) + "  ");
		}
	}

}
