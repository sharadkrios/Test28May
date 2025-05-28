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

public class OpenViolationsLogPage extends BasePage {
	public OpenViolationsLogPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Open Violations Log')]")
	WebElement openViolationsLogSideNav;

	@FindBy(xpath = "//h2[text()=' Open Violations Log ']")
	WebElement pageTitle;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color'])[28]")
	WebElement logDetails;

	@FindBy(xpath = "//div[text()='Open Violations Log Detail']")
	WebElement logDetailLabel;

	@FindBy(xpath = "(//i[@class='cc-1-5x cc-hyperlink dx-theme-accent-as-text-color fas fa-history'])[1]")
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

		LoggerManager.info("Loader icon is invisible, proceeding with search.");

		quickSearch.searchCommunity(communityName);
		LoggerManager.info("Community search completed for keyword: {} " + communityName);

		try {
			LoggerManager.info("Pressing Escape key to close any popups if present");
			pressEscapeKey();
		} catch (AWTException e) {
			LoggerManager.error("Error pressing the Escape key");
		}

		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[contains(text(),'Open Violations Log')]"),
					"Open Violations Log");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to Open Violations Log");

			waitForInvisibility(loaderIcon);

			LoggerManager.info("Scrolling to Open Violations Log navigation");
			scrollToElement(openViolationsLogSideNav);

			if (isElementDisplayed(openViolationsLogSideNav)) {
				LoggerManager.info("Open Violations Log Menu is visible, clicking on it");
				clickElementJS(openViolationsLogSideNav);
				LoggerManager.info("Successfully searched for the community and accessed Open Violations Log");
				waitForInvisibility(loaderIcon);
				boolean isPageTitle = pageTitle.getText().equals("Open Violations Log");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Open Violations Log Menu is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the community search process");
			return false;
		}
	}

	public String logDetails() {
		try {
			clickElement(logDetails);
			return logDetailLabel.getText();
		} catch (Exception e) {
			LoggerManager.error("Error occurred while retrieving log details" + e.getMessage());
			throw e;
		}
	}

	public boolean violationHistory() {
		try {
			if (isElementDisplayed(historyIcon)) {
				clickElement(historyIcon);
			} else {
				LoggerManager.error("History icon is not displayed.");
			}
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while retrieving violation history: " + e.getMessage());
			return false;
		}
	}

	public boolean historyImage() {
		try {
			if (isElementDisplayed(imageIcon)) {
				clickElement(imageIcon);
				clickElement(imageCloseButton);
			} else {
				LoggerManager.error("Image icon is not displayed.");
			}

			if (isElementDisplayed(historyCloseButton)) {
				clickElement(historyCloseButton);
			}
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while retrieving history image: " + e.getMessage());
			return false;
		}
	}

	public boolean closeButtons() {
		try {
			clickElement(logCloseButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while closing buttons: " + e.getMessage());
			return false;
		}
	}
}