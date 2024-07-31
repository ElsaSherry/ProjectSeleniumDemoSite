package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.FindPatientRecordPage;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.PatientDetailsPage;

public class PatientDetailsTests extends BaseClass { 
	LoginPageClass lp;
	
	HomePageClass hp;
	FindPatientRecordPage fpr = new FindPatientRecordPage(driver);
	PatientDetailsPage pdp = new PatientDetailsPage(driver);

	@Test(priority = 2,groups = {"group1"})
	public void verifyNavigationToFindPatientRecordPage() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));


		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("findPatient.page"),
				"Navigation to Find Patient Record page was not successful.");
	}

	@Test(priority = 1,groups = {"group1"})
	public void verifySearchFunctionality() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));

		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPage fpr = new FindPatientRecordPage(driver);
		fpr.searchForPatient("Elsa Sherry");

		
		Assert.assertTrue(fpr.isSearchResultsTableDisplayed(), "Search results are not displayed.");
	}

	@Test(priority = 4,groups = {"group2"})
	public void testFindPatientByName() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));


		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPage fdr = new FindPatientRecordPage(driver);
		fdr.searchForPatient("Amy");
		int resultsCount = fdr.getSearchResultsCount();
		Assert.assertTrue(resultsCount > 0, "No patients found with the name 'Amy'");
	}

	@Test(priority = 3,groups = {"group2"})
	public void testFindPatientByIdentifier() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));



		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPage fdr = new FindPatientRecordPage(driver);
		fdr.searchForPatient("1002KJ");
		int resultsCount = fdr.getSearchResultsCount();
		Assert.assertTrue(resultsCount > 0, "No patients found with the identifier '1002KJ'");
	}

	@Test(priority = 5,groups = {"group3"})
	public void testFindPatientAndVerifyGender() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));


		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPage fdr = new FindPatientRecordPage(driver);
		fdr.searchForPatient("John");
		String firstResultGender = fdr.getFirstResultGender();
		Assert.assertNotNull(firstResultGender, "First result gender is null");
	}

	@Test(priority = 6,groups = {"group3"})
	public void testFindPatientAndVerifyAge() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));


		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPage fdr = new FindPatientRecordPage(driver);
		fdr.searchForPatient("John");
		String firstResultAge = fdr.getFirstResultAge();
		Assert.assertNotNull(firstResultAge, "First result age is null");
	}

	@Test(priority = 7,groups = {"group2"})
	public void testFindPatientCaseInsensitive() {
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");

		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPage fdr = new FindPatientRecordPage(driver);
		fdr.searchForPatient("john");
		int resultsCount = fdr.getSearchResultsCount();
		Assert.assertTrue(resultsCount > 0, "No patients found with the name 'john' in case-insensitive search");
	}

	@Test(priority = 8,groups = {"group3"})
	public void testFindPatientPartialName() {
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");

		hp = new HomePageClass(driver);
		hp.clickFindPatientRecord();

		FindPatientRecordPage fdr = new FindPatientRecordPage(driver);
		fdr.searchForPatient("Joh");
		int resultsCount = fdr.getSearchResultsCount();
		Assert.assertTrue(resultsCount > 0, "No patients found with the partial name 'Joh'");
	}

}
