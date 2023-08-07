package vtiger.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of testNG
 * Example for Abstraction
 * @author Shannu
 *
 */
public class ListenerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		String methodname = result.getMethod().getMethodName();
		System.out.println("----executionStarted-------"+methodname);
		test=report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result)
	{
		String methodname = result.getMethod().getMethodName();
     // System.out.println("----PASS----"+methodname);
		test.log(Status.PASS, "----PASS----"+methodname);
	
	}

	public void onTestFailure(ITestResult result)
	{
		String methodname = result.getMethod().getMethodName();
		//System.out.println("----FAIL----"+methodname);
		test.log(Status.FAIL, "----FAIL----"+methodname);
		
		//print the exception
		//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
		
		//Take Screenshot for failure test scripts to attach with bug raising
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String screenshotname=methodname+jutil.getSystemDateInFormat();
		try {
			String path = wutil.takeScreenShot(BaseClass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(path);
		} 
		
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result)
	
	{
		String methodname = result.getMethod().getMethodName();
		//System.out.println("----SKIP----"+methodname);
		test.log(Status.SKIP, "--SKIP---"+methodname);
	//System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
		//SuiteLevel Execution-start of <suite> - same as @BeforeSuite
		System.out.println("----suite execution Started------");
		//Configure the extent report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("VTiger Execution Reports");
		htmlreport.config().setReportName("Build 3 Vtiger Execution Reports");
		htmlreport.config().setTheme(Theme.DARK);
		
		//Report generation
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Testing-Env");
		report.setSystemInfo("BaseURL", "http://localhost:8888");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter", "Shahanaz");
	
	}

	public void onFinish(ITestContext context)
	{
		//SuiteLevel Execution-end of <suite> - same as @AfterSuite
		System.out.println("----suite execution ended-------");
		//Report Generation
		report.flush();
		
	}

}
