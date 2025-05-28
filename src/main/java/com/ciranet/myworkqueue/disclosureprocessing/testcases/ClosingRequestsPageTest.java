package com.ciranet.myworkqueue.disclosureprocessing.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.disclosureprocessing.pages.ClosingRequestsPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ClosingRequestsPageTest extends TestBase {

	// Create the ClosingRequestsPage object
	ClosingRequestsPage closingRequestsPage = createPage(ClosingRequestsPage.class);

	@Test(priority = 0, description = "Verify Closing Requests navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyClosingRequestNavigation() {

		LoggerManager.info("Verifying Closing Request navigation");
		TestBase.setExtentReportSettings("Closing Request", Constants.SMOKE_TESTING,
				"Verify Closing Request", "Verifying Closing Request navigation");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertTrue(closingRequestsPage.navigate(), "Error navigating to Closing Requests");
	}

	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolBarFullScreen() {
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon",
				"Verifying Fullscreen icon");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertTrue(closingRequestsPage.toolBarFullScreen(), "Error while clicking on Fullscreen icon");
	}

	@Test(priority = 2, description = "Verify Search icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySearchIcon() {
		LoggerManager.info("Verifying Search icon");
		TestBase.setExtentReportSettings("Search icon", Constants.FUNCTIONAL_TESTING, "Verify Search icon",
				"Verifying Search icon");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertTrue(closingRequestsPage.searchButton(), "Error while clicking on the Search icon");
	}

	@Test(priority = 3, description = "Verify Action Transfer to Collection", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyActionTransfertoCollectionsMenu() {
		LoggerManager.info("Verifying Action Transfer to Collection");
		TestBase.setExtentReportSettings("Action Transfer to Collection", Constants.FUNCTIONAL_TESTING,
				"Verify Action Transfer to Collection", "Verifying Action Transfer to Collection");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertEquals(closingRequestsPage.verifyActionTransfertoCollections(), "Collections");

	}

	@Test(priority = 4, description = "Verify Action Transfer to Transition", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyActionTransfertoTransitionMenu() {
		LoggerManager.info("Verifying Action Transfer to Transition");
		TestBase.setExtentReportSettings("Action Transfer to Transition", Constants.FUNCTIONAL_TESTING,
				"Verify Action Transfer to Transition", "Verifying Action Transfer to Transition");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertEquals(closingRequestsPage.verifyActionTransfertoTransition(), "Transition");
	}

	@Test(priority = 5, description = "Verify Assign Property", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyActionAssignPropertyMenu() {
		LoggerManager.info("Verifying Assign Property");
		TestBase.setExtentReportSettings("Assign Property", Constants.FUNCTIONAL_TESTING, "Verify Assign Property",
				"Verifying Assign Property");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertEquals(closingRequestsPage.verifyActionAssignPropertyCancelPopup(), "Resale/SOA Change Request Property");
	}

	@Test(priority = 6, description = "Verify Cancel Request", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyActionCancleRequestMenu() {
		LoggerManager.info("Verifying Cancel Request");
		TestBase.setExtentReportSettings("Cancel Request", Constants.FUNCTIONAL_TESTING, "Verify Cancel Request",
				"Verifying Cancel Request");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertEquals(closingRequestsPage.actionCancelRequest(), "Cancel Reason:");
	}

	@Test(priority = 7, description = "Verify tab switching", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySwitchingTabs() {
		LoggerManager.info("Verifying tab switching");
		TestBase.setExtentReportSettings("Tab Switching", Constants.FUNCTIONAL_TESTING, "Verify tab switching",
				"Verifying tab switching");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertTrue(closingRequestsPage.switchingTabs(), "Error while clicking on Open Request(Auto Fill) tab");
	}

	@Test(priority = 8, description = "Verify Request Type", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyRequestTypeFilter() {
		LoggerManager.info("Verifying Request Type");
		TestBase.setExtentReportSettings("Request Type", Constants.FUNCTIONAL_TESTING, "Verify Request Type",
				"Verifying Request Type");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertEquals(closingRequestsPage.requestTypeFilter(), "Location");
	}

	@Test(priority = 9, description = "Verify Search tab", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySearchTab() {
		LoggerManager.info("Verifying Search tab");
		TestBase.setExtentReportSettings("Search tab", Constants.FUNCTIONAL_TESTING, "Verify Search tab",
				"Verifying Search tab");
		closingRequestsPage = new ClosingRequestsPage(driver);
		assertEquals(closingRequestsPage.searchTab(), "Property Address:");
	}	
}
