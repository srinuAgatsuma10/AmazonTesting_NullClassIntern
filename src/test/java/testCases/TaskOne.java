package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TaskOne {
	WebDriver driver = new ChromeDriver();
	
	@Test(priority = 1)
	public void getMthod()throws Exception {
		driver.get("https://www.amazon.in");
		driver.navigate().back();
	}
	
	@Test(priority = 2)
	public void navigateToMethod()throws Exception  {
		driver.navigate().to("https://www.amazon.in");
		Thread.sleep(3000);
		driver.refresh();
	}
}
