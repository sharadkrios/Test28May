package com.ciranet.forgotpassword.testcases;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import com.ciranet.constants.Constants;
import com.ciranet.forgotpassword.pages.ForgotPasswordPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;

public class ForgotPasswordPageTest extends TestBase{
	ForgotPasswordPage forgotPasswordPage = createPage(ForgotPasswordPage.class);

	@Test(priority = 0, description = "Verify Forgot Password navigation", groups = {Constants.SMOKE_TESTING}, alwaysRun = true)
	
	public void verifyForgotPasswordPageNavigation()
	{
		LoggerManager.info("Verifying navigate to Forgot Password Page");
		TestBase.setExtentReportSettings("Navigate Forgot Password Test", Constants.SMOKE_TESTING, "Verify navigating to Forgot Password Page", "Verifying navigation to Forgot Password Page");
		forgotPasswordPage = new ForgotPasswordPage(driver);
		assertTrue(forgotPasswordPage.navigate(), "Error while navigating to Forgot Password Page"); 
	}
	
	@Test(priority = 1, description = "Verify Login Page navigation", groups = {Constants.FUNCTIONAL_TESTING}, alwaysRun = true)
	
	public void clickPreferences()
	{
		LoggerManager.info("Verifying navigate to Login Page");
		TestBase.setExtentReportSettings("Navigate Login Page Test", Constants.SMOKE_TESTING, "Verify navigating to Login Page", "Verifying navigation to Login Page");
		forgotPasswordPage = new ForgotPasswordPage(driver);
		assertTrue(forgotPasswordPage.navigateBackToLoginPage(), "Error while navigating to Login Page"); 
	}

}
