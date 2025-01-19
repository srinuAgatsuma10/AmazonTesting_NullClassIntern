package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPagePOM extends BasePOM{

	public SearchResultsPagePOM(WebDriver driver) {
		super(driver);
	}
	
	// WebElements
	/*//Brand Details*/
	@FindBy(xpath = "//ul[@data-csa-c-content-id=\"91049095031\"]//li//span[@class=\"a-list-item\"]")
	List<WebElement> brandWithC;
	
	/*//Price Details*/
	@FindBy(xpath = "//label[@aria-label='Minimum']")
	WebElement currentPrice;
	@FindBy(xpath = "")
	WebElement targetPrice;
	
	/*//Customer rating*/
	@FindBy(xpath = "//a[@aria-label='Apply the filter 4 Stars & Up to narrow results']")
	WebElement custRatings;
	
	
	// Validation Elements
	/*//Result Products*/
	@FindBy(xpath = "//div[@class=\"a-section a-spacing-none puis-padding-right-small s-title-instructions-style\"]")
	List<WebElement> resultProductsDesc;
	
	@FindBy(xpath = "//i[@data-cy=\"reviews-ratings-slot\"]//span[@class='a-icon-alt']")
	WebElement resultProductsRatings;
	
	@FindBy(xpath = "")
	WebElement resultProductPrice;
	
	
	// Action Methods
		
}
