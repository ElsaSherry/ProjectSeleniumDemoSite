package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class RegiterAPatientClass {
	WebDriver driver;
	GeneralUtilities gl=new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();
	
	 public RegiterAPatientClass(WebDriver driver) 
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//i[@class='icon-user']") WebElement registerAPatientButton;
	 
	 @FindBy(name = "givenName")
	     WebElement givenName;

	    @FindBy(name = "familyName")
	     WebElement familyName;

	    @FindBy(id = "gender-field")
	     WebElement gender;

	    @FindBy(id = "birthdateDay-field")
	     WebElement birthDay;

	    @FindBy(id = "birthdateMonth-field")
	     WebElement birthMonth;

	    @FindBy(id = "birthdateYear-field")
	     WebElement birthYear;

	    @FindBy(id = "address1")
	     WebElement address1;

	    @FindBy(id = "address2")
	     WebElement address2;

	    @FindBy(id = "cityVillage")
	     WebElement cityVillage;

	    @FindBy(id = "stateProvince")
	     WebElement stateProvince;

	    @FindBy(id = "country")
	     WebElement country;

	    @FindBy(id = "postalCode")
	     WebElement postalCode;

	    @FindBy(name = "phoneNumber")
	     WebElement phoneNumber;
	    
	   // WebElement patientPhoneNumber;
		//@FindBy(id = "relationship_type")
		
		//WebElement relationshipDp;
		@FindBy(id = "next-button")
		
		WebElement nextButton;
		
		// @FindBy (name="confirm right") WebElement enterButton;
	    
		@FindBy(xpath = "//input[@placeholder='Person Name']")
		WebElement relationPersonName;
		
		//@FindBy(id = "submit")
		//WebElement confirmButton1;
		
		@FindBy(id = "cancelSubmission")
		WebElement CancelButton;
		
		@FindBy(className = "PersonName-givenName")
		WebElement registeredPatientGivenName;
		
		@FindBy(name = "PersonName-familyName")
		WebElement registeredPatientFamilyName;
	    

	    @FindBy(id = "confirmationSection")
	     WebElement confirmButton;

	  
	    public void registerPatient(String fName, String lName, String gen, String bDay, String bMonth, String bYear, String addr1, String addr2, String city, String state, String ctry, String postCode, String phone) {
	       
	        gl.typeOnElement(givenName, fName);;
	      
	        gl.typeOnElement(familyName, lName);
	        
	        ew.visibitlityOfElementWait(driver, nextButton);
			gl.clickUsingJavaScriptExecutor(driver, nextButton);
			
			ew.visibitlityOfElementWait(driver, gender);
			gl.selectFromDropDownByVisibilityOfText(gender, gen);;
			gl.clickUsingJavaScriptExecutor(driver, nextButton);

	       
	        //gl.typeOnElement(gender, gen);
			ew.visibitlityOfElementWait(driver, birthDay);
			gl.typeOnElement(birthDay, bDay);
			gl.selectFromDropDownByVisibilityOfText(birthMonth, bMonth);
			ew.visibitlityOfElementWait(driver, birthYear);
			gl.typeOnElement(birthYear, bYear);
			gl.clickUsingJavaScriptExecutor(driver, nextButton);
	   
	        //gl.typeOnElement(birthDay, bDay);
	       
	       // gl.typeOnElement(birthMonth, bMonth);
	        
	       // gl.typeOnElement(birthYear, bYear);
	       
	        gl.typeOnElement(address1, addr1);
	       
	        gl.typeOnElement(address2, addr2);
	        
	        gl.typeOnElement(cityVillage, city);
	       
	        gl.typeOnElement(stateProvince, state);
	      
	        gl.typeOnElement(country, ctry);
	       
	        gl.typeOnElement(postalCode, postCode);
	        
	        gl.clickUsingJavaScriptExecutor(driver, nextButton);
			ew.visibitlityOfElementWait(driver, phoneNumber);
			gl.typeOnElement(phoneNumber, phone);
			gl.clickUsingJavaScriptExecutor(driver, nextButton);
	        
	        //gl.typeOnElement(phoneNumber, phone);
			 ew.elementTobeClickableWait(driver, confirmButton);
			    gl.clickAnElementUsingSendKeys(driver, confirmButton);
	       // gl.clickOnElement(confirmButton);
			    
			   

	    }
	
	 
	

}
