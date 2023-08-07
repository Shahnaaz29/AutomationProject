package vtiger.OrganisationTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
@Test(dataProvider="getdata")
public void addToCartTest(String name,int price,String model)
{
	System.out.println("name is "+name+" price is "+price+" model is "+model);
}
@DataProvider	
public Object[][]getdata()
{
	Object[][] data=new Object[3][3];
	
	//first set of data
	data[0][0]="iphone";
	data[0][1]=20000;
	data[0][2]="S13";
	//second set of data
	data[1][0]="samsung";
	data[1][1]=15000;
	data[1][2]="A80";
	//third set of data
	data[2][0]="vivo";
	data[2][1]=10000;
	data[2][2]="ab6";
	return data;
}
}
