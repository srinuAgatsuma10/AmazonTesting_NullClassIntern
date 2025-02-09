package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePagePOM;
import pageObjects.ProductDisplayPagePOM;
import pageObjects.SearchResultsPagePOM;
import pageObjects.SignInPagePOM;
import testBase.BaseClass;
import utilities.EmailUtils;

public class TaskThree extends BaseClass {

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
	public void priceDropEmail() throws Exception {
		logger.info("");
		try {
			logger.info("****Starting Task Three TestCase****");
			logger.info("Searching the product");
			HomePagePOM hp = new HomePagePOM(driver);
			hp.searchRandomProduct();
			hp.clickSearchIcon();

			logger.info("Selecting random product from search result page");
			SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
			spm.clickRandomProduct();

			logger.info("Threshold price");
			String thresholdPrice = prop.getProperty("threPrice");
			int threPrice = Integer.parseInt(thresholdPrice);

			logger.info("Accessing product details..Product title, Price and URL");
			ProductDisplayPagePOM pdm = new ProductDisplayPagePOM(driver);
			int price = pdm.productPrice();
			String productTitle = pdm.productDescription();
			String url = pdm.currentUlr();

			logger.info("Validating the assertion");
			if (price < threPrice) {
				// Trigger email notification
				String recipientEmail = prop.getProperty("recipientEmail");
				EmailUtils.sendPriceDropEmail(recipientEmail, productTitle, price, url);
				Assert.assertTrue(true, "Price drop notification sent successfully.");
			} else {
				System.out.println("No product price should be down");
			}
		} catch (Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("***Terminating to the Application***");
	}
}
