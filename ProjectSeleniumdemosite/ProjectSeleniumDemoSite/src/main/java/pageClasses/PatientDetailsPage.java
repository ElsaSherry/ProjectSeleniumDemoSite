package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FluentWaitClass;
import utilities.GeneralUtilities;

public class PatientDetailsPage {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	FluentWaitClass fw = new FluentWaitClass();

	public PatientDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Patient')]")
	WebElement patientHeader;

	@FindBy(linkText = "Edit")
	WebElement editButton;

	@FindBy(linkText = "Delete")
	WebElement deleteButton;

	public boolean isPatientHeaderDisplayed() {

		return gl.isElementDisplayed(patientHeader);
	}

	public void clickEditButton() {

		gl.clickOnElement(editButton);
	}

	public void clickDeleteButton() {

		gl.clickOnElement(deleteButton);
	}
}
