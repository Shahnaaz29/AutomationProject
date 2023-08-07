package vtiger.OrganisationTests;

import org.testng.annotations.Test;

public class GenericMethodPractice {
@Test
	public static int add(int a,int b)//called method
	{
		int c=a+b;
		return c;
	}
	public static void main(String[] args) //calling method
	{
		int result=add(12,13);
		System.out.println(result);
	}
	
	
}
