package leogle.chapter14.CollectionClass;

import java.util.Iterator;
import java.util.TreeSet;

//1.创建类实现Comparable接口
public class SetInterface implements Comparable<Object> {
	String name;
	long id;

	// 2.构造方法
	public SetInterface(String name, long id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public long getId() {
		return this.id;
	}

	// 3.重写比较方法
	@Override
	public int compareTo(Object o) {
		SetInterface upstu = (SetInterface) o;
		int result = id > upstu.id ? 1 : (id == upstu.id ? 0 : -1);
		return result;
	}

	public static void main(String[] args) {
		SetInterface stu1 = new SetInterface("李同学", 01011);
		SetInterface stu2 = new SetInterface("陈同学", 01021);
		SetInterface stu3 = new SetInterface("王同学", 01031);
		SetInterface stu4 = new SetInterface("马同学", 01041);
		TreeSet<SetInterface> set = new TreeSet<>();
		set.add(stu1);
		set.add(stu2);
		set.add(stu3);
		set.add(stu4);
		Iterator<SetInterface> it = set.iterator();
		System.out.println("set集合中的所有元素：");
		while (it.hasNext()) {
			SetInterface stu = it.next();
			System.out.println(stu.getName() + " " + stu.getId());
		}

		// 4.截取排在stu2对象之前的对象 [...,stu2)
		it = set.headSet(stu2).iterator();
		System.out.println("截取前面部分的集合：");
		while (it.hasNext()) {
			SetInterface stu = it.next();
			System.out.println(stu.getName() + " " + stu.getId());
		}

		// 5.截取排在stu2与stu3之间的对象 [stu2,stu3)
		it = set.subSet(stu2, stu3).iterator();
		System.out.println("截取中间部分的集合：");
		while (it.hasNext()) {
			SetInterface stu = it.next();
			System.out.println(stu.getName() + " " + stu.getId());
		}

		// 6.截取stu2之后的对象[stu2,...]
		it = set.tailSet(stu2).iterator();
		System.out.println("截取后面部分的集合：");
		while (it.hasNext()) {
			SetInterface stu = it.next();
			System.out.println(stu.getName() + " " + stu.getId());
		}
	}

}
