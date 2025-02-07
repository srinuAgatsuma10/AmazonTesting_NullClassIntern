package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPagePOM extends BasePOM {

	public CartPagePOM(WebDriver driver) {
		super(driver);
	}

	// TotalPrice
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	WebElement totalCartPrice;

	public Boolean validateTotalPrice() {
		try {
			int totPrice = Integer.parseInt(totalCartPrice.getText());
			if (totPrice > 2000) {
				return true;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return false;
	}

}
