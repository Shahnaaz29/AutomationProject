package vtiger.OrganisationTests;

import org.testng.annotations.Test;

public class ReadDataFromCmdTest {
@Test
public void read()
{
	String UN=System.getProperty("username");
	System.out.println(UN);
	String PWD = System.getProperty("password");
	System.out.println(PWD);
}

}
