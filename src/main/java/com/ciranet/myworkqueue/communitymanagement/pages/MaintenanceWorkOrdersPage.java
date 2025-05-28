package com.ciranet.myworkqueue.communitymanagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class MaintenanceWorkOrdersPage extends BasePage {
	public MaintenanceWorkOrdersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div//span[normalize-space()='Maintenance Work Orders']")
	WebElement maintenanceWorkOrdersSideNav;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[@title='Column Chooser']")
	WebElement columnChooserButton;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeColChooserButton;

	@FindBy(xpath = "//div[contains(text(),'Column Chooser')]")
	WebElement columnChooserLabel;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayoutButton;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon far fa-minus-square']")
	WebElement collapseIcon;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//div//span[normalize-space()='Closed Work Orders']")
	WebElement closedWorkOrderTab;

	@FindBy(xpath = "//div//span[normalize-space()='Open Work Orders']")
	WebElement openWorkOrderTab;

	@FindBy(xpath = "(//input[@role='spinbutton'])[1]")
	WebElement daysText;

	@FindBy(xpath = "//div//span[@class='dx-button-text']")
	WebElement refreshButton;

	@FindBy(xpath = "//td[normalize-space()='Community: Plantation Oaks (Count = 1)']")
	WebElement daysValidRecord;

	@FindBy(xpath = "(//div//span[@class='dx-button-text'][normalize-space()='Action'])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div//span[normalize-space()='Manage Work Authorization']")
	WebElement manageWorkAuthorization;

	@FindBy(xpath = "//div[contains(text(),'Manage Task References')]")
	WebElement manageTaskRef;

	@FindBy(xpath = "//dx-button[@aria-label=\"Save\"]")
	WebElement saveButton;

	@FindBy(xpath = "//dx-button[@aria-label=\"Close\"]")
	WebElement closeButton;

	@FindBy(xpath = "//div//span[normalize-space()='Manage Proposals']")
	WebElement manageProposal;

	@FindBy(xpath = "//div[text()=' View/Edit ']")
	WebElement viewEdit;

	@FindBy(xpath = "//div//span[text()='Save & Close']")
	WebElement saveClosePopup;

	@FindBy(xpath = "//span[text()='Close']")
	WebElement popupClose;

	@FindBy(xpath = "//div[@class=\"button-multiple-icon-container\"]")
	WebElement addWorkOrderButton;

	@FindBy(xpath = "//i[@class=\"dx-icon fas fa-times\"]")
	WebElement addWorkOrderCloseButton;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-input-wrapper']//dx-text-box[@ng-reflect-placeholder='Select Community...']")
	WebElement communityDropdown;

	@FindBy(xpath = "(//div[@data-dx_placeholder='Select...'])[6]")
	WebElement jobType;

	@FindBy(xpath = "//div[contains(text(),'Other')]")
	WebElement jobTypeValue;

	@FindBy(xpath = "//div[@class='dx-datagrid-content']//td[normalize-space()='1100 Trinity Mills Condos']")
	WebElement communityDropdownValue;

	@FindBy(xpath = "(//div[@data-dx_placeholder='Select...'])[7]")
	WebElement referenceTypeDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'][normalize-space()='Other'])[2]")
	WebElement referenceTypeDropdownValue;

	@FindBy(xpath = "//div//span[text()='Save & Close']")
	WebElement saveandCloseButton;

	@FindBy(xpath = "//div//span[text()='Save']")
	WebElement save;

	@FindBy(xpath = "(//div//span[text()='Close'])[1]")
	WebElement close;

	@FindBy(xpath = "//div[contains(text(),'Change Status')]")
	WebElement changeStatus;

	@FindBy(xpath = "//div[contains(text(),'Initial Request')]")
	WebElement initialReq;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;
	
	@FindBy(xpath="//div//span[normalize-space()='Closed Work Orders']")
	WebElement closedWorkOrdersTabText;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[normalize-space()='Maintenance Work Orders']"),
					"Maintenance Work Orders");
			LoggerManager.info("Navigated to 'Maintenance Work Orders'");
			LoggerManager.info("Scrolling to Maintenance Work Orders navigation");
			scrollToElement(maintenanceWorkOrdersSideNav);

			if (isElementDisplayed(maintenanceWorkOrdersSideNav)) {
				LoggerManager.info("Maintenance Work Orders is visible, clicking on it");
				clickElementJS(maintenanceWorkOrdersSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed Maintenance Work Orders");

				boolean isPageTitle = pageTitle.getText().equals("Maintenance Work Orders");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Maintenance Work Orders is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}

	}

	public boolean toolBarFullScreen() {
		try {
			clickElementJS(fullScreenIcon);
			waitForInvisibility(loaderIcon);
			clickElementJS(normalScreenIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in toolBarFullScreen: " + e.getMessage());
			throw e;
		}
	}

	public String columnChooser() {
		try {
			clickElement(columnChooserButton);
			String colchooserTitle = columnChooserLabel.getText();
			waitForElementToBeClickable(closeColChooserButton);
			clickElement(closeColChooserButton);
			return colchooserTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in columnChooser: " + e.getMessage());
			return "Error occurred while retrieving column chooser title";
		}
	}

	public boolean addNewWorkOrder() {
		try {
			clickElement(addWorkOrderButton);
			waitForInvisibility(loaderIcon);
			clickElement(communityDropdown);
			clickElement(communityDropdownValue);
			waitForInvisibility(loaderIcon);
			scrollToElement(jobType);
			clickElementJS(jobType);
			clickElementJS(jobTypeValue);
			scrollToElement(referenceTypeDropdown);
			clickElementJS(referenceTypeDropdown);
			waitForElementToBeVisible(referenceTypeDropdownValue);
			clickElementJS(referenceTypeDropdownValue);
			clickElement(saveandCloseButton);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in addNewWorkOrder: " + e.getMessage());
			throw e;
		}
	}

	private void viewEdit() {
		try {
			clickElementJS(actionButton);
			clickElementJS(viewEdit);
		} catch (Exception e) {
			LoggerManager.error("Error in viewEdit: " + e.getMessage());
			throw e;
		}
	}

	public boolean manageWorkAuthorization() {
		try {
			viewEdit();
			clickElement(manageWorkAuthorization);
			clickElement(closeButton);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in verifyManageWorkAuthorization: " + e.getMessage());
			throw e;
		}
	}

	public boolean manageTaskReferences() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(actionButton);
			waitForElementToBeVisible(manageTaskRef);
			clickElementJS(manageTaskRef);
			waitForElementToBeVisible(save);
			clickElement(save);
			waitForElementToBeVisible(closeButton);
			clickElement(closeButton);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in manageTaskReferences: " + e.getMessage());
			throw e;
		}
	}

	public boolean manageProposal() {
		try {
			viewEdit();
			clickElement(manageProposal);
			waitForElementToBeVisible(closeButton);
			clickElement(closeButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in manageProposal: " + e.getMessage());
			throw e;
		}
	}

	public boolean saveViewEditWorkOrder() {
		try {
			viewEdit();
			clickElement(saveClosePopup);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in saveViewEditWorkOrder: " + e.getMessage());
			throw e;
		}
	}

	public boolean closeAddWorkOrder() {
		try {
			clickElementJS(addWorkOrderButton);
			waitForElementToBeVisible(close);
			clickElementJS(close);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in closeAddWorkOrder: " + e.getMessage());
			return false;
		}
	}

	public boolean closeViewEditWorkOrder() {
		try {
			viewEdit();
			waitForElementToBeVisible(popupClose);
			clickElement(popupClose);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in closeViewEditWorkOrder: " + e.getMessage());
			return false;
		}
	}

	public boolean viewEditCloseWorkOrder() {
		try {
			waitForInvisibility(loaderIcon);
			viewEdit();
			waitForElementToBeVisible(save);
			clickElement(save);
			waitForElementToBeVisible(popupClose);
			clickElement(popupClose);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in viewEditCloseWorkOrder: " + e.getMessage());
			return false;
		}
	}

	public boolean changeStatus() {
		try {
			waitForElementToBeVisible(actionButton);
			clickElement(actionButton);
			waitForInvisibility(loaderIcon);
			Actions action = new Actions(driver);
			action.moveToElement(changeStatus).build().perform();
			action.moveToElement(initialReq).click().perform();
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in changeStatus: " + e.getMessage());
			throw e;
		}
	}

	public String switchTab() {
		try {
			clickElementJS(closedWorkOrderTab);
			
			waitForInvisibility(loaderIcon);
			return closedWorkOrdersTabText.getText();
		} catch (Exception e) {
			LoggerManager.error("Error in switchTab: " + e.getMessage());
			throw e;
		}
	}

	public boolean closedDaysTextbox() {
		try {
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(daysText);
			clickElement(daysText);
			enterText(daysText, "300");
			clickElement(refreshButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in closedDaysTextbox: " + e.getMessage());
			throw e;
		}
	}

	public boolean expandOptionIcon() {
		try {
			clickElementJS(expandIcon);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in expandOptionIcon: " + e.getMessage());
			return false;
		}
	}

	public boolean collapseOptionIcon() {
		try {
			clickElementJS(collapseIcon);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in collapseOptionIcon: " + e.getMessage());
			return false;
		}
	}
}

