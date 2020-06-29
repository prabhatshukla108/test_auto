package com.mypolicynow.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

public class Utilities {

	public void selectBytext(ExtendedWebElement selRTO, String text) {
		Select select = new Select((WebElement) selRTO);
		select.selectByVisibleText(text);
	}

	public void selectByIndex(WebElement ele, int index) {
		Select select = new Select(ele);
		select.selectByIndex(index);

	}

	public void selectByValue(ExtendedWebElement selRTO, String value) {
		Select select = new Select((WebElement) selRTO);
		select.selectByValue(value);
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

	public boolean validateElementsbyText(WebDriver driver,String text) {

		boolean bool = driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed();

		System.out.println(bool);
		return bool;

	}

	public String[] assertBoolean(String str) {

		String[] s = str.split("\\|");

		for (String bool : s) {
			Assert.assertEquals(bool, "true");
		}
		return s;
	}

}