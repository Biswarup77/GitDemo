package ipg.StaffAug;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjects.RediffHomePage;

public class Test_RediffLogin {
	
	
	
	
	@Test
	public void rediffFunction()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		
		RediffHomePage rhp = new RediffHomePage(driver);
		//rhp.buttonLogin().click();
		rhp.buttonLogin2().click();
		
		
		
	}

}
