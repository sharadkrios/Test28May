package com.ciranet.cirabooks.cashmanagement.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.cirabooks.cashmanagement.pages.DepositsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class DepositsPageTest extends TestBase {
	DepositsPage depositsPage = createPage(DepositsPage.class);

	@Test(priority = 0, description = "Verify Deposits navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyDepositsNavigation() throws Exception {
		LoggerManager.info("Verifying Deposits navigation");
		TestBase.setExtentReportSettings("Deposits", Constants.SMOKE_TESTING, "Verify Deposits",
				"Verifying Deposits navigation");
		depositsPage = new DepositsPage(driver);
		assertTrue(depositsPage.navigate(), "Error navigating to Deposits page");
	}

	@Test(priority = 1, description = "Verify Add New Deposit", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAddDeposits() {
		LoggerManager.info("Verifying Add New Deposit");
		TestBase.setExtentReportSettings("Add New Deposit", Constants.FUNCTIONAL_TESTING,
				"Verify Add New Deposit", "Verifying Add New Deposit");
		depositsPage = new DepositsPage(driver);
		assertEquals(depositsPage.addDeposits(), "Add New Deposit");
	}

	@Test(priority = 2, description = "Verify Column Chooser", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifycolumnChooserClick() {
		LoggerManager.info("Verifying Column Chooser");
		TestBase.setExtentReportSettings("Column Chooser", Constants.FUNCTIONAL_TESTING, "Verify Column Chooser",
				"Verifying Column Chooser");
		depositsPage = new DepositsPage(driver);
		assertEquals(depositsPage.columnChooser(), "Column Chooser");
	}

	@Test(priority = 3, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolbarFullScreen() {
		LoggerManager.info("Verifying Fullacreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING,
				"Verify Fullscreen icon", "Verifying Fullscreen icon");
		depositsPage = new DepositsPage(driver);
		assertTrue(depositsPage.toolBarFullScreen(), "Error while Fullscreen icon is not clickable");
	}

	@Test(priority = 4, description = "Verify Export To Excel icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyExportToExcelIcon() {
		LoggerManager.info("Verifying Export To Excel icon");
		TestBase.setExtentReportSettings("Export To Excel icon", Constants.FUNCTIONAL_TESTING,
				"Verify Export To Excel icon", "Verifying Export To Excel icon");
		depositsPage = new DepositsPage(driver);
		assertTrue(depositsPage.exportToExcel(), "Error while Export to Excel icon is not clickable");
	}

	@Test(priority = 5, description = "Verify View menu", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViewMenu() {
		LoggerManager.info("Verifying View menu");
		TestBase.setExtentReportSettings("View menu ", Constants.FUNCTIONAL_TESTING, "Verify View menu",
				"Verifying View menu");
		depositsPage = new DepositsPage(driver);
		assertEquals(depositsPage.viewMenu(), "Receive Date");
	}
}

