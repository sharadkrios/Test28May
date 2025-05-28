package com.ciranet.community.compliance.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.community.compliance.pages.LastInspectionLogPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class LastInspectionLogPageTest extends TestBase {
	// Create the LastInspectionLogPage object
	LastInspectionLogPage lastInspectionLogPage = createPage(LastInspectionLogPage.class);

	@Test(priority = 0, description = "Verify Last Inspection Log navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyLastInspectionLogNavigation() throws Exception {
		LoggerManager.info("Verifying Last Inspection Log navigation");
		TestBase.setExtentReportSettings("Last Inspection Log navigation", Constants.SMOKE_TESTING,
				"Verify Last Inspection Log", "Verifying Last Inspection Log navigation");
		lastInspectionLogPage = new LastInspectionLogPage(driver);
		String communitySearch = "Herff Ranch";
		assertTrue(lastInspectionLogPage.navigate(communitySearch), "Error navigating to Last Inspection Log");
	}

	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolBarFullScreen() {
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING,
				"Verify Fullscreen icon", "Verifying Fullscreen icon");
		lastInspectionLogPage = new LastInspectionLogPage(driver);
		assertTrue(lastInspectionLogPage.toolBarFullScreen(), "Error while Fullscreen icon is not clickable");
	}

	@Test(priority = 2, description = "Verify Last Inspection Results Detail", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLastInspectionResultsDetails() {
		LoggerManager.info("Verifying Last Inspection Results Detail");
		TestBase.setExtentReportSettings("Last Inspection Results Detail", Constants.FUNCTIONAL_TESTING,
				"Verify Last Inspection Results Detail", "Verifying Last Inspection Results Detail");
		lastInspectionLogPage = new LastInspectionLogPage(driver);
		assertEquals(lastInspectionLogPage.logDetails(),
				"Last Inspection Results Detail: Landscaping / Previous Inspection");
	}

	@Test(priority = 3, description = "Verify Violation History", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViolationHistory() {
		LoggerManager.info("Verifying Violation History");
		TestBase.setExtentReportSettings("Violation History", Constants.FUNCTIONAL_TESTING,
				"Verify Violation History", "Verifying Violation History");
		lastInspectionLogPage = new LastInspectionLogPage(driver);
		assertEquals(lastInspectionLogPage.violationHistory(), "Violation History");
	}

	@Test(priority = 4, description = "Verify Violation History Images", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyHistoryImage() {
		LoggerManager.info("Verifying Violation History Images");
		TestBase.setExtentReportSettings("Violation History Images", Constants.FUNCTIONAL_TESTING,
				"Verify Violation History Images", "Verifying Violation History Images");
		lastInspectionLogPage = new LastInspectionLogPage(driver);
		assertEquals(lastInspectionLogPage.historyImage(), "Violation History Images");
	}

	@Test(priority = 5, description = "Verify Last Inspection Log", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCloseButtons() {
		LoggerManager.info("Verifying Last Inspection Log");
		TestBase.setExtentReportSettings("Last Inspection Log", Constants.FUNCTIONAL_TESTING,
				"Verify Last Inspection Log", "Verifying  Last Inspection Log");
		lastInspectionLogPage = new LastInspectionLogPage(driver);
		assertEquals(lastInspectionLogPage.closeButtons(), "Last Inspection Log");
	}
}

