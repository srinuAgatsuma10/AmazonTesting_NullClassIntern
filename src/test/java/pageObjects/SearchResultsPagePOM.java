package pageObjects;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPagePOM extends BasePOM{

	public SearchResultsPagePOM(WebDriver driver) {
		super(driver);
	}
	
	// WebElements
	/*//Brand Details*/
	@FindBy(xpath = "//a[@aria-label='See more, Brands']//span[@class='a-expander-prompt'][normalize-space()='See more']")
	WebElement seeMore;
	@FindBy(xpath = "//ul[@data-csa-c-content-id=\"91049095031\"]//li//span[@class=\"a-list-item\"]")
	List<WebElement> brandWithC;
	
	/*//Price Details*/
	@FindBy(xpath = "//label[@aria-label='Minimum']")
	WebElement currentPrice;
	@FindBy(xpath = "//div[@class='a-section s-range-input-container s-upper-bound']")
	WebElement targetPrice;
	@FindBy(xpath = "//input[@aria-label='Go - Submit price range']")
	WebElement goButton;
	
	/*//Customer rating*/
	@FindBy(xpath = "//a[@aria-label='Apply the filter 4 Stars & Up to narrow results']")
	WebElement custRatings;
	
	
	// Validation WebElements
	/*//Result Products*/
	@FindBy(xpath = "//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']")
	List<WebElement> resultProductsDesc;
	
	@FindBy(xpath = "//i[@data-cy=\"reviews-ratings-slot\"]//span[@class='a-icon-alt']")
	List<WebElement> resultProductsRatings;
	
	@FindBy(xpath = "//span[@class='a-price-whole']")
	List<WebElement> resultProductPrice;
	
	
	// Action Methods
	
	public void brandWithC() {
	    Set<String> selectedBrands = new HashSet<>(); // Store already selected brands
	    
	    while (true) {
	        seeMore.click(); // Click seeMore button
	        
	        List<WebElement> brands = brandWithC; // Re-fetch elements after clicking seeMore
	        boolean foundNewBrand = false;
	        
	        for (WebElement brandC : brands) {
	            String bC = brandC.getText();
	            if (bC.startsWith("C") && !selectedBrands.contains(bC)) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandC); // Ensure visibility
	                brandC.click(); // Click on the brand
	                selectedBrands.add(bC); // Add to selected list
	                foundNewBrand = true;
	                
	                // Wait for the page to stabilize
	                try {
	                    Thread.sleep(1000); // Adjust as needed for stability
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                break; // Break to restart loop to refresh elements
	            }
	        }
	        
	        // If no new brand was found, exit the loop
	        if (!foundNewBrand) {
	            break;
	        }
	    }
	}



	
	public void priceSelection() {
		goButton.click();
	}
	
	public void costumerRatings() {
		custRatings.click();
	}
	
	
	//Validation Action Methods
	public Boolean resultProducts() {
		for(WebElement resPro : resultProductsDesc) {
			String rePo = resPro.getText();
			if(rePo.contains("Camera")){
				return true;
			}
			else {
				System.out.println("No Products found");
			}
		}
		return null;
	}
	
	public Boolean resProRating() {
		for(WebElement resRate : resultProductsRatings) {
			if(resRate.isEnabled()) {
				return (resRate.isDisplayed());
			}
			
		}return null;
	}
	
	public Boolean productPrice() {
		for(WebElement price : resultProductPrice) {
			int proPrice = Integer.parseInt(price.getText());
			if(proPrice >= 100) {
				return (price.isDisplayed());
			}else {
				return false;
			}
		}
	return null;	
	}
	
	
	
	
		
}
