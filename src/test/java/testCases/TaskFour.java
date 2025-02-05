package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePagePOM;
import pageObjects.SearchResultsPagePOM;
import testBase.BaseClass;

public class TaskFour extends BaseClass {
	
	@Test
	public void addToCart() {
		
		HomePagePOM hp = new HomePagePOM(driver);
		hp.enterProduct("Headphones");
		hp.clickSearchIcon();
		
		SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
		
	}
}
