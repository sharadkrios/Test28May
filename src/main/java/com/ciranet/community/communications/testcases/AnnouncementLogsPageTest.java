package com.ciranet.community.communications.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.community.communications.pages.AnnouncementLogsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class AnnouncementLogsPageTest extends TestBase 
{
	
	AnnouncementLogsPage announcementLogsPage = createPage(AnnouncementLogsPage.class);
		
	@Test(priority = 0, description = "Verify Announcements Logs navigation", groups = {Constants.SMOKE_TESTING}, alwaysRun=true)
	@Parameters("communitySearchText")
	public void verifyAnnouncementsLogsNavigation(String communitySearchText)
	{
		LoggerManager.info("Verifying Announcements Logs navigation");
		TestBase.setExtentReportSettings("Announcements Logs", Constants.SMOKE_TESTING, "Verify Announcements Logs", "Verifying Announcements Logs navigation");
		announcementLogsPage = new AnnouncementLogsPage(driver);
		announcementLogsPage.communitySearchTextFromParameter=communitySearchText;
		assertTrue(announcementLogsPage.navigateToAnnouncementLogs(communitySearchText), "Error navigating to Announcements Logs Page");
	}

	@Test(priority = 1, description = "Verify tab switching", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyAnnouncementsLogsTabSwitch() 
	{
		LoggerManager.info("Verifying tab switching");
		TestBase.setExtentReportSettings("Tab switching", Constants.FUNCTIONAL_TESTING, "Verify Tab switching", "Verifying Tab switching");
		announcementLogsPage = new AnnouncementLogsPage(driver);
		assertTrue(announcementLogsPage.verifyAnnouncementsLogsTabSwitch(), "Error: 'Announcements' tab switching functionality is not functioning properly");
	}

	@Test(priority = 2, description = "Verify Add New Announcement", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyNewAnnouncementAddition() 
	{
		LoggerManager.info("Verifying Add New Announcement button");
		TestBase.setExtentReportSettings("Add New Announcement", Constants.FUNCTIONAL_TESTING, "Verify Add New Announcement", "Verifying Add New Announcement");
		announcementLogsPage = new AnnouncementLogsPage(driver);
		assertTrue(announcementLogsPage.verifyNewAnnouncementAddition(), "Error: 'Add New Announcement' button is not clickable");
	}

	@Test(priority = 3, description = "Verify Edit Announcement", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyAnnouncementEditing() 
	{
		LoggerManager.info("Verifying Edit Announcement");
		TestBase.setExtentReportSettings("Edit Announcement", Constants.FUNCTIONAL_TESTING, "Verify Edit Announcement", "Verifying Edit Announcement");
		announcementLogsPage = new AnnouncementLogsPage(driver);
		assertTrue(announcementLogsPage.verifyAnnouncementEditing(), "Error: 'Announcement updated successfully' confirmation message is not displayed");
	}

	@Test(priority = 4, description = "Verify Delete Announcement", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyAnnouncementDeletion() 
	{
		LoggerManager.info("Verifying Delete Announcement");
		TestBase.setExtentReportSettings("Delete Announcement", Constants.FUNCTIONAL_TESTING, "Verify Delete Announcement ", "Verifying Delete Announcement");
		announcementLogsPage = new AnnouncementLogsPage(driver);
		assertTrue(announcementLogsPage.verifyAnnouncementDeletion(), "Error: 'Announcement updated successfully' confirmation message is not clickable");
	}

	@Test(priority = 5, description = "Verify Help icon", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyHelpButtonFunctionality() 
	{
		LoggerManager.info("Verifying Help");
		TestBase.setExtentReportSettings("Help icon", Constants.FUNCTIONAL_TESTING, "Verify Help icon", "Verifying Help icon");
		announcementLogsPage = new AnnouncementLogsPage(driver);
		assertTrue(announcementLogsPage.verifyHelpButtonFunctionality(),"Error: 'Help' icon for Announcement Logs is not clickable");
	}
}