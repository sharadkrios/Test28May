package com.ciranet.community.information.pages;

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
import com.ciranet.quicksearch.QuickSearch;
import com.ciranet.utilities.LoggerManager;

public class CommonLotsPage extends BasePage {
	public CommonLotsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Common Lots')]")
	WebElement commonLotsSideNav;

	@FindBy(xpath = "//h2[text()=' Common Lots ']")
	WebElement pageTitle;

	@FindBy(xpath = "//div[@class='dx-item dx-tab']//div[contains(text(),'Common Lots')]")
	WebElement commonLotsTab;

	@FindBy(xpath = "//div[@class='dx-item dx-tab']//div[contains(text(),'PTA Received')]")
	WebElement ptaReceivedTab;

	@FindBy(xpath = "//div[@class='dx-item dx-tab']//div[contains(text(),'PTA Not Received')]")
	WebElement ptaNotReceivedTab;

	@FindBy(xpath = "//div[@class='dx-item dx-tab']//div[contains(text(),'Property Taxes Paid')]")
	WebElement propertyTaxesPaidTab;

	@FindBy(xpath = "//div[@class='button-content']")
	WebElement addNewCommonLotButton;

	@FindBy(xpath = "//div[contains(text(),'Add a New Common Lot')]")
	WebElement commonLotPopupTitle;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[9]")
	WebElement phaseDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[2]")
	WebElement phaseDropdownValue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[10]")
	WebElement sectionDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[6]")
	WebElement sectionDropdownValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[32]")
	WebElement blockTextbox;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[33]")
	WebElement lotTextbox;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[34]")
	WebElement numberTextbox;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[11]")
	WebElement streetDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[12]")
	WebElement streetDropdownValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[36]")
	WebElement cityTextbox;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[38]")
	WebElement zipTextbox;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[39]")
	WebElement countyTextbox;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[40]")
	WebElement parcelTextbox;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[41]")
	WebElement improvedValueTextbox;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[42]")
	WebElement totalAcreageTextbox;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[13]")
	WebElement commonAreaTypeDropdown;

	@FindBy(xpath = "//div[contains(text(),'Lake')]")
	WebElement commonAreaTypeDropdownValue;

	@FindBy(xpath = "//textarea[@class='dx-texteditor-input']")
	WebElement lotDescriptionTextbox;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[text()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "(//i[@class='dx-icon cc-icon fas fa-external-link-alt'])[1]")
	WebElement fullScreenIcon;

	@FindBy(xpath = "(//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180'])[1]")
	WebElement normalScreenIcon;

	@FindBy(xpath = "(//i[@class='dx-icon cc-icon fas fa-external-link-alt'])[2]")
	WebElement fullScreenIconCategoryGrid;

	@FindBy(xpath = "(//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180'])[2]")
	WebElement normalScreenIconCategoryGrid;

	@FindBy(xpath = "(//div//span[contains(text(),'Action')])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Edit/View')]")
	WebElement editViewMenu;

	@FindBy(xpath = "//div[contains(text(),'Edit a Common Lot')]")
	WebElement editCommonLotPopupTitle;

	@FindBy(xpath = "(//td[contains(text(),'Not Exempt')])[1]")
	WebElement ptaNotExemptMenu;

	@FindBy(xpath = "(//td[contains(text(),'Exemption Filed')])[1]")
	WebElement ptaExemptionFiledMenu;

	@FindBy(xpath = "(//td[contains(text(),'Association Not Responsible')])[1]")
	WebElement ptaAssociationNotResponsibleMenu;

	@FindBy(xpath = "//div[contains(text(),'Change Exempt Status')]")
	WebElement changeExemptStatusMenu;

	@FindBy(xpath = "//div[@class='menu-item-container']//div[contains(text(),'Not Exempt')]")
	WebElement notExemptMenu;

	@FindBy(xpath = "//div[@class='menu-item-container']//div[contains(text(),'Exemption Filed')]")
	WebElement exemptionFiledMenu;

	@FindBy(xpath = "//div[@class='menu-item-container']//div[contains(text(),'Association Not Responsible')]")
	WebElement associationNotResponsibleMenu;

	@FindBy(xpath = "//div[contains(text(),'Activate')]")
	WebElement activateMenu;

	@FindBy(xpath = "//div[contains(text(),'Deactivate')]")
	WebElement deactivateMenu;

	@FindBy(xpath = "(//td[@role='gridcell']//i[@title='Notes'])[1]")
	WebElement notesIcon;

	@FindBy(xpath = "//div[@class='textarea-container']//span[normalize-space()='New Notes']")
	WebElement newNotesLabel;

	@FindBy(xpath = "(//textarea[@role='textbox'])[2]")
	WebElement newNotesTextbox;

	@FindBy(xpath = "//div[contains(text(),'Category')]")
	WebElement categoryColumnText;

	@FindBy(xpath = "//tr[@class='dx-row dx-data-row dx-row-lines dx-column-lines dx-selection']")
	WebElement tableRowSelect;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[1]")
	WebElement yearDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[4]")
	WebElement yearDropdownValue;

	@FindBy(xpath = "//div[@class='dx-datagrid-group-closed']")
	WebElement expandIcon;

	@FindBy(xpath = "//div[contains(text(),'Appraiser')]")
	WebElement appraiserColumnText;

	@FindBy(xpath = "//div[contains(text(),'Street Number')]")
	WebElement streetNumberColumnText;

	@FindBy(xpath = "//div[contains(text(),'Tax Year')]")
	WebElement taxYearColumnText;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	QuickSearch quickSearch = new QuickSearch(driver);
	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	// method declaration
	public boolean navigate(String communityName) throws Exception {

		LoggerManager.info("Starting community search with keyword: {} " + communityName);

		// Wait for loader icon to disappear
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Loader icon is invisible, proceeding with search.");
		quickSearch.searchCommunity(communityName);
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Community search completed for keyword: {} " + communityName);
		try {
			LoggerManager.info("Pressing Escape key to close any popups if present");
			pressEscapeKey(); // Assuming this method handles escape key events
		} catch (AWTException e) {
			LoggerManager.error("Error pressing the Escape key");
		}
		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[contains(text(),'Common Lots')]"),
					"Common Lots");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to Common Lots");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Scrolling to Common Lots navigation");
			scrollToElement(commonLotsSideNav);
			if (isElementDisplayed(commonLotsSideNav)) {
				LoggerManager.info("Common Lots navigation is visible, clicking on it");
				clickElementJS(commonLotsSideNav);
				LoggerManager.info("Successfully searched for the community and accessed Common Lots");
				boolean isPageTitle = pageTitle.getText().equals("Common Lots");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.warn("Common Lots navigation is not visible, search failed");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the community search process");
			return false;
		}
	}

	public boolean toolBarFullScreen() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(fullScreenIcon);
			if (isElementDisplayed(normalScreenIcon)) {
				clickElementJS(normalScreenIcon);
				return true;
			} else {
				LoggerManager.warn("Normal Screen icon not clicked");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error occurred while toggling toolbar fullscreen" + e.getMessage());
			return false;
		}
	}

	public String commonLotActions() {
		try {
			clickElementJS(fullScreenIcon);

			// View/Edit menu
			clickElementJS(actionButton);
			clickElement(editViewMenu);
			String editPopupTitle = editCommonLotPopupTitle.getText();
			scrollToElement(lotDescriptionTextbox);
			clickElementJS(lotDescriptionTextbox);
			enterText(lotDescriptionTextbox, "Edit Common lot description for testing");
			clickElement(saveButton);
			waitForInvisibility(loaderIcon);

			// Change Exempt Status Menu
			clickElementJS(actionButton);
			Actions actions = new Actions(driver);
			actions.moveToElement(changeExemptStatusMenu).perform();
			clickElementJS(notExemptMenu);
			waitForInvisibility(loaderIcon);

			// Exemption Filed Menu
			clickElementJS(actionButton);
			actions.moveToElement(changeExemptStatusMenu).perform();
			clickElementJS(exemptionFiledMenu);
			waitForInvisibility(loaderIcon);

			// Association Not Responsible Menu
			clickElementJS(actionButton);
			actions.moveToElement(changeExemptStatusMenu).perform();
			clickElementJS(associationNotResponsibleMenu);
			waitForInvisibility(loaderIcon);

			// Activate/Deactivate Menu
			clickElementJS(actionButton);
			if (isElementDisplayed(activateMenu)) {
				clickElementJS(activateMenu);
				LoggerManager.info("Activate menu clicked");
			} else {
				clickElementJS(deactivateMenu);
				LoggerManager.info("Deactivate menu clicked");
			}

			waitForInvisibility(loaderIcon);
			return editPopupTitle;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while performing common lot actions" + e.getMessage());
			throw e;
		}
	}

	public String notes() {
		try {
			clickElementJS(notesIcon);
			String notesLabel = newNotesLabel.getText();
			clickElement(newNotesTextbox);
			enterText(newNotesTextbox, "Common lots notes for testing");
			clickElement(saveButton);
			waitForInvisibility(loaderIcon);
			waitForElementToBeClickable(tableRowSelect);
			clickElement(tableRowSelect);
			clickElementJS(normalScreenIcon);
			return notesLabel;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while adding notes" + e.getMessage());
			throw e;
		}
	}

	public String categoryGrid() {
		try {
			clickElementJS(fullScreenIconCategoryGrid);
			String categoryLabel = categoryColumnText.getText();
			waitForInvisibility(loaderIcon);
			clickElementJS(normalScreenIconCategoryGrid);
			return categoryLabel;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while interacting with category grid" + e.getMessage());
			throw e;
		}
	}

	// PTA Received tab
	public String ptaReceivedTab() {
		try {
			clickElementJS(ptaReceivedTab);
			String appraiserLabel = appraiserColumnText.getText();
			clickElement(yearDropdown);
			clickElement(yearDropdownValue);
			clickElement(expandIcon);
			clickElement(notesIcon);
			enterText(newNotesTextbox, "Notes for PTA Received tab");
			clickElement(saveButton);
			waitForInvisibility(loaderIcon);
			return appraiserLabel;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while interacting with PTA Received tab" + e.getMessage());
			throw e;
		}
	}

	// PTA Not Received tab
	public String ptaNotReceivedTab() {
		try {
			clickElementJS(ptaNotReceivedTab);
			String streetNumberLabel = streetNumberColumnText.getText();
			clickElement(yearDropdown);
			clickElement(yearDropdownValue);
			return streetNumberLabel;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while interacting with PTA Not Received tab" + e.getMessage());
			throw e;
		}
	}

	// Property Taxes Paid tab
	public String propertyTaxesPaidTab() {
		try {
			clickElementJS(propertyTaxesPaidTab);
			String taxYearLabel = taxYearColumnText.getText();
			clickElement(expandIcon);
			return taxYearLabel;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while interacting with Property Taxes Paid tab" + e.getMessage());
			throw e;
		}
	}

	// Add Common Lot
	public String addCommonLot() {
		try {
			clickElement(commonLotsTab);
			clickElementJS(addNewCommonLotButton);

			String addPopupTitle = commonLotPopupTitle.getText();
			clickElement(phaseDropdown);
			clickElement(phaseDropdownValue);
			clickElement(sectionDropdown);
			clickElement(sectionDropdownValue);
			clickElement(blockTextbox);
			enterText(blockTextbox, "Test Block");

			clickElement(lotTextbox);
			enterText(lotTextbox, "Test Lot");
			clickElement(numberTextbox);
			enterText(numberTextbox, "9800000001");
			clickElement(streetDropdown);
			clickElement(streetDropdownValue);

			clickElement(cityTextbox);
			enterText(cityTextbox, "San Diego");
			clickElement(zipTextbox);
			enterText(zipTextbox, "92109");

			clickElement(countyTextbox);
			enterText(countyTextbox, "San Diego");
			clickElement(parcelTextbox);
			enterText(parcelTextbox, "Test Parcel");

			clickElement(improvedValueTextbox);
			enterText(improvedValueTextbox, "112233445566");
			clickElement(totalAcreageTextbox);
			enterText(totalAcreageTextbox, "22334455");
			clickElement(commonAreaTypeDropdown);
			clickElement(commonAreaTypeDropdownValue);
			clickElement(lotDescriptionTextbox);
			enterText(lotDescriptionTextbox, "Common lot description for testing");
			clickElement(saveButton);
			return addPopupTitle;
		} catch (Exception e) {
			LoggerManager.error("Error occurred while adding a common lot" + e.getMessage());
			throw e;
		}
	}
}

