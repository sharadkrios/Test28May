package com.ciranet.cirabooks.accountspayable.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.cirabooks.accountspayable.pages.APExpenseDetailPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class APExpenseDetailPageTest extends TestBase {
	
	// Create the APExpenseDetailPage object
	APExpenseDetailPage apExpenseDetailPage = createPage(APExpenseDetailPage.class);

	@Test(priority = 0, description = "Verify AP Expense Detail navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyAPExpenseDetailNavigation() throws Exception {
		LoggerManager.info("Verifying AP Expense Details navigation");
		TestBase.setExtentReportSettings("AP Expense Detail navigation", Constants.SMOKE_TESTING,
				"Verify AP Expense Detail", "Verifying AP Expense Detail navigation");
		apExpenseDetailPage = new APExpenseDetailPage(driver);
		String communitySearch = "Amberwood";
		assertTrue(apExpenseDetailPage.navigate(communitySearch), "Error navigated to AP Expense Detail");
	}

	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolBarFullScreen() {
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen Icon", Constants.FUNCTIONAL_TESTING,
				"Verify Fullscreen icon", "Verifying Fullscreen icon");
		apExpenseDetailPage = new APExpenseDetailPage(driver);
		assertTrue(apExpenseDetailPage.toolBarFullScreen(), "Error while Fullscreen icon is not clicked");
	}


	@Test(priority = 2, description = "Verify Workflow Details", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyReclassifyButton() {
		LoggerManager.info("Verifying Workflow Details");
		TestBase.setExtentReportSettings("Workflow Details", Constants.FUNCTIONAL_TESTING,
				"Verify Workflow Details", "Verifying Workflow Details");
		apExpenseDetailPage = new APExpenseDetailPage(driver);
		assertEquals(apExpenseDetailPage.reclassifyButton(), "AAP Workflow Job Details");
	}
}
