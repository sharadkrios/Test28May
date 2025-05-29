package com.ciranet.myworkqueue.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ProjectsTasksPage extends BasePage {

	public ProjectsTasksPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='Notification Settings']")
	WebElement notificationSettingsButton;

	@FindBy(xpath = "//span[normalize-space()='Open Tasks']")
	WebElement openTasksTab;

	@FindBy(xpath = "//div[@class='dx-item-content dx-tab-content']//span[normalize-space()='Closed Tasks']")
	WebElement closedTasksTab;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Action']")
	WebElement actionButton;

	@FindBy(xpath = "//div[@class='menu-text'][normalize-space()='View / Edit']")
	WebElement viewEditOption;

	@FindBy(xpath = "//div[@class='dx-template-wrapper']//textarea[@role='textbox']")
	WebElement updateShortDesc;

	@FindBy(xpath = "//span[normalize-space()='Refresh']")
	WebElement refreshButtonClick;

	@FindBy(xpath = "//span[@class='dx-button-text'][contains(.,'Cancel')]")
	WebElement cancelButton;

	@FindBy(xpath = "//dx-switch[@aria-label='No']//div[@class='dx-switch-off'][normalize-space()='No']")
	WebElement disableEmailNotification;

	@FindBy(xpath = "//dx-switch[@aria-label='Yes']//div[@class='dx-switch-on'][normalize-space()='Yes']")
	WebElement enableEmailNotification;

	@FindBy(xpath = "//dx-button[@aria-label='Close']//div[@class='dx-button-content']")
	WebElement notificationCloseButton;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayout;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-columnchooser fa-stack-2x']")
	WebElement columnChooser;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement columnChooserClose;

	@FindBy(xpath = "(//a[@class='fas fa-question-circle'])[1]")
	WebElement helpProjectTask;

	@FindBy(xpath = "//span[normalize-space()='Add New Project / Task']")
	WebElement addNewProjectTask;

	@FindBy(xpath = "(//dx-button[@title='Cancel'])[1]")
	WebElement addNewProjectTaskCloseButton;

	@FindBy(xpath = "//input[@max='3650']")
	WebElement daysText;

	@FindBy(xpath = "//span[@class='dx-button-text']")
	WebElement refreshButton;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-angle-double-right']")
	WebElement hideConfiguration;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-angle-double-left']")
	WebElement showConfiguration;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigateToProjectsTasks() {
		try {
			navigationSearch.navigate(By.xpath("//span[contains(.,'Projects / Tasks')]"), "Projects / Tasks");
			TimeUnit.SECONDS.sleep(3);
			return verifyPageHeaderTextMatches("Projects / Tasks");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error occurred while navigating to Projects / Tasks page: " + e);
			return false;
		}
	}

	public boolean verifyTabSwitching() {
		try {
			waitForElementToBeClickable(closedTasksTab);
			clickElement(closedTasksTab);
			TimeUnit.SECONDS.sleep(5);
			LoggerManager.info("Closed Task Tab Selected.");

			if (isElementEnabled(closedTasksTab)) {
				LoggerManager.info("Closed Task Status: True");

			} else {
				LoggerManager.error("Closed Task Status: False");
			}
			waitForElementToBeVisible(openTasksTab);
			clickElement(openTasksTab);
			LoggerManager.info("Open Task Tab Selected.");
			TimeUnit.SECONDS.sleep(3);

			if (isElementEnabled(openTasksTab)) {
				LoggerManager.info("Open Task Status: True");
				return true;
			} else {
				LoggerManager.error("Open Task Status: False");
				return false;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in switch tab: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyRefreshButtonClick() {
		try {
			waitForElementToBeClickable(refreshButtonClick);
			clickElement(refreshButtonClick);
			TimeUnit.SECONDS.sleep(3);
			LoggerManager.info("Refresh button clicked successfully.");
			waitForElementToBeClickable(openTasksTab);

			if (isElementDisplayed(openTasksTab)) {
				LoggerManager.info("Open Task Tab is displayed after refresh.");
				return true;
			} else {
				LoggerManager.error("Open Task Tab is not displayed after refresh.");
				return false;
			}

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred while clicking the refresh button: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyNotificationSettingsButton() {
		try {
			waitForElementToBeClickable(notificationSettingsButton);
			clickElement(notificationSettingsButton);
			TimeUnit.SECONDS.sleep(3);
			LoggerManager
			.info("Notification Setting Button Clicked. Status: " + notificationSettingsButton.isSelected());
			String notificationSettingPopup = driver.getWindowHandle();
			switchToWindow(notificationSettingPopup);
			TimeUnit.SECONDS.sleep(3);
			LoggerManager.info("Switched to Notification Setting popup.");
			waitForElementToBeClickable(disableEmailNotification);
			clickElementJS(disableEmailNotification);
			TimeUnit.SECONDS.sleep(3);
			LoggerManager.info("Disabled email notifications.");
			waitForElementToBeClickable(enableEmailNotification);
			clickElementJS(enableEmailNotification);
			LoggerManager.info("Enabled email notifications.");
			waitForElementToBeClickable(notificationCloseButton);
			clickElementJS(notificationCloseButton);
			TimeUnit.SECONDS.sleep(3);
			LoggerManager.info("Notification Setting popup closed.");
			waitForElementToBeClickable(openTasksTab);

			if (isElementDisplayed(openTasksTab)) {
				LoggerManager.info("Notification settings updated successfully.");
				return true;
			} else {
				LoggerManager.error("Open Task Tab is not displayed after closing the notification settings popup.");
				return false;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred while managing notification settings: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyToolbarExpandAndCollapse() {
		try {
			TimeUnit.SECONDS.sleep(3);
			waitForElementToBeClickable(hideConfiguration);
			if (isElementDisplayed(hideConfiguration)) {
				clickElementJS(hideConfiguration);
				LoggerManager.info("Clicked to hide");
			} else {
				LoggerManager.error("Right arrow is not displayed. Menu might already be hidden.");
			}
			TimeUnit.SECONDS.sleep(3);
			waitForElementToBeClickable(showConfiguration);
			if (isElementDisplayed(showConfiguration)) {
				clickElement(showConfiguration);
				LoggerManager.info("Clicked to display");
				return true;
			} else {
				LoggerManager.error("Left arrow is not displayed. Menu might already be visible.");
				return false;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in expandCollapseClick: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyToolbarFullScreen() {
		try {
			clickElementJS(fullScreenIcon);
			LoggerManager.info("Fullscreen icon clicked successfully.");
			if (isElementDisplayed(normalScreenIcon)) {
				LoggerManager.info("Fullscreen mode activated.");
				return true;
			} else {
				LoggerManager.error("Failed to activate fullscreen mode. Close button not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred in toolBarFullScreen: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyToolbarNormalScreen() {
		try {
			if (isElementDisplayed(normalScreenIcon)) {
				clickElementJS(normalScreenIcon);
				waitForElementToBeClickable(fullScreenIcon);
				LoggerManager.info("Normal screen selected successfully.");
				return true;
			} else {
				LoggerManager.error("Normal screen icon not displayed");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred in toolBarNormalScreen: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyToolbarColumnChooserIcon() {
		try {
			clickElement(resetLayout);
			LoggerManager.info("Reset layout clicked.");

			if (isElementDisplayed(columnChooser)) {

				clickElementJS(columnChooser);
				LoggerManager.info("Column chooser opened.");
				TimeUnit.SECONDS.sleep(3);
				clickElement(columnChooserClose);
				return true;
			} else {
				LoggerManager.error("An error occurred in column Chooser Click");
				return false;
			}

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in column Chooser Click: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyAddNewProjectTaskButton() {
		try {
			waitForElementToBeClickable(addNewProjectTask);

			if (isElementDisplayed(addNewProjectTask)) {

				clickElementJS(addNewProjectTask);
				TimeUnit.SECONDS.sleep(5);
				LoggerManager.info("Add New Project Task Button Clicked.");
				clickElement(addNewProjectTaskCloseButton);
				addNewProjectTaskCloseButton.click();
				TimeUnit.SECONDS.sleep(5);
				LoggerManager.info("add New Project Task Close Button clicked");
				return true;
			} else {
				LoggerManager.error("An error occurred in add New Project Task Button Click");
				return false;
			}

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in add New Project Task Button Click: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyClosedWithinDaysTextBox() {
		try {

			if (isElementDisplayed(closedTasksTab)) {
				clickElement(closedTasksTab);
				TimeUnit.SECONDS.sleep(3);
				clickElement(daysText);
				enterText(daysText, "300");
				LoggerManager.info("Entered 300 Days Filter");
				clickElement(refreshButton);
				LoggerManager.info("Clicked on Refresh");
				TimeUnit.SECONDS.sleep(3);

				return true;

			} else {
				LoggerManager.error("An error occurred while interacting with closed within days textbox");
				return false;
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager
			.error("An error occurred while interacting with closed within days textbox: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyActionViewEdit() {
		try {
			verifyClosedWithinDaysTextBox();
			waitForElementToBeClickable(actionButton);
			if (isElementDisplayed(actionButton)) {
				clickElement(actionButton);
				waitForElementToBeClickable(viewEditOption);
				clickElement(viewEditOption);
				waitForElementToBeClickable(updateShortDesc);
				TimeUnit.SECONDS.sleep(5);
				updateShortDesc.click();

				clickElement(updateShortDesc);
				enterText(updateShortDesc, "Updated Short Description");
				waitForElementToBeClickable(cancelButton);
				clickElement(cancelButton);
				TimeUnit.SECONDS.sleep(5);
				LoggerManager.info("Task Updated on Date");
				return true;
			} else {
				LoggerManager.error("An error occurred while verifying the action button");

				return false;
			}

		}

		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred while verifying the action button: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyHelpIcon() {
		try {

			if (isElementDisplayed(helpProjectTask)) {
				clickElement(helpProjectTask);
				TimeUnit.SECONDS.sleep(3);
				LoggerManager.info("Successfully verified");
				return true;
			} else {
				LoggerManager.error("An error occurred in help Project Task");
				return false;
			}

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in help Project Task" + e.getMessage());
			return false;
		}
	}
}


