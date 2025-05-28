package com.ciranet.myportfolio.revenuemanagement.testcases;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myportfolio.revenuemanagement.pages.BillingItemManagementPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class BillingItemManagementPageTest extends TestBase
{
	// Create the BillingItemManagementPage object
	BillingItemManagementPage billingItemManagementPage = createPage(BillingItemManagementPage.class);
	
	@Test(priority = 0, description = "Verify Billing Item Management navigation", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyBillingItemManagementNavigation() 
	{
		LoggerManager.info("Verifying Billing Item Management navigation");
		TestBase.setExtentReportSettings("Billing Item Management navigation", Constants.SMOKE_TESTING, "Verify Billing Item Management navigation", "Verifying Billing Item Management navigation");
		billingItemManagementPage = new BillingItemManagementPage(driver);
		assertTrue(billingItemManagementPage.navigate(),"Error navigating to Billing Item Management page");		
	}
	
	@Test(priority = 1, description = "Verify Billing Item Management Data", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyBillingItemManagementData() 
	{
		LoggerManager.info("Verifying Billing Item Management Data");
		TestBase.setExtentReportSettings("Billing Item Management Data", Constants.FUNCTIONAL_TESTING, "Verify Billing Item Management Data", "Verifying Billing Item Management Data");
		billingItemManagementPage = new BillingItemManagementPage(driver);
		assertTrue(billingItemManagementPage.verifyBillingItemManagementDataDisplay(),"Error to display Billing Item Management data");		
	}
	
	@Test(priority = 2, description = "Verify Add Billing Item Quantity", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyAddBillingItemQuantity() 
	{
		LoggerManager.info("Verifying Billing Item Quantity popup");
		TestBase.setExtentReportSettings("Billing Item Management Quantity Entry", Constants.FUNCTIONAL_TESTING, "Verify Billing Item Quantity Entry", "Verifying Billing Item Quantity");
		billingItemManagementPage = new BillingItemManagementPage(driver);
		assertTrue(billingItemManagementPage.addBillingItemQuantity(),"Error to add Billing Item Quantity");		
	}
	
	@Test(priority = 3, description = "Verify Edit Billing Item Quantity", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEditBillingItemQuantity()  
	{
		LoggerManager.info("Verifying Edit Billing Item Quantity ");
		TestBase.setExtentReportSettings("Edit Billing Item Quantity", Constants.FUNCTIONAL_TESTING, "Verify Edit Billing Item Quantity", "Verifying Edit Billing Item Quantity");
		billingItemManagementPage = new BillingItemManagementPage(driver);
		assertTrue(billingItemManagementPage.editBillingItemQuantity(),"Error to edit Billing Item Management Quantity");		
	}
}
