package VolumeI.Chapter05_Inheritance.Section07_Reflection.Part01_TheClassClass;

import VolumeI.Chapter05_Inheritance.eg.Employee;
import basic.Basic;

public class Case02_CompareClass extends Basic{

	public static void main(String[] args){
		test01();
	}
	
	public static void test01(){
		Employee e1 = new Employee("joe wang");
		Employee e2 = new Employee("sofia liang");
		pl(e1.getClass()==Employee.class);
		pl(e1.getClass()==e2.getClass());
		
		pl("********** test01 done **********");
	}
}
