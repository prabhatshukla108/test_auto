package com.sarafu.client.apps.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.sarafu.client.App.pages.SarafuPageAndriodBase;

public class LoginAppTest extends AbstractTest implements IMobileUtils {
	@Test(dataProvider = "SingleDataProvider", description = "JIRA#Sarafu_AUTO-001", enabled = true)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/srp_pwm_.xlsx", sheet = "MobileAutomation", dsUid = "TUID", dsArgs = "username,password")

	public void verify_valid_Login(String username, String password) {

		try {
			SarafuPageAndriodBase lp = initPage(getDriver(), SarafuPageAndriodBase.class);
			lp.clickLOGINbtn();
			lp.typeName(username);
			lp.typePassword(password);
			lp.clickContinuebtnIfactive();
		} catch (Exception e) {
			Assert.fail("Test failed " + e.getLocalizedMessage());
		}
	}

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#Sarafu_AUTO-002", enabled = true, dependsOnMethods = "verify_valid_Login")
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/srp_pwm_.xlsx", sheet = "MobileAutomation", dsUid = "TUID", dsArgs = "username,password")

	public void verify_homepage_and_logout_functionality(String username, String password) {

		try {
			SoftAssert a = new SoftAssert();
			SarafuPageAndriodBase lp = initPage(getDriver(), SarafuPageAndriodBase.class);
			lp.clickOnLocationbtnifPresent();
			boolean boo_hp = lp.checkUserReachHomeAndclickMenu();
			a.assertTrue(boo_hp, "Error : User not landed on Homepage");
			lp.clickSetting();
			boolean bool = lp.checkIsLanguagePresent();
			a.assertTrue(bool, "Error : Language switch not available");
			lp.clickLogout();
			boolean bo = lp.clickbtnConfirm();
			a.assertTrue(bo, "Error : Not able to logout");
			a.assertAll();
		} catch (Exception e) {
			Assert.fail("Test failed " + e.getLocalizedMessage());
		}
	}


}