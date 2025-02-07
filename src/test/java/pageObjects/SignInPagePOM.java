package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPagePOM extends BasePOM {

	public SignInPagePOM(WebDriver driver) {
		super(driver);
	}

	// Web Elements
	// Email Input field
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement emailBox;

	// continue button
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;

	// Password button
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement passwordBtn;

	// SignIn Button
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signInButton;

	// Password button
	@FindBy(xpath = "//input[@id='input-box-otp']")
	WebElement otpInputBox;

	// SignIn Button
	@FindBy(xpath = "//input[@aria-labelledby='cvf-submit-otp-button-announce']")
	WebElement submitCode;

	// Action methods
	public void enterEmial(String email) {
		emailBox.sendKeys(email);

	}

	public void clickContinuue() {
		continueBtn.click();
	}

	public void enterPassword(String pass) {
		passwordBtn.sendKeys(pass);

	}

	public void clickSignInBtn() {
		signInButton.click();
	}

	public void enterOTP() throws Exception {
		Thread.sleep(30000);
		submitCode.click();
	}
}
