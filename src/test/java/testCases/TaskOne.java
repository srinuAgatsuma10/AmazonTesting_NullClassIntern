package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchResultsPagePOM;
import pageObjects.TestPOM;
import testBase.BaseClass;

public class TaskOne extends BaseClass {

//	public Test1(WebDriver driver) {
//		super(driver);
//	}

	@Test
	public void test() throws Exception {
		try {
		TestPOM tp = new TestPOM(driver);
		tp.enterName("camera");
		tp.click();
		
		SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
		spm.brandWithC();
		//spm.priceSelection();
		spm.costumerRatings();
		
		Boolean products = spm.resultProducts();
		Boolean ratings = spm.resProRating();
		Boolean price = spm.productPrice();
		
		
		if(products == true && ratings == true && price == true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
		catch(Exception e) {
			Assert.fail();
		}
	}
}
