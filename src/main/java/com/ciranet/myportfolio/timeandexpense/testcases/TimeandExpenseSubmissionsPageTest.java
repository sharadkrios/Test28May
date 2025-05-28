package com.ciranet.myportfolio.timeandexpense.testcases;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myportfolio.timeandexpense.pages.TimeandExpenseSubmissionsPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class TimeandExpenseSubmissionsPageTest extends TestBase 
{
	// Create the TimeandExpenseSubmissionsPage object
	TimeandExpenseSubmissionsPage timeandExpenseSubmissionsPage = createPage(TimeandExpenseSubmissionsPage.class);
	
	@Test(priority = 0, description = "Verify Time & Expense Submissions navigation", groups = {Constants.SMOKE_TESTING}, alwaysRun=true)
	public void verifyTimeandExpenseSubmissionsNavigation() throws Exception
	{
		LoggerManager.info("Verifying Time & Expense Submissions navigation");
		TestBase.setExtentReportSettings("Time & Expense Submissions", Constants.SMOKE_TESTING, "Verify Time & Expense Submissions", "Verifying Time & Expense Submissions navigation");
		timeandExpenseSubmissionsPage = new TimeandExpenseSubmissionsPage(driver);
		assertTrue(timeandExpenseSubmissionsPage.navigate(),"Error navigating to Time & Expense Submissions");
	}
	
	@Test(priority = 1,description = "Verify Entity selection", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyEntitySelection() 
	{	
		LoggerManager.info("Verifying Entity selection");
		TestBase.setExtentReportSettings("Entity", Constants.FUNCTIONAL_TESTING, "Verify Entity", "Verifying Entity");
		timeandExpenseSubmissionsPage = new TimeandExpenseSubmissionsPage(driver);
		assertEquals(timeandExpenseSubmissionsPage.entity(),"Action");
	}
	
	@Test(priority = 2, description = "Verify Fullscreen icon", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true) 
	public void verifyToolbarFullScreen() 
	{
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon", "Verifying Fullscreen icon");
		timeandExpenseSubmissionsPage = new TimeandExpenseSubmissionsPage(driver);
		assertTrue(timeandExpenseSubmissionsPage.toolBarFullScreen(), "Error while Fullscreen icon is not clickable");
	}
	
	@Test(priority = 3, description = "Verify General Expenses", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true) 
	public void verifyGeneralExpense() 
	{
		LoggerManager.info("Verifying General Expenses");
		TestBase.setExtentReportSettings("General Expenses", Constants.FUNCTIONAL_TESTING, "Verify General Expenses", "Verifying General Expenses");
		timeandExpenseSubmissionsPage = new TimeandExpenseSubmissionsPage(driver);
		assertEquals(timeandExpenseSubmissionsPage.generalExpense(), "General Expenses");
	}
	
	@Test(priority = 4, description = "Verify Approve", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true) 
	public void verifyApproveMenu() 
	{
		LoggerManager.info("Verifying Approve");
		TestBase.setExtentReportSettings("Approve",Constants.FUNCTIONAL_TESTING, "Verify Approve", "Verifying Approve");
		timeandExpenseSubmissionsPage = new TimeandExpenseSubmissionsPage(driver);
		assertTrue(timeandExpenseSubmissionsPage.approveMenu(), "Error while Approve menu is not clickable");
	}

	@Test(priority = 5, description = "Verify Deny", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true) 
	public void verifyDenyMenu() 
	{
		LoggerManager.info("Verifying Deny");
		TestBase.setExtentReportSettings("Deny", Constants.FUNCTIONAL_TESTING, "Verify Deny", "Verifying Deny");
		timeandExpenseSubmissionsPage = new TimeandExpenseSubmissionsPage(driver);
		assertTrue(timeandExpenseSubmissionsPage.denyMenu(), "Error while Deny menu is not clickable");
	}

	@Test(priority = 6, description = "Verify Biography", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true) 
	public void verifySubmittedByColumn() 
	{
		LoggerManager.info("Verifying Biography");
		TestBase.setExtentReportSettings("Biography", Constants.FUNCTIONAL_TESTING, "Verify Biography", "Verifying Biography");
		timeandExpenseSubmissionsPage = new TimeandExpenseSubmissionsPage(driver);
		assertEquals(timeandExpenseSubmissionsPage.submittedByColumn(), "Experience Summary");
	}
}
