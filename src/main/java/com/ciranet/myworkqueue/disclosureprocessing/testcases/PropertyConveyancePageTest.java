package com.ciranet.myworkqueue.disclosureprocessing.testcases;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.disclosureprocessing.pages.PropertyConveyancePage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class PropertyConveyancePageTest extends TestBase
{
	// Create the PropertyConveyancePage object
	PropertyConveyancePage propertyConveyancePage = createPage(PropertyConveyancePage.class);
	
	@Test(priority = 0, description = "Verify Property Conveyances navigation", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyPropertyConveyancesNavigation() 
	{
		LoggerManager.info("Verifying Property Conveyances navigation");		
		TestBase.setExtentReportSettings("Property Conveyances", Constants.SMOKE_TESTING, "Verify Property Conveyances", "Verifying Property Conveyances navigation");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.navigate(), "Error navigating to Property Conveyances");
	}

	@Test(priority = 1, description = "Verify Fullscreen icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyFullScreen() 
	{
		LoggerManager.info("Verify Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon", "Verifying Fullscreen icon");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.fullScreen(),"Error while clicking on Fullscreen icon");
	}

	@Test(priority = 2, description = "Verify Normalscreen icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyNormalScreen() 
	{
		LoggerManager.info("Verify Normalscreen icon");
		TestBase.setExtentReportSettings("Normalscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Normalscreen icon", "Verifying Normalscreen icon");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.normalScreen(),"Error while clicking on Normalscreen icon");
	}

	@Test(priority = 3, description = "Verify Column Chooser icon ", groups = { Constants.FUNCTIONAL_TESTING },alwaysRun=true)
	public void verifyColumnChooser() 
	{
		LoggerManager.info("Verify Column Chooser icon");
		TestBase.setExtentReportSettings("Column Chooser icon", Constants.FUNCTIONAL_TESTING, "Verify Column Chooser icon", "Verifying Column Chooser icon");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.columnChooser(),"Error while clicking on Column Chooser icon");
	}

	@Test(priority = 4, description = "Verify Expand icon", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyExpandIcon() 
	{
		LoggerManager.info("Verify Expand icon");
		TestBase.setExtentReportSettings("Expand icon", Constants.FUNCTIONAL_TESTING, "Verify Expand icon", "Verifying Expand icon");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.expandOption(),"Error while expanding Expand icon");
	}

	@Test(priority = 5, description = "Verify Edit Community", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEditCommunity() 
	{
		LoggerManager.info("Verify Edit Community");
		TestBase.setExtentReportSettings("Edit Community", Constants.FUNCTIONAL_TESTING, "Verify Edit Community", "Verifying Edit Community");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.editCommunity(),"Error occured while editing the community");
	}

	@Test(priority = 6 , description = "Verify Delete", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyDeleteCommunity() 
	{
		LoggerManager.info("Verify Delete");
		TestBase.setExtentReportSettings("Delete", Constants.FUNCTIONAL_TESTING, "Verify Delete", "Verifying Delete");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.deleteCommunity(),"Error while Deleting the community");
		
	}

	@Test(priority = 7 , description = "Verify Refresh Button", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyRefresh() 
	{
		LoggerManager.info("Verify Refresh Button");
		TestBase.setExtentReportSettings("Refresh Button", Constants.FUNCTIONAL_TESTING, "Verify Refresh Button", "Verifying Refresh Button");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.refreshButton(),"Error while Refreshing the grid");
	}

	@Test(priority = 8, description = "Verify Compact Mode toggle button", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyProcessPropertyConveyanceCompactMode() 
	{
		LoggerManager.info("Verify Compact Mode toggle button");
		TestBase.setExtentReportSettings("Compact Mode", Constants.FUNCTIONAL_TESTING, "Verify Compact Mode", "Verifying Compact Mode");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.processPropertyConveyanceCompactMode(),"Error while clicking on Compact Mode");
	
	}

	@Test(priority = 9, description = "Verify Search Work Queue", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifySearchWorkQueue() 
	{
		LoggerManager.info("Verify search Work Queue");
		TestBase.setExtentReportSettings("Search Work Queue", Constants.FUNCTIONAL_TESTING, "Verify Search Work Queue", "Verifying Search Work Queue");
		propertyConveyancePage = new PropertyConveyancePage(driver);
		assertTrue(propertyConveyancePage.searchWorkQueue(),"Error while searching the Work Queue");
	}	
}
