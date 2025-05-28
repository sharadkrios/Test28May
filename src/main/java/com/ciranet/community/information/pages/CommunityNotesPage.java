package com.ciranet.community.information.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.quicksearch.QuickSearch;
import com.ciranet.utilities.LoggerManager;

public class CommunityNotesPage extends BasePage {
	public CommunityNotesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Community Notes')]")
	WebElement communityNotesSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//div[contains(text(),'Add a Note')]")
	WebElement newNoteLabel;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper dx-button-content'])[10]")
	WebElement addNewNoteButton;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[7]")
	WebElement categoryDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[1]")
	WebElement categoryValue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[8]")
	WebElement subCategoryDropdown;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[16]")
	WebElement subCategoryValue;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[14]")
	WebElement subjectTextEditor;

	@FindBy(xpath = "//button[@title='Horizontal line']")
	WebElement horizontalLineIcon;

	@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']")
	WebElement notesTextEditor;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper dx-button-content'])[11]")
	WebElement importNoteTemplateButton;

	@FindBy(xpath = "//div[contains(text(),'Import Notes From Template')]")
	WebElement importNoteTemplateLabel;

	@FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[2]")
	WebElement checkbox;

	@FindBy(xpath = "//span[text()='Import']")
	WebElement importButton;

	@FindBy(xpath = "(//div[@aria-label='Action'])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div[text()=' Edit ']")
	WebElement editMenu;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[text()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[contains(text(),'Edit Note')]")
	WebElement editNoteLabel;

	@FindBy(xpath = "(//i[@title='Notes'])[1]")
	WebElement notesIcon;

	@FindBy(xpath = "(//div[@class='dx-texteditor-container']//textarea[@role='textbox'])[2]")
	WebElement newNotesTextArea;

	@FindBy(xpath = "//div//span[text()='New Notes']")
	WebElement newNotesLabel;

	@FindBy(xpath = "(//i[@title='Log'])[1]")
	WebElement logsIcon;

	@FindBy(xpath = "//div//span[normalize-space()='Close']")
	WebElement closeButton;

	@FindBy(xpath = "//div[@role='presentation']//div[text()='Action']")
	WebElement actionLabel;

	@FindBy(xpath = "(//i[@title='Attachment'])[1]")
	WebElement attachmentIcon;

	@FindBy(xpath = "//span[normalize-space()='Attach Local File']")
	WebElement attachLocalFileButton;

	@FindBy(xpath = "//div[text()='Attachments']")
	WebElement attachmentsLabel;

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
			navigationSearch.navigateBySideNavigation(By.xpath("//span[contains(text(),'Community Notes')]"),
					"Community Notes");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Navigated to Community Notes");

			waitForInvisibility(loaderIcon);

			LoggerManager.info("Scrolling to 'Community Notes' navigation");
			scrollToElement(communityNotesSideNav);

			if (isElementDisplayed(communityNotesSideNav)) {
				LoggerManager.info("Community Notes navigation is visible, clicking on it");
				clickElementJS(communityNotesSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the community and accessed Community Notes");

				boolean isPageTitle = pageTitle.getText().equals("Community Notes");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Community Notes navigation is not visible, search failed");
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

	public String addNote() {
		try {
			clickElement(addNewNoteButton);
			String addTitle = newNoteLabel.getText();
			waitForInvisibility(loaderIcon);
			clickElementJS(categoryDropdown);
			clickElementJS(categoryValue);
			clickElementJS(subCategoryDropdown);
			clickElementJS(subCategoryValue);
			clickElementJS(subjectTextEditor);
			enterText(subjectTextEditor, "Subject for testing purpose");
			clickElementJS(horizontalLineIcon);
			clickElement(saveButton);
			return addTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in addNote: " + e.getMessage());
			throw e;
		}
	}

	public String importNoteTemplate() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(importNoteTemplateButton);
			String notesTemplateTitle = importNoteTemplateLabel.getText();
			clickElement(checkbox);
			clickElement(importButton);
			return notesTemplateTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in importNoteTemplate: " + e.getMessage());
			throw e;
		}
	}

	public String editActionButton() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(actionButton);
			clickElement(editMenu);
			String editTitle = editNoteLabel.getText();
			waitForInvisibility(loaderIcon);
			clickElementJS(saveButton);
			return editTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in actionButton: " + e.getMessage());
			throw e;
		}
	}

	public String notes() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(fullScreenIcon);
			clickElement(notesIcon);
			String label = newNotesLabel.getText();
			clickElement(newNotesTextArea);
			enterText(newNotesTextArea, "Community Test Notes");
			clickElement(saveButton);
			return label;
		} catch (Exception e) {
			LoggerManager.error("Error while adding notes" + e.getMessage());
			throw e;
		}
	}

	public String logs() {
		try {
			waitForInvisibility(loaderIcon);
			clickElement(logsIcon);
			String label = actionLabel.getText();
			clickElement(closeButton);
			return label;
		} catch (Exception e) {
			LoggerManager.error("Error while retrieving logs" + e.getMessage());
			throw e;
		}
	}

	public String attachment() throws AWTException {
		try {
			clickElement(attachmentIcon);
			String label = attachmentsLabel.getText();

			// Using Robot to automate file upload
			Robot robot = new Robot();
			clickElement(attachLocalFileButton);
			StringSelection s = new StringSelection(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\ciranet\\testdata\\communityNotes.pdf");
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
			
			//releasing enter
			robot.keyRelease(KeyEvent.VK_ENTER);
			waitForInvisibility(loaderIcon);
			
			clickElementJS(normalScreenIcon);
			return label;
		} catch (AWTException e) {

			LoggerManager.error("Error while uploading attachment (AWTException)" + e.getMessage());
			throw e;
		} catch (Exception e) {
			LoggerManager.error("Error while uploading attachment" + e.getMessage());
			throw e;
		}
	}
}

