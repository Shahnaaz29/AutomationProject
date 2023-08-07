package vtiger.OrganisationTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
@Test (retryAnalyzer = vtiger.genericUtilities.RetryAnalyzerImplementation.class)
public void sample()
{
	Assert.fail();//failing on purpose to check the count of retries
	System.out.println("Hello");
}

}
