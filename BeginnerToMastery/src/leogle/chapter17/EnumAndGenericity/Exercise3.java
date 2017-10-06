package leogle.chapter17.EnumAndGenericity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 3.尝试定义一个泛型类，并使用通配符
 */

public class Exercise3 {
	@Test
	public void test() {
		// 通配符？
		List<?> list = null;
		list = new ArrayList<>();
		list = new LinkedList<>();

	}
}
