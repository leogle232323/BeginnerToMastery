package leogle.chapter17.EnumAndGenericity;

import org.junit.Test;

class Test1 {
	private Object b;

	public Object getB() {
		return b;
	}

	public void setB(Object b) {
		this.b = b;
	}
}

public class UpwardDownwardTransition {
	@Test
	public void test() {
		Test1 t = new Test1();
		// 向上转型
		t.setB(new Boolean(true));
		System.out.println("向上转型，b的值为：" + t.getB());
		t.setB(new Float(12.3f));
		// 向下转型
		Float f = (Float) t.getB();
		System.out.println("向下转型，b的值为：" + f);

		// 向下转型，报错（运行时异常）
		try {
			Integer i = (Integer) t.getB();
		} catch (ClassCastException e) {
			System.out.println("向下转型出错！");
		}

	}
}
