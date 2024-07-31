package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotInSelenium {
	public void takeScreenshot(WebDriver driver,String name) throws IOException
	{
		String folderpath="C:\\Users\\asher\\eclipse-workspace\\SeleniumTestNG"+"\\screenshots";
		File file=new File(folderpath);
		if(!file.exists())
		{
			file.mkdirs();
		}
		
		TakesScreenshot take_screenshot=(TakesScreenshot)driver;
		File storing_screenshotfile=take_screenshot.getScreenshotAs(OutputType.FILE);
		
		String timeStamp=new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date());
		
		String destination_path="C:\\Users\\asher\\eclipse-workspace\\SeleniumTestNG"+"\\screenshots"+name+timeStamp+".png";
		
		//to copy screenshot to destination folder
		File fileDestination=new File(destination_path);
		
		FileHandler.copy(storing_screenshotfile, fileDestination);
	}

	
}
