package vtiger.OrganisationTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.genericUtilities.BaseClass;
import vtiger.objectRepository.CreateNewOrganizationPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.OrganizationInfoPage;
import vtiger.objectRepository.OrganizationsPage;

public class CreateOrgWithIndustryUsingDDTTest extends BaseClass
{
@Test(groups = "SmokeSuite")
public void createOrgWithIndDDTTest() throws Throwable 
{	
		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eutil.getDataFromExcel("Organisation", 5, 2)+jutil.getRandomNumber();
		String INDUSTRY = eutil.getDataFromExcel("Organisation", 5, 3);
		
		
		//Step 5: Click on Organizations Link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		
		//Step 6: click on Create Organization look up image	
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnOrgLookUpImg();
		
		//Step 6: create Organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME, INDUSTRY);

		//Step 8: Validate
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader = oip.getHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
		
//		if(OrgHeader.contains(ORGNAME))
//		{
//			System.out.println("PASS");
//			System.out.println(OrgHeader);
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
		
		
}
@Test
public void Demo()
{
	System.out.println("Demo Program");
}
}
