package vtiger.genericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all the reusable methods related to webDriver actions
 * @author Shannu
 *
 */
public class WebDriverUtility
{
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver)//parameterize web driver instead of declaring it globally//becz of updated driver reference
{
	driver.manage().window().maximize();
}
/**
 * This method will minimize the window
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();

}
/**
 * This method will wait for all the FindElement and FindElemnets actions to be performed
 * @param driver
 */
public void waitForElementsToLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}
/**
 * This method will wait until specified element to be visible in DOM
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method will handle drop down using index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element,int index) 
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
/**
 * this method will handle drop down using value
 * @param element
 * @param index
 */
//method overloading
//methods names same but different arguments
public void handleDropDown(WebElement element,String index) 

{
	Select sel=new Select(element);
	sel.selectByValue(index);
}
/**
 * This method will handle drop down using visible text
 * @param text
 * @param element
 */
//changing the sequence of arguments in same method name
//method overloading
public void handleDropdown(String text,WebElement element)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * This method will perform mouse hover actions on a target element
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver,WebElement element)
{
Actions act=new Actions(driver);
act.moveToElement(element).perform();
}
/**
 * This method will double click anywhere on the webpage
 * @param driver
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
/**
 * This method will double click on a web element
 * @param driver
 * @param element
 */
//method overloading- different number of arguments
public void doubleClickAction (WebDriver driver,WebElement element) 
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * This method will perform right click action anywhere on web page
 * @param driver
 */
public void contextClickAction(WebDriver driver)
{
	Actions act=new Actions (driver);
	act.contextClick().perform();
}
/**
 * this method will perform right click action on specific web element
 * @param driver
 * @param element
 */
//method overloading-diff number of arguments
public void contextClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method will perform drag and drop action
 * @param driver
 * @param source
 * @param target
 */
public void dragAndDropAction(WebDriver driver,WebElement source, WebElement target)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(source, target).perform();
}
/**
 * This method will used to move the cursor anywhere on the web page based on offset values
 * @param driver
 * @param xoffset
 * @param yoffset
 */
public void moveAcrossWebPage(WebDriver driver,int xoffset,int yoffset)
{
	Actions act=new Actions(driver);
	act.moveByOffset(xoffset, yoffset).perform();
}
/**
 * This method will scroll vertically for 500 pixels
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500);", "");

}
/**
 * This method scroll vertically until the element reference
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	int y=element.getLocation().getY();
	jse.executeScript("window.scrollBy(0,"+y+");", element);
	//jse.executeScript("arguments[0].scrollIntoview();", element);
}
/**
 * This method will accept  the confirmation popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method will cancel the confirmation pop up
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method will enter the text in prompt pop up
 * @param driver
 * @param text
 */
public void sendTextToAlert(WebDriver driver,String text)
{
	driver.switchTo().alert().sendKeys(text);
}
/**
 * This methohd will capture the alert message and return to caller
 * @param driver
 */
public void getAlertText(WebDriver driver)
{
	driver.switchTo().alert().getText();
}
/**
 * This method will handle frame based on frame index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will handle frame based on value of name or ID attributes
 * @param driver
 * @param nameorID
 */
public void handleFrame(WebDriver driver,String nameorID)
{
	driver.switchTo().frame(nameorID);
}
/**
 * This method will handle frame based on element
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * This method will help to switch the control back to immediate parent
 * @param driver
 */
public void switchToParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
/**
 * This method will help to switch the control back to current page
 * @param driver
 */
public void switchToDefaultPage(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * This method will switch the selenium control from parent to child or from child to parent based on partialWindowTitle
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver,String partialWindowTitle)
{
          //step1:capture all the window IDs
	Set <String> allwindowIds = driver.getWindowHandles();
	      //step2:Iterate through individual IDs
	for(String winID:allwindowIds)
	{
	      //step3:switch to each id and capture the title
     String currenttitle = driver.switchTo().window(winID).getTitle();
	
	      //step4:compare the title with required reference
     if(currenttitle.contains(partialWindowTitle))
	 {
		 break;
	 }
		 
	}	 
		 
}
/**
 * This method will take screenshot and return the absolute path of it
 * @param driver
 * @param screenshotname
 * @throws Throwable
 */
public String takeScreenShot(WebDriver driver,String screenshotname) throws Throwable
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
    File dest = new File(".\\Screenshots\\"+screenshotname+".png");
	Files.copy(src, dest);//this class is coming from commons IO tool
	//below statement is not compulsory to take screenshot..but it will be used to create extend report for further usage
	return dest.getAbsolutePath();//used to attach the screenshot to extend reports
}


}
