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
	@FindBy(xpath = "")
	List<WebElement> brandWithC;
	
	/*//Price Details*/
	
	/*//Customer rating*/
	
	/*//Result Products*/
	@FindBy(xpath = "")
	List<WebElement> resultProducts;
	
	
	
	// Action Methods
		
}
