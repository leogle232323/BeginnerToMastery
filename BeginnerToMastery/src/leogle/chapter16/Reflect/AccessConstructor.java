package leogle.chapter16.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Test;

class Example {
	String s;
	int i, i2, i3;

	@SuppressWarnings("unused")
	private Example() {

	}

	protected Example(String s, int i) {
		this.s = s;
		this.i = i;
	}

	public Example(String... strings) {
		if (0 < strings.length) {
			i = Integer.valueOf(strings[0]);
		}
		if (1 < strings.length) {
			i2 = Integer.valueOf(strings[1]);
		}
		if (2 < strings.length) {
			i3 = Integer.valueOf(strings[2]);
		}

	}

	public void print() {
		System.out.println("s=" + s);
		System.out.println("i=" + i);
		System.out.println("i2=" + i2);
		System.out.println("i3=" + i3);
	}
}

public class AccessConstructor {
	@Test
	public void test() {
		Example example = new Example();
		Class<?> exampleC = example.getClass();
		Constructor<?>[] declaredConstructors = exampleC.getDeclaredConstructors();

		// 1.Constructor类的常用方法
		// 1.1查看构造方法是否允许带有可变数量的参数
		for (Constructor<?> value : declaredConstructors) {
			if (value.isVarArgs()) {
				System.out.println("构造方法" + value + "允许带有可变数量的参数~");
			} else {
				System.out.println("构造方法" + value + "不允许带有可变数量的参数~");
			}
		}

		// 1.2获得构造方法的各个参数类型（按照声明顺序）
		for (Constructor<?> value : declaredConstructors) {
			Class<?>[] parameterTypes = value.getParameterTypes();
			if (parameterTypes.length == 0) {
				System.out.println("构造方法" + value + "无参数~");
			} else {
				System.out.println("构造方法" + value + "各个参数类型为：");
				for (Class<?> valueType : parameterTypes) {
					System.out.println(valueType);
				}
			}
		}

		// 1.3获得构造方法可能抛出的异常信息
		for (Constructor<?> value : declaredConstructors) {
			Class<?>[] exceptionTypes = value.getExceptionTypes();
			if (exceptionTypes.length == 0) {
				System.out.println("构造方法" + value + "无可能抛出的异常类型~");
			} else {
				System.out.println("构造方法" + value + "可能抛出的异常类型为：");
				for (Class<?> valueException : exceptionTypes) {
					System.out.println(valueException);
				}
			}
		}

		// 1.4通过构造方法创建一个该类的对象
		for (Constructor<?> value : declaredConstructors) {
			try {
				value.newInstance();
			} catch (Exception e) {
				System.out.println("构造方法" + value + "创建对象异常~");
			}
		}

		// 1.5设置构造方法权限
		for (Constructor<?> value : declaredConstructors) {
			value.setAccessible(true);
			try {
				value.newInstance();
			} catch (Exception e) {
				System.out.println("构造方法" + value + "创建对象异常~");
			}
		}

		// 1.6获得可以解析出该构造方法所采用的修饰符的整数
		for (Constructor<?> value : declaredConstructors) {
			int modifier = value.getModifiers();
			System.out.println("构造方法" + value + "的modifier整数为" + modifier);
		}

		// 2.Modifier类中的常用解析方法
		// 2.1查看是否被public修饰符修饰
		for (Constructor<?> value : declaredConstructors) {
			int modifier = value.getModifiers();
			if (Modifier.isPublic(modifier)) {
				System.out.println("构造方法" + value + "被public修饰符修饰~");
			} else {
				System.out.println("构造方法" + value + "未被public修饰符修饰~");
			}
		}

		// 2.2查看是否被protected修饰符修饰
		for (Constructor<?> value : declaredConstructors) {
			int modifier = value.getModifiers();
			if (Modifier.isProtected(modifier)) {
				System.out.println("构造方法" + value + "被protected修饰符修饰~");
			} else {
				System.out.println("构造方法" + value + "未被protected修饰符修饰~");
			}
		}

		// 2.3查看是否被private修饰符修饰
		for (Constructor<?> value : declaredConstructors) {
			int modifier = value.getModifiers();
			if (Modifier.isPrivate(modifier)) {
				System.out.println("构造方法" + value + "被private修饰符修饰~");
			} else {
				System.out.println("构造方法" + value + "未被private修饰符修饰~");
			}
		}

		// 2.4查看是否被static修饰符修饰
		for (Constructor<?> value : declaredConstructors) {
			int modifier = value.getModifiers();
			if (Modifier.isStatic(modifier)) {
				System.out.println("构造方法" + value + "被static修饰符修饰~");
			} else {
				System.out.println("构造方法" + value + "未被static修饰符修饰~");
			}
		}

		// 2.5查看是否被final修饰符修饰
		for (Constructor<?> value : declaredConstructors) {
			int modifier = value.getModifiers();
			if (Modifier.isFinal(modifier)) {
				System.out.println("构造方法" + value + "被final修饰符修饰~");
			} else {
				System.out.println("构造方法" + value + "未被final修饰符修饰~");
			}
		}

		// 2.6以字符串的形式返回所有修饰符
		for (Constructor<?> value : declaredConstructors) {
			int modifier = value.getModifiers();
			System.out.println("构造方法" + value + "所有修饰符为：" + Modifier.toString(modifier));
		}
	}

	@Test
	public void testExample() {
		Example e = new Example();
		Class<?> exampleC = e.getClass();
		Constructor<?>[] constructors = exampleC.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++) {
			Constructor<?> constructor = constructors[i];
			System.out.println("------查看是否允许带有可变量的参数------");
			System.out.println(constructor + ":" + constructor.isVarArgs());
			System.out.println("------获取所有参数类型------");
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			for (Class<?> value : parameterTypes) {
				System.out.println(value);
			}
			System.out.println("------获取所有可能抛出的异常信息类型------");
			Class<?>[] exceptionTypes = constructor.getExceptionTypes();
			for (Class<?> value : exceptionTypes) {
				System.out.println(value);
			}

			Example example = null;
			while (example == null) {

				try {
					if (parameterTypes.length == 0) {
						example = (Example) constructor.newInstance();
						break;
					} else if (parameterTypes.length == 2) {
						example = (Example) constructor.newInstance("5", 5);
						break;
					} else if (parameterTypes.length == 1) {
						String[] str = new String[] { "3", "4" };
						// 将str数组转换为Object对象，否则编译器会将str当做可变长度的参数
						example = (Example) constructor.newInstance((Object) str);
						break;
					}
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// 设置允许访问构造方法
					constructor.setAccessible(true);
					System.out.println("权限不够！");
				} catch (IllegalArgumentException e1) {
					System.out.println("参数非法！");
					e1.printStackTrace();
					break;
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
			}
			example.print();
		}
	}

}
