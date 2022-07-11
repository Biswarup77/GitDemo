package ipg.StaffAug;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Objects;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resource.Base;

public class Test_Login extends Base{
	
	
	@BeforeClass
	public void initialization() throws IOException
	{
		
		driver = initializeDriver();
		
		
	}
	
	@Test(dataProvider="getData")
	public void homeNavigation (String username, String password) 
	{
		driver.manage().window().maximize();
		String url = prop.getProperty("url");
		
		driver.get(url);
				
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		
		LoginPage logP = new LoginPage(driver);
		logP.getEmail().sendKeys(username);
		logP.getPassword().sendKeys(password);
		logP.getLoginButton().click();
		
		System.out.println("Login Done");
		
	}
	@AfterClass
	public void terminate()
	{
		System.out.println("Check Loop Data Provider");
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "abcd@gmail.com";
		data[0][1] = "12345";
		
		data[1][0] = "efgh@gmail.com";
		data[1][1] = "45678";
		
		data[2][0] = "asefgh@gmail.com";
		data[2][1] = "4125678";
		
		return data;
	}
	
	
	

}
