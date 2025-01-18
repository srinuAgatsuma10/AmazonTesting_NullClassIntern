//package testCases;
//
//import java.time.LocalTime;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class TestTask {
//
//	public static void main(String[] args) {
//			        // Restrict execution time to 3 PM - 6 PM
//			        LocalTime now = LocalTime.now();
//			        LocalTime start = LocalTime.of(15, 0); // 3 PM
//			        LocalTime end = LocalTime.of(18, 0);   // 6 PM
//
//			        if (now.isBefore(start) || now.isAfter(end)) {
//			            System.out.println("Script can only run between 3 PM and 6 PM.");
//			            return;
//			        }
//
//			        // Set up WebDriver
//			        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Sakshi\\\\Documents\\\\chromedriver\\\\chromedriver.exe");
//					ChromeOptions options = new ChromeOptions();
//					options.addArguments("--remote-allow-origins=*");
//			 		WebDriver driver = new ChromeDriver(options);
//			 		driver.get("https://www.amazon.in/");
//					driver.manage().window().maximize();
//					
//				
//
//			        try {
//			            // Navigate to the product website
//			            driver.get("URL_of_the_product_page");
//
//			            // Apply brand filter (brands starting with 'C')
//			            List<WebElement> brands = driver.findElements(By.xpath("//label[contains(text(), 'C')]"));
//			            for (WebElement brand : brands) {
//			                brand.click();
//			            }
//
//			            // Apply price filter (above 2000)
//			            WebElement priceFilter = driver.findElement(By.xpath("//input[@name='min-price']"));
//			            priceFilter.clear();
//			            priceFilter.sendKeys("2000");
//			            priceFilter.submit();
//
//			            // Apply customer rating filter (above 4)
//			            List<WebElement> ratings = driver.findElements(By.xpath("//label[contains(text(), '4 Stars & Up')]"));
//			            for (WebElement rating : ratings) {
//			                rating.click();
//			            }
//
//			            // Search for the product
//			            WebElement searchBox = driver.findElement(By.id("search-input-box"));
//			            searchBox.sendKeys("Product Name");
//			            searchBox.submit();
//
//			            // Wait for results to load (adjust time if needed)
//			            Thread.sleep(5000);
//
//			            // Verify results
//			            List<WebElement> products = driver.findElements(By.className("product"));
//			            for (WebElement product : products) {
//			                System.out.println(product.getText());
//			            }
//
//			        } catch (Exception e) {
//			            e.printStackTrace();
//			        } finally {
//			            // Close the browser
//			            driver.quit();
//			        }
//			    }
//			
//
//
//		}
//	
//	
//}
