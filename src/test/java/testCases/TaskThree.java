package testCases;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePagePOM;
import pageObjects.ProductDisplayPagePOM;
import pageObjects.SearchResultsPagePOM;
import testBase.BaseClass;

public class TaskThree extends BaseClass {

//	@BeforeClass
//	public void signIntoApplication() throws Exception {
//		HomePagePOM hp = new HomePagePOM(driver);
//		hp.clickSignIn();
//
//		SignInPagePOM sip = new SignInPagePOM(driver);
//		sip.enterEmial(prop.getProperty("workingEmail1"));
//		sip.clickContinuue();
//		sip.enterPassword(prop.getProperty("workingPassword"));
//		sip.clickSignInBtn();
//		sip.enterOTP();
//	}

	@Test
	public void priceDropEmail() throws Exception {
		try {
			HomePagePOM hp = new HomePagePOM(driver);
			hp.searchRandomProduct();
			hp.clickSearchIcon();

			SearchResultsPagePOM spm = new SearchResultsPagePOM(driver);
			spm.clickRandomProduct();

			String thresholdPrice = prop.getProperty("threPrice");
			int threPrice = Integer.parseInt(thresholdPrice);

			ProductDisplayPagePOM pdm = new ProductDisplayPagePOM(driver);
			int price = pdm.productPrice();
			String productTitle = pdm.productDescription();
			String url = pdm.currentUlr();

			if (price < threPrice) {
				// Trigger email notification
				String recipientEmail = prop.getProperty("recipientEmail");
				EmailUtils.sendPriceDropEmail(recipientEmail, productTitle, price, url);
				Assert.assertTrue(true, "Price drop notification sent successfully.");
			} else {
				System.out.println("No product price should be down");
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}

	// Method to send email
	public static class EmailUtils {

		public static void sendPriceDropEmail(String recipientEmail, String productTitle, int productPrice,
				String productUrl) {
			try {
				// Set up the email
				Email email = new SimpleEmail();
				email.setHostName("smtp.gmail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator("your_sender_email@gmail.com", // Replace with sender
																								// email
						"your_password_or_app_password")); // Replace with app password
				email.setSSLOnConnect(true);
				email.setFrom("your_sender_email@gmail.com"); // Sender email
				email.setSubject("Price Drop Alert: " + productTitle);

				// Dynamic email body
				String message = String.format(
						"Good news! The price of the product '%s' has dropped.\n\nCurrent Price: ₹%d\nProduct Link: %s\n\nAct fast before the price changes!",
						productTitle, productPrice, productUrl);

				email.setMsg(message); // Set the email message
				email.addTo(recipientEmail); // Recipient email

				// Send the email
				email.send();
				System.out.println("Price drop notification sent successfully!");

			} catch (Exception e) {
				System.err.println("Failed to send price drop email: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
