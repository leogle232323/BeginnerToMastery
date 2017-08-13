package leogle.chapter14.CollectionClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 创建Map集合，创建Emp对象，并将Emp对象添加到集合中(Emp对象的id作为Map集合的键),并将id为"015"的对象从集合中移除
 */
public class Exercise3 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		Emp emp1 = new Emp("010", "小小");
		Emp emp2 = new Emp("011", "火女");
		Emp emp3 = new Emp("015", "撼地神牛");
		map.put(emp1.getE_id(), emp1.getE_name());
		map.put(emp2.getE_id(), emp2.getE_name());
		map.put(emp3.getE_id(), emp3.getE_name());

		System.out.println("map集合内容为：");
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			String name = map.get(id);
			System.out.println(id + " " + name);
		}

		// 移除id为"015"的对象
		map.remove("015");
		System.out.println("移除对象'015'之后的集合内容为：");
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String id = iter.next();
			String name = map.get(id);
			System.out.println(id + " " + name);
		}
	}

}
