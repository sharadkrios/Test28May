package com.ciranet.myworkqueue.communityonboarding.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.communityonboarding.pages.ScheduleFirstAssessmentPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ScheduleFirstAssessmentPageTest extends TestBase {

	// Create the ScheduleFirstAssessmentPage object
	ScheduleFirstAssessmentPage scheduleFirstAssessment = createPage(ScheduleFirstAssessmentPage.class);

	@Test(priority = 0, description = "Verify Schedule First Assessment navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyScheduleFirstAssessmentNavigation() {
		LoggerManager.info("Verifying Schedule First Assessment navigation");
		TestBase.setExtentReportSettings("Schedule First Assessment", Constants.SMOKE_TESTING,
				"Verify Schedule First Assessment", "Verifying Schedule First Assessment navigation");
		scheduleFirstAssessment = new ScheduleFirstAssessmentPage(driver);
		assertTrue(scheduleFirstAssessment.navigateToScheduleFirstAssessment(),
				"Error navigate to Schedule First Assessment");
	}

	@Test(priority = 1, description = "Verify Reset Schedule First Assessment", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyResetFirstAssessment() {
		LoggerManager.info("Verifying Reset Schedule First Assessment");
		TestBase.setExtentReportSettings("Reset Schedule First Assessment", Constants.FUNCTIONAL_TESTING,
				"Verify Reset Schedule First Assessment", "Verifying Reset Schedule First Assessment");
		scheduleFirstAssessment = new ScheduleFirstAssessmentPage(driver);
		assertEquals(scheduleFirstAssessment.resetFirstAssessment(), "Reset");
	}

	@Test(priority = 2, description = "Verify Schedule First Assessment", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyScheduleFirstAssessment() {
		LoggerManager.info("Verifying Schedule First Assessment");
		TestBase.setExtentReportSettings("Schedule First Assessment", Constants.FUNCTIONAL_TESTING,
				"Verify Schedule First Assessment", "Verifying Schedule First Assessment");
		scheduleFirstAssessment = new ScheduleFirstAssessmentPage(driver);
		assertEquals(scheduleFirstAssessment.scheduleFirstAssessment(), "Schedule");
	}
}

