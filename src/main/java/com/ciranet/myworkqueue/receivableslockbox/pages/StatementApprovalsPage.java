package com.ciranet.myworkqueue.receivableslockbox.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class StatementApprovalsPage extends BasePage {
	public StatementApprovalsPage(WebDriver driver) {
		super(driver);
	}

	// Initializing the Page Objects
	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'Statement Approvals')]")
	WebElement statementApprovalsSideNav;

	@FindBy(xpath = "(//i[@class='dx-icon cc-icon fas fa-external-link-alt'])[1]")
	WebElement fullScreenIcon;

	@FindBy(xpath = "(//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180'])[1]")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//div//span[normalize-space()='Pending Approvals']")
	WebElement pendingApprovalsTab;

	@FindBy(xpath = "(//div//span[@class='dx-button-text'][normalize-space()='Action'])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Approve & Print')]")
	WebElement approvePrintMenu;

	@FindBy(xpath = "//div[contains(text(),'Delete & Reschedule')]")
	WebElement deleteRescheduleMenu;

	@FindBy(xpath = "//div[contains(text(),'Delete Forever')]")
	WebElement deleteForeverMenu;

	@FindBy(xpath = "//div[@title='Reschedule']//div[@class='dx-button-content']")
	WebElement rescheduleButton;

	@FindBy(xpath = "//div[contains(text(),'Confirmation')]")
	WebElement confirmationTitle;

	@FindBy(xpath = "//span[normalize-space()='No']")
	WebElement noConfirmationButton;

	@FindBy(xpath = "//span[normalize-space()='Yes']")
	WebElement yesConfirmationButton;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color cc-hyperlink-hover'])[1]")
	WebElement communityRecord;

	@FindBy(xpath = "//h2[@class='page-header']//span[contains(text(),'My Community Dashboard - Classic')]")
	WebElement headerCommunity;

	@FindBy(xpath = "(//div[@class='dx-item dx-tab'])[1]")
	WebElement searchApprovalsTab;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[9]")
	WebElement dateTypeDropdown;

	@FindBy(xpath = "//div[contains(text(),'Statement Date')]")
	WebElement dateTypeDropdownValue;

	@FindBy(xpath = "(//input[@role='combobox'])[10]")
	WebElement beginDateDropdown;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Search')])[1]")
	WebElement search;

	@FindBy(xpath = "(//i[@ng-reflect-ng-class='fas fa-history'])[1]")
	WebElement logs;

	@FindBy(xpath = "//dx-button[@title='Close']//span[@class='dx-button-text'][normalize-space()='Close']")
	WebElement logsClose;

	@FindBy(xpath = "(//i[@ng-reflect-ng-class='far fa-file-pdf'])[1]")
	WebElement statementcolumn;

	@FindBy(xpath = "//span[normalize-space()='Close']")
	WebElement errorClose;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[3]")
	WebElement locationSearch;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[14]")
	WebElement runIDValueSearch;

	@FindBy(xpath = "//div[@class='dx-datagrid-filter-panel-clear-filter']")
	WebElement clearButton;

	@FindBy(xpath = "(//div[@class='dx-item dx-tab'])[2]")
	WebElement statementRunsTab;

	@FindBy(xpath = "//span[normalize-space()='Year:']")
	WebElement yearLabel;

	@FindBy(xpath = "//span[normalize-space()='Workspace']")
	WebElement workspaceLabel;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "(//div[@role='presentation']//div[contains(text(),'Run Id')])[2]")
	WebElement runIDColumnLabel;

	@FindBy(xpath = "//span[contains(text(),'Date Type:')]")
	WebElement dateTypeLable;

	@FindBy(xpath = "//span[contains(text(),'Begin Date:')]")
	WebElement beginDateLable;

	@FindBy(xpath = "//div[@role='presentation']//div[contains(text(),'User')]")
	WebElement logsColumnLabel;

	@FindBy(xpath = "//div[contains(text(),'Resource Not Found.')]")
	WebElement errorMessage;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	Navigation navigationSearch = new Navigation(driver);
	
	Robot robot; 

	public void pressEscapeKey() 
	{
		try 
		{
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		}
		catch (AWTException e) 
		{
			e.printStackTrace();
		}
	}
	
	// method declaration
	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),'Statement Approvals')]"),
					"Statement Approvals");
			
			LoggerManager.info("Navigated to 'Statement Approvals");

			LoggerManager.info("Scrolling to Statement Approvals navigation");
			scrollToElement(statementApprovalsSideNav);

			if (isElementDisplayed(statementApprovalsSideNav)) {
				LoggerManager.info("Statement Approvals navigation is visible, clicking on it");
				clickElementJS(statementApprovalsSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed Statement Approvals");

				boolean isPageTitle = pageTitle.getText().equals("Statement Approvals");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Statement Approvals navigation is not visible, search failed");
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
			LoggerManager.error("Error in toolBarFullScreen: " + e.getMessage());
			throw e;
		}
	}

	public boolean approvePrintAction() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(pendingApprovalsTab);
			if (isElementDisplayed(actionButton)) {
				clickElementJS(actionButton);
				clickElement(approvePrintMenu);
			} else {
				LoggerManager.info("Approve & Print menu is displayed");
			}
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in approvePrintAction: " + e.getMessage());
			throw e;
		}
	}

	public String deleteRescheduleAction() {
		String rescheduleButtonText = " ";
		try {
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(actionButton)) {
				clickElementJS(actionButton);
				clickElement(deleteRescheduleMenu);
				rescheduleButtonText = rescheduleButton.getText();
				clickElementJS(rescheduleButton);
				clickElementJS(errorClose);
			} else {
				LoggerManager.info("Delete & Reschedule menu is displayed");
			}
			return rescheduleButtonText;
		} catch (Exception e) {
			LoggerManager.error("Error in deleteRescheduleAction: " + e.getMessage());
			throw e;
		}
	}

	public String deleteForeverAction() {
		String confirmTitle = "";
		try {
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(actionButton)) {
				clickElementJS(actionButton);
				clickElement(deleteForeverMenu);
				confirmTitle = confirmationTitle.getText();
				clickElementJS(noConfirmationButton);

				clickElementJS(actionButton);
				clickElement(deleteForeverMenu);
				clickElementJS(yesConfirmationButton);
			} else {
				LoggerManager.info("Delete Forever menu is displayed");
			}
			return confirmTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in deleteForeverAction: " + e.getMessage());
			throw e;
		}
	}

	public boolean logsClick() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(logs);
			clickElementJS(logsClose);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in logsClick: " + e.getMessage());
			throw e;
		}
	}

	public boolean statementColumnPDFClick() {
		try {
			clickElementJS(statementcolumn);
			waitForInvisibility(loaderIcon);
			clickElementJS(errorClose);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in statementColumnPDFClick: " + e.getMessage());
			throw e;
		}
	}

	public boolean locationColumnClick() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(locationSearch);
			enterText(locationSearch, "Illinois");
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in locationColumnClick: " + e.getMessage());
			throw e;
		}
	}

	public boolean runIDClick() {
		try {
			waitForInvisibility(loaderIcon);
			scrollToElement(runIDValueSearch);
			clickElementJS(runIDValueSearch);
			enterText(runIDValueSearch, "144");
			clickElementJS(clearButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in runIDClick: " + e.getMessage());
			throw e;
		}
	}

	public String community(){
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(communityRecord);
			@SuppressWarnings({ "rawtypes", "unchecked" })
			ArrayList communityDetails = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) communityDetails.get(1));
			waitForInvisibility(loaderIcon);
			pressEscapeKey();
			String headerTitle = headerCommunity.getText();
			driver.switchTo().window((String) communityDetails.get(0));
			return headerTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in community: " + e.getMessage());
			throw e;
		}
	}

	public String searchApprovalsTabRecords() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(searchApprovalsTab);
			clickElementJS(dateTypeDropdown);
			clickElementJS(dateTypeDropdownValue);
			clickElementJS(beginDateDropdown);
			enterText(beginDateDropdown, "12/26/2023");
			clickElementJS(search);
			waitForInvisibility(loaderIcon);
			return dateTypeLable.getText();
		} catch (Exception e) {
			LoggerManager.error("Error in searchApprovalsTabRecords: " + e.getMessage());
			throw e;
		}
	}

	public String statementRunsTabRecords() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(statementRunsTab);
			return yearLabel.getText();
		} catch (Exception e) {
			LoggerManager.error("Error in statementRunsTabRecords: " + e.getMessage());
			throw e;
		}
	}
}