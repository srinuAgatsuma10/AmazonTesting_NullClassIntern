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
			logger.info("****Starting Task Five TestCase****");
			logger.info("Loggin to the Application");
			HomePagePOM hp = new HomePagePOM(driver);
			hp.clickSignIn();

			logger.info("Filling user SignIn data");
			SignInPagePOM sip = new SignInPagePOM(driver);
			sip.enterEmial(prop.getProperty("workingEmail1"));
			sip.clickContinuue();
			sip.enterPassword(prop.getProperty("workingPassword"));
			sip.clickSignInBtn();

			logger.info("Navigating to AccountList page");
			hp.navigateToAccList();

			logger.info("Navigating YourAccount page");
			YourAccountPagePOM yap = new YourAccountPagePOM(driver);
			yap.clickLogAndSecurity();
			sip.enterOTP();
			String userEmail = yap.validateUserEmail();

			logger.info("Validating user name");
			yap.forbcharInUserName();

			boolean forbChar = yap.forbcharInUserName();

			Assert.assertTrue(userEmail.equals(prop.getProperty("workingEmail1")) && forbChar);
		} catch (Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("****Terminating Task Five TestCase****");
	}
}
