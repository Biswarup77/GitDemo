package ipg.StaffAug;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.j2objc.annotations.Property;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.Base;


public class Test_ValidateTitle extends Base{
	
	public WebDriver driver;
	
	ExtentReports exreport;
	//public static Logger log = LogManager.getLogger(Test_ValidateTitle.class.getName());
	@BeforeClass
	public void initialization() throws IOException
	{	
		
		driver = initializeDriver();
		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		
		driver.get(url);
			
	}
	
	@Test
	public void navigateTitle () throws IOException
	{	
			
		LandingPage lp = new LandingPage(driver);
		
		AssertJUnit.assertEquals((lp.getTitle().getText()).toUpperCase()	, ("FEATURED Courses").toUpperCase());
		
		//System.out.println("Featured coures displayed");
		//log.info("Featured coures displayed");
		System.out.println("Check 1");
		
		
	}
	
	
	@AfterClass
	public void terminate()
	{	
		System.out.println("Check 1");
		driver.quit();
		
		
	}

}
