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
	
	@FindBy(xpath = "//*[text()='Invalid Credentials']")
	private ExtendedWebElement btnValidationMsg;
	public boolean verifyLoginvalidationsmsg() {
		boolean bool = false;
		try {
			clickBtnLogin();
			clickBtnSubmit();
			bool = driver.findElement(By.xpath("//*[text()='Invalid Credentials']")).isDisplayed();
			System.out.println("BOOL msg :" + bool);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}
	public void clickBtnLogin() {
		if (btnLogin.isElementPresent(1000) && btnLogin.isClickable()) {
			btnLogin.click();
			LOGGER.debug("CLICKED LOGIN BUTTON");
		}
	}
	
	public void enterUsernameAndPass(String username, String password) {
		if (txtUsername.isElementPresent(1000) && txtPassword.isElementPresent()) {
			txtUsername.type(username);
			LOGGER.debug("ENTERED USERNAME");
			txtPassword.type(password);
			LOGGER.debug("ENTERED PASSWORD");
		
		}
	}
	
	public void clickBtnSubmit() {
		try {
			if(btnSubmit.isElementPresent() && btnSubmit.isClickable())
				btnSubmit.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}

	public String testLogin(String username, String password) {
		String title = "";
		boolean boolRememberMe = false, btnfrgtpass = false;
		// Open home page and verify page is opened
		try {
			clickBtnLogin();
			enterUsernameAndPass(username, password);
			btnfrgtpass = btnForgetPass.isElementPresent();
			System.out.println(btnfrgtpass);
			boolRememberMe = chkRememberme.isElementPresent();
			System.out.println(boolRememberMe);
			clickBtnSubmit();
//			boolean validationmsg = !(btnValidationMsg.isElementPresent());
//			System.out.println("VLADTION MSG :"+validationmsg);
			title=boolRememberMe + "|" + btnfrgtpass;
//			System.out.println("Logged in successfully :"+title );

		} catch (Exception e) {
			LOGGER.error("FAILED LOGIN :" + e.getLocalizedMessage());
		}
		return title; // new LandingPage(getDriver());
	}

	public LandingPage getLandingDriver() {
		return new LandingPage(getDriver());
	}
//	public void login(String username, String pass) throws InterruptedException {
//
//		if (btnLogin.isElementPresent() && btnLogin.isClickable()) {
//			btnLogin.click();
//			LOGGER.debug("CLICKED LOGIN BUTTON");
//		}
//		if (txtUsername.isElementPresent() && txtPassword.isElementPresent()) {
//			txtUsername.type(username);
//			LOGGER.debug("ENTERED USERNAME");
//			txtPassword.type(pass);
//			LOGGER.debug("ENTERED PASSWORD");
//			
//		}
//		if (btnSubmit.isElementPresent() && btnSubmit.isClickable()) {
//			btnSubmit.click();
//			Thread.sleep(1000);
//		}		
//	}

}
