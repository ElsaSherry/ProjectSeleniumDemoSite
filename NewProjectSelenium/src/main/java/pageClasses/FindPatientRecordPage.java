package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FluentWaitClass;
import utilities.GeneralUtilities;

public class FindPatientRecordPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	FluentWaitClass fw = new FluentWaitClass();

	public FindPatientRecordPage(WebDriver driver) 
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "patient-search")
     WebElement patientSearchBox;

    @FindBy(xpath = "//table[@id='patient-search-results-table']")
     WebElement searchResultsTable;

   
    public void searchForPatient(String patientName) {
      //  patientSearchBox.sendKeys(patientName);
    	gl.typeOnElement(patientSearchBox, patientName);
    }

    public boolean isSearchResultsTableDisplayed() {
       // return searchResultsTable.isDisplayed();
    	return gl.isElementDisplayed(searchResultsTable);
    }
}


