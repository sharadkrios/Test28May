package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.configurations.pages.ModulesConfigurationsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin

public class ModulesConfigurationsPageTest extends TestBase {
	// Create the ModulesConfigurationsPage object
	ModulesConfigurationsPage modulesConfigurationsPage = createPage(ModulesConfigurationsPage.class);
	private String contextSearchText="";

	@Test(priority = 0, description = "Verify Modules Configuration navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyModulesNavigation() {
		LoggerManager.info("Verifying Modules Configuration navigation");
		TestBase.setExtentReportSettings("Modules Configuration", Constants.SMOKE_TESTING,
				"Verify Modules Configuration", "Verifying Modules Configuration navigation");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		assertTrue(modulesConfigurationsPage.navigateToModulesConfiguration(),
				"Error navigate to Modules configuration");
	}

	@Parameters("contextSearchText")
	@Test(priority = 1, description = "Verify Cira Budget Recommendations and Assumptions", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyRecommendationsandAssumptions(String contextSearchText) {
		this.contextSearchText = contextSearchText;
		LoggerManager.info("Verifying Cira Budget Recommendations and Assumptions");
		TestBase.setExtentReportSettings("Cira Budget Recommendations and Assumptions", Constants.FUNCTIONAL_TESTING,
				"Verify Cira Budget Recommendations and Assumptions",
				"Verifying Cira Budget Recommendations and Assumptions");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		modulesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(
				modulesConfigurationsPage.selectConfigurationByName("Cira Budget Recommendations and Assumptions",
						contextSearchText),
				"Error occurred while clicking on Cira Budget Recommendations and Assumptions");
	}

	@Test(priority = 2, description = "Verify Cira Budget Supplemental Information", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySupplementalInformation() {
		LoggerManager.info("Verifying Cira Budget Supplemental Information");
		TestBase.setExtentReportSettings("Cira Budget Supplemental Information", Constants.FUNCTIONAL_TESTING,
				"Verify Cira Budget Supplemental Information", "Verifying Cira Budget Supplemental Information");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		assertTrue(modulesConfigurationsPage.selectConfigurationByName("Cira Budget Supplemental Information",
				contextSearchText), "Error occurred while clicking on Cira Budget Supplemental Information");
	}

	@Test(priority = 3, description = "Verify Customer Defined Info", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCustomerDefinedInfo() {
		LoggerManager.info("Verifying Customer Defined Info");
		TestBase.setExtentReportSettings("Customer Defined Info", Constants.FUNCTIONAL_TESTING,
				"Verify Customer Defined Info", "Verifying Customer Defined Info");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		assertTrue(modulesConfigurationsPage.selectConfigurationByName("Customer Defined Info", contextSearchText),
				"Error occurred while clicking on Customer Defined Info");
	}

	@Test(priority = 4, description = "Verify Egnyte Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEgnyteConfiguration() {
		LoggerManager.info("Verifying Egnyte Configuration");
		TestBase.setExtentReportSettings("Egnyte Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Egnyte Configuration", "Verifying Egnyte Configuration");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		assertTrue(modulesConfigurationsPage.selectConfigurationByName("Egnyte Configuration", contextSearchText),
				"Error occurred while clicking on Egnyte Configuration");
	}

	@Test(priority = 5, description = "Verify Help", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyHelp() {
		LoggerManager.info("Verifying Help");
		TestBase.setExtentReportSettings("Help", Constants.FUNCTIONAL_TESTING, "Verify Help", "Verifying Help");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		assertTrue(modulesConfigurationsPage.selectConfigurationByName("Help", contextSearchText),
				"Error occurred while clicking on Help");
	}

	@Test(priority = 6, description = "Verify Transition Document", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyTransitionDocuments() {
		LoggerManager.info("Verifying Transition Document");
		TestBase.setExtentReportSettings("Transition Document", Constants.FUNCTIONAL_TESTING,
				"Verify Transition Document", "Verifying Transition Document");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		assertTrue(modulesConfigurationsPage.selectConfigurationByName("Transition Document", contextSearchText),
				"Error occurred while clicking on Transition Document");
	}

	@Test(priority = 7, description = "Verify Work Order Work Areas", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyWorkOrderWorkAreas() {
		LoggerManager.info("Verifying Work Order Work Areas");
		TestBase.setExtentReportSettings("Work Order Work Areas", Constants.FUNCTIONAL_TESTING,
				"Verify Work Order Work Areas", "Verifying Work Order Work Areas");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		assertTrue(modulesConfigurationsPage.selectConfigurationByName("Work Order Work Areas", contextSearchText),
				"Error occurred while clicking on Work Order Work Areas");
	}

	@Test(priority = 8, description = "Verify Transition Task Templates", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyTransitionTaskTemplates() {
		LoggerManager.info("Verifying Transition Task Templates");
		TestBase.setExtentReportSettings("Transition Task Templates", Constants.FUNCTIONAL_TESTING,
				"Verify Transition Task Templates", "Verifying Transition Task Templates");
		modulesConfigurationsPage = new ModulesConfigurationsPage(driver);
		assertEquals(modulesConfigurationsPage.selectTransitionTaskTemplates(), "Tasks");
	}
}

