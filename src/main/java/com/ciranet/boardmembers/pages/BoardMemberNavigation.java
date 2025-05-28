package com.ciranet.boardmembers.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class BoardMemberNavigation extends BasePage {

    public BoardMemberNavigation(WebDriver driver) {
        super(driver);
    }

    // Here define the Object definition
    @FindBy(xpath = "//h2[normalize-space()='Announcements']")
    WebElement annoucementLogsPageTitle;

    // For Mail merge module
    @FindBy(xpath = "//h2[normalize-space()='Mail Merge']")
    WebElement mailMergePageTitle;

    // Resident Contact Logs controls
    @FindBy(xpath = "//h2[normalize-space()='Resident Contact Logs']")
    WebElement residentContactLogsPageTitle;

    // Compliance module xpaths are defined here
    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Certified Tracking')]")
    WebElement certifiedTrackingPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Detailed Violations Log')]")
    WebElement detailedViolationsLogPageTitle;

    // Last Inspection Log
    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Last Inspection Log')]")
    WebElement lastInspectionLogPageTitle;

    // Open Violation log
    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Open Violations Log')]")
    WebElement openViolationsLogPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Report a Violation')]")
    WebElement reportAViolationPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Deed Restriction Full Summary')]")
    WebElement restrictionSummaryPageTitle;

    // Compliance module xpath ends here

    // Information Side Nav - components
    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Additional Information')]")
    WebElement additionalInfoPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Amenities and Access Control')]")
    WebElement amenitiesAndAccessControlPageTitle;

    @FindBy(xpath = "//i[contains(@class,'dx-icon dx-icon-menu')]")
    WebElement hamburgerIcon;

    // For Board/Committee Member
    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Board / Committee Members')]")
    WebElement boardCommitteeMembersPageTitle;

    // Calendar
    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'My Calendar')]")
    WebElement myCalendarPageTitle;

    @FindBy(xpath = "//h2[normalize-space()='Actual vs Budget']")
    WebElement frActualVsBudgetPageTitle;

    @FindBy(xpath = "//h2[normalize-space()='Benchmark Report']")
    WebElement frBenchmarkReportPageTitle;

    @FindBy(xpath = "//h2[normalize-space()='Financial Summary']")
    WebElement financialSummaryPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'General Ledger Report')]")
    WebElement generalLedgerReportPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Trial Balance')]")
    WebElement trialBalancePageTitle;

    // My Work Queue navigations
    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Architectural Application')]")
    WebElement architecturalApplicationPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(text(),'Board Approvals')]")
    WebElement boardApprovalsPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(text(),'Maintenance Work Orders')]")
    WebElement maintenanceWorkOrdersPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(text(),'Projects / Tasks')]")
    WebElement projectsTasksPageTitle;

    @FindBy(xpath = "dx-loadindicator-icon")
    WebElement loaderIcon;

    @FindBy(xpath = "//span[normalize-space()='Documents']")
    WebElement documentsSideNav;

    @FindBy(xpath = "//span[contains(.,'Archive')]")
    WebElement archiveSideNav;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Documents')]")
    WebElement archivePageTitle;

    @FindBy(xpath = "//h2[normalize-space()='Property Details']")
    WebElement propertyDetailsPageTitle;

    @FindBy(xpath = "//span[normalize-space()='Reports']")
    WebElement reportsSideNav;

    @FindBy(xpath = "//span[normalize-space()='Move-In Summary']")
    WebElement moveInSummarySideNav;

    @FindBy(xpath = "//h2[normalize-space()='Move-In Summary']")
    WebElement moveInSummaryPageTitle;

    @FindBy(xpath = "//span[normalize-space()='On Demand']")
    WebElement onDemandSideNav;

    @FindBy(xpath = "//h2[normalize-space()='Reports']")
    WebElement onDemandPageTitle;

    @FindBy(xpath = "//span[normalize-space()='Summary - Previous Month']")
    WebElement summaryPrevMonthSideNav;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Operations Summary - Previous Month')]")
    WebElement summaryPrevMonthPageTitle;

    @FindBy(xpath = "(//div//span[contains(.,'CiraBooks Workspace')])[2]")
    WebElement cbWorkspacePageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'AP Expense Detail')]")
    WebElement cbAPExpenseDetailPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'AP Ledger')]")
    WebElement cbAPLedgerPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Aging Summary')]")
    WebElement cbARAgingSummaryPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'AR Ledger')]")
    WebElement cbARLedgerPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Assessment Rules')]")
    WebElement cbARAssessmentRulesPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Customer Aging')]")
    WebElement cbARCustomerAgingPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Delinquency Detail')]")
    WebElement cbARDelinquencyDetailPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Review My Invoices')]")
    WebElement cbMySubInvoicesPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Approved Open AP')]")
    WebElement cbOpenAPPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Search Invoices')]")
    WebElement cbSearchInvoicesPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Submit Invoice/Payment Request')]")
    WebElement cbSubmitInvoicePageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Vendor Aging')]")
    WebElement cbVendorAgingPageTitle;

    @FindBy(xpath = "//span[normalize-space()='New Document Summary']")
    WebElement newDocumentSummarySideNav;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'New Document Summary')]")
    WebElement newDocumentSummaryPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Vendor Management')]")
    WebElement vendorManagementPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Common Lots')]")
    WebElement commonLotsPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Assets')]")
    WebElement communityAssetsPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Community Notes')]")
    WebElement communityNotesPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Enforcement Policy')]")
    WebElement enforcementPolicyPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Community Dashboard')]")
    WebElement graphsAndMetricsPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Community Information')]")
    WebElement infoSummaryPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Insurance')]")
    WebElement insurancePageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Legal Information')]")
    WebElement legalSummaryPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Community Map')]")
    WebElement mapPageTitle;

    @FindBy(xpath = "//h2[@class='page-header'][contains(.,'Resident Directory')]")
    WebElement residentDirectoryPageTitle;

    Navigation navigationSearch = new Navigation(driver);

    private String threadMessage = "Thread was interrupted during sleep: ";


    /** Navigate to Home page
     *
     */
    public boolean navigateHomePage() {
        try {
            LoggerManager.info("Attempting to navigate. Waiting for the Hamburger menu to be visible...");
            waitForElementToBeVisible(hamburgerIcon);

            if (hamburgerIcon.isDisplayed()) {
                LoggerManager.info("Hamburger menu is displayed. Navigation successful.");
                return true;
            } else {
                LoggerManager.warn("Hamburger menu is not displayed. Navigation failed.");
                return false;
            }
        } catch (Exception e) {
            LoggerManager.error("An error occurred during navigation: " + e.getMessage());
            return false;
        }
    }

    /** Method for waiting on the page till page is in ready state
     *
     */
    private void waitForPageToLoad(int timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                        .equals("complete"));
    }

    // Common method to check Page Title is displayed or not for the navigated item WebElement sideNavElement,
    private boolean navigateToPageAndVerifyPageTitle(WebElement pageTitleElement,
                                                     String expectedTitle) {
        try {

            LoggerManager.info("Navigating to menu and validating page title...");

            String actualTitle = pageTitleElement.getText();
            boolean isPageTitleValid = actualTitle.equals(expectedTitle);

            if (isPageTitleValid) {
                LoggerManager.info("Page Title validation passed. Title matches " + expectedTitle + ".");
            } else {
                LoggerManager.warn(
                        "Page Title validation failed. Expected: " + expectedTitle + ", Actual: " + actualTitle + ".");
            }

            return isPageTitleValid;

        } catch (Exception e) {
            logError("navigateToPageAndVerifyPageTitle", e);
            return false;
        }
    }

    private void logError(String methodName, Exception e) {
        LoggerManager.error("An error occurred in '" + methodName + "' method: " + e.getMessage() + e);
    }

    private void timeUnitSleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds); // Sleeps for seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            LoggerManager.error(threadMessage + e.getMessage());
        }
    }
    /** Method to Navigate to the page
     *
     */
    private boolean navigateToPage(By navigationItemXPath, String navigationItemName, String expectedTitle, WebElement pageTitleElement) //,
    //WebElement sideNavElement)
    {
        try {
            LoggerManager.info("Navigating to '" + navigationItemName + "' page.");
            navigationSearch.navigate(navigationItemXPath, navigationItemName); // Perform navigation

            timeUnitSleep(4);

            // Verify if the page title matches the expected title
            return navigateToPageAndVerifyPageTitle(pageTitleElement, expectedTitle);
        } catch (Exception e) {
            logError(navigationItemName + " Navigation", e);
            return false;
        }
    }

    // ======== Communications navigation items start here ===== //
    public boolean navigateToAnnouncementLogs() {
        return navigateToPage(By.xpath("//span[normalize-space()='Announcement Logs']"), "Announcement Logs",
                "Announcements", annoucementLogsPageTitle);
    }

    public boolean navigateToMailMerge() {
        return navigateToPage(By.xpath("//span[contains(text(),'Mail Merge')]"), "Mail Merge", "Mail Merge",
                mailMergePageTitle);
    }

    public boolean navigateToResidentContactLogs() {
        return navigateToPage(By.xpath("//div//span[normalize-space()='Resident Contact Logs']"),
                "Resident Contact Logs", "Resident Contact Logs", residentContactLogsPageTitle);
    }

    // ======== Communications navigation items end here ===== //

    // ======== Compliance navigation items start here ===== //
    public boolean navigateToCertifiedTracking() {
        return navigateToPage(By.xpath("//span[contains(.,'Certified Tracking')]"), "Certified Tracking",
                "Certified Tracking", certifiedTrackingPageTitle);
    }

    public boolean navigateToDetailedViolationLog() {
        return navigateToPage(By.xpath("//span[normalize-space()='Detailed Violations Log']"),
                "Detailed Violations Log", "Detailed Violations Log", detailedViolationsLogPageTitle);
    }

    public boolean navigateToLastInspectionLog() {
        return navigateToPage(By.xpath("//span[normalize-space()='Last Inspection Log']"), "Last Inspection Log",
                "Last Inspection Log", lastInspectionLogPageTitle);

    }

    public boolean navigateToOpenViolationsLog() {
        return navigateToPage(By.xpath("//span[normalize-space()='Open Violations Log']"), "Open Violations Log",
                "Open Violations Log", openViolationsLogPageTitle);
    }

    public boolean navigateToReportAViolation() {
        return navigateToPage(By.xpath("//span[normalize-space()='Report a Violation']"), "Report a Violation",
                "Report a Violation", reportAViolationPageTitle);
    }

    public boolean navigateToRestrictionSummary() {
        return navigateToPage(By.xpath("//span[normalize-space()='Restriction Summary']"), "Restriction Summary",
                "Deed Restriction Full Summary", restrictionSummaryPageTitle);
    }

    // ========== Compliance navigation items end here ========== //

    // ========== Information navigation items start here ========== //

    public boolean navigateToAdditionalInfo() {
        return navigateToPage(By.xpath("//span[normalize-space()='Additional Info']"), "Additional Info",
                "Additional Information", additionalInfoPageTitle);
    }

    public boolean navigateToAmenitiesAccessControl() {
        Boolean isPageTitleDisplayed = navigateToPage(
                By.xpath("//span[normalize-space()='Amenities and Access Control']"), "Amenities and Access Control",
                "Amenities and Access Control", amenitiesAndAccessControlPageTitle);
        clickHamburgerIcon();

        return isPageTitleDisplayed;

    }

    public boolean navigateToBoardCommitteeMember() {
        return navigateToPage(By.xpath("//span[normalize-space()='Board / Committee Members']"),
                "Board / Committee Members", "Board / Committee Members", boardCommitteeMembersPageTitle);
    }

    public boolean navigateToCalendar() {
        return navigateToPage(By.xpath("//span[normalize-space()='Calendar']"), "Calendar", "My Calendar",
                myCalendarPageTitle);
    }

    // For Common Lots navigation item
    public boolean navigateToCommonLots() {
        return navigateToPage(By.xpath("//span[normalize-space()='Common Lots']"), "Common Lots", "Common Lots",
                commonLotsPageTitle);
    }

    // For Community Assets navigation item
    public boolean navigateToCommunityAssets() {
        return navigateToPage(By.xpath("//span[normalize-space()='Community Assets']"), "Community Assets", "Assets",
                communityAssetsPageTitle);

    }

    // Community Notes navigation item
    public boolean navigateToCommunityNotes() {
        return navigateToPage(By.xpath("//span[normalize-space()='Community Notes']"), "Community Notes",
                "Community Notes", communityNotesPageTitle); 
    }

    // Documents - Archive navigation item
    public boolean navigateToDocumentArchive() {
        try {
            LoggerManager.info("Navigating to 'Archive' page.");
            // Navigate to the document Archive menu
            navigationSearch.navigateBySideNavigation(By.xpath("//span[normalize-space()='Documents']"), "Documents");
            waitForElementToBeClickable(documentsSideNav);
            clickElement(documentsSideNav);
            waitForElementToBeClickable(archiveSideNav);
            scrollToElement(archiveSideNav);
            clickElementJS(archiveSideNav);

            waitForPageToLoad(30);

            boolean isPageTitleDisplayed = archivePageTitle.getText().equals("Documents");

            if (isPageTitleDisplayed) {
                LoggerManager.info("Page Title validation passed. Title matches Documents.");
            } else {
                LoggerManager.warn("Page Title validation failed. Title does not match Documents.");
            }

            return isPageTitleDisplayed;
        } catch (Exception e) {
            LoggerManager.error("An error occurred while navigating to Archive: " + e.getMessage());
            return false;
        }
    }

    // Documents - New Document Summary navigation item
    public boolean navigateToNewDocumentSummary() {
        try {
            LoggerManager.info("Navigating to 'New Document Summary' page.");
            // Navigate to the New Document Summary menu
            scrollToElement(newDocumentSummarySideNav);
            clickElementJS(newDocumentSummarySideNav);

            boolean isPageTitleDisplayed = newDocumentSummaryPageTitle.getText().equals("New Document Summary");

            if (isPageTitleDisplayed) {
                LoggerManager.info("Page Title validation passed. Title matches New Document Summary.");
            } else {
                LoggerManager.warn("Page Title validation failed. Title does not match New Document Summary.");
            }

            return isPageTitleDisplayed;
        } catch (Exception e) {
            LoggerManager.error("An error occurred while navigating to New Document Summary: " + e.getMessage());
            return false;
        }
    }

    // For Enforcement policy navigation item
    public boolean navigateToEnforcementPolicy() {
        return navigateToPage(By.xpath("//span[normalize-space()='Enforcement Policy']"), "Enforcement Policy",
                "Enforcement Policy", enforcementPolicyPageTitle);
    }

    // For Graphs and Metrics navigation item
    public boolean navigateToGraphsAndMetrics() {
        Boolean isPageTitleDisplayed = navigateToPage(By.xpath("//span[normalize-space()='Graphs & Metrics']"),
                "Graphs & Metrics", "Community Dashboard", graphsAndMetricsPageTitle);
        waitForPageToLoad(40);
        return isPageTitleDisplayed;

    }

    //For InfoSummary navigation item
    public boolean navigateToInfoSummary() {
        return navigateToPage(By.xpath("//span[normalize-space()='Info Summary']"), "Info Summary",
                "Community Information", infoSummaryPageTitle);

    }

    //For Insurance navigation item
    public boolean navigateToInsurance() {
        return navigateToPage(By.xpath("//span[normalize-space()='Insurance']"), "Insurance", "Insurance",
                insurancePageTitle);

    }

    //For Legal Summary navigation item
    public boolean navigateToLegalSummary() {
        return navigateToPage(By.xpath("//span[normalize-space()='Legal Summary']"), "Legal Summary",
                "Legal Information", legalSummaryPageTitle);

    }

    //For Map navigation item
    public boolean navigateToMap() {
        Boolean isPageTitleDisplayed = navigateToPage(By.xpath("//span[normalize-space()='Map']"), "Map",
                "Community Map", mapPageTitle);

        waitForPageToLoad(30);

        clickHamburgerIcon();

        return isPageTitleDisplayed;
    }

    public void clickHamburgerIcon() {
        try {
            TimeUnit.SECONDS.sleep(2); // Sleeps for 2 seconds
            hamburgerIcon.click();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            LoggerManager.error(threadMessage + e.getMessage());
        }
    }

    // To click on Vendor Management navigation item
    public boolean navigateToVendorManagement() {

        return navigateToPage(By.xpath("//span[normalize-space()='Vendor Management']"), "Vendor Management",
                "Vendor Management", vendorManagementPageTitle);
    }

// For Property navigation item

    public boolean navigateToPropertyDetails() {
        boolean isPageTitleDisplayed = navigateToPage(By.xpath("//span[normalize-space()='Property Details']"),
                "Property Details", "Property Details", propertyDetailsPageTitle);

        clickHamburgerIcon();
        return isPageTitleDisplayed;
    }

    // For Resident Directory navigation item
    public boolean navigateToResidentDirectory() {
        return navigateToPage(By.xpath("//span[normalize-space()='Resident Directory']"), "Resident Directory",
                "Resident Directory", residentDirectoryPageTitle);
    }

    // For Move-In Summary navigation item
    public boolean navigateToMoveInSummary() {

        try {
            LoggerManager.info("Navigating to 'Move-In Summary' page.");
            // Navigate to the Move-In Summary menu
            navigationSearch.navigateBySideNavigation(By.xpath("(//span[normalize-space()='Reports'])[1]"), "Reports");
            waitForInvisibility(loaderIcon);
            scrollToElement(reportsSideNav);
            clickElementJS(reportsSideNav);
            waitForElementToBeClickable(moveInSummarySideNav);
            scrollToElement(moveInSummarySideNav);
            clickElementJS(moveInSummarySideNav);

            boolean isPageTitleDisplayed = moveInSummaryPageTitle.getText().equals("Move-In Summary");

            if (isPageTitleDisplayed) {
                LoggerManager.info("Page Title validation passed. Title matches Move-In Summary.");
            } else {
                LoggerManager.warn("Page Title validation failed. Title does not match Move-In Summary.");
            }

            return isPageTitleDisplayed;
        } catch (Exception e) {
            LoggerManager.error("An error occurred while navigating to Move-In Summary: " + e.getMessage());
            return false;
        }
    }

    // For On Demand Report navigation item
    public boolean navigateToReportsOnDemand() {
        try {
            LoggerManager.info("Navigating to 'On Demand' page.");
            // Navigate to the On Demand menu
            scrollToElement(onDemandSideNav);
            clickElementJS(onDemandSideNav);

            TimeUnit.SECONDS.sleep(4);
            boolean isPageTitleDisplayed = onDemandPageTitle.getText().equals("Reports");

            if (isPageTitleDisplayed) {
                LoggerManager.info("Page Title validation passed. Title matches Reports.");
            } else {
                LoggerManager.warn("Page Title validation failed. Title does not match Reports.");
            }

            return isPageTitleDisplayed;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LoggerManager.error("An error occurred while navigating to Reports: " + e.getMessage());
            return false;
        }
    }

    // For Reports Summary navigation item
    public boolean navigateToReportsSummaryPrevMonth() {

        try {
            LoggerManager.info("Navigating to 'Summary - Previous Month' page.");
            // Navigate to the Summary Previous Month menu
            scrollToElement(summaryPrevMonthSideNav);
            clickElementJS(summaryPrevMonthSideNav);

            waitForPageToLoad(50);
            boolean isPageTitleDisplayed = summaryPrevMonthPageTitle.getText()
                    .equals("Operations Summary - Previous Month");

            if (isPageTitleDisplayed) {
                LoggerManager.info("Page Title validation passed. Title matches Operations Summary - Previous Month.");
            } else {
                LoggerManager.warn(
                        "Page Title validation failed. Title does not match Operations Summary - Previous Month.");
            }
            waitForPageToLoad(50);

            return isPageTitleDisplayed;
        } catch (Exception e) {
            LoggerManager.error("An error occurred while navigating to Summary - Previous Month: " + e.getMessage());
            return false;
        }
    }

    // For CiraBooks navigation item
    public boolean navigateToCiraBooksWorkSpace() {
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            LoggerManager.error(threadMessage + e.getMessage());
        }

        return navigateToPage(By.xpath("//div//span[normalize-space()='CiraBooks Workspace']"), "CiraBooks Workspace",
                "CiraBooks Workspace", cbWorkspacePageTitle);
    }

    // For AP Expense Detail navigation item
    public boolean navigateToCbApExpenseDetail() {
        return navigateToPage(By.xpath("//span[normalize-space()='AP Expense Detail']"), "AP Expense Detail",
                "AP Expense Detail", cbAPExpenseDetailPageTitle);
    }

    // For AP Ledger navigation item
    public boolean navigateToCbApLedger() {
        return navigateToPage(By.xpath("//span[normalize-space()='AP Ledger']"), "AP Ledger", "AP Ledger",
                cbAPLedgerPageTitle);
    }

    // For My Submitted Invoices navigation item
    public boolean navigateToCbApMySubmittedInvoices() {
        return navigateToPage(By.xpath("//span[normalize-space()='My Submitted Invoices']"), "My Submitted Invoices",
                "Review My Invoices", cbMySubInvoicesPageTitle);
    }

    // For Open AP navigation item
    public boolean navigateToCbApOpenAP() {
        return navigateToPage(By.xpath("//span[normalize-space()='Open AP']"), "Open AP", "Approved Open AP",
                cbOpenAPPageTitle);
    }

    // For Search Invoices navigation item
    public boolean navigateToCbApSearchInvoices() {
        return navigateToPage(By.xpath("//span[normalize-space()='Search Invoices']"), "Search Invoices",
                "Search Invoices", cbSearchInvoicesPageTitle);
    }

    //Submit Invoice
    public boolean navigateToCbApSubmitInvoice() {
        return navigateToPage(By.xpath("//span[normalize-space()='Submit Invoice']"), "Submit Invoice",
                "Submit Invoice/Payment Request", cbSubmitInvoicePageTitle);
    }

    //Vendor Aging
    public boolean navigateToCbApVendorAging() {
        return navigateToPage(By.xpath("//span[normalize-space()='Vendor Aging']"), "Vendor Aging", "Vendor Aging",
                cbVendorAgingPageTitle); 
    }

    // For CB - Accounts Payable modules
    public boolean navigateToCbArAgingSummary() {
        return navigateToPage(By.xpath("//span[normalize-space()='AR Aging Summary']"), "AR Aging Summary",
                "Aging Summary", cbARAgingSummaryPageTitle);
    }


    public boolean navigateToCbArLedger() {
        return navigateToPage(By.xpath("//span[normalize-space()='AR Ledger']"), "AR Ledger", "AR Ledger",
                cbARLedgerPageTitle);
    }

    //Assessment Rules
    public boolean navigateToCbArAssessmentRules() {
        return navigateToPage(By.xpath("//span[normalize-space()='Assessment Rules']"), "Assessment Rules",
                "Assessment Rules", cbARAssessmentRulesPageTitle);
    }

    //For Customer Aging navigation item
    public boolean navigateToCbArCustomerAging() {

        return navigateToPage(By.xpath("//span[normalize-space()='Customer Aging']"), "Customer Aging",
                "Customer Aging", cbARCustomerAgingPageTitle);
    }

    //For Delinquency Detail navigation item
    public boolean navigateToCbArDelinquencyDetail() {

        boolean isPageTitleDisplayed = navigateToPage(By.xpath("//span[normalize-space()='Delinquency Detail']"),
                "Delinquency Detail", "Delinquency Detail", cbARDelinquencyDetailPageTitle);
        clickHamburgerIcon();

        return isPageTitleDisplayed;

    }

    // For Actual vs Budget navigation item
    public boolean navigateToFrActualVsBudget() {

        Boolean isPageTitleDisplayed = navigateToPage(By.xpath("//span[normalize-space()='Actual vs Budget']"),
                "Actual vs Budget", "Actual vs Budget", frActualVsBudgetPageTitle);
        clickHamburgerIcon();
        return isPageTitleDisplayed;
    }

    public boolean navigateToFrBenchmarkReport() {
        return navigateToPage(By.xpath("//span[normalize-space()='Benchmark Report']"), "Benchmark Report",
                "Benchmark Report", frBenchmarkReportPageTitle);
    }

    public boolean navigateToFrFinancialSummary() {
        try {
            TimeUnit.SECONDS.sleep(2); // Sleeps for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            LoggerManager.error(threadMessage + e.getMessage());
        }
        return navigateToPage(By.xpath("//span[normalize-space()='Financial Summary']"), "Financial Summary",
                "Financial Summary", financialSummaryPageTitle);
    }

    public boolean navigateToGlGeneralLedgerReport() {
        try {
            TimeUnit.SECONDS.sleep(2); // Sleeps for 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            LoggerManager.error(threadMessage + e.getMessage());
        }
        return navigateToPage(By.xpath("//span[normalize-space()='General Ledger Report']"), "General Ledger Report",
                "General Ledger Report", generalLedgerReportPageTitle);
    }

    public boolean navigateToGlTrialBalance() {
        return navigateToPage(By.xpath("//span[normalize-space()='Trial Balance']"), "Trial Balance", "Trial Balance",
                trialBalancePageTitle);
    }

    public boolean navigateToArchitecturalApplication() {
        return navigateToPage(By.xpath("//span[normalize-space()='Architectural Application']"),
                "Architectural Application", "Architectural Application", architecturalApplicationPageTitle);
    }

    public boolean navigateToBoardApprovals() {
        return navigateToPage(By.xpath("//span[normalize-space()='Board Approvals']"), "Board Approvals",
                "Board Approvals", boardApprovalsPageTitle);
    }

    public boolean navigateToMaintenanceWorkOrders() {
        return navigateToPage(By.xpath("//span[normalize-space()='Maintenance Work Orders']"),
                "Maintenance Work Orders", "Maintenance Work Orders", maintenanceWorkOrdersPageTitle);

    }

    public boolean navigateProjectsTasks() {
        return navigateToPage(By.xpath("//span[normalize-space()='Projects / Tasks']"), "Projects / Tasks",
                "Projects / Tasks", projectsTasksPageTitle);
    }
}