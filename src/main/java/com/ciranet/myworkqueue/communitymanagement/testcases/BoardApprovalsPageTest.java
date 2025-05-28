package com.ciranet.myworkqueue.communitymanagement.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.communitymanagement.pages.BoardApprovalsPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class BoardApprovalsPageTest extends TestBase {

	// Create the BoardApprovalsPage object
	BoardApprovalsPage boardApprovalsPage = createPage(BoardApprovalsPage.class);

	@Test(priority = 0, description = "Verify Board Approval navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyBoardApprovalsNavigation() {
		LoggerManager.info("Verifying Board Approval navigation");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		TestBase.setExtentReportSettings("Board Approval", Constants.SMOKE_TESTING, "Verify Board Approval",
				"Verifying Board Approvals navigation");
		assertTrue(boardApprovalsPage.navigate(), "Error navigate to Board Approvals");
	}

	@Test(priority = 1, description = "Verify View", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyViewBoardApprovalInformation() {
		LoggerManager.info("Verify View");
		TestBase.setExtentReportSettings("View", Constants.FUNCTIONAL_TESTING, "Verify View", "Verifying View");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.viewBoardApprovalInformation(), "Error clicking on View button");
	}

	@Test(priority = 2, description = "Verify Approve", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyApprove() {
		LoggerManager.info("Verify Approve");
		TestBase.setExtentReportSettings("Approve", Constants.FUNCTIONAL_TESTING, "Verify Approve",
				"Verifying Approve");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.approve(), "Error clicking on Approve button");
	}

	@Test(priority = 3, description = "Verify Approve with Stipulation", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyApproveWithStipulationButton() {
		LoggerManager.info("Verify Approve with Stipulation");
		TestBase.setExtentReportSettings("Approve with Stipulation", Constants.FUNCTIONAL_TESTING,
				"Verify Approve with Stipulation", "Verifying Approve with Stipulation");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.approveWithStipulation(), "Error clicking on Approve with Stipulation");
	}

	@Test(priority = 4, description = "Verify Review", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyReview() {
		LoggerManager.info("Verify Review");
		TestBase.setExtentReportSettings("Review", Constants.FUNCTIONAL_TESTING, "Verify Review", "Verifying Review");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.review(), "Error clicking on Review");
	}

	@Test(priority = 5, description = "Verify Den Request Additional Information", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyDenyRequestAdditionalInformation() {
		LoggerManager.info("Verify Den Request Additional Information");
		TestBase.setExtentReportSettings("Den Request Additional Information", Constants.FUNCTIONAL_TESTING,
				"Verify Den Request Additional Information", "Verifying Den Request Additional Information");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.denyRequestAdditionalInformation(),
				"Error clicking on Den Request Additional Information");
	}

	@Test(priority = 6, description = "Verify Documents", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyDocuments() {
		LoggerManager.info("Verify Documents");
		TestBase.setExtentReportSettings("Documents", Constants.FUNCTIONAL_TESTING, "Verify Documents",
				"Verifying Documents");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.documents(), "Error clicking on Documents");
	}

	@Test(priority = 7, description = "Verify Logs", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLogs() {
		LoggerManager.info("Verify Logs");
		TestBase.setExtentReportSettings("Logs", Constants.FUNCTIONAL_TESTING, "Verify Logs", "Verifying Logs");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.logs(), "Error clicking on Logs");
	}

	@Test(priority = 8, description = "Verify Workflow Details", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyWorkflowDetails() {
		LoggerManager.info("Verify Workflow Details");
		TestBase.setExtentReportSettings("Workflow Details", Constants.FUNCTIONAL_TESTING, "Verify Workflow Details",
				"Verifying Workflow Details");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.workflowDetails(), "Error clicking on Workflow Details");
	}

	@Test(priority = 9, description = "Verify Fullscreen", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolbarFullScreen() {
		LoggerManager.info("Verify Fullscreen");
		TestBase.setExtentReportSettings("Fullscreen", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen",
				"Verifying Fullscreen");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.toolBarFullScreen(), "Error while clicking on Fullscreen icon");
	}

	@Test(priority = 10, description = "Verify Normalscreen", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolBarNormalScreen() {
		LoggerManager.info("Verify Normalscreen");
		TestBase.setExtentReportSettings("Normalscreen", Constants.FUNCTIONAL_TESTING, "Verify Normalscreen",
				"Verifying Normalscreen");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.toolBarNormalScreen(), "Error while clicking on Normalscreen icon");

	}

	@Test(priority = 11, description = "Verify Switching tab", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySwitchTab() {
		LoggerManager.info("Verify Switching tab");
		TestBase.setExtentReportSettings("Switching tab", Constants.FUNCTIONAL_TESTING, "Verify Switching tab",
				"Verifying Switching tab");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertTrue(boardApprovalsPage.switchTab(), "Error while switching the tab");
	}

	@Test(priority = 12, description = "Verify Column Chooser", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyColumnChooser() {
		LoggerManager.info("Verify Column Chooser");
		TestBase.setExtentReportSettings("Column Chooser", Constants.FUNCTIONAL_TESTING, "Verify Column Chooser",
				"Verifying Column Chooser");
		boardApprovalsPage = new BoardApprovalsPage(driver);
		assertEquals(boardApprovalsPage.columnChooser(), "Column Chooser");
	}	
	
}
