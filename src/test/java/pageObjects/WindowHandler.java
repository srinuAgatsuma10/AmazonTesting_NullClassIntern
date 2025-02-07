package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowHandler extends BasePOM {

	public WindowHandler(WebDriver driver) {
		super(driver);
	}

	// Product Page Window
	// Add to cart Button
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCart;

	public void Handling2windows(Boolean isLasInteration) throws Exception {
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Id's of current windows: " + windows);

		List<String> winid = new ArrayList(windows);
		String parent = winid.get(0);
		String child = winid.get(1);
		driver.switchTo().window(child);
		addToCart.click();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parent);

		if (!isLasInteration) {
			SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
			spm.clickRandomProduct();
		} else {
			System.out.println("Driver is in Parent window");
		}
	}

}
