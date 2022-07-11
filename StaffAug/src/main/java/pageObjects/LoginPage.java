package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resource.Base;

public class LoginPage extends Base{

	
	public WebDriver driver;
	
	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[id='user_password']");
	By loginButton = By.cssSelector("[value='Log In']");
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
		
		
	}
	public WebElement getPassword()
	{		
		return driver.findElement(password);		
	}
	public WebElement getLoginButton()
	{		
		return driver.findElement(loginButton);		
	}
	
}
