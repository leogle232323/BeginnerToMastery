package leogle.chapter14.CollectionClass;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapAndTreeMap {

	public static void main(String[] args) {
		// 1.由HashMap实现的Map对象
		Map<String, String> map = new HashMap<>();
		Emp emp1 = new Emp("001", "张三");
		Emp emp2 = new Emp("002", "李四");
		Emp emp3 = new Emp("003", "王五");
		Emp emp4 = new Emp("004", "孙二");
		Emp emp5 = new Emp(null, null);
		// 2.将对象添加到集合
		map.put(emp4.getE_id(), emp4.getE_name());
		map.put(emp5.getE_id(), emp5.getE_name());
		map.put(emp1.getE_id(), emp1.getE_name());
		map.put(emp2.getE_id(), emp2.getE_name());
		map.put(emp3.getE_id(), emp3.getE_name());
		// 3.获取Map集合中的key对象集合
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		System.out.println("HashMap类实现的Map集合，无序：");
		while (it.hasNext()) {
			String str = it.next();
			String name = map.get(str);
			System.out.println(str + " " + name);
		}

		// 4.创建TreeMap集合对象
		TreeMap<String, String> treemap = new TreeMap<>();
		// 5.向集合添加对象，map中不能有值为null的键
		map.remove(null);
		treemap.putAll(map);
		Iterator<String> iter = treemap.keySet().iterator();
		System.out.println("TreeMap类实现的Map集合，键对象升序：");
		while (iter.hasNext()) {
			String str = iter.next();
			String name = treemap.get(str);
			System.out.println(str + " " + name);
		}

	}

}

class Emp {
	private String e_id;
	private String e_name;

	public Emp(String e_id, String e_name) {
		this.e_id = e_id;
		this.e_name = e_name;
	}

	public String getE_id() {
		return this.e_id;
	}

	public String getE_name() {
		return this.e_name;
	}
}
