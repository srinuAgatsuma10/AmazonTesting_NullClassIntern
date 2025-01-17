package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPOM extends BasePOM{
	
	// Constructor
	public TestPOM(WebDriver driver) {
		super(driver);
	}

	// WebElements
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchBox;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchIcon;
	
	// Action Methods
	public void enterName(String name) {
		searchBox.sendKeys(name);
	}
	
	public void click() {
		searchIcon.click();
	}
}
