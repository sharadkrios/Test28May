package com.ciranet.myworkqueue.communitymanagement.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.communitymanagement.pages.MaintenanceWorkOrdersPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class MaintenanceWorkOrdersPageTest extends TestBase {

	// Create the MaintenanceWorkOrdersPage object
	MaintenanceWorkOrdersPage workOrdersPage = createPage(MaintenanceWorkOrdersPage.class);

	@Test(priority = 0, description = "Verify Maintenance Work Orders navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)

	public void verifyMaintenanceWorkOrdersNavigation() {
		LoggerManager.info("Verifying Maintenance Work Orders navigation");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		TestBase.setExtentReportSettings("Maintenance Work Orders", Constants.SMOKE_TESTING,"Verify Maintenance Work Orders", "Verifying Maintenance Work Orders navigation");
		assertTrue(workOrdersPage.navigate(), "Error navigate to Maintenance Work Orders");
	}
	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolbarFullScreenIcon() {
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon","Verifying Fullscreen icon");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.toolBarFullScreen(), "Error: unable to  click on Fullscreen icon ");
	}	
	
	@Test(priority = 2, description = "Verify Column Chooser icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyColumnChooser() {
		LoggerManager.info("Verifying Column Chooser icon");
		TestBase.setExtentReportSettings("Column Chooser icon", Constants.FUNCTIONAL_TESTING,"Verify Column Chooser icon", "Verifying Column Chooser icon");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertEquals(workOrdersPage.columnChooser(), "Column Chooser");
	}

	@Test(priority = 3, description = "Verify Add New Work Order", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAddNewWorkOrder() {
		LoggerManager.info("Verifying Add New Work Order");
		TestBase.setExtentReportSettings("Add New Work Order", Constants.FUNCTIONAL_TESTING,"Verify Add New Work Order", "Verifying Add New Work Order");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.addNewWorkOrder(), "Error occurred while adding the work order.");
	}
	
	@Test(priority = 4, description = "Verify Manage Work Authorization", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyManageWorkAuthorization() {
		LoggerManager.info("Verifying Manage Work Authorization");
		TestBase.setExtentReportSettings("Manage Work Authorization", Constants.FUNCTIONAL_TESTING,"Verify Manage Work Authorization", "Verifying Manage Work Authorization");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.manageWorkAuthorization(), "Error occurred while Managing Work Authorization");
	}
		
	@Test(priority = 5, description = "Verify Manage Task References", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyManageTaskReferences() {
		LoggerManager.info("Verifying Manage Task References");
		TestBase.setExtentReportSettings("Manage Task References", Constants.FUNCTIONAL_TESTING,"Verify Manage Task References", "Verifying Manage Task References");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.manageTaskReferences(), "Error occurred while Managing the Task References");
	}
	
	@Test(priority = 6, description = "Verify Manage Praposal", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyManageProposal() {
		LoggerManager.info("Verifying Manage Praposal");
		TestBase.setExtentReportSettings("Manage Praposal", Constants.FUNCTIONAL_TESTING,"Verify Manage Praposal", "Verifying Manage Praposal");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.manageProposal(), "Error occurred while Manage the Praposal");
	}

	@Test(priority = 7, description = "Verify View/Edit Work Order", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViewEditWorkOrder() {
		LoggerManager.info("Verifying View/Edit Work Order");
		TestBase.setExtentReportSettings("View/Edit Work Order", Constants.FUNCTIONAL_TESTING,"Verify View/Edit Work Order", "Verifying View/Edit Work Order");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.saveViewEditWorkOrder(), "Error: Unable to save the edited Work Order.");
	}
	
	@Test(priority = 8, description = "Verify the Add Work Orders and Close", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifycloseWorkOrder() {
		LoggerManager.info("Verifying that Add Work Orders and Close");
		TestBase.setExtentReportSettings("Add Work Orders and Close", Constants.FUNCTIONAL_TESTING,"Verify Add Work Orders and Close", "Verifying Add Work Orders and Close");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.closeAddWorkOrder(), "Error occurred while Closing the Work Orders");
	}
	@Test(priority = 9, description = "Verify the View Edit Work Order and Close", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViewEditCloseWorkOrderClick() {
		LoggerManager.info("Verifying the View Edit Work Order and Close");
		TestBase.setExtentReportSettings("View Edit Work Order and Close", Constants.FUNCTIONAL_TESTING,"Verify View Edit Work Order and Close", "Verifying that View Edit Work Order and Close");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.closeViewEditWorkOrder(), "Error occurred while Closing the Edited Work Order");
	}
	@Test(priority = 10, description = "Verify the View Edit Work Order and Save", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViewEditSaveWorkOrderClick() {
		LoggerManager.info("Verifying the View Edit Work Order and Save");
		TestBase.setExtentReportSettings("View Edit Work Order and Save", Constants.FUNCTIONAL_TESTING,"Verify View Edit Work Order and Save", "Verifying that View Edit Work Order and Save");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.viewEditCloseWorkOrder(), "Error occurred while Saving the Edited Work Order");
	}

	@Test(priority = 11, description = "Verify the Chanage Status", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifychangeStatus() {
		LoggerManager.info("Verifying Change Status");
		TestBase.setExtentReportSettings("Change Status", Constants.FUNCTIONAL_TESTING,"Verify Change Status", "Verifying Change Status");		
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.changeStatus(), "Error occurred while changing the Status");
	}
	
	@Test(priority = 12, description = "Verify tab Switching", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySwitchtab() {
		LoggerManager.info("Verifying tab Switching");
		TestBase.setExtentReportSettings("Tab Switching", Constants.FUNCTIONAL_TESTING, "Verify Tab Switching","Verifying Tab switching");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertEquals(workOrdersPage.switchTab(), "Closed Work Orders");
	}

	@Test(priority = 13, description = "Verify Closed Work Orders", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyClosedDaysTextbox() {
		LoggerManager.info("Verifying Closed Work Orders");
		TestBase.setExtentReportSettings("Closed Work Orders", Constants.FUNCTIONAL_TESTING,"Verify Closed Work Orders", "Verifying Closed Work Orders");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.closedDaysTextbox(), "Error occurred while displaying Closed Worked Orders");

	}
	@Test(priority = 14, description = "Verify Expand icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyExpandOption() {
		LoggerManager.info("Verifying Expand icon");
		TestBase.setExtentReportSettings("Expand icon", Constants.FUNCTIONAL_TESTING,"Verify Expand icon", "Verifying Expand icon");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.expandOptionIcon(), "Error: unable to click on Expand icon");
	}
	@Test(priority = 15, description = "Verify Collapse icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCollapseOption() {
		LoggerManager.info("Verifying Collapse icon");
		TestBase.setExtentReportSettings("Collapse icon", Constants.FUNCTIONAL_TESTING,"Verify Collapse icon", "Verifying Collapse icon");
		workOrdersPage = new MaintenanceWorkOrdersPage(driver);
		assertTrue(workOrdersPage.collapseOptionIcon(), "Error: unable to click on Collapsed icon");
	}
	
}
