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
		
		boolean c = util.validateElementsbyText(driver," Car");
		Thread.sleep(500);
		boolean b = util.validateElementsbyText(driver," Bike");
		Thread.sleep(500);
		boolean comm = util.validateElementsbyText(driver," Commercial");
		Thread.sleep(500);
		boolean tra = util.validateElementsbyText(driver," Travel");
		Thread.sleep(500);
		boolean l = util.validateElementsbyText(driver," Life");
		Thread.sleep(500);
		boolean h = util.validateElementsbyText(driver," Health");
		
		String s=c+"|"+b+"|"+comm+"|"+tra+"|"+l+"|"+h;
		System.out.println("String :"+s);
	return s;
	}
	
	
	

}
