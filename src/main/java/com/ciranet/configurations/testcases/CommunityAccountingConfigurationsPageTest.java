package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.configurations.pages.CommunityAccountingConfigurationsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class CommunityAccountingConfigurationsPageTest extends TestBase {
	// Create the CommunityAccountingPage object
	CommunityAccountingConfigurationsPage communityAccountingConfigurationsPage = createPage(
			CommunityAccountingConfigurationsPage.class);
	private String contextSearchText;

	@Test(priority = 0, description = "Verify Community Accounting Configurations navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCommunityAccountingConfigurationsNavigation() {
		LoggerManager.info("Verifying Community Accounting Configurations navigation");
		TestBase.setExtentReportSettings("Community Accounting Configurations", Constants.SMOKE_TESTING,
				"Verify Community Accounting Configurations",
				"Verifying Community Accounting Configurations navigation");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		assertTrue(communityAccountingConfigurationsPage.navigateToCommuityAccountingConfigurations(),
				"Error navigate to Community Accounting Configurations");
	}

	@Parameters("contextSearchText")
	@Test(priority = 1, description = "Verify AAP Cross Entity Bill Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAAPCrossEntityBillConfiguration(String contextSearchText) {
		this.contextSearchText = contextSearchText;
		LoggerManager.info("Verifying AAP Cross Entity Bill Configuration");
		TestBase.setExtentReportSettings("AAP Cross Entity Bill Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify AAP Cross Entity Bill Configuration", "Verifying AAP Cross Entity Bill Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectAAPCrossEntityBill(),
				"Error occurred while AAP Cross Entity Bill Configuration is not clickable");
	}

	@Test(priority = 2, description = "Verify AAP Work Flow Auto Action Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAAPWorkFlowAutoActionConfiguration() {
		LoggerManager.info("Verifying AAP Work Flow Auto Action Configuration");
		TestBase.setExtentReportSettings("AAP  Work Flow Auto Action Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify AAP Work Flow Auto Action Configuration", "Verifying AAP Work Flow Auto Action Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectAAPWorkFlowAutoAction(),
				"Error occurred while AAP Work Flow Auto Action Configuration is not clickable");
	}


	@Test(priority = 3, description = "Verify AAP Work Flow CheckList Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAAPWorkFlowCheckListConfiguration() {
		LoggerManager.info("Verifying AAP Work Flow CheckList Configuration");
		TestBase.setExtentReportSettings("AAP Work Flow CheckList Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify AAP Work Flow CheckList Configuration", "Verifying AAP Work Flow CheckList Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectAAPWorkFlowCheckList(),
				"Error occurred while AAP Work Flow CheckList Configuration is not clickable");
	}

	@Test(priority = 4, description = "Verify AAR Billing Types Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAARBillingTypesConfiguration() {
		LoggerManager.info("Verifying AAR Billing Types Configuration");
		TestBase.setExtentReportSettings("AAR Billing Types Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify AAR Billing Types Configuration", "Verifying AAR Billing Types Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectAARBillingTypes(),
				"Error occurred while AAR Billing Types Configuration is not clickable");
	}

	@Test(priority = 5, description = "Verify AAR Builder Statements Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAARBuilderStatementsConfiguration() {
		LoggerManager.info("Verifying AAR Builder Statements Configuration");
		TestBase.setExtentReportSettings("AAR Builder Statements Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify AAR Builder Statements Configuration", "Verifying AAR Builder Statements Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectAARBuilderStatements(),
				"Error occurred while AAR Builder Statements Configuration is not clickable");
	}

	@Test(priority = 6, description = "Verify AAR Misc Invoice Types Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAARMiscInvoiceTypesConfiguration() {
		LoggerManager.info("Verifying AAR Misc Invoice Types Configuration");
		TestBase.setExtentReportSettings("AAR Misc Invoice Types Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify AAR Misc Invoice Types Configuration", "Verifying AAR Misc Invoice Types Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectAARMiscInvoiceTypes(),
				"Error occurred while AAR Misc Invoice Types Configuration is not clickable");
	}

	@Test(priority = 7, description = "Verify AAR Payment Application Order Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAARPaymentApplicationOrderConfiguration() {
		LoggerManager.info("Verifying AAR Payment Application Order Configuration");
		TestBase.setExtentReportSettings("AAR Payment Application Order Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify AAR Payment Application Order Configuration",
				"Verifying AAR Payment Application Order Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectAARPaymentApplicationOrder(),
				"Error occurred while AAR Payment Application Order Configuration is not clickable");
	}

	@Test(priority = 8, description = "Verify AAR Statements Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAARStatementsConfiguration() {
		LoggerManager.info("Verifying AAR Statements Configuration");
		TestBase.setExtentReportSettings("AAR Statements Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify AAR Statements Configuration", "Verifying AAR Statements Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectAARStatements(),
				"Error occurred while AAR Statements Configuration is not clickable");
	}

	@Test(priority = 9, description = "Verify Collections Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCollectionsConfiguration() {
		LoggerManager.info("Verifying Collections Configuration");
		TestBase.setExtentReportSettings("Collections Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Collections Configuration", "Verifying Collections Configuration");
		communityAccountingConfigurationsPage = new CommunityAccountingConfigurationsPage(driver);
		communityAccountingConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(communityAccountingConfigurationsPage.selectCollectionsConfiguration(),
				"Error occurred while Collections Configuration is not clickable");
	}
}