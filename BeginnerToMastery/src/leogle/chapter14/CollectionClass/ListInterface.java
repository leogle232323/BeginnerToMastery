package leogle.chapter14.CollectionClass;

import java.util.ArrayList;
import java.util.List;

public class ListInterface {

	public static void main(String[] args) {
		// 1.创建List集合类对象
		List<String> list = new ArrayList<>();
		// 2.向集合添加元素
		list.add("a");
		list.add("b");
		list.add("c");
		// 3.获得[0,2)之间的随机数
		int i = (int) Math.random() * (list.size() - 1);
		System.out.println("随机获取集合中的元素：" + list.get(i));
		// 4.将指定索引位置的元素从集合中移除
		list.remove(2);
		System.out.println("将索引是'2'的元素从集合移除后，集合中的元素是：");
		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}

	}

}
