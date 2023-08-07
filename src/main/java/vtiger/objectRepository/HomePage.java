package vtiger.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtilities.WebDriverUtility;
//rule1: create a class same as web page
public class HomePage extends WebDriverUtility
{
//rule2:Identify web elements
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationLnk;
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactLnk;
	@FindBy(linkText = "Opportunities")
	private WebElement oppoortunitiesLnk;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLnk;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOppoortunitiesLnk() {
		return oppoortunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//business library
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrgLink()
	{
		organizationLnk.click();
	}
	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactsLink()
	{
		contactLnk.click();
	}
	/**
	 * This method will click on Opportunities link
	 */
	public void clickOnOppLnk()
	{
		oppoortunitiesLnk.click();	
	}
	/**
	 * This method will click on logout link
	 * @throws InterruptedException 
	 */
	public void clickOnSignoutLnk(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(3000);
		signoutLnk.click();
	}
	
}
