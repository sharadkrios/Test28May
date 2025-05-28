package com.ciranet.myworkqueue.disclosureprocessing.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class PropertyConveyancePage extends BasePage {
	public PropertyConveyancePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div//span[normalize-space()='Property Conveyances']")
	WebElement propertyConveyancesSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//td[@aria-label='Column Community']")
	WebElement communityColumn;

	@FindBy(xpath = "(//span[text()='Action'])[3]")
	WebElement actionButton;

	@FindBy(xpath = "(//div[@ng-reflect-klass='menu-text'])[2]")
	WebElement editCommunity;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-button-content']//div[@class='dx-dropdowneditor-icon']")
	WebElement selectCommunityDropdown;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement selectCommunityDropdownValue;

	@FindBy(xpath = "//div//span[normalize-space()='Update']")
	WebElement updateButton;

	@FindBy(xpath = "(//span[@class='dx-button-text'])[54]")
	WebElement editCoummunityUpdate;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[@title='Column Chooser']")
	WebElement columnChooser;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayout;

	@FindBy(xpath = "//div//i[@class='dx-icon dx-icon-close']")
	WebElement closeColChooser;

	@FindBy(xpath = "//div[@class='dx-switch-off']")
	WebElement compactModeOff;

	@FindBy(xpath = "//div[@class='dx-switch-on']")
	WebElement compactModeOn;

	@FindBy(xpath = "(//div[@role='tab'])[2]")
	WebElement completedTab;

	@FindBy(xpath = "(//input[contains(@class,'dx-texteditor-input')])[2]")
	WebElement fromDate;

	@FindBy(xpath = "(//div[@class='menu-text'])[3]")
	WebElement deleteCoummunity;

	@FindBy(xpath = "//dx-button[@hint='Refresh'][contains(.,'Refresh')]")
	WebElement refreshButton;

	@FindBy(xpath = "(//div[@class=\"dx-button-content\"])[13]")
	WebElement showSearch;

	@FindBy(xpath = "(//div[@aria-label='Action'])[1]")
	WebElement actionProcess;

	@FindBy(xpath = "(//div[@ng-reflect-klass='menu-text'])[1]")
	WebElement processProperty;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-minus-square']")
	WebElement collapseAllIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandAllIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetButton;

	@FindBy(xpath = "//div[@class='dx-loadpanel-content-wrapper']")
	WebElement loaderIcon;

	@FindBy(xpath = "//div[@class='dx-loadpanel-content-wrapper']")
	WebElement loaderofPropertyOwnershipConveyance;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']//div[@class='dx-loadpanel-content-wrapper']")
	WebElement loaderOfPage;

	@FindBy(xpath = "(//div//dx-button[@class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text dx-button-has-icon'])[2]")
	WebElement searchWorkQueue;

	@FindBy(xpath = "//div[@class='dx-group-panel-message']")
	WebElement toGroupPanel;

	@FindBy(xpath = "//div//span[normalize-space()='Close']")
	WebElement errorMessageCloseButton;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-popup-title dx-has-close-button']")
	WebElement errorMessagePopupTitle;

	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//div//span[normalize-space()='Property Conveyances']"),
					"Property Conveyances");
			LoggerManager.info("Navigated to 'Property Conveyances'");
			LoggerManager.info("Scrolling to Property Conveyances navigation");
			scrollToElement(propertyConveyancesSideNav);

			if (isElementDisplayed(propertyConveyancesSideNav)) {
				LoggerManager.info("Property Ownership Conveyance is visible, clicking on it");
				clickElementJS(propertyConveyancesSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed Property Conveyances");

				boolean isPageTitle = pageTitle.getText().equals("Property Ownership Conveyance");

				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Property Conveyances is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}

	}

	public boolean fullScreen() {
		try {
			scrollToElement(fullScreenIcon);
			clickElement(fullScreenIcon);
			waitForInvisibility(loaderIcon);

			if (normalScreenIcon.isDisplayed()) {
				LoggerManager.info("Toolbar switched to full screen successfully.");
				return true;
			} else {
				LoggerManager.warn("Full screen icon not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in verifyFullScreen: " + e.getMessage());
			throw e;
		}
	}

	public boolean normalScreen() {
		try {
			scrollToElement(normalScreenIcon);
			clickElementJS(normalScreenIcon);
			waitForInvisibility(loaderIcon);

			if (fullScreenIcon.isDisplayed()) {
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Toolbar switched to normal screen successfully.");
				return true;
			} else {
				LoggerManager.warn("Normal screen icon not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in verifyNormalScreen: " + e.getMessage());
			throw e;
		}
	}

	public boolean columnChooser() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(resetLayout);
			clickElementJS(columnChooser);
			waitForElementToBeVisible(closeColChooser);
			clickElement(closeColChooser);
			LoggerManager.info("Column chooser clicked successfully.");
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in verifyColumnChooser: " + e.getMessage());
			throw e;
		}
	}

	public boolean expandOption() {
		try {
			Actions act = new Actions(driver);
			act.dragAndDrop(communityColumn, toGroupPanel).build().perform();
			clickElement(collapseAllIcon);
			clickElement(expandAllIcon);
			waitForInvisibility(loaderIcon);
			clickElementJS(resetButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in verifyExpandIcon: " + e.getMessage());
			throw e;
		}
	}

	public boolean editCommunity() {
		try {
			clickElement(actionButton);
			waitForElementToBeVisible(editCommunity);
			clickElement(editCommunity);
			waitForInvisibility(loaderIcon);
			clickElementJS(selectCommunityDropdown);
			clickElementJS(selectCommunityDropdownValue);
			waitForElementToBeVisible(updateButton);
			clickElementJS(updateButton);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in verifyEditCommunity: " + e.getMessage());
			throw e;
		}

	}

	public boolean deleteCommunity() {
		try {
			clickElementJS(actionButton);
			waitForElementToBeVisible(deleteCoummunity);
			clickElementJS(deleteCoummunity);
			pressEscapeKey();
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in verifyDeleteCommunity: " + e.getMessage());
			return false;

		}
	}

	public boolean refreshButton() {
		try {
			if (isElementDisplayed(refreshButton)) {
				waitForInvisibility(loaderIcon);
				clickElementJS(refreshButton);
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Refresh button clicked and page refreshed successfully.");
				return true;
			} else {
				LoggerManager.warn("Refresh button not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in verifyRefresh: " + e.getMessage());
			throw e;
		}
	}

	public boolean processPropertyConveyanceCompactMode() {
		try {
			waitForInvisibility(loaderOfPage);
			clickElementJS(actionProcess);
			clickElement(processProperty);
			if (isElementDisplayed(errorMessagePopupTitle)) {
				clickElement(errorMessageCloseButton);
			}
			if (isElementDisplayed(compactModeOff)) {
				clickElementJS(compactModeOff);
				waitForElementToBeVisible(compactModeOn);
				clickElementJS(compactModeOn);
				waitForInvisibility(loaderIcon);
				pressEscapeKey();
				LoggerManager.info("Compact mode toggled on successfully.");
				return true;
			} else {
				pressEscapeKey();
				LoggerManager.warn("Compact mode on button not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in verifyProcessPropertyConveyanceCompactMode: " + e.getMessage());
			return false;

		}

	}

	public boolean searchWorkQueue() {
		try {
			waitForInvisibility(loaderIcon);
			completedTab();
			fromDate.clear();
			fromDate.sendKeys("01/01/2020");
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in verifySearchWorkQueue: " + e.getMessage());
			throw e;
		}
	}

	public boolean completedTab() {
		try {
			clickElementJS(completedTab);
			waitForInvisibility(loaderIcon);
		} catch (Exception e) {
			LoggerManager.error("Error in completedTab: " + e.getMessage());
			throw e;
		}
		return false;
	}
}
