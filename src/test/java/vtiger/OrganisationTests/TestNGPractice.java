package vtiger.OrganisationTests;

import org.testng.annotations.Test;

public class TestNGPractice 
{
@Test
public void createCustomer()
{
	//Assert.fail();//purposefully failing the script
	System.out.println("Customer created");
}
@Test
public void modifyCustomer()
{
	System.out.println("Customer modified");
}
@Test(enabled = false)
public void deleteCustomer()
	{
	System.out.println("Customer deleted");
	}
}

