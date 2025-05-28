package com.ciranet.myportfolio.revenuemanagement.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

//Every line of code that runs in Java must be inside a class
public class MyCustomerChargesPage extends BasePage {
	public MyCustomerChargesPage(WebDriver driver) {
		super(driver);
	}
	
	// Initializing the Page Objects

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'My Customer Charges')]")
	WebElement myCustomerChargesSideNav;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[1]")
	WebElement entityDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[1]")
	WebElement entityDropdownValue;

	@FindBy(xpath = "(//div[@class='dx-texteditor-buttons-container'])[7]")
	WebElement customersDropdown;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement customersDropdownValue;

	@FindBy(xpath = "//span[text()='Create New Charge']")
	WebElement createNewChargeButton;

	@FindBy(xpath = "//div[text()='Add Customer Charge']")
	WebElement addChargePopupTitle;

	@FindBy(xpath = "(//div[@class='dx-texteditor-buttons-container'])[20]")
	WebElement customerDropdown;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement customerDropdownValue;

	@FindBy(xpath = "(//div[@class='dx-texteditor-buttons-container'])[21]")
	WebElement productDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[5]")
	WebElement productDropdownValue;

	@FindBy(xpath = "(//input[@role='combobox'])[10]")
	WebElement transactionDate;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[24]")
	WebElement quantity;

	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Close']")
	WebElement closeButton;

	@FindBy(xpath = "//div[contains(text(),'Add Customer Charge')]")
	WebElement addCustomerChargeLabel;

	@FindBy(xpath = "//div[contains(text(),'Edit Customer Charge')]")
	WebElement editCustomerChargeLabel;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "//div[contains(text(),'Confirmation')]")
	WebElement confirmationTitle;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Action')])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	WebElement editMenu;

	@FindBy(xpath = "//div[contains(text(),'Delete')]")
	WebElement deleteMenu;

	@FindBy(xpath = "//div[@aria-label='No']//div[@class='dx-button-content']")
	WebElement noOption;

	@FindBy(xpath = "//div[@aria-label='Yes']//div[@class='dx-button-content']")
	WebElement yesOption;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	WebElement fromDate;

	@FindBy(xpath = "//dx-button[@title='Refresh']//div[@class='dx-button-content']")
	WebElement refreshButton;

	@FindBy(xpath = "(//td[@role='gridcell']//i[@title='Notes'])[1]")
	WebElement notesIcon;

	@FindBy(xpath = "//div[@class='dx-texteditor-container']//textarea[@role='textbox']")
	WebElement notesTextbox;

	@FindBy(xpath = "(//div[contains(text(),'Note')])[2]")
	WebElement noteTitle;

	Navigation navigationSearch = new Navigation(driver);

	// method declaration
	public boolean navigate() throws Exception {
		try {
			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),'My Customer Charges')]"),
					"My Customer Charges");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to My Customer Charges");
			LoggerManager.info("Scrolling to My Customer Charges navigation");
			scrollToElement(myCustomerChargesSideNav);

			if (isElementDisplayed(myCustomerChargesSideNav)) {
				LoggerManager.info("My Customer Charges navigation is visible, clicking on it");
				clickElementJS(myCustomerChargesSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed My Customer Charges");

				boolean isPageTitle = pageTitle.getText().equals("My Customer Charges");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("My Customer Charges navigation is not visible, search failed");
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
			if (isElementDisplayed(normalScreenIcon)) {
				clickElementJS(normalScreenIcon);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in toolBarFullScreen method: " + e.getMessage());
			throw e;
		}
	}

	public String entity() {
		try {
			clickElement(entityDropdown);
			clickElement(entityDropdownValue);
			clickElementJS(fromDate);
			enterText(fromDate, "01/05/2021");
			clickElement(customersDropdown);
			clickElement(customersDropdownValue);
			clickElement(refreshButton);
			if (isElementDisplayed(closeButton)) {
				clickElement(closeButton);
			}
			return actionButton.getText();
		} catch (Exception e) {
			LoggerManager.error("Error occurred in entity method: " + e.getMessage());
			throw e;
		}
	}

	public String addNewCharge() {
		try {
			clickElementJS(createNewChargeButton);
			waitForInvisibility(loaderIcon);
			clickElementJS(customerDropdown);
			clickElementJS(customerDropdownValue);
			String addPopupTitle = addCustomerChargeLabel.getText();
			clickElement(productDropdown);
			clickElement(productDropdownValue);
			clickElement(transactionDate);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String currentDate = LocalDate.now().format(formatter);
			transactionDate.sendKeys(currentDate);
			Actions actions = new Actions(driver);
			actions.moveToElement(transactionDate).sendKeys(Keys.ENTER).perform();
			clickElementJS(quantity);
			enterText(quantity, "10");
			clickElementJS(description);
			enterText(description, "Add New Customer Charge");
			clickElementJS(saveButton);
			return addPopupTitle;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in addNewCharge method: " + e.getMessage());
			throw e;
		}
	}

	public String notes() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(notesIcon);
			clickElement(notesTextbox);
			enterText(notesTextbox, "Testing purpose");
			String titleNotes = noteTitle.getText();
			clickElementJS(saveButton);
			clickElement(closeButton);
			return titleNotes;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in notes method: " + e.getMessage());
			throw e;
		}
	}

	public String editCharge() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(actionButton);
			clickElementJS(editMenu);
			String editPopupTitle = editCustomerChargeLabel.getText();
			clickElementJS(saveButton);
			return editPopupTitle;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in editCharge method: " + e.getMessage());
			throw e;
		}
	}

	public String deleteCharge() {
		try {
			clickElementJS(actionButton);
			clickElementJS(deleteMenu);
			String confirmTitle = confirmationTitle.getText();
			clickElementJS(noOption);
			clickElementJS(actionButton);
			clickElementJS(deleteMenu);
			clickElementJS(yesOption);
			return confirmTitle;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in deleteCharge method: " + e.getMessage());
			throw e;
		}
	}
}
