package leogle.chapter16.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassAndReflect {

	public static void main(String[] args) throws SecurityException {
		String str = new String("i am a string!");
		Class strC = str.getClass();

		// 1.获取类的存放路径
		Package pkg = strC.getPackage();
		System.out.println("类String的存放路径(包名)为：" + pkg);

		// 2.获取类的名称
		String name = strC.getName();
		System.out.println("类String的名称(全名)为：" + name);

		// 3.获取类的继承类
		Class superClass = strC.getSuperclass();
		System.out.println("类String的继承类(父类)为：" + superClass);

		// 4.获取类的实现接口
		Class[] interfaces = strC.getInterfaces();
		System.out.println("类String实现的接口为：");
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println("接口：" + interfaces[i]);
		}

		// 5.获取构造方法
		// 5.1 获得所有权限为public的构造方法
		Constructor[] constructors = strC.getConstructors();
		System.out.println("所有权限为public的构造方法为：");
		for (Constructor value : constructors) {
			System.out.println(value);
		}

		// 5.2 获得权限为public的指定构造方法
		Constructor constructor;
		try {
			constructor = strC.getConstructor(char[].class, boolean.class);
			System.out.println("权限为public的指定构造方法(参数为byte[])为：" + constructor);
		} catch (NoSuchMethodException e) {
			System.out.println("没有这样的public构造方法！");
		}

		// 5.3 获得所有构造方法，按声明顺序返回
		Constructor[] allConstructors = strC.getDeclaredConstructors();
		System.out.println("所有构造方法为：");
		for (Constructor value : allConstructors) {
			System.out.println(value);
		}

		// 5.4 获得指定构造方法
		Constructor declaredConstructor;
		try {
			declaredConstructor = strC.getDeclaredConstructor(char[].class, boolean.class);
			System.out.println("指定构造方法为：" + declaredConstructor);
		} catch (NoSuchMethodException e) {
			System.out.println("没有这样的构造方法！");
		}

		// 6.获取方法
		// 6.1 获得所有权限为public的方法(包含从超类继承的成员方法)
		Method[] publicMethods = strC.getMethods();
		System.out.println("所有权限为public的构造方法为：");
		for (Method value : publicMethods) {
			System.out.println(value);
		}

		// 6.2 获得权限为public的指定方法
		try {
			Method publicMethod = strC.getMethod("matches", String.class);
			System.out.println("指定方法为：" + publicMethod);
		} catch (NoSuchMethodException e) {
			System.out.println("没有这样的方法！");
		}

		// 6.3获得所有方法，按声明顺序返回(不包含从超类继承的方法，只获取本类定义的方法)
		Method[] allMethods = strC.getDeclaredMethods();
		System.out.println("所有方法为：");
		for (Method value : allMethods) {
			System.out.println(value);
		}

		// 6.4获得指定方法
		try {
			Method declaredMethod = strC.getDeclaredMethod("checkBounds", byte[].class, int.class, int.class);
			System.out.println("指定方法为：" + declaredMethod);
		} catch (NoSuchMethodException e) {
			System.out.println("没有这样的方法！");
		}

		// 7.获取成员变量
		// 7.1获得所有权限为public的成员变量(包含从超类继承的成员变量)
		Field[] fields = strC.getFields();
		System.out.println("所有权限为public的成员变量为：");
		for (Field value : fields) {
			System.out.println(value);
		}

		// 7.2获得权限为public的指定成员变量
		try {
			Field field = strC.getField("CASE_INSENSITIVE_ORDER");
			System.out.println("权限为public的指定成员变量为：" + field);
		} catch (NoSuchFieldException e) {
			System.out.println("没有这样的成员变量！");
		}

		// 7.3获得所有成员变量，按声明顺序返回(不包含从超类继承的成员变量，只获取本类定义的成员变量)
		Field[] declaredFields = strC.getDeclaredFields();
		System.out.println("所有成员变量为：");
		for (Field value : declaredFields) {
			System.out.println(value);
		}

		// 7.4获得指定成员变量
		try {
			Field declaredField = strC.getDeclaredField("serialVersionUID");
			System.out.println("指定成员变量为：" + declaredField);
		} catch (NoSuchFieldException e) {
			System.out.println("没有这样的成员变量！");
		}

		// 8.获取内部类
		// 8.1获得所有权限为public的内部类
		Class[] classes = strC.getClasses();
		System.out.println("所有权限为public的内部类为：" + classes);
		for (Class value : classes) {
			System.out.println(classes);
		}

		// 8.2获得所有内部类
		Class[] declaredClasses = strC.getDeclaredClasses();
		System.out.println("所有内部类为：" + declaredClasses);
		for (Class value : declaredClasses) {
			System.out.println(value);
		}

		// 9.获取内部类的声明类
		Class declaringClass = strC.getDeclaringClass();
		if (declaringClass != null) {
			System.out.println("内部类的声明类为：" + declaringClass);
		} else {
			System.out.println("该类不为内部类！");
		}

	}

}
