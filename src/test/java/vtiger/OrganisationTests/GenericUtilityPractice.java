package vtiger.OrganisationTests;

import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice
{
public static void main(String[] args) throws Throwable
{
	JavaUtility jutil=new JavaUtility();
	int value = jutil.getRandomNumber();
	System.out.println(value);
	
	System.out.println(jutil.getSystemDate());
	System.out.println(jutil.getSystemDateInFormat());
	
	PropertyFileUtility putil=new PropertyFileUtility();
	String value1 = putil.getDataFromPropertyFile("password");
	System.out.println(value1);
	ExcelFileUtility eutil=new ExcelFileUtility();
	Object value2 = eutil.getDataFromExcel("Organisation", 5, 4	);
	System.out.println(value2);
	
	eutil.writeDataintoExcel("sample", 2, 4, "shannu");
	System.out.println("data Added");
}
}