package vtiger.objectRepository;
//rule1: create a separate pom class for every web page

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //rule2:identify the web elements using annotations
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	//rule3: create a constructor to initialise the two 
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//rule4:provide getters to access these web elements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//rule5:business library-project specific generic method
	/**
	 * This metjod will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginbtn.click();
	}
	
}
 