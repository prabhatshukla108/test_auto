package com.sarafu.client.App.pages;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class SarafuPageAndriodBase extends AbstractPage {

	public SarafuPageAndriodBase(WebDriver driver) {
		super(driver);
	}

	public abstract void clickLOGINbtn();

	public abstract void typeName(String name);

	public abstract void typePassword(String password);

	public abstract void clickContinuebtnIfactive();

	public abstract boolean clickOnLocationbtnifPresent();
	
	public abstract boolean checkUserReachHomeAndclickMenu();

	public abstract void clickSetting();

	public abstract boolean checkIsLanguagePresent();

	public abstract void clickLogout();
	
	public abstract boolean clickbtnConfirm();

//	public abstract boolean checkUser_Successfully_LoggedOUT();


}