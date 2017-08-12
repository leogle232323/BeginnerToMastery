package leogle.chapter14.CollectionClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionInterface {

	public static void main(String[] args) {
		// 1.实例化集合类对象
		Collection<String> collection = new ArrayList<>();
		// 2.向集合添加对象
		collection.add("today");
		collection.add("is");
		collection.add("a nice day !");
		// 3.创建迭代器
		Iterator<String> it = collection.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
	}

}
