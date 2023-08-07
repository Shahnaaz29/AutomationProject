package vtiger.genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
public String getDataFromPropertyFile(String key) throws Throwable 
{
	FileInputStream fis=new FileInputStream(IConstants.propertyFilePath);
	//.\\src\\test\\resources\\CommonData.properties
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	
}
}
