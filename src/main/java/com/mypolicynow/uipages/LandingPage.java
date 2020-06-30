package com.mypolicynow.uipages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mypolicynow.utils.Utilities;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class LandingPage  extends AbstractPage {

	Logger LOGGER = Logger.getLogger(LandingPage.class);

	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Utilities util = new Utilities();
	
	public String verifyLandingpageElements() throws InterruptedException {
		
		boolean c = util.eleIsDisplayedbyText(driver," Car");
		Thread.sleep(500);
		boolean b = util.eleIsDisplayedbyText(driver," Bike");
		Thread.sleep(500);
		boolean comm = util.eleIsDisplayedbyText(driver," Commercial");
		Thread.sleep(500);
		boolean tra = util.eleIsDisplayedbyText(driver," Travel");
		Thread.sleep(500);
//		boolean l = util.eleIsDisplayedbyText(driver," Life");
		Thread.sleep(500);
		boolean h = util.eleIsDisplayedbyText(driver," Health");
		
		String s=c+"|"+b+"|"+comm+"|"+tra+"|"+h;
		System.out.println("String :"+s);
	return s;
	}
	
	public GetQuotePage getGQPdriver() {
		
		return new GetQuotePage(getDriver());
		
	}
	
	

}
