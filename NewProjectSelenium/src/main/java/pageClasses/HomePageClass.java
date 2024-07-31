package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FluentWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	FluentWaitClass fw = new FluentWaitClass();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']//child::h4")
	WebElement loggedInAsuser;

	@FindBy(xpath = "//div[@id='apps']//child::a")
	List<WebElement> allTilesInHomePage;

	@FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
	WebElement registerPatientLink;

	@FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	WebElement findPatientRecordLink;

	@FindBy(xpath = "//footer")
	WebElement footer;

	@FindBy(linkText = "Logout")
	WebElement logoutLink;

	@FindBy(xpath = "//a[@class='btn btn-default btn-lg button app big align-self-center']//child::i[@class='icon-user']']")
	WebElement registerAPatientButton;

	@FindBy(xpath = "By.xpath(\"//h1[contains(text(),'Elsa Sherry')]")
	WebElement patientHeader;

	public void clickRegisterPatient() {
		gl.clickOnElement(registerPatientLink);
		// registerPatientLink.click();
	}

	public void clickRegiterAPatientbutton() {
		gl.clickOnElement(registerAPatientButton);
		// registerAPatientButton.click();
	}

	public String getTextOfRegitrationOfPatientSuccesfull() {
		return gl.getTextOfElement(patientHeader);

	}

	public String getTextOfSuperAdminText() {
		fw.presenceOfElementLocatedWaitXpath(driver, "//div[@id='content']//child::h4");
		return gl.getTextOfElement(loggedInAsuser);
	}

	public void clickFindPatientRecord() {
		// findPatientRecordLink.click();
		gl.clickOnElement(findPatientRecordLink);
	}

	public boolean isRegisterPatientLinkDisplayed() {
		// return registerPatientLink.isDisplayed();
		return gl.isElementDisplayed(registerPatientLink);
	}

	public boolean isFindPatientRecordLinkDisplayed() {
		// return findPatientRecordLink.isDisplayed();
		return gl.isElementDisplayed(findPatientRecordLink);
	}

	public boolean isFooterDisplayed() {
		// return footer.isDisplayed();
		return gl.isElementDisplayed(footer);
	}

	public void logout() {
		// logoutLink.click();
		gl.clickOnElement(logoutLink);
	}

}
