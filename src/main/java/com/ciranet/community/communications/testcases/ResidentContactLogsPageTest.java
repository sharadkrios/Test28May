package com.ciranet.community.communications.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.community.communications.pages.ResidentContactLogsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ResidentContactLogsPageTest extends TestBase {
	ResidentContactLogsPage residentContactLogsPage = createPage(ResidentContactLogsPage.class);

	@Test(priority = 0, description = "Verify Resident Contact Logs navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	@Parameters("communitySearchText")
	public void verifyResidentContactLogsNavigation(String communitySearchText) {
		LoggerManager.info("Verifying Resident Contact Logs navigation");
		TestBase.setExtentReportSettings("Resident Contact Logs navigation", Constants.SMOKE_TESTING,
				"Verify Resident Contact Logs", "Verifying Resident Contact Logs navigation");
		residentContactLogsPage = new ResidentContactLogsPage(driver);
		assertTrue(residentContactLogsPage.navigateToResidentContactLogs(communitySearchText),
				"Error navigating to Resident Contact Logs page.");
	}

	@Test(priority = 1, description = "Verify Resident Contact Logs Historical Hyperlink", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void testResidentContactLogsHistoricalHyperlink() {
		LoggerManager.info("Starting test: Verify Resident Contact Logs Historical Hyperlink");
		TestBase.setExtentReportSettings("Resident Contact Logs - Historical Hyperlink", Constants.FUNCTIONAL_TESTING,
				" Verify Resident Contact Logs Historical Hyperlink",
				"Verifying Resident Contact Logs Historical Hyperlink");
		residentContactLogsPage = new ResidentContactLogsPage(driver);
		assertTrue(residentContactLogsPage.verifyResidentContactLogsHistoricalHyperlink(),
				"Error 'Resident Contact Log Detail Historical' hyperlink is not visible");
	}
}

