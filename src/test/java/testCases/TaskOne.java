package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.TestPOM;
import testBase.BaseClass;

public class TaskOne extends BaseClass {

//	public Test1(WebDriver driver) {
//		super(driver);
//	}

	@Test
	public void test() {
		TestPOM tp = new TestPOM(driver);
		tp.enterName("Redmi Mobile");
		tp.click();
		
		Assert.assertTrue(true);
	}
}
