package com.ciranet.myworkqueue.communitymanagement.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.communitymanagement.pages.ViolationReviewPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ViolationReviewPageTest extends TestBase {

	// Create the ViolationReviewPage object
	ViolationReviewPage violationReviewPage = createPage(ViolationReviewPage.class);

	@Test(priority = 0, description = "Verify Violation Review navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyViolationReviewNavigation() {
		LoggerManager.info("Verifying Violation Review navigation");
		TestBase.setExtentReportSettings("Violation Review", Constants.SMOKE_TESTING, "Verify Violation Review",
				"Verifying Violation Review navigation");
		violationReviewPage = new ViolationReviewPage(driver);
		assertTrue(violationReviewPage.navigate(), "Error navigating to Violation Review");
	}

	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyFullScreenIcon() {
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon",
				"Verifying Fullscreen icon");
		violationReviewPage = new ViolationReviewPage(driver);
		assertTrue(violationReviewPage.toolBarFullScreen(), "Error while Fullscreen icon is not clickable");
	}

	@Test(priority = 2, description = "Verify Violation Inspection History", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViolationInspectionHistory() throws Exception {
		LoggerManager.info("Verifying Violation Inspection History");
		TestBase.setExtentReportSettings("Violation Inspection History", Constants.FUNCTIONAL_TESTING,
				"Verify Violation Inspection History", "Verifying Violation Inspection History");
		violationReviewPage = new ViolationReviewPage(driver);
		assertEquals(violationReviewPage.violationInspectionHistory(), "Violation Inspection History");
	}
		
}
