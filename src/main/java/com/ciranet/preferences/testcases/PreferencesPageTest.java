package com.ciranet.preferences.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.preferences.pages.PreferencesPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class PreferencesPageTest extends TestBase {
	// Create the PreferencesPage object
	PreferencesPage preferencesPage = createPage(PreferencesPage.class);

	@Test(priority = 0, description = "Verify Preferences", groups = { Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyPreferencesMenuVisibility() {
		LoggerManager.info("Verifying Preferences");
		TestBase.setExtentReportSettings("Preferences", Constants.SMOKE_TESTING, "Verify Preferences",
				"Verifying Preferences");
		preferencesPage = new PreferencesPage(driver);
		assertTrue(preferencesPage.checkPreferencesMenuVisibility(), "Preferences menu is not seen");
	}

	@Test(priority = 1, description = "Verify Main Navigation Behaviour - Open in Same Window", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySetNavigationToSameWindow() {
		LoggerManager.info("Verifying Main Navigation Behaviour - Open in Same Window");
		TestBase.setExtentReportSettings("Main Navigation Behaviour- Open in Same Window", Constants.FUNCTIONAL_TESTING,
				"Verify Main Navigation Behaviour - Open in Same Window",
				"Verifying Main Navigation Behaviour - Open in Same Window");
		preferencesPage = new PreferencesPage(driver);
		assertTrue(preferencesPage.setNavigationToSameWindow(),
				"Main Navigation Bahaviour  - Open in Same Window is not set");
	}

	@Test(priority = 2, description = "Verify Main Navigation Behaviour - Open in New Window", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifySetNavigationToNewWindow() {
		LoggerManager.info("Verifying Main Navigation Behaviour  - Open in New Window");
		TestBase.setExtentReportSettings("Main Navigation Behaviour  - Open in New Window",
				Constants.FUNCTIONAL_TESTING, "Verify Main Navigation Behaviour  - Open in New Window",
				"Verifying Main Navigation Behaviour  - Open in New Window");
		preferencesPage = new PreferencesPage(driver);
		assertTrue(preferencesPage.setNavigationToNewWindow(),
				"Main Navigation Bahaviour  - Open in New Window is not set");
	}

	@Test(priority = 3, description = "Verify Themes", groups = { Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyApplyNewTheme() {
		LoggerManager.info("Verifying Themes");
		TestBase.setExtentReportSettings("Themes", Constants.FUNCTIONAL_TESTING, "Verify Themes", "Verifying Themes");
		preferencesPage = new PreferencesPage(driver);
		assertTrue(preferencesPage.applyNewTheme(), "Theme value is not selected");
	}	
}
