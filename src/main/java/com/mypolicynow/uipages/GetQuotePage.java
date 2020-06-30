package com.mypolicynow.uipages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mypolicynow.utils.Utilities;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class GetQuotePage extends AbstractPage {
	private static final WebElement WebElement = null;

	Logger LOGGER = Logger.getLogger(GetQuotePage.class);

	public GetQuotePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[text()=' Car']")
	private ExtendedWebElement btnCar;

	@FindBy(xpath = "//span[text()='Comprehensive Policy']")
	private ExtendedWebElement btnComprehensivePolicy;// 8169972611

	@FindBy(xpath = "//div[@id='compressive-pl']//input[@id='comprehensive_new']/following::span[text()=' New'][1]")
	private ExtendedWebElement btnNewPolicy;// 8169972611

	@FindBy(xpath = "//div[@id='compressive-pl']//input[@id='comprehensive_new']/following::span[text()=' Renew'][1]")
	private ExtendedWebElement btnRenewPolicy;

	@FindBy(xpath = "//select[@id='rto']")
	private ExtendedWebElement selRTO;

	@FindBy(xpath = "//select[@id='make']")
	private ExtendedWebElement selMake;

	@FindBy(xpath = "//select[@id='model']")
	private ExtendedWebElement selModel;

	@FindBy(xpath = "//select[@id='variant']")
	private ExtendedWebElement selVariant;

	@FindBy(xpath = "//select[@id='manufacturing_year']")
	private ExtendedWebElement selManufacturingYear;

	@FindBy(xpath = "//select[@id='manufacturing_month']")
	private ExtendedWebElement selManufacturingMonth;

	@FindBy(xpath = "//input[@id='purchase_invoice_date']")
	private ExtendedWebElement txtpurchaseInvoiceDate;

	@FindBy(xpath = "//select[@id='quote_policy_holder_type']")
	private ExtendedWebElement selPolicyHolderType;

	@FindBy(xpath = "//select[@id='od_discount_selected']")
	private ExtendedWebElement selODdiscount;

	@FindBy(xpath = "//input[@id='invoice_price']")
	private ExtendedWebElement txtInvoice;

	@FindBy(xpath = "//*[text()=' 1 Yr OD & 3 Yr TP ']")
	private ExtendedWebElement chk1OD3TP;// 8169972611

	@FindBy(xpath = "//*[text()=' 3 Yr OD & 3 Yr TP ']")
	private ExtendedWebElement chk3OD3TP;

	@FindBy(xpath = "//*[text()=' 1 Yr OD & 0 Yr TP ']")
	private ExtendedWebElement chkStandAlone1OD0TP;// 8169972611

	@FindBy(xpath = "//*[text()=' 1 Yr OD & 1 Yr TP ']")
	private ExtendedWebElement chkStandAlone1OD1TP;

	@FindBy(xpath = "//input[@id='have_motor_license_yes']/following::span[text()=' Yes '][1]")
	private ExtendedWebElement chkValidLicenseYes;// 8169972611

	@FindBy(xpath = "//input[@id='have_motor_license_no']/following::span[text()=' No '][1]")
	private ExtendedWebElement chkValidLicenseNo;

	@FindBy(xpath = "//input[@id='have_motor_policy_yes']/following::span[text()=' Yes '][1]")
	private ExtendedWebElement chkOwnerpolicyYes;//

	@FindBy(xpath = "//input[@id='have_motor_policy_no']/following::span[text()=' No '][1]")
	private ExtendedWebElement chkOwnerpolicyNo;

	@FindBy(xpath = "//input[@id='have_pa_policy_no']/following::span[text()=' No '][1]")
	private ExtendedWebElement chkPApolicyNo;
	@FindBy(xpath = "//input[@id='have_pa_policy_yes']/following::span[text()=' Yes '][1]")
	private ExtendedWebElement chkPApolicyYes;

	@FindBy(xpath = "//span[text()=' 1 year PA ']")
	private ExtendedWebElement chkPApolicy1yrs;
	@FindBy(xpath = "//span[text()=' 3 year PA ']")
	private ExtendedWebElement chkPApolicy3yrs;

	@FindBy(xpath = "//button[@id='get_quote_submit']")
	private ExtendedWebElement btnGetQuote;
	
	@FindBy(xpath = "//*[text()='Ex Showroom : ']")
	private ExtendedWebElement ttExshowroom;

	Utilities util = new Utilities();
	Actions actions = new Actions(getDriver());
	


	public boolean validationGQPMessage(String field, String message) {
//		WebDriver driver
		boolean bool = driver
				.findElement(
						By.xpath("//label[text()='" + field + "']/following-sibling::p/span[text()='" + message + "']"))
				.isDisplayed();
		System.out.println("Bool validationGQPMessage" + bool);
		return bool;

	}

	public String validatePlaceholder() throws InterruptedException {
		// Open home page and verify page is opened,
		
		boolean rto = util.eleIsDisplayedbyText(driver, "Select RTO");
		Thread.sleep(500);
		boolean make = util.eleIsDisplayedbyText(driver, "Select A Make");
		Thread.sleep(500);
		boolean mod = util.eleIsDisplayedbyText(driver, "Select A Variant");
		Thread.sleep(500);
		boolean var = util.eleIsDisplayedbyText(driver, "Select Manufacturing Year");
		Thread.sleep(500);
		boolean mon = util.eleIsDisplayedbyText(driver, "Select Manufacturing Month");
		Thread.sleep(500);
		boolean type = util.eleIsDisplayedbyText(driver, "Select Type");
		Thread.sleep(500);
		boolean disct = util.eleIsDisplayedbyText(driver, "Max Discount");
		String s = rto + "|" + make + "|" + mod + "|" + var + "|" + mon + "|" + type + "|" + disct;
		return s;

	}

	public String verifyGQPMessage() throws InterruptedException {
		String s = "";
		if (btnCar.isClickable())
			btnCar.click();
		else {
			System.out.println("BTN CAR NOT CLICKABLE");
		}

		btnGetQuote.click();
		Thread.sleep(500);
		boolean rto = validationGQPMessage("RTO (EX. MH-02) ", "Please select rto");
		Thread.sleep(500);
		boolean make = validationGQPMessage("Make ", "Please select make");
		Thread.sleep(500);
		boolean model = validationGQPMessage("Model ", "Please select model");
		Thread.sleep(500);
		boolean variant = validationGQPMessage("Variant ", "Please select variant");
		Thread.sleep(500);
		boolean year = validationGQPMessage("Manufacturing Year ", "Please select manufacturing year");
		Thread.sleep(500);
		boolean month = validationGQPMessage("Manufacturing Month ", "Please select manufacturing month");
		Thread.sleep(500);
		boolean date = validationGQPMessage("Purchase/Registration Date ", "Please enter purchase/registration date");
		Thread.sleep(500);
		boolean holdertype = validationGQPMessage("Policy Holder Type", "Please select policy holder type");
		s = rto + "|" + make + "|" + model + "|" + variant + "|" + year + "|" + month + "|" + date + "|" + holdertype;
		System.out.println("s :" + s);
		return s;
	}

	public void testGetQuotepage(String rto, String make, String model, String variant, String man_year,
			String man_month, String purchaseDate, String polHolderType, String ODdiscount, String invoice,
			String chkOD, String chkstandaloneOD, String chkvalidLicence, String chkanotherMotorInsPol,
			String chkPAPolicy15, String chkPACover) {
		// Open home page and verify page is opened
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println("IN TESTGET");

			try {
				if (btnCar.isClickable())
					btnCar.click();
				else {
					System.out.println("BTN CAR NOT CLICKABLE");
				}
				if (btnComprehensivePolicy.isElementPresent() && btnComprehensivePolicy.isClickable()) {
					LOGGER.debug("CLICKED ComprehensivePolicy BUTTON");
					btnComprehensivePolicy.click();
					LOGGER.debug("CLICKED LOGIN BUTTON");
					System.out.println("CLICKED ComprehensivePolicy BUTTON");
				}
			} catch (Exception e) {
				System.out.println("CANT click comprehensive : " + e.getLocalizedMessage());
			}
			if (btnNewPolicy.isElementPresent() && btnNewPolicy.isElementPresent()) {
				WebElement element =driver.findElement(By.xpath("//button[@id='get_quote_submit']"));
				Thread.sleep(2000);
				btnNewPolicy.click();
				Thread.sleep(1000);
				selRTO.select(rto);
				Thread.sleep(1000);
				selMake.select(make);
				Thread.sleep(1000);
				selModel.select(model);
				Thread.sleep(1000);
				selVariant.select(variant);
				Thread.sleep(1000);
				selManufacturingYear.select(man_year);
				Thread.sleep(1000);
				selManufacturingMonth.select(man_month);
				Thread.sleep(1000);

				WebElement datePicker = driver.findElement(By.xpath("//*[@id='purchase_invoice_date']"));
				js.executeScript("document.getElementById('purchase_invoice_date').removeAttribute('readonly');",
						datePicker);
				driver.findElement(By.xpath("//*[@id='purchase_invoice_date']")).sendKeys(purchaseDate);
				txtpurchaseInvoiceDate.type(purchaseDate);
				txtpurchaseInvoiceDate.sendKeys(Keys.TAB);

				Thread.sleep(1000);
				selPolicyHolderType.select(polHolderType);
				Thread.sleep(1000);
				selODdiscount.select(ODdiscount);
				if (txtInvoice.isElementPresent()) {
					txtInvoice.type(invoice);
				} else {
					LOGGER.error("txtinvoice not present");
				}

				if (chkOD.equalsIgnoreCase("1")) {
					chk1OD3TP.click();
					Thread.sleep(1000);
				} else if (chkOD.equals("3")) {
					chk3OD3TP.click();
					Thread.sleep(1000);
				} else {
					LOGGER.error("Verfiy the string check OD inserted");
				}
				// IF STD ALONE OD IS PRESENT and NOT NULL
				if (!chkstandaloneOD.isEmpty()) {
					try {
						if (chkStandAlone1OD1TP.isClickable()) {
							if (chkstandaloneOD.equalsIgnoreCase("1")) {
								chkStandAlone1OD1TP.click();
							} else if (chkstandaloneOD.equals("0")) {
								chkStandAlone1OD0TP.click();
							} else {
								LOGGER.error("Verfiy the string check standaloneOD inserted as " + chkstandaloneOD);
								System.out.println("STANDALONE OD NOT ");
							}
						} else {

							System.out.println("STANDALONE OD NOT PRESENT");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (chkvalidLicence.equalsIgnoreCase("y")) {
					chkValidLicenseYes.click();
					if (chkOwnerpolicyNo.isElementPresent() && chkOwnerpolicyYes.isElementPresent()) {
						if (chkanotherMotorInsPol.equalsIgnoreCase("Y")) {
							chkOwnerpolicyYes.click();
							if (btnGetQuote.isElementPresent() && btnGetQuote.isClickable()) {
								((JavascriptExecutor)
										driver).executeScript("window.scrollBy(289.67,60)");	
										Thread.sleep(2000);
										btnGetQuote.click();
										Thread.sleep(5000);
								Thread.sleep(5000);
								System.out.println("TITLE GETPAGE *************** :"+driver.getTitle());
							} else {
								LOGGER.error("BUTToN QUOTE NOT PRESENT");
							}
						} else if (chkanotherMotorInsPol.equalsIgnoreCase("N")) {
							chkOwnerpolicyNo.click();
							if (chkPApolicyYes.isElementPresent() && chkPApolicyNo.isElementPresent()) {
								if (chkPAPolicy15.equalsIgnoreCase("Y")) {
									chkPApolicyYes.click();
									if (btnGetQuote.isElementPresent() && btnGetQuote.isClickable()) {
										((JavascriptExecutor)
												driver).executeScript("window.scrollBy(289.67,60)");	
										Thread.sleep(2000);
										btnGetQuote.click();
										System.out.println("TITLE GETPAGE *************** :"+driver.getTitle());
									} else {
										LOGGER.error("BUTToN QUOTE NOT PRESENT");
									}
								} else if (chkPAPolicy15.equalsIgnoreCase("N")) {
									chkPApolicyNo.click();
									if (chkPApolicy1yrs.isElementPresent() && chkPApolicy3yrs.isPresent()) {
										if (chkPACover.equalsIgnoreCase("1")) {
											chkPApolicy1yrs.click();
											((JavascriptExecutor)
											driver).executeScript("window.scrollBy(289.67,60)");	
											Thread.sleep(2000);
											btnGetQuote.click();
											Thread.sleep(5000);
											boolean bool = ttExshowroom.isElementPresent();
											Assert.assertTrue(bool,"Element Exshowroom not present");
											System.out.println("TITLE GETPAGE *************** :"+driver.getTitle());
//											WebElement btnGetQuot = driver.findElement(By.xpath("//*[@id='get_quote_submit']"));
											System.out.println("TITLE GETPAGE *************** :"+driver.getTitle());
										} else if (chkPACover.equalsIgnoreCase("3")) {
											chkPApolicy3yrs.click();
										((JavascriptExecutor)
											driver).executeScript("window.scrollBy(289.67,60)");	
										Thread.sleep(2000);
											btnGetQuote.click();
//											actions.moveToElement(element).click().perform();
											Thread.sleep(5000);
											boolean bool = ttExshowroom.isElementPresent();
											Assert.assertTrue(bool,"Element Exshowroom not present");
											System.out.println("TITLE GETPAGE *************** :"+driver.getTitle());
//											WebElement btnGetQuot = driver.findElement(By.xpath("//*[@id='get_quote_submit']"));
//											js.executeScript("arguments[0].scrollIntoView()", btnGetQuot); 

										} else {
											System.out.println("FAILED IN PA POLICY 1 & 3 Years");
										}

									}

								}
							}

						}

					} else
						LOGGER.error("Ownerpolicy chkbox is not present" + chkOwnerpolicyNo);
				} else if (chkvalidLicence.equalsIgnoreCase("n")) {
					chkValidLicenseNo.click();
					if (btnGetQuote.isElementPresent() && btnGetQuote.isClickable()) {
						Thread.sleep(1000);
						js.executeScript("scroll(250, 0)");
						btnGetQuote.click();
						Thread.sleep(4000);
						boolean bool = ttExshowroom.isElementPresent();
						Assert.assertTrue(bool,"Element Exshowroom not present");
						
					System.out.println("TITLE GETPAGE *************** :"+driver.getTitle());
					} else {
						LOGGER.error("BUTTON QUOTE NOT PRESENT");
					}

				}

			} else {
				LOGGER.error("BUTTON NEW IS NOT CLICKED");
			}
		} catch (Exception e) {
			LOGGER.error("FAILED LOGIN :" + e.getLocalizedMessage());
		}

	}
}
