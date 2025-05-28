package com.ciranet.community.information.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class InsurancePage extends BasePage {

	@FindBy(xpath = "//h2[@class='page-header']")
	private WebElement pageTitle;

	@FindBy(xpath = "//div//span[normalize-space()='Insurance']")
	WebElement insuranceSideNav;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']")
	private WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-widget dx-button-mode-contained dx-button-normal dx-dropdowneditor-button']//div[@class='dx-button-content']//div[@class='dx-dropdowneditor-icon'])[1]")
	private WebElement showAllDropdownIcon;

	@FindBy(xpath = "//div[contains(text(),'Show All')]")
	private WebElement showAllDropdownValue;

	@FindBy(xpath = "//div[@class='dx-item dx-tab']/div[@class='dx-item-content dx-tab-content']/span[@class='dx-tab-text' and text()='Internal Tasks']")
	private WebElement internalTaskTab;

	@FindBy(xpath = "//div//span[normalize-space()='Add Task']")
	private WebElement addTaskButton;

	@FindBy(xpath = "//input[@name='internalTask.shortDescription']")
	private WebElement shortDescriptionTextBox;

	@FindBy(xpath = "//textarea[@name='internalTask.description']")
	private WebElement descriptionTextBox;

	@FindBy(xpath = "((//dx-box[@class='dx-box-flex dx-box dx-widget dx-visibility-change-handler dx-collection'])[8]//div[@class='dx-dropdowneditor-icon'])[1]")
	private WebElement priorityDropdown;

	@FindBy(xpath = "//div[contains(text(),'Low')]")
	private WebElement priorityDropdownValue;

	@FindBy(xpath = "((//dx-box[@class='dx-box-flex dx-box dx-widget dx-visibility-change-handler dx-collection'])[8]//div[@class='dx-dropdowneditor-icon'])[2]")
	private WebElement dueDateDatepicker;

	@FindBy(xpath = "//div//td[@class='dx-calendar-cell dx-calendar-today dx-calendar-contoured-date']")
	private WebElement dueDateDatepickerValue;

	@FindBy(xpath = "//div//span[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[1]")
	private WebElement activeFilterDropdown;

	@FindBy(xpath = "//div[contains(text(),'All Tasks')]")
	private WebElement activeFilterDropdownValue;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-plus-square']")
	private WebElement expandAllIcon;

	@FindBy(xpath = "(//div//span[@class='dx-button-text'][normalize-space()='Action'])[1]")
	private WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	private WebElement editMenu;

	@FindBy(xpath = "//div[contains(text(),' Edit Task:')]")
	private WebElement editPopupTitle;

	@FindBy(xpath = "//div[contains(@class, 'dx-button') and @title='Reset Layout']/div[contains(@class, 'dx-button-content')]/i[contains(@class, 'fas fa-ban')] ")
	private WebElement resetIcon;

	@FindBy(xpath = "//div[contains (text(),'Change Status To')]")
	private WebElement changeStatusToMenu;

	@FindBy(xpath = "//div[contains(text(),'Open')]")
	private WebElement openChangeStatusToMenu;

	@FindBy(xpath = "//div[contains(text(),'Change Assign To')]")
	private WebElement changeAssignToMenu;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[13]")
	private WebElement selectAssignToDropdown;

	@FindBy(xpath = "//div[@class='dx-datagrid-content']//tr[@aria-rowindex='1']")
	private WebElement selectAssignToDropdownValue;

	@FindBy(xpath = "//div[contains(text(),'Delete Task')]")
	private WebElement deleteTaskMenu;

	@FindBy(xpath = "//div//span[normalize-space()='No']")
	private WebElement noConfirmationButton;

	@FindBy(xpath = "//div[contains(text(),'Confirmation')]")
	private WebElement confirmationPopupTitle;

	@FindBy(xpath = "//div//span[normalize-space()='Completed / Closed Tasks']")
	private WebElement completedClosedTasks;

	@FindBy(xpath = "//div//span[normalize-space()='Days']")
	private WebElement daysLabel;

	@FindBy(xpath = "//div//span[normalize-space()='Refresh']")
	private WebElement refreshButton;

	public InsurancePage(WebDriver driver) {
		super(driver);
	}

	private String communitySearchTextFromParameter;
	Navigation navigationSearch = new Navigation(driver);

	public String getCommunitySearchTextFromParameter() {
		return communitySearchTextFromParameter;
	}

	public void setCommunitySearchTextFromParameter(String communitySearchTextFromParameter) {
		this.communitySearchTextFromParameter = communitySearchTextFromParameter;
	}

	public void pressEscapeKey() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public boolean navigateToInsurance(String communityName) {
		navigationSearch.navigateToCommunityContext(communityName);
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Community search completed for keyword: {} " + communityName);
		try {
			LoggerManager.info("Pressing Escape key to close any popups if present");
			pressEscapeKey();
		} catch (NoSuchElementException e) {

			LoggerManager.error("Error pressing the Escape key");
		}

		try {
			navigationSearch.navigate(By.xpath("//span[normalize-space()='Insurance']"), "Insurance");
			waitForInvisibility(loaderIcon);
			scrollToElement(insuranceSideNav);
			if (isElementDisplayed(insuranceSideNav)) {
				boolean isPageTitle = "Insurance".equals(pageTitle.getText());
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.info("Insurance is not visible");
				return false;
			}
		} catch (NoSuchElementException e) {
			LoggerManager.error("An error occurred during the search process");
			return false;
		}

	}

	public String showAllRecords() {
		try {
			waitForInvisibility(loaderIcon);
			waitForElementToBeClickable(showAllDropdownIcon);
			clickElementJS(showAllDropdownIcon);
			clickElementJS(showAllDropdownValue);
			String showAllDropdownText = showAllDropdownValue.getText();
			waitForInvisibility(loaderIcon);
			return showAllDropdownText;
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while displaying the all records in the grid" + e.getMessage());
			throw e;
		}
	}

	public String addTask() {
		try {
			waitForElementToBeClickable(internalTaskTab);
			clickElementJS(internalTaskTab);
			waitForElementToBeClickable(addTaskButton);
			clickElementJS(addTaskButton);
			String addTaskButtonText = addTaskButton.getText();
			clickElementJS(shortDescriptionTextBox);
			shortDescriptionTextBox.sendKeys("Testing");
			clickElementJS(descriptionTextBox);
			descriptionTextBox.sendKeys("Testing Purpose");
			scrollToElement(priorityDropdown);
			clickElementJS(priorityDropdown);
			clickElementJS(priorityDropdownValue);
			scrollToElement(dueDateDatepicker);
			clickElementJS(dueDateDatepicker);
			clickElementJS(dueDateDatepickerValue);
			waitForElementToBeClickable(saveButton);
			clickElementJS(saveButton);
			waitForInvisibility(loaderIcon);
			return addTaskButtonText;
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while adding the task" + e.getMessage());
			throw e;
		}
	}

	public boolean editTask() {
		try {
			waitForElementToBeClickable(resetIcon);
			clickElementJS(resetIcon);
			waitForElementToBeClickable(activeFilterDropdown);
			clickElementJS(activeFilterDropdown);
			clickElementJS(activeFilterDropdownValue);
			clickElementJS(expandAllIcon);
			waitForElementToBeVisible(actionButton);
			clickElementJS(actionButton);
			clickElementJS(editMenu);
			waitForInvisibility(loaderIcon);
			String editPopupTitleText = editPopupTitle.getText();
			String expectedPopupTitle = "Edit Task:";
			boolean isPopupTitle = editPopupTitleText.contains(expectedPopupTitle);
			if (!isPopupTitle) {
				LoggerManager.error(
						"Popup title mismatch. Expected: " + expectedPopupTitle + ", but found: " + editPopupTitleText);
				return false;
			}
			clickElementJS(saveButton);
			waitForInvisibility(loaderIcon);
			return isPopupTitle;
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while editing the task" + e.getMessage());
			throw e;
		}
	}

	public String changeStatusTo() {
		try {
			waitForElementToBeVisible(actionButton);
			clickElementJS(actionButton);
			Actions action = new Actions(driver);
			clickElementJS(changeStatusToMenu);
			action.moveToElement(openChangeStatusToMenu).click().build().perform();
			String openChangeStatusText = openChangeStatusToMenu.getText();
			waitForInvisibility(loaderIcon);
			return openChangeStatusText;
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while changing the status" + e.getMessage());
			throw e;
		}
	}

	public boolean changeAssignTo() {
		try {
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(actionButton);
			clickElementJS(actionButton);
			clickElementJS(changeAssignToMenu);
			waitForInvisibility(loaderIcon);
			waitForElementToBeClickable(selectAssignToDropdown);
			clickElementJS(selectAssignToDropdown);
			waitForElementToBeVisible(selectAssignToDropdownValue);
			if (isElementDisplayed(selectAssignToDropdownValue)) {
				clickElementJS(selectAssignToDropdownValue);
				waitForInvisibility(loaderIcon);
				return true;
			} else {
				LoggerManager.warn("Assign To dropdown value is not displayed.");
				return false;
			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while changing the assignee: " + e.getMessage());
			return false;
		}
	}

	public boolean deleteTask() {
		try {
			waitForElementToBeVisible(actionButton);
			clickElementJS(actionButton);
			clickElementJS(deleteTaskMenu);
			String confirmationPopupTitleText = confirmationPopupTitle.getText();
			if (!confirmationPopupTitleText.contains("Confirmation")) {
				LoggerManager.warn("Delete confirmation popup did not appear as expected.");
				return false;
			} else {
				clickElementJS(noConfirmationButton);
				LoggerManager.info("Delete action was canceled.");
				return true;
			}
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while deleting the task" + e.getMessage());
			return false;
		}
	}

	public boolean isCompletedClosedTaskDisplay() {
		try {
			waitForElementToBeClickable(completedClosedTasks);
			clickElementJS(completedClosedTasks);
			boolean daysVisible = isElementDisplayed(daysLabel);
			clickElementJS(refreshButton);
			return daysVisible;
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager
					.error("Error occurred while displaying the completed and closed task in 180 Days" + e.getMessage());
			throw e;
		}
	}
}