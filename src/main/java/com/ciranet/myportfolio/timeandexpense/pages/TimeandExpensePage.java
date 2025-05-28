package com.ciranet.myportfolio.timeandexpense.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class TimeandExpensePage extends BasePage {

	public TimeandExpensePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[1]")
	public WebElement entityDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-tab-content'])[2]")
	public WebElement generalExpense;

	@FindBy(xpath = "//div//span[normalize-space()='Mileage Expense']")
	public WebElement mileageExpense;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "//dx-box[@direction='row']//div[@class='dx-template-wrapper dx-item-content dx-toolbar-item-content']")
	public WebElement newTimeEntry;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper dx-button-content'])[11]")
	public WebElement customerDrop;

	@FindBy(xpath = "(//td[@aria-describedby='dx-col-16'])[2]")
	WebElement columnCustomerDropDown;

	@FindBy(xpath = "(//td[@aria-describedby='dx-col-16'])[2]")
	public WebElement customerValue;

	@FindBy(xpath = "(//div[contains(@class,'dx-dropdowneditor-icon')])[9]")
	public WebElement chargeCode;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[58]")
	public WebElement mileageChargeCode;

	@FindBy(xpath = "(//td[@aria-describedby='dx-col-16'])[2]")
	public WebElement chargeCodeValue;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[contains(text(),'Save')]")
	WebElement saveTime;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Save')])[2]")
	public WebElement saveMyPlaces;

	@FindBy(xpath = "(//div[@class='menu-text'])[3]")
	public WebElement mileageExpensebutton;

	@FindBy(xpath = "(//div[@class=\"dx-button-content\"]//span[@class='dx-button-text'])[2]")
	public WebElement myPlace;

	@FindBy(xpath = "(//div[@class='dx-button-content']//i[@class='dx-icon dx-icon-runner'])[35]")
	public WebElement actionMyplaces;

	@FindBy(xpath = "(//i[@class=\"dx-icon fas fa-times\"])[2]")
	public WebElement closeButton;

	@FindBy(xpath = "(//i[@class=\"dx-icon fas fa-times\"])[1]")
	public WebElement myPlacescloseButton;

	@FindBy(xpath = "//i[@class='dx-icon fas fa-upload']")
	public WebElement submitForApproval;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Cancel']")
	public WebElement cancel;

	@FindBy(xpath = "(//dx-button[@class='dx-widget dx-button dx-button-mode-contained dx-button-success dx-button-has-text dx-button-has-icon'])[2]")
	public WebElement submit;

	@FindBy(xpath = "(//div[@class='dx-checkbox-container'])[2]")
	public WebElement submitForApprovalcheckbox;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[5]")
	public WebElement entityCustomerDropdown;

	@FindBy(xpath = "//td[normalize-space()='1100 Trinity Mills Condominium Owners Association']")
	public WebElement entityCustomerDropdownvalue;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	public WebElement chargeCodeValueButton;

	@FindBy(xpath = "//span[normalize-space()='Time & Expense']")
	WebElement timeExpenseMenu;

	@FindBy(xpath = "//span[normalize-space()='Time & Expense Management']")
	WebElement timeExpenseManagementMenu;

	@FindBy(xpath = "//h2[@class='page-header']")
	public WebElement labelTimeandExpense;

	@FindBy(xpath = "//span[normalize-space()='My Portfolio']")
	WebElement myPortfolioClick;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-widget dx-checkbox dx-select-checkbox dx-datagrid-checkbox-size'])[1]")
	WebElement selectAllCheckBox;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Submit']")
	WebElement submitMileage;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-popup-title dx-has-close-button']")
	WebElement errorMessage;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Close']")
	WebElement closeErrorMessage;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Add New Place']")
	WebElement addNewPlace;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container']//input[@type='text'])[12]")
	WebElement placeName;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container']//input[@type='text'])[13]")
	WebElement placeAddress;

	@FindBy(xpath = "//dx-button[@title='Close']//span[@class='dx-button-text'][normalize-space()='Close']")
	WebElement closeMyNewPace;

	@FindBy(xpath = "//div[contains(text(),'Add New My Place')]")
	public WebElement labelMyPlace;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='New Expense Entry']")
	WebElement newExpenseEntryButton;

	@FindBy(xpath = "//dx-button[@title='Hide Menu']//i[@class='dx-icon dx-icon-menu']")
	WebElement hamburger;

	@FindBy(xpath = "//dx-button[@title='Distance']//i[@class='dx-icon fas fa-map-marker-alt']")
	WebElement milesDrivenIcon;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[12]")
	WebElement fromAddressIcondropdownIcon;

	@FindBy(xpath = "(//tr[@role='row'])[15]")
	WebElement fromAddressvalue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[13]")
	WebElement toAddressIcondropdownIcon;

	@FindBy(xpath = "(//tr[@role='row'])[16]")
	WebElement toAddressvalue;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Get Trip Distance']")
	WebElement getTripDistanceButton;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Select']")
	WebElement selectDistanceButton;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='New Mileage Expense']")
	WebElement newMileageExpenseButton;

	Navigation navigationSearch = new Navigation(driver);

	public boolean timeandExpensePageLanding() throws Exception {

		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[normalize-space()='Time & Expense Management']"),
					"Time & Expense Management");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to 'Time & Expense Management");
			LoggerManager.info("Scrolling to Time & Expense Management Menu");
			scrollToElement(timeExpenseManagementMenu);

			if (isElementDisplayed(timeExpenseManagementMenu)) {
				LoggerManager.info("Time & Expense Management Menu is visible, clicking on it");
				clickElementJS(timeExpenseManagementMenu);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed Time & Expense Management");

				boolean isLabelCorrect = labelTimeandExpense.getText().equals("Time & Expense Management");
				LoggerManager.info("Label text validation: " + (isLabelCorrect ? "Passed" : "Failed"));

				return isLabelCorrect;

			} else {
				LoggerManager.warn("Time & Expense Management Menu is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}

	}

	public Boolean newTimeEntrySaveButton() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(entityCustomerDropdown);
			waitForInvisibility(loaderIcon);
			clickElement(entityCustomerDropdownvalue);
			waitForInvisibility(loaderIcon);
			clickElement(refreshButton);
			clickElement(newTimeEntry);
			waitForInvisibility(loaderIcon);
			clickElement(chargeCode);
			waitForInvisibility(loaderIcon);
			clickElement(chargeCodeValueButton);
			waitForInvisibility(loaderIcon);
			clickElement(saveTime);
			waitForInvisibility(loaderIcon);

			if (isElementDisplayed(errorMessage)) {
				clickElement(closeErrorMessage);
			}

			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in newTimeEntrySaveButton: " + e.getMessage());
			throw e;
		}
	}

	public boolean tabSwitching() {
		try {

			clickElement(generalExpense);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in tabSwitching: " + e.getMessage());
			throw e;
		}
	}

	public boolean submitForApprovalCancelButton() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(newExpenseEntryButton);
			waitForInvisibility(loaderIcon);
			clickElement(chargeCode);
			waitForInvisibility(loaderIcon);
			clickElement(chargeCodeValueButton);
			waitForInvisibility(loaderIcon);
			clickElement(saveTime);

			if (isElementDisplayed(errorMessage)) {
				clickElement(closeErrorMessage);
			}

			waitForInvisibility(loaderIcon);
			clickElementJS(submitForApproval);
			waitForInvisibility(loaderIcon);
			clickElement(cancel);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in submitForApprovalCancelButton: " + e.getMessage());
			throw e;
		}
	}

	public boolean submitMileageExpenses() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(mileageExpense);
			waitForInvisibility(loaderIcon);
			clickElementJS(newMileageExpenseButton);
			waitForInvisibility(loaderIcon);
			clickElement(chargeCode);
			waitForInvisibility(loaderIcon);
			clickElement(chargeCodeValueButton);
			waitForInvisibility(loaderIcon);
			scrollToElement(milesDrivenIcon);
			clickElementJS(milesDrivenIcon);
			waitForInvisibility(loaderIcon);
			clickElementJS(fromAddressIcondropdownIcon);
			waitForInvisibility(loaderIcon);
			clickElementJS(fromAddressvalue);
			waitForInvisibility(loaderIcon);
			clickElementJS(toAddressIcondropdownIcon);
			waitForInvisibility(loaderIcon);
			clickElementJS(toAddressvalue);
			waitForInvisibility(loaderIcon);
			clickElementJS(getTripDistanceButton);
			waitForInvisibility(loaderIcon);
			clickElementJS(selectDistanceButton);
			waitForInvisibility(loaderIcon);
			clickElement(saveTime);
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(errorMessage)) {
				clickElement(closeErrorMessage);
			}
			waitForInvisibility(loaderIcon);

			clickElement(submitForApproval);
			waitForInvisibility(loaderIcon);
			clickElement(selectAllCheckBox);
			waitForInvisibility(loaderIcon);
			clickElement(submitMileage);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in submitMileageExpenses: " + e.getMessage());
			throw e;
		}
	}

	public String myPlaces() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(myPlace);
			waitForInvisibility(loaderIcon);
			clickElementJS(addNewPlace);
			waitForInvisibility(loaderIcon);
			String myPlaceLabel = labelMyPlace.getText();
			clickElement(placeName);
			waitForInvisibility(loaderIcon);
			placeName.sendKeys("Testing");
			waitForInvisibility(loaderIcon);
			clickElement(placeAddress);
			waitForInvisibility(loaderIcon);
			placeAddress.sendKeys("Dallas");
			clickElement(saveMyPlaces);
			waitForInvisibility(loaderIcon);
			clickElement(closeMyNewPace);
			return myPlaceLabel;
		} catch (Exception e) {
			LoggerManager.error("Exception in myPlaces: " + e.getMessage());
			throw e;
		}
	}
}

