package com.ciranet.community.information.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.ciranet.community.information.pages.CommunityNotesPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class CommunityNotesPageTest extends TestBase {
	
	// Create the CommunityNotesPage object
	CommunityNotesPage communityNotesPage = createPage(CommunityNotesPage.class);
	
	@Test(priority = 0, description = "Verify Community Notes navigation", groups = {Constants.SMOKE_TESTING}, alwaysRun=true)
	public void verifyCommunityNotesNavigation() throws Exception 
	{
		LoggerManager.info("Verifying Community Notes navigation");
		TestBase.setExtentReportSettings("Community Notes", Constants.SMOKE_TESTING, "Verify Community Notes", "Verifying Community Notes navigation");
		communityNotesPage = new CommunityNotesPage(driver);
		String communitySearch= "Herff Ranch";
		assertTrue(communityNotesPage.navigate(communitySearch),"Error navigating to Community Notes");
	}
		
	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyToolBarFullScreen()
	{
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon", "Verifying Fullscreen icon");
		communityNotesPage = new CommunityNotesPage(driver);
		assertTrue(communityNotesPage.toolBarFullScreen(), "Error while Fullscreen icon is not clickable");
	}
	
	@Test(priority = 2, description = "Verify Add Notes", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyAddNewNote() 
	{	
		LoggerManager.info("Verifying Add New Note");
		TestBase.setExtentReportSettings(" Add New Note", Constants.FUNCTIONAL_TESTING, "Verify Add Notes",
				"Verifying Add New Note");
		communityNotesPage = new CommunityNotesPage(driver);
		assertEquals(communityNotesPage.addNote(),"Add a Note");		
	}
	
	@Test(priority = 3, description = "Verify Import Note Template", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyImportNoteTemplate() 
	{	
		LoggerManager.info("Verifying Import Note Template");
		TestBase.setExtentReportSettings("Import Note Template", Constants.FUNCTIONAL_TESTING, "Verify Import Note Template",
				"Verifying Import Note Template");
		assertEquals(communityNotesPage.importNoteTemplate(),"Import Notes From Template");		
	}

	@Test(priority = 4, description = "Verify Edit Note", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyActionMenu() 
	{	
		LoggerManager.info("Verifying Edit Note");
		TestBase.setExtentReportSettings("Edit Note", Constants.FUNCTIONAL_TESTING, "Verify Edit Note",
				"Verifying Edit Note");
		communityNotesPage = new CommunityNotesPage(driver);
		assertEquals(communityNotesPage.editActionButton(),"Edit Note");		
	}
		
	@Test(priority = 5, description = "Verify Notes icon", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyNotes() 
	{	
		LoggerManager.info("Verifying Notes icon");
		TestBase.setExtentReportSettings("Notes icon", Constants.FUNCTIONAL_TESTING, "Notes icon",
				"Verifying Notes icon");
		communityNotesPage = new CommunityNotesPage(driver);
		assertEquals(communityNotesPage.notes(),"New Notes");		
	}
	
	@Test(priority = 6, description = "Verify Logs", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyLogs() 
	{	
		LoggerManager.info("Verifying Logs");
		TestBase.setExtentReportSettings("Logs", Constants.FUNCTIONAL_TESTING, "Verify Logs",
				"Verifying Logs");
		communityNotesPage = new CommunityNotesPage(driver);
		assertEquals(communityNotesPage.logs(),"Action");		
	}
	
	@Test(priority = 7, description = "Verify Attachments", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyAttachements() throws AWTException 
	{	
		LoggerManager.info("Verifying Attachments");
		TestBase.setExtentReportSettings("Attachments", Constants.FUNCTIONAL_TESTING, "Verify Attachments",
				"Verifying Attachments");
		communityNotesPage = new CommunityNotesPage(driver);
		assertEquals(communityNotesPage.attachment(),"Attachments");		
	}	
}