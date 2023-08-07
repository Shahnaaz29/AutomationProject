package vtiger.OrganisationTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
@Test(invocationCount = 0)
public void sampleTest()
{
	int a=1;//expected
	int b=2;//actual
	System.out.println("Step1");
	System.out.println("Step2");
	Assert.assertEquals(b, a);
	System.out.println("Step3");
	System.out.println("Step4");
	System.out.println("Execution and validation completed");
	
}
@Test
public void sampleTest1()
{
	SoftAssert sa=new SoftAssert();
	int a=1;//expected
	int b=2;//actual
	System.out.println("Step1");
	System.out.println("Step2");
	sa.assertEquals(b, a);
	System.out.println("Step3");
	System.out.println("Step4");
	sa.assertTrue(false);
	System.out.println("Execution and validation completed");
	sa.assertAll();//logging all the failures
}
}
	