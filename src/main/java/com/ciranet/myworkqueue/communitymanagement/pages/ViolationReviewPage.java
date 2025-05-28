package com.ciranet.myworkqueue.communitymanagement.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

//Every line of code that runs in Java must be inside a class
public class ViolationReviewPage extends BasePage {
	public ViolationReviewPage(WebDriver driver) {
		super(driver);
	}

	// Initializing the Page Objects
	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'Violation Review')]")
	WebElement violationReviewSideNav;

	@FindBy(xpath = "//h2[contains(text(),'Open Violations Requiring Review')]")
	WebElement pageTitle;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "(//div[@class='dx-button-content'])[31]")
	WebElement actionsButton;

	@FindBy(xpath = "//div[text()='Violation Inspection History']")
	WebElement violationHistoryPopupTitle;

	@FindBy(xpath = "(//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal'])[2]")
	WebElement resetIcon;

	@FindBy(xpath = "//span[text()='Approve']")
	WebElement approveButton;

	@FindBy(xpath = "//div[@aria-label='No']")
	WebElement noButton;

	@FindBy(xpath = "//dx-button[@aria-label='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//div[contains(text(),'Hearing Location and Date')]")
	WebElement hearingLocationLabel;
	
	@FindBy(xpath = "//dx-date-box[@type='datetime']//div[@class='dx-dropdowneditor-icon']")
	WebElement datePicker;
	

	@FindBy(xpath = "(//td//span[contains(text(),'18')])[3]")
	WebElement calendarDropdownValue;
	
	@FindBy(xpath = "(//textarea[@role='textbox'])[3]")
	WebElement hearingLocationTextbox;
	
	@FindBy(xpath = "//div[@aria-label='OK']//div[@class='dx-button-content']")
	WebElement datepickerOkButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath = "(//dx-button[@aria-label='Cancel'])[2]")
	WebElement rejectCancelButton;

	@FindBy(xpath = "(//dx-button[@aria-label='Cancel'])[1]")
	WebElement violationCancelButton;

	@FindBy(xpath = "//span[text()='Reject']")
	WebElement rejectButton;

	@FindBy(xpath = "//dx-button[@aria-label=\"Don't Send Notification\"]")
	WebElement notificationButton;

	@FindBy(xpath = "(//dx-text-area//textarea[@role='textbox'])[3]")
	WebElement rejectReasonTextArea;

	@FindBy(xpath = "//dx-button[@aria-label='OK']")
	WebElement okButton;

	@FindBy(xpath = "//dx-button[@aria-label='Browse']")
	WebElement browseButton;

	@FindBy(xpath = "//dx-button[@aria-label='Upload']")
	WebElement uploadButton;

	@FindBy(xpath = "(//dx-button[@aria-label='Close'])[2]")
	WebElement historyCloseButton;

	@FindBy(xpath = "(//textarea[@class='dx-texteditor-input'])[1]")
	WebElement violationNotesTextArea;

	@FindBy(xpath = "(//i[@title='Images'])[2]")
	WebElement imagesColumn;

	@FindBy(xpath = "(//dx-button[@aria-label='Close'])[3]")
	WebElement imagesCloseButton;

	@FindBy(xpath = "(//i[@title='Logs'])[2]")
	WebElement logsColumn;

	@FindBy(xpath = "(//dx-button[@aria-label='Close'])[3]")
	WebElement logsCloseButton;
		
	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	Navigation navigationSearch = new Navigation(driver);

	// method declaration
	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),'Violation Review')]"),
					"Violation Review");
			LoggerManager.info("Navigated to Violation Review");

			LoggerManager.info("Scrolling to Violation Review navigation");
			scrollToElement(violationReviewSideNav);

			if (isElementDisplayed(violationReviewSideNav)) {
				LoggerManager.info("Violation Review navigation is visible, clicking on it");
				clickElementJS(violationReviewSideNav);

				LoggerManager.info("Successfully searched for the navigation and accessed Violation Review");

				boolean isPageTitle = pageTitle.getText().equals("Open Violations Requiring Review");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;
			} else {
				LoggerManager.warn("Violation Review navigation is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
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
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred while toggling full screen mode." + e.getMessage());
			throw e;
		}
	}

	public String violationInspectionHistory() throws Exception {
		try {
			clickElementJS(actionsButton);
			clickElementJS(resetIcon);
			String popupTitle = violationHistoryPopupTitle.getText();
			clickElementJS(approveButton);

			if (isElementDisplayed(hearingLocationLabel)) {
				clickElement(datePicker);
				clickElement(datePicker);
				clickElementJS(calendarDropdownValue);
				clickElementJS(datepickerOkButton);
				clickElementJS(hearingLocationTextbox);
				enterText(hearingLocationTextbox, "Location Test");
				hearingLocationTextbox.sendKeys(Keys.ENTER);
				waitForInvisibility(loaderIcon);
				scrollToElement(saveButton);
				clickElementJS(saveButton);	
			} else {
				clickElementJS(noButton);
			}

			clickElementJS(rejectButton);
			clickElementJS(notificationButton);
			clickElementJS(rejectReasonTextArea);
			enterText(rejectReasonTextArea, "Test Reject");

			clickElementJS(rejectCancelButton);
			clickElementJS(violationCancelButton);

			Robot robot = new Robot();
			clickElementJS(browseButton);
			StringSelection s = new StringSelection(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\ciranet\\testdata\\violationReview.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

			// Clipboard copy
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

			// pressing ctrl+v
			robot.keyPress(KeyEvent.VK_CONTROL);
			waitForInvisibility(loaderIcon);
			
			robot.keyPress(KeyEvent.VK_V);
			waitForInvisibility(loaderIcon);
			
			// releasing ctrl+v
			robot.keyRelease(KeyEvent.VK_CONTROL);
			waitForInvisibility(loaderIcon);
			
			robot.keyRelease(KeyEvent.VK_V);
			waitForInvisibility(loaderIcon);
			
			// pressing enter
			robot.keyPress(KeyEvent.VK_ENTER);
			waitForInvisibility(loaderIcon);
			
			// releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			waitForInvisibility(loaderIcon);
			
			clickElementJS(violationNotesTextArea);
			violationNotesTextArea.sendKeys("Violation Notes Requiring Review");
			if (isElementDisplayed(imagesColumn)) {
				clickElementJS(imagesColumn);
				clickElementJS(actionsButton);
			}
			scrollToElement(logsColumn);
			clickElementJS(logsColumn);
			clickElementJS(logsCloseButton);
			clickElementJS(uploadButton);
			clickElementJS(historyCloseButton);
			return popupTitle;
		} catch (Exception e) {
			LoggerManager.error("An error occurred while handling Violation Inspection History popup." + e.getMessage());
			throw e;
		}		
	}
}