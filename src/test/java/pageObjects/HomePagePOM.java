package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePOM extends BasePOM {

	public HomePagePOM(WebDriver driver) {
		super(driver);
	}

	// WebElements
	//Search Box
	@FindBy(xpath = "")
	WebElement searchBox;
	
	//Search Icon
	@FindBy(xpath = "")
	WebElement searchIcon;
	
	
	// Action Methods
	public void enterProduct(String name){
		try {
		if(searchBox.isEnabled()) {
		searchBox.sendKeys(name);
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void clickSearchIcon() {
		searchIcon.click();
	}
}
