package com.mypolicynow.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypolicynow.uipages.GetQuotePage;
import com.mypolicynow.uipages.LandingPage;
import com.mypolicynow.uipages.LoginPage;
import com.mypolicynow.utils.Utilities;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.ReportContext;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

public class GetQuotePageTest extends AbstractTest {

	Utilities util = new Utilities();

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0004", enabled = true)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password")
	public void Verify_user_able_to_see_the_validation_messages_on_car_page_for_mandatory_fields(String TUID,
			String username, String password) throws InterruptedException {
		// Open home page and verify page is opened,
		ReportContext.setCustomTestDirName(TUID);
		try {
			LoginPage lp = new LoginPage(getDriver());
			lp.open();
			Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
			lp.testLogin(username, password);
			LandingPage ld = lp.getLandingDriver();
			GetQuotePage gqp = ld.getGQPdriver();
			String s = gqp.verifyGQPMessage();
			util.assertBoolean(s);
		} catch (Exception e) {
			Assert.fail(
					"Failed in the " + e.getClass() + "|" + e.getCause() + "|" + e.getStackTrace()[0].getMethodName());

		}
	}

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0005", enabled = false)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password")
	public void testPlaceholder(String TUID, String username, String password) throws InterruptedException {
		// Open home page and verify page is opened,
		ReportContext.setCustomTestDirName(TUID);
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		lp.testLogin(username, password);
		LandingPage ld = lp.getLandingDriver();
		GetQuotePage gqp = ld.getGQPdriver();
		String s = gqp.validatePlaceholder();
		util.assertBoolean(s);

	}

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0006", enabled = false)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password,rto,make,model,variant,man_year,man_month,purchaseDate,polHoldertype,ODdiscount,InvoicePrice,chkODTP,chkStandaloneODTP,chkValidLicence,chkanotherMotorInsPol,chkPAPolicy15,chkPACover")
	public void Verify_user_able_to_enter_all_the_fields_with_Multiple_Data_Sets_and_reach_Quotation_page_New_Comprehensive(
			String TUID, String username, String password, String rto, String make, String model, String variant,
			String man_year, String man_month, String purchaseDate, String polHoldertype, String ODdiscount,
			String InvoicePrice, String chkODTP, String chkStandaloneODTP, String chkValidLicence,
			String chkanotherMotorInsPol, String chkPAPolicy15, String chkPACover) throws InterruptedException {
		// Open home page and verify page is opened,
		ReportContext.setCustomTestDirName(TUID);
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		lp.testLogin(username, password);
		LandingPage ld = lp.getLandingDriver();
		GetQuotePage gqp = ld.getGQPdriver();
		gqp.testGetQuotepageNewComprehensive(rto, make, model, variant, man_year, man_month, purchaseDate,
				polHoldertype, ODdiscount, InvoicePrice, chkODTP, chkStandaloneODTP, chkValidLicence,
				chkanotherMotorInsPol, chkPAPolicy15, chkPACover);
	}

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0007", enabled = false)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password")
	public void Verify_if_Car_tab_get_opened_along_with_all_fileds(String TUID, String username, String password)
			throws InterruptedException {
		// Open home page and verify page is opened,
		ReportContext.setCustomTestDirName(TUID);
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		lp.testLogin(username, password);
		LandingPage ld = lp.getLandingDriver();
		GetQuotePage gqp = ld.getGQPdriver();
		gqp.clickBtnCar();
		String s = gqp.verifyGetQUotepageFieldsonClickingCar();
		util.assertBoolean(s);

	}
}
