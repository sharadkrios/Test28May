package com.ciranet.corporatecirabooks.accountsreceivable.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.corporatecirabooks.accountsreceivable.pages.NewARPaymentPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class NewARPaymentPageTest extends TestBase
{
	// Create the NewARPaymentPage object
	NewARPaymentPage newARPaymentPage = createPage(NewARPaymentPage.class);

	@Test(priority = 0, description = "Verify New AR Payment navigation", groups = { Constants.SMOKE_TESTING },alwaysRun = true)
	public void verifyNewARPaymentNavigation()
	{
		LoggerManager.info("Verifying New AR Payment navigation");
		TestBase.setExtentReportSettings("New AR Payment navigation Test", Constants.SMOKE_TESTING, "Verify New AR Payment navigation", "Verifying New AR Payment navigation");
		newARPaymentPage = new NewARPaymentPage(driver);
		// Assert that navigation succeeded
		assertTrue(newARPaymentPage.navigate(),"Error navigating to New AR Payment Page.");
	} 
	
	@Test(priority = 1, description = "Verify New AR Payment Page entry", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyNewARPaymentEntry() 
	{
		LoggerManager.info("Verifying the addition of New AR Payment");
		TestBase.setExtentReportSettings("Add New AR Payment Test", Constants.FUNCTIONAL_TESTING, "Verify adding New AR Payment", "Verifying the addition of New AR Payment");
		newARPaymentPage = new NewARPaymentPage(driver);
		assertTrue(newARPaymentPage.addNewARPayment(), "Error while adding a New AR Payment");
	}
}