package VolumeI.Chapter05_Inheritance.Section07_Reflection.Part01_TheClassClass;

import java.util.Date;

import VolumeI.Chapter05_Inheritance.eg.Employee;
import VolumeI.Chapter05_Inheritance.eg.Manager;
import basic.util.Basic;

public class Case01_GetClass extends Basic{
	
	public static void main(String[] args){
		try{
			test01();
			test02();
			test03();
			test04();
			test05();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void test01() throws Exception{
		Employee e = new Employee("Harry Hacker");
		Manager m = new Manager("Harry Hacker");
		pl(e.getClass().getSimpleName() + " " + e.getName());
		pl(e.getClass().getName() + " " + e.getName());
		pl(m.getClass().getSimpleName() + " " + m.getName());
		pl(m.getClass().getName() + " " + m.getName());
		
		pl("********** test01 done **********");
	}
	
	public static void test02() throws Exception{
		Date d = new Date();
		String name = Date.class.getName();
		String simpleName = d.getClass().getSimpleName();
		pl(name);
		pl(simpleName);
		
		Class c1 = Class.forName(name);
		pl("c1: " + c1);
//		Class c2 = Class.forName(simpleName);
//		pl("c2: " + c2);	//ClassNotFoundException
		
		pl("********** test02 done **********");
	}
	
	public static void test03() throws Exception{
		pl(int.class.getName());
		
		pl("********** test03 done **********");
	}
	
	public static void test04() throws Exception{
		byte b = 1;
		Object o1 = b;
		pl(byte.class);
		pl(o1.getClass().getName());
		
		short s = 1;
		Object o2 = s;
		pl(short.class);
		pl(o2.getClass().getName());
		
		int i = 1;
		Object o3 = i;
		pl(int.class);
		pl(o3.getClass().getName());
		
		long l = 1;
		Object o4 = l;
		pl(long.class);
		pl(o4.getClass().getName());
		
		float f = 1;
		Object o5 = f;
		pl(float.class);
		pl(o5.getClass().getName());
		
		double d = 1;
		Object o6 = d;
		pl(double.class);
		pl(o6.getClass().getName());
		
		boolean bl = true;
		Object o7 = bl;
		pl(boolean.class);
		pl(o7.getClass().getName());
		
		char c = 1;
		Object o8 = c;
		pl(char.class);
		pl(o8.getClass().getName());
		
		pl("********** test04 done **********");
	}
	
	public static void test05() throws Exception{
		byte[] b = {1};
		Object o1 = b;
		pl(byte[].class);
		pl(o1.getClass().getName());
		
		short[] s = {1};
		Object o2 = s;
		pl(short[].class);
		pl(o2.getClass().getName());
		
		int[] i = {1};
		Object o3 = i;
		pl(int[].class);
		pl(o3.getClass().getName());
		
		long[] l = {1};
		Object o4 = l;
		pl(long[].class);
		pl(o4.getClass().getName());
		
		float[] f = {1};
		Object o5 = f;
		pl(float[].class);
		pl(o5.getClass().getName());
		
		double[] d = {1};
		Object o6 = d;
		pl(double[].class);
		pl(o6.getClass().getName());
		
		boolean[] bl = {true};
		Object o7 = bl;
		pl(boolean[].class);
		pl(o7.getClass().getName());
		
		char[] c = {1};
		Object o8 = c;
		pl(char[].class);
		pl(o8.getClass().getName());
		
		pl("********** test05 done **********");
	}
}
