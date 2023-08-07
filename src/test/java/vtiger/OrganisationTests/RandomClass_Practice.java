package vtiger.OrganisationTests;

import java.util.Random;

public class RandomClass_Practice {
public static void main(String[] args) {
	Random r=new Random();
	int value = r.nextInt(1000);//random numbers range between 0 to 1000
	System.out.println(value);
}
}
