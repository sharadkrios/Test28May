package com.ciranet.community.compliance.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.quicksearch.QuickSearch;
import com.ciranet.utilities.LoggerManager;

public class LastInspectionLogPage extends BasePage {
	public LastInspectionLogPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Last Inspection Log')]")
	WebElement lastInspectionLogSideNav;

	@FindBy(xpath = "//h2[text()=' Last Inspection Log ']")
	WebElement pageTitle;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color'])[3]")
	WebElement logDetails;

	@FindBy(xpath = "//div[contains(text(),'Last Inspection Results Detail: Landscaping / Previous Inspection')]")
	WebElement logDetailsLabel;

	@FindBy(xpath = "(//i[@title='History'])[1]")
	WebElement historyIcon;

	@FindBy(xpath = "//h4[text()='Violation History']")
	WebElement violationHistory;

	@FindBy(xpath = "(//i[@title='Images'])[1]")
	WebElement imageIcon;

	@FindBy(xpath = "//div[text()='Violation History Images']")
	WebElement historyImages;

	@FindBy(xpath = "(//dx-button[@title='Close'])[3]")
	WebElement imageCloseButton;

	@FindBy(xpath = "(//dx-button[@title='Close'])[2]")
	WebElement historyCloseButton;

	@FindBy(xpath = "(//dx-button[@title='Close'])[1]")
	WebElement logCloseButton;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	QuickSearch quickSearch = new QuickSearch(driver);
	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public boolean navigate(String communityName) throws Exception {

		LoggerManager.info("Starting community search with keyword: {} " + communityName);

		// Wait for loader icon to disappear
		LoggerManager.info("Loader icon is invisible, proceeding with search.");

		quickSearch.searchCommunity(communityName);
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Community search completed for keyword: {} " + communityName);

		try {
			LoggerManager.info("Pressing Escape key to close any popups if present");
			pressEscapeKey();
		} catch (AWTException e) {
			LoggerManager.error("Error pressing the Escape key");
		}

		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[contains(text(),'Last Inspection Log')]"),
					"Last Inspection Log");
			LoggerManager.info("Navigating to Last Inspection Log");

			LoggerManager.info("Scrolling to Last Inspection Log navigation");
			scrollToElement(lastInspectionLogSideNav);

			if (isElementDisplayed(lastInspectionLogSideNav)) {
				LoggerManager.info("Last Inspection Log navigation is visible, clicking on it");
				clickElementJS(lastInspectionLogSideNav);

				LoggerManager.info("Successfully searched for the community and accessed Last Inspection Log");

				boolean isPageTitle = pageTitle.getText().equals("Last Inspection Log");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Last Inspection Log navigation is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the community search process");
			return false;
		}
	}

	public boolean toolBarFullScreen() {
		try {
			clickElementJS(fullScreenIcon);
			if (isElementDisplayed(normalScreenIcon)) {
				clickElementJS(normalScreenIcon);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in toolBarFullScreen: " + e.getMessage());
			throw e;
		}
	}

	public String logDetails() {
		try {
			clickElement(logDetails);
			return logDetailsLabel.getText();
		} catch (Exception e) {
			LoggerManager.error("Error occurred in logDetails: " + e.getMessage());
			throw e;
		}
	}

	public String violationHistory() {
		try {
			clickElement(historyIcon);
			return violationHistory.getText();
		} catch (Exception e) {
			LoggerManager.error("Error occurred in violationHistory: " + e.getMessage());
			throw e;
		}
	}

	public String historyImage() {
		try {
			clickElement(imageIcon);
			return historyImages.getText();
		} catch (Exception e) {
			LoggerManager.error("Error occurred in historyImage: " + e.getMessage());
			throw e;
		}
	}

	public String closeButtons() {
		try {
			clickElement(imageCloseButton);
			clickElement(historyCloseButton);
			clickElement(logCloseButton);
			return pageTitle.getText();
		} catch (Exception e) {
			LoggerManager.error("Error occurred in closeButtons: " + e.getMessage());
			throw e;
		}
	}
}

