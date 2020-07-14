package com.mypolicynow.uipages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class QuotationPage extends AbstractPage {

	Logger LOGGER = Logger.getLogger(QuotationPage.class);

	public QuotationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//p[text()='Some ICs are getting time to load if you want to edit please click edit button.']")
	private ExtendedWebElement loader;

	@FindBy(xpath = "//h3[text()='Ex Showroom : ']/i/following-sibling::span")
	private ExtendedWebElement txtExShowroomPrice;// 8169972611

	@FindBy(xpath = "//*[text()=' Min:']/following-sibling::span")
	private ExtendedWebElement txtMinimumIDV;// 8169972611

	@FindBy(xpath = "//*[text()=' Max:']/following-sibling::span")
	private ExtendedWebElement txtMaximumIDV;

	@FindBy(xpath = "//input[@id='change_idv_input']")
	private ExtendedWebElement txtActualIDV;

	@FindBy(xpath = "//button[text()='Submit']")
	private ExtendedWebElement btnSubmit;

	@FindBy(xpath = "//span[text()='Accessories']")
	private ExtendedWebElement chkAccessories;

	@FindBy(xpath = "//span[text()='Deductibles']")
	private ExtendedWebElement chkDeductibles;// 8169972611

	@FindBy(xpath = "//span[text()='PA Covers']")
	private ExtendedWebElement chkPACovers;// 8169972611

	@FindBy(xpath = "//input[@id='electrical_val']")
	private ExtendedWebElement txtElecricalVal;

	@FindBy(xpath = "//input[@id='non_electrical_val']")
	private ExtendedWebElement txtNonElectricalVal;

	@FindBy(xpath = "//input[@id='cng_val']")
	private ExtendedWebElement txtCNGval;
	
	@FindBy(xpath = "//img[@id='loading-image']")
	private ExtendedWebElement imgLoader;
	
	// Some ICs are getting time to load if you want to edit please click edit
	// button.
	// idv = for new : as per formula.
	// for renew : based on the age of vehicle

	public void calculateIDV() {

		int exshowroomPrice = Integer.parseInt(txtExShowroomPrice.getText());
		System.out.println("exshowroomPrice : " + exshowroomPrice);
		int minimumIDV = Integer.parseInt(txtMinimumIDV.getText());
		System.out.println("minimumIDV : " + minimumIDV);
		int maxIDV = Integer.parseInt(txtMaximumIDV.getText());
		System.out.println("minimumIDV : " + maxIDV);
		System.out.println("ACTUAL IDV : " + txtActualIDV.getText());
		int idv = 0;
		try {
			idv = Integer.parseInt(txtActualIDV.getText());
			System.out.println("minimumIDV : " + idv);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SoftAssert ass = new SoftAssert();

		int expected_idv = (int) (exshowroomPrice - (exshowroomPrice * 0.05));
		ass.assertEquals(idv, expected_idv);
		System.out.println(idv + "- ACTUAL IDV : EXPECTED " + expected_idv);

		int min_idv = (int) (idv - (idv * 0.05));
		ass.assertEquals(minimumIDV, min_idv);
		System.out.println(minimumIDV + "- ACTUAL MINI IDV : EXPECTED " + min_idv);

		int max_idv = (int) (idv + (idv * 0.05));
		ass.assertEquals(maxIDV, max_idv);
		System.out.println(maxIDV + "- ACTUAL MAX IDV : EXPECTED " + max_idv);

		ass.assertAll();

	}

	public void clickBuyNow() {
		String company = "BHARTI AXA GENERAL INSURANCE CO LTD";
		driver.findElement(
				By.xpath("//img[@alt='" + company + "']//following::button[normalize-space(text())='Buy Policy'][1]"))
				.click();
	}

	public void clickBreakUp() {

		String company = "BHARTI AXA GENERAL INSURANCE CO LTD";
		driver.findElement(
				By.xpath("//img[@alt='" + company + "']//following::a[normalize-space(text())='Breakup'][1]")).click();
		// img[@alt='BHARTI AXA GENERAL INSURANCE CO
		// LTD']//following::a[normalize-space(text())='Breakup'][1]
	}

	public void addAcessories(String addElectrical, String addNonElectrical, String cngLpg) throws InterruptedException {

		if (chkAccessories.isElementPresent(1000)) {
			chkAccessories.click();
			driver.switchTo().activeElement();
			txtElecricalVal.type(addElectrical);
			txtNonElectricalVal.type(addNonElectrical);
			txtCNGval.type(cngLpg);
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(79.22,31)");
			btnSubmit.click();
			imgLoader.waitUntilElementDisappear(10000);
			Thread.sleep(3000);
			if (driver.findElement(By.xpath("//img[@alt='BHARTI AXA GENERAL INSURANCE CO LTD']//following::a[normalize-space(text())='Breakup'][1]")).isDisplayed())
			{
				driver.findElement(By.xpath("//img[@alt='BHARTI AXA GENERAL INSURANCE CO LTD']//following::a[normalize-space(text())='Breakup'][1]")).click();
				Thread.sleep(5000);
			}
		}

	}
	

}
