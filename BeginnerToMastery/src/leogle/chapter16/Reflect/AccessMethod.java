package leogle.chapter16.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

class Example3 {
	static void staticMethod() {
		System.out.println("执行 staticMethod()方法");
	}

	public int publicMethod(int i) {
		System.out.println("执行 publicMethod()方法");
		return i * 100;
	}

	protected int protectedMethod(String s, int i) {
		System.out.println("执行 protectedMethod()方法");
		return Integer.valueOf(s) + i;
	}

	private String privateMethod(String... strings) {
		System.out.println("执行 privateMethod()方法");
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < strings.length; i++) {
			stringBuffer.append(strings[i]);
		}
		return stringBuffer.toString();
	}
}

public class AccessMethod {
	@Test
	public void test() {
		Example3 example3 = new Example3();
		Class<?> example3C = example3.getClass();
		Method method = null;
		try {
			method = example3C.getMethod("publicMethod", int.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		// 1.获得方法的名称
		System.out.println("方法的名称为：" + method.getName());
		// 2.按照声明顺序以Class数组形式获得该方法的各个参数的类型
		Class<?>[] parameterTypes = method.getParameterTypes();
		System.out.println("各个参数类型为：");
		for (Class<?> value : parameterTypes) {
			System.out.println(value);
		}
		// 3.以Class对象的形式获得该方法的返回值的类型
		Class<?> returnType = method.getReturnType();
		System.out.println("方法的返回值类型为：" + returnType);
		// 4.以Class数组的形式获得该方法可能抛出的异常类型
		Class<?>[] exceptionTypes = method.getExceptionTypes();

		if (exceptionTypes.length != 0) {
			System.out.println("方法可能抛出的异常类型为：");
			for (Class<?> value : exceptionTypes) {
				System.out.println(value);
			}
		} else {
			System.out.println("方法无可能抛出的异常类型！");
		}
		// 5.利用指定参数执行指定对象中的该方法，返回值为Object类型
		try {
			System.out.println("利用指定参数执行指定对象中的该方法，返回值为Object类型：");
			method.invoke(example3, 3);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// 6.查看该方法是否允许带有可变数量的参数
		System.out.println("方法是否允许带有可变数量的参数：" + method.isVarArgs());
		// 7.获得可以解析出该方法所采用的修饰符的整数
		System.out.println("可以解析出该方法所采用的修饰符的整数为：" + method.getModifiers());
		// 8.查看方法是否被修饰符修饰
		int modifiers = method.getModifiers();
		// 8.1查看方法是否被public修饰
		System.out.println("方法是否被public修饰：" + Modifier.isPublic(modifiers));
		// 8.2查看方法是否被private修饰
		System.out.println("方法是否被private修饰：" + Modifier.isPrivate(modifiers));
		// 8.3查看方法是否被protected修饰
		System.out.println("方法是否被protected修饰：" + Modifier.isProtected(modifiers));
		// 8.4查看方法是否被static修饰
		System.out.println("方法是否被static修饰：" + Modifier.isStatic(modifiers));
		// 8.5查看方法是否被final修饰
		System.out.println("方法是否被final修饰：" + Modifier.isFinal(modifiers));
		// 8.6查看方法所有修饰符
		System.out.println("方法所有修饰符为：" + Modifier.toString(modifiers));
	}

	@Test
	public void test2() {
		Example3 example3 = new Example3();
		Class<?> example3C = example3.getClass();
		Method[] methods = example3C.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println("方法名称为：" + method.getName());
			System.out.println("方法是否允许带有可变数量的参数：" + method.isVarArgs());
			System.out.println("入口参数类型依次为：");
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (Class<?> value : parameterTypes) {
				System.out.println(value);
			}
			System.out.println("方法返回类型为：" + method.getReturnType());
			System.out.println("方法可能抛出的异常类型为：");
			Class<?>[] exceptionTypes = method.getExceptionTypes();
			for (Class<?> value : exceptionTypes) {
				System.out.println(value);
			}
			boolean isTurn = true;
			while (isTurn) {
				isTurn = false;
				// 根据方法名称执行不同的方法
				try {
					if ("staticMethod".equals(method.getName()))
						method.invoke(example3);
					else if ("publicMethod".equals(method.getName())) {
						method.invoke(example3, 111);
					} else if ("protectedMethod".equals(method.getName())) {
						method.invoke(example3, "11", 55);
					} else if ("privateMethod".equals(method.getName())) {
						Object[] para = new Object[] { new String[] { "haha", "heeh", "heihei" } };
						method.invoke(example3, para);
					}
				} catch (IllegalAccessException e) {
					System.out.println("执行方法时抛出异常，权限不够，下面执行获取权限方法：");
					method.setAccessible(true);
					isTurn = true;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			System.out.println("------分割线------");
		}

	}
}
