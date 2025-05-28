package com.ciranet.myworkqueue.receivableslockbox.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.receivableslockbox.pages.StatementApprovalsPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class StatementApprovalsPageTest extends TestBase {

	// Create the StatementApprovalsPage object
	StatementApprovalsPage statementApprovalsPage = createPage(StatementApprovalsPage.class);

	@Test(priority = 0, description = "Verify Statement Approvals navigation", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyStatementApprovalsNavigation() {
		LoggerManager.info("Verifying Statement Approvals navigation");
		TestBase.setExtentReportSettings("Statement Approvals", Constants.FUNCTIONAL_TESTING,
				"Verify Statement Approvals", "Verifying Statement Approvals navigation");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertTrue(statementApprovalsPage.navigate(), "Error navigate to Statement Approvals");
	}

	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolFullScreen() {
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon",
				"Verifying Fullscreen icon");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertTrue(statementApprovalsPage.toolBarFullScreen(), "Error Fullscreen icon is not clickable");
	}

	@Test(priority = 2, description = "Verify Approve & Print menu", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyApprovePrintMenu() {
		LoggerManager.info("Verifying Approve & Print menu");
		TestBase.setExtentReportSettings("Approve & Print menu", Constants.FUNCTIONAL_TESTING,
				"Verify Approve & Print menu", "Verifying Approve & Print menu");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertTrue(statementApprovalsPage.approvePrintAction(), "Error 'Approve & Print' menu is not clickable");
	}

	@Test(priority = 3, description = "Verify Delete & Reschedule menu", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyDeleteRescheduleMenu() {
		LoggerManager.info("Verifying Delete & Reschedule menu");
		TestBase.setExtentReportSettings("Delete & Reschedule menu", Constants.FUNCTIONAL_TESTING,
				"Verify Delete & Reschedule menu", "Verifying Delete & Reschedule menu");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertEquals(statementApprovalsPage.deleteRescheduleAction(), "Reschedule");
	}

	@Test(priority = 4, description = "Verify Delete Forever menu", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyDeleteForeverMenu() {
		LoggerManager.info("Verifying Delete Forever menu");
		TestBase.setExtentReportSettings("Delete Forever menu", Constants.FUNCTIONAL_TESTING,
				"Verify Delete Forever menu", "Verifying Delete Forever menu");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertEquals(statementApprovalsPage.deleteForeverAction(), "Confirmation");
	}

	@Test(priority = 5, description = "Verify Logs icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLogsColumn() {
		LoggerManager.info("Verifying Logs icon");
		TestBase.setExtentReportSettings("Logs icon", Constants.FUNCTIONAL_TESTING, "Verify Logs icon",
				"Verifying Logs icon");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertTrue(statementApprovalsPage.logsClick(), "Error Logs icon is not clickable");
	}

	@Test(priority = 6, description = "Verify Statement PDF", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyStatementColumn() {
		LoggerManager.info("Verifying Statement PDF");
		TestBase.setExtentReportSettings("Statement PDF", Constants.FUNCTIONAL_TESTING, "Verify Statement PDF",
				"Verifying Statement PDF");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertTrue(statementApprovalsPage.statementColumnPDFClick(), "Error Statement PDF icon is not clickable");
	}

	@Test(priority = 7, description = "Verify Location Search", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLocationSearch() {
		LoggerManager.info("Verifying Location Search");
		TestBase.setExtentReportSettings("Location Search", Constants.FUNCTIONAL_TESTING, "Verify Location Search",
				"Verifying Location Search");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertTrue(statementApprovalsPage.locationColumnClick(), "Error Location is not visible");
	}

	@Test(priority = 8, description = "Verify Run ID Search", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyRunIDClick() {
		LoggerManager.info("Verifying Run ID Search");
		TestBase.setExtentReportSettings("Run ID", Constants.FUNCTIONAL_TESTING, "Verify Run ID", "Verifying Run ID");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertTrue(statementApprovalsPage.runIDClick(), "Error Run ID is not visible");
	}

	@Test(priority = 9, description = "Verify Community", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCommunity() {
		LoggerManager.info("Verifying Community");
		TestBase.setExtentReportSettings("Community", Constants.FUNCTIONAL_TESTING, "Verify Community",
				"Verifying Community");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertEquals(statementApprovalsPage.community(), "My Community Dashboard - Classic");
	}

	@Test(priority = 10, description = "Verify Search Approvals Tab", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySearchApprovalsTab() {
		LoggerManager.info("Verifying Search Approvals Tab");
		TestBase.setExtentReportSettings("Search Approvals Tab", Constants.FUNCTIONAL_TESTING,
				"Verify Search Approvals Tab", "Verifying Search Approvals Tab");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertEquals(statementApprovalsPage.searchApprovalsTabRecords(), "Date Type:");
	}

	@Test(priority = 11, description = "Verify Statement Runs Tab", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyStatementRunsTab() {
		LoggerManager.info("Verifying Statement Runs Tab");
		TestBase.setExtentReportSettings("Statement Runs Tab", Constants.FUNCTIONAL_TESTING,
				"Verify Statement Runs Tab", "Verifying Statement Runs Tab");
		statementApprovalsPage = new StatementApprovalsPage(driver);
		assertEquals(statementApprovalsPage.statementRunsTabRecords(), "Year:");
	}
}

