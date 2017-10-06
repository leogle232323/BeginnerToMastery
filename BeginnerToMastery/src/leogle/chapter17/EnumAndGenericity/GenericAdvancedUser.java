package leogle.chapter17.EnumAndGenericity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

//1.限制泛型可用类型
class LimitClass<T extends List> {

}

// 2.使用类型通配符
class WildCardClass<T extends List> {
	public void doSomething(WildCardClass<? extends List> a) {
		System.out.println("do something...");
	}
}

// 3.泛型类：继承泛型类与实现泛型接口
// 3.1 继承泛型类与实现泛型接口
class ExtendClass<T1> {

}

// 保留父类的泛型类型，如果不指明，则默认为Object类型
class SubClass<T1, T2, T3> extends ExtendClass<T1> {

}

// 3.2实现泛型接口
interface GenericInterface<T1> {

}

class SubClass2<T1, T2, T3> implements GenericInterface<T1> {

}

public class GenericAdvancedUser {
	// 1.限制泛型使用类型
	@Test
	public void test1() {
		// 可以实例化已经实现List接口的类
		LimitClass<ArrayList> l1 = new LimitClass<>();
		LimitClass<LinkedList> l2 = new LimitClass<>();
		// 不能实例化没有实现List接口的类
		// LimitClass<HashMap> l3 = new LimitClass<>();
	}

	// 2.使用类型通配符创建对象
	@Test
	public void test2() {
		WildCardClass<? extends List> a = null;
		a = new WildCardClass<ArrayList>();
		a = new WildCardClass<LinkedList>();
		// 1.使用通配符，向下限制
		a.doSomething(a);

		List<String> list = new ArrayList<>();
		list.add("成员");
		// 使用通配符
		List<?> list2 = list;
		List<?> list3 = new LinkedList<Integer>();
		System.out.println(list2.get(0));

		// 3.使用通配符初始化出来的对象，不能添加新的信息，只能获取或删除（因为不知道List里面的具体类型）
		// list2.add("ha");

		// 2.泛型还支持向上限制
		List<? super List> b = null;
		b = new ArrayList<Object>();
		// b= new ArrayList<ArrayList>();
	}

	// 3.继承泛型类、实现泛型接口
	@Test
	public void test3() {
		// 继承泛型类
		ExtendClass<String> m1 = new ExtendClass<>();
		SubClass<Object, Object, Object> m2 = new SubClass<>();
		// 实现泛型接口
		SubClass2<Object, Object, Object> m3 = new SubClass2<>();
	}
}
