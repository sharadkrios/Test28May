package com.ciranet.myworkqueue.communityonboarding.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class OnBoardingChecklistPage extends BasePage {
	public OnBoardingChecklistPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'My Work Queue')]")
	WebElement myWorkQueueSideNav;

	@FindBy(xpath = "//span[normalize-space()='Community On-Boarding']")
	WebElement communityOnBoardingSideNav;

	@FindBy(xpath = "//span[normalize-space()='On-Boarding Checklist']")
	WebElement onBoardingChecklistSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "//dx-button[@title='Hide Menu']//i[@class='dx-icon dx-icon-menu']")
	WebElement hamburger;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[1]")
	WebElement departmentDropDown;

	@FindBy(xpath = "//div[contains(text(),'GrandManors Accounting')]")
	WebElement departmentDropDownValue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[2]")
	WebElement statusDropDown;

	@FindBy(xpath = "//div[contains(text(),'In Production')]")
	WebElement statusDropDownValue;

	@FindBy(xpath = "//span[normalize-space()='Refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "//div[@role='presentation']//div[text()='Status']")
	WebElement statusColumn;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Action')])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Change Assign To')]")
	WebElement changeAssignToMenu;

	@FindBy(xpath = "//div[contains(text(),'Assigned To User')]")
	WebElement assignToUserPopupTitle;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Select')])[1]")
	WebElement selectButton;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-popup-title dx-has-close-button']")
	WebElement errorPopupTitle;

	@FindBy(xpath = "//dx-button[@aria-label='Close']//span[@class='dx-button-text'][normalize-space()='Close']")
	WebElement errorPopupCloseButton;

	@FindBy(xpath = "//i[@class='dx-icon fas fa-times']")
	WebElement closeAssignToUserPopupButton;

	@FindBy(xpath = "//div[@class='dx-button-content']//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayout;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandAll;

	@FindBy(xpath = "//div[@class='menu-text'][normalize-space()='Approve']")
	WebElement approveMenu;

	@FindBy(xpath = "//div[contains(text(),'Notes for Approval without Documents')]")
	WebElement approvePopupTitle;

	@FindBy(xpath = "(//div[@class='dx-texteditor-container']//textarea[@role='textbox'])[2]")
	WebElement approvingNotesTextBox;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Save']")
	WebElement saveApprovingNotesButton;

	@FindBy(xpath = "(//div[@class='menu-item-container']//div[@class='menu-text'])[3]")
	WebElement emailReminderMenu;

	@FindBy(xpath = "//div[contains(text(),'Service Team')]")
	WebElement serviceTeamMenu;

	@FindBy(xpath = "//div[contains(text(),'CiraConnect Account Managers')]")
	WebElement serviceTeamMail;

	@FindBy(xpath = "//div[contains(text(),'Set Not Applicable')]")
	WebElement setNotApplicableMenu;

	@FindBy(xpath = "//div[@aria-label='No']//div[@class='dx-button-content']")
	WebElement noConfirmationPopup;

	@FindBy(xpath = "//div[contains(text(),'Confirmation')]")
	WebElement confirmationPopup;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper']//i[@ng-reflect-ng-class='fas fa-paperclip'])[1]")
	WebElement attachmentIcon;

	@FindBy(xpath = "//div[@class='button-template-content dx-template-wrapper dx-button-content']")
	WebElement communityDocumentButton;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper']//i[@class='dx-icon-folder'])[7]")
	WebElement communityDocumentTree;

	@FindBy(xpath = "(//div[@class='dx-checkbox-container']//span[@class='dx-checkbox-icon'])[2]")
	WebElement communityDocumentCheckList;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Attach']")
	WebElement attachCommunityDocumentButton;

	@FindBy(xpath = "//div[contains(text(),'Manage Documents')]")
	WebElement manageDocumentPopup;

	@FindBy(xpath = "(//div[@role='presentation'])[34]")
	WebElement approvedOnColumnHeader;

	@FindBy(xpath = "(//i[@class='cc-1-5x cc-blue-icon fas fa-envelope'])[1]")
	WebElement emailEnvelopIcon;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[contains(text(),'Emails')]")
	WebElement emailPopupTitle;

	@FindBy(xpath = "//span[normalize-space()='Link Emails']")
	WebElement linkEmailButton;

	@FindBy(xpath = "(//span[@class='dx-button-text'][normalize-space()='Close'])[1]")
	WebElement viewCloseIcon;

	@FindBy(xpath = "//span[normalize-space()='Close']")
	WebElement emailCloseIcon;

	@FindBy(xpath = "(//i[@class='cc-1-5x cc-blue-icon fas fa-history'])[1]")
	WebElement logIcon;

	@FindBy(xpath = "//div[@class='dx-item dx-toolbar-item dx-toolbar-label']")
	WebElement logPopupTitle;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement logCloseIcon;

	@FindBy(xpath = "(//i[@class='cc-1-5x cc-icon-check fas fa-clipboard-check'])[1]")
	WebElement notesIconWithCheckMark;

	@FindBy(xpath = "(//i[@class='cc-1-5x cc-blue-icon far fa-clipboard'])[1]")
	WebElement notesIconWithUncheckMark;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-toolbar-item-content'])[25]")
	WebElement notesPopupTitle;

	@FindBy(xpath = "(//div[@class='dx-texteditor-container']//textarea[@role='textbox'])[2]")
	WebElement notesTextArea;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveNotesButton;

	@FindBy(xpath = "//span[normalize-space()='Close']")
	WebElement closeManageDocumentbutton;

	@FindBy(xpath = "(//div[@aria-label='close'])[2]")
	WebElement closeIcon;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//span[normalize-space()='On-Boarding Checklist']"),
					"On-Boarding Checklist");
			LoggerManager.info("Navigated to On-Boarding Checklist");
			LoggerManager.info("Scrolling to On-Boarding Checklist navigation");
			scrollToElement(onBoardingChecklistSideNav);

			if (isElementDisplayed(onBoardingChecklistSideNav)) {
				LoggerManager.info("On-Boarding Checklist navigation is visible, clicking on it");
				clickElementJS(onBoardingChecklistSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed On-Boarding Checklist");

				boolean isPageTitle = pageTitle.getText().equals("On-Boarding Checklist");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("On-Boarding Checklist navigation is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}

	}

	public String changeAssignedToAction() {
		String popUpTitleAssignToUser = "";
		try {
			clickElement(hamburger);
			clickElement(departmentDropDown);
			clickElementJS(departmentDropDownValue);
			clickElement(statusDropDown);
			clickElementJS(statusDropDownValue);
			clickElement(refreshButton);
			waitForInvisibility(loaderIcon);
			clickElement(resetLayout);
			clickElement(expandAll);
			clickElementJS(actionButton);
			clickElementJS(changeAssignToMenu);
			waitForInvisibility(loaderIcon);
			popUpTitleAssignToUser = assignToUserPopupTitle.getText();
			clickElementJS(selectButton);
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(errorPopupTitle)) {
				clickElementJS(errorPopupCloseButton);
				LoggerManager.warn("Error popup displayed and closed.");
			}

			if (isElementDisplayed(closeAssignToUserPopupButton)) {
				clickElementJS(closeAssignToUserPopupButton);

			}
		} catch (Exception e) {
			LoggerManager.error("Exception in changeAssignedToAction: " + e.getMessage());
			throw e;
		}
		return popUpTitleAssignToUser;
	}

	public boolean approveAction() {
		try {
			clickElementJS(actionButton);
			clickElementJS(approveMenu);
			if (isElementDisplayed(approvingNotesTextBox)) {
				clickElementJS(approvingNotesTextBox);
				approvingNotesTextBox.sendKeys("Approving Notes Testing");
				waitForInvisibility(loaderIcon);
				clickElementJS(saveApprovingNotesButton);
			}
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in approveAction: " + e.getMessage());
			throw e;
		}
	}

	public boolean emailReminderAction() {
		try {
			clickElementJS(actionButton);
			waitForInvisibility(loaderIcon);
			Actions actions = new Actions(driver);
			actions.moveToElement(emailReminderMenu).perform();
			actions.moveToElement(serviceTeamMenu).perform();
			actions.moveToElement(serviceTeamMail).perform();
			clickElement(serviceTeamMail);
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(errorPopupTitle)) {
				clickElement(errorPopupCloseButton);
			}
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in emailReminderAction: " + e.getMessage());
			throw e;
		}
	}

	public String setNotAppplicableAction() {
		String popupConfirmation = "";
		try {
			clickElementJS(actionButton);
			clickElementJS(setNotApplicableMenu);
			popupConfirmation = confirmationPopup.getText();
			LoggerManager.info("Confirmation popup displayed with message: " + popupConfirmation);
			clickElement(noConfirmationPopup);
			waitForInvisibility(loaderIcon);
		} catch (Exception e) {
			LoggerManager.error("Exception in setNotAppplicableAction: " + e.getMessage());
			throw e;
		}
		return popupConfirmation;
	}

	public String documentsAdding() {
		String popupManageDocument = "";
		try {
			scrollToElement(attachmentIcon);
			clickElementJS(attachmentIcon);
			popupManageDocument = manageDocumentPopup.getText();
			clickElementJS(communityDocumentButton);
			if (communityDocumentTree.isDisplayed()) {
				clickElementJS(communityDocumentTree);
				if (communityDocumentCheckList.isDisplayed()) {
					clickElementJS(communityDocumentCheckList);
					clickElementJS(attachCommunityDocumentButton);
				} else {
					clickElementJS(closeIcon);
				}
			} else {
				waitForInvisibility(loaderIcon);
				clickElementJS(closeManageDocumentbutton);
			}
		} catch (Exception e) {
			LoggerManager.error("Exception in documentsAdding: " + e.getMessage());
			throw e;
		}
		return popupManageDocument;
	}

	public boolean emailLinking() {
		try {
			scrollToElement(emailEnvelopIcon);
			clickElementJS(emailEnvelopIcon);
			waitForInvisibility(loaderIcon);
			clickElementJS(linkEmailButton);
			clickElementJS(viewCloseIcon);
			clickElementJS(emailCloseIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in emailLinking: " + e.getMessage());
			throw e;
		}
	}

	public boolean logHistory() {
		try {
			waitForInvisibility(loaderIcon);
			scrollToElement(logIcon);
			clickElementJS(logIcon);
			clickElementJS(logCloseIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in logHistory: " + e.getMessage());
			throw e;
		}
	}

	public boolean addingNotes() {
		try {
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(notesIconWithCheckMark)) {
				clickElementJS(notesIconWithCheckMark);
			} else {
				clickElementJS(notesIconWithUncheckMark);
			}
			clickElementJS(notesTextArea);
			notesTextArea.sendKeys("Test the Notes");
			clickElementJS(saveNotesButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Exception in addingNotes: " + e.getMessage());
			throw e;
		}
	}
}
