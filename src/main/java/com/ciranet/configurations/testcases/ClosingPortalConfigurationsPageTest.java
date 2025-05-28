package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.configurations.pages.ClosingPortalConfigurationsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ClosingPortalConfigurationsPageTest extends TestBase {

	// Create the closingPortalConfigurationsPage object
	ClosingPortalConfigurationsPage closingPortalConfigurationsPage = createPage(ClosingPortalConfigurationsPage.class);

	private String contextSearchText;

	@Test(priority = 0, description = "Verify Closing Portal navigation", groups = { Constants.SMOKE_TESTING })
	public void verifyClosingPortalNavigation() {
		LoggerManager.info("Verifying Closing Portal navigation");
		TestBase.setExtentReportSettings("Closing Portal", Constants.SMOKE_TESTING, "Verify Closing Portal",
				"Verifying Closing Portal navigation");
		closingPortalConfigurationsPage = new ClosingPortalConfigurationsPage(driver);
		assertTrue(closingPortalConfigurationsPage.navigateToClosingPortalConfigurations(),
				"Error navigate to Closing Portal Configurations");
	}

	@Parameters({ "contextSearchText" })
	@Test(priority = 1, description = "Verify Account Inquiry Fulfillment", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAccountInquiryFulfillment(String contextSearchText) {
		this.contextSearchText = contextSearchText;
		LoggerManager.info("Verifying Account Inquiry Fulfillment");
		TestBase.setExtentReportSettings("Account Inquiry Fulfillment", Constants.FUNCTIONAL_TESTING,
				"Verify Account Inquiry Fulfillment", "Verifying Account Inquiry Fulfillment");
		closingPortalConfigurationsPage = new ClosingPortalConfigurationsPage(driver);
		closingPortalConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(closingPortalConfigurationsPage.selectConfigurations("Account Inquiry Fulfillment"),
				"Error occurred while Account Inquiry Fulfillment is not clickable");
	}

	@Test(priority = 2, description = "Verify CiraConnect Fee", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCiraConnectFee() {
		LoggerManager.info("Verifying CiraConnect Fee");
		TestBase.setExtentReportSettings("CiraConnect Fee", Constants.FUNCTIONAL_TESTING, "Verify CiraConnect Fee",
				"Verifying CiraConnect Fee");
		closingPortalConfigurationsPage = new ClosingPortalConfigurationsPage(driver);
		closingPortalConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(closingPortalConfigurationsPage.selectConfigurations("CiraConnect Fee"),
				"Error occurred while CiraConnect Fee is not clickable");
	}

	@Test(priority = 3, description = "Verify Closing Portal Delivery Tiers", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyClosingPortalDeliveryTiers() {
		LoggerManager.info("Verifying Closing Portal Delivery Tiers");
		TestBase.setExtentReportSettings("Closing Portal Delivery Tiers", Constants.FUNCTIONAL_TESTING,
				"Verify Closing Portal Delivery Tiers", "Verifying Closing Portal Delivery Tiers");
		closingPortalConfigurationsPage = new ClosingPortalConfigurationsPage(driver);
		closingPortalConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(closingPortalConfigurationsPage.selectConfigurations("Closing Portal Delivery Tiers"),
				"Error occurred while Closing Portal Delivery Tiers is not clickable");
	}

	@Test(priority = 4, description = "Verify Portal Configuration Fees & Charges", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyPortalConfigurationFeesCharges() {
		LoggerManager.info("Verifying Portal Configuration Fees & Charges");
		TestBase.setExtentReportSettings("Portal Configuration Fees & Charges", Constants.FUNCTIONAL_TESTING,
				"Verify Portal Configuration Fees & Charges", "Verifying Portal Configuration Fees & Charges");
		closingPortalConfigurationsPage = new ClosingPortalConfigurationsPage(driver);
		closingPortalConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(closingPortalConfigurationsPage.selectConfigurations("Portal Configuration Fees & Charges"),
				"Error occurred while Portal Configuration Fees & Charges is not clickable");
	}
}
