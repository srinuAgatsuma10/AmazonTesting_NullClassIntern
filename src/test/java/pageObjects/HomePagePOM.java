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
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	//Search Icon
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchIcon;
	
	// SignIn
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement signInBtn;
	
	
	// Action Methods
	
	public void clickSignIn() {
		signInBtn.click();
	}
	
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
