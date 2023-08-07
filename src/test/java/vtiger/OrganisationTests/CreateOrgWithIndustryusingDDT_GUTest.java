package vtiger.OrganisationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.genericUtilities.BaseClass;
@Listeners(vtiger.genericUtilities.ListenerImplementationClass.class)
public class CreateOrgWithIndustryusingDDT_GUTest extends BaseClass
{
	@Test
	public void createOrgWithIndDDTGUTest() throws Throwable
{
	
	/* Read Data from Excel sheet - Test data */
	String ORGNAME = eutil.getDataFromExcel("Organisation", 5, 2)+jutil.getRandomNumber();
	String INDUSTRY = eutil.getDataFromExcel("Organisation", 5, 3);
	
	
	//Step 5: Click on Organizations Link
	driver.findElement(By.linkText("Organizations")).click();
	Reporter.log("Organization clicked");
	
	//Step 6: click on Create Organization look up image
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	Reporter.log("Organization created");
	
	//Step 6: create Organization
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	
	//Step 6: Choose 'Chemicals' in industry drop down
	WebElement industryDropDown = driver.findElement(By.name("industry"));
	wutil.handleDropDown(industryDropDown, INDUSTRY);
	Reporter.log("Industry dropdown selected chemicals");
	
	//Step 7: save 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//Step 8: Validate
	String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	Assert.assertTrue(OrgHeader.contains(ORGNAME));
	System.out.println(OrgHeader);
}
//	if(OrgHeader.contains(ORGNAME))
//	{
//		System.out.println("PASS");
//		System.out.println(OrgHeader);
//	}
//	else
//	{
//		System.out.println("Fail");
//	}
	@Test
	public void demotest()
	{
		//Assert.fail();
		System.out.println("demo");
	}
}

