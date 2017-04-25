package VolumeI.Chapter05_Inheritance.Section07_Reflection.Part03_UsingReflectionToAnalyzeTheCapabilitiesOfClasses;

import java.lang.reflect.Field;

import VolumeI.Chapter05_Inheritance.eg.Employee;
import VolumeI.Chapter05_Inheritance.eg.Manager;
import basic.util.Basic;

public class Case03_GetClassFromAsset extends Basic{

	public static void main(String[] args){
		try{
//			test01(Employee.class);
//			test01(Manager.class);
			test02(Employee.class);		//exception, need public
			test02(Manager.class);		//exception, need public
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void test01(Class c){
		Field[] fArr = null;
		if((fArr=c.getFields()).length > 0 || (fArr=c.getDeclaredFields()).length>0){
			Field f = fArr[0];
			pl(f);
			pl(f.getDeclaringClass());
		}
		pl("********** test01 done **********");
	}

	public static void test02(Class c) throws Exception{
		Field f = c.getField("name");
		pl(f);
		pl("********** test02 done **********");
	} 
}
