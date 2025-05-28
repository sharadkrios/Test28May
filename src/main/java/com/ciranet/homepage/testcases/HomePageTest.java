package com.ciranet.homepage.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.homepage.pages.HomePage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class HomePageTest extends TestBase 
{
	HomePage homePage = createPage(HomePage.class);
	
	@Test(priority = 0, description = "Verify Owner Search", groups = {Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyOwnerSearch() 
	{
		LoggerManager.info("Verifying Owner Search on Home Page");
		TestBase.setExtentReportSettings("HomePage Owner Search Test", Constants.SMOKE_TESTING, "Verify Home Page Owner Search", "Verifying Owner Search on Home Page");
		homePage = new HomePage(driver);
		String ownerSearchKeyword = "romich";
		assertTrue(homePage.searchOwner(ownerSearchKeyword));

	}

	@Test(priority = 1, description = "Verify Community Search", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyCommunitySearchOn() 
	{
		LoggerManager.info("Verifying Community Search on Home Page");
		TestBase.setExtentReportSettings("HomePage Community Search Test", Constants.SMOKE_TESTING, "Verify Home Page Community Search", "Verifying Community Search");
		homePage = new HomePage(driver);
		String communitySearchKeyword = "amberwood";
		assertTrue(homePage.searchCommunity(communitySearchKeyword));
	}	
}
