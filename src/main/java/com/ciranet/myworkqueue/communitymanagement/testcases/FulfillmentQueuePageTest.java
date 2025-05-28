package com.ciranet.myworkqueue.communitymanagement.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.communitymanagement.pages.FulfillmentQueuePage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class FulfillmentQueuePageTest extends TestBase {
	// Create the FulfillmentQueuePage object
	FulfillmentQueuePage fulfillmentQueuePage = createPage(FulfillmentQueuePage.class);

	@Test(priority = 0, description = "Verify Fulfillment Queue Navigation Test", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyFulfillmentQueuePageNavigation() {
		LoggerManager.info("Verifying Fulfillment Queue Page Navigation");
		TestBase.setExtentReportSettings("Verifying Fullfillment Queue Navigation Test", Constants.SMOKE_TESTING,
				"Verify Fullfillment Queue navigation", "Verifying Fullfillment Queue navigation");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.navigate(), "Error while navigating to Fulfillment Queue Page");
	}

	@Test(priority = 1, description = "Verify Toolbar - Full screen option click", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolbarFullScreenOption() {
		LoggerManager.info("Verify Toolbar - Full screen icon click");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		TestBase.setExtentReportSettings("Toolbar - Full screen", Constants.FUNCTIONAL_TESTING, "Toolbar Full screen",
				"Verifying Toolbar Full screen icon click");
		assertTrue(fulfillmentQueuePage.toolBarFullScreen(), "Error to get Full Screen toolbar");
	}

	@Test(priority = 2, description = "Verify Toolbar - Normal screen option click", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolbarNormalScreenOption() {
		LoggerManager.info("Verify Toolbar - Normal screen icon click");
		TestBase.setExtentReportSettings("Toolbar - Normal screen", Constants.FUNCTIONAL_TESTING,
				"Toolbar Normal screen", "Verifying Toolbar Normal screen icon click");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.toolBarNormalScreen(), "Error to get Normal Screen");
	}

	@Test(priority = 3, description = "Verify Toolbar Expand icon click", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyExpandOption() {
		LoggerManager.info("Verify Toolbar Expand icon");
		TestBase.setExtentReportSettings("Verify Toolbar Expand icon", Constants.FUNCTIONAL_TESTING,
				"Toolbar Expand icon", "Verifying Toolbar Expand and Collapse functionaity");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.expandCollapseOptionsClick(),
				"Error occured while Expand and Collapse functionality");
	}

	@Test(priority = 4, description = "Verify Toolbar - Column Chooser icon click", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyColumnChooserOption() {
		LoggerManager.info("Verify Column Chooser icon");
		TestBase.setExtentReportSettings("Verify Column Chooser icon test", Constants.FUNCTIONAL_TESTING,
				"Verify Column Chooser icon click", "Verifying Column Chooser icon");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.columnChooserClick(), "Error to select Column Chooser");
	}

	@Test(priority = 5, description = "Verify tab Switching", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySwitchtab() {
		LoggerManager.info("Verify tab Switching");
		TestBase.setExtentReportSettings("Switching tab test", Constants.FUNCTIONAL_TESTING, "Verify tab switching",
				"Verifying tab Switching");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.switchTab(), "Error while Tab switching");
	}

	@Test(priority = 6, description = "Verify Edit and Save the entry", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEditAndSave() {
		LoggerManager.info("Verify Action Button save");
		TestBase.setExtentReportSettings("Edit and Save test", Constants.FUNCTIONAL_TESTING, "Verify Action Edit and Save",
				"Verifying Action Edit and Save");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.saveButtonClick(), "Error while editing and clicking on Save button");
	}

	@Test(priority = 7, description = "Verify that View Edit Action close button", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEditAndClose() {
		LoggerManager.info("Verify that View Edit Action close button");
		TestBase.setExtentReportSettings("View Edit Action close button", Constants.FUNCTIONAL_TESTING,
				"View Edit Action close button", "Verifying View Edit Action close button");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.verifyActionCloseButton(), "Error while Edit and Close functionality");
	}

	@Test(priority = 8, description = "Verify Refresh Queue", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyrefreshQueuebutton() {
		LoggerManager.info("Verify Refresh Queue");
		TestBase.setExtentReportSettings("Refresh Queue", Constants.FUNCTIONAL_TESTING, "Refresh Queue",
				"Verifying Refresh Queue");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.refreshQueueButton(), "Error while clicking on the refresh Queue button");
	}
	
	@Test(priority = 9, description = "Verify Documents tab", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyActionDocumentTabClick() {
		LoggerManager.info("Verify Documents tab");
		TestBase.setExtentReportSettings("Documents tab", Constants.FUNCTIONAL_TESTING, "Documents tab",
				"Verifying Documents tab");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.actionDocumentTabClick(), "Error to click on Action Document tab");
	}

	@Test(priority = 10, description = "Verify Action completion Job tab", groups = {Constants.FUNCTIONAL_TESTING })
	public void verifyAddonNotesCompletiontTabClick() {
		LoggerManager.info("Verify Action completion Job tab");
		TestBase.setExtentReportSettings("Action completion Job tab", Constants.FUNCTIONAL_TESTING,
				"Action completion Job tab", "Verifying Action completion Job tab");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.addNotesOnCompletionJobTab(), "Error to click on Action Completion tab");
	}
	
	@Test(priority = 11, description = "Verify Add Job save and close", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyAddJobSaveAndCloseButton() {
		LoggerManager.info("Verify Add Job save and close");
		TestBase.setExtentReportSettings("Add Job save and close", Constants.FUNCTIONAL_TESTING,
				"Add Job save and close", "Verifying Add Job save and close");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.addJobSaveAndCloseButton(), "Error to add Job, Save And Close button");
	}
	
	@Test(priority = 12, description = "Verify Add Completion Job tab", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyAddCompletionJobtab() {
		LoggerManager.info("Verify Add Completion Job tab");
		TestBase.setExtentReportSettings("Add Completion Job tab", Constants.FUNCTIONAL_TESTING,
				"Add Completion Job tab", "Verifying Add Completion Job tab");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.addCompletionJobAddItemTab(), "Error while adding Completion Job and Add item");
	}

	@Test(priority = 13, description = "Verify Closed Jobs Search Button", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyClosedJobsSearchButton() {
		LoggerManager.info("Verify Closed Jobs Search Button");
		TestBase.setExtentReportSettings("Closed Jobs Search", Constants.FUNCTIONAL_TESTING,
				"Closed Jobs Search Button", "Verifying Closed Jobs Search Button");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.closedJobsSearchButton(), "Error is seen to search Closed Jobs ");
	}

	@Test(priority = 14, description = "Verify Add Completed Job Save & Add Documents button click", groups = {
			Constants.FUNCTIONAL_TESTING })
	public void verifyAddCompletedJobbuttonSaveandAddDocuments() {
		LoggerManager.info("Verify Add Completed Job Save & Add Documents button click");
		TestBase.setExtentReportSettings("Add Completed Job Save and Add Documents", Constants.FUNCTIONAL_TESTING,
				"Add Completed Job Save & Add Documents button click",
				"Verifying Add Completed Job Save & Add Documents button click");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.addCompletedJobbuttonSaveandAddDocuments(), "Error while adding Completed Job document and save document");
	}
	
	@Test(priority = 15, description = "Verify Add Completed Job Close button click", groups = {
			Constants.FUNCTIONAL_TESTING })
	public void verifyAddCompletedJobbuttonclick() {
		LoggerManager.info("Verify Add Completed Job Close button click");
		TestBase.setExtentReportSettings("Add Completed Job Close button click", Constants.FUNCTIONAL_TESTING,
				"Add Completed Job Close", "Verifying Add Completed Job Close button click");
		fulfillmentQueuePage = new FulfillmentQueuePage(driver);
		assertTrue(fulfillmentQueuePage.addCompletedJobAndCloseButtonClick(), "Error to add the Completed Job and click on Close button");
	}
	
}
