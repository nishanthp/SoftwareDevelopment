package com.java.concepts;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Marker
public class Annotations {

	@SingleValue
	int random;

	@Custom
	public void something() {

	}

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException {
		Annotations a = new Annotations();
		Class<? extends Annotations> aclass = a.getClass();
		for (Field d : aclass.getFields()) {
			System.out.println(d.getAnnotation(SingleValue.class).n());
		}

	}
}

//// This class also has CustomIn annotation.
// class AnnotationsSub extends Annotations {
//
// public void something() {
//
// }
// }

@Documented
@Target({ElementType.METHOD})
@interface Custom {

}

// Types of annotations.
@interface Marker {

}

@interface SingleValue {
	int n() default 10;
}

@interface MultiValue {
	int val1() default 10;
	int val2() default 12;
}