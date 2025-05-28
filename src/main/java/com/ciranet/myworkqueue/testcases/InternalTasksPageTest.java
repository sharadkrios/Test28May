package com.ciranet.myworkqueue.testcases;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.pages.InternalTasksPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class InternalTasksPageTest extends TestBase 
{
	// Create the InternalTasksPageTest object
	InternalTasksPage internalTasksPage = createPage(InternalTasksPage.class);
	
	@Test(priority = 0, description = "Verify Internal Task Page navigation", groups = { Constants.SMOKE_TESTING }, alwaysRun=true)
	public void verifyInternalTasksPageNavigation() 
	{
		LoggerManager.info("Verifying Internal Task Page navigation");
		TestBase.setExtentReportSettings("Internal Task navigation Test", Constants.SMOKE_TESTING, "Verify Internal Tasks navigation", "Verifying Internal Task navigation");
		internalTasksPage = new InternalTasksPage(driver);
		
		assertTrue(internalTasksPage.navigate(),"Error navigating to Internal Task Page");
	}

	@Test(priority = 1, description = "Verify Help functionality", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyHelpInternalTask() 
	{
		LoggerManager.info("Verifying Internal Task Help functionality");
		TestBase.setExtentReportSettings("Internal Task  Help Test", Constants.FUNCTIONAL_TESTING, "Verify Internal task Help", "Verifying Internal Task Help functionality");
		internalTasksPage = new InternalTasksPage(driver);
		assertTrue(internalTasksPage.helpInternalTask(),"Error while clicking on Help icon");
	}
	
	@Test(priority = 2, description = "Verify Toolbar - Column Chooser functionality", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyColumnChooserOption() 
	{
		LoggerManager.info("Verifying Internal Task - Column Chooser");
		TestBase.setExtentReportSettings("Column Chooser Test", Constants.FUNCTIONAL_TESTING, "Verify Column Chooser functionality", "Verifying Column chooser functionality");
		internalTasksPage = new InternalTasksPage(driver);
		assertTrue(internalTasksPage.columnChooserClick(),"Error while clicking on the Column chooser");
	}
	
	@Test(priority = 3, description = "Verify Toolbar - Full screen option click", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyToolbarFullScreenOption() 
	{
		LoggerManager.info("Verifying Internal Task - Full screen");
		TestBase.setExtentReportSettings("Full Screen test", Constants.FUNCTIONAL_TESTING, "Verify Full Screen functionality", "Verifying Full Screen functionality");
		internalTasksPage = new InternalTasksPage(driver);
		assertTrue(internalTasksPage.toolbarFullScreen(), "Error while displaying grid data in Fullscreen");
	}
	
	@Test(priority = 4, description = "Verify Toolbar - Normal screen option click", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifytoolBarNormalScreenOption() 
	{
		LoggerManager.info("Verifying Internal Task - Normal screen click");
		TestBase.setExtentReportSettings("Verifying Normal Screen", Constants.FUNCTIONAL_TESTING, "Verify Normal Screen functionality", "Verifying Normal screenfunctionality");
		internalTasksPage = new InternalTasksPage(driver);
		assertTrue(internalTasksPage.toolBarNormalScreen(),"Error clicking on Normal icon");
	}
	
	@Test(priority = 5, description = "Verify Email Setting", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyEmailSetting() 
	{
		LoggerManager.info("Verifying Email Setting");
		TestBase.setExtentReportSettings("Verify Email Setting test", Constants.FUNCTIONAL_TESTING, "Verify Email Settings popup display", "Verifying Email Setting popup display");
		internalTasksPage = new InternalTasksPage(driver);
		assertTrue(internalTasksPage.emailSetting(), "Error in opening Email Settings");
	}
	
	@Test(priority = 6, description = "Verify Toolbar - Expand And Collapse", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyExpandCollapseOption() 
	{
		LoggerManager.info("Verifying Expand and Collapse");
		TestBase.setExtentReportSettings("Verifying Expand Collapse", Constants.FUNCTIONAL_TESTING, "Verify Expand and Collapse functionality", "Verifying Expand and Collapse");
		assertTrue(internalTasksPage.expandCollapseClick(),"Error in Expand and collapse functionality");
	}
	  
	@Test(priority = 7, description = "Verify Active Filter selection", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyActiveFilterSelect() 
	{
		LoggerManager.info("Verifying Active Filter functionality");
		TestBase.setExtentReportSettings("Verifying Active Filter selection as All Tasks", Constants.FUNCTIONAL_TESTING, "Verify Active Filter selection as All Tasks", "Verifying Active Filter selection");
		internalTasksPage = new InternalTasksPage(driver);
		assertTrue(internalTasksPage.activeFilterSelection(),"Error in Filter selection as All Tasks");
	}
	
	@Test(priority = 8, description = "Verify Edit Record and Cancel", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEditAndCancel() 
	{
		LoggerManager.info("Verify Edit and Cancel functionality");
		TestBase.setExtentReportSettings("Edit record and Cancel Test", Constants.FUNCTIONAL_TESTING, "Verify Edit and Cancel", "Verifying Edit and Cancel");
		internalTasksPage = new InternalTasksPage(driver);
		assertTrue(internalTasksPage.verifyCancelInEditRecord(),"Error while Edit and Cancel functionality");
	}
	
	@Test(priority = 9, description = "Verify Closed Within Days Textbox", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyDaysTextbox() 
	{
		LoggerManager.info("Verify Completed / Closed tasks Within Days");
		TestBase.setExtentReportSettings("Verify Completed / Closed Within Days Textbox", Constants.FUNCTIONAL_TESTING, "Verify Completed / Closed within Days Text", "Verifying Completed / Closed Within Days Testbox");
		internalTasksPage = new InternalTasksPage(driver);
		assertTrue(internalTasksPage.closedWithinDaysTextbox(),"Error while checking Closed Within textbox functionality");
	}
}