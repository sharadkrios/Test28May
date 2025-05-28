package com.ciranet.community.communications.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.community.communications.pages.MailMergePage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class MailMergePageTest extends TestBase {
	MailMergePage mailMergePage = createPage(MailMergePage.class);

	@Test(priority = 0, description = "Verify Mail Merge navigation", groups = 
		{
			Constants.SMOKE_TESTING }, alwaysRun = true)
	@Parameters("communitySearchText")
	public void verifyMailMergeNavigation(String communitySearchText) {
		LoggerManager.info("Verifying Mail Merge navigation");
		TestBase.setExtentReportSettings("Mail Merge navigation", Constants.SMOKE_TESTING, "Verify Mail Merge",
				"Verifying Mail Merge navigation");
		mailMergePage = new MailMergePage(driver);
		//assertTrue(mailMergePage.navigateToMailMerge(communitySearchText), "Error navigating to Mail Merge page.");
		assertTrue(mailMergePage.navigateToMailMerge(communitySearchText));
	}
/*
	@Test(priority = 1, description = "Verify Mail Merge Dropdown selection", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void validateDropdownSelection() {
		LoggerManager.info("Verifying Mail Merge Dropdown selection");
		TestBase.setExtentReportSettings("Mail Merge Dropdown selection", Constants.FUNCTIONAL_TESTING,
				"Verify Mail Dropdown selection", "Verifying Mail Merge Dropdown selection");
		mailMergePage = new MailMergePage(driver);
		assertTrue(mailMergePage.verifyMailMergeDropdownOptions(),
				"Error 'Mail Merge' dropdown selections are not visible");
	}
	
	@Test(priority = 2, description = "Verify Mail Merge Create Labels button", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLabelsCreation() {
		LoggerManager.info("Verifying mailMerge- Create Labels");
		TestBase.setExtentReportSettings("Mail Merge Create Labels", Constants.FUNCTIONAL_TESTING,
				"Verify Create Labels", "Verifying Create Labels");
		mailMergePage = new MailMergePage(driver);
		assertTrue(mailMergePage.verifyMailMergeLabelsCreation(), "Error 'Create Labels' is not visible");
	}
	
	@Parameters("filePath")
	@Test(priority = 3, description = "Verify Mail Merge Browse button", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void validateMailMergeBrowseAndUpload(String filePath){
		LoggerManager.info("Verifying mailMerge- Browse button");
		TestBase.setExtentReportSettings("Mail Merge Browse button", Constants.FUNCTIONAL_TESTING,
				"Verify Browse and upload file functionality", "Verifying Browse and upload functionality");
		mailMergePage = new MailMergePage(driver);
		assertTrue(mailMergePage.verifyBrowseAndUploadFunctionality(filePath), "Error' Browse' button is not visible");
	}
	
	@Test(priority = 4, description = "Verify Mail Merge View or Save Standard Letter head Template", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void testMailMergeViewOrSaveTemplate() {
		LoggerManager.info("Verifying Mail Merge View or Save Standard Letter head Template");
		TestBase.setExtentReportSettings("Mail Merge View or Save Standard Letter head Template",
				Constants.FUNCTIONAL_TESTING, "Verify View or Save Standard Letter head Template hyperlink",
				"Verifying Mail Merge View or Save Standard Letter head Template");
		mailMergePage = new MailMergePage(driver);
		assertTrue(mailMergePage.validateMailMergeViewOrSaveTemplate(),
				"Error 'View or Save Standard Letterhead Template' hyperlink was not clicked");
	}
	


	@Test(priority = 5, description = "Verify CustomerId hyperlinks", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void testCustomerIdHyperlinkNavigation() {
		LoggerManager.info("Verifying CustomerId hyperlinks");
		TestBase.setExtentReportSettings("CustomerId hyperlinks", Constants.FUNCTIONAL_TESTING,
				"Verify CustomerId hyperlinks", "Verifying CustomerId hyperlinks");
		mailMergePage = new MailMergePage(driver);
		assertTrue(mailMergePage.verifyCustomerIdHyperlinkNavigation(),
				"Error 'CustomerId' hyperlinks are not visible");
	}


	@Test(priority = 6, description = "Verify Combined Owner hyperlinks", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void testCombinedOwnerHyperlinkNavigation() {
		LoggerManager.info("Verifying Combined Owner Hyperlinks");
		TestBase.setExtentReportSettings("Combined Owner hyperlinks", Constants.FUNCTIONAL_TESTING,
				"Verify Combined Owner hyperlinks", "Verifying Combined Owner hyperlinks");
		mailMergePage = new MailMergePage(driver);
		assertTrue(mailMergePage.verifyCombinedOwnerHyperlinkNavigation(), "Error 'Combined Owner' hyperlinks are not visible.");
	}
*/
}
