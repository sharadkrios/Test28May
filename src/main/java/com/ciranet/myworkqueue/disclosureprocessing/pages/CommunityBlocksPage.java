package com.ciranet.myworkqueue.disclosureprocessing.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class CommunityBlocksPage extends BasePage {
	public CommunityBlocksPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'Community Blocks')]")
	WebElement communityBlocksSideNav;
	
	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[@title='Column Chooser']")
	WebElement columnChooser;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement columnChooserClose;
 
	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//*[@id='dx-col-1656']")
	WebElement communityColumn;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-file-excel']")
	WebElement exportToExcelIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-minus-square']")
	WebElement collapseAllIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandAllIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetIcon;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-tab-content']//span[@class='dx-tab-text'])[2]")
	WebElement expiredTab;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-tab-content']//span[@class='dx-tab-text'])[1]")
	WebElement activeTab;

	@FindBy(xpath = "//span[normalize-space()='Add Block']")
	WebElement addBlockButton;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper dx-button-content'])[11]")
	WebElement communityDropdown;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement communityDropdownValue;

	@FindBy(xpath = "(//div[@class='dx-field-item-content dx-field-item-content-location-bottom']//input[@class='dx-texteditor-input'])[8]")
	WebElement titleTextbox;

	@FindBy(xpath = "//div[@class='dx-field-item-content dx-field-item-content-location-bottom']//textarea[@class='dx-texteditor-input']")
	WebElement blockText;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[contains(text(),'Add Community Block')]")
	WebElement addBlocksLabel;

	@FindBy(xpath = "(//dx-button[@class='dx-widget dx-button dx-button-mode-contained dx-button-default dx-button-has-text dx-button-has-icon']//div[@class='dx-button-content'])[2]")
	WebElement editButton;

	@FindBy(xpath = "//span[contains(text(),'Block Text:')]")
	WebElement blockTextLabel;

	@FindBy(xpath = "//div[@class='dx-datagrid-filter-panel-clear-filter']")
	WebElement clearButton;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-angle-double-right']")
	WebElement collapseIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-angle-double-left']")
	WebElement expandIcon;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container']//input[@class='dx-texteditor-input'])[5]")
	WebElement communityFilter;

	@FindBy(xpath = "//div[contains(text(),'Column Chooser')]")
	WebElement columnChooserTitle;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;
		
	@FindBy(xpath = "(//i[@class='cc-1-5x fas fa-history'])[1]")
	WebElement historyIcon;

	@FindBy(xpath = "//span[normalize-space()='Close']")
	WebElement historyCloseButton;
	
	@FindBy(xpath = "//div[@role='presentation'][contains(text(),'Additional Info')]")
	WebElement infoColumnHeader;
	
	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color cc-hyperlink-hover'])[1]")
	WebElement communityLink;
	
	@FindBy(xpath = "//i[@class='dx-icon fas fa-times']")
	WebElement crossMark;
	
	@FindBy(xpath = "(//div[contains(text(),'Community')])[1]")
	WebElement communityHeader;
	
	@FindBy(xpath = "(//span[contains(text(),'My Community Dashboard - Classic')])[2]")
	WebElement communityPageTitle;


	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),'Community Blocks')]"),
					"Community Blocks");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to 'Community Blocks");

			waitForInvisibility(loaderIcon);

			LoggerManager.info("Scrolling to Community Blocks navigation");
			scrollToElement(communityBlocksSideNav);

			if (isElementDisplayed(communityBlocksSideNav)) {
				LoggerManager.info("Community Blocks navigation is visible, clicking on it");
				clickElementJS(communityBlocksSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed Community Blocks");

				boolean isPageTitle = pageTitle.getText().equals("SOA Community Blocks Config");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Community Blocks navigation is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}
	}

	public String columnChooserClick() {
		try {
			clickElement(columnChooser);
			String colchooserLabel = columnChooserTitle.getText();
			waitForElementToBeClickable(columnChooserClose);
			clickElement(columnChooserClose);
			return colchooserLabel;
		} catch (Exception e) {
			LoggerManager.error("Error in columnChooserClick: " + e.getMessage());
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
			LoggerManager.error("Error in toolBarFullScreen: " + e.getMessage());
			throw e;
		}
	}

	public boolean exportToExcel() {
		try {
			if (isElementEnabled(exportToExcelIcon)) {
				clickElement(exportToExcelIcon);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in exportToExcel: " + e.getMessage());
			throw e;
		}
	}

	public String addBlock() {
		try {
			clickElement(addBlockButton);
			String addPopupTitle = addBlocksLabel.getText();
			clickElementJS(communityDropdown);
			clickElement(communityDropdownValue);
			clickElement(titleTextbox);
			enterText(titleTextbox, "New Community Added");
			enterText(blockText, "Testing Purpose");
			scrollToElement(saveButton);
			clickElement(saveButton);
			return addPopupTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in addBlock: " + e.getMessage());
			throw e;
		}
	}

	public String activeEditButton() {
		try {
			clickElement(activeTab);
			clickElementJS(editButton);
			waitForInvisibility(loaderIcon);
			String textLabel = blockTextLabel.getText();
			scrollToElement(saveButton);
			clickElementJS(saveButton);
			return textLabel;
		} catch (Exception e) {
			LoggerManager.error("Error in activeEditButton: " + e.getMessage());
			throw e;
		}
	}

	public String expiredEditButton() {
		try {
			clickElement(expiredTab);
			waitForInvisibility(loaderIcon);
			clickElementJS(editButton);
			String labelText = blockTextLabel.getText();
			scrollToElement(saveButton);
			clickElement(saveButton);
			clickElement(activeTab);
			waitForInvisibility(loaderIcon);
			return labelText;
		} catch (Exception e) {
			LoggerManager.error("Error in expiredEditButton: " + e.getMessage());
			throw e;
		}
	}

	public String community() {
		try {
			clickElementJS(communityLink);
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayList communityDetails = new ArrayList(driver.getWindowHandles());
	        driver.switchTo().window((String) communityDetails.get(1));
	        clickElementJS(crossMark);
	        String title = communityPageTitle.getText();
	        driver.switchTo().window((String) communityDetails.get(0));
			return title;
		} catch (Exception e) {
			LoggerManager.error("Error in communityFilter: " + e.getMessage());
			throw e;
		}
	}
	
	public String logs() {
		try {
			clickElement(activeTab);
			scrollToElement(historyIcon);
			clickElementJS(historyIcon);
			clickElementJS(historyCloseButton);
			clickElement(expiredTab);
			scrollToElement(historyIcon);
			clickElementJS(historyIcon);
			String columnHeader = infoColumnHeader.getText();
			clickElementJS(historyCloseButton);
			return columnHeader;
		} catch (Exception e) {
			LoggerManager.error("Error in logs: " + e.getMessage());
			throw e;
		}
	}
}