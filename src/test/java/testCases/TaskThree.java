package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePagePOM;
import pageObjects.ProductDisplayPagePOM;
import pageObjects.SearchResultsPagePOM;
import testBase.BaseClass;

public class TaskThree extends BaseClass{

//	@BeforeClass
//	public void signIntoApplication() throws Exception {
//		HomePagePOM hp = new HomePagePOM(driver);
//		hp.clickSignIn();
//
//		SignInPagePOM sip = new SignInPagePOM(driver);
//		sip.enterEmial(prop.getProperty("workingEmail1"));
//		sip.clickContinuue();
//		sip.enterPassword(prop.getProperty("workingPassword"));
//		sip.clickSignInBtn();
//		sip.enterOTP();
//	}
	
	
	@Test
	public void priceDropEmail() throws Exception{
		try {
			HomePagePOM hp = new HomePagePOM(driver);
			hp.searchRandomProduct();
			hp.clickSearchIcon();

			SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
			spm.clickRandomProduct();
			
			String thresholdPrice = prop.getProperty("threPrice");
			int threPrice = Integer.parseInt(thresholdPrice);
			
			ProductDisplayPagePOM pdm = new ProductDisplayPagePOM(driver);
			int price = pdm.productPrice();	
//			String productTitle = pdm.productDescription();
//			String url = pdm.currentUlr();
			
			if(price < threPrice) {
				//Sent Mail
				System.out.println("King Of the pirates");
			}
			else {
				System.out.println("No product price should be down");
			}	
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
}
