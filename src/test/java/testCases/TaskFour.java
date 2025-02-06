package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.*;
import testBase.BaseClass;

public class TaskFour extends BaseClass {
	
//	@BeforeClass
//	public void signIntoApplication() throws Exception {
//		HomePagePOM hp = new HomePagePOM(driver);
//		hp.clickSignIn();
//		
//		SignInPagePOM sip = new SignInPagePOM(driver);
//		sip.enterEmial("thethundergod2025@gmail.com");
//		sip.clickContinuue();
//		sip.enterPassword("Allow@me");
//		sip.clickSignInBtn();
//		sip.enterOTP();
//	}
	
	@Test
	public void addToCart() throws Exception {
		try {
		HomePagePOM hp = new HomePagePOM(driver);
		hp.enterProduct("Headphones");
		hp.clickSearchIcon();
		
		int i = 3;
		SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
		spm.clickRandomProduct();
		
		while(i<=3) {
			WindowHandler winH = new WindowHandler(driver);
			winH.Handling2windows();
			}
		}
		catch(Exception e){
			Assert.fail();
		}
		
	}
}
