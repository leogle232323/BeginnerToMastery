package leogle.chapter14.CollectionClass;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapInterface {

	public static void main(String[] args) {
		// 1.创建map实例
		Map<String, String> map = new HashMap<>();
		// 2.向集合中添加对象
		map.put("01", "李同学");
		map.put("02", "魏同学");
		map.put("03", null);
		map.put(null, null);
		// 3.构建Map集合中所有Key对象的集合
		Set<String> set = map.keySet();
		// 4.创建集合迭代器
		Iterator<String> it = set.iterator();
		System.out.println("key集合中的元素：");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// 5.构建Map集合中所有values值集合
		Collection<String> values = map.values();
		it = values.iterator();
		System.out.println("values集合中的元素：");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
