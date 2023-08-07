package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;
//Initialisation
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
//Utilisation
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
//Business Library
	/**
	 * This method will click on create organization lookup image
	 */
	public void clickOnOrgLookUpImg()
	{
		createOrgLookUpImg.click();
	}
	
	
	
	
}
