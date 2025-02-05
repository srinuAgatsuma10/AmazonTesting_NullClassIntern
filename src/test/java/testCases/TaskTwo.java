package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePagePOM;
import pageObjects.SearchResultsPagePOM;
import testBase.BaseClass;

public class TaskTwo extends BaseClass {
	@Test
	public void searchingProducts() throws Exception {
		try {
		HomePagePOM hp = new HomePagePOM(driver);
		hp.enterProduct("camera");
		hp.clickSearchIcon();
		
		SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
		spm.brandWithC();
		spm.priceSelection();
		spm.costumerRatings();
		
		Boolean products = spm.resultProducts();
		Boolean ratings = spm.resProRating();
		Boolean price = spm.productPrice();
		
		
		if(products == true && ratings == true && price == true) {
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
		
	}
		catch(Exception e) {
			Assert.fail();
		}
	}

}
