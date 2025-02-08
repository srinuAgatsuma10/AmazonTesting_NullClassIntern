package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

//	public BaseClass(WebDriver driver) {
//		this.driver = driver;
//	}

	@BeforeClass
	public void setUp() throws IOException {

		// Access URL from Properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void threeToSixPMTime() {
		LocalTime currentTime = LocalTime.now();
		LocalTime start = LocalTime.of(15, 0);
		LocalTime end = LocalTime.of(18, 0);

		if (currentTime.isBefore(start) || currentTime.isAfter(end)) {
			throw new RuntimeException("Test can only run between 3 PM and 6 PM");
		}
	}

	public void sixToSevenPMTime() {
		LocalTime currentTime = LocalTime.now();
		LocalTime start = LocalTime.of(18, 0);
		LocalTime end = LocalTime.of(19, 0);

		if (currentTime.isBefore(start) || currentTime.isAfter(end)) {
			throw new RuntimeException("Test can only run between 6 PM and 7 PM");
		}
	}

	public void twelveToThreePMTime() {
		LocalTime currentTime = LocalTime.now();
		LocalTime start = LocalTime.of(12, 0); // 12 PM
		LocalTime end = LocalTime.of(15, 0); // 3 PM

		if (currentTime.isBefore(start) || currentTime.isAfter(end)) {
			throw new RuntimeException("Test can only run between 12 PM and 3 PM");
		}
	}
	
}
