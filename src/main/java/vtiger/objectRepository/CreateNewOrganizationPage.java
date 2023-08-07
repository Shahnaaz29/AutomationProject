package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	//Declaration
@FindBy(name="accountname")
private WebElement OrgnameEdt;
@FindBy(name="industry")
private WebElement IndustryDropDown;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement SaveBtn;

    //Initialization
public CreateNewOrganizationPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

//utilisation
public WebElement getOrgnameEdt() {
	return OrgnameEdt;
}

public WebElement getIndustryDropDown() {
	return IndustryDropDown;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

//Business Library
/**
 * This method will create Organization
 * @param ORGNAME
 */
public void createOrganization(String ORGNAME)
{
	OrgnameEdt.sendKeys(ORGNAME);
	SaveBtn.click();
}

/**
 * This method will create organization with industry dropdown
 * @param ORGNAME
 * @param INDUSTRY
 */
public void createOrganization(String ORGNAME,String INDUSTRY)
{
	OrgnameEdt.sendKeys(ORGNAME);
	handleDropDown(IndustryDropDown,INDUSTRY);
	SaveBtn.click();
}


}
