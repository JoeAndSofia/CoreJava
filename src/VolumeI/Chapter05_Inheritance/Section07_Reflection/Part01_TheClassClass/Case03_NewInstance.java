package VolumeI.Chapter05_Inheritance.Section07_Reflection.Part01_TheClassClass;

import java.util.Date;

import VolumeI.Chapter05_Inheritance.eg.Employee;
import basic.util.Basic;

public class Case03_NewInstance extends Basic{

	public static void main(String[] args){
		try{
			test01("java.util.Date");
			test02("basic.eg.Employee");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void test01(String className) throws Exception{
		Object o = Class.forName(className).newInstance();
		long t = ((Date)o).getTime();
		pl(t);
		
		pl("********** test01 done **********");
	}
	
	public static void test02(String className) throws Exception{
		/*
		 * Exception: no-argument constructor is not defined in class Employee.
		 * Hint: Try learn class Constructor
		 */
		Object o = Class.forName(className).newInstance();	 
		pl(o);
		
		pl("********** test02 done **********");
	}
}
