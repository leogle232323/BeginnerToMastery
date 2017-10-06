package leogle.chapter17.EnumAndGenericity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 2.尝试定义一个泛型类，使用extends关键字限制该泛型类的类型为List接口，并分别创建两个泛型对象
 */
class GenericEx2<T extends List> {

}

public class Exercise2 {
	@Test
	public void test() {
		// 泛型类，类型为ArrayList
		GenericEx2<ArrayList> a = new GenericEx2<ArrayList>();
		// 泛型类，类型为LinkedList
		GenericEx2<LinkedList> b = new GenericEx2<>();
	}
}
