package com.ciranet.cirabooks.accountspayable.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.quicksearch.QuickSearch;
import com.ciranet.utilities.LoggerManager;

public class APExpenseDetailPage extends BasePage {
	public APExpenseDetailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//div[@class='dx-button-content'])[4]")
	WebElement communityIcon;

	@FindBy(xpath = "//input[@role='textbox']")
	WebElement textBox;

	@FindBy(xpath = "(//span[contains(text(),'Amberwood')])[1]")
	WebElement amberwoodCommunity;

	@FindBy(xpath = "//i[@class='dx-icon fas fa-times']")
	WebElement crossMark;

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'Community')]")
	WebElement communitySideNav;

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'CiraBooks')]")
	WebElement ciraBooksSideNav;

	@FindBy(xpath = "//span[contains(text(),'Accounts Payable')]")
	WebElement accountsPayableSideNav;

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'AP Expense Detail')]")
	WebElement apExpenseDetailSideNav;

	@FindBy(xpath = "//h2[contains(text(),'AP Expense Detail')]")
	WebElement pageTitle;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color'])[1]")
	WebElement amountColumn;

	@FindBy(xpath = "//span[contains(text(),'Bill Description:')]")
	WebElement billDescriptionLable;

	@FindBy(xpath = "//dx-button[@aria-label='Reclassify']")
	WebElement reclassifyButton;

	@FindBy(xpath = "//legend[contains(text(),'AAP Workflow Job Details')]")
	WebElement jobDetailsLabel;

	@FindBy(xpath = "(//dx-button[@aria-label='Close'])[2]")
	WebElement errorCloseButton;

	@FindBy(xpath = "//dx-button[@title='Settings']")
	WebElement settingButton;

	@FindBy(xpath = "//span[text()='Show Invoice On Right Pane']")
	WebElement rightPane;

	@FindBy(xpath = "//dx-button[@title='Settings']")
	WebElement settingButton1;

	@FindBy(xpath = "//span[text()='Show Invoice On Left Pane']")
	WebElement leftPane;

	@FindBy(xpath = "//div[text()='Internal Notes']")
	WebElement internalNotesIcon;

	@FindBy(xpath = "(//div[@class='dx-texteditor-container']//textarea[@class='dx-texteditor-input'])[2]")
	WebElement newNotesTextbox;

	@FindBy(xpath = "//dx-button[@aria-label='Save']")
	WebElement newNotesSave;

	@FindBy(xpath = "(//dx-button[@aria-label='Close'])[3]")
	WebElement newNotesClose;

	@FindBy(xpath = "//i[@title='Invoice History']")
	WebElement workflowHistoryIcon;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains (text(),'Close')])[3]")
	WebElement historyCloseButton;

	@FindBy(xpath = "//dx-button[@text='Reclass']")
	WebElement reclassButton;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement apBillClose;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

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

		// Wait for loader icon to disappear
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Loader icon is invisible, proceeding with search.");

		quickSearch.searchCommunity(communityName);
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Community search completed for keyword: {} " + communityName);

		try {
			LoggerManager.info("Pressing Escape key to close any popups if present");
			pressEscapeKey();
		} catch (AWTException e) {
			LoggerManager.error("Error pressing the Escape key"+ e.getMessage());
		}

		try {
			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),'AP Expense Detail')]"),
					"AP Expense Detail");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to AP Expense Detail");

			waitForInvisibility(loaderIcon);

			LoggerManager.info("Scrolling to 'AP Expense Detail' navigation");
			scrollToElement(apExpenseDetailSideNav);

			if (isElementDisplayed(apExpenseDetailSideNav)) {
				LoggerManager.info("AP Expense Detail navigation is visible, clicking on it");
				clickElementJS(apExpenseDetailSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the community and accessed AP Expense Detail");

				boolean isPageTitle = pageTitle.getText().equals("AP Expense Detail");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("AP Expense Detail navigation is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the community search process");
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
			LoggerManager.error("Error in toolBarFullScreen method" + e.getMessage());
			throw e;
		}
	}

	public String reclassifyButton() {
		try {
			clickElementJS(amountColumn);
			clickElement(reclassifyButton);
			clickElement(errorCloseButton);

			String detailsJob = jobDetailsLabel.getText();

			clickElement(settingButton);
			clickElement(rightPane);
			clickElement(settingButton);
			clickElement(leftPane);
			clickElement(internalNotesIcon);
			clickElement(newNotesTextbox);
			enterText(newNotesTextbox, "AP Expense Details");
			clickElement(newNotesSave);
			clickElement(newNotesClose);
			clickElement(workflowHistoryIcon);
			clickElement(historyCloseButton);
			clickElement(reclassButton);
			clickElementJS(apBillClose);
			return detailsJob;
		} catch (Exception e) {
			LoggerManager.error("Error in reclassifyButton method" + e.getMessage());
			throw e;
		}

	}
}
