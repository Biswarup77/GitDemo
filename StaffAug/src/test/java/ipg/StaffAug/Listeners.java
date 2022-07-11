package ipg.StaffAug;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.Base;
import resource.ExtentReportNG;

public class Listeners extends Base implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		test =extent.createTest(result.getMethod().getMethodName()); 
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		extentTest.get().fail(result.getThrowable());
		System.out.println("Entered Listeners Failure");
		
		WebDriver driver = null;
		
		//Capture Failure Screenshot
		String testmethodName = result.getMethod().getMethodName();
		
		System.out.println("Method Name print : "+testmethodName);
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e)
		{
			
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshot(testmethodName,driver),testmethodName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
		
	}
	

}
