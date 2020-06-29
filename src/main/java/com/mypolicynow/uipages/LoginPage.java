package com.mypolicynow.uipages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LoginPage extends AbstractPage {

	Logger LOGGER = Logger.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@id='open-login-pop-up']")
	private ExtendedWebElement btnLogin;

	@FindBy(xpath = "//input[@id='username_login']")
	private ExtendedWebElement txtUsername;// 8169972611

	@FindBy(xpath = "//input[@id='password']")
	private ExtendedWebElement txtPassword;// 8169972611

	@FindBy(xpath = "//*[text()=' Remember me']")
	private ExtendedWebElement chkRememberme;

	@FindBy(xpath = "//*[@id='forgot_password']")
	private ExtendedWebElement btnForgetPass;

	@FindBy(xpath = "//button[@id='login_submit']")
	private ExtendedWebElement btnSubmit;

	public boolean verifyLoginvalidationsmsg() {
		boolean bool = false;
		try {
			if (btnLogin.isElementPresent() && btnLogin.isClickable()) {
				btnLogin.click();
				LOGGER.debug("CLICKED LOGIN BUTTON");
			}
			btnSubmit.click();
			bool = driver.findElement(By.xpath("//*[text()='Invalid Credentials']")).isDisplayed();
			System.out.println("BOOL :" + bool);

			driver.findElement(By.xpath("//button[@class='mfp-close']")).click();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public String testLogin(String username, String password) {
		String title = "";
		boolean boolRememberMe = false, btnfrgtpass = false;
		// Open home page and verify page is opened
		try {
//			driver.navigate().refresh();

			if (btnLogin.isElementPresent() && btnLogin.isClickable()) {
				btnLogin.click();
				LOGGER.debug("CLICKED LOGIN BUTTON");
			}
			if (txtUsername.isElementPresent() && txtPassword.isElementPresent()) {
				txtUsername.type(username);
				LOGGER.debug("ENTERED USERNAME");
				txtPassword.type(password);
				LOGGER.debug("ENTERED PASSWORD");
				btnfrgtpass = btnForgetPass.isElementPresent();
				System.out.println(btnfrgtpass);
				boolRememberMe = chkRememberme.isElementPresent();
				System.out.println(boolRememberMe);
			}
			if (btnSubmit.isElementPresent() && btnSubmit.isClickable()) {
				btnSubmit.click();
				Thread.sleep(1000);
				title = driver.getTitle();

			}

			title = title + "|" + boolRememberMe + "|" + btnfrgtpass;
			System.out.println("LOGIN VALIDATION :" + title);
			System.out.println("Logged in successfully");

		} catch (Exception e) {
			LOGGER.error("FAILED LOGIN :" + e.getLocalizedMessage());
		}
		return title; // new LandingPage(getDriver());
	}

	public LandingPage getLandingDriver() {
		return new LandingPage(getDriver());
	}
	public void login(String username, String pass) throws InterruptedException {

		if (btnLogin.isElementPresent() && btnLogin.isClickable()) {
			btnLogin.click();
			LOGGER.debug("CLICKED LOGIN BUTTON");
		}
		if (txtUsername.isElementPresent() && txtPassword.isElementPresent()) {
			txtUsername.type(username);
			LOGGER.debug("ENTERED USERNAME");
			txtPassword.type(pass);
			LOGGER.debug("ENTERED PASSWORD");
			
		}
		if (btnSubmit.isElementPresent() && btnSubmit.isClickable()) {
			btnSubmit.click();
			Thread.sleep(1000);
		}		
	}

}
