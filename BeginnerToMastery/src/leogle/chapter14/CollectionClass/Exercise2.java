package leogle.chapter14.CollectionClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 分别向Set集合以及List集合中添加 "A"、"a"、"c"、"C"、"a" 5个元素，观察重复值"a" 能否在 List集合以及Set集合中成功地添加
 * 
 */
public class Exercise2 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("a");
		set.add("c");
		set.add("C");
		set.add("a");

		System.out.println("set集合内容为：");
		for (String value : set) {
			System.out.print(value + " ");
		}

		System.out.println();

		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("a");
		list.add("c");
		list.add("C");
		list.add("a");
		System.out.println("list集合内容为：");
		for (String value : list) {
			System.out.print(value + " ");
		}
	}

}
