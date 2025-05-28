package com.ciranet.myworkqueue.processtracker.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class AnnualStatementGenerationProcessPage extends BasePage {

	// Step 1:Rules Approved
	@FindBy(xpath = "(//i[@class='cc-hyperlink cc-1-25x cc-blue-icon fas fa-edit'])[9]")
	private WebElement step1Edit;

	@FindBy(xpath = "(//div[@class='dx-switch-handle'])[4]")
	private WebElement valueLockedToggleYes;

	@FindBy(xpath = "//dx-switch[@aria-label='No']")
	private WebElement valueLockedToggleNo;

	@FindBy(xpath = "//div[contains(text(),'Set Value')]")
	private WebElement setValueTab;

	@FindBy(xpath = "(//div[contains(text(),'Notes')])[2]")
	private WebElement notesTab;

	@FindBy(xpath = "(//textarea[@role='textbox'])[2]")
	private WebElement newNotesTextbox;

	@FindBy(xpath = "//span[contains(text(),'Save Notes')]")
	private WebElement saveNotesButton;

	@FindBy(xpath = "//div[@title='Reject']//div[@class='dx-button-content']")
	private WebElement rejectButton;

	@FindBy(xpath = "(//textarea[@role='textbox'])[3]")
	private WebElement rejectTextbox;

	@FindBy(xpath = "(//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-danger dx-button-has-text dx-button-has-icon'])[2]")
	private WebElement descriptionRejectButton;

	@FindBy(xpath = "//div[@title='Save / Approve']")
	private WebElement saveApproveButton;

	@FindBy(xpath = "//div[@role='button' and @aria-label='Upload']")
	private WebElement uploadButton;

	@FindBy(xpath = "(//dx-text-area//textarea[@role='textbox'])[3]")
	private WebElement resolutionTextArea;

	@FindBy(xpath = "(//div[@title='Save'])[2]")
	private WebElement saveButton;

	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	private WebElement refreshButton;

	// Step2 Statements Generated, Printed and Approved
	@FindBy(xpath = "(//i[@class='cc-hyperlink cc-1-25x cc-blue-icon fas fa-edit'])[10]")
	private WebElement step2Edit;

	// Step 3 Statements Forwarded to FSG for mail fulfillment
	@FindBy(xpath = "(//i[@class='cc-hyperlink cc-1-25x cc-blue-icon fas fa-edit'])[11]")
	private WebElement step3Edit;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[8]")
	private WebElement statusDropdown;

	@FindBy(xpath = "//div[@class='dx-item-content dx-list-item-content'][normalize-space()='complete']")
	private WebElement statusDropdownValue;

	// Step 4 Statements Have Been Mailed
	@FindBy(xpath = "(//i[@class='cc-hyperlink cc-1-25x cc-blue-icon fas fa-edit'])[12]")
	private WebElement step4Edit;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-input-wrapper']//div[@class='dx-dropdowneditor-icon']")
	private WebElement calendarDropdown;

	@FindBy(xpath = "(//td//span[contains(text(),'6')])[1]")
	private WebElement calendarDropdownValue;

	@FindBy(xpath = "(//div//span[@class='dx-button-text'][normalize-space()='Action'])[4]")
	private WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Flag Complete')]")
	private WebElement flagComplete;

	@FindBy(xpath = "//div[contains(text(),'Confirmation')]")
	private WebElement confirmationPopup;

	@FindBy(xpath = "//div[contains(text(),'Flag Unnecessary')]")
	private WebElement flagUnnecessary;

	@FindBy(xpath = "//span[normalize-space()='No']")
	private WebElement confirmationNoButton;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']")
	private WebElement loaderIcon;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-toast-success dx-toast-content dx-resizable']")
	private WebElement successAlertMessage;

	public AnnualStatementGenerationProcessPage(WebDriver driver) {
		super(driver);
	}

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigateToAnnualStatementGenerationProcess() {
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigate(By.xpath("//div//span[normalize-space()='Annual Statement Generation Process']"),
					"Annual Statement Generation Process");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to Annual Statement Generation Process");

			return verifyPageHeaderTextMatches("Annual Statement Generation Process");
		} catch (RuntimeException e) {
			LoggerManager
					.error("An error occurred during the navigating to Annual Statement Generation Process selection"
							+ e.getMessage());
			return false;
		}
	}

	// Method for rejecting a note
	private boolean handleNoteRejection(String rejectionMessage) { 
		try {
			clickElementJS(notesTab);
			clickElementJS(rejectButton);
			clickElement(rejectTextbox);
			rejectTextbox.sendKeys(rejectionMessage);
			rejectTextbox.sendKeys(Keys.ENTER);
			clickElement(descriptionRejectButton);
			return confirmSuccessAlertMessage();
		} catch (TimeoutException e) {
			LoggerManager.error("An error occurred while rejecting note: " + e.getMessage());
			return false;
		}
	}

	// Method to handle file upload
	private void handleFileUpload(String filePath) throws Exception {
		try {
			Robot robot = new Robot();
			StringSelection filePathSelection = new StringSelection(System.getProperty("user.dir") + filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (RuntimeException e) {
			LoggerManager.info("Error while handling file upload: " + e.getMessage());
			throw e;
		}
	}

	// Method to handle Resolution Description
	private boolean handleResolutionDescriptionTextArea(String rejectionMessage) {
		try {
			if (isElementDisplayed(resolutionTextArea)) {
				clickElementJS(resolutionTextArea);
				resolutionTextArea.sendKeys(rejectionMessage);
				resolutionTextArea.sendKeys(Keys.ENTER);
				saveButton.click();
				waitForInvisibility(loaderIcon);
				return true;
			} else {
				LoggerManager.info("Resolution text area is not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error handling resolution text area: " + e.getMessage());
			return false;
		}
	}

	// Check Success Alert Message
	public boolean confirmSuccessAlertMessage() { 
		try {
			waitForElementToBeVisible(successAlertMessage);

			if (isElementDisplayed(successAlertMessage)) {
				LoggerManager.info("Success Alert Message: " + successAlertMessage.getText());
				return true;
			} else {
				LoggerManager.info("Success Alert Message not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred while checking the Success Alert Message: " + e.getMessage());
			return false;
		}
	}

	// Steps approve and upload files
	public void handleFileApprovalAndUpload (String step, String filePath, String notes) throws Exception {
		try {
			clickElement("step1".equals(step) ? step1Edit : step2Edit);
			clickElementJS(notesTab);
			clickElementJS(newNotesTextbox);
			enterText(newNotesTextbox, notes);
			clickElementJS(saveNotesButton);
			clickElementJS(setValueTab);
			clickElement(uploadButton);
			waitForInvisibility(loaderIcon);
			handleFileUpload(filePath);
			waitForInvisibility(loaderIcon);
			clickElementJS(saveApproveButton);

			// Handle resolution description
			if (handleResolutionDescriptionTextArea("Resolution rejection")) {
				LoggerManager.info("Resolution rejection handled successfully.");
			} else {
				LoggerManager.info("Resolution text area not handled.");
			}

			// Step-specific lock toggle
			clickElementJS("step1".equals(step) ? step1Edit : step2Edit);
			handleValueLockedToggle();
		} catch (RuntimeException e) {
			LoggerManager.info("Error during approveAndUploadFiles: " + e.getMessage());
			throw e;
		}
	}

	// Value Locked Toggle
	public void handleValueLockedToggle() { 
		try {
			if (isElementDisplayed(valueLockedToggleNo)) {
				clickElement(valueLockedToggleYes);
			} else {
				LoggerManager.info("valueLockedToggleNo is not displayed.");
			}
			clickElement(saveApproveButton);
		} catch (RuntimeException e) {
			LoggerManager.info("Error during toggleValueLocked: " + e.getMessage());
			throw e;
		}
	}

	// Step1 Rules Approved starts
	public boolean handleNoteRejectionForStep1() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(refreshButton);
			clickElement(step1Edit);
			return handleNoteRejection("Step 1 Rejection");
		} catch (Exception e) {
			LoggerManager.info("Error during noteRejectedForRulesApproved: " + e.getMessage());
			return false;
		}
	}

	public boolean handleRulesApprovalAndFileUpload(String filePath) {
		try {
			handleFileApprovalAndUpload("step1", filePath, "Step 1 Notes");
			return confirmSuccessAlertMessage();
		} catch (Exception e) {
			LoggerManager.info("Error during rulesApprovedAndUploadFiles: " + e.getMessage());
			return false;
		}
	}

	// Step2 Statements Generated, Printed and Approved starts
	public boolean handleNoteRejectionForStep2() {
		try {
			clickElementJS(refreshButton);
			waitForInvisibility(loaderIcon);
			scrollToElement(step2Edit);
			clickElementJS(step2Edit);
			return handleNoteRejection("Step 2 Rejection");
		} catch (Exception e) {
			LoggerManager.info("Error during rejectNoteForGeneratedStatements: " + e.getMessage());
			return false;
		}
	}

	public boolean handleGeneratedStatementsApprovalAndUpload(String filePath) { 
		try {
			handleFileApprovalAndUpload("step2", filePath, "Step 2 Notes");
			return confirmSuccessAlertMessage();
		} catch (Exception e) {
			LoggerManager.info("Error during approveStatementsGeneratedAndUploadFiles: " + e.getMessage());
			return false;
		}
	}

	// Step3 Statements Forwarded to FSG for mail fulfillment starts
	public boolean handleForwardedStatementsApproval() { 
		try {
			clickElement(refreshButton);
			waitForInvisibility(loaderIcon);
			scrollToElement(step3Edit);
			clickElementJS(step3Edit);
			clickElement(notesTab);
			clickElement(newNotesTextbox);
			enterText(newNotesTextbox, "Step 3 Notes");
			clickElement(saveNotesButton);
			clickElement(setValueTab);
			clickElement(statusDropdown);
			clickElement(statusDropdownValue);
			clickElement(saveApproveButton);
			return confirmSuccessAlertMessage();
		} catch (Exception e) {
			LoggerManager.info("An error occurred in approveStatementsForwardedToFSG: " + e.getMessage());
			return false;
		}
	}

	// Step4 Statements Have Been Mailed starts
	public boolean handleNoteRejectionForStep4() {
		try {
			waitForInvisibility(loaderIcon);
			scrollToElement(step4Edit);
			clickElementJS(step4Edit);
			return handleNoteRejection("Step 4 Rejection");
		} catch (Exception e) {
			LoggerManager.info("Error during rejectNoteForMailedStatements: " + e.getMessage());
			return false;
		}
	}

	public boolean handleMailedStatementsApproval() {
		try {
			clickElementJS(refreshButton);
			waitForInvisibility(loaderIcon);
			scrollToElement(step4Edit);
			clickElementJS(step4Edit);
			clickElement(notesTab);
			clickElement(newNotesTextbox);
			enterText(newNotesTextbox, "Step 4 Notes");
			waitForInvisibility(loaderIcon);

			clickElement(saveNotesButton);
			clickElement(setValueTab);
			clickElement(calendarDropdown);
			clickElement(calendarDropdownValue);
			waitForInvisibility(loaderIcon);
			clickElement(saveApproveButton);
			waitForInvisibility(loaderIcon);

			if (handleResolutionDescriptionTextArea("Resolution rejection")) {
				LoggerManager.info("Resolution rejection handled successfully.");
			} else {
				LoggerManager.info("Resolution text area not handled.");
			}

			clickElementJS(step4Edit);
			handleValueLockedToggle();
			return confirmSuccessAlertMessage();
		} catch (RuntimeException e) {
			LoggerManager.error("An error occurred in approveMailedStatements: " + e.getMessage());
			return false;
		}
	}

	// Handle action flags
	public String handleActionWithFlags() {
		try {
			clickElementJS(refreshButton);
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			clickElement(flagComplete);
			waitForInvisibility(loaderIcon);
			String confirmationPopupTitle = confirmationPopup.getText();
			clickElement(confirmationNoButton);
			clickElementJS(actionButton);
			clickElement(flagUnnecessary);
			return confirmationPopupTitle;
		} catch (RuntimeException e) {
			LoggerManager.info("An error occurred in handleActionWithFlags: " + e.getMessage());
			throw e;
		}
	}
}