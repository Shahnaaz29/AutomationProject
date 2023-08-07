package vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.genericUtilities.ExcelFileUtility;
import vtiger.genericUtilities.JavaUtility;
import vtiger.genericUtilities.PropertyFileUtility;
import vtiger.genericUtilities.WebDriverUtility;

public class CreateContactwithOrg {
public static void main(String[] args) throws Throwable
{
	 //create organization
	
	//create object of required utilities
		JavaUtility jutil=new JavaUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		WebDriver driver=null;
		
		
		//Step 1: Read all the necessary data
		
		/* Read data from property File - Common Data */
		String BROWSER = putil.getDataFromPropertyFile("browser");
		String URL = putil.getDataFromPropertyFile("url");
		String USERNAME = putil.getDataFromPropertyFile("username");
		String PASSWORD = putil.getDataFromPropertyFile("password");
		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eutil.getDataFromExcel("contacts", 3, 3)+jutil.getRandomNumber();
		String LASTNAME = eutil.getDataFromExcel("Organisation", 3, 2);
		//Step 2: Launch the browser - driver is acting based runtime data - RunTime polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" --- Browser launched");	
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" --- Browser launched");
		}
		else
		{
			System.out.println("invalid Browser name");
		}
		
		wutil.maximizeWindow(driver);
		wutil.waitForElementsToLoad(driver);
		
		//Step 3: Load the URL
		driver.get(URL);
		
		//Step 4: Login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Click on Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: click on Create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6: create Organization
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 7: save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
	//create contact using organization
		
		//Step 9: click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step10:navigate to create contact lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//step11: Create a contact with mandatory information
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@ title='Select']")).click();
		
		//step12: switch to child window
		wutil.switchToWindow(driver, "Accounts");
		
		//step13: search for organization
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		
		//step14:click on search now button
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();//writing dynamic xpath
		
		//step15: switch back to parent window
		wutil.switchToWindow(driver, "Contacts");
		
		//step16:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 17:validate
		String Contactheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(Contactheader);
		}
		else
		{
			System.out.println("Fail");
		}
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout successfull");
	
}
}
