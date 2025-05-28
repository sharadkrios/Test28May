package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.configurations.pages.ServicesConfigurationsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ServicesConfigurationsPageTest extends TestBase {

	// Create the ServicesPage object
	ServicesConfigurationsPage servicesConfigurationsPage = createPage(ServicesConfigurationsPage.class);
	private String contextSearchText;

	@Test(priority = 0, description = "Verify Services Configurations navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyServicesNavigation() {
		LoggerManager.info("Verifying Services Configurations navigation");
		TestBase.setExtentReportSettings("Services Configurations", Constants.SMOKE_TESTING,
				"Verify Services Configurations", "Verifying Services Configurations navigation");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		assertTrue(servicesConfigurationsPage.navigateToServicesConfigurations(),
				"Error navigate to Services Configurations");
	}

	@Parameters("contextSearchText")
	@Test(priority = 1, description = "Verify Board Portal Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyBoardPortalConfiguration(String contextSearchText) {
		this.contextSearchText = contextSearchText;
		LoggerManager.info("Verifying Board Portal Configuration");
		TestBase.setExtentReportSettings("Board Portal Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Board Portal Configuration", "Verifying Board Portal Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectBoardPortal(),
				"Error occured while Board Portal Configuration is not clickable");
	}

	@Test(priority = 2, description = "Verify Branding Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyBrandingConfiguration() {
		LoggerManager.info("Verifying Branding Configuration");
		TestBase.setExtentReportSettings("Branding Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Branding Configuration", "Verifying Branding Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectBrandingConfiguration(),
				"Error occured while Branding Configuration is not clickable");
	}

	@Test(priority = 3, description = "Verify Bussiness Hours", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyBussinessHoursConfiguration() {
		LoggerManager.info("Verifying Bussiness Hours Configuration");
		TestBase.setExtentReportSettings("Business Hours Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Business Hours Configuration", "Verifying Business Hours Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectBussinessHours(),
				"Error occured while Business Hours Configuration is not clickable");
	}

	@Test(priority = 4, description = "Verify Calendar Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyCalendarConfiguration() {
		LoggerManager.info("Verifying Calendar Configuration");
		TestBase.setExtentReportSettings("Calendar Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Calendar Configuration", "Verifying Calendar Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectCalendarConfiguration(),
				"Error occured while Calendar Configuration is not clickable");
	}

	@Test(priority = 5, description = "Verify Mass Communication System Template Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyMassCommunicationSystemTemplateConfiguration() {
		LoggerManager.info("Verifying Mass Communication System Template Configuration");
		TestBase.setExtentReportSettings("Mass Communication System Template Configuration",
				Constants.FUNCTIONAL_TESTING, "Verify Mass Communication System Template Configuration",
				"Verifying Mass Communication System Template Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectMassCommunicationSystemTemplate(),
				"Error occured while Mass Communication System Template Configuration is not clickable");
	}

	@Test(priority = 6, description = "Verify Resident Portal Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyResidentPortalConfiguration() {
		LoggerManager.info("Verifying Resident Portal Configuration");
		TestBase.setExtentReportSettings("Resident Portal Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Resident Portal Configuration", "Verifying Resident Portal Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectResidentPortal(),
				"Error occured while Resident Portal Configuration is not clickable");
	}

	@Test(priority = 7, description = "Verify Service Groups Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyServiceGroupsConfiguration() {
		LoggerManager.info("Verifying Service Groups Configuration");
		TestBase.setExtentReportSettings("Service Groups Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Service Groups Configuration", "Verifying Service Groups Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectServiceGroups(),
				"Error occured while Service Groups Configuration is not clickable");
	}

	@Test(priority = 8, description = "Verify Service Roles Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyServiceRolesConfiguration() {
		LoggerManager.info("Verifying Service Roles Configuration");
		TestBase.setExtentReportSettings("Service Roles Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Service Roles Configuration", "Verifying Service Roles Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectServiceRoles(),
				"Error occured while Service Roles Configuration is not clickable");
	}

	@Test(priority = 9, description = "Verify Services Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyServicesConfiguration() {
		LoggerManager.info("Verifying Services Configuration");
		TestBase.setExtentReportSettings("Services Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Services Configuration", "Verifying Services Configuration");
		servicesConfigurationsPage = new ServicesConfigurationsPage(driver);
		servicesConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(servicesConfigurationsPage.selectServices(),
				"Error occured while Services Configuration is not clickable");
	}
}
