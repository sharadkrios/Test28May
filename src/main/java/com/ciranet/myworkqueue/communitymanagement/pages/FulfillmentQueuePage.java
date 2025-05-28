package com.ciranet.myworkqueue.communitymanagement.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class FulfillmentQueuePage extends BasePage {
	public FulfillmentQueuePage(WebDriver driver) {
		super(driver);
	}

	// Initializing the Page Objects
	@FindBy(xpath = "//div[@title='Fulfillment Queue']//div[@class='header-text']")
	WebElement fulfillmentQueueSideNav;

	@FindBy(xpath = "//h2[@class='page-header'][contains(.,'Fulfillment Queue')]")
	WebElement pageTitle;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon far fa-minus-square']")
	WebElement collapseIcon;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandIcon;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[@title='Column Chooser']")
	WebElement columnChooserButton;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeColChooserButton;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayoutButton;

	@FindBy(xpath = "//div[@class='dx-item-content dx-tab-content']//span[normalize-space()='Closed Jobs']")
	WebElement closedJobsTab;

	@FindBy(xpath = "//span[normalize-space()='Active Jobs']")
	WebElement activeJobsTab;

	@FindBy(xpath = "(//div[@class='dx-button-content'][contains(.,'Action')])[1]")
	WebElement actionButton;

	@FindBy(xpath = "(//div[text()=' View/Edit '])[1]")
	WebElement viewOrEditMenu;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement actionSaveButton;

	@FindBy(xpath = "(//span[text()='Close'])[2]")
	WebElement errorClose;

	@FindBy(xpath = "//span[text()='Close']")
	WebElement closeButton;

	@FindBy(xpath = "//span[text()='Refresh Queue']")
	WebElement refreshQueueButton;

	@FindBy(xpath = "//div[@title='Close']//div[@class='dx-button-content']")
	WebElement popupClose;

	@FindBy(xpath = "//span[text()='Documents']")
	WebElement documentsTab;

	@FindBy(xpath = "//i[@class='dx-icon fas fa-times']")
	WebElement documentsCloseButton;

	@FindBy(xpath = "//span[text()='Completion Job']")
	WebElement completionJobTab;

	@FindBy(xpath = "//i[@title='Show Notes']")
	WebElement showNotesIcon;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text dx-button-has-icon' and @title='Close']")
	WebElement completionJobClose;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-toolbar-item-content'][contains(.,'Save')])[1]")
	WebElement completionJobSave;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-toolbar-item-content'][contains(.,'Save & Close')])[1]")
	WebElement completionJobSaveandClose;

	@FindBy(xpath = "(//textarea[@role='textbox'])[4]")
	WebElement fulfillmentTextBox;

	@FindBy(xpath = "(//span[text()='Save'])[2]")
	WebElement textBoxSave;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-button-content']//div[@class='dx-dropdowneditor-icon']")
	WebElement communityFilter;

	@FindBy(xpath = "//td[normalize-space()='1100 Trinity Mills Condos']")
	WebElement communityFilterValue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[2]")
	WebElement searchBy;

	@FindBy(xpath = "//div[@class='dx-item-content dx-list-item-content'][normalize-space()='Request Date']")
	WebElement searchByValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input' and @type='text' and @role='combobox'])[2]")
	WebElement beginDate;

	@FindBy(xpath = "//div[@title='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']//div[@class='dx-loadpanel-content-wrapper']")
	WebElement closedTabLoader;

	@FindBy(xpath = "//dx-button[@aria-label='Add Job']")
	WebElement addJobButton;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container'])[49]")
	WebElement jobType;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[1]")
	WebElement jobValue;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[2]")
	WebElement jobValueCompletedJobButton;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input' and @type='text' and @role='combobox'])[19]")
	WebElement sendTo;

	@FindBy(xpath = "(//div[@class='dx-treelist-empty-space dx-treelist-collapsed'])[1]")
	WebElement managementCompanyExpand;

	@FindBy(xpath = "(//div[@class='dx-treelist-empty-space dx-treelist-collapsed'])[2]")
	WebElement locationExpand;

	@FindBy(xpath = "(//div[contains(@class,'dx-treelist-text-content')])[4]")
	WebElement communitySelection;

	@FindBy(xpath = "//div[text()='Amberwood']")
	WebElement sendToValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input' and @type='text' and @role='combobox'])[20]")
	WebElement paperType;

	@FindBy(xpath = "//div[text()='Standard Weight']")
	WebElement paperTypeValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input' and @type='text' and @role='combobox'])[21]")
	WebElement ink;

	@FindBy(xpath = "//div[text()='Black & White']")
	WebElement inkValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input' and @type='text' and @role='combobox'])[22]")
	WebElement paperColor;

	@FindBy(xpath = "//div[text()='White']")
	WebElement paperColorValue;

	@FindBy(xpath = "(//label[@class='dx-field-item-label dx-field-item-label-location-top'])[11]")
	WebElement postage;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input' and @type='text' and @role='combobox'])[23]")
	WebElement postagePaid;

	@FindBy(xpath = "(//div[text()='Yes'])[2]")
	WebElement postagePaidValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input' and @type='text' and @role='combobox'])[24]")
	WebElement residents;

	@FindBy(xpath = "(//div[text()='No'])[2]")
	WebElement residentsValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input' and @type='text' and @role='combobox'])[25]")
	WebElement outside;

	@FindBy(xpath = "//div[text()='None']")
	WebElement outsideValue;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-success dx-button-has-text dx-button-has-icon' and @aria-label='Save']")
	WebElement saveClose;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-tab-content'])[5]")
	WebElement addCompletionJob;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container'])[68]")
	WebElement closeJob;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[1]")
	WebElement closeJobValue;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text dx-button-has-icon' and @title='Add Item']")
	WebElement addItem;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text dx-button-has-icon' and @aria-label='Close']")
	WebElement addCompletionJobClose;

	@FindBy(xpath = "//dx-button[@aria-label='Add Completed Job']")
	WebElement addCompletedJob;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text dx-dialog-button' and @aria-label='Yes']")
	WebElement confirmation;

	@FindBy(xpath = "//span[@class='dx-button-text'][contains(.,'Yes')]")
	WebElement confirmationYes;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text dx-button-has-icon' and @title='Close']")
	WebElement completedJobClose;

	@FindBy(xpath = "//td[@aria-label='Sunday, November 1, 2020' and @class='dx-calendar-cell dx-calendar-contoured-date' ]")
	WebElement beginDateValue;

	@FindBy(xpath = "//div[@title='Save']")
	WebElement saveDocument;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text dx-button-has-icon' and @aria-label='Close']")
	WebElement addJobButtonClose;

	@FindBy(xpath = "//dx-button[@type='success']")
	WebElement addSuccessMsg;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//dx-button[@title='Delete']//div[@class='dx-button-content']")
	WebElement deleteItemIcon;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[normalize-space()='Fulfillment Queue']"),
					"Fulfillment Queue");

			scrollToElement(fulfillmentQueueSideNav);
			clickElementJS(fulfillmentQueueSideNav);

			Boolean isPageTitle = pageTitle.getText().equals("Fulfillment Queue");
			LoggerManager.info("Label text validation: " + (Boolean.TRUE.equals(isPageTitle) ? "Passed" : "Failed"));
			waitForElementToBeVisible(pageTitle);
			return isPageTitle;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean toolBarFullScreen() {
		try {
			LoggerManager.info("Loader icon is no longer visible.");

			clickElementJS(fullScreenIcon);
			LoggerManager.info("Clicked on the fullscreen icon.");

			waitForElementToBeVisible(normalScreenIcon);
			// Check if the normal screen icon is displayed
			if (isElementDisplayed(normalScreenIcon)) {
				LoggerManager.info("Normal screen icon is displayed. Reverting to normal mode.");
				LoggerManager.info("Successfully reverted to normal mode.");
				return true;
			} else {
				LoggerManager.error("Normal screen icon is not displayed. Fullscreen toggle may have failed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the toolbar fullscreen toggle: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean toolBarNormalScreen() {
		try {
			LoggerManager.info("Attempting to switch to Normal Screen mode...");
			scrollToElement(normalScreenIcon);
			clickElementJS(normalScreenIcon);

			waitForElementToBeVisible(fullScreenIcon);
			if (fullScreenIcon.isDisplayed()) {
				LoggerManager.info("Successfully switched to Normal Screen mode.");
				return true;
			} else {
				LoggerManager.error("Failed to switch to Normal Screen mode. Full Screen icon not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred while switching to Normal Screen mode: " + e.getMessage());
			return false;
		}
	}

	public boolean expandCollapseOptionsClick() {
		try {
			LoggerManager.info("Attempting to collapse the UI section.");
			clickElementJS(collapseIcon);

			LoggerManager.info("Attempting to expand the UI section.");
			waitForElementToBeVisible(expandIcon);
			clickElementJS(expandIcon);

			LoggerManager.info("Expand and collapse actions completed successfully.");
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while performing expand/collapse actions." + e);
			return false;
		}
	}

	public boolean columnChooserClick() {
		try {
			
			waitForInvisibility(loaderIcon);

			clickElementJS(resetLayoutButton);
			LoggerManager.info("Clicked on Reset Layout button.");

			clickElement(columnChooserButton);
			LoggerManager.info("Clicked on Column Chooser button.");

			WebElement columnChooserPopup = driver.findElement(By.xpath("//div[contains(text(),'Column Chooser')]"));
			waitForElementToBeVisible(columnChooserPopup);

			boolean checkColumnChooserTitle = columnChooserPopup.getText().equals("Column Chooser");
			LoggerManager.info("Page Title validation: " + (checkColumnChooserTitle ? "Passed" : "Failed"));

			clickElementJS(closeColChooserButton);
			LoggerManager.info("Clicked on Close Column Chooser button.");

			return checkColumnChooserTitle;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in columnChooserClick method: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean switchTab() {
		try {
			LoggerManager.info("Attempting to switch to Closed Jobs tab...");
			
			if (closedJobsTab.isEnabled()) {
				clickElementJS(closedJobsTab);
				LoggerManager.info("Closed Jobs tab is enabled.");
			} else {
				LoggerManager.info("Closed Jobs tab is not enabled.");
			}

			LoggerManager.info("Switching to Active Jobs tab...");

			if (activeJobsTab.isEnabled()) {
				clickElementJS(activeJobsTab);
				LoggerManager.info("Active Jobs tab is successfully enabled.");
				return true;
			} else {
				LoggerManager.error("Failed to enable Active Jobs tab.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred while switching tabs: " + e.getMessage());
			return false;
		}
	}

	// Commonmethod used to select View/Edit menu
	public void viewOrEdit() {
		try {
			waitForElementToBeVisible(actionButton);
			LoggerManager.info("Attempting to click on the action button...");
			clickElement(actionButton);
			LoggerManager.info("Action button clicked successfully.");

			LoggerManager.info("Attempting to click on the View/Edit option...");
			clickElement(viewOrEditMenu);
			LoggerManager.info("View/Edit option clicked successfully.");
		} catch (Exception e) {
			LoggerManager.error("Error occurred in viewedit method: " + e.getMessage() + e);
		}
	}

	public boolean saveButtonClick() {
		try {
			LoggerManager.info("Starting the action save process...");

			// Call the viewedit method and log the operation
			LoggerManager.info("Calling the viewOrEdit method.");
			viewOrEdit();
			LoggerManager.info("View/Edit method executed successfully.");

			// Check if the Save button is displayed and proceed
			LoggerManager.info("Checking if the Save button is displayed.");
			if (isElementDisplayed(saveClose)) {
				clickElement(saveClose);
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Save button clicked successfully.");
				return true;
			} else {
				LoggerManager.error("Error while clicking on Save button");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in actionSaveClick method: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean verifyActionCloseButton() {
		try {
			LoggerManager.info("Starting verification of the Action Close button...");

			// Call the viewOrEdit method
			LoggerManager.info("Calling the viewOrEdit method...");
			viewOrEdit();
			LoggerManager.info("viewOrEdit method executed successfully.");

			// Switch to the popup window
			LoggerManager.info("Switching to the fulfillment popup window...");
			String fulfillmentPopup = driver.getWindowHandle();
			driver.switchTo().window(fulfillmentPopup);
			LoggerManager.info("Switched to the fulfillment popup window.");

			// Wait for the close button to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(popupClose));

			// Check if the close button is displayed
			if (isElementDisplayed(popupClose)) {
				LoggerManager.info("Popup close button is displayed. Attempting to click...");
				clickElement(popupClose);
				LoggerManager.info("Popup close button clicked successfully.");
				return true;
			} else {
				LoggerManager.error("Popup close button is not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in verifyActionCloseButton method: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean refreshQueueButton() {
		try {
			LoggerManager.info("Starting refreshQueueButton operation...");

			// Check if the refreshQueueButton is displayed
			if (isElementDisplayed(refreshQueueButton)) {
				LoggerManager.info("Refresh Queue button is displayed. Attempting to click.");
				clickElement(refreshQueueButton);

				LoggerManager.info("Refresh Queue button clicked successfully.");
				return true;
			} else {
				LoggerManager.error("Refresh Queue button is not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in refreshQueueButton method: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean actionDocumentTabClick() {
		try {
			LoggerManager.info("Starting actionDocumentTabClick operation.");
			viewOrEdit();
			
			LoggerManager.info("viewOrEdit method executed successfully.");

			// Check if the documents element is displayed
			if (isElementDisplayed(documentsTab)) {
				LoggerManager.info("Documents tab is displayed. Attempting to click.");
				clickElement(documentsTab);
				LoggerManager.info("Documents tab clicked successfully.");

				// Click the close button on the documents tab
				clickElement(documentsCloseButton);
				LoggerManager.info("Documents tab closed successfully.");
				return true;
			} else {
				LoggerManager.error("Documents tab is not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in actionDocumentTabClick method: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean addNotesOnCompletionJobTab() {
		try {
			LoggerManager.info("Starting actionCompletionTabClick operation...");

			viewOrEdit();

			clickElement(completionJobTab);
			LoggerManager.info("Clicked on Completion Job.");

			clickElement(showNotesIcon);
			LoggerManager.info("Clicked on showNotes.");

			fulfillmentTextBox.sendKeys("Notes of Fulfillment");
			LoggerManager.info("Entered notes in textBox.");

			waitForElementToBeClickable(textBoxSave);
			clickElement(textBoxSave);
			LoggerManager.info("Saved notes in textBox.");

			clickElementJS(completionJobClose);
			LoggerManager.info("Closed completionJob.");

			return true;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in actionCompletionTabClick: " + e.getMessage() + e);
			return false;
		}
	}

	private void robotEscKeyPress() {
		try {
			LoggerManager.info("Performing Escape key action using Robot class...");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			robot.delay(100);
		} catch (java.awt.AWTException e) {
			LoggerManager.error("Error occurred while pressing Escape key: " + e.getMessage() + e);
		}
	}
	
	public boolean addJobSaveAndCloseButton() {
		clickElement(addJobButton);
		String addJobPopupWindow = driver.getWindowHandle();
		driver.switchTo().window(addJobPopupWindow);
		clickElement(jobType);
		waitForElementToBeClickable(jobValue);
		clickElementJS(jobValue);

		clickElementJS(sendTo);

		// this is to select Management Company, Location and
		managementCompanyExpand.click();
		locationExpand.click();
		communitySelection.click();

		clickElementJS(paperType);
		clickElementJS(paperTypeValue);
		
		clickElementJS(ink);
		clickElementJS(inkValue);
		
		clickElementJS(paperColor);
		clickElementJS(paperColorValue);
		
		clickElementJS(postage);
		clickElementJS(postagePaid);
		clickElementJS(postagePaidValue);
		
		clickElementJS(residents);
		clickElementJS(residentsValue);
		
		clickElementJS(outside);
		clickElementJS(outsideValue);
		
		clickElementJS(saveClose);

		String addPopup = driver.getWindowHandle();
		driver.switchTo().window(addPopup);
		if (isElementDisplayed(confirmationYes)) {
			clickElementJS(confirmationYes);

			robotEscKeyPress();

			return true;
		} else {
			return false;
		}
	}

	public boolean addCompletionJobAddItemTab() {
		try {
			LoggerManager.info("Starting addCompletionJobTab operation...");

			LoggerManager.info("Clicking on Add Job Button...");
			clickElement(addJobButton);

			LoggerManager.info("Clicking on Add Completion Job...");
			clickElementJS(addCompletionJob);

			waitForElementToBeClickable(addItem);

			LoggerManager.info("Clicking on Add Item...");
			clickElement(addItem);

			if (isElementDisplayed(deleteItemIcon)) {
				LoggerManager.info("Delete Item icon is displayed. ");
				waitForElementToBeVisible(deleteItemIcon);
				clickElementJS(deleteItemIcon);
				LoggerManager.info("Add Item and Delete item is working.");
				return true;
			} else {
				LoggerManager.error("Error while adding and deleting item.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in addCompletionJobTab: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean closedJobsSearchButton() {
		try {
			LoggerManager.info("Starting closedJobsSearchButton operation...");

			LoggerManager.info("Clicking on Closed Jobs Tab.");
			if (closedJobsTab.isEnabled()) {
				clickElementJS(closedJobsTab);
				LoggerManager.info("Closed jobs tab is enabled.");
			} else {
				LoggerManager.error("Closed jobs tab is not enabled.");
			}

			LoggerManager.info("Selecting Community Filter...");
			clickElementJS(communityFilter);

			LoggerManager.info("Selecting Community Filter Value...");
			clickElementJS(communityFilterValue);

			LoggerManager.info("Setting Begin Date...");
			clickElementJS(beginDate);
			beginDate.clear();
			beginDate.sendKeys("09/01/2020");
			beginDate.sendKeys(Keys.TAB);
			waitForElementToBeClickable(searchButton);
			scrollToElement(searchButton);
			LoggerManager.info("Clicking on Search Button...");
			clickElementJS(searchButton);
			waitForElementToBeVisible(actionButton);

			LoggerManager.info("Verifying if Action Button is displayed in a row...");
			if (actionButton.isDisplayed()) {
				LoggerManager.info("Action button is displayed. Search operation successful.");
				return true;
			} else {
				LoggerManager.error("Action button is not displayed. Search operation failed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in closedJobsSearchButton: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean addCompletedJobbuttonSaveandAddDocuments() {
		try {
			LoggerManager.info("Starting addCompletedJobbuttonSaveandAddDocuments operation...");

			waitForElementToBeClickable(addCompletedJob);
			clickElementJS(addCompletedJob);

			LoggerManager.info("Switching to the Add Completed Job Popup window...");
			String addcompletedJobPopup = driver.getWindowHandle();
			driver.switchTo().window(addcompletedJobPopup);

			LoggerManager.info("Clicking on Confirmation button...");
			waitForElementToBeClickable(confirmation);
			clickElementJS(confirmation);

			LoggerManager.info("Checking if Save Document button is displayed...");
			if (isElementDisplayed(saveDocument)) {
				LoggerManager.info("Save Document button is displayed. Clicking Save Document...");
				clickElementJS(saveDocument);
				
				robotEscKeyPress();

				LoggerManager.info("Add Completed Job and Save Documents operation completed successfully.");
				return true;
			} else {
				LoggerManager.error("Save Document button is not displayed. Operation failed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in addCompletedJobbuttonSaveandAddDocuments: " + e.getMessage() + e);
			return false;
		}
	}

	public boolean addCompletedJobAndCloseButtonClick() {
		try {
			LoggerManager.info("Checking if the Completed Job Close button is displayed...");
			waitForElementToBeClickable(addCompletedJob);
			clickElementJS(addCompletedJob);

			LoggerManager.info("Switching to the Add Completed Job Popup window...");
			String addcompletedJobPopup = driver.getWindowHandle();
			driver.switchTo().window(addcompletedJobPopup);

			LoggerManager.info("Clicking on Confirmation button...");
			waitForElementToBeClickable(confirmation);
			clickElementJS(confirmation);

			if (isElementDisplayed(completedJobClose)) {
				LoggerManager.info("Completed Job Close button is displayed. Clicking the button...");
				clickElementJS(completedJobClose);
				LoggerManager.info("Operation completed successfully. Returning true.");
				return true;
			} else {
				LoggerManager.warn("Completed Job Close button is not displayed. Returning false.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error(
					"An error occurred while interacting with the Completed Job Close button: " + e.getMessage());
			return false;
		}
	}
}