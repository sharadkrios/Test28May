package com.ciranet.community.information.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.community.information.pages.CommonLotsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class CommonLotsPageTest extends TestBase {

	// Create the CommonLotsPage object
	CommonLotsPage commonLotsPage = createPage(CommonLotsPage.class);

	@Test(priority = 0, description = "Verify Common Lots navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCommonLotsNavigation() throws Exception {
		LoggerManager.info("Verifying Common Lots navigation");
		TestBase.setExtentReportSettings("Common Lots", Constants.SMOKE_TESTING,
				"Verify Common Lots navigation", "Verifying Common Lots navigation");
		commonLotsPage = new CommonLotsPage(driver);
		String communitySearch = "Amberwood";
		assertTrue(commonLotsPage.navigate(communitySearch), "Error navigating to Common Lots");
	}

	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolBarFullScreen() {
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING,
				"Verify Fullscreen icon", "Verifying Fullscreen icon");
		commonLotsPage = new CommonLotsPage(driver);
		assertTrue(commonLotsPage.toolBarFullScreen(), "Error while Fullscreen icon is not clickable");
	}

	@Test(priority = 2, description = "Verify Edit Common Lot", groups = { "Functional" }, alwaysRun = true)
	public void verifyCommonLotActions() {
		LoggerManager.info("Verifying Edit Common Lot");
		TestBase.setExtentReportSettings("Edit Common Lot", Constants.FUNCTIONAL_TESTING, "Verify Edit Common Lot",
				"Verifying Edit Common Lot");
		commonLotsPage = new CommonLotsPage(driver);
		assertEquals(commonLotsPage.commonLotActions(), "Edit a Common Lot");
	}

	@Test(priority = 3, description = "Verify Common Lot Notes", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCommonLotsNotes() {
		LoggerManager.info("Verifying Common Lot Notes");
		TestBase.setExtentReportSettings("Common Lot Notes", Constants.FUNCTIONAL_TESTING, "Verify Common Lot Notes",
				"Verifying Common Lot Notes");
		commonLotsPage = new CommonLotsPage(driver);
		assertEquals(commonLotsPage.notes(), "New Notes");
	}

	@Test(priority = 4, description = "Verify Category Grid", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCategoryGrid() {
		LoggerManager.info("Verifying Category Grid");
		TestBase.setExtentReportSettings("Category Grid", Constants.FUNCTIONAL_TESTING, "Verify Category Grid",
				"Verifying Category Grid");
		commonLotsPage = new CommonLotsPage(driver);
		assertEquals(commonLotsPage.categoryGrid(), "Category");
	}

	@Test(priority = 5, description = "Verify PTA Received Tab", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyPTAReceivedTab() {
		LoggerManager.info("Verifying PTA Received Tab");
		TestBase.setExtentReportSettings("PTA Received Tab", Constants.FUNCTIONAL_TESTING, "Verify PTA Received Tab",
				"Verifying PTA Received Tab");
		commonLotsPage = new CommonLotsPage(driver);
		assertEquals(commonLotsPage.ptaReceivedTab(), "Appraiser");
	}

	@Test(priority = 6, description = "Verify PTA Not Received Tab", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyPTANotReceivedTab() {
		LoggerManager.info("Verifying PTA Not Received Tab");
		TestBase.setExtentReportSettings("PTA Not Received Tab", Constants.FUNCTIONAL_TESTING,
				"Verify PTA Not Received Tab", "Verifying PTA Not Received Tab");
		commonLotsPage = new CommonLotsPage(driver);
		assertEquals(commonLotsPage.ptaNotReceivedTab(), "Street Number");
	}

	@Test(priority = 7, description = "Verify Property Taxes Paid tab", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyPropertyTaxesPaidTab() {
		LoggerManager.info("Verifying Property Taxes Paid tab");
		TestBase.setExtentReportSettings("Property Taxes Paid Tab", Constants.FUNCTIONAL_TESTING,
				"Verify Property Taxes Paid tab", "Verifying Property Taxes Paid tab");
		commonLotsPage = new CommonLotsPage(driver);
		assertEquals(commonLotsPage.propertyTaxesPaidTab(), "Tax Year");
	}

	@Test(priority = 8, description = "Verify Add a New Common Lot", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAddNewCommonLot() {
		LoggerManager.info("Verifying Add a New Common Lot");
		TestBase.setExtentReportSettings("Add a New Common Lot", Constants.FUNCTIONAL_TESTING,
				"Verify Add a New Common Lot", "Verifying Add a New Common Lot");
		commonLotsPage = new CommonLotsPage(driver);
		assertEquals(commonLotsPage.addCommonLot(), "Add a New Common Lot");
	}
}
