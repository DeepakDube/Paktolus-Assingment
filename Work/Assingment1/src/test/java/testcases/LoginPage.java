package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseTest;
import utility.ReadXLSdata;

public class LoginPage extends BaseTest {

	@Test(dataProvider = "getData", dataProviderClass = ReadXLSdata.class)
	public static void LoginTest(String name, String email, String phone, String company) {

		driver.findElement(By.id(loc.getProperty("name_field"))).sendKeys(name);
		driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(email);
		driver.findElement(By.xpath(loc.getProperty("no_field"))).sendKeys(phone);
		driver.findElement(By.cssSelector(loc.getProperty("company_field"))).sendKeys(company);
		driver.findElement(By.xpath(loc.getProperty("next_btn"))).click();
		driver.findElement(By.xpath(loc.getProperty("area_field"))).click();
		driver.findElement(By.xpath(loc.getProperty("next_btn"))).click();
		driver.findElement(By.xpath(loc.getProperty("range_field"))).click();
		driver.findElement(By.xpath(loc.getProperty("next_btn"))).click();
		WebElement actual = driver.findElement(By.className(loc.getProperty("text_field")));
		Assert.assertTrue(actual.isDisplayed());
		System.out.println(actual.isDisplayed());

	}

	// @DataProvider(name = "testdata")
	// public Object[][] tData() {

	// return new Object[][] {

//				{ "Deepak", "abc@gmail.com", "9876543210", "Cnc Web" }, { "   ", "abc@gmail.com", "  ", "Cnc Web" },
	// { "9876543210", "Deepak", "abc@gmail.com", "Deepak" }, { " ", " ", " ", " "
	// },

	// };

	// }

}
