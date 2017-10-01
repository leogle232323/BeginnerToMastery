package leogle.chapter16.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

interface Education {
	public boolean education();
}

interface BringUp {
	public boolean bringUp();
}

class Father {
	public String name;
	@SuppressWarnings("unused")
	private byte age;
	String isOld;

	Father() {
		System.out.println("父亲无参构造函数~");
	}

	public Father(String name) {
		System.out.println("父亲有一个参数构造函数~");
	}

	public void eat(String food) {
		System.out.println("父亲无参公有方法~");
	}

	void sleep() {
		System.out.println("父亲无参默认权限方法~");
	}

	public class HardWorking {

	}

	class Shame {

	}
}

class Son extends Father implements Education, BringUp {
	public String sex;
	@SuppressWarnings("unused")
	private String motherName;
	String fatherName;

	Son() {
		System.out.println("子类无参构造方法~");
	}

	@SuppressWarnings("unused")
	private Son(String name, String age, String sex) {

	}

	public Son(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public Son(String... strings) {

	}

	public boolean growUp() {
		System.out.println("儿子慢慢成长~");
		return false;
	}

	@Override
	public boolean bringUp() {
		System.out.println("接口方法，儿子教育下一代~");
		return true;
	}

	@Override
	public boolean education() {
		System.out.println("接口方法，儿子养育下一代~");
		return true;
	}

	public class CharacterOuter {
		String characterOuter;
	}

	class CharacterInner {
		String characterInner;
	}

}

public class ClassAndReflect {
	@Test
	public void testReflect() {
		String name = "leogle";
		String sex = "male";
		Son son = new Son(name, sex);
		Class<? extends Son> sonClass = son.getClass();

		// 1.获得类的存放路径（包路径）
		Package pkg = sonClass.getPackage();
		System.out.println("类Son的存放路径为：" + pkg);

		// 2.获得类的名字
		String className = sonClass.getName();
		System.out.println("类Son的名称（全名）为：" + className);

		// 3.获得该类继承的类（父类）
		Class<?> superClass = sonClass.getSuperclass();
		System.out.println("类Son的父类（全名）为：" + superClass);

		// 4.获得该类实现的接口
		Class<?>[] interfaces = sonClass.getInterfaces();
		System.out.println("类Son实现的接口（全名）为：");
		for (Class<?> value : interfaces) {
			System.out.println(value);
		}

		// 5.获得类的构造方法
		// 5.1 获得所有权限为public的构造方法
		Constructor<?>[] constructors = sonClass.getConstructors();
		System.out.println("类Son所有权限为public的构造方法为：");
		for (Constructor<?> value : constructors) {
			System.out.println(value);
		}

		// 5.2 获得权限为public的指定构造方法）
		Constructor<?> constructor = null;
		try {
			constructor = sonClass.getConstructor(String.class, String.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("类Son权限为public的指定构造方法为：" + constructor);

		// 5.3 获得所有构造方法，按声明顺序返回
		Constructor<?>[] declaredConstruectors = sonClass.getDeclaredConstructors();
		System.out.println("类Son所有构造方法为：");
		for (Constructor<?> value : declaredConstruectors) {
			System.out.println(value);
		}

		// 5.4 获得指定构造方法
		Constructor<?> declaredConstructor = null;
		try {
			declaredConstructor = sonClass.getDeclaredConstructor(String.class, String.class, String.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("类Son指定构造方法为：" + declaredConstructor);

		// 6.获得类的方法
		// 6.1 获得所有权限为public的方法（包含父类的public方法）
		Method[] methods = sonClass.getMethods();
		System.out.println("类Son所有权限为public的方法为：");
		for (Method value : methods) {
			System.out.println(value);
		}

		// 6.2 获得权限为public的指定方法（包含父类的public方法）
		Method method = null;
		try {
			method = sonClass.getMethod("bringUp");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("权限为public的指定方法为：" + method);

		// 6.3获得所有方法，按声明顺序返回
		Method[] getDeclaredMethods = sonClass.getDeclaredMethods();
		System.out.println("类Son的所有方法为：");
		for (Method value : getDeclaredMethods) {
			System.out.println(value);
		}

		// 6.4获得指定方法
		Method getDeclaredMethod = null;
		try {
			getDeclaredMethod = sonClass.getDeclaredMethod("education");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("类Son指定方法为：" + getDeclaredMethod);

		// 7.获得类的成员变量
		// 7.1获得所有权限为public的成员变量（包含父类public成员变量）
		Field[] fields = sonClass.getFields();
		System.out.println("类Son所有权限为public的成员变量为：");
		for (Field value : fields) {
			System.out.println(value);
		}

		// 7.2 获得权限为public的指定成员变量（包含父类public成员变量）
		Field field = null;
		try {
			field = sonClass.getField("name");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("类Son权限为public的指定成员变量为：" + field);

		// 7.3获得所有成员变量，按声明顺序返回
		Field[] decalredFields = sonClass.getDeclaredFields();
		System.out.println("类Son所有成员变量为：");
		for (Field value : decalredFields) {
			System.out.println(value);
		}

		// 7.4获得指定成员变量
		Field declaredField = null;
		try {
			declaredField = sonClass.getDeclaredField("fatherName");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		System.out.println("类Son指定成员变量为:" + declaredField);

		// 8.获得内部类
		// 8.1获得所有权限为public的内部类（包含父类的内部类）
		Class<?>[] classes = sonClass.getClasses();
		System.out.println("类Son所有权限为public的内部类为：");
		for (Class<?> value : classes) {
			System.out.println(value);
		}

		// 8.2获得所有内部类（不包含父类的内部类）
		Class<?>[] declaredClasses = sonClass.getDeclaredClasses();
		System.out.println("类Son的所有内部类为：");
		for (Class<?> value : declaredClasses) {
			System.out.println(value);
		}

		// 9.获得内部类的声明类
		Class<?> declaringClass = Son.CharacterOuter.class.getDeclaringClass();
		if (declaringClass != null) {
			System.out.println("类CharacterOuter是内部类，其声明类为：" + declaringClass);
		} else {
			System.out.println("类CharacterOuter不是内部类~");
		}

	}

}
