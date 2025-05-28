package com.ciranet.myworkqueue.communitymanagement.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.communitymanagement.pages.CommonLotsAppraisalPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class CommonLotsAppraisalPageTest extends TestBase{
	
	// Create the ServicesPage object
	CommonLotsAppraisalPage commonLotsAppraisalPage = createPage(CommonLotsAppraisalPage.class);


	@Test(priority = 0, description = "Verify navigate to Common Lots Appraisal", groups = {Constants.SMOKE_TESTING}, alwaysRun = true)
	public void verifyCommonLotsAppraisalURL() 
	{
		LoggerManager.info("Verifying navigating to Common Lots Appraisal Page");
		TestBase.setExtentReportSettings("Verify navigate to Common Lots Appraisal Test", Constants.SMOKE_TESTING, 
				"Verify navigating to Common Lots Approsal Page", "Verifying navigate to Common Lots Apprisal Page");
		commonLotsAppraisalPage = new CommonLotsAppraisalPage(driver);
		assertEquals(commonLotsAppraisalPage.navigate(), "Common Lots Appraisal");   
	}

	@Test(priority = 1, description = "Verify Toolbar Full Screen Option", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true) 
	public void verifyToolbarFullScreenOption() {
		LoggerManager.info("Verifying Common Lots Full Screen Option");
		TestBase.setExtentReportSettings("Verifying Common Lots Appraisal Full Screen Test",Constants.FUNCTIONAL_TESTING, "Verify Common Lots Appraisal Full screen", "Verifying Common Lots Appraisal Full screen");
		commonLotsAppraisalPage = new CommonLotsAppraisalPage(driver);
		assertTrue(commonLotsAppraisalPage.toolBarFullScreen(), "Error in Fullscreen functionality");	
	}

	@Test(priority = 2, description = "Verify Column Chooser Option", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyColumnChooserOption() 
	{
		LoggerManager.info("Verifying Common Lots Appraisal Title");
		TestBase.setExtentReportSettings("Verifying Common Lots Appraisal Title", Constants.FUNCTIONAL_TESTING, "Common Lots", "Verify C L A");
		commonLotsAppraisalPage = new CommonLotsAppraisalPage(driver);
		assertTrue(commonLotsAppraisalPage.columnChooserClick(), "Error while clicking on Column Chooser");
	}
	
	@Test(priority = 3, description = "Verify Excel Export Option", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyExcelOption() 
	{
		LoggerManager.info("Verify Export to Excel ");
		TestBase.setExtentReportSettings("Export to Excel test", Constants.FUNCTIONAL_TESTING, "Verify Export to Excel option", "Verifying Export to Excel");
		assertTrue(commonLotsAppraisalPage.verifyExportToExcel(), "Error while Export to Excel");
	}

	@Test(priority = 4, description = "Verify CSV Option", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyExportCSVOption() 
	{
		LoggerManager.info("Verifying Common Lots CSV option");
		TestBase.setExtentReportSettings("Verifying CSV export", Constants.FUNCTIONAL_TESTING, "Verify CSV export", "Verifying CSV export");
		commonLotsAppraisalPage = new CommonLotsAppraisalPage(driver);
		assertTrue(commonLotsAppraisalPage.verifyExportToCSV(), "Error is seen while exporting to CSV");
	}

	@Test(priority = 5, description = "Verify Add New Common Lot entry", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyAddNewCommonLot() 
	{
		LoggerManager.info("Verifying Add New Common Lot");
		TestBase.setExtentReportSettings("Add New Common Lot Test", Constants.FUNCTIONAL_TESTING, "Verify Add New Common Lot", "Verifying Add New Common Lot");
		commonLotsAppraisalPage = new CommonLotsAppraisalPage(driver);
		assertTrue(commonLotsAppraisalPage.verifyAddNewCommonLotEntry(), "Error is seen while Adding New Common Lot Entry");
	}
	
	@Test(priority = 6, description = "Verify Edit Common Lot entry", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyEditCommonLot() 
	{
		LoggerManager.info("Verifying Edit Common Lot");
		TestBase.setExtentReportSettings("Edit Common Lot Test", Constants.FUNCTIONAL_TESTING, "Verify Edit Common Lot", "Verifying Edit Common Lot");
		commonLotsAppraisalPage = new CommonLotsAppraisalPage(driver);
		assertTrue(commonLotsAppraisalPage.verifyEditCommonLotEntry(), "Error is seen while editing Common Lot Entry");
	}
	
	@Test(priority = 7, description = "Verify Add New Appraiser entry", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyAddNewAppraiser() 
	{
		LoggerManager.info("Verifying Add New Appraiser");
		TestBase.setExtentReportSettings("Add New Appraiser Test", Constants.FUNCTIONAL_TESTING, "Verify Add New Appraiser", "Verifying Add New Appraiser");
		commonLotsAppraisalPage = new CommonLotsAppraisalPage(driver);
		assertTrue(commonLotsAppraisalPage.addNewAppraiserEntry(), "Error is seen while adding New Appraiser Entry");
	}

	@Test(priority = 8, description = "Verify Edit Common Lot Appraisal entry", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyAddCommonLotAppraisal() 
	{
		LoggerManager.info("Verifying Edit Common Lot Appraisal");
		TestBase.setExtentReportSettings("Edit Appraisal Test", Constants.FUNCTIONAL_TESTING, "Verify Edit Common Lot Appraisal entry", "Verifying Edit Appraisal entry");
		commonLotsAppraisalPage = new CommonLotsAppraisalPage(driver);
		assertTrue(commonLotsAppraisalPage.editCommonLotAppraiserEntry(), "Error is seen while editing and saving Common Lot Appraisal Entry");
	}
}
