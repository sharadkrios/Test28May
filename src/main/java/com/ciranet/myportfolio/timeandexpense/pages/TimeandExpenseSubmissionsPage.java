package com.ciranet.myportfolio.timeandexpense.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class TimeandExpenseSubmissionsPage extends BasePage {
	public TimeandExpenseSubmissionsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'Time & Expense Submission')]")
	WebElement timeandExpenseSubmissionSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[1]")
	WebElement entityDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[1]")
	WebElement entityDropdownValue;
	
	@FindBy(xpath = "(//div[@class='dx-datagrid-group-closed'])[2]")
	WebElement expensesClosed;

	@FindBy(xpath = "//div[@class='dx-datagrid-group-opened']")
	WebElement expensesOpened;

	@FindBy(xpath = "//div[contains(text(),'General Expenses')]")
	WebElement generalExpensesLabel;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Action')])[5]")
	WebElement actionButton;

	@FindBy(xpath = "//div[@class='menu-text'][normalize-space()='Approve']")
	WebElement approveMenu;

	@FindBy(xpath = "(//div[contains(text(),'Verified By')])[1]")
	WebElement verifiedByLabel;

	@FindBy(xpath = "//div[@class='menu-text'][normalize-space()='Deny']")
	WebElement denyMenu;

	@FindBy(xpath = "//div[contains(text(),'Deny Reason')]")
	WebElement denyReasonLabel;

	@FindBy(xpath = "//textarea[@role='textbox']")
	WebElement denyReasonTextBox;

	@FindBy(xpath = "//span[normalize-space()='Confirm Deny']")
	WebElement confirmDenyButton;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color'])[5]")
	WebElement submittedByCell;

	@FindBy(xpath = "//h5[text()=' Experience Summary ']")
	WebElement experienceSummaryLabel;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeIcon;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate() throws Exception {
		try {
			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),'Time & Expense Submission' )]"),
					"Time & Expense Submission");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to Time & Expense Submission");

			waitForInvisibility(loaderIcon);

			LoggerManager.info("Scrolling to 'Time & Expense Submission' navigation");
			scrollToElement(timeandExpenseSubmissionSideNav);

			if (isElementDisplayed(timeandExpenseSubmissionSideNav)) {
				LoggerManager.info("Time & Expense Submission navigation is visible, clicking on it");
				clickElementJS(timeandExpenseSubmissionSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed Time & Expense Submission");

				boolean isPageTitle = pageTitle.getText().equals("Time & Expense Submissions");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Time & Expense Submission navigation is not visible, search failed");
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
				LoggerManager.info("ToolBar Full Screen toggled to Normal Screen.");
				return true;
			} else {
				LoggerManager.warn("ToolBar Full Screen failed, Normal Screen button not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in toolBarFullScreen method" + e.getMessage());
			throw e;
		}
	}

	public String entity() {
		try {
			clickElement(entityDropdown);
			clickElement(entityDropdownValue);
			waitForInvisibility(loaderIcon);
			String actionText = actionButton.getText();
			return actionText;
		} catch (Exception e) {
			LoggerManager.error("Error in entity method" + e.getMessage());
			throw e;
		}
	}

	public String generalExpense() {
		try {
			clickElement(expensesClosed);
			String expenseLabel = generalExpensesLabel.getText();
			clickElement(expensesOpened);
			return expenseLabel;
		} catch (Exception e) {
			LoggerManager.error("Error in generalExpenses method" + e.getMessage());
			throw e;
		}
	}
	
	public boolean approveMenu() {
	    try {
	        clickElement(actionButton);
	        clickElement(approveMenu);
	        return true; 
	    } catch (Exception e) {
	        LoggerManager.error("Error in approveMenu method: " + e.getMessage());
	        return false;
	    }
	}

	public boolean denyMenu() {
	    try {
	        waitForInvisibility(loaderIcon);
	        clickElement(actionButton);
	        clickElement(denyMenu);
	        enterText(denyReasonTextBox, "Expense deny for testing purpose");
	        clickElement(confirmDenyButton);
	        return true;
	    } catch (Exception e) {
	        LoggerManager.error("Error in denyMenu method: " + e.getMessage());
	        return false;
	    }
	}

	public String submittedByColumn() {
		try {
			waitForInvisibility(loaderIcon);
			scrollToElement(submittedByCell);
			clickElementJS(submittedByCell);
			String summaryExperience = experienceSummaryLabel.getText();
			clickElementJS(closeIcon);
			return summaryExperience;
		} catch (Exception e) {
			LoggerManager.error("Error in submittedByColumn method" + e.getMessage());
			throw e;
		}
	}
}
