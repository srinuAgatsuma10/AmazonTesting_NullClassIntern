package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAccountPagePOM extends BasePOM {

	public YourAccountPagePOM(WebDriver driver) {
		super(driver);
	}

	// Login and Security
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	WebElement totalCartPrice;

	// UserName
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	WebElement userName;

	public void clickLogAndSecurity() {
		totalCartPrice.click();
	}

	public Boolean validateUserName() {
		String name = userName.getText();
		return name.length() == 10 && name.chars().allMatch(Character::isLetterOrDigit);
	}

}
