package vtiger.OrganisationTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContact {

public static void main(String[] args) throws InterruptedException {
	
	//launching browser
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/index.php");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//login operation
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//click on contacts module
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	//create new contact
	driver.findElement(By.name("firstname")).sendKeys("Shannu");
	driver.findElement(By.name("lastname")).sendKeys("Shaik");
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	
	//logout operation
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	driver.close();
}
}
