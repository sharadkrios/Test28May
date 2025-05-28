package com.ciranet.community.dashboard.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.community.dashboard.pages.CommunityMetricsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class CommunityMetricsPageTest extends TestBase {

	// Create the CommunityMetricsPage object
	CommunityMetricsPage communityMetricsPage = createPage(CommunityMetricsPage.class);

	@Test(priority = 0, description = "Verify Community Metrics navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCommunityMetricsNavigation() {
		LoggerManager.info("Verifying Community Metrics navigation");
		TestBase.setExtentReportSettings("Community Metrics navigation", Constants.SMOKE_TESTING,
				"Verify Community Metrics", "Verifying Community Metrics navigation");
		communityMetricsPage = new CommunityMetricsPage(driver);
		String communitySearch = "Amberwood";
		assertTrue(communityMetricsPage.navigate(communitySearch), "Error navigating to Community Metrics page");
	}

	@Test(priority = 1, description = "Verify Add Lawsuit", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAddLawsuit() {
		LoggerManager.info("Verifying Add Lawsuit");
		TestBase.setExtentReportSettings("Add Lawsuit", Constants.FUNCTIONAL_TESTING, "Verify Add Lawsuit",
				"Verifying Add Lawsuit");
		communityMetricsPage = new CommunityMetricsPage(driver);
		assertEquals(communityMetricsPage.addLawsuit(), "Add Lawsuit");
	}

	@Test(priority = 2, description = "Verify Edit Lawsuit", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEditLawsuit() {
		LoggerManager.info("Verifying Edit Lawsuit");
		TestBase.setExtentReportSettings("Edit Lawsuit", Constants.FUNCTIONAL_TESTING, "Verify Edit Lawsuit",
				"Verifying Edit the Lawsuit");
		communityMetricsPage = new CommunityMetricsPage(driver);
		assertEquals(communityMetricsPage.editLawsuit(), "Edit Lawsuit");
	}

	@Test(priority = 3, description = "Verify Registered ACH Owners", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyRegisteredACHOwners() {
		LoggerManager.info("Verifying Registered ACH Owners");
		TestBase.setExtentReportSettings("Registered ACH Owners", Constants.FUNCTIONAL_TESTING,
				"Verify Registered ACH Owners", "Verifying Property Owner Details");
		communityMetricsPage = new CommunityMetricsPage(driver);
		assertEquals(communityMetricsPage.registeredACHOwners(), "Property Owner Details");
	}

	@Test(priority = 4, description = "Verify tab switching", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyTabSwitching() {
		LoggerManager.info("Verifying tab switching");
		TestBase.setExtentReportSettings("Tab switching", Constants.FUNCTIONAL_TESTING, "Verify tab switch",
				"Verifying tab Switching");
		communityMetricsPage = new CommunityMetricsPage(driver);
		assertTrue(communityMetricsPage.tabSwitching(), "Error while switching the tab");
	}

	@Test(priority = 5, description = "Verify Work Area", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyWorkArea() {
		LoggerManager.info("Verifying Work Area");
		TestBase.setExtentReportSettings("Work Area", Constants.FUNCTIONAL_TESTING, "Verify Work Area",
				"Verifying Work Area");
		communityMetricsPage = new CommunityMetricsPage(driver);
		assertTrue(communityMetricsPage.workArea(), "Error while accessing Work Area");
	}
}
