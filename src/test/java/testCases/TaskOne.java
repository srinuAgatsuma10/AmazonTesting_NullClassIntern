package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TaskOne {
	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testGetMethod() {
		driver.get("https://www.amazon.in/");
		System.out.println("Opened Amazon using driver.get()");
	}

	@Test(priority = 2)
	public void testNavigateToMethod() {
		driver.navigate().to("https://www.flipkart.com/");
		System.out.println("Navigated to Flipkart using driver.navigate().to()");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
