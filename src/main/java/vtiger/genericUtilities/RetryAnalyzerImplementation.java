package vtiger.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer 
{

	int count=1;
	int retrycount=3;                 //pass  //fail
	public boolean retry(ITestResult result) 
	{         //1<=3  2<=3 3<=3
		while(count<=retrycount)
		{
			count++;//update to 2 3 4
			return true;//retry
		}
		return false;//dont retry
	}

}
