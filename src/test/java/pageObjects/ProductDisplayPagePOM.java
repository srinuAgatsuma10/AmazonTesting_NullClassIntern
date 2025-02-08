package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPagePOM extends BasePOM {

	public ProductDisplayPagePOM(WebDriver driver) {
		super(driver);
	}

	// Product Price
	@FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@aria-hidden='true']")
	WebElement proPrice;

	// Product Description
	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement proDesc;

	
	public int productPrice() {
		String price = proPrice.getText().substring(0);
		int priceOnly = Integer.parseInt(price);
		return priceOnly;
	}

	public String productDescription() {
		return(proDesc.getText());
	}

	public String currentUlr() {
		return(driver.getCurrentUrl());
	}

}
