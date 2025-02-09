package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;
import testBase.BaseClass;

public class TaskFour extends BaseClass {

	@BeforeClass
	public void signIntoApplication() throws Exception {
		logger.info("***Loging to the Application***");
		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickSignIn();

		SignInPagePOM sip = new SignInPagePOM(driver);
		sip.enterEmial(prop.getProperty("workingEmail1"));
		sip.clickContinuue();
		sip.enterPassword(prop.getProperty("workingPassword"));
		sip.clickSignInBtn();
//		sip.enterOTP();
	}

	@Test
	public void addToCart() throws Exception {

		BaseClass bc = new BaseClass();
		bc.sixToSevenPMTime();

		try {
			logger.info("****Starting Task Four TestCase****");
			logger.info("Searching the product");
			HomePagePOM hp = new HomePagePOM(driver);
			hp.enterProduct(prop.getProperty("productName2"));
			hp.clickSearchIcon();

			logger.info("Selecting random product from Search results page");
			SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
			spm.clickRandomProduct();

			logger.info("Handling Windows");
			WindowHandler winH = new WindowHandler(driver);
			for (int i = 0; i <= 3; i++) {
				Boolean isLasInteration = (i == 3);
				winH.Handling2windows(isLasInteration);
			}

			logger.info("Navigating to Home");
			hp.logoButton();

			logger.info("Navigating to Cart page");
			spm.cilcATCbtn();

			logger.info("Validating total price in Cart page");
			CartPagePOM cpm = new CartPagePOM(driver);
			cpm.validateTotalPrice();

			logger.info("Navigaing to AccountList page");
			hp.navigateToAccList();

			YourAccountPagePOM yap = new YourAccountPagePOM(driver);
			yap.clickLogAndSecurity();

			SignInPagePOM sip = new SignInPagePOM(driver);
			sip.enterPassword(prop.getProperty("workingPassword"));
			sip.clickSignInBtn();
			sip.enterOTP();

			logger.info("Validating user name");
			yap.validateUserName();

			Boolean totalPriceValidation = cpm.validateTotalPrice();
			Boolean unserNameValidation = yap.validateUserName();

			// You can use these two approaches for validating testCase.

			// Approach 1
//			if (totalPriceValidation == true && unserNameValidation == true) {
//				Assert.assertTrue(true);
//			} else {
//				Assert.assertTrue(false);
//			}

			// Approach 2
			Assert.assertTrue(totalPriceValidation && unserNameValidation,
					"Validation failed: Either totalPriceValidation or unserNameValidation is false");

		} catch (Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("****Terminating Task Four TestCase****");
	}
}
