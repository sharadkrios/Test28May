package com.ciranet.configurations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ProcessTrackerPage extends BasePage {
	public ProcessTrackerPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div//span[normalize-space()='Configurations']")
	WebElement configurationsSideNav;

	@FindBy(xpath = "//div[@title='Process Tracker Configurations']")
	WebElement processTrackerSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "(//div[@class='dx-texteditor-buttons-container'])[2]")
	WebElement configurationDropdown;

	@FindBy(xpath = "//div[@class='dx-item dx-menu-item']//span[contains(text(),'Community Auto Close & Report Generation')]")
	WebElement communityAutoCloseReportGeneration;

	@FindBy(xpath = "//div[@class='dx-item dx-menu-item']//span[contains(text(),'Financial Package Configuration')]")
	WebElement financialPackageConfiguration;

	@FindBy(xpath = "//div[@class='dx-item dx-menu-item']//span[contains(text(),'Process Tracker Configuration')]")
	WebElement processTrackerConfiguration;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-input-wrapper'])[2]")
	WebElement contextDropdown;

	@FindBy(xpath = "(//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement contextValue;

	@FindBy(xpath = "//div[@class='dx-item dx-toolbar-item dx-toolbar-button']//strong[contains(text(),'Community Auto Close & Report Generation - Global')]")
	WebElement pageTitleCommunityAutoCloseReportGeneration;

	@FindBy(xpath = "//div[@class='dx-item dx-toolbar-item dx-toolbar-button']//strong[contains(text(),'Financial Package Configuration - Global')]")
	WebElement pageTitleFinancialPackageConfiguration;

	@FindBy(xpath = "//div[@class='dx-item dx-toolbar-item dx-toolbar-button']//strong[contains(text(),'Process Tracker Configuration - Global')]")
	WebElement pageTitleProcessTrackerConfiguration;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//div//span[normalize-space()='Yes']")
	WebElement confirmationYesButton;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(By.xpath("//div//span[normalize-space()='Configurations']"),
					"Configurations");
			waitForInvisibility(loaderIcon);
			clickElementJS(configurationsSideNav);
			clickElementJS(processTrackerSideNav);
			waitForInvisibility(loaderIcon);

			LoggerManager.info("Successfully searched for the navigation and accessed  Process Tracker");
			
			boolean isPageTitle = pageTitle.getText().equals("Process Tracker Configurations");
			LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
			waitForInvisibility(loaderIcon);
			return isPageTitle;
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}
	}

	public String communityAutoCloseReportGeneration() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(communityAutoCloseReportGeneration);
			waitForInvisibility(loaderIcon);
			clickElement(contextDropdown);
			Actions action = new Actions(driver);
			action.moveToElement(contextValue).click().build().perform();
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(pageTitleCommunityAutoCloseReportGeneration);
			return pageTitleCommunityAutoCloseReportGeneration.getText();
		} catch (Exception e) {
			LoggerManager.error("An error occurred in communityAutoCloseReportGeneration method." + e.getMessage());
			throw e;
		}
	}

	public String financialPackageConfiguration() {
		try {
			clickElementJS(configurationDropdown);
			clickElement(financialPackageConfiguration);
			clickElementJS(confirmationYesButton);
			waitForInvisibility(loaderIcon);
			clickElement(contextDropdown);
			Actions action = new Actions(driver);
			action.moveToElement(contextValue).click().build().perform();
			waitForElementToBeVisible(pageTitleFinancialPackageConfiguration);
			return pageTitleFinancialPackageConfiguration.getText();
		} catch (Exception e) {
			LoggerManager.error("An error occurred in financialPackageConfiguration method." + e.getMessage());
			throw e;
		}
	}

	public String processTrackerConfiguration() {
		try {
			clickElementJS(configurationDropdown);
			clickElement(processTrackerConfiguration);
			waitForInvisibility(loaderIcon);
			clickElement(contextDropdown);
			Actions action = new Actions(driver);
			action.moveToElement(contextValue).click().build().perform();
			waitForElementToBeVisible(pageTitleProcessTrackerConfiguration);
			return pageTitleProcessTrackerConfiguration.getText();
		} catch (Exception e) {
			LoggerManager.error("An error occurred in processTrackerConfiguration method." + e.getMessage());
			throw e;
		}
	}
}

