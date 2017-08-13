package leogle.chapter14.CollectionClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 将1~100之间的所有正整数存放在一个List集合中，并将集合中索引位置是10的对象从集合中移除
 * 
 */
public class Exercise1 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= 100; i++) {
			list.add(i);
		}
		list.remove(10);
		for (Integer value : list) {
			System.out.print(value + " ");
		}
	}

}
