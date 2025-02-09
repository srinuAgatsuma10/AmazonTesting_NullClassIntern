package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;

import pageObjects.ProductDisplayPagePOM;

public class EmailUtils {

	public static WebDriver driver;
	public static Properties prop;

	public static void sendPriceDropEmail(String recipientEmail, String productTitle, int productPrice,
			String productUrl) throws IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);

		ProductDisplayPagePOM pdm = new ProductDisplayPagePOM(driver);
		int price = pdm.productPrice();
		String productTitle1 = pdm.productDescription();
		String url = pdm.currentUlr();
		try {
			// Set up the email
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(prop.getProperty("senderEmail"),

					prop.getProperty("senderPassword")));
			email.setSSLOnConnect(true);
			email.setFrom(prop.getProperty("senderEmail"));
			email.setSubject("Price Drop Alert: " + productTitle1);

			// Email body
			String message = String.format(
					"Good news! The price of the product '%s' has dropped.\n\nCurrent Price: ₹%d\nProduct Link: %s\n\nAct fast before the price changes!",
					productTitle1, price, url);

			email.setMsg(message);
			email.addTo(prop.getProperty("recipientEmail"));

			// Send the email
			email.send();
			System.out.println("Price drop notification sent successfully!");

		} catch (Exception e) {
			System.err.println("Failed to send price drop email: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
