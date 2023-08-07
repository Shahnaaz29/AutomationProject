package vtiger.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of all generic methods related to java
 * @author Shannu
 *
 */
public class JavaUtility {
	/**
	 * This method will generate a random number for every execution
	 * @return Random value
	 */
public int getRandomNumber()
{
	Random r=new Random();
	int ran = r.nextInt(10000);
	return ran;
}
/**
 * this method will generate system date
 * @return
 */
public String getSystemDate()
{
	Date d=new Date();
	String date = d.toString();
	return date;
}
/**
 * This method will generate system date in specific format
 * @return current system date
 */
public String getSystemDateInFormat()
{
	Date d=new Date();
	String[] date = d.toString().split(" ");
	String currentdate = date[2];
  String month = date[1];
  String year = date[5];
  String time = date[3].replace(":", "-");
  String dateinFormat = currentdate+"_"+month+"_"+year+"_"+time;
  return dateinFormat;
}
}
