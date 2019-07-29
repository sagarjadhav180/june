package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.TestBase;

public class Test5 extends TestBase
{
	
	@Test
	public void test1()
	{
		test=extent.startTest("test1");
		test.log(LogStatus.PASS, "test1 running--first log", "first log");
		System.out.println("test 1 started.......");
		Assert.fail();
		test.log(LogStatus.FAIL, "Assertion error");
	}

}
