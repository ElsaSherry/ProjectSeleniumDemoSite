package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class LoginPageTextClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority = 3,groups = {"group1"})
	public void verifySuccesfullogin() throws IOException {
		lp = new LoginPageClass(driver); 
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));

		hp = new HomePageClass(driver);

		// Verify that we have successfully logged in
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("home.page"), "Login was not successful.");
	}

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "unsuccesfull", priority = 4,groups = {"group1"})
	public void verifyUnsuccessfulLogin(String umane, String pswd) {
		lp = new LoginPageClass(driver);
		lp.login("uname", "pswd");
		
		Assert.assertTrue(lp.isErrorMessageDisplayed(), "Error message is not displayed for invalid login.");
	}

	@Test(priority = 1,groups = {"group2"})
	public void verifyTheExpectedPageisOpensWhileHittingTheUrl() {
		String expectedTitle = "Login";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "The expected page did not open.");
	}

	@Test(priority = 2,groups = {"group2"})
	public void veryfyLogoIsDisplayedOrNotInLoginPage() {
		lp = new LoginPageClass(driver);
		boolean logo_status = lp.isLogoDisplayed();
		Assert.assertTrue(logo_status, "Logo Not Found");
	}

	@Test(priority = 5,groups = {"group2"})
	public void verifyAllLocationSessionsAreDisplayedOrNotInLoginPage() {
		lp = new LoginPageClass(driver);
		boolean all_location = lp.IsAllLocationSessionIsDisplayed();
		Assert.assertTrue(all_location);

	}

}
