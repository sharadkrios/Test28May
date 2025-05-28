package com.ciranet.cirabooks.cashmanagement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.ciranet.navigation.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ciranet.basepage.BasePage;
import com.ciranet.utilities.LoggerManager;

public class DepositsPage extends BasePage {
	public DepositsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'Deposits')]")
	WebElement depositsSideNav;

	@FindBy(xpath = "//div[@title='Column Chooser']//div[@class='dx-button-content']")
	WebElement columnChooser;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement close;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-file-excel']")
	WebElement exportExcel;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-button-content']//div[@class='dx-dropdowneditor-icon']")
	WebElement communityDropdown;

	@FindBy(xpath = "(//div//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement communityDropdownValue;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper dx-button-content'])[12]")
	WebElement addDepositButton;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[8]")
	WebElement bankDropdown;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper dx-button-content'])[14]")
	WebElement searchBankDropdown;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[5]")
	WebElement searchBankValue;

	@FindBy(xpath = "(//input[@role='textbox'])[17]")
	WebElement description;

	@FindBy(xpath = "(//td[@aria-label='Select row'])[1]")
	WebElement checkbox;

	@FindBy(xpath = "//dx-button[@title='Save']")
	WebElement saveButton;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Action')])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div[@class='menu-text']")
	WebElement viewmenu;

	@FindBy(xpath = "//h2[contains(text(),'Deposits')]")
	WebElement pageTitle;

	@FindBy(xpath = "//div[contains(text(),'Column Chooser')]")
	WebElement columnChooserLabel;

	@FindBy(xpath = "//div[@role='presentation']//div[contains(text(),'Receive Date')]")
	WebElement viewPopupColHeader;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[contains(text(),'Close')]")
	WebElement viewClose;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[contains(text(),'Add New Deposit')]")
	WebElement addDepositLable;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate() throws Exception {

		try {
			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),'Deposits')]"), "Deposits");
			LoggerManager.info("Navigated to Deposits");

			LoggerManager.info("Scrolling to 'Deposits' navigation");
			scrollToElement(depositsSideNav);

			if (isElementDisplayed(depositsSideNav)) {
				LoggerManager.info("Deposits side navigation is visible, clicking on it");
				clickElementJS(depositsSideNav);

				LoggerManager.info("Successfully searched for the navigation and accessed Deposits");

				boolean isPageTitle = pageTitle.getText().equals("Deposits");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Deposits side navigation is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}
	}

	public String addDeposits() {
		try {
			clickElementJS(communityDropdown);
			clickElementJS(communityDropdownValue);
			waitForElementToBeClickable(addDepositButton);
			clickElementJS(addDepositButton);
			String addPopupTitle = addDepositLable.getText();
			clickElementJS(bankDropdown);
			clickElementJS(searchBankDropdown);
			clickElementJS(searchBankValue);
			waitForInvisibility(loaderIcon);
			clickElement(description);
			enterText(description, "Deposits-Test");
			clickElementJS(checkbox);
			clickElement(saveButton);
			return addPopupTitle;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in addDeposits: " + e.getMessage());
			throw e;
		}
	}

	public String columnChooser() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(columnChooser);
			String colchooserTitle = columnChooserLabel.getText();
			waitForElementToBeClickable(close);
			clickElementJS(close);
			return colchooserTitle;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in columnChooserClick: " + e.getMessage());
			throw e;
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
			LoggerManager.error("Error occurred in toolBarFullScreen: " + e.getMessage());
			throw e;
		}
	}

	public boolean exportToExcel() {
		try {
			if (isElementEnabled(exportExcel)) {
				clickElement(exportExcel);
				waitForInvisibility(loaderIcon);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred in exportToExcel: " + e.getMessage());
			throw e;
		}
	}

	public String viewMenu() {
		try {
			clickElement(actionButton);
			clickElement(viewmenu);
			String viewPopupColumn = viewPopupColHeader.getText();
			clickElement(viewClose);
			return viewPopupColumn;
		} catch (Exception e) {
			LoggerManager.error("Error occurred in viewMenu: " + e.getMessage());
			throw e;
		}
	}
}

