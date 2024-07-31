package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegiterAPatientClass;

public class RegisterAPatientTextClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass hp;
	RegiterAPatientClass rap; 
	
 
	@Test(groups = {"group2"})
	public void verifyToSelecttheButtonToGoToRegiterAPatientPage() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));

		hp = new HomePageClass(driver);
		hp.clickRegisterPatient();
		

		rap = new RegiterAPatientClass(driver);

		rap.registerPatient("Elsa", "Sherry", "Female", "01", "January", "1990", "123 Line", "Pattom", "TVM", "Kerala",
				"India", "12345", "1234567890");
		rap.relationshipWithPatient("Parent","Elsa");
		
		
		String actual_registeredPatientName=rap.registeredPatientName();
		
		String expected_registeredPatientName="Elsa";
		
		Assert.assertEquals(actual_registeredPatientName, expected_registeredPatientName,"Patient registration Failed");
		
		
	}
}
