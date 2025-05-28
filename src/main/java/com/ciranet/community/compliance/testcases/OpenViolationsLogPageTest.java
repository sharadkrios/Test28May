package com.ciranet.community.compliance.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.community.compliance.pages.OpenViolationsLogPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class OpenViolationsLogPageTest extends TestBase {
	// Create the OpenViolationsLogPage object
	OpenViolationsLogPage openViolationsLogPage = createPage(OpenViolationsLogPage.class);

	@Test(priority = 0, description = "Verify Open Violations Log navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyOpenViolationsLogNavigation() throws Exception {
		LoggerManager.info("Verifying Open Violations Log navigation");
		TestBase.setExtentReportSettings("Open Violations Log", Constants.SMOKE_TESTING,
				"Verify Open Violations Log", "Verifying Open Violations Log navigation");
		openViolationsLogPage = new OpenViolationsLogPage(driver);
		String communitySearch = "Waterford";
		assertTrue(openViolationsLogPage.navigate(communitySearch), "Error navigating to Open Violations Log");
	}

	@Test(priority = 1, description = "Verify Log Details", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLogDetails() {
		LoggerManager.info("Verifying Log Detail");
		TestBase.setExtentReportSettings("Log Detail", Constants.FUNCTIONAL_TESTING,
				"Verify Log Detail", "Verifying Log Detail");
		assertEquals(openViolationsLogPage.logDetails(), "Open Violations Log Detail");
	}

	@Test(priority = 2, description = "Verify Violation History", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViolationHistory() {
		LoggerManager.info("Verifying Violation History");
		TestBase.setExtentReportSettings("Violation History", Constants.FUNCTIONAL_TESTING,
				"Verify Violation History", "Verifying Violation History");
		assertTrue(openViolationsLogPage.violationHistory(), "Error while Violation History");
	}

	@Test(priority = 3, description = "Verify Violation History Images", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyHistoryImage() {
		LoggerManager.info("Verifying Violation History Images");
		TestBase.setExtentReportSettings("Violation History Images", Constants.FUNCTIONAL_TESTING,
				"Verify Violation History Images", "Verifying Violation History Images");
		assertTrue(openViolationsLogPage.historyImage(), "Error while Violation History Images");
	}

	@Test(priority = 4, description = "Verify popup Close buttons", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCloseButtons() {
		LoggerManager.info("Verifying popup Close buttons");
		TestBase.setExtentReportSettings("Popup Close buttons", Constants.FUNCTIONAL_TESTING,
				"Verify popup Close buttons", "Verifying popup Close buttons");
		assertTrue(openViolationsLogPage.closeButtons(), "Error while popup Close buttons");
	}
}
