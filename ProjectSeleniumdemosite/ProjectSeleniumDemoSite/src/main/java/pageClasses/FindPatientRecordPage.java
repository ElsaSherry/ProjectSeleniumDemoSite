package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.FluentWaitClass;
import utilities.GeneralUtilities;

public class FindPatientRecordPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	FluentWaitClass fw = new FluentWaitClass();
	ExplicitWaitClass ew = new ExplicitWaitClass();

	public FindPatientRecordPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "patient-search")
	WebElement patientSearchBox;

	@FindBy(xpath = "//table[@id='patient-search-results-table']")
	WebElement searchResultsTable;
	@FindBy(xpath = "//table[@id='patient-search-results-table']//tr")
	List<WebElement> searchResults;

	@FindBy(xpath = "//table[@id='patient-search-results-table']//tr[1]//td[1]")
	WebElement firstResult;

	@FindBy(xpath = "//table[@id='patient-search-results-table']//tr[1]//td[2]")
	WebElement firstResultIdentifier;

	@FindBy(xpath = "//table[@id='patient-search-results-table']//tr[1]//td[3]")
	WebElement firstResultGender;

	@FindBy(xpath = "//table[@id='patient-search-results-table']//tr[1]//td[4]")
	WebElement firstResultAge;

	public void searchForPatient(String patientName) {

		gl.typeOnElement(patientSearchBox, patientName);
	}

	public boolean isSearchResultsTableDisplayed() {

		return gl.isElementDisplayed(searchResultsTable);
	}

	public void searchForPatientName(String patientName) {
		gl.typeOnElement(patientSearchBox, patientName);

		ew.visibitlityOfElementWait(driver, patientSearchBox);
	}

	public int getSearchResultsCount() {

		return gl.sizeOfWebElementList(searchResults);
	}

	public String getFirstResultName() {

		return gl.getTextOfElement(firstResult);
	}

	public String getFirstResultIdentifier() {

		return gl.getTextOfElement(firstResultIdentifier);
	}

	public String getFirstResultGender() {

		return gl.getTextOfElement(firstResultGender);
	}

	public String getFirstResultAge() {

		return gl.getTextOfElement(firstResultAge);
	}
	public String readStringData(int row, int coloum) throws IOException {
		return ExcelReadClass.getStringData(row, coloum);

	}

	public String getIntegerData(int row, int coloum) throws IOException {
		return ExcelReadClass.getIntegerData(row, coloum);

	}
}
