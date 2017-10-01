package leogle.chapter16.Reflect;

import java.lang.reflect.Field;

import org.junit.Test;

class Example2 {
	int i;
	public float f;
	protected boolean b;
	private String s;
}

public class AccessField {
	@Test
	public void test() {
		Example2 example2 = new Example2();
		Class<?> example2C = example2.getClass();
		// 获得指定成员变量
		Field field = null;
		try {
			field = example2C.getDeclaredField("f");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		// 1.获得成员变量的名称
		System.out.println("成员变量" + field + "的名称为：" + field.getName());
		// 2.获得表示该成员变量类型的Class对象
		System.out.println("成员变量" + field + "的类型为：" + field.getType());
		// 3.获得指定对象中成员变量的值，返回值为Object类型
		try {
			System.out.println("指定对象中成员变量的 值为：" + field.get(example2));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		// 4.将指定对象中成员变量的值设置为value
		try {
			field.set(example2, 100.111f);
			System.out.println("将指定对象中成员变量的值设置为指定的值，设置之后值为：" + field.get(example2));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		// 5.获得指定对象中类型为int的成员变量的值
		try {
			System.out.println("指定对象中类型为int的成员变量的值为：" + field.getInt(example2));
		} catch (IllegalArgumentException e) {
			System.out.println("参数非法!");
		} catch (IllegalAccessException e) {
			System.out.println("无权访问!");
		}
		// 6.将指定对象中类型为int的成员变量的值设置为i
		try {
			field.setInt(example2, 100);
			System.out.println("将指定对象中类型为int的成员变量的值设置为i，设置之后值为：" + field.get(example2));
		} catch (IllegalArgumentException e) {
			System.out.println("参数非法！");
		} catch (IllegalAccessException e) {
			System.out.println("无权访问！");
		}
		// 7.获得指定对象中类型为float的成员变量的值
		try {
			System.out.println("获得指定对象中类型为float的成员变量的值为：" + field.getFloat(example2));
		} catch (IllegalArgumentException e) {
			System.out.println("参数非法！");
		} catch (IllegalAccessException e) {
			System.out.println("无权访问！");
		}
		// 8.将指定对象中类型为float的成员变量的值设置为f
		try {
			field.setFloat(example2, 111.11f);
			System.out.println("将指定对象中类型为float的成员变量的值设置为f,设置之后值为：" + field.getFloat(example2));
		} catch (IllegalArgumentException e) {
			System.out.println("参数非法！");
		} catch (IllegalAccessException e) {
			System.out.println("无权访问！");
		}
		// 9.获得指定变量中类型为boolean的成员变量的值
		try {
			System.out.println("获得指定对象中类型为boolean的成员变量的值：" + field.getBoolean(example2));
		} catch (IllegalArgumentException e) {
			System.out.println("参数非法！");
		} catch (IllegalAccessException e) {
			System.out.println("无权访问！");
		}
		// 10.将指定对象中类型为boolean的成员变量的值设置为z
		try {
			field.setBoolean(example2, true);
			System.out.println("将指定对象中类型为boolean的成员变量的值设置为z，设置之后为：" + field.get(example2));
		} catch (IllegalArgumentException e) {
			System.out.println("参数非法！");
		} catch (IllegalAccessException e) {
			System.out.println("无权访问！");
		}
		// 11.设置成员变量访问权限
		field.setAccessible(true);
		System.out.println("设置成员变量的访问权限，设置之后为：" + field.isAccessible());
		// 12.获得可以解析出该成员变量所采用的修饰符的整数
		System.out.println("获得可以解析出该成员变量所采用的修饰符的整数为：" + field.getModifiers());
	}

	@Test
	public void test2() {
		Example2 example2 = new Example2();
		Class<?> example2C = example2.getClass();
		// 获得所有成员变量
		Field[] fields = example2C.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			// 获得成员变量名称
			System.out.println("成员变量名称为：" + field.getName());
			// 获得成员变量类型
			Class<?> fieldType = field.getType();
			System.out.println("成员变量类型为：" + fieldType);
			boolean isTurn = true;
			while (isTurn) {
				isTurn = false;
				try {
					System.out.println("修改前的值为：" + field.get(example2));
					// 判断成员变量类型
					if (fieldType.equals(int.class)) {
						field.setInt(example2, 168);
					} else if (fieldType.equals(float.class)) {
						field.setFloat(example2, 122.222f);
					} else if (fieldType.equals(boolean.class)) {
						field.setBoolean(example2, true);
					} else {
						field.set(example2, "any");
					}
					System.out.println("修改后的值为：" + field.get(example2));
				} catch (IllegalArgumentException e) {
					System.out.println("参数非法！");
				} catch (IllegalAccessException e) {

					System.out.println("设置成员变量值时无权访问，下面执行授权方法！");
					field.setAccessible(true);
					isTurn = true;
				}

			}
			System.out.println("------分割线------");
		}
	}

}
