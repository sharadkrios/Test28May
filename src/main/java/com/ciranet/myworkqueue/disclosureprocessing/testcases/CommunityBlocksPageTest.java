package com.ciranet.myworkqueue.disclosureprocessing.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.disclosureprocessing.pages.CommunityBlocksPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class CommunityBlocksPageTest  extends TestBase
{
	// Create the CommunityBlocksPage object
	CommunityBlocksPage communityBlocksPage = createPage(CommunityBlocksPage.class);

	@Test(priority = 0, description = "Verify Community Blocks navigation", groups = { Constants.SMOKE_TESTING }, alwaysRun=true)
	public void verifyCommunityBlocksNavigation()
	{
		LoggerManager.info("Verifying Community Blocks navigation");
		TestBase.setExtentReportSettings("Community Blocks", Constants.SMOKE_TESTING, "Verify Community Blocks", "Verifying Community Blocks navigation");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertTrue(communityBlocksPage.navigate(),"Error navigate to Community Blocks");
	}

	@Test(priority = 1, description = "Verify Column Chooser", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyColumnChooserClick() {

		LoggerManager.info("Verifying Column chooser");
		TestBase.setExtentReportSettings("Column Chooser Test", Constants.FUNCTIONAL_TESTING, "Verify Column Chooser Title", "Verifying Column Chooser Page Title");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertEquals(communityBlocksPage.columnChooserClick(),"Column Chooser");
	}

	@Test(priority = 2, description = "Verify Fullscreen icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyToolBarFullScreen()
	{
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon", "Verifying Fullscreen icon");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertTrue(communityBlocksPage.toolBarFullScreen(), "Error while Fullscreen icon is not clickable");
	}

	@Test(priority = 3, description = "Verify Export to Excel icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyExportToExcel()
	{
		LoggerManager.info("Verifying Export to Excel icon");
		TestBase.setExtentReportSettings("Export to Excel icon", Constants.FUNCTIONAL_TESTING, "Verify Export to Excel icon", "Verifying Export to Excel icon");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertTrue(communityBlocksPage.exportToExcel(), "Error while Export to Excel icon is not clickable");
	}
	
	@Test(priority = 4, description = "Verify Add Community Block", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyAddBlock()
	{
		LoggerManager.info("Verifying Add Block");
		TestBase.setExtentReportSettings("Add Community Block", Constants.FUNCTIONAL_TESTING, "Verify Add Community Blocks", "Verifying Add Community Blocks");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertEquals(communityBlocksPage.addBlock(),"Add Community Block");
	}

	@Test(priority = 5, description = "Verify Active tab Edit button", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyActiveEditButton()
	{
		LoggerManager.info("Verifying Active tab Edit button");
		TestBase.setExtentReportSettings("Active tab Edit", Constants.FUNCTIONAL_TESTING, "Verify Active tab Edit", "Verifying Active tab Edit");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertEquals(communityBlocksPage.activeEditButton(), "Block Text:");     
	}
	
	@Test(priority = 6, description = "Verify Expired tab Edit button", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyExpiredEditButton()
	{
		LoggerManager.info("Verifying Expired tab Edit");
		TestBase.setExtentReportSettings("Expired tab Edit", Constants.FUNCTIONAL_TESTING, "Verify Expired tab Edit", "Verifying Expired tab Edit");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertEquals(communityBlocksPage.expiredEditButton(),"Block Text:");   
	}

	@Test(priority = 7, description = "Verify Community", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyCommunity()
	{
		LoggerManager.info("Verifying Community");
		TestBase.setExtentReportSettings("Community", Constants.FUNCTIONAL_TESTING, "Verify Community", "Verifying Community");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertEquals(communityBlocksPage.community(),"My Community Dashboard - Classic");
	}
	
	@Test(priority = 8, description = "Verify Logs", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyLogs()
	{
		LoggerManager.info("Verifying Logs");
		TestBase.setExtentReportSettings("Logs", Constants.FUNCTIONAL_TESTING, "Verify Logs", "Verifying Logs");
		communityBlocksPage = new CommunityBlocksPage(driver);
		assertEquals(communityBlocksPage.logs(),"Additional Info");
	}
}
