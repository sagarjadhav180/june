package pom;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
//import org.json.simple.parser.ParseException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
//import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tests.Listener;
import tests.SendMail;

public class TestBase {
	
	
	
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setup() throws ClientProtocolException, URISyntaxException, IOException{
		 // Create the extentReport
		 extent = new ExtentReports("D:/Selenium/org.com.june/Extent.html", true);
		 extent.addSystemInfo("User Name", "sagu");
		 extent.addSystemInfo("OS", "Windows");
		 extent.addSystemInfo("Host Name", "sagu");
		 extent.loadConfig(new File("D:/Selenium/org.com.june/src/main/java/pom/extent_config.xml"));
	}

	
	
	@AfterMethod
	public void tearDown(ITestResult result){
		try {
			if(result.getStatus() == ITestResult.FAILURE){
			//Code to add failure message in report	
			test.log(LogStatus.FAIL, result.getThrowable().getMessage());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Code to add test result in report
		extent.endTest(test);
		extent.flush();
	}
	
	
	@AfterSuite
	public void send_report()throws Exception, ClientProtocolException, IOException{
		// Get count of passed, failed and skipped test case
		int [] result = Listener.count_of_test();
//		HelperClass.writeExcel(result);
//		SendMail.execute("cfa_api_report.html", result);
	}
	
}
