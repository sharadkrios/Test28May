package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.configurations.pages.BatchJobEmailsConfigurationsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class BatchJobEmailsConfigurationsPageTest extends TestBase {

	// Create the BatchJobEmailsPage object
	BatchJobEmailsConfigurationsPage batchJobEmailsConfigurationsPage = createPage(
			BatchJobEmailsConfigurationsPage.class);
	private String contextSearchText;

	@Test(priority = 0, description = "Verify Batch Job Emails Navigation", groups = { Constants.SMOKE_TESTING })
	public void verifyBatchJobEmailsNavigation() {
		LoggerManager.info("Verifying Batch Job Emails navigation");
		TestBase.setExtentReportSettings("Batch Job Emails", Constants.SMOKE_TESTING, "Verify Batch Job Emails",
				"Verifying Batch Job Emails Navigation");
		batchJobEmailsConfigurationsPage = new BatchJobEmailsConfigurationsPage(driver);
		assertTrue(batchJobEmailsConfigurationsPage.navigateToBatchJobEmails(), "Error navigate to Batch Job Emails");
	}

	@Parameters({ "contextSearchText" })
	@Test(priority = 1, description = "Verify ACH & Fee Notification Email", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyACHFeeNotificationEmail(String contextSearchText) {
		this.contextSearchText = contextSearchText;
		LoggerManager.info("Verifying ACH & Fee Notification Email");
		TestBase.setExtentReportSettings("ACH & Fee Notification Email", Constants.FUNCTIONAL_TESTING,
				"Verify ACH & Fee Notification Email", "Verifying ACH & Fee Notification Email");
		batchJobEmailsConfigurationsPage = new BatchJobEmailsConfigurationsPage(driver);
		batchJobEmailsConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(
				batchJobEmailsConfigurationsPage
						.selectConfigurations("Select ACH & Fee Notification Email Configuration"),
				"Error occurred while selecting ACH & Fee Notification Email");
	}

	@Test(priority = 2, description = "Verify ACH Notification Email", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyACHNotificationEmail() {
		LoggerManager.info("Verifying ACH Notification Email");
		TestBase.setExtentReportSettings("ACH Notification Email", Constants.FUNCTIONAL_TESTING,
				"Verify ACH Notification Email", "Verifying ACH Notification Email");
		batchJobEmailsConfigurationsPage = new BatchJobEmailsConfigurationsPage(driver);
		batchJobEmailsConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(batchJobEmailsConfigurationsPage.selectConfigurations("Select ACH Notification Email Configuration"),
				"Error occurred while selecting ACH Notification Email");
	}

	@Test(priority = 3, description = "Verify Annual Budget Preparation Kickoff", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAnnualBudgetPreparationKickoff() {
		LoggerManager.info("Verifying Annual Budget Preparation Kickoff");
		TestBase.setExtentReportSettings("Annual Budget Preparation Kickoff", Constants.FUNCTIONAL_TESTING,
				"Verify Annual Budget Preparation Kickoff", "Verifying Annual Budget Preparation Kickoff");
		batchJobEmailsConfigurationsPage = new BatchJobEmailsConfigurationsPage(driver);
		batchJobEmailsConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(
				batchJobEmailsConfigurationsPage
						.selectConfigurations("Select Annual Budget Preparation Kickoff Configuration"),
				"Error occurred while selecting Annual Budget Preparation Kickoff");
	}

	@Test(priority = 4, description = "Verify Annual Budget Submission to CAM", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAnnualBudgetSubmissiontoCAM() {
		LoggerManager.info("Verifying Annual Budget Submission to CAM");
		TestBase.setExtentReportSettings("Annual Budget Submission to CAM", Constants.FUNCTIONAL_TESTING,
				"Verify Annual Budget Submission to CAM", "Verifying Annual Budget Submission to CAM");
		batchJobEmailsConfigurationsPage = new BatchJobEmailsConfigurationsPage(driver);
		batchJobEmailsConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(
				batchJobEmailsConfigurationsPage
						.selectConfigurations("Select Annual Budget Submission to CAM Configuration"),
				"Error occurred while selecting Annual Budget Submission to CAM");
	}

	@Test(priority = 5, description = "Verify Annual Budget Submission to Client", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAnnualBudgetSubmissiontoClient() {
		LoggerManager.info("Verifying Annual Budget Submission to Client");
		TestBase.setExtentReportSettings("Annual Budget Submission to Client", Constants.FUNCTIONAL_TESTING,
				"Verify Annual Budget Submission to Client", "Verifying Annual Budget Submission to Client");
		batchJobEmailsConfigurationsPage = new BatchJobEmailsConfigurationsPage(driver);
		batchJobEmailsConfigurationsPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(
				batchJobEmailsConfigurationsPage
						.selectConfigurations("Select Annual Budget Submission to Client Configuration"),
				"Error occurred while selecting Annual Budget Submission to Client");
	}
}

