package com.ciranet.community.information.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.community.information.pages.CommunityAssetsPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class CommunityAssetsPageTest extends TestBase {
	
	// Create the CommunityAssetsPage object
	CommunityAssetsPage communityAssetsPage = createPage(CommunityAssetsPage.class);
	
	@Test(priority = 0, description = "Verify Community Assets navigation", groups = {Constants.SMOKE_TESTING},alwaysRun=true)
	public void verifyNavigate() 
	{
		LoggerManager.info("Verifying Community Assets navigation");
		TestBase.setExtentReportSettings("Community Assets navigation", Constants.SMOKE_TESTING, "Verify Community Assets", "Verifying Community Assets navigation");
		communityAssetsPage = new CommunityAssetsPage(driver);
		String communitySearch= "Amberwood";
		assertTrue(communityAssetsPage.navigate(communitySearch), "Error navigating to Assets");
	} 

	@Test(priority = 1, description = "Verify add community assets", groups = {Constants.FUNCTIONAL_TESTING},alwaysRun=true)
	public void verifyAddNewAsset() 
	{
		LoggerManager.info("Verifying add community assets ");
		TestBase.setExtentReportSettings("Add assets ", Constants.FUNCTIONAL_TESTING, "Verify Add Assets ", "Verifying add assets ");
		communityAssetsPage = new CommunityAssetsPage(driver);
		assertEquals(communityAssetsPage.addNewAsset(), "Add/Edit Asset");
	} 
    
	@Test(priority = 2, description = "Verify edit assets", groups = {Constants.FUNCTIONAL_TESTING},alwaysRun=true)
	public void verifyEditAsset() 
	{
		LoggerManager.info("Verifying edit assets ");
		TestBase.setExtentReportSettings("Edit assets", Constants.FUNCTIONAL_TESTING, "Verify edit assets", "Verifying edit assets");
		communityAssetsPage = new CommunityAssetsPage(driver);
		assertEquals(communityAssetsPage.editAsset(), "Add/Edit Asset");
	} 

	@Test(priority = 3, description = "Verify delete assets", groups = {Constants.FUNCTIONAL_TESTING},alwaysRun=true)
	public void verifyDeleteAsset() 
	{
		LoggerManager.info("Verifying delete assets");
		TestBase.setExtentReportSettings("Delete assets ", Constants.FUNCTIONAL_TESTING, "Verify delete assets", "Verifying delete assets");
		communityAssetsPage = new CommunityAssetsPage(driver);
		assertEquals(communityAssetsPage.deleteAsset(), "Confirmation");
	} 
  
	@Test(priority = 4, description = "Verify upload asset", groups = {Constants.FUNCTIONAL_TESTING},alwaysRun=true)
	public void verifyUploadAssetImage()  
	{
		LoggerManager.info("Verifying upload assets");
		TestBase.setExtentReportSettings("Upload assets ", Constants.FUNCTIONAL_TESTING, "Verify upload assets", "Verifying upload assets");
		communityAssetsPage = new CommunityAssetsPage(driver);
		assertEquals(communityAssetsPage.uploadAssetImage(), "Upload Asset Images");
	} 
}
