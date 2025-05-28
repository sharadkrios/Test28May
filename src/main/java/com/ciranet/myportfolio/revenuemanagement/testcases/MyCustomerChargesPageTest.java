package com.ciranet.myportfolio.revenuemanagement.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myportfolio.revenuemanagement.pages.MyCustomerChargesPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class MyCustomerChargesPageTest extends TestBase 
{
	// Create the MyCustomerChargesPage object
	MyCustomerChargesPage myCustomerChargesPage = createPage(MyCustomerChargesPage.class);

	@Test(priority = 0, description = "Verify My Customer Charges navigation", groups = { Constants.SMOKE_TESTING }, alwaysRun=true)
	public void verifyMyCustomerChargesNavigation() throws Exception
	{
		LoggerManager.info("Verifying My Customer Charges navigation");
		TestBase.setExtentReportSettings("My Customer Charges", Constants.FUNCTIONAL_TESTING, "Verify My Customer Charges", "Verifying My Customer Charges navigation");
		myCustomerChargesPage = new MyCustomerChargesPage(driver);
		assertTrue(myCustomerChargesPage.navigate(),"Error navigated to My Customer Charges");
	}
	
	@Test(priority = 1,description = "Verify Entity", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyEntitySelection() 
	{	
		LoggerManager.info("Verifying Entity");
		TestBase.setExtentReportSettings("Entity", Constants.FUNCTIONAL_TESTING, "Verify Entity", "Verifying Entity");
		myCustomerChargesPage = new MyCustomerChargesPage(driver);
		assertEquals(myCustomerChargesPage.entity(),"Action");
	}
	
	@Test(priority = 2, description = "Verify Fullscreen icon", groups = {Constants.FUNCTIONAL_TESTING }, alwaysRun=true) 
	public void verifyToolbarFullScreenIcon() 
	{
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Fullscreen icon", Constants.FUNCTIONAL_TESTING, "Verify Fullscreen icon", "Verifying Fullscreen icon");
		myCustomerChargesPage = new MyCustomerChargesPage(driver);
		assertTrue(myCustomerChargesPage.toolBarFullScreen(), "Error while Fullscreen icon is not clickable");
	}

	@Test(priority = 3,description = "Verify Add Customer Charge", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyCreateNewCharge() 
	{
		LoggerManager.info("Verifying Add Customer Charge");
		TestBase.setExtentReportSettings("Add Customer Charge", Constants.FUNCTIONAL_TESTING, "Verify Add Customer Charge", "Verifying Add Customer Charge");
		myCustomerChargesPage = new MyCustomerChargesPage(driver);
		assertEquals(myCustomerChargesPage.addNewCharge(),"Add Customer Charge");
	}
	
	@Test(priority = 4,description = "Verify Note", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyNote() 
	{
		LoggerManager.info("Verifying Note");
		TestBase.setExtentReportSettings("Note", Constants.FUNCTIONAL_TESTING, "Verify Note", "Verifying Note");
		myCustomerChargesPage = new MyCustomerChargesPage(driver);
		assertEquals(myCustomerChargesPage.notes(),"Note");
	}
	
	@Test(priority = 5,description = "Verify Edit Customer Charges", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyEditCharge() 
	{
		LoggerManager.info("Verifying Edit Customer Charges");
		TestBase.setExtentReportSettings("Edit Customer Charges", Constants.FUNCTIONAL_TESTING, "Verify Edit Customer Charges", "Verifying Edit Customer Charges");
		myCustomerChargesPage = new MyCustomerChargesPage(driver);
		assertEquals(myCustomerChargesPage.editCharge(),"Edit Customer Charge");
	}

	@Test(priority = 6,description = "Verify Delete Charges", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun=true)
	public void verifyDeleteCharge() 
	{
		LoggerManager.info("Verifying Delete Charges");
		TestBase.setExtentReportSettings("Delete Customer Charges", Constants.FUNCTIONAL_TESTING, "Verify Delete Charges", "Verifying Delete Charges");
		myCustomerChargesPage = new MyCustomerChargesPage(driver);
		assertEquals(myCustomerChargesPage.deleteCharge(),"Confirmation");
	}
}