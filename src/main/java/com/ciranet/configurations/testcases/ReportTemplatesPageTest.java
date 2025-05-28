package com.ciranet.configurations.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.configurations.pages.ReportTemplatesPage;
import com.ciranet.constants.Constants;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ReportTemplatesPageTest extends TestBase {

	// Create the ReportTemplatesPage object
	ReportTemplatesPage reportTemplatesPage = createPage(ReportTemplatesPage.class);

	@Test(priority = 0, description = "Verify Report Templates navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyReportTemplatesNavigation() {
		LoggerManager.info("Verifying Report Templates navigation");
		reportTemplatesPage = new ReportTemplatesPage(driver);
		TestBase.setExtentReportSettings("Report Templates", Constants.SMOKE_TESTING, "Verify Report Templates",
				"Verifying Report Templates navigation");
		assertTrue(reportTemplatesPage.navigate(), "Error navigate to Report Templates");
	}

	@Test(priority = 1, description = "Verify Letter Templates", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLetterTemplate() {
		LoggerManager.info("Verifying Letter Templates");
		TestBase.setExtentReportSettings("Letter Templates", Constants.FUNCTIONAL_TESTING, "Verify Letter Templates",
				"Verifying Letter Templates");
		reportTemplatesPage = new ReportTemplatesPage(driver);
		assertEquals(reportTemplatesPage.letterTemplate(),
				"Letter Templates / Builder Statement Cover Letter - Global");
	}

	@Test(priority = 2, description = "Verify Letterhead Templates", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyLetterheadTemplate() {
		LoggerManager.info("Verifying Letterhead Templates");
		TestBase.setExtentReportSettings("Letterhead Templates", Constants.FUNCTIONAL_TESTING,
				"Verify Letterhead Template", "Verifying Letterhead Templates");
		reportTemplatesPage = new ReportTemplatesPage(driver);
		assertEquals(reportTemplatesPage.letterheadTemplate(), "Letterhead Template / Page Footer - Global");
	}
}
