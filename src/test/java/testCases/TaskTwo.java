package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePagePOM;
import pageObjects.SearchResultsPagePOM;
import testBase.BaseClass;

public class TaskTwo extends BaseClass {
	@Test
	public void searchingProducts() throws Exception {
		logger.info("****Staring Task One TestCase****");

		BaseClass bc = new BaseClass();
		bc.threeToSixPMTime();

		try {
			logger.info("Searching a product");
			HomePagePOM hp = new HomePagePOM(driver);
			hp.enterProduct(prop.getProperty("productName1"));
			hp.clickSearchIcon();

			logger.info("Flitering the Products");
			SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
			spm.brandWithC();
			spm.priceSelection();
			spm.costumerRatings();

			logger.info("Accessing the Product details");
			Boolean products = spm.resultProducts();
			Boolean ratings = spm.resProRating();
			Boolean price = spm.productPrice();

			// You can use these two approaches for validating testCase.

			// Approach 1
//		if(products == true && ratings == true && price == true) {
//			Assert.assertTrue(true);
//		}
//		else {
//			Assert.assertTrue(false);
//		}
			// Approach 2
			logger.info("Validate using assertion");
			Assert.assertTrue(products && ratings && price,
					"Validation failed: Either products, ratings, or price is false");

		} catch (Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("****Terminating Task One TestCase****");
	}

}
