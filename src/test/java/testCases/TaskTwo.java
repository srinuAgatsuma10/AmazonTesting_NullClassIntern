package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePagePOM;
import pageObjects.SearchResultsPagePOM;
import testBase.BaseClass;

public class TaskTwo extends BaseClass {
	@Test
	public void searchingProducts() throws Exception {

		BaseClass bc = new BaseClass();
		bc.threeToSixPMTime();

		try {
			HomePagePOM hp = new HomePagePOM(driver);
			hp.enterProduct(prop.getProperty("productName1"));
			hp.clickSearchIcon();

			SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
			spm.brandWithC();
			spm.priceSelection();
			spm.costumerRatings();

			Boolean products = spm.resultProducts();
			Boolean ratings = spm.resProRating();
			Boolean price = spm.productPrice();

//		if(products == true && ratings == true && price == true) {
//			Assert.assertTrue(true);
//		}
//		else {
//			Assert.assertTrue(false);
//		}

			Assert.assertTrue(products && ratings && price,
					"Validation failed: Either products, ratings, or price is false");

		} catch (Exception e) {
			Assert.fail();
		}
	}

}
