package com.ciranet.myworkqueue.processtracker.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.processtracker.pages.AnnualStatementGenerationProcessPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class AnnualStatementGenerationProcessPageTest extends TestBase {

	// Create the AnnualStatementGenerationProcessPage object
	AnnualStatementGenerationProcessPage annualStatementGenerationProcessPage = createPage(
			AnnualStatementGenerationProcessPage.class);

	@Test(priority = 0, description = "Verify Annual Statement Generation Process navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyAnnualStatementGenerationProcessNavigation() {
		LoggerManager.info("Verifying Annual Statement Generation Process navigations");
		TestBase.setExtentReportSettings("Annual Statement Generation Process", Constants.SMOKE_TESTING,
				"Verify Annual Statement Generation Process",
				"Verifying Annual Statement Generation Process navigation");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertTrue(annualStatementGenerationProcessPage.navigateToAnnualStatementGenerationProcess(),
				"Error navigating to Annual Statement Generation Process");
	}

	@Test(priority = 1, description = "Verify Rules Approved Notes rejection", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyRulesApprovedNoteRejected() {
		LoggerManager.info("Verifying Rules Approved Notes rejection");
		TestBase.setExtentReportSettings("Rules Approved Notes rejection", Constants.FUNCTIONAL_TESTING,
				"Verify Rules Approved Notes rejection", "Verifying Rules Approved Notes rejection");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertTrue(annualStatementGenerationProcessPage.handleNoteRejectionForStep1(),
				"Error occurred while rejecting the 'Rules Approved' notes.");
	}

	@Parameters("filePath")
	@Test(priority = 2, description = "Verify Rules approved and upload file", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyRulesApprovedAndFileUpload(String filePath) {
		LoggerManager.info("Verifying Rules approved and upload file");
		TestBase.setExtentReportSettings("Rules approved and upload file", Constants.FUNCTIONAL_TESTING,
				"Verify Rules approved and upload file", "Verifying Rules approved and file upload");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertTrue(annualStatementGenerationProcessPage.handleRulesApprovalAndFileUpload(filePath),
				"An error occurred while approving the rules and uploading the file.");
	}

	@Test(priority = 3, description = "Verify Notes rejection for statements", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyNotesRejectionForStatements() {
		LoggerManager.info("Verifying Notes rejection for statements");
		TestBase.setExtentReportSettings("Notes rejection for statements", Constants.FUNCTIONAL_TESTING,
				"Verify Notes rejection for statements", "Verifying Notes rejection for statements");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertTrue(annualStatementGenerationProcessPage.handleNoteRejectionForStep2(),
				"Error occurred while rejecting the notes");
	}

	@Parameters("filePath")
	@Test(priority = 4, description = "Verify Approve Statements Generated and Upload File", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyApproveStatementsGeneratedAndUploadFile(String filePath){
		LoggerManager.info("Verifying Approve Statements Generated and Upload File");
		TestBase.setExtentReportSettings("Approve Statements Generated and Upload File", Constants.FUNCTIONAL_TESTING,
				"Verify Approve Statements Generated and Upload File",
				"Verifying Approve Statements Generated and Upload File");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertTrue(annualStatementGenerationProcessPage.handleGeneratedStatementsApprovalAndUpload(filePath),
				"An error occurred while approving the generated statements and uploading the file.");
	}

	@Test(priority = 5, description = "Verify Statements Forwarded to FSG are Approved", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyStatementsForwardedToFSGApproved() {
		LoggerManager.info("Verifying Statements Forwarded to FSG are Approved");
		TestBase.setExtentReportSettings("Statements Forwarded to FSG Approved", Constants.FUNCTIONAL_TESTING,
				"Verify Statements Forwarded to FSG Approval", "Verifying Statements Forwarded to FSG Approval");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertTrue(annualStatementGenerationProcessPage.handleForwardedStatementsApproval(),
				"Error occurred while forwarding statements for approval.");
	}

	@Test(priority = 6, description = "Verify Statements Mail Note Rejection", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyStatementsMailNoteRejected() {
		LoggerManager.info("Verifying Mail Note Rejection for Statements");
		TestBase.setExtentReportSettings("Statements Mail Note Rejected", Constants.FUNCTIONAL_TESTING,
				"Verify Statements Mail Note Rejection", "Verifying Statements Mail Note Rejection");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertTrue(annualStatementGenerationProcessPage.handleNoteRejectionForStep4(),
				"Error occurred while rejecting the mail note for statements.");
	}

	@Test(priority = 7, description = "Verify Statements Mail Approval", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyStatementsMailApproved() {
		LoggerManager.info("Verifying Statements Mail Approval");
		TestBase.setExtentReportSettings("Statements Mail Approved", Constants.FUNCTIONAL_TESTING,
				"Verify Statements Mail Approval", "Verifying Statements Mail Approval");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertTrue(annualStatementGenerationProcessPage.handleMailedStatementsApproval(),
				"An error occurred during the approval of mailed statements.");
	}

	@Test(priority = 8, description = "Verify Actions Flags", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyActionFlags() {
		LoggerManager.info("Verifying Action Flags");
		TestBase.setExtentReportSettings("Action Flags", Constants.FUNCTIONAL_TESTING, "Verify Action Flags",
				"Verifying Action Flags");
		annualStatementGenerationProcessPage = new AnnualStatementGenerationProcessPage(driver);
		assertEquals(annualStatementGenerationProcessPage.handleActionWithFlags(), "Confirmation");
	}
}