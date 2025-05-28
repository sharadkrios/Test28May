package com.ciranet.community.compliance.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.community.compliance.pages.DetailedViolationsLogPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class DetailedViolationsLogPageTest extends TestBase 
{
	// Create the DetailedViolationsLogPage object
	DetailedViolationsLogPage detailedViolationsLogPage = createPage(DetailedViolationsLogPage.class);
	
	@Test(priority = 0, description = "Verify Detailed Violations Log navigation", groups = {Constants.SMOKE_TESTING}, alwaysRun=true)
	public void verifyDetailedViolationsLogNavigation() throws Exception 
	{
		LoggerManager.info("Verifying Detailed Violations Log navigation");
		TestBase.setExtentReportSettings("Detailed Violations Log", Constants.SMOKE_TESTING, "Verify Detailed Violations Log", "Verifying Detailed Violations Log navigation");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);	
		String communitySearch= "Herff Ranch";
		assertTrue(detailedViolationsLogPage.navigate(communitySearch),"Error navigating to Detailed Violations Log");
	}
	
	@Test(priority = 1, description = "Verify Escalate Violation action menu", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyEscalateViolationAction() 
	{	
		LoggerManager.info("Verifying Escalate Violation action menu");
		TestBase.setExtentReportSettings("Escalate Violation action menu", Constants.FUNCTIONAL_TESTING, "Verify Escalate Violation action menu", "Verifying Escalate Violation action menu");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertEquals(detailedViolationsLogPage.escalateViolationsAction(),"Escalate Existing Violation");
	}
	
	@Test(priority = 2, description = "Verify Close Violation action menu", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyCloseViolationAction()
	{	
		LoggerManager.info("Verifying Close Violation action menu");
		TestBase.setExtentReportSettings("Close Violation action menu", Constants.FUNCTIONAL_TESTING, "Verify Close Violation action menu", "Verifying Close Violation action menu");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertEquals(detailedViolationsLogPage.closeViolationAction(),"Close Reason");
	}
	
	@Test(priority = 3, description = "Verify Custom Violation Letters action menu", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyCustomViolationLettersAction()
	{	
		LoggerManager.info("Verifying Custom Violation Letters action menu");
		TestBase.setExtentReportSettings("Custom Violation Letters action menu", Constants.FUNCTIONAL_TESTING, "Verify Custom Violation Letters action menu", "Verifying Custom Violation Letters action menu");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertEquals(detailedViolationsLogPage.customViolationLettersAction(),"Generate and Save");
	}
	
	@Test(priority = 4, description = "Verify Refer To Attorney action menu", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyReferToAttorneyAction()
	{	
		LoggerManager.info("Verifying Refer To Attorney action menu");
		TestBase.setExtentReportSettings("Refer To Attorney action menu", Constants.FUNCTIONAL_TESTING, "Verify Refer To Attorney action menu", "Verifying Refer To Attorney action menu");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertEquals(detailedViolationsLogPage.referToAttorneyAction(),"Select Vendor");
	}
	
	@Test(priority = 5, description = "Verify Clear Attorney Flag action menu", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyClearAttorneyFlagAction()
	{	
		LoggerManager.info("Verifying Clear Attorney Flag action menu");
		TestBase.setExtentReportSettings("Clear Attorney Flag action menu", Constants.FUNCTIONAL_TESTING, "Verify Clear Attorney Flag action menu", "Verifying Clear Attorney Flag action menu");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertTrue(detailedViolationsLogPage.clearAttorneyFlag(),"Error while Clear Attorney Menu is clicked");
	}
	
	@Test(priority = 6, description = "Verify Add Report Violation", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyReportViolation()
	{	
		LoggerManager.info("Verifying Add Report Violation");
		TestBase.setExtentReportSettings("Add Report Violation", Constants.FUNCTIONAL_TESTING, "Verify Add Report Violation", "Verifying Add Report Violation");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertEquals(detailedViolationsLogPage.reportViolation(),"Report a Violation");
	}
	
	@Test(priority = 7, description = "Verify Closed Violation History", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyClosedViolationHistory()
	{	
		LoggerManager.info("Verifying Closed Violation History");
		TestBase.setExtentReportSettings("Closed Violation History", Constants.FUNCTIONAL_TESTING, "Verify Closed Violation History", "Verifying Closed Violation History");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertTrue(detailedViolationsLogPage.closedViolationHistory(),"Error while Violation History icon is clicked");
	}
	
	@Test(priority = 8, description = "Verify Property Address", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyClosedPropertyAddress()
	{	
		LoggerManager.info("Verifying Property Address");
		TestBase.setExtentReportSettings("Property Address", Constants.FUNCTIONAL_TESTING, "Verify Property Address", "Verifying Property Address");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertTrue(detailedViolationsLogPage.propertyAddress(),"Error while Property Address is clicked");
	}
	
	@Test(priority = 9, description = "Verify Edit Allowances", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	public void verifyEditAllowances()
	{	
		LoggerManager.info("Verifying Edit Allowances");
		TestBase.setExtentReportSettings("Edit Allowances", Constants.FUNCTIONAL_TESTING, "Verify Edit Allowances", "Verifying Edit Allowances");
		detailedViolationsLogPage = new DetailedViolationsLogPage(driver);
		assertTrue(detailedViolationsLogPage.editAllowances(),"Error while Edit Menu is clicked");
	}
}