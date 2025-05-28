package com.ciranet.corporatecirabooks.accountsreceivable.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class NewARPaymentPage extends BasePage
{
	public NewARPaymentPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='header-text']//span[contains(text(),'CiraBooks Corporate')]")
	private WebElement corporateCiraBooks;

	@FindBy(xpath="//div[@class='header-text']//span[contains(text(),'Accounts Receivable')]") 
	private WebElement  accountsReceivable;

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'New AR Payment')]")
	private WebElement  newARPaymentSideNav;

	@FindBy(xpath = "//h2[contains(text(),'New AR Payment')]")
	public WebElement  newARPaymentPageTitle;

	@FindBy(xpath = "//input[@role='combobox']")
	public WebElement managementCompanyDropdown;

	@FindBy(xpath = "(//div[contains(@class,'dx-item-content dx-list-item-content')])[1]")
	public WebElement managementCompanyValue;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	public WebElement customerDropdown;

	@FindBy(xpath = "(//td[@aria-describedby='dx-col-1'])[2]")
	public WebElement customerDropdownValue;

	@FindBy(xpath = "//input[@role='spinbutton']")
	public WebElement newARPaymentAmount;

	@FindBy(xpath = "//dx-text-box[@placeholder='(e.g. Check Number)']//input[@role='textbox']")
	public WebElement NewARPaymentDescription;

	@FindBy(xpath = "//textarea[@role='textbox']")
	public WebElement newARPaymentDescription;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	public WebElement saveButton;

	@FindBy(xpath = "(//div[@class='dx-button-content'])[24]")
	public WebElement noButton;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable dx-popup-inherit-height']")
	public WebElement confirmationPopup;

	@FindBy(xpath="//div[contains(@class, 'dx-loadindicator-icon')]")
	WebElement loaderIcon;
	
	@FindBy(xpath="(//input[contains(@autocomplete,'off')])[12]")
	WebElement glAccount;

	@FindBy(xpath="(//input[contains(@class,'dx-texteditor-input')])[13]")
	WebElement departmentDropdown;
	
	@FindBy(xpath="(//div[contains(@class,'dx-item-content dx-list-item-content')])[7]")
	WebElement departmentDropdownValue;
					
	Navigation navigationSearch = new Navigation(driver);
	
	public boolean navigate()  
	{
	    try {
	        // Log navigation action
	        LoggerManager.info("Navigating to 'New AR Payment' page.");
	        
	        // Navigate to the New AR Payment menu
	        navigationSearch.navigateBySideNavigation(By.xpath(
	                "//span[normalize-space()='New AR Payment']"), "New AR Payment");

	        // Scroll to the "New AR Payment" side navigation and click it
	        LoggerManager.info("Scrolling to 'New AR Payment' navigation.");
	        waitForElementToBeClickable(newARPaymentSideNav);
	        scrollToElement(newARPaymentSideNav);
	        clickElementJS(newARPaymentSideNav);
	        
	        // Wait for the loader icon to disappear
	        LoggerManager.info("Waiting for loader icon to disappear.");
	        waitForInvisibility(loaderIcon);
	        
	        // Check if the label text matches
	        boolean isPageTitle = newARPaymentPageTitle.getText().equals("New AR Payment");
	        LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
	        
	        return isPageTitle;
	        
	    } catch (Exception e) {
	        // Log the error message
	        LoggerManager.error("Error occurred in 'navigate' method: " + e.getMessage() + e);
	        
	        // Rethrow the exception after logging
	        return false;
	    }
	}


	public boolean addNewARPayment()  
	{
	    try {
	    	LoggerManager.info("Starting AR creation process...");

	        // Interacting with the company dropdown
	    	LoggerManager.info("Select Management Company from dropdown.");
	        clickElement(managementCompanyDropdown);
	        clickElement(managementCompanyValue);

	        // Selecting customer
	        LoggerManager.info("Selecting Customer from dropdown.");
	        clickElement(customerDropdown);
	        clickElement(customerDropdownValue);

	        // Entering payment amount
	        LoggerManager.info("Entering payment amount: 10");
	        clickElement(newARPaymentAmount);
	        enterText(newARPaymentAmount, "10");

	        // Entering payment description
	        LoggerManager.info("Entering payment description: 123");
	        clickElement(newARPaymentDescription);
	        enterText(newARPaymentDescription, "123");
	        waitForInvisibility(loaderIcon);

	        // GL Account selection
	        LoggerManager.info("Selecting GL Account.");
	        waitForElementToBeClickable(glAccount);
	        clickElement(glAccount);
	        glAccount.clear();
	        glAccount.click();
	        glAccount.sendKeys("10700-00;-Undeposited Funds - RealManage: Deposits in Transit");

	        LoggerManager.info("Waiting for GL Account option to be clickable.");
	        By glAccountDropdownValue = By.xpath("//td[contains(text(),'Undeposited Funds - RealManage: Deposits in Transi')]");
	        waitForElementToBeClickable(driver.findElement(glAccountDropdownValue));
	        scrollToElement(driver.findElement(glAccountDropdownValue));

	        LoggerManager.info("Selecting GL Account option.");
	        driver.findElement(glAccountDropdownValue).click();

	        // Entering AR description
	        LoggerManager.info("Entering AR Payment description.");
	        enterText(newARPaymentDescription, "AR Payment Description");

	        // Selecting department
	        LoggerManager.info("Selecting department.");
	        waitForElementToBeClickable(departmentDropdown);
	        clickElement(departmentDropdown);
	        waitForElementToBeClickable(departmentDropdownValue);
	        clickElement(departmentDropdownValue);

	        // Save the AR
	        LoggerManager.info("Saving New AR Payment Entry");
	        scrollToElement(saveButton);
	        clickElement(saveButton);
	        waitForInvisibility(loaderIcon);

	        // Check for confirmation popup
	        if (isElementDisplayed(confirmationPopup)) {
	        	LoggerManager.info("Confirmation popup is displayed and clicking on 'No' button.");
	            waitForInvisibility(loaderIcon);
	            clickElement(noButton);
	            waitForInvisibility(loaderIcon);
	            LoggerManager.info("AR payment added successfully.");
	            return true;
	        } else {
	        	LoggerManager.warn("Confirmation popup not displayed. AR creation may have failed.");
	            return false;
	        }

	    } catch (Exception e) {
	    	LoggerManager.error("Error occurred during AR Payment creation: " + e.getMessage() +  e);
	        return false;
	    }
	}
}

