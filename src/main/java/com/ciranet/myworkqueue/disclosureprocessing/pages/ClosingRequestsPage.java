package com.ciranet.myworkqueue.disclosureprocessing.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ClosingRequestsPage extends BasePage {
	public ClosingRequestsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//div[@class='dx-switch-on'])[3]")
	WebElement compactOn;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeButton;

	@FindBy(xpath = "//dx-switch[@aria-label='ON']//div[@class='dx-switch-handle']")
	WebElement compactOff;

	@FindBy(xpath = "//div[@class='cc-wizard-horizontal-content dx-template-wrapper dx-item-content dx-box-item-content']")
	WebElement wizard;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Action')])[1]")
	WebElement actionButton;

	@FindBy(xpath = "(//div[@ng-reflect-klass='menu-text'])[2]")
	WebElement transferTo;

	@FindBy(xpath = "//div[@class='menu-text'][normalize-space()='Collections']")
	WebElement collection;

	@FindBy(xpath = "//div[contains(text(),'Processing')]")
	WebElement processing;

	@FindBy(xpath = "//div[@class='menu-text'][normalize-space()='Transition']")
	WebElement transition;

	@FindBy(xpath = " (//div[@ng-reflect-klass='menu-text'])[4]")
	WebElement assignProperty;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[23]")
	WebElement communityDropDown;

	@FindBy(xpath = "(//div//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement communityDropdownValue;

	@FindBy(xpath = "(//dx-text-box[@class='dx-show-invalid-badge dx-textbox dx-texteditor dx-editor-outlined dx-texteditor-empty dx-widget'])[2]")
	WebElement searchText;

	@FindBy(xpath = "//div//dx-button[@title='Search']//span[@class='dx-button-text'][normalize-space()='Search']")
	WebElement searchButtonProperty;

	@FindBy(xpath = "//dx-button[@title='Cancel']//div[@class='dx-button-content']")
	WebElement cancelButton;

	@FindBy(xpath = "//div[contains(text(),'Cancel Request')]")
	WebElement cancelRequest;

	@FindBy(xpath = "//div[@class='dx-item-content dx-tab-content']//span[contains(text(),'Search')]")
	WebElement searchTab;

	@FindBy(xpath = "//div[@class='dx-item-content dx-tab-content']//span[normalize-space()='Open Requests (Auto fulfill)']")
	WebElement openRequestTab;

	@FindBy(xpath = "(//input[@autocomplete='off' and @role='textbox'])[2]")
	WebElement propertyAddress;

	@FindBy(xpath = "(//input[@autocomplete='off'])[6]")
	WebElement toDate;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container']//input[@type='text'])[4]")
	WebElement fromDate;

	@FindBy(xpath = "//a[@class='dx-widget dx-button dx-button-mode-contained dx-button-normal dx-button-has-text dx-calendar-caption-button']")
	WebElement currentYear;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-chevronleft']")
	WebElement lastYear;

	@FindBy(xpath = "//td[@class='dx-calendar-cell dx-calendar-contoured-date']")
	WebElement month;

	@FindBy(xpath = "//td[@class='dx-calendar-cell dx-calendar-contoured-date']")
	WebElement date;

	@FindBy(xpath = "//div[@class='dx-button-content']//i[@class='dx-icon dx-icon-search']")
	WebElement searchButton;

	@FindBy(xpath = "(//div[@class='dx-button-content']//i[@class='dx-icon dx-icon-runner'])[1]")
	WebElement actionCheck;

	@FindBy(xpath = "(//div[@class='dx-datagrid-text-content dx-text-content-alignment-left dx-text-content-alignment-right'])[1]")
	WebElement rush;

	@FindBy(xpath = "(//div//span[@class='dx-header-filter dx-header-filter-empty'])[9]")
	WebElement requestType;

	@FindBy(xpath = "(//div[@class='dx-datagrid-text-content dx-text-content-alignment-left dx-header-filter-indicator'])[6]")
	WebElement community;

	@FindBy(xpath = "(//div[@class='dx-column-indicators'])[10]")
	WebElement location;

	@FindBy(xpath = "//div[@role='presentation']//div[contains(text(),'Location')]")
	WebElement labelLocation;

	@FindBy(xpath = "(//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-normal dx-button-has-text'])[1]")
	WebElement locationOk;

	@FindBy(xpath = "(//i[@class='cc-1-5x fas fa-envelope'])[1]")
	WebElement emailLabel;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon fas fa-search']")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@aria-label='Search in the data grid']")
	WebElement searchField;

	@FindBy(xpath = "(//div[@class='dx-texteditor-buttons-container']//span[@class='dx-icon dx-icon-clear'])[2]")
	WebElement clearSearch;

	@FindBy(xpath = "(//div[@class='dx-datagrid-text-content dx-text-content-alignment-left dx-header-filter-indicator'])[7]")
	WebElement propertyReasonLabel;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//*[@id='dx-col-1656']")
	WebElement communityColumn;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayout;

	@FindBy(xpath = "//div//span[normalize-space()='Closing Requests']")
	WebElement closingRequestSideNav;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container']//input[@type='text'])[15]")
	WebElement managementCompanySearchFilter;

	@FindBy(xpath = "//td[normalize-space()='Collections']")
	WebElement collectionsValue;

	@FindBy(xpath = "//td[normalize-space()='Transition']")
	WebElement transitionValue;

	@FindBy(xpath = "//div[contains(text(),'Resale/SOA Change Request Property')]")
	WebElement assignPropertyPopupTitle;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement cancelButtonCancelRequest;

	@FindBy(xpath = "//span[contains(text(),'Cancel Reason:')]")
	WebElement labelCancelReason;

	@FindBy(xpath = "//div//span[contains(text(),'Property Address:')]")
	WebElement labelPropertyAddress;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "//div//span[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "(//div//span[@class='dx-checkbox-icon'])[4]")
	WebElement checkBoxProperty;

	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[normalize-space()='Closing Requests']"),
					"Closing Request");
			LoggerManager.info("Navigated to 'Closing Request'");
			LoggerManager.info("Scrolling to Closing Request navigation");
			scrollToElement(closingRequestSideNav);

			if (isElementDisplayed(closingRequestSideNav)) {
				LoggerManager.info("Closing Request navigation is visible, clicking on it");
				clickElementJS(closingRequestSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed Closing Request");

				boolean isPageTitle = pageTitle.getText().equals("Closing Requests");

				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Closing Request navigation is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}

	}

	public boolean toolBarFullScreen() {
		try {
			clickElement(fullScreenIcon);
			waitForElementToBeVisible(normalScreenIcon);
			clickElementJS(normalScreenIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in toolBarFullScreen: " + e.getMessage());
			throw e;
		}
	}

	public boolean searchButton() {
		try {
			clickElement(searchIcon);
			clickElement(resetLayout);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in searchButton: " + e.getMessage());
			throw e;
		}
	}

	public String verifyActionTransfertoCollections() {
		try {
			clickElement(actionButton);
			scrollToElement(transferTo);
			clickElement(transferTo);
			clickElementJS(processing);
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			scrollToElement(transferTo);
			clickElement(transferTo);
			clickElementJS(collection);
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(collectionsValue);
			return collectionsValue.getText();
		} catch (Exception e) {
			LoggerManager.error("Error in verifyActionTransfertoCollections: " + e.getMessage());
			throw e;
		}
	}

	public String verifyActionTransfertoTransition() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			scrollToElement(transferTo);
			clickElement(transferTo);
			clickElementJS(processing);
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			scrollToElement(transferTo);
			clickElement(transferTo);
			waitForInvisibility(loaderIcon);
			clickElementJS(transition);
			return transitionValue.getText();
		} catch (Exception e) {
			LoggerManager.error("Error in verifyActionTransfertoTransition: " + e.getMessage());
			throw e;
		}
	}

	public String verifyActionAssignPropertyCancelPopup() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			clickElementJS(assignProperty);
			String propertyPopupTitle = assignPropertyPopupTitle.getText();
			waitForInvisibility(loaderIcon);
			clickElement(communityDropDown);
			clickElementJS(communityDropdownValue);
			clickElementJS(cancelButton);
			waitForInvisibility(loaderIcon);
			return propertyPopupTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in verifyActionAssignProperty: " + e.getMessage());
			throw e;
		}
	}

	public String actionCancelRequest() {
		try {
			scrollToElement(actionButton);
			clickElement(actionButton);
			scrollToElement(cancelRequest);
			clickElement(cancelRequest);
			waitForInvisibility(loaderIcon);
			String cancelReasonLabel = labelCancelReason.getText();
			clickElement(cancelButtonCancelRequest);
			waitForInvisibility(loaderIcon);
			return cancelReasonLabel;
		} catch (Exception e) {
			LoggerManager.error("Error in actionCancelRequest: " + e.getMessage());
			throw e;
		}
	}

	public boolean switchingTabs() {
		try {
			clickElement(openRequestTab);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in switchingTabs: " + e.getMessage());
			throw e;
		}
	}

	public String requestTypeFilter() {
		try {
			clickElementJS(rush);
			clickElementJS(community);
			clickElementJS(requestType);
			clickElementJS(location);
			clickElementJS(locationOk);
			waitForInvisibility(loaderIcon);
			return labelLocation.getText();
		} catch (Exception e) {
			LoggerManager.error("Error in requestTypeFilter: " + e.getMessage());
			throw e;
		}
	}

	public String searchTab() {
		try {
			scrollToElement(searchTab);
			clickElementJS(searchTab);
			waitForInvisibility(loaderIcon);
			clickElementJS(propertyAddress);
			propertyAddress.sendKeys("1100");
			clickElementJS(fromDate);
			fromDate.clear();
			fromDate.sendKeys("09/01/2019", Keys.ENTER);
			clickElementJS(searchButton);
			waitForInvisibility(loaderIcon);
			return labelPropertyAddress.getText();
		} catch (Exception e) {
			LoggerManager.error("Error in searchTab: " + e.getMessage());
			throw e;
		}
	}	
}
