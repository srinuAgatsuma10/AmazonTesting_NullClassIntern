package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;
import testBase.BaseClass;

public class TaskFour extends BaseClass {

	@BeforeClass
	public void signIntoApplication() throws Exception {
		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickSignIn();

		SignInPagePOM sip = new SignInPagePOM(driver);
		sip.enterEmial("thethundergod2025@gmail.com");
		sip.clickContinuue();
		sip.enterPassword("Allow@me");
		sip.clickSignInBtn();
//		sip.enterOTP();
	}

	@Test
	public void addToCart() throws Exception {
		try {
			HomePagePOM hp = new HomePagePOM(driver);
			hp.enterProduct("Headphones");
			hp.clickSearchIcon();

			SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
			spm.clickRandomProduct();

			WindowHandler winH = new WindowHandler(driver);

			for (int i = 0; i <= 3; i++) {

				Boolean isLasInteration = (i == 3);
				winH.Handling2windows(isLasInteration);

			}

			spm.cilcATCbtn();
			CartPagePOM cpm = new CartPagePOM(driver);
			cpm.validateTotalPrice();
			hp.clickSignIn();

			YourAccountPagePOM yap = new YourAccountPagePOM(driver);
			yap.clickLogAndSecurity();

			SignInPagePOM sip = new SignInPagePOM(driver);
			sip.enterPassword("Allow@me");
			sip.clickSignInBtn();
//			sip.enterOTP();

			yap.validateUserName();

			Boolean totalPriceValidation = cpm.validateTotalPrice();
			Boolean unserNameValidation = yap.validateUserName();

//			if (totalPriceValidation == true && unserNameValidation == true) {
//				Assert.assertTrue(true);
//			} else {
//				Assert.assertTrue(true);
//			}
			Assert.assertTrue(totalPriceValidation && unserNameValidation,
					"Validation failed: Either totalPriceValidation or unserNameValidation is false");

		} catch (Exception e) {
			Assert.fail();
		}

	}
}
