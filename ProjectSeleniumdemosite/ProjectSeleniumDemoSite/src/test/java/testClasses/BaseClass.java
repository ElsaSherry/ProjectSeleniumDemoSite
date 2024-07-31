package testClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import utilities.*;
public class BaseClass {
	WebDriver driver; 
	ScreenShotInSelenium sh;
	public static Properties property;
	 
	public static void readProperty() throws IOException
	{
		property=new Properties();
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\confignew.properties");
	    property.load(f);
	} 
	@Parameters({ "Browser" })
	@BeforeMethod(groups = { "Launch" })
	public void beforeMethod(String browserValue) throws IOException { 
		
		readProperty();
		if (browserValue.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserValue.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		}
		//driver = new ChromeDriver();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

	}

	@AfterMethod(groups = { "Close" })
		public void afterMethod(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.FAILURE) {
				sh = new ScreenShotInSelenium();
				sh.takeScreenshot(driver, result.getName());

			}
			driver.quit();
	}
	

}

