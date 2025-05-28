package com.ciranet.boardmembers.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ciranet.boardmembers.pages.BoardMemberNavigation;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class BoardMemberNavigationTest extends TestBase {
	// Create the object
	private BoardMemberNavigation boardMemberHomePage;

	@BeforeClass
	public void initilizeClass() {
		LoggerManager.info("Setting up BoardMemberNavigationTests...");
		boardMemberHomePage = createPage(BoardMemberNavigation.class);
	}

	// Helper method runNavigationTest to reduce code duplication
	private void runNavigationTest(String testName, String description, String group, Runnable testLogic) {
		LoggerManager.info(description);
		TestBase.setExtentReportSettings(testName, group, description, description);
		try {
			testLogic.run();
		} catch (AssertionError e) {
			LoggerManager.error("Assertion failed: " + e.getMessage());
			throw e;
		} catch (Exception e) {
			LoggerManager.error("Exception occurred: " + e.getMessage());
			throw new IllegalStateException("Unexpected test execution error.", e);
		}
	}

	@Test(priority = 0, description = "Verify Home Page navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyHomePageNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Home Page navigation test", "Verify Home Page navigation", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateHomePage(),
						"Error occurred while navigating to BoardMember Home Page"));
	}

	// ========== Communications Side navigation items Tests ========== //

	@Test(priority = 1, description = "Verify Announcement Logs Navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyAnnouncementLogsNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Announcement Logs navigation test", "Verify Announcement Logs navigation",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToAnnouncementLogs(),
						"Error occurred while navigating to Announcement Logs"));
	}

	@Test(priority = 2, description = "Verify Mail Merge Navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyMailMergeNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Mail Merge navigation test", "Verify Mail Merge Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToMailMerge(),
						"Error occurred while navigating to Mail Merge"));
	}

	@Test(priority = 3, description = "Verify Resident Contact Logs Navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyResidentContactLogsNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Resident Contact Logs navigation test", "Verify Resident Contact Logs Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToResidentContactLogs(),
						"Error occurred while navigating to Resident Contact Logs"));
	}

	// ========== Compliance Side navigation items Tests ========== //

	@Test(priority = 4, description = "Verify Certified Tracking Navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCertifiedTrackingNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Certified Tracking navigation test", "Verify Certified Tracking Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToCertifiedTracking(),
						"Error occurred while navigating to Certified Tracking"));
	}

	@Test(priority = 5, description = "Verify Detailed Violation Log Navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyDetailedViolationLogNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Detailed Violation Log navigation test", "Verify Detailed Violation Log Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToDetailedViolationLog(),
						"Error occurred while navigating to Detailed Violation Log"));
	}

	@Test(priority = 6, description = "Verify Last Inspection Log Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyLastInspectionLogNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Last Inspection Log navigation test", "Verify Last Inspection Log Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToLastInspectionLog(),
						"Error occurred while navigating to Last Inspection Log"));
	}

	@Test(priority = 7, description = "Verify Open Violations Log Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyOpenViolationsLog() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Open Violations Log navigation test", "Verify Open Violations Log Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToOpenViolationsLog(),
						"Error occurred while navigating to Open Violations Log"));
	}

	@Test(priority = 8, description = "Verify Report A Violation Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyReportAViolation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Report A Violation navigation test", "Verify Report A Violation Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToReportAViolation(),
						"Error occurred while navigating to Report A Violation"));
	}

	@Test(priority = 9, description = "Verify Restriction Summary Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyRestrictionSummary() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Restriction Summary navigation test", "Verify Restriction Summary Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToRestrictionSummary(),
						"Error occurred while navigating to Restriction Summary"));
	}

	// =========== Compliance navigation items end here ========== //

	// =========== Information navigation items start here ========== //

	@Test(priority = 10, description = "Verify Additional Info Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyAdditionalInfoNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Additional Info navigation test", "Verify Additional Info Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToAdditionalInfo(),
						"Error occurred while navigating to Additional Info"));
	}

	@Test(priority = 11, description = "Verify Amenities And Access Control Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyAmenitiesAccessControlNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Amenities and Access Control navigation test", "Verify Amenities and Access Control Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToAmenitiesAccessControl(),
						"Error occurred while navigating to Amenities and Access Control"));
	}

	@Test(priority = 12, description = "Verify Board / Committee Members Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyBoardCommitteeMembersNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Board / Committee Members navigation test", "Verify Board / Committee Members Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToBoardCommitteeMember(),
						"Error occurred while navigating to Board / Committee Members"));
	}

	@Test(priority = 13, description = "Verify Calendar Page", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCalendarNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Calendar navigation test", "Verify Calendar Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCalendar(),
						"Error occurred while navigating to Calendar"));
	}

	@Test(priority = 14, description = "Verify Common Lots Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCommonLotsNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Common Lots navigation test", "Verify Common Lots Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCommonLots(),
						"Error occurred while navigating to Common Lots"));
	}

	@Test(priority = 15, description = "Verify Community Assets Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCommunityAssetsNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Community Assets navigation test", "Verify Community Assets Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCommunityAssets(),
						"Error occurred while navigating to Community Assets"));
	}

	@Test(priority = 16, description = "Verify Community Notes Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCommunityNotesNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Community Notes navigation test", "Verify Community Notes Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCommunityNotes(),
						"Error occurred while navigating to Community Notes"));
	}

	@Test(priority = 17, description = "Verify Documents Archive Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyDocumentsArchiveNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Documents Archive navigation test", "Verify Documents Archive Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToDocumentArchive(),
						"Error occurred while navigating to Documents Archive"));
	}

	@Test(priority = 18, description = "Verify New Document Summary Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyNewDocumentSummaryNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Documents Summary navigation test", "Verify New Document Summary Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToNewDocumentSummary(),
						"Error occurred while navigating to New Document Summary"));
	}

	@Test(priority = 19, description = "Verify Enforcement Policy Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyEnforcementPolicyNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Enforcement Policy navigation test", "Verify Enforcement Policy Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToEnforcementPolicy(),
						"Error occurred while navigating to Enforcement Policy"));
	}

	@Test(priority = 20, description = "Verify Graphs & Metrics Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyGraphsAndMetricsNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Graphs & Metrics navigation test", "Verify Graphs & Metrics Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToGraphsAndMetrics(),
						"Error occurred while navigating to Graphs & Metrics"));
	}

	@Test(priority = 21, description = "Verify Info Summary Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyInfoSummaryNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Info Summary navigation test", "Verify Info Summary Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToInfoSummary(),
						"Error occurred while navigating to Info Summary"));
	}

	@Test(priority = 22, description = "Verify Insurance Page", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyInsuranceNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Insurance navigation test", "Verify Insurance Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToInsurance(),
						"Error occurred while navigating to Insurance"));
	}

	@Test(priority = 23, description = "Verify Legal Summary Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyLegalSummaryNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Legal Information navigation test", "Verify Legal Information Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToLegalSummary(),
						"Error occurred while navigating to Legal Information"));
	}

	@Test(priority = 24, description = "Verify Map Page", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyMapNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Community Map navigation test", "Verify Community Map Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToMap(),
						"Error occurred while navigating to Community Map"));
	}

	@Test(priority = 25, description = "Verify Vendor Management Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyVendorManagementNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Vendor Management navigation test", "Verify Vendor Management Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToVendorManagement(),
						"Error occurred while navigating to Vendor Management"));
	}

	@Test(priority = 26, description = "Verify Property Details Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyPropertyDetailsNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Property Details navigation test", "Verify Property Details Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToPropertyDetails(),
						"Error occurred while navigating to Property Details"));
	}

	@Test(priority = 27, description = "Verify Resident Directory Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyResidentDirectoryNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Resident Directory navigation test", "Verify Resident Directory Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToResidentDirectory(),
						"Error occurred while navigating to Resident Directory"));
	}

	@Test(priority = 28, description = "Verify Reports - Move-In-Summary Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyMoveInSummaryNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Reports Move-In-Summary navigation test", "Verify Move-In-Summary Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToMoveInSummary(),
						"Error occurred while navigating to Move-In-Summary"));
	}

	@Test(priority = 29, description = "Verify Reports - On Demand Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyOnDemandNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Reports-On Demand navigation test", "Verify Reports-On Demand Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToReportsOnDemand(),
						"Error occurred while navigating to Reports-On Demand"));
	}

	@Test(priority = 30, description = "Verify Reports - Summary Previous Month Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifySummaryPreviousMonthNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Reports-Summary Previous Month navigation test",
				"Verify Reports-Summary Previous Month Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToReportsSummaryPrevMonth(),
						"Error occurred while navigating to Reports-Summary Previous Month"));

	}

	// ========== Cirabooks navigation items start here

	@Test(priority = 31, description = "Verify Cirabooks WorkSpace Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCiraBooksWorkspace() {

		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Cirabooks Workspace navigation test", "Verify Cirabooks Workspace Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToCiraBooksWorkSpace(),
						"Error occurred while navigating to Cirabooks Workspace"));
	}

	@Test(priority = 32, description = "Verify AP Expense Detail Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCBAPExpenseDetailNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Cirabooks AP Expense Detail navigation test", "Verify AP Expense Detail Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToCbApExpenseDetail(),
						"Error occurred while navigating to AP Expense Detail"));
	}

	@Test(priority = 33, description = "Verify AP Ledger Page", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCBApLedgerMenu() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Cirabooks AP Ledger navigation test", "Verify AP Ledger Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbApLedger(),
						"Error occurred while navigating to AP Ledger"));
	}

	@Test(priority = 34, description = "Verify My Submitted Invoices Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCBMySubmittedInvoicesNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Cirabooks My Submitted Invoices navigation test", "Verify My Submitted Invoices Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToCbApMySubmittedInvoices(),
						"Error occurred while navigating to My Submitted Invoices"));
	}

	@Test(priority = 35, description = "Verify Open AP Page", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCBOpenAPNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Cirabooks Open AP navigation test", "Verify Open AP Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbApOpenAP(),
						"Error occurred while navigating to Open AP"));
	}

	@Test(priority = 36, description = "Verify Search Invoices Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCBAPSearchInvoicesNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Search Invoices navigation test", "Verify Search Invoices Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbApSearchInvoices(),
						"Error occurred while navigating to Search Invoices"));
	}

	@Test(priority = 37, description = "Verify Submit Invoice Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCBAPSubmitInvoiceNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Submit Invoice navigation test", "Verify Submit Invoice Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbApSubmitInvoice(),
						"Error occurred while navigating to Submit Invoice"));
	}

	@Test(priority = 38, description = "Verify Vendor Aging Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCiraBooksVendorAgingNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Vendor Aging navigation test", "Verify Vendor Aging Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbApVendorAging(),
						"Error occurred while navigating to Vendor Aging"));
	}

	@Test(priority = 39, description = "Verify AR Aging Summary Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCBARAgingSummaryNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("AR Aging Summary navigation test", "Verify AR Aging Summary Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbArAgingSummary(),
						"Error occurred while navigating to AR Aging Summary"));
	}

	@Test(priority = 40, description = "Verify AR Ledger  Page", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCiraBookARLedgerNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("AR Ledger navigation test", "Verify AR Ledger Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbArLedger(),
						"Error occurred while navigating to AR Ledger"));
	}

	@Test(priority = 41, description = "Verify Assessment Rules Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCiraBookARAssessmentRulessNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Assessment Rules navigation test", "Verify Assessment Rules Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbArAssessmentRules(),
						"Error occurred while navigating to Assessment Rules"));
	}

	@Test(priority = 42, description = "Verify Customer Aging Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCiraBookARCustomerAgingNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Customer Aging navigation test", "Verify Customer Aging Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToCbArCustomerAging(),
						"Error occurred while navigating to Customer Aging"));
	}

	@Test(priority = 43, description = "Verify Delinquency Detail Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCiraBookARDelinquencyDetailNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Delinquency Detail navigation test", "Verify Delinquency Detail Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToCbArDelinquencyDetail(),
						"Error occurred while navigating to Delinquency Detail"));
	}

	@Test(priority = 44, description = "Verify Actual Vs Budget Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyFRActualVsBudgetNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Actual Vs Budget navigation test", "Verify Actual Vs Budget Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToFrActualVsBudget(),
						"Error occurred while navigating to Actual Vs Budget"));
	}

	@Test(priority = 45, description = "Verify Benchmark Report Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyBenchmarkReportNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Benchmark Report navigation test", "Verify Benchmark Report Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToFrBenchmarkReport(),
						"Error occurred while navigating to Benchmark Report"));
	}

	@Test(priority = 46, description = "Verify Financial Summary Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyFinancialSummaryNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Financial Summary navigation test", "Verify Financial Summary Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToFrFinancialSummary(),
						"Error occurred while navigating to Financial Summary"));
	}

	@Test(priority = 47, description = "Verify General Ledger Report Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyGLReportNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("General Ledger Report navigation test", "Verify General Ledger Report Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToGlGeneralLedgerReport(),
						"Error occurred while navigating to General Ledger Report"));
	}

	@Test(priority = 48, description = "Verify Trial Balance Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyGLTrialBalance() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Trial Balance navigation test", "Verify Trial Balance Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToGlTrialBalance(),
						"Error occurred while navigating to Trial Balance"));
	}

	@Test(priority = 49, description = "Verify Architectural Application Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyArchitecturalApplicationNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Architectural Application navigation test", "Verify Architectural Application Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToArchitecturalApplication(),
						"Error occurred while navigating to Architectural Application"));
	}

	@Test(priority = 50, description = "Verify Board Approvals Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifymyBoardApprovalsNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Board Approvals navigation test", "Verify Board Approvals Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateToBoardApprovals(),
						"Error occurred while navigating to Board Approvals"));
	}

	@Test(priority = 51, description = "Verify Maintenance Work Orders Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyMaintenanceWorkOrdersNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Maintenance Work Orders navigation test", "Verify Maintenance Work Orders Page",
				Constants.SMOKE_TESTING, () -> assertTrue(boardMemberHomePage.navigateToMaintenanceWorkOrders(),
						"Error occurred while navigating to Maintenance Work Orders"));
	}

	@Test(priority = 52, description = "Verify Projects / Tasks Page", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyProjectsTasksNavigation() {
		boardMemberHomePage = new BoardMemberNavigation(driver);
		runNavigationTest("Projects / Tasks navigation test", "Verify Projects / Tasks Page", Constants.SMOKE_TESTING,
				() -> assertTrue(boardMemberHomePage.navigateProjectsTasks(),
						"Error occurred while navigating to Projects / Tasks"));
	}
}
