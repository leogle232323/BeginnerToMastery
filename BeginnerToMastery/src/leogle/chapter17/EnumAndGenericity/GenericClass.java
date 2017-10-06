package leogle.chapter17.EnumAndGenericity;

import org.junit.Test;

//定义泛型类
class OverClass<T> {
	// 定义泛型成员变量
	private T over;

	public T getOver() {
		return over;
	}

	public void setOver(T over) {
		this.over = over;
	}
}

public class GenericClass {
	@Test
	public void test() {
		// 实例化一个Boolean型对象
		OverClass<Boolean> over1 = new OverClass<>();
		// 实例化一个Float型对象
		OverClass<Float> over2 = new OverClass<>();
		// 不需要进行类型转换
		over1.setOver(true);
		over2.setOver(12.4f);
		// 不需要进行类型转换
		Boolean b = over1.getOver();
		Float f = over2.getOver();
		// 编译时就会报错（类型不匹配）
		// Integer i = over2.getOver();
		System.out.println(b);
		System.out.println(f);
	}

}
