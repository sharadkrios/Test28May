package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.configurations.pages.ProcessTrackerPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ProcessTrackerPageTest extends TestBase {
	
	// Create the ProcessTrackerPage object
	ProcessTrackerPage processTrackerPage = createPage(ProcessTrackerPage.class);
		
	@Test(priority = 0, description = "Verify Process Tracker navigation", groups = {Constants.SMOKE_TESTING}, alwaysRun=true)
	public void verifyConfigProcessTrackerNavigation() 
	{
		LoggerManager.info("Verifying Process Tracker navigation");	
		TestBase.setExtentReportSettings("Process Tracker",Constants.SMOKE_TESTING, "Verify Process Tracker", "Verifying Process Tracker navigation");
		processTrackerPage = new ProcessTrackerPage(driver);
		assertTrue(processTrackerPage.navigate(),"Error navigate to  Process Tracker");	
	}

	@Test(priority = 1, description = "Verify Community Auto Close & Report Generation", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyCommunityAutoCloseReportGeneration() 
	{
		LoggerManager.info("Verifying Community Auto Close & Report Generation");
		TestBase.setExtentReportSettings("Community Auto Close & Report Generation",Constants.FUNCTIONAL_TESTING, "Verify Community Auto Close & Report Generation", "Verifying Community Auto Close & Report Generation");
		processTrackerPage = new ProcessTrackerPage(driver);
		assertEquals(processTrackerPage.communityAutoCloseReportGeneration(),"Community Auto Close & Report Generation - Global");			
	}

	@Test(priority = 2, description = "Verify Financial Package Configuration", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyFinancialPackageConfiguration()
	{
		LoggerManager.info("Verifying Financial Package Configuration");
		TestBase.setExtentReportSettings("Financial Package Configuration",Constants.FUNCTIONAL_TESTING, "Verify Financial Package Configuration", "Verifying Financial Package Configuration");
		processTrackerPage = new ProcessTrackerPage(driver);
		assertEquals(processTrackerPage.financialPackageConfiguration(),"Financial Package Configuration - Global");		
	}
	
	@Test(priority = 3, description = "Verify Process Tracker Configuration", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun=true)
	public void verifyProcessTrackerConfiguration() 
	{
		LoggerManager.info("Verifying Process Tracker Configuration");
		TestBase.setExtentReportSettings("Process Tracker Configuration",Constants.FUNCTIONAL_TESTING, "Verify Process Tracker Configuration", "Verifying Process Tracker Configuration");	
		processTrackerPage = new ProcessTrackerPage(driver);
		assertEquals(processTrackerPage.processTrackerConfiguration(),"Process Tracker Configuration - Global");	
	}	
}

