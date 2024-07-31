package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class HomePageTextClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority = 2,groups = {"group3"})
	
	public void verifyFindPatientRecordLinkIsDisplayed() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp = new HomePageClass(driver);
		Assert.assertTrue(hp.isFindPatientRecordLinkDisplayed(),
				"Find Patient Record link is not displayed on the home page.");
	}

	@Test(priority = 1,groups = {"group3"})
	public void verifyRegisterAPatientLinkIeDisplayedOnHomePage() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp = new HomePageClass(driver);

		Assert.assertTrue(hp.isRegisterPatientLinkDisplayed(),
				"Register Patient link is not displayed on the home page.");

	}

	@Test(priority = 3,groups = {"group1"})
	public void verifyLogoutFunctionality() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp = new HomePageClass(driver);
		hp.logout();

		// Verify that we are logged out and redirected to the login page
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("login.htm"), "Logout was not successful.");
	}

	@Test(priority = 4,groups = {"group3"})
	public void verifyAdminDropdownMyAccountAndHomeIcon() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));

		hp = new HomePageClass(driver);

		hp.clickAdminDropdown();
		hp.clickMyAccountLink();
		Assert.assertTrue(hp.isHomeIconDisplayed(), "HomeIcon is not displayed on the My Account page.");
	}
}
