package com.mypolicynow.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class Utilities {
//	WebDriver driver ;
//
//	WebDriverWait wait = new WebDriverWait(driver, 5);

	public void wait(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	public void CalendarTest(WebDriver driver) {
		// Creating JavascriptExecutor interface object Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement datePicker = driver.findElement(By.xpath("(//input[@class='form-control'])[11]"));
		// Need to remove readonly HTML attribute
		js.executeScript("document.getElementsByClassName('form-control')[11].removeAttribute('readonly');",
				datePicker);

		// Enter Date directly into the field
		driver.findElement(By.xpath("(//input[@class='form-control'])[11]")).sendKeys("03-05-2019");
	}

	public boolean eleIsDisplayedbyText(WebDriver driver,String text) {

		boolean bool = driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed();

		System.out.println(bool);
		return bool;

	}

	public String[] assertBoolean(String str) {
		System.out.println("IN ASSERT BOOLEAN : ");

		String[] s = str.split("\\|");

		for (String bool : s) {
			Assert.assertEquals(bool, "true");
		}
		return s;
	}

}