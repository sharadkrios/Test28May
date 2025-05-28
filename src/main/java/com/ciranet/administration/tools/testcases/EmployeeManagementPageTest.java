package com.ciranet.administration.tools.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.administration.tools.pages.EmployeeManagementPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class EmployeeManagementPageTest extends TestBase {

	// Create the EmployeeManagementPage object
	EmployeeManagementPage employeeManagement = createPage(EmployeeManagementPage.class);

	@Test(priority = 0, description = "Verify Employee Management navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyEmployeeManagementNavigation() {
		LoggerManager.info("Verifying Employee Management navigation");
		TestBase.setExtentReportSettings("Employee Management navigation", Constants.SMOKE_TESTING,
				"Verify Employee Management", "Verifying Employee Management navigation");
		employeeManagement = new EmployeeManagementPage(driver);
		assertTrue(employeeManagement.navigate(), "Error navigating to Employee Management Page");
	}

	@Test(priority = 1, description = "Verify Fullscreen icon", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyToolbarFullscreen() {
		LoggerManager.info("Verifying Fullscreen icon");
		TestBase.setExtentReportSettings("Full Screen icon", Constants.FUNCTIONAL_TESTING,
				"Verify Full Screen icon", "Verifying Full Screen icon");
		employeeManagement = new EmployeeManagementPage(driver);
		assertTrue(employeeManagement.toolBarFullScreen(), "Error while Fullscreen icon is not clicked");
	}

	@Test(priority = 2, description = "Verify User Status", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyUserStatus() {
		LoggerManager.info("Verifying User Status");
		TestBase.setExtentReportSettings("User Status", Constants.FUNCTIONAL_TESTING, "Verify User Status",
				"Verifying User Status");
		employeeManagement = new EmployeeManagementPage(driver);
		assertTrue(employeeManagement.userStatus(), "Error while Checkmark icon is not displayed");
	}

	@Test(priority = 3, description = "Verify Manager Biography", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyBiography() {
		LoggerManager.info("Verifying Manager Biography");
		TestBase.setExtentReportSettings("Manager Biography", Constants.FUNCTIONAL_TESTING, "Verify Manager Biography",
				"Verifying Manager Biography");
		employeeManagement = new EmployeeManagementPage(driver);
		assertEquals(employeeManagement.biography(), "Olga Scott, Client Services Manager");
	}

	@Test(priority = 4, description = "Verify Edit Employee Details", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyEditEmployee() {
		LoggerManager.info("Verifying Edit Employee Details");
		TestBase.setExtentReportSettings("Edit Employee Details", Constants.FUNCTIONAL_TESTING,
				"Verify Edit Employee Details", "Verifying Edit Employee Details");
		employeeManagement = new EmployeeManagementPage(driver);
		assertEquals(employeeManagement.editEmployee(), "Edit Employee Akshay Yeole");
	}
}
