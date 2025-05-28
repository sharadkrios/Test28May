package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ciranet.configurations.pages.ResponseTemplatesPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ResponseTemplatesPageTest extends TestBase {

	// Create the ResponseTemplatesPage object
	ResponseTemplatesPage responseTemplatesPage = createPage(ResponseTemplatesPage.class);

	@Test(priority = 0, description = "Verify Response Template navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyResponseTemplatesNavigation() {
		LoggerManager.info("Verifying  Response Templates navigation");
		TestBase.setExtentReportSettings("Response Templates", Constants.SMOKE_TESTING, "Verify Response Templates",
				"Verifying Response Templates");
		responseTemplatesPage = new ResponseTemplatesPage(driver);
		assertTrue(responseTemplatesPage.navigateToResponseTemplates(), "Error navigate to Response Templates");
	}

	@Parameters("contextSearchText")
	@Test(priority = 1, description = "Verify Response Template Configuration", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyResponseTemplateConfiguration(String contextSearchText) {
		LoggerManager.info("Verifying Response Templates Configuration");
		TestBase.setExtentReportSettings("Response Template Configuration", Constants.FUNCTIONAL_TESTING,
				"Verify Response Template Configuration", "Verifying Response Template Configuration");
		responseTemplatesPage = new ResponseTemplatesPage(driver);
		responseTemplatesPage.setContextSearchTextFromParameter(contextSearchText);
		assertTrue(responseTemplatesPage.responseTemplateSelection(),
				"Error occured while Templates dropdown is not clickable");
	}
}