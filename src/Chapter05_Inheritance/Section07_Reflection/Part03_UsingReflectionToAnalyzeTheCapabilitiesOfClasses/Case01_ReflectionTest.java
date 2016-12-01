package Chapter05_Inheritance.Section07_Reflection.Part03_UsingReflectionToAnalyzeTheCapabilitiesOfClasses;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import basic.util.Basic;

public class Case01_ReflectionTest extends Basic{

	public static void main(String[] args){
		try{
			test01(args);
		}catch(Exception e){
			e.printStackTrace();
		}



	}

	public static void test01(String[] args) throws Exception{
		//read class name from command line args or user input
		String name;
		if(args.length > 0){
			name = args[0];
		}else{
			Scanner in = new Scanner(System.in);
			p("Enter class name (e.g. java.util.Date): ");
			name = in.next();
		}

		//print class name and superclass name(if != Object)
		Class c1 = Class.forName(name);
		Class superc1 = c1.getSuperclass();
		String modifiers = Modifier.toString(c1.getModifiers());
		if(modifiers!=null && !modifiers.isEmpty()){
			p(modifiers + " ");
		}
		p("class " + name);
		if(superc1 != null && superc1 != Object.class){
			p(" extends " + superc1.getName());
		}
		p("\n{\n");
		printConstructors(c1);
		pl();
		printMethods(c1);
		pl();
		printFields(c1);
		pl("}");

	}

	private static void printConstructors(Class c1) {
		Constructor[] constructors = c1.getDeclaredConstructors();

		for (Constructor c : constructors)
		{
			String name = c.getName();
			p(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) p(modifiers + " ");
			p(name + "(");

			// print parameter types
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
			{
				if (j > 0) p(", ");
				p(paramTypes[j].getName());
			}
			pl(");");
		}
	}

	/**
	 * Prints all methods of a class
	 * @param cl a class
	 */
	public static void printMethods(Class cl)
	{
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods)
		{
			Class retType = m.getReturnType();
			String name = m.getName();

			p(" ");
			// print modifiers, return type and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) p(modifiers + " ");
			p(retType.getName() + " " + name + "(");

			// print parameter types
			Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
			{
				if (j > 0) p(", ");
				p(paramTypes[j].getName());
			}
			pl(");");
			pl(retType);
		}
	}

	/**
	 * Prints all fields of a class
	 * @param cl a class
	 */
	public static void printFields(Class cl)
	{
		Field[] fields = cl.getDeclaredFields();

		for (Field f : fields)
		{
			Class type = f.getType();
			String name = f.getName();
			p(" ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0) p(modifiers + " ");
			pl(type.getName() + " " + name + ";");
		}
	}

}
