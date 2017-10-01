package leogle.chapter16.Reflect;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

//1.定义一个Annotation，不包含任何成员（marker annotation）
@interface NoMemberAnnotation {

}

// 2.定义一个包含一个成员的Annotation，一个成员时，通常将名称命名为value
@interface OneMemberAnnotation {
	String value();
}

// 3.定义一个包含多个成员的Annotation
@interface MoreMemberAnnotation {
	String describe();

	Class<?>type();
}

// 4.定义一个Annotation，成员设置了默认值
@interface DefaultValueAnnotation {
	String describe() default "<默认值>";

	Class<?>type() default void.class;
}

// 5.定义一个用来注释构造方法的Annotation类
// 用于构造方法
@Target(ElementType.CONSTRUCTOR)
// 运行时加载
@Retention(RetentionPolicy.RUNTIME)
@interface Constructor_Annotation {
	String value() default "默认构造方法";
}

// 6.定义一个用来注释字段、方法和参数的Annotation类
// 用于字段、方法和参数
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
// 运行时加载
@Retention(RetentionPolicy.RUNTIME)
@interface Field_Method_Parameter_Annotation {
	String describe();

	Class<?>type() default void.class;
}

class Record {
	@Field_Method_Parameter_Annotation(describe = "编号", type = int.class)
	int id;
	@Field_Method_Parameter_Annotation(describe = "姓名", type = String.class)
	String name;

	// 采用默认值注释构造方法
	@Constructor_Annotation()
	public Record() {

	}

	// 采用指定值注释构造方法
	@Constructor_Annotation("立即初始化构造方法")
	public Record(@Field_Method_Parameter_Annotation(describe = "编号", type = int.class) int id,
			@Field_Method_Parameter_Annotation(describe = "姓名", type = String.class) String name) {
		this.id = id;
		this.name = name;
	}

	@Field_Method_Parameter_Annotation(describe = "获得编号", type = int.class)
	public int getId() {
		return id;
	}

	// 成员type采用默认注释方法
	@Field_Method_Parameter_Annotation(describe = "设置编号")
	public void setId(@Field_Method_Parameter_Annotation(describe = "编号", type = int.class) int id) {
		this.id = id;
	}

	@Field_Method_Parameter_Annotation(describe = "获得姓名", type = String.class)
	public String getName() {
		return name;
	}

	@Field_Method_Parameter_Annotation(describe = "设置姓名")
	public void setName(@Field_Method_Parameter_Annotation(describe = "姓名", type = String.class) String name) {
		this.name = name;
	}
}

public class Annotations {
	@Test
	public void test() {
		Record record = new Record();
		Class<?> recordC = record.getClass();

		// 1.访问构造方法Annotation
		// 获得所有构造方法
		System.out.println("------访问构造方法Annotation------");
		Constructor<?>[] declaredConstructors = recordC.getDeclaredConstructors();
		// 遍历构造方法
		for (int i = 0; i < declaredConstructors.length; i++) {
			Constructor<?> constructor = declaredConstructors[i];
			// 查看是否具有指定类型的注释
			if (constructor.isAnnotationPresent(Constructor_Annotation.class)) {
				// 获得指定类型的注释
				Constructor_Annotation ca = constructor.getAnnotation(Constructor_Annotation.class);
				System.out.println("构造方法注释信息为：" + ca.value());
			}

			// 获得参数注释
			Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
			if (parameterAnnotations.length == 0) {
				System.out.println("构造方法" + constructor + "没有参数！");
			}
			for (int j = 0; j < parameterAnnotations.length; j++) {
				// 获得指定参数注释的长度
				int length = parameterAnnotations[j].length;
				// 如果长度为0，则表示没有为参数添加注释
				if (length == 0) {
					System.out.println("未添加Annotation参数");
				} else {
					for (int k = 0; k < length; k++) {
						// 获得参数的注释
						Field_Method_Parameter_Annotation pa = (Field_Method_Parameter_Annotation) parameterAnnotations[j][k];
						// 获得参数描述
						System.out.println("参数描述为：" + pa.describe());
						System.out.println("参数类型为：" + pa.type());
					}
				}
			}
			System.out.println("------分割线------");
		}

		// 2.访问字段的Annotation
		// 获得所有字段
		System.out.println("------访问字段的Annotation------");
		Field[] declaredFields = recordC.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Field field = declaredFields[i];
			// 查看是否具有指定类型的注释
			if (field.isAnnotationPresent(Field_Method_Parameter_Annotation.class)) {
				// 获得指定类型的注释
				Field_Method_Parameter_Annotation fa = field.getAnnotation(Field_Method_Parameter_Annotation.class);
				System.out.println("字段" + field.getName() + "描述为：" + fa.describe());
				System.out.println("字段" + field.getName() + "类型为：" + fa.type());
			}
		}

		// 3.访问方法及参数的Annotation
		System.out.println("------访问方法及参数的Annotation------");
		Method[] methods = recordC.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.isAnnotationPresent(Field_Method_Parameter_Annotation.class)) {
				Field_Method_Parameter_Annotation ma = method.getAnnotation(Field_Method_Parameter_Annotation.class);
				System.out.println("方法" + method.getName() + "描述为：" + ma.describe());
				System.out.println("方法" + method.getName() + "类型为：" + ma.type());
			}

			// 获得方法的参数的注释
			Annotation[][] parameterAnnotations = method.getParameterAnnotations();
			for (int j = 0; j < parameterAnnotations.length; j++) {
				int length = parameterAnnotations[j].length;
				if (length == 0) {
					System.out.println("参数" + parameterAnnotations[j] + "未添加Annotation");
				} else {
					for (int k = 0; k < length; k++) {
						Field_Method_Parameter_Annotation pa = (Field_Method_Parameter_Annotation) parameterAnnotations[j][k];
						System.out.println("参数" + parameterAnnotations[j] + "描述为：" + pa.describe());
						System.out.println("参数" + parameterAnnotations[j] + "类型为：" + pa.type());
					}
				}
			}
		}

	}
}
