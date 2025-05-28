package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.configurations.pages.CommunityConfigurationsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin

public class CommunityConfigurationsPageTest extends TestBase {

	// Create the CommunityPage object
	CommunityConfigurationsPage communityConfigurationsPage = createPage(CommunityConfigurationsPage.class);

	private String contextSearchText;

	@Test(priority = 0, description = "Verify Community Navigation", groups = { Constants.SMOKE_TESTING })
	public void verifyCommunityNavigation() {
		LoggerManager.info("Verifying Community navigation");
		TestBase.setExtentReportSettings("Community", Constants.SMOKE_TESTING, "Verify Community",
				"Verifying Community Navigation");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		assertTrue(communityConfigurationsPage.navigateToCommunityConfigurations(),
				"Error navigate to Community configuration");
	}

	@Parameters({ "contextSearchText" })
	@Test(priority = 1, description = "Verify Access Control Waiver", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyAccessControlWaiver(String contextSearchText) {
		this.contextSearchText = contextSearchText;
		LoggerManager.info("Verifying Access Control Waiver");
		TestBase.setExtentReportSettings("Access Control Waiver", Constants.FUNCTIONAL_TESTING,
				"Verify Access Control Waiver", "Verifying Access Control Waiver");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Access Control Waiver Configuration"),
				"Error occurred while clicking on Access Control Waiver");
	}

	@Test(priority = 2, description = "Verify Board Approval", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyBoardApproval() {
		LoggerManager.info("Verifying Board Approval");
		TestBase.setExtentReportSettings("Board Approval", Constants.FUNCTIONAL_TESTING, "Verify Board Approval",
				"Verifying Board Approval");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Board Approval Configuration"),
				"Error occurred while clicking on Board Approval");
	}

	@Test(priority = 3, description = "Verify Collection Letter Fees", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyCollectionLetterFees() {
		LoggerManager.info("Verifying Collection Letter Fees");
		TestBase.setExtentReportSettings("Collection Letter Fees", Constants.FUNCTIONAL_TESTING,
				"Verify Collection Letter Fees", "Verifying Collection Letter Fees");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Collection Letter Fees Configuration"),
				"Error occurred while clicking on Collection Letter Fees");
	}

	@Test(priority = 4, description = "Verify Community Configuration", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyCommunityConfiguration() {
		LoggerManager.info("Verifying Community Configuration");
		TestBase.setExtentReportSettings("Community Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Community Configuration", "Verifying Community Configuration");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Community Configuration"),
				"Error while clicking on community configuration");
	}

	@Test(priority = 5, description = "Verify Fulfillment Job Special Pricing Configuration", groups = {
			Constants.FUNCTIONAL_TESTING })
	public void verifyFulfillmentJobSpecialPricingConfiguration() {
		LoggerManager.info("Verifying Fulfillment Job Special Pricing Configuration");
		TestBase.setExtentReportSettings("Fulfillment Job Special Pricing Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Fulfillment Job Special Pricing Configuration",
				"Verifying Fulfillment Job Special Pricing Configuration");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Fulfillment Job Special Pricing Configuration"),
				"Error occurred while clicking on Fulfillment Job Special Pricing Configuration");
	}

	@Test(priority = 6, description = "Verify Holidays", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyHolidays() {
		LoggerManager.info("Verifying Holidays");
		TestBase.setExtentReportSettings("Holidays", Constants.FUNCTIONAL_TESTING, "Verify Holidays",
				"Verifying Holidays");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Holidays Configuration"),
				"Error occurred while clicking on Holidays");
	}

	@Test(priority = 7, description = "Verify Info", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyInfo() {
		LoggerManager.info("Verifying Info");
		TestBase.setExtentReportSettings("Info", Constants.FUNCTIONAL_TESTING, "Verify Info", "Verifying Info");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Info Configuration"),
				"Error occurred while clicking on Info");
	}

	@Test(priority = 8, description = "Verify Mass Communication Configuration", groups = {
			Constants.FUNCTIONAL_TESTING })
	public void verifyMassCommunicationConfiguration() {
		LoggerManager.info("Verifying Mass Communication Configuration");
		TestBase.setExtentReportSettings("Mass Communication Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Mass Communication Configuration", "Verifying Mass Communication Configuration");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Mass Communication Configuration"),
				"Error occurred while clicking on Mass Communication Configuration");
	}

	@Test(priority = 9, description = "Verify Notes", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyNotes() {
		LoggerManager.info("Verifying Notes");
		TestBase.setExtentReportSettings("Notes", Constants.FUNCTIONAL_TESTING, "Verify Notes", "Verifying Notes");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Notes Configuration"),
				"Error occurred while clicking on Notes");
	}

	@Test(priority = 10, description = "Verify Owner Fees", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyOwnerFees() {
		LoggerManager.info("Verifying Owner Fees");
		TestBase.setExtentReportSettings("Owner Fees", Constants.FUNCTIONAL_TESTING, "Verify Owner Fees",
				"Verifying Owner Fees");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Owner Fees Configuration"),
				"Error occurred while clicking on Owner Fees");
	}

	@Test(priority = 11, description = "Verify Printing Provider", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyPrintingProvider() {
		LoggerManager.info("Verifying Printing Provider");
		TestBase.setExtentReportSettings("Printing Provider", Constants.FUNCTIONAL_TESTING, "Verify Printing Provider",
				"Verifying Printing Provider");
		communityConfigurationsPage = new CommunityConfigurationsPage(driver);
		communityConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityConfigurationsPage.selectConfigurations("Select Printing Provider Configuration"),
				"Error occurred while clicking on Printing Provider");
	}
}





