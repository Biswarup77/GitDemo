package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

		public WebDriver driver;
		By signIn = By.cssSelector("a[href*='sign_in']");
		
		//By signIn = By.xpath("//span[contains(text(),'Login')]");
		By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
		
		By menubar = By.xpath("//ul[contains(@class,'nav navbar')]");
		
		public LandingPage(WebDriver driver) {
			
			this.driver = driver;
			
		}

		public WebElement getLogin()
		{
			
			return driver.findElement(signIn);
		}
		public WebElement getTitle()
		{
			
			return driver.findElement(title);
		}
		public WebElement getNavigation()
		{
			
			return driver.findElement(menubar);
		}
		

}
