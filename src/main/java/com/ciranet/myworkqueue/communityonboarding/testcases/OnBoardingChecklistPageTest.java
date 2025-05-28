package com.ciranet.myworkqueue.communityonboarding.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.communityonboarding.pages.OnBoardingChecklistPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class OnBoardingChecklistPageTest extends TestBase {
	// Create the OnBoardingChecklistPage object
	OnBoardingChecklistPage onBoardingChecklistPage = createPage(OnBoardingChecklistPage.class);

	@Test(priority = 0, description = "Verify On Boarding Checklist navigate", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyOnBoardingChecklist() {
		LoggerManager.info("Verifying On Boarding Checklist navigation");
		TestBase.setExtentReportSettings("On Boarding Checklist", Constants.SMOKE_TESTING,
				"Verify On-Boarding Checklist", "Verifying On Boarding Checklist navigation");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertTrue(onBoardingChecklistPage.navigate(), "Error navigating to On-Boarding Checklist");
	}

	@Test(priority = 1, description = "Verify Change Assign To action", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyChangeAssignedTo() {
		LoggerManager.info("Verifying Change Assign To");
		TestBase.setExtentReportSettings("Change Assign To", Constants.FUNCTIONAL_TESTING, "Verify Change Assign To",
				"Verifying Change Assign To");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertEquals(onBoardingChecklistPage.changeAssignedToAction(), "Assigned To User");
	}

	@Test(priority = 2, description = "Verify Email Reminder", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEmailReminderAction() {
		LoggerManager.info("Verifying Email Reminder");
		TestBase.setExtentReportSettings("Email Reminder", Constants.FUNCTIONAL_TESTING, "Verify Email Reminder",
				"Verifying Email Reminder");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertTrue(onBoardingChecklistPage.emailReminderAction(), "Error clicking on Email Reminder");
	}

	@Test(priority = 3, description = "Verify Set Not Appplicable", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySetNotAppplicableAction() {
		LoggerManager.info("Verifying Set Not Appplicable");
		TestBase.setExtentReportSettings("Set Not Appplicable", Constants.FUNCTIONAL_TESTING,
				"Verify Set Not Appplicable", "Verifying Set Not Appplicable");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertEquals(onBoardingChecklistPage.setNotAppplicableAction(), "Confirmation");
	}

	@Test(priority = 4, description = "Verify Approval", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyApproveAction() {
		LoggerManager.info("Verifying Approval");
		TestBase.setExtentReportSettings("Approval", Constants.FUNCTIONAL_TESTING, "Verify Approval",
				"Verifying Approval");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertTrue(onBoardingChecklistPage.approveAction(), "Error clicking on Approval");
	}

	@Test(priority = 5, description = "Verify Manage Documents", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyDocumentsAdding() {
		LoggerManager.info("Verifying Manage Documents");
		TestBase.setExtentReportSettings("Manage Documents", Constants.FUNCTIONAL_TESTING, "Verify Manage Document",
				"Verifying Manage Documents");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertEquals(onBoardingChecklistPage.documentsAdding(), "Manage Documents");
	}

	@Test(priority = 6, description = "Verify Email icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEmailLinking() {
		LoggerManager.info("Verifying Email icon");
		TestBase.setExtentReportSettings("Email icon", Constants.FUNCTIONAL_TESTING, "Verify Email icon",
				"Verifying Emails icon");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertTrue(onBoardingChecklistPage.emailLinking(), "Error clicking on Emails icon");
	}

	@Test(priority = 7, description = "Verify Logs icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLogHistory() {
		LoggerManager.info("Verifying Logs icon");
		TestBase.setExtentReportSettings("Logs icon", Constants.FUNCTIONAL_TESTING, "Verify Log icon",
				"Verifying Logs icons");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertTrue(onBoardingChecklistPage.logHistory(), "Error clicking on Logs icon");
	}

	@Test(priority = 8, description = "Verify Notes Icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAddingNotes() {
		LoggerManager.info("Notes Icon");
		TestBase.setExtentReportSettings("Verifying Notes Icon", Constants.FUNCTIONAL_TESTING, "Verify Note Icon",
				"Verifying Notes Icons");
		onBoardingChecklistPage = new OnBoardingChecklistPage(driver);
		assertTrue(onBoardingChecklistPage.addingNotes(), "Error clicking on Notes icon");
	}

}
