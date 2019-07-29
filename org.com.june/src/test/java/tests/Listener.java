package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import pom.TestBase;

public class Listener extends TestBase implements ITestListener{

	
	static List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
	static List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
	static List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();
	String failed_test_case = "";
	
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		failedtests.add(arg0.getMethod());
		failed_test_case = arg0.getMethod().getMethodName();
		System.out.println("Failed:"+ arg0.getMethod());
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		skippedtests.add(arg0.getMethod());
		System.out.println("Skipped:"+ arg0.getMethod());
		test = extent.startTest(arg0.getMethod().getMethodName());
		LogStatus sta = test.getRunStatus();
		System.out.println("Skipped Status: "+sta);
		test.log(LogStatus.SKIP, "test skipped because of test method <span class='red label'>" + failed_test_case + "</span>" + " is failed.");
		extent.endTest(test);
		extent.flush();
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		passedtests.add(arg0.getMethod());
		System.out.println("Passed:"+ arg0.getMethod());
	}
	 
	
	
	public static int[] count_of_test(){
		int [] result = {passedtests.size(),failedtests.size(),skippedtests.size()}; 
		return result;
	}
	// This belongs to ISuiteListener and will execute before the Suite start
	
	
}
