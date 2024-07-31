package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;
	GeneralUtilities gl=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();
	
	public LoginPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 
	}
	
	@FindBy(id="username") WebElement usernameTextBox;
	@FindBy(id="password") WebElement userPassword;
	@FindBy(id="Registration Desk") WebElement registrationDesk;
	@FindBy(id="loginButton") WebElement loginButton;

	@FindBy(id = "Inpatient Ward")
	WebElement inpatientWard;
	@FindBy(xpath = "//div[@id='error-message']") WebElement errormessage;
	@FindBy(xpath = "//div[@class='logo']//child::img")
	WebElement logoImage;
	
	@FindBy(xpath = "//ul[@id='sessionLocation']//child::li")
	List<WebElement> allLocationSessions;
	
	public void login(String username,String password)
	{
		gl.typeOnElement(usernameTextBox, username);
		gl.typeOnElement(userPassword, password);
		ew.visibitlityOfElementWait(driver, registrationDesk);
		gl.clickOnElement(registrationDesk);
		gl.clickOnElement(loginButton);
		gl.isElementDisplayed(errormessage);
	}
    public boolean IsAllLocationSessionIsDisplayed()
    {
    	for(WebElement element:allLocationSessions) {
   		 gl.isElementDisplayed(element);
   		 return true; 
   	}
   	return false;
    }
    public String getTextOfErrorMessageFromLoginPage() {
		return gl.getTextOfElement(errormessage);
	}
    public boolean isErrorMessageDisplayed() {
       // return errormessage.isDisplayed();
    	return gl.isElementDisplayed(errormessage);
    }

	
	public boolean isLogoDisplayed() {
		return gl.isElementDisplayed(logoImage);
	}
	
	public String getTextOfCurrentLoginPageURL() {
		return gl.getTextOfElement(loginButton);
	}
	
	public String readStringData(int row,int coloum)throws IOException {
		return ExcelReadClass.getStringData(row, coloum) ;
		
	}
	
	public String getIntegerData(int row,int coloum)throws IOException {
		return ExcelReadClass.getIntegerData(row,coloum) ;
		
	}
}

