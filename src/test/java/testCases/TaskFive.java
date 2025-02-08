package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePagePOM;
import pageObjects.SignInPagePOM;
import pageObjects.YourAccountPagePOM;
import testBase.BaseClass;

public class TaskFive extends BaseClass {

	@Test
	public void logInToApplication() {

		BaseClass bc = new BaseClass();
		bc.twelveToThreePMTime();

		try {
			HomePagePOM hp = new HomePagePOM(driver);
			hp.clickSignIn();

			SignInPagePOM sip = new SignInPagePOM(driver);
			sip.enterEmial(prop.getProperty("workingEmail1"));
			sip.clickContinuue();
			sip.enterPassword(prop.getProperty("workingPassword"));
			sip.clickSignInBtn();

			hp.navigateToAccList();

			YourAccountPagePOM yap = new YourAccountPagePOM(driver);
			yap.clickLogAndSecurity();
			sip.enterOTP();
			String userEmail = yap.validateUserEmail();

			yap.forbcharInUserName();

			boolean forbChar = yap.forbcharInUserName();

			Assert.assertTrue(userEmail.equals(prop.getProperty("workingEmail1")) && forbChar);
		} catch (Exception e) {
			Assert.fail();
		}

	}
}
