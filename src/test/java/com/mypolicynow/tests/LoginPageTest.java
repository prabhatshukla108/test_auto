package com.mypolicynow.tests;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypolicynow.uipages.LandingPage;
import com.mypolicynow.uipages.LoginPage;
import com.mypolicynow.utils.Utilities;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.ReportContext;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

public class LoginPageTest extends AbstractTest {

	Utilities util = new Utilities();

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0001",enabled = true)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password")

	public void Verify_user_able_to_get_login_validation_message(String TUID,String username, String password) {
		// Open home page and verify page is opened,
		ReportContext.setCustomTestDirName(TUID);
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		boolean bool = lp.verifyLoginvalidationsmsg();
		Assert.assertTrue(bool, "Validation msg not present for Login!");
	}
	
	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0002",enabled=true)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password")

	public void Verify_user_able_to_login_with_valid_Login_Credencials_having_all_elements (String TUID,String username, String password) {
		// Open home page and verify page is opened,
		ReportContext.setCustomTestDirName(TUID);
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		String lptitle =lp.testLogin(username, password);
		util.assertBoolean(lptitle);
	}
	
	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0003",enabled=true)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password")
	public void Verify_user_able_to_see_the_five_tabs_on_Homepage_after_login(String TUID,String username, String password) throws InterruptedException {
		// Open home page and verify page is opened,
		ReportContext.setCustomTestDirName(TUID);
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		String lptitle =lp.testLogin(username, password);
		util.assertBoolean(lptitle);
	
		LandingPage land = lp.getLandingDriver();

		String s = land.verifyLandingpageElements();
		util.assertBoolean(s);
	
	}

}
