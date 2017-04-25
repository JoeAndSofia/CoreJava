package VolumeI.Chapter05_Inheritance.Section07_Reflection.Part03_UsingReflectionToAnalyzeTheCapabilitiesOfClasses;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import basic.util.Basic;

public class Case02_GetClassAsset extends Basic{

	public static void main(String[] args){
		
		Class c = Date.class;
		
		test01(c);
		test02(c);
		test03(c);
		test04(c);
		test05(c);
		test06(c);
	}

	public static void test01(Class c){
		Field[] fieldArray = c.getFields();
		for(Field field : fieldArray){
			pl(field);
		}
		pl("********** test01 done **********");
	}
	
	public static void test02(Class c){
		Field[] fieldArray = c.getDeclaredFields();
		for(Field field : fieldArray){
			pl(field);
		}
		pl("********** test02 done **********");
	}

	public static void test03(Class c){
		Method[] methodArray = c.getMethods();
		for(Method method : methodArray){
			pl(method);
		}
		pl("********** test03 done **********");
	}

	public static void test04(Class c){
		Method[] methodArray = c.getDeclaredMethods();
		for(Method method : methodArray){
			pl(method);
		}
		pl("********** test04 done **********");
	}
	
	public static void test05(Class c){
		Constructor[] constructorArray = c.getConstructors();
		for(Constructor constructor : constructorArray){
			pl(constructor);
		}
		pl("********** test05 done **********");
	}
	
	public static void test06(Class c){
		Constructor[] constructorArray = c.getDeclaredConstructors();
		for(Constructor constructor : constructorArray){
			pl(constructor);
		}
		pl("********** test06 done **********");
	}
}
