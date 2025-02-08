package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePOM extends BasePOM {

	public HomePagePOM(WebDriver driver) {
		super(driver);
	}

	//Explicit Wait
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	// WebElements
	// Search Box
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;

	// Search Icon
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchIcon;

	// SignIn
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement signInBtn;
	
	// Navigate to account list
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement navToAcc;
	
	// Amazon Logo Home Button
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement logoBtn;
	
	
	

	// Action Methods

	public void clickSignIn() {
		signInBtn.click();
	}

	public void enterProduct(String name) {
		try {
			if (searchBox.isEnabled()) {
				searchBox.sendKeys(name);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickSearchIcon() {
		searchIcon.click();
	}
	
	public void navigateToAccList() {
		navToAcc.click();
	}
	
	public void logoButton() {
		WebElement logo = myWait.until(ExpectedConditions.elementToBeClickable(logoBtn));
		logo.click();
	}
	
	public void searchRandomProduct() {
	    String[] productsArray = {"Headphones", "TWS Earbuds", "Shirts for Men", "Pants for Men"};
	    String randomProduct = productsArray[new java.util.Random().nextInt(productsArray.length)];
	    searchBox.sendKeys(randomProduct);
	    
	}

}
