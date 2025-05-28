package com.ciranet.community.information.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.community.information.pages.InsurancePage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class InsurancePageTest extends TestBase {

	InsurancePage insurancePage = createPage(InsurancePage.class);

	@Parameters("communitySearchText")
	@Test(priority = 0, description = "Verify Insurance navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyInsuranceNavigation(String communitySearchText) {
		LoggerManager.info("Verifying Insurance navigation");
		TestBase.setExtentReportSettings("Insurance", Constants.SMOKE_TESTING, "Verify Insurance",
				"Verifying Insurance navigation");
		insurancePage = new InsurancePage(driver);
		insurancePage.setCommunitySearchTextFromParameter(communitySearchText);
		assertTrue(insurancePage.navigateToInsurance(communitySearchText), "Error navigating to Insurance");
	}

	@Test(priority = 1, description = "Verify Show All records", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyShowAllRecord() {
		LoggerManager.info("Verifying Show All records");
		TestBase.setExtentReportSettings("Show All", Constants.FUNCTIONAL_TESTING, "Verify Show All records",
				"Verifying Show All records");
		insurancePage = new InsurancePage(driver);
		assertEquals(insurancePage.showAllRecords(), "Show All");
	}

	@Test(priority = 2, description = "Verify Add Task", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAddTask() {
		LoggerManager.info("Verifying Add Task");
		TestBase.setExtentReportSettings("Add Task", Constants.FUNCTIONAL_TESTING, "Verify Add Task",
				"Verifying Add Task");
		insurancePage = new InsurancePage(driver);
		assertEquals(insurancePage.addTask(), "Add Task");
	}

	@Test(priority = 3, description = "Verify Edit Task", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEditTask() {
		LoggerManager.info("Verifying Edit Task");
		TestBase.setExtentReportSettings("Edit Task", Constants.FUNCTIONAL_TESTING, "Verify Edit Task",
				"Verifying Edit Task");
		insurancePage = new InsurancePage(driver);
		assertTrue(insurancePage.editTask(), "An error occurred while editing the Task");
	}

	@Test(priority = 4, description = "Verify Change Status To", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyChangeStatusTo() {
		LoggerManager.info("Verifying Change Status To");
		TestBase.setExtentReportSettings("Change Status To", Constants.FUNCTIONAL_TESTING, "Verify Change Status To",
				"Verifying Change Status To");
		insurancePage = new InsurancePage(driver);
		assertEquals(insurancePage.changeStatusTo(), "Open");
	}

	@Test(priority = 5, description = "Verify Change Assign To", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyChangeAssignTo() {
		LoggerManager.info("Verifying Change Assign To");
		TestBase.setExtentReportSettings("Change Assign To", Constants.FUNCTIONAL_TESTING, "Verify Change Assign To",
				"Verifying Change Assign To");
		insurancePage = new InsurancePage(driver);
		assertTrue(insurancePage.changeAssignTo(), "An error occurred while changing the assignee");
	}

	@Test(priority = 6, description = "Verify Delete Task", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyDeleteTask() {
		LoggerManager.info("Verifying Delete Task");
		TestBase.setExtentReportSettings("Delete Task", Constants.FUNCTIONAL_TESTING, "Verify Delete Task",
				"Verifying Delete Task");
		insurancePage = new InsurancePage(driver);
		assertTrue(insurancePage.deleteTask(), "An error occurred while canceling the task deletion");
	}

	@Test(priority = 7, description = "Verify Completed / Closed Tasks", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCompletedClosedTask() {
		LoggerManager.info("Verifying Completed / Closed Tasks");
		TestBase.setExtentReportSettings("Completed / Closed Tasks", Constants.FUNCTIONAL_TESTING,
				"Verify Completed / Closed Tasks", "Verifying Completed / Closed Tasks");
		insurancePage = new InsurancePage(driver);
		assertTrue(insurancePage.isCompletedClosedTaskDisplay(),
				"An error occurred while displaying the Completed / Closed Tasks in 180 days ");
	}
}
