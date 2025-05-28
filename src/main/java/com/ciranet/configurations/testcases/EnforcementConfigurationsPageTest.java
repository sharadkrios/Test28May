package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.configurations.pages.EnforcementConfigurationsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class EnforcementConfigurationsPageTest extends TestBase {

	// Create the EnforcementPage object
	EnforcementConfigurationsPage enforcementConfigurationsPage = createPage(EnforcementConfigurationsPage.class);
	private String contextSearchText;
	
	@Test(priority = 0, description = "Verify Enforcement Configurations navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyEnforcementNavigation() {
		LoggerManager.info("Verifying Enforcement Configurations navigation");
		TestBase.setExtentReportSettings("Enforcement Configurations", Constants.SMOKE_TESTING, "Verify Enforcement Configurations",
				"Verifying Enforcement Configurations navigation");
		enforcementConfigurationsPage = new EnforcementConfigurationsPage(driver);
		assertTrue(enforcementConfigurationsPage.navigateToEnforcementConfigurations(), "Error navigate to Enforcement Configurations");
	}

	@Parameters("contextSearchText")
	@Test(priority = 1, description = "Verify Architectural Categories Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyArchitecturalCategoriesConfiguration(String contextSearchText) {
		this.contextSearchText = contextSearchText;
		LoggerManager.info("Verifying Architectural Categories Configuration");
		TestBase.setExtentReportSettings("Architectural Categories Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Architectural Categories Configuration", "Verifying Architectural Categories Configuration");
		enforcementConfigurationsPage = new EnforcementConfigurationsPage(driver);
		enforcementConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(enforcementConfigurationsPage.selectArchitecturalCategories(), "Error occured while Architectural Categories Configuration is not clickable");
	}

	@Test(priority = 2, description = "Verify Architectural Forms and Guides Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyArchitecturalFormsandGuidesConfiguration() {
		LoggerManager.info("Verifying Architectural Forms and Guides Configuration");
		TestBase.setExtentReportSettings("Architectural Forms and Guides Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Architectural Forms and Guides Configuration", "Verifying Architectural Forms and Guides Configuration");
		enforcementConfigurationsPage = new EnforcementConfigurationsPage(driver);
		enforcementConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(enforcementConfigurationsPage.selectArchitecturalFormsandGuides(), "Error occured while Architectural Forms and Guides Configuration is not clickable");
	}

	@Test(priority = 3, description = "Verify Violation Category SubCategory Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViolationCategorySubCategoryConfiguration() {
		LoggerManager.info("Verifying Violation Category SubCategory Configuration");
		TestBase.setExtentReportSettings("Violation Category SubCategory Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Violation Category SubCategory Configuration",
				"Verifying Violation Category SubCategory Configuration");
		enforcementConfigurationsPage = new EnforcementConfigurationsPage(driver);
		enforcementConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(enforcementConfigurationsPage.selectViolationCategorySubCategoryConfiguration(),
				"Error occured while Violation Category / SubCategory Configuration is not clickable");
	}

	@Test(priority = 4, description = "Verify Violation Escalation Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViolationEscalationConfiguration() {
		LoggerManager.info("Verifying Violation Escalation Configuration");
		TestBase.setExtentReportSettings("Violation Escalation Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Violation Escalation Configuration", "Verifying Violation Escalation Configuration");
		enforcementConfigurationsPage = new EnforcementConfigurationsPage(driver);
		enforcementConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(enforcementConfigurationsPage.selectViolationEscalationConfiguration(), "Error occured while Violation Escalation Configuration is not clickable.");
	}

	@Test(priority = 5, description = "Verify Violation Notification Templates Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViolationNotificationTemplatesConfiguration() {
		LoggerManager.info("Verifying Violation Notification Templates Configuration");
		TestBase.setExtentReportSettings("Violation Notification Templates Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Violation Notification Templates Configuration", "Verifying Violation Notification Templates Configuration");
		enforcementConfigurationsPage = new EnforcementConfigurationsPage(driver);
		enforcementConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(enforcementConfigurationsPage.selectViolationNotificationTemplates(), "Error occured while Violation Notification Templates Configuration is not clickable");
	}

	@Test(priority = 6, description = "Verify Violation Restriction Definition Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViolationRestrictionDefinitionConfiguration() {
		LoggerManager.info("Verifying Violation Restriction Definition Configuration");
		TestBase.setExtentReportSettings("Violation Restriction Definition Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Violation Restriction Definition Configuration", "Verifying Violation Restriction Definition Configuration");
		enforcementConfigurationsPage = new EnforcementConfigurationsPage(driver);
		enforcementConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(enforcementConfigurationsPage.selectViolationRestrictionDefinition(),
				"Error occured while Violation Restriction Definition Configuration is not clickable.");
	}
}
