package com.ciranet.administration.tools.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class EmployeeManagementPage extends BasePage {
	public EmployeeManagementPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@title='Administration']")
	WebElement administrationSideNav;

	@FindBy(xpath = "//div[@title='Tools']//div[@class='header-text']")
	WebElement toolsSideNav;

	@FindBy(xpath = "//span[normalize-space()='Employee Management']")
	WebElement employeeManagementSideNav;

	@FindBy(xpath = "//h2[text()=' Employee Management ']")
	WebElement pageTitle;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[1]")
	WebElement userStatusDropdown;

	@FindBy(xpath = "(//div[contains(text(),'Active')])[3]")
	WebElement userStatusDropdownActiveValue;
	
	@FindBy(xpath = "//div[contains(text(),'Inactive')]")
	WebElement userStatusDropdownInactiveValue;
	
	@FindBy(xpath = "(//i[@ng-reflect-ng-class='fas fa-2x fa-check'])[1]")
	WebElement checkmarkIcon;
	
	@FindBy(xpath = "//i[@class='dx-icon dx-icon-refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color']//span[contains(text(),'Olga Scott')])[1]")
	WebElement managerColumn;

	@FindBy(xpath = "(//input[@aria-label='Filter cell'])[5]")
	WebElement managerSearch;

	@FindBy(xpath = "//div[contains(text(),'Olga Scott, Client Services Manager')]")
	WebElement biographyDetails;

	@FindBy(xpath = "(//input[@aria-label='Filter cell'])[1]")
	WebElement nameColumnSearch;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeButton;

	@FindBy(xpath = "//span[normalize-space()='Action']")
	WebElement actionButton;

	@FindBy(xpath = "//div[@class='menu-text']")
	WebElement editMenu;

	@FindBy(xpath = "//div[@class='dx-switch-on']")
	WebElement overrideOnToggle;

	@FindBy(xpath = "//div[@class='dx-switch-off']")
	WebElement overrideOffToggle;

	@FindBy(xpath = "(//input[@role='textbox'])[12]")
	WebElement titleTextbox;

	@FindBy(xpath = "//dx-button[@title='Save']//div[@class='dx-button-content']")
	WebElement saveButton;

	@FindBy(xpath = "//div[contains(text(),'Edit Employee Akshay Yeole')]")
	WebElement employeeDetails;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate()  
	{
	    try {
	        LoggerManager.info("Navigating to Employee Management");
	       
	        navigationSearch.navigateBySideNavigation(By.xpath(
	                "//span[normalize-space()='Employee Management']"), "Employee Management");

	        LoggerManager.info("Scrolling to 'Employee Management' navigation.");
	        waitForElementToBeClickable(employeeManagementSideNav);
	        scrollToElement(employeeManagementSideNav);
	        clickElementJS(employeeManagementSideNav);
	        
	        LoggerManager.info("Waiting for loader icon to disappear.");
	        waitForInvisibility(loaderIcon);
	        
	        boolean isPageTitle = pageTitle.getText().equals("Employee Management");
	        LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
	        
	        return isPageTitle;
	        
	    } catch (Exception e) {
	    	
	        LoggerManager.error("Error occurred in 'navigate' method: " + e.getMessage() + e);
	        
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
			LoggerManager.error("Error in toolBarFullScreen method: " + e.getMessage());
			throw e;
		}
	}

	public boolean userStatus() {
		try {
			clickElementJS(userStatusDropdown);
			clickElement(userStatusDropdownInactiveValue);
			clickElementJS(refreshButton);
			waitForInvisibility(loaderIcon);
			clickElementJS(userStatusDropdown);
			clickElement(userStatusDropdownActiveValue);
			clickElementJS(refreshButton);
			waitForInvisibility(loaderIcon);
			return (checkmarkIcon.isDisplayed());
		} catch (Exception e) {
			LoggerManager.error("Error in userStatus method: " + e.getMessage());
			throw e;
		}
	}

	public String biography() {
		try {
			clickElementJS(managerSearch);
			enterText(managerSearch, "Olga Scott");
			waitForInvisibility(loaderIcon);
			clickElementJS(managerColumn);
			waitForInvisibility(loaderIcon);
			String detailsBiography = biographyDetails.getText();
			clickElementJS(closeButton);
			managerSearch.clear();
			return detailsBiography;
		} catch (Exception e) {
			LoggerManager.error("Error in biography method: " + e.getMessage());
			throw e;
		}
	}

	public String editEmployee() {
		try {
			clickElementJS(nameColumnSearch);
			enterText(nameColumnSearch, "Akshay");
			waitForInvisibility(loaderIcon);
			clickElementJS(actionButton);
			clickElementJS(editMenu);
			
			if (isElementDisplayed(overrideOffToggle)) {
				clickElementJS(overrideOffToggle);	
			}
			else{
				LoggerManager.info("Override On Toggle is enabled");
			};
			
			waitForInvisibility(loaderIcon);
			String detailsEmployee = employeeDetails.getText();
			titleTextbox.clear();
			enterText(titleTextbox, "Developer");
			clickElementJS(saveButton);
			nameColumnSearch.clear();
			return detailsEmployee;
		} catch (Exception e) {
			LoggerManager.error("Error in editEmployee method: " + e.getMessage());
			throw e;
		}
	}
}
