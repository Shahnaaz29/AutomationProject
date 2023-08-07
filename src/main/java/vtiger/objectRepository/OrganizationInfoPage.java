package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//Business Library
	/**
	 * This method will capture the header text on organization and return it to caller
	 */
	public String getHeaderText()
	{
		return orgHeaderText.getText();
		 
	}
}
