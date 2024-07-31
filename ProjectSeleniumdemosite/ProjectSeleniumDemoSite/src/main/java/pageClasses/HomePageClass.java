package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
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

	@FindBy(linkText = "Logout")
	WebElement logoutLink;

	@FindBy(xpath = "//a[@class='btn btn-default btn-lg button app big align-self-center']//child::i[@class='icon-user']']")
	WebElement registerAPatientButton;

	@FindBy(xpath = "By.xpath(\"//h1[contains(text(),'Elsa Sherry')]")
	WebElement patientHeader;

	@FindBy(xpath = "//i[@class='icon-caret-down appui-icon-caret-down link']")
	WebElement adminDropdown;

	@FindBy(linkText = "My Account")
	WebElement myAccountLink;

	@FindBy(xpath = "//i[@class='icon-home small']")
	WebElement homeicon;

	public void clickRegisterPatient() {
		gl.clickOnElement(registerPatientLink);

	}

	public void clickRegiterAPatientbutton() {
		gl.clickOnElement(registerAPatientButton);

	}

	public String getTextOfRegitrationOfPatientSuccesfull() {
		return gl.getTextOfElement(patientHeader);

	}

	public String getTextOfSuperAdminText() {
		fw.presenceOfElementLocatedWaitXpath(driver, "//div[@id='content']//child::h4");
		return gl.getTextOfElement(loggedInAsuser);
	}

	public void clickFindPatientRecord() {

		gl.clickOnElement(findPatientRecordLink);
	}

	public boolean isRegisterPatientLinkDisplayed() {

		return gl.isElementDisplayed(registerPatientLink);
	}

	public boolean isFindPatientRecordLinkDisplayed() {

		return gl.isElementDisplayed(findPatientRecordLink);
	}

	public void clickAdminDropdown() {

		gl.clickOnElement(adminDropdown);
	}

	public void clickMyAccountLink() {

		gl.clickOnElement(myAccountLink);
	}

	public boolean isHomeIconDisplayed() {

		return gl.isElementDisplayed(homeicon);
	}

	public void logout() {

		gl.clickOnElement(logoutLink);
	}

	public String readStringData(int row, int coloum) throws IOException {
		return ExcelReadClass.getStringData(row, coloum);

	}

	public String getIntegerData(int row, int coloum) throws IOException {
		return ExcelReadClass.getIntegerData(row, coloum);

	}

}
