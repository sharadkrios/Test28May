package com.ciranet.myworkqueue.communitymanagement.pages;

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
import com.ciranet.utilities.LoggerManager;

public class BoardApprovalsPage extends BasePage {
	// Initializing the Page Objects:
	public BoardApprovalsPage(WebDriver driver) {
		super(driver);
	}

	// Initializing the Page Objects
	@FindBy(xpath = "//div//span[normalize-space()='Board Approvals']")
	WebElement boardApprovalsSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-normal dx-button-has-icon' and @title='Collapse All']")
	WebElement collapseIcon;

	@FindBy(xpath = "//div[@class='dx-widget dx-button dx-button-mode-contained dx-button-normal dx-button-has-icon' and @title='Expand All']")
	WebElement expandIcon;

	@FindBy(xpath = "//div[@class='dx-item-content dx-toolbar-item-content']//div[@title='Column Chooser']")
	WebElement columnChooser;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeColChooser;

	@FindBy(xpath = "//div[contains(text(),'Column Chooser')]")
	WebElement colChooserLabel;

	@FindBy(xpath = "//dx-button[@title='Community Search']")
	WebElement communityIcon;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-menu']")
	WebElement toolbarMenu;

	@FindBy(xpath = "//div[@class='dx-button-content']//i[@class='dx-icon dx-icon-close']")
	WebElement columnIcon;

	@FindBy(xpath = "//div[@class='dx-item-content dx-tab-content']//span[text()='Closed']")
	WebElement closedTab;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-tab-content'])[1]")
	WebElement openTab;

	@FindBy(xpath = "//dx-button[@title='Hide Menu']//i[@class='dx-icon dx-icon-menu']")
	WebElement hamburger;

	@FindBy(xpath = "//div[@class='dx-radiobutton-icon']")
	WebElement allTaskRadioButton;

	@FindBy(xpath = "//dx-button[@title='Refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "//dx-button[@title='View']")
	WebElement viewButton;

	@FindBy(xpath = "//div[@aria-label='cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayout;

	@FindBy(xpath = "//div[@class='dx-group-panel-item dx-datagrid-action dx-datagrid-drag-action'][normalize-space()='Process']")
	WebElement processGridColumn;

	@FindBy(xpath = "//div[@class='dx-group-panel-item dx-datagrid-action dx-datagrid-drag-action'][normalize-space()='ID']")
	WebElement idGridColumn;

	@FindBy(xpath = "(//td[@class='dx-command-expand dx-datagrid-group-space dx-cell-focus-disabled'])[1]")
	WebElement dropDestinationColumn;

	@FindBy(xpath = "//dx-button[@title='Cancel']//span[normalize-space()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "(//div[contains(@class, 'cc-action-button')]//dx-button[@hint='Action' and @text='Action' and not(contains(@class, 'dx-state-invisible'))])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//dx-button[@aria-label='Approve']//span[normalize-space()='Approve']")
	WebElement approveButton;

	@FindBy(xpath = "//div[contains(@class, 'dx-loadpanel-message') and contains(text(), 'successful')]")
	WebElement approveSuccessfullyMessage;

	@FindBy(xpath = "//div[@class='dx-loadpanel-indicator dx-loadindicator dx-widget']//div[@class='dx-loadindicator-icon']")
	WebElement boardApprovalLoaderIcon;

	@FindBy(xpath = "//dx-button[@title='Approve with Stipulation']")
	WebElement approveWithStipulationButton;

	@FindBy(xpath = "//textarea[@role='textbox']")
	WebElement boardApprovalNoteTextBox;

	@FindBy(xpath = "//div//span[normalize-space()='Ok']")
	WebElement okButton;

	@FindBy(xpath = "(//input[@aria-label='Filter cell'])[2]")
	WebElement processFilterText;

	@FindBy(xpath = "//div//span[normalize-space()='In Review']")
	WebElement reviewButton;

	@FindBy(xpath = "//div//span[normalize-space()='Deny / Request Additional Information']")
	WebElement denyRequestAdditionalInformationButton;

	@FindBy(xpath = "//div[contains(text(),'Deny / Request Additional Information')]")
	WebElement denyPopupTitle;

	@FindBy(xpath = "//div[contains(text(),'Approved with Stipulation')]")
	WebElement approveStipulationPopupTitle;

	@FindBy(xpath = "//div[@class='dx-overlay-wrapper dx-loadpanel-wrapper dx-overlay-modal dx-overlay-shader']")
	WebElement reviewSuccessfulMessage;

	@FindBy(xpath = "(//div//i[@title='Attachments'])[1]")
	WebElement attachmentIcon;

	@FindBy(xpath = "//div//span[normalize-space()='Close']")
	WebElement closeButton;

	@FindBy(xpath = "(//div//i[@title='Logs'])[1]")
	WebElement logIcon;

	@FindBy(xpath = "(//i[@title='View AR Collections Details'])[1]")
	WebElement workflowDetailsIcon;

	@FindBy(xpath = "//div//span[normalize-space()='Close']")
	WebElement errorMessageCloseButton;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-popup-title dx-has-close-button']")
	WebElement errorMessagePopupTitle;

	@FindBy(xpath = "(//div//span[normalize-space()='Close'])[1]")
	WebElement workflowCloseButton;

	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//div//span[normalize-space()='Board Approvals']"),
					"Board Approvals");
			LoggerManager.info("Navigated to 'Board Approvals'");
			LoggerManager.info("Scrolling to Board Approvals navigation");
			scrollToElement(boardApprovalsSideNav);

			if (isElementDisplayed(boardApprovalsSideNav)) {
				LoggerManager.info("Board Approvals is visible, clicking on it");
				clickElementJS(boardApprovalsSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed Board Approvals");

				boolean isPageTitle = pageTitle.getText().equals("Board Approvals");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Board Approvals is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}

	}

	public boolean viewBoardApprovalInformation() {
		try {
			clickElement(hamburger);
			waitForElementToBeVisible(allTaskRadioButton);
			clickElement(allTaskRadioButton);
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(refreshButton);
			clickElement(refreshButton);
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(resetLayout);
			clickElement(resetLayout);
			waitForInvisibility(loaderIcon);
			Actions action = new Actions(driver);
			action.dragAndDrop(processGridColumn, dropDestinationColumn).build().perform();
			action.dragAndDrop(idGridColumn, dropDestinationColumn).build().perform();
			waitForInvisibility(loaderIcon);
			if (viewButton.isDisplayed()) {
				waitForElementToBeVisible(viewButton);
				clickElement(viewButton);
				waitForElementToBeVisible(cancelButton);
				clickElement(cancelButton);
			} else {
				LoggerManager.info("View button is not visible");
			}
		} catch (Exception e) {
			LoggerManager.error("Error in viewBoardApprovalInformation: " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean approve() {
		try {
			waitForInvisibility(loaderIcon);
			clickElementJS(actionButton);
			waitForInvisibility(loaderIcon);
			if (isElementVisible(By.xpath("//dx-button[@aria-label='Approve']//span[normalize-space()='Approve']"))) {
				clickElementJS(approveButton);
				waitForInvisibility(loaderIcon);
			} else {
				clickElementJS(cancelButton);
				LoggerManager.info("Approve button is not visible");
			}
		} catch (Exception e) {
			LoggerManager.error("Error in approve: " + e.getMessage());
		}
		return true;
	}

	public boolean approveWithStipulation() {
		try {
			waitForElementToBeVisible(processFilterText);
			clickElementJS(processFilterText);
			enterText(processFilterText, "Collections");
			scrollToElement(actionButton);
			clickElement(actionButton);
			if (isElementVisible(By.xpath("//dx-button[@title='Approve with Stipulation']"))) {
				clickElementJS(approveWithStipulationButton);
				clickElementJS(boardApprovalNoteTextBox);
				enterText(boardApprovalNoteTextBox, "Test the board approval text");
				clickElementJS(okButton);
				waitForInvisibility(loaderIcon);

			} else {
				clickElementJS(cancelButton);
				LoggerManager.info("Approve With Stipulation button is not visible");
			}
		} catch (Exception e) {
			LoggerManager.error("Error in approveWithStipulation: " + e.getMessage());
		}
		return true;
	}

	public boolean review() {
		try {
			scrollToElement(actionButton);
			clickElement(actionButton);
			waitForElementToBeVisible(reviewButton);
			if (isElementVisible(By.xpath("//div//span[normalize-space()='In Review']"))) {
				clickElement(reviewButton);
				waitForInvisibility(loaderIcon);
			} else {
				clickElementJS(cancelButton);
				LoggerManager.info("Review button is not visible");
			}
		} catch (Exception e) {
			LoggerManager.error("Error in review: " + e.getMessage());
		}
		return true;
	}

	public boolean denyRequestAdditionalInformation() {
		try {
			scrollToElement(actionButton);
			clickElement(actionButton);
			if (isElementVisible(By.xpath("//div//span[normalize-space()='Deny / Request Additional Information']"))) {
				clickElementJS(denyRequestAdditionalInformationButton);
				clickElementJS(boardApprovalNoteTextBox);
				enterText(boardApprovalNoteTextBox, "Test the board approval text");
				clickElementJS(okButton);
				waitForInvisibility(loaderIcon);

			} else {
				clickElementJS(cancelButton);
				LoggerManager.info("Deny Request button is not visible");
			}
		} catch (Exception e) {
			LoggerManager.error("Error in denyRequestAdditionalInformation: " + e.getMessage());
		}
		return true;
	}

	public boolean documents() {
		try {
			clickElementJS(attachmentIcon);
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(closeButton);
			clickElementJS(closeButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in documents: " + e.getMessage());
			return false;
		}
	}

	public boolean logs() {
		try {
			clickElementJS(logIcon);
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(closeButton);
			clickElementJS(closeButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in logs: " + e.getMessage());
			return false;
		}
	}

	public boolean workflowDetails() {
		try {
			scrollToElement(workflowDetailsIcon);
			clickElementJS(workflowDetailsIcon);
			waitForInvisibility(loaderIcon);
			clickElementJS(cancelButton);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in workflowDetails: " + e.getMessage());
			return false;
		}
	}

	public boolean toolBarFullScreen() {
		try {
			waitForElementToBeVisible(fullScreenIcon);
			clickElement(fullScreenIcon);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in toolBarFullScreen: " + e.getMessage());
			return false;
		}
	}

	public boolean toolBarNormalScreen() {
		try {
			waitForElementToBeVisible(normalScreenIcon);
			clickElementJS(normalScreenIcon);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in toolBarNormalScreen: " + e.getMessage());
			return false;
		}
	}

	public boolean switchTab() {
		try {
			waitForElementToBeVisible(closedTab);
			clickElementJS(closedTab);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("Error in switchTab: " + e.getMessage());
			return false;
		}
	}

	public String columnChooser() {
		try {
			clickElementJS(columnChooser);
			waitForElementToBeVisible(colChooserLabel);
			String colChooserTitle = colChooserLabel.getText();
			clickElement(closeColChooser);
			return colChooserTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in columnChooser: " + e.getMessage());
			return null;
		}
	}	
}
