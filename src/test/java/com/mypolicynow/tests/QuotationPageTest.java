package com.mypolicynow.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypolicynow.uipages.GetQuotePage;
import com.mypolicynow.uipages.LandingPage;
import com.mypolicynow.uipages.LoginPage;
import com.mypolicynow.uipages.QuotationPage;
import com.mypolicynow.utils.Utilities;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.ReportContext;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

public class QuotationPageTest extends AbstractTest {

	Utilities util = new Utilities();

	
	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0006", enabled = true)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password,rto,make,model,variant,man_year,man_month,purchaseDate,polHoldertype,ODdiscount,InvoicePrice,chkODTP,chkStandaloneODTP,chkValidLicence,chkanotherMotorInsPol,chkPAPolicy15,chkPACover,addElectrical,addNonElectrical,cngLpg")
	public void Verify_user_able_to_enter_all_the_fields_with_Multiple_Data_Sets_and_reach_Quotation_page_New_Comprehensive(
			String TUID, String username, String password, String rto, String make, String model, String variant,
			String man_year, String man_month, String purchaseDate, String polHoldertype, String ODdiscount,
			String InvoicePrice, String chkODTP, String chkStandaloneODTP, String chkValidLicence,
			String chkanotherMotorInsPol, String chkPAPolicy15, String chkPACover,String addElectrical,String addNonElectrical,String cngLpg) throws InterruptedException {
		// Open home page and verify page is opened,
//		try {
		ReportContext.setCustomTestDirName(TUID);
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		lp.testLogin(username, password);
		LandingPage ld = lp.getLandingDriver();
		GetQuotePage gqp = ld.getGQPdriver();
		QuotationPage qp =	gqp.testGetQuotepageNewComprehensive(rto, make, model, variant, man_year, man_month, purchaseDate,
				polHoldertype, ODdiscount, InvoicePrice, chkODTP, chkStandaloneODTP, chkValidLicence,
				chkanotherMotorInsPol, chkPAPolicy15, chkPACover);
		qp.addAcessories(addElectrical, addNonElectrical, cngLpg);
		
//	}catch(Exception e) {
//		Assert.fail(e.getLocalizedMessage());
//	}
		}
	
	@Test(dataProvider = "SingleDataProvider", description = "JIRA#PVTCAR_NEW-0006", enabled = false)
	@MethodOwner(owner = "Prabhat")
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "TUID,username,password,rto,make,model,variant,man_year,man_month,purchaseDate,polHoldertype,ODdiscount,InvoicePrice,chkODTP,chkStandaloneODTP,chkValidLicence,chkanotherMotorInsPol,chkPAPolicy15,chkPACover,addElectrical,addNonElectrical,cngLpg")
	public void Verify_user_able_to_reach_Quotation_page_New_Comprehensive_and_VerifyIDV(
			String TUID, String username, String password, String rto, String make, String model, String variant,
			String man_year, String man_month, String purchaseDate, String polHoldertype, String ODdiscount,
			String InvoicePrice, String chkODTP, String chkStandaloneODTP, String chkValidLicence,
			String chkanotherMotorInsPol, String chkPAPolicy15, String chkPACover,String addElectrical,String addNonElectrical,String cngLpg) throws InterruptedException {
		// Open home page and verify page is opened,
//		try {
		ReportContext.setCustomTestDirName(TUID);
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		lp.testLogin(username, password);
		LandingPage ld = lp.getLandingDriver();
		GetQuotePage gqp = ld.getGQPdriver();
		QuotationPage qp =	gqp.testGetQuotepageNewComprehensive(rto, make, model, variant, man_year, man_month, purchaseDate,
				polHoldertype, ODdiscount, InvoicePrice, chkODTP, chkStandaloneODTP, chkValidLicence,
				chkanotherMotorInsPol, chkPAPolicy15, chkPACover);
		qp.calculateIDV();
		
//	}catch(Exception e) {
//		Assert.fail(e.getLocalizedMessage());
//	}
		}
}
