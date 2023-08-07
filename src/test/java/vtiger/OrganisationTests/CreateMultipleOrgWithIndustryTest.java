package vtiger.OrganisationTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.genericUtilities.BaseClass;
import vtiger.objectRepository.CreateNewOrganizationPage;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.OrganizationInfoPage;
import vtiger.objectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass
{
	
	    @Test(dataProvider = "getData")
	    public void createMultipleOrg(String ORG, String INDUSTRY)  throws Throwable {

	      /* Read Data from Excel sheet - Test data */
	      String ORGNAME = ORG + jutil.getRandomNumber();

	      // Step 5: Click on Organizations Link
	      HomePage hp = new HomePage(driver);
	      hp.clickOnOrgLink();

	      // Step 6: click on Create Organization look up image
	      OrganizationsPage op = new OrganizationsPage(driver);
	      op.clickOnOrgLookUpImg();

	      // Step 6: create Organization
	      CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	      cnop.createOrganization(ORGNAME, INDUSTRY);

	      // Step 8: Validate
	      OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	      String OrgHeader = oip.getHeaderText();
	      Assert.assertTrue(OrgHeader.contains(ORGNAME));
	  	System.out.println(OrgHeader);
	  	
//	      if (OrgHeader.contains(ORGNAME)) 
//        {
//	        System.out.println("PASS");
//	        System.out.println(OrgHeader);
//	      }  	
//	  	else
//	  	{
//	        System.out.println("Fail");
//	      }
	    }

	    @DataProvider
	    public Object[][] getData() throws Throwable, IOException {
	      return eutil.readMultipleData("MultipleOrg");
	    }
}
