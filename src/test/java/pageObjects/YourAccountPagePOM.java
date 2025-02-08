package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAccountPagePOM extends BasePOM {

	public YourAccountPagePOM(WebDriver driver) {
		super(driver);
	}

	// Login and Security
	@FindBy(xpath = "//div[@data-card-identifier='SignInAndSecurity']//div[@class='a-box-inner']")
	WebElement totalCartPrice;

	// UserName
	@FindBy(xpath = "//span[@id='NAME_SUBTITLE']")
	WebElement userName;

	// User Email
	@FindBy(xpath = "//span[@id='EMAIL_SUBTITLE']")
	WebElement userEmail;

	public void clickLogAndSecurity() {
		totalCartPrice.click();
	}

	public Boolean validateUserName() {
		String name = userName.getText();
		return name.length() == 10 && name.chars().allMatch(Character::isLetterOrDigit);
	}

	public String validateUserEmail() {
		// String email;
		return (userEmail.getText());
	}

	public boolean forbcharInUserName() {
		String name = "Thunder Storm";
		char[] nameArr = name.toCharArray();
		char[] forbiddenCharArr = { 'A', 'C', 'G', 'I', 'L', 'K' };
		for (int i = 0; i < nameArr.length; i++) {
			for (int j = 0; j < forbiddenCharArr.length; j++) {
				if (nameArr[i] == forbiddenCharArr[j]) {
					return false;
				}
			}
		}
		return true;
	}
}
