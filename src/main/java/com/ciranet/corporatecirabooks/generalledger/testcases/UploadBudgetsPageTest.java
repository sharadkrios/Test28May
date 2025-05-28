package com.ciranet.corporatecirabooks.generalledger.testcases;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.corporatecirabooks.generalledger.pages.UploadBudgetsPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class UploadBudgetsPageTest extends TestBase {

	UploadBudgetsPage uploadBudgets = createPage(UploadBudgetsPage.class);

	@Test(priority = 0, description = "Verify Upload Budgets navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyUploadBudgetsNavigation() {
		LoggerManager.info("Verifying Upload Budgets");
		TestBase.setExtentReportSettings("Upload Budgets", Constants.SMOKE_TESTING, "Verify Upload Budgets",
				"Verifying Upload Budgets navigation");
		uploadBudgets = new UploadBudgetsPage(driver);
		assertTrue(uploadBudgets.navigateToUploadBudgets(), "Error navigate to Upload Budgets");
	}

	@Parameters("filePath")
	@Test(priority = 1, description = "Verify Uploading the Budget file", groups = {
			Constants.FUNCTIONAL_TESTING }, alwaysRun = true)
	public void verifyUploadBudgets(String filePath) throws AWTException {
		LoggerManager.info("Verifying Uploading the Budget file");
		TestBase.setExtentReportSettings("Uploading the Budget file", Constants.FUNCTIONAL_TESTING, "Verify Uploading the Budget file",
				"Verifying Uploading the Budget file");
		uploadBudgets = new UploadBudgetsPage(driver);
		assertTrue(uploadBudgets.verifyBudgetFileUpload(filePath), "Error occurred while Uploading the Budget file");
	}
}