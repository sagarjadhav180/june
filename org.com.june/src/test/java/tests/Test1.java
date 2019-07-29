package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.TestBase;

public class Test1 extends TestBase
{
	@Test
	public  void run1()
	{
		System.out.println("run1..");

		test=extent.startTest("testing logs");
		String str1="Object 1";
		String str2="Object 1";
		
		Assert.assertEquals(str1, str2,"str1 not matching with str2");
		test.log(LogStatus.PASS, "String objects matching");
	
		
		
	}

}
 