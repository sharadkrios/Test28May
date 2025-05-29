package com.ciranet.myworkqueue.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.pages.ProjectsTasksPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ProjectsTasksPageTest extends TestBase {
	ProjectsTasksPage projectsTasksPage = createPage(ProjectsTasksPage.class);

	@Test(priority = 0, description = "Verify Projects / Tasks navigation", groups = {
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyProjectsTasksNavigation() {
		LoggerManager.info("Verifying Projects / Tasks navigation");
		TestBase.setExtentReportSettings("Projects / Tasks", Constants.SMOKE_TESTING, "Verify Projects / Tasks",
				"Verifying Projects / Tasks navigation");
		projectsTasksPage = new ProjectsTasksPage(driver);
        projectsTasksPage.ProjectTaskPageLanding();
	}
}
