package com.ciranet.community.compliance.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.quicksearch.QuickSearch;
import com.ciranet.utilities.LoggerManager;

public class DetailedViolationsLogPage extends BasePage {

	public DetailedViolationsLogPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Detailed Violations Log')]")
	WebElement detailedViolationsLogSideNav;

	@FindBy(xpath = "//h2[text()=' Detailed Violations Log ']")
	WebElement pageTitle;

	@FindBy(xpath = "//dx-button[@text='Refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "//div[@title='Reset Layout']")
	WebElement resetIcon;

	@FindBy(xpath = "//div[@class='dx-group-panel-item dx-datagrid-action dx-datagrid-drag-action']")
	WebElement categoryColumnDrag;

	@FindBy(xpath = "//td[normalize-space()='Status']")
	WebElement categoryColumnDrop;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Action')])[2]")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Escalate Violation')]")
	WebElement escalateViolationMenu;

	// Open Tab
	// Escalate Violations Menu
	@FindBy(xpath = "(//textarea[@role='textbox'])[2]")
	WebElement violationNotesTextbox;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[16]")
	WebElement actionDropdown;

	@FindBy(xpath = "//div[@class='dx-item-content dx-list-item-content'][normalize-space()='Not Fixed']")
	WebElement actionDropdownValue;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Escalate Existing Violation']")
	WebElement escalateExistingViolationButton;

	// Close Violation Menu
	@FindBy(xpath = "//div[contains(text(),'Close Violation')]")
	WebElement closeViolationMenu;

	@FindBy(xpath = "//div[contains(text(),'Resolved Upon ACC Approval')]")
	WebElement resolvedUponACCApprovalMenu;

	@FindBy(xpath = "//div[contains(text(),'Close Reason')]")
	WebElement closeReasonLabel;

	@FindBy(xpath = "//textarea[@role='textbox']")
	WebElement reasonTextbox;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-popup-title dx-has-close-button']")
	WebElement errorPopup;

	@FindBy(xpath = "//dx-button[@text='Close']")
	WebElement closeButton;

	@FindBy(xpath = "  //i[@class='dx-icon fas fa-save']")
	WebElement saveButton;

	// Custom Violation Letters Menu
	@FindBy(xpath = "//div[contains(text(),'Custom Violation Letters')]")
	WebElement customViolationLettersMenu;

	@FindBy(xpath = "//div[contains(text(),'TestResponse')]")
	WebElement letterMenu;

	@FindBy(xpath = "//button[@title='Horizontal line']//span[@class='tox-icon tox-tbtn__icon-wrap']//*[name()='svg']")
	WebElement horizontalLineIcon;

	@FindBy(xpath = "//span[normalize-space()='Generate and Save']")
	WebElement generateandSaveButton;

	// Refer to Attorney Menu
	@FindBy(xpath = "//div[contains(text(),'Refer to Attorney')]")
	WebElement referToAttorneyMenu;

	@FindBy(xpath = "//div[contains(text(),'Select Vendor')]")
	WebElement selectVendorLabel;

	@FindBy(xpath = "(//dx-button[@text='Select'])[1]")
	WebElement selectButton;

	@FindBy(xpath = "//dx-button[@text='OK']")
	WebElement okButton;

	// Clear Attorney Flag Menu
	@FindBy(xpath = "//td[normalize-space(.)='Referred to Attorney']//span[contains(@class, 'dx-header-filter')]")
	WebElement referredToAttorneyFilterIcon;

	@FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[3]")
	WebElement filterCheckbox;

	@FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[2]")
	WebElement blankCheckbox;

	@FindBy(xpath = "//div[@aria-label='OK']//div[@class='dx-button-content']")
	WebElement filterOkButton;

	@FindBy(xpath = "//div[contains(text(),'Clear Attorney Flag')]")
	WebElement clearAttorneyFlagMenu;

	@FindBy(xpath = "//div[@class='dx-datagrid-filter-panel-clear-filter']")
	WebElement clearButton;

	// Report Violation Button
	@FindBy(xpath = "//dx-button[@aria-label='Report Violation']//div[@class='dx-button-content']")
	WebElement reportViolationButton;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[contains(text(),'Report a Violation')]")
	WebElement reportViolationLabel;

	@FindBy(xpath = "//div[@aria-label='fas fa-ellipsis-h']//i[@class='dx-icon fas fa-ellipsis-h']")
	WebElement propertyDropdown;

	@FindBy(xpath = "(//span[@class='dx-button-text'][normalize-space()='Select'])[2]")
	WebElement propertySelectButton;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[12]")
	WebElement categoryDropdownIcon;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[6]")
	WebElement categoryDropdownValue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[13]")
	WebElement subCategoryDropdownIcon;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[17]")
	WebElement subCategoryDropdownValue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[14]")
	WebElement locationDropdownIcon;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[25]")
	WebElement locationDropdownValue;

	@FindBy(xpath = "(//textarea[@role='textbox'])[1]")
	WebElement regardingTextbox;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[16]")
	WebElement actionDropdownsIcon;

	@FindBy(xpath = "//div[@class='dx-item-content dx-list-item-content'][normalize-space()='Not Fixed']")
	WebElement actionDropdownsValue;

	@FindBy(xpath = "//span[normalize-space()='Submit New Violation']")
	WebElement submitNewViolationButton;

	// Closed Tab
	@FindBy(xpath = "//span[@class='dx-tab-text'][normalize-space()='Closed']")
	WebElement closedTab;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper']//i[@title='History'])[1]")
	WebElement historyIcon;

	@FindBy(xpath = "//i[@title='Images']")
	WebElement imagesIcon;

	@FindBy(xpath = "(//div[@class='dx-widget dx-button dx-button-mode-text dx-button-normal dx-button-has-icon dx-closebutton'])[2]")
	WebElement imagesCloseButton;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-text dx-button-normal dx-button-has-icon dx-closebutton']")
	WebElement historyCloseButton;

	@FindBy(xpath = "//h4[normalize-space()='Violation History']")
	WebElement violationHistoryLable;

	@FindBy(xpath = "//td[normalize-space(.)='Property Address']//span[contains(@class, 'dx-header-filter')]")
	WebElement propertyAddressColumnFilter;

	@FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[3]")
	WebElement checkBoxIcon;

	@FindBy(xpath = "(//app-hyperlink-creator[@cssclass='cc-hyperlink-hover'])[1]")
	WebElement propertyAddressColumn;

	@FindBy(xpath = "//div[@class='context-summary context-summary-lg']")
	WebElement propertyAddressDetails;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-search']")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@aria-label='Search in the data grid']")
	WebElement searchTextbox;

	// Allowances Tab
	@FindBy(xpath = "//span[@class='dx-tab-text'][contains(text(),'Allowances')]")
	WebElement allowancesTab;

	@FindBy(xpath = "//div[@class='dx-group-panel-item dx-datagrid-action dx-datagrid-drag-action']")
	WebElement typeColumnDrag;

	@FindBy(xpath = "//td[normalize-space()='Current Owner']")
	WebElement typeColumnDrop;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Action')])[1]")
	WebElement action;

	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	WebElement editMenu;

	@FindBy(xpath = "//span[contains(text(),'Sub-Category:')]")
	WebElement subCategoryLabel;

	@FindBy(xpath = "//dx-button[@title='Update']")
	WebElement updateButton;

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

		waitForInvisibility(loaderIcon);
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
			navigationSearch.navigateBySideNavigation(By.xpath("//span[contains(text(),'Detailed Violations Log')]"),
					"Detailed Violations Log");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to 'Detailed Violations Log");

			waitForInvisibility(loaderIcon);

			LoggerManager.info("Scrolling to Detailed Violations Log navigation");
			scrollToElement(detailedViolationsLogSideNav);

			if (isElementDisplayed(detailedViolationsLogSideNav)) {
				LoggerManager.info("Detailed Violations Log navigation is visible, clicking on it");
				clickElementJS(detailedViolationsLogSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the community and accessed Detailed Violations Log");

				boolean isPageTitle = pageTitle.getText().equals("Detailed Violations Log");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Detailed Violations Log navigation is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the community search process");
			return false;
		}
	}

	// Open Tab
	public String escalateViolationsAction() {
		try {
			if (isElementDisplayed(closeButton)) {
				clickElement(closeButton);
			}
			clickElementJS(refreshButton);
			clickElementJS(resetIcon);
			waitForInvisibility(loaderIcon);

			clickElementJS(referredToAttorneyFilterIcon);
			clickElementJS(blankCheckbox);
			clickElementJS(filterOkButton);

			Actions actions = new Actions(driver);
			actions.dragAndDrop(categoryColumnDrag, categoryColumnDrop).build().perform();
			waitForInvisibility(loaderIcon);

			clickElement(actionButton);
			clickElementJS(escalateViolationMenu);
			clickElementJS(violationNotesTextbox);
			enterText(violationNotesTextbox, "Test");

			String escalateExistingViolationLabel = escalateExistingViolationButton.getText();
			clickElementJS(actionDropdown);
			clickElementJS(actionDropdownValue);

			waitForInvisibility(loaderIcon);
			clickElementJS(escalateExistingViolationButton);
			return escalateExistingViolationLabel;
		} catch (Exception e) {
			LoggerManager.error("Exception in escalateViolationsAction: " + e.getMessage());
			throw e;
		}

	}

	public String closeViolationAction() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			Actions actions = new Actions(driver);
			actions.moveToElement(closeViolationMenu).perform();
			clickElementJS(resolvedUponACCApprovalMenu);
			waitForElementToBeVisible(reasonTextbox);
			String popupTitle = closeReasonLabel.getText();
			clickElementJS(reasonTextbox);
			enterText(reasonTextbox, "Detailed Violations Log testing purpose.");
			if (isElementDisplayed(closeButton)) {
				clickElement(closeButton);
			}
			clickElementJS(saveButton);
			waitForInvisibility(loaderIcon);
			return popupTitle;
		} catch (Exception e) {
			LoggerManager.error("Exception in closeViolationAction: " + e.getMessage());
			throw e;
		}

	}

	public String customViolationLettersAction() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			clickElementJS(customViolationLettersMenu);
			clickElementJS(letterMenu);
			String generateAndSaveLabel = generateandSaveButton.getText();
			waitForInvisibility(loaderIcon);
			clickElementJS(generateandSaveButton);
			return generateAndSaveLabel;
		} catch (Exception e) {
			LoggerManager.error("Exception in customViolationLettersAction: " + e.getMessage());
			throw e;
		}

	}

	public String referToAttorneyAction() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			clickElementJS(referToAttorneyMenu);
			waitForInvisibility(loaderIcon);
			String popupTitle = selectVendorLabel.getText();
			clickElementJS(selectButton);
			waitForInvisibility(loaderIcon);
			return popupTitle;
		} catch (Exception e) {
			LoggerManager.error("Exception in referToAttorneyAction: " + e.getMessage());
			throw e;
		}

	}

	public boolean clearAttorneyFlag() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(refreshButton);
			clickElementJS(resetIcon);
			waitForInvisibility(loaderIcon);

			clickElementJS(referredToAttorneyFilterIcon);
			clickElementJS(filterCheckbox);
			clickElementJS(filterOkButton);
			waitForInvisibility(loaderIcon);

			Actions actions = new Actions(driver);
			actions.dragAndDrop(categoryColumnDrag, categoryColumnDrop).build().perform();

			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			clickElement(clearAttorneyFlagMenu);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in clearAttorneyFlag: " + e.getMessage());
		}
		return false;
	}

	public String reportViolation() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(resetIcon);
			clickElementJS(reportViolationButton);

			String violationLabel = reportViolationLabel.getText();
			clickElementJS(propertyDropdown);
			waitForInvisibility(loaderIcon);
			clickElementJS(propertySelectButton);
			clickElementJS(categoryDropdownIcon);
			clickElementJS(categoryDropdownValue);
			clickElementJS(subCategoryDropdownIcon);
			clickElementJS(subCategoryDropdownValue);
			clickElementJS(locationDropdownIcon);
			clickElementJS(locationDropdownValue);
			clickElementJS(regardingTextbox);
			enterText(regardingTextbox, "Test");
			clickElementJS(violationNotesTextbox);
			enterText(violationNotesTextbox, "Test");
			clickElementJS(actionDropdownsIcon);
			clickElementJS(actionDropdownsValue);
			waitForInvisibility(loaderIcon);
			clickElementJS(submitNewViolationButton);
			return violationLabel;
		} catch (Exception e) {
			LoggerManager.error("Exception in reportViolation: " + e.getMessage());
			throw e;
		}

	}

	// Close Tab
	public boolean closedViolationHistory() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(closedTab);
			clickElementJS(refreshButton);
			clickElementJS(resetIcon);
			waitForInvisibility(loaderIcon);

			Actions actions = new Actions(driver);
			actions.dragAndDrop(categoryColumnDrag, categoryColumnDrop).build().perform();
			waitForInvisibility(loaderIcon);
			clickElementJS(historyIcon);
			if (isElementDisplayed(imagesIcon)) {
				clickElementJS(imagesIcon);
				clickElement(imagesCloseButton);
			}
			clickElementJS(historyCloseButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in closedViolationHistory: " + e.getMessage());
		}
		return false;
	}

	public boolean propertyAddress() {
		LoggerManager.info("Entered propertyAddress method.");
		try {
			clickElement(closedTab);
			clickElementJS(refreshButton);
			waitForInvisibility(loaderIcon);
			clickElementJS(resetIcon);

			clickElementJS(searchIcon);
			enterText(searchTextbox, "New");
			waitForInvisibility(loaderIcon);

			clickElementJS(propertyAddressColumnFilter);
			clickElementJS(filterCheckbox);
			clickElementJS(filterOkButton);
			waitForInvisibility(loaderIcon);

			Actions actions = new Actions(driver);
			actions.dragAndDrop(categoryColumnDrag, categoryColumnDrop).build().perform();
			waitForInvisibility(loaderIcon);

			clickElement(propertyAddressColumn);

			Set<String> windowHandles = driver.getWindowHandles();
			String[] windows = windowHandles.toArray(new String[0]);
			driver.switchTo().window(windows[2]);
			waitForInvisibility(loaderIcon);
			pressEscapeKey();
			driver.switchTo().window(windows[1]);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in propertyAddress method: " + e.getMessage());
		}
		return false;
	}

	// Allowances Tab
	public boolean editAllowances() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(allowancesTab);
			clickElementJS(refreshButton);
			clickElementJS(resetIcon);
			Actions actions = new Actions(driver);
			actions.dragAndDrop(typeColumnDrag, typeColumnDrop).build().perform();
			waitForInvisibility(loaderIcon);
			clickElement(action);
			clickElementJS(editMenu);
			clickElementJS(updateButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in editAllowances: " + e.getMessage());
		}
		return false;
	}
}