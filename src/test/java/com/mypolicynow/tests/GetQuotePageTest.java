package com.mypolicynow.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypolicynow.uipages.GetQuotePage;
import com.mypolicynow.uipages.LandingPage;
import com.mypolicynow.uipages.LoginPage;
import com.mypolicynow.utils.Utilities;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;

public class GetQuotePageTest extends AbstractTest {

	Utilities util = new Utilities();

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#AUTO-0001")
	@MethodOwner(owner = "Prabhat")
	@TestPriority(Priority.P1)
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "username,password,rto,make,model,variant,man_year,man_month,purchaseDate,polHoldertype,ODdiscount,InvoicePrice,chkODTP,chkStandaloneODTP,chkValidLicence,chkanotherMotorInsPol,chkPAPolicy15,chkPACover")
	public void testLogin(String username, String password, String rto, String make, String model, String variant,
			String man_year, String man_month, String purchaseDate, String polHoldertype, String ODdiscount,
			String InvoicePrice, String chkODTP, String chkStandaloneODTP, String chkValidLicence,
			String chkanotherMotorInsPol, String chkPAPolicy15, String chkPACover) {
		// Open home page and verify page is opened,
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		boolean bool = lp.verifyLoginvalidationsmsg();
		Assert.assertTrue(bool, "Validation msg not present for Login!");

		String lptitle = lp.testLogin(username, password);

		String[] login = lptitle.split("\\|");
		System.out.println("Title : " + login);
		String landingpage = "My Policy Now";
		Assert.assertTrue(StringUtils.containsIgnoreCase(login[0], landingpage), "Invalid title results!");
		Assert.assertEquals((login[1]), "true");
		Assert.assertEquals((login[2]), "true");
	}

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#AUTO-0003")
	@MethodOwner(owner = "Prabhat")
	@TestPriority(Priority.P3)
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "username,password,rto,make,model,variant,man_year,man_month,purchaseDate,polHoldertype,ODdiscount,InvoicePrice,chkODTP,chkStandaloneODTP,chkValidLicence,chkanotherMotorInsPol,chkPAPolicy15,chkPACover")
	public void testGetQuotepage(String username, String password, String rto, String make, String model,
			String variant, String man_year, String man_month, String purchaseDate, String polHoldertype,
			String ODdiscount, String InvoicePrice, String chkODTP, String chkStandaloneODTP, String chkValidLicence,
			String chkanotherMotorInsPol, String chkPAPolicy15, String chkPACover) throws InterruptedException {
		// Open home page and verify page is opened,
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		lp.login(username, password);
		GetQuotePage gqp = new GetQuotePage(getDriver());
		String s = gqp.verifyGQPMessage();

		util.assertBoolean(s);

		gqp.testGetQuotepage(rto, make, model, variant, man_year, man_month, purchaseDate, polHoldertype, ODdiscount,
				InvoicePrice, chkODTP, chkStandaloneODTP, chkValidLicence, chkanotherMotorInsPol, chkPAPolicy15,
				chkPACover);
	}

	@Test(dataProvider = "SingleDataProvider", description = "JIRA#AUTO-0002")
	@MethodOwner(owner = "Prabhat")
	@TestPriority(Priority.P2)
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "username,password")

	public void testLandingpage(String username, String password) throws InterruptedException {
		// Open home page and verify page is opened,
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		lp.login(username, password);
		LandingPage land = lp.getLandingDriver();
		String s = land.verifyLandingpageElements();
		util.assertBoolean(s);

	}
	
	@Test(dataProvider = "SingleDataProvider", description = "JIRA#AUTO-0002")
	@MethodOwner(owner = "Prabhat")
	@TestPriority(Priority.P2)
	@XlsDataSourceParameters(path = "xls/myPolicynow.xlsx", sheet = "mypolicy", dsUid = "TUID", dsArgs = "username,password")

	public void testPlaceholder(String username, String password) throws InterruptedException {
		// Open home page and verify page is opened,
		LoginPage lp = new LoginPage(getDriver());
		lp.open();
		Assert.assertTrue(lp.isPageOpened(), "Home page is not opened");
		lp.login(username, password);
		boolean s = util.validateElementsbyText(driver, "");
		
		util.assertBoolean(s);

	}

}
