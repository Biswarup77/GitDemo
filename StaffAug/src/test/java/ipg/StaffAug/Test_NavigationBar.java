package ipg.StaffAug;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
import com.google.j2objc.annotations.Property;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.Base;

public class Test_NavigationBar extends Base{
	
	public WebDriver driver;
	
	ExtentReports exreport;	
	@BeforeClass
	public void initialization() throws IOException
	{
		
		driver = initializeDriver();
		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		
		driver.get(url);
		
	}
	
	@Test
	public void homeNavigation () throws IOException
	{
		
		LandingPage lp = new LandingPage(driver);
		
		AssertJUnit.assertTrue(lp.getNavigation().isDisplayed());
		
		System.out.println("Navigation Bar Present");
		
	
	}
	@AfterClass
	public void terminate()
	{
		System.out.println("Check ");
		driver.quit();
	}
	
	

}
