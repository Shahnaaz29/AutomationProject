package vtiger.OrganisationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import vtiger.genericUtilities.BaseClass;

public class CreateOrgWithIndustry extends BaseClass
{
@Test(groups = "RegressionSuite")

public void createOrgWithindustry()
{
	//Create the Organization
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	//Click on Plus symbol 
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//pass the values 
	String orgname = "sss"+jutil.getRandomNumber();;
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	//Click on the DropDown
	WebElement Industrydropdown = driver.findElement(By.name("industry"));
	//Click on Chemicals
	Select se = new Select(Industrydropdown);
	se.selectByValue("Chemicals");
	//Click on save 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//Validate
	String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHeader.contains(orgname))
	{
		System.out.println("pass");
		System.out.println(OrgHeader);
	}
	else
	{
		System.out.println("Fail");
	}
	
}

}

