package testCases;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class TestClassJava {
//
//	public static void main(String[] args) throws Exception {
////			        // Restrict execution time to 3 PM - 6 PM
////			        LocalTime now = LocalTime.now();
////			        LocalTime start = LocalTime.of(15, 0); // 3 PM
////			        LocalTime end = LocalTime.of(18, 0);   // 6 PM
////
////			        if (now.isBefore(start) || now.isAfter(end)) {
////			            System.out.println("Script can only run between 3 PM and 6 PM.");
////			            return;
////			        }
////
////			        // Set up WebDriver
////			        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Sakshi\\\\Documents\\\\chromedriver\\\\chromedriver.exe");
////					ChromeOptions options = new ChromeOptions();
////					options.addArguments("--remote-allow-origins=*");
////			 		WebDriver driver = new ChromeDriver(options);
////			 		driver.get("https://www.amazon.in/");
////					driver.manage().window().maximize();
////					
////				
////
////			        try {
////			            // Navigate to the product website
////			            driver.get("URL_of_the_product_page");
////
////			            // Apply brand filter (brands starting with 'C')
////			            List<WebElement> brands = driver.findElements(By.xpath("//label[contains(text(), 'C')]"));
////			            for (WebElement brand : brands) {
////			                brand.click();
////			            }
////
////			            // Apply price filter (above 2000)
////			            WebElement priceFilter = driver.findElement(By.xpath("//input[@name='min-price']"));
////			            priceFilter.clear();
////			            priceFilter.sendKeys("2000");
////			            priceFilter.submit();
////
////			            // Apply customer rating filter (above 4)
////			            List<WebElement> ratings = driver.findElements(By.xpath("//label[contains(text(), '4 Stars & Up')]"));
////			            for (WebElement rating : ratings) {
////			                rating.click();
////			            }
////
////			            // Search for the product
////			            WebElement searchBox = driver.findElement(By.id("search-input-box"));
////			            searchBox.sendKeys("Product Name");
////			            searchBox.submit();
////
////			            // Wait for results to load (adjust time if needed)
////			            Thread.sleep(5000);
////
////			            // Verify results
////			            List<WebElement> products = driver.findElements(By.className("product"));
////			            for (WebElement product : products) {
////			                System.out.println(product.getText());
////			            }
////
////			        } catch (Exception e) {
////			            e.printStackTrace();
////			        } finally {
////			            // Close the browser
////			            driver.quit();
////			        }
////			    }
////			
//		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.amazon.in/");
////		driver.manage().window().maximize();
//		
//		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Camera");
//		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
//		
////		Actions act = new Actions(driver);
////		//WebElement def_slider = driver.findElement(By.xpath("//input[@class=\"s-range-input\"]"));
////		WebElement def_slider = driver.findElement(By.cssSelector("input[id='p_36/range-slider_slider-item_lower-bound-slider']"));
////		System.out.println("current location :"+def_slider.getLocation());	// X-872,Y-941
////		//input[@id='p_36/range-slider_slider-item_lower-bound-slider']
////		act.dragAndDropBy(def_slider,50 ,304 ).build().perform();
////		//act.clickAndHold(def_slider).moveByOffset(50, 0).release().perform();
////		System.out.println("location after moving :"+def_slider.getLocation());
////		
//////		JavascriptExecutor js = (JavascriptExecutor) driver;
//////        js.executeScript("arguments[0].value = 2150;", def_slider); 
//		
////		  WebElement slider = driver.findElement(By.xpath("//div[contains(@class, 'sf-range-slider')]"));
////
////	        // Initialize Actions class
////	        Actions actions = new Actions(driver);
////
////	        // Move the slider by an offset (adjust values accordingly)
////	        actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();
////	        
////	        // Add a delay for observation
////	        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
//
//		
////		WebElement slider = driver.findElement(By.xpath("//div[contains(@class, 'sf-range-slider')]"));
////
////        // Execute JavaScript to set the slider value
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].setAttribute('value', '5000')", slider);
////        
////        // Add a delay for observation
////        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
////		
//		
////		   // Locate the slider knobs
////        WebElement leftKnob = driver.findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')][1]"));
////        WebElement rightKnob = driver.findElement(By.xpath("//span[contains(@class, 'ui-slider-handle')][2]"));
////
////        // Scroll into view (if needed)
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("arguments[0].scrollIntoView(true);", leftKnob);
////        js.executeScript("arguments[0].scrollIntoView(true);", rightKnob);
////
////        // Initialize Actions class
////        Actions actions = new Actions(driver);
////
////        // Move the left knob (Test small offsets first)
////        actions.clickAndHold(leftKnob).moveByOffset(10, 0).release().perform();
////        Thread.sleep(1000);
////
////        // Move the right knob
////        actions.clickAndHold(rightKnob).moveByOffset(-10, 0).release().perform();
////        Thread.sleep(1000);
////
////        // JavaScript backup (if Actions fail)
////        js.executeScript("arguments[0].style.left='30%';", leftKnob);
////        js.executeScript("arguments[0].style.left='80%';", rightKnob);
//
//		// Locate the slider
//        WebElement slider = driver.findElement(By.xpath("//input[contains(@class, 'sf-range-slider-input')]"));
//
//        // Use JavaScript to set the slider value directly
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value = 2600; arguments[0].dispatchEvent(new Event('change'))", slider);
//        
//        // Add a delay for observation
//        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
//
//		
//		driver.quit();
//		}
//	
//	
//}




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class TestClassJava {
    public static void main(String[] args) {
        // Check if the current time is between 12 PM and 5 PM
//        LocalTime now = LocalTime.now();
//        LocalTime start = LocalTime.of(12, 0); // 12 PM
//        LocalTime end = LocalTime.of(17, 0);   // 5 PM
//
//        if (now.isBefore(start) || now.isAfter(end)) {
//            System.out.println("Test can only be run between 12 PM and 5 PM.");
//            return;
//        }

        // Set the path for the ChromeDriver
//        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Sakshi\\\\Documents\\\\chromedriver\\\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
// 		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open Amazon
            driver.get("https://www.amazon.in");

            // Step 2: Search for a product
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("laptop");
            searchBox.submit();

            // Step 3: Click on the first product
            WebElement firstProduct = driver.findElement(By.cssSelector(".s-main-slot .s-result-item"));
            firstProduct.click();

            // Step 4: Add to cart
            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
            addToCartButton.click();

            // Step 5: Proceed to checkout
            WebElement cartButton = driver.findElement(By.id("nav-cart"));
            cartButton.click();

            // Step 6: Proceed to checkout
            WebElement proceedToCheckoutButton = driver.findElement(By.name("proceed-to-checkout-action"));
            proceedToCheckoutButton.click();

            // Step 7: Login (Assuming you have an account)
            // You need to replace the email and password with your own
            WebElement emailField = driver.findElement(By.id("ap_email"));
            emailField.sendKeys("patilsakshi64424@gmail.com");
            driver.findElement(By.id("continue")).click();

            WebElement passwordField = driver.findElement(By.id("ap_password"));
            passwordField.sendKeys("your_password");
            driver.findElement(By.id("signInSubmit")).click();

            // Step 8: Select payment method and confirm order
            // This part may vary based on your account settings and saved payment methods
            // You may need to add additional steps to select a payment method

            // Assuming you have a payment method set up, confirm the order
            WebElement placeOrderButton = driver.findElement(By.name("placeYourOrder1"));
            placeOrderButton.click();

            // Step 9: Confirm order
            System.out.println("Order placed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}






