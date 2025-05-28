package com.ciranet.community.dashboard.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.quicksearch.QuickSearch;
import com.ciranet.utilities.LoggerManager;

public class CommunityMetricsPage extends BasePage {

	public CommunityMetricsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@class='dx-button-content']//i[@class='dx-icon fas fa-map-marker-alt']")
	WebElement communitySearchIcon;

	@FindBy(xpath = "//input[@role='textbox']")
	WebElement searchCommunityTextBox;

	@FindBy(xpath = "//div[@class='dx-button-content']//i[@class='dx-icon fas fa-search']")
	WebElement searchIcon;

	@FindBy(xpath = "//a[@class='cc-hyperlink dx-theme-accent-as-text-color cc-hyperlink-hover']//span[contains(text(),'Herff Ranch')]")
	WebElement herffRanchCommunity;

	@FindBy(xpath = "//h4[@class='popup-title-text']")
	WebElement communityAlert;

	@FindBy(xpath = "//i[@class='dx-icon fas fa-times']")
	WebElement communityAlertCloseIcon;

	@FindBy(xpath = "//h3[@class='tile-header page-header']//span[normalize-space()='Community Metrics']")
	WebElement communityMetricsNav;

	@FindBy(xpath = "//dx-box[@id='tile-content-1-community-metrics-widget']//span[@title='Toggle Fullscreen']")
	WebElement toggleFullscreen;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//span[normalize-space()='Lawsuits']")
	WebElement lawsuitsLink;

	@FindBy(xpath = "//div[contains(text(),'Add Lawsuit')]")
	WebElement addLawsuitsPopupTitle;

	@FindBy(xpath = "//div[contains(text(),'Add New Lawsuit')]")
	WebElement addLawsuitButton;

	@FindBy(xpath = "//div[@class='dx-texteditor-input-container']//input[@name='causeNumber']")
	WebElement causeNumberTextBox;

	@FindBy(xpath = "//div[@class='dx-texteditor-input-container']//input[@name='causeTitle']")
	WebElement causeTitleTextBox;

	@FindBy(xpath = "//div[@class='dx-texteditor-input-container']//textarea[@name='description']")
	WebElement descriptionTextBox;

	@FindBy(xpath = "//div[@class='dx-template-wrapper dx-button-content']//i[@class='fas fa-ellipsis-h']")
	WebElement attorney;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Select')])[1]")
	WebElement selectButton;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[31]")
	WebElement lawsuitShowIcon;

	@FindBy(xpath = "//div[contains(text(),'Show All')]")
	WebElement lawsuitShowAll;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container']//input[@type='text'])[75]")
	WebElement unsatisfiedJudgementalAmountTextBox;

	@FindBy(xpath = "(//div[@class='dx-texteditor-input-container']//input[@type='text'])[76]")
	WebElement deactiveDate;

	@FindBy(xpath = "(//div[@class='dx-button-content']//span[contains(text(),'Action')])[48]")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Edit Lawsuit')]")
	WebElement editLawsuitLabel;

	@FindBy(xpath = "//div[@class='dx-button-content']//span[normalize-space()='Close']")
	WebElement closeLawsuit;

	@FindBy(xpath = "//a[@class='cc-hyperlink dx-theme-accent-as-text-color']//span[normalize-space()='Registered ACH Owners']")
	WebElement registeredACHOwners;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper']//*[contains(text(), '&')])[1]")
	WebElement combinedOwner;

	@FindBy(xpath = "//h2[@class='page-header']//span[contains(text(),'Property Owner Details')]")
	WebElement propertyOwnerDetail;

	@FindBy(xpath = "//div[@class='dx-item-content dx-tab-content']//span[normalize-space()='Community Alerts']")
	WebElement propertyCommunityAlert;

	@FindBy(xpath = "//dx-button[@title='Close']//span[@class='dx-button-text'][normalize-space()='Close']")
	WebElement closeACHOwner;

	@FindBy(xpath = "//span[normalize-space()='Open Work']")
	WebElement openWorkTab;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper']//*[contains(text(), 'Email')])[1]")
	WebElement workAreaMenu;

	@FindBy(xpath = "//span[normalize-space()='Compose New']")
	WebElement composeEmailLabel;

	@FindBy(xpath = "(//div//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal'])[2]")
	WebElement resetLayout;

	@FindBy(xpath = "//div[@class='dx-button-content']//i[@class='dx-icon fas fa-save']")
	WebElement lawsuitSaveButton;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement addAlertMessage;

	@FindBy(xpath = "//div//span[normalize-space()='Cancel']")
	WebElement cancelAddLawsuit;

	@FindBy(xpath = "//div//span[normalize-space()='Community Metrics']")
	WebElement pageTitle;

	QuickSearch quickSearch = new QuickSearch(driver);
	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public boolean navigate(String communityName) {

		LoggerManager.info("Starting community search with keyword: {} " + communityName);
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Loader icon is invisible, proceeding with search.");

		quickSearch.searchCommunity(communityName);
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Community search completed for keyword: {} " + communityName);

		try {
			LoggerManager.info("Pressing Escape key to close any popups if present");
			pressEscapeKey();
		} catch (Exception e) {
			LoggerManager.error("Error pressing the Escape key" + e.getMessage());

		}

		try {
			LoggerManager.info("Scrolling to 'Community Metrics' navigation");
			scrollToElement(communityMetricsNav);

			if (communityMetricsNav.isDisplayed()) {
				clickElement(toggleFullscreen);
				waitForInvisibility(loaderIcon);
				boolean isPageTitle = pageTitle.getText().equals("Community Metrics");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));

				return isPageTitle;

			} else {
				LoggerManager.warn("Community Metrics navigation is not visible, search failed");
				return false;
			}

		}

		catch (Exception e) {
			LoggerManager.error("An error occurred during the searching  process" + e.getMessage());
			return false;

		}
	}

	public String addLawsuit() {
		try {
			clickElement(lawsuitsLink);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.body.style.zoom='105%'");
			clickElementJS(addLawsuitButton);
			waitForInvisibility(loaderIcon);
			String popupTitle = addLawsuitsPopupTitle.getText();
			clickElement(causeNumberTextBox);
			causeNumberTextBox.sendKeys("24988");
			clickElement(causeTitleTextBox);
			causeTitleTextBox.sendKeys("Test Cause Title @269449");
			clickElement(descriptionTextBox);
			descriptionTextBox.sendKeys("Test Descriptions 4411");
			clickElement(attorney);
			clickElement(selectButton);
			clickElement(unsatisfiedJudgementalAmountTextBox);
			unsatisfiedJudgementalAmountTextBox.sendKeys("10");
			scrollToElement(deactiveDate);
			clickElement(deactiveDate);
			waitForInvisibility(loaderIcon);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String currentDate = LocalDate.now().format(formatter);
			deactiveDate.sendKeys(currentDate);
			deactiveDate.sendKeys(Keys.ENTER);
			scrollToElement(lawsuitSaveButton);
			clickElementJS(lawsuitSaveButton);
			
			if (addAlertMessage.isDisplayed()) {
				waitForInvisibility(loaderIcon);
				clickElementJS(cancelAddLawsuit);
			}
			return popupTitle;
		} catch (Exception e) {
			LoggerManager.error("Error in addLawsuit: " + e.getMessage());
			throw e;
		}
	}

	public String editLawsuit() {
		try {
			clickElementJS(actionButton);
			String labelEditLawsuit = editLawsuitLabel.getText();

			if (descriptionTextBox.getAttribute("value").isEmpty()) {
				descriptionTextBox.sendKeys("Edit the test description");
			}
			clickElementJS(saveButton);
			waitForInvisibility(loaderIcon);
			clickElement(closeLawsuit);
			return labelEditLawsuit;
		} catch (Exception e) {
			LoggerManager.error("Error in editLawsuit: " + e.getMessage());
			throw e;
		}
	}

	public String registeredACHOwners() {
		try {
			clickElement(registeredACHOwners);
			clickElementJS(combinedOwner);
			waitForInvisibility(loaderIcon);
			ArrayList ownerDetails = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) ownerDetails.get(2));

			if (isElementDisplayed(propertyCommunityAlert)) {
				clickElement(communityAlertCloseIcon);
			}
			waitForInvisibility(loaderIcon);
			String ownerDetail = propertyOwnerDetail.getText();
			driver.close();
			ArrayList achOwnerDetails = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) achOwnerDetails.get(1));
			clickElementJS(closeACHOwner);
			return ownerDetail;
		} catch (Exception e) {
			LoggerManager.error("An unexpected error occurred:" + e.getMessage());
			return "Error: Unexpected error.";
		}
	}

	public boolean tabSwitching() {
		try {
			clickElement(openWorkTab);
			return true;
		} catch (Exception e) {
			LoggerManager.error("An unexpected error occurred during tab switching:" + e.getMessage());
			return false;
		}
	}

	public boolean workArea() {
		try {
			clickElement(resetLayout);
			clickElement(workAreaMenu);
			waitForInvisibility(loaderIcon);
			return true;
		} catch (Exception e) {
			LoggerManager.error("An unexpected error occurred during work area operation:" + e.getMessage());
			return false;
		}
	}
}
