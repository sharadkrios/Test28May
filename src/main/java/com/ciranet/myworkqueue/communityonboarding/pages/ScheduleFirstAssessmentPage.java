package com.ciranet.myworkqueue.communityonboarding.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ScheduleFirstAssessmentPage extends BasePage {

	@FindBy(xpath = "//div//span[normalize-space()='Schedule First Assessment']")
	private WebElement scheduleFirstAssessmentSideNav;

	@FindBy(xpath = "//h2[text()=' Schedule First Assessment ']")
	private WebElement pageTitle;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[1]")
	private WebElement communityDropdownIcon;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[3]")
	private WebElement communityDropdownValue;

	@FindBy(xpath = "(//dx-check-box//span[@class='dx-checkbox-icon'])[2]")
	private WebElement rateTypeCheckbox;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-input-wrapper']//div[@class='dx-dropdowneditor-icon']")
	private WebElement calendarDropdown;

	@FindBy(xpath = "(//td//span[contains(text(),'5')])[1]")
	private WebElement calendarDropdownValue;

	@FindBy(xpath = "//dx-button[@title='Schedule']//div[@class='dx-button-content']")
	private WebElement scheduleButton;

	@FindBy(xpath = "//div//span[normalize-space()='Reset']")
	private WebElement resetButton;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']")
	private WebElement loaderIcon;

	@FindBy(xpath = "//div//span[normalize-space()='Close']")
	private WebElement errorCloseButton;

	@FindBy(xpath = "//div[contains(text(),'Error')]")
	private WebElement errorPopupTitle;

	Navigation navigationSearch = new Navigation(driver);

	public ScheduleFirstAssessmentPage(WebDriver driver) {
		super(driver);
	}

	public boolean navigateToScheduleFirstAssessment() {
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigate(
					By.xpath("//div//span[normalize-space()='Schedule First Assessment']"),
					"Schedule First Assessment");
			waitForInvisibility(loaderIcon);
			scrollToElement(scheduleFirstAssessmentSideNav);
			if (isElementDisplayed(scheduleFirstAssessmentSideNav)) {
				boolean isPageTitle = "Schedule First Assessment".equals(pageTitle.getText());
				LoggerManager.info("Page title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.info("Schedule First Assessment is not visible");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process: " + e.getMessage());
			return false;
		}
	}
	
	public String resetFirstAssessment() {
		try {
			clickElement(communityDropdownIcon);
			clickElementJS(communityDropdownValue);
			String resetButtonText = resetButton.getText();
			waitForElementToBeClickable(resetButton);
			clickElementJS(resetButton);
			return resetButtonText;
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while reseting the first assessment" + e.getMessage());
			throw e;
		}
	}

	public String scheduleFirstAssessment() {
		try {
			waitForElementToBeVisible(communityDropdownIcon);
			clickElement(communityDropdownIcon);
			clickElementJS(communityDropdownValue);
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(rateTypeCheckbox);
			clickElementJS(rateTypeCheckbox);
			clickElementJS(calendarDropdown);
			clickElementJS(calendarDropdownValue);
			String scheduleButtonText = scheduleButton.getText();
			clickElementJS(scheduleButton);
			waitForInvisibility(loaderIcon);
			if (errorPopupTitle.isDisplayed()) {
				clickElementJS(errorCloseButton);
			}
			return scheduleButtonText;
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while scheduling the first assessment" + e.getMessage());
			throw e;
		}
	}
}

