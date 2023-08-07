package vtiger.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.objectRepository.HomePage;
import vtiger.objectRepository.LoginPage;

/**
 * This class consists of all the basic configuration annotations for all the common actions.
 * @author Shannu
 *
 */
public class BaseClass {
	
	 public JavaUtility jutil=new JavaUtility();
	 public ExcelFileUtility eutil=new ExcelFileUtility();
	 public PropertyFileUtility putil=new PropertyFileUtility();
	 public WebDriverUtility wutil=new WebDriverUtility();
	
	public WebDriver driver=null;
	//only used for listener to take screenshot
	public static WebDriver sdriver;
@BeforeSuite(alwaysRun = true)
public void beforeSuitConfig()
{
	System.out.println("====DB connection successfull====");
}

//@Parameters("browser")//hold a value
//@BeforeTest
@BeforeClass(alwaysRun = true)
public void beforeclassConfig(/*String BROWSER*/) throws Throwable
{
	//read browser name and URL from property file
	String BROWSER = putil.getDataFromPropertyFile("browser");
	String URL = putil.getDataFromPropertyFile("url");
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println(BROWSER+" --- Browser launched-----");	
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println(BROWSER+" --- Browser launched------");
	}
	else
	{ 
		System.out.println("=====invalid Browser name=====");
	}
	 
	wutil.maximizeWindow(driver);
	wutil.waitForElementsToLoad(driver);
	
	//only used for listener to take screenshot
	sdriver=driver;
//Load the URL
	driver.get(URL);
}
@BeforeMethod(alwaysRun = true)
public void beforeMethodConfig() throws Throwable
{
	//read username and password from property file
	String USERNAME = putil.getDataFromPropertyFile("username");
	String PASSWORD = putil.getDataFromPropertyFile("password");
	//logging in 
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME,PASSWORD);
	System.out.println("======Login Successfull=====");
}



@AfterMethod(alwaysRun = true)
public void afterMethodConfig() throws Throwable
{
	HomePage hp=new HomePage(driver);
	hp.clickOnSignoutLnk(driver);
	System.out.println("======Logout Successfull=====");
}

@AfterClass(alwaysRun = true)
public void afterClassConfig()
{
	driver.quit();
	System.out.println("====Browser closed======");
}

@AfterSuite(alwaysRun = true)
public void afterSuitConfig()
{
	System.out.println("DB connection closed");
}
}
