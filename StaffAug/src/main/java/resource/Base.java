package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
				
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\04819I744\\eclipse-workspace\\StaffAug\\src\\main\\java\\resource\\data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		//Chrome
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		//Firefox
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\work\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//IE
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\work\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS ); //Deprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;  //initializeDriver() method's return type is WebDriver
		
		
	
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		
		FileHandler.copy(srcFile, new File(destFile));
		return destFile;
		
	}
	
	

}
