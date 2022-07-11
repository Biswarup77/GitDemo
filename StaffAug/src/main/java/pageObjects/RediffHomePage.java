package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePage {

	
	WebDriver driver;
	By loginButton = By.xpath("//a[contains(text(),'Sign in')]");
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement loginButton2;
	
	public RediffHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement buttonLogin()
	{
		return driver.findElement(loginButton);		
	}
	
	public WebElement buttonLogin2()
	{
		return 	loginButton2;
	}
	
}
