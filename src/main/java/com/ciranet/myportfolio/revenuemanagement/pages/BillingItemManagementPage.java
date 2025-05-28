package com.ciranet.myportfolio.revenuemanagement.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class BillingItemManagementPage extends BasePage 
{
		public BillingItemManagementPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),' Billing Item Management ')]")
	WebElement  billingItemManagementSideNav ;

	@FindBy(xpath="//div[contains(@class, 'dx-loadindicator-icon')]")
	WebElement loaderIcon;
	
	@FindBy(xpath="//h2[contains(text(), 'Billing Item Management')]")
	WebElement pageTitle;
	
	@FindBy(xpath = "//input[@role='combobox']")
	WebElement entityDropdown;

	@FindBy(xpath = "(//div[contains(@class,'dx-item-content dx-list-item-content')])[1]")
	WebElement entityValue;
	
	@FindBy(xpath = "(//input[contains(@class,'dx-texteditor-input')])[3]")
	WebElement fromDate;
	
	@FindBy(xpath = "(//input[contains(@class,'dx-texteditor-input')])[4]")
	WebElement toDate;
	
	@FindBy(xpath = "//span[normalize-space()='Refresh']")
	WebElement refreshButton;
	
	@FindBy(xpath = "//span[normalize-space()='Add']")
	WebElement addButton;

	@FindBy(xpath="//dx-drop-down-box[@class='dx-show-invalid-badge dx-dropdownbox dx-textbox dx-texteditor dx-dropdowneditor-button-visible dx-editor-outlined dx-widget customer-width dx-texteditor-empty dx-dropdowneditor']//div[@class='dx-dropdowneditor-input-wrapper']//input[@role='textbox']")
	WebElement customerDropdown;
	
	@FindBy(xpath="(//tr[@class='dx-row dx-data-row dx-column-lines'])[1]")
	WebElement customerDropdownValue;
	
	@FindBy(xpath="//input[contains(@id,'billingItem.itemTypeId')]")
	WebElement billingItemType;
	
	@FindBy(xpath="(//div[@class='dx-item-content dx-list-item-content'])[4]")
	WebElement billingItemTypeValue;
	
	@FindBy(xpath = "//input[@autocomplete='off'][contains(@id,'billingItem.transactionDate')]")
	WebElement transactionDate;
	
	@FindBy(xpath = "//input[@autocomplete='off'][contains(@id,'billingItem.quantity')]")
	WebElement billingItemQuantity;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath = "//textarea[contains(@id,'billingItem.description')]")
	WebElement descriptionTextArea;
	
	@FindBy(xpath = "//div[@class='dx-overlay-content dx-toast-success dx-toast-content dx-resizable']")
	WebElement addConfirmationMessage;
	
	
	@FindBy(xpath="//div[@class='dx-overlay-wrapper dx-loadpanel-wrapper dx-overlay-modal dx-overlay-shader']")
	WebElement editConfirmationMessage;
	
	@FindBy(xpath="(//div[@class='dx-dropdowneditor-input-wrapper']//div[@class='dx-dropdowneditor-icon'])[4]")
	WebElement dateColumnFilter;
	
	@FindBy(xpath = "(//div[@class='dx-button-content'][contains(.,'Action')])[1]")
	WebElement actionButton;
	
	@FindBy(xpath = "(//div[@id='menutemplate']/div/div[2])[1]")
	WebElement editMenu;
	
	
	Navigation navigationSearch = new Navigation(driver);

	
	public Boolean navigate()
	{
		try {
			 // Log navigation action
	        LoggerManager.info("Navigating to 'Billing Item Management' page.");
	        
	        // Navigate to the Billing Item Management menu
	        navigationSearch.navigateBySideNavigation(By.xpath(
	                "//span[normalize-space()='Billing Item Management']"), "Billing Item Management");
	        
	        LoggerManager.info("Scrolling to 'Billing Item Management' navigation.");
	        scrollToElement(billingItemManagementSideNav);
	        clickElement(billingItemManagementSideNav);
	        
	        // Wait for the loader icon to disappear
	        LoggerManager.info("Waiting for loader icon to disappear.");
	        waitForInvisibility(loaderIcon);
	        
	        // Check if the label text matches
	        boolean isPageTitle = pageTitle.getText().equals("Billing Item Management");
	        LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
	        
	        return isPageTitle;

		} catch (Exception e) {
	        // Log the error message
	        LoggerManager.error("Error occurred in 'navigate' method: " + e.getMessage() + e);
	        
	        return false;
	    }
	}
	
	public boolean verifyBillingItemManagementDataDisplay()
	{
		try {
			 // Log navigation action
	        LoggerManager.info("Entity Selection.");
	        clickElement(entityDropdown);
	        clickElement(entityValue);
	        waitForInvisibility(loaderIcon);
	        waitForElementToBeClickable(fromDate);
	        waitForElementToBeClickable(toDate);
	        waitForElementToBeClickable(refreshButton);
	        scrollToElement(refreshButton);
	        clickElement(refreshButton);
	        waitForInvisibility(driver.findElement(By.xpath("//div[@class='dx-loadpanel-indicator dx-loadindicator dx-widget']//div[@class='dx-loadindicator-icon']")));
	          
	        if (isElementDisplayed(driver.findElement(By.xpath("//div[@class='cc-page-info dx-template-wrapper dx-item-content dx-toolbar-item-content']")))){
	        	return true;
	        } else 
	        	return false;
	        
		} catch (Exception e) {
	        // Log the error message
	        LoggerManager.error("Error occurred in 'verifyBillingItemManagementDataDisplay' method: " + e.getMessage() + e);
	        return false;
		}
	}
	
	
	public Boolean addBillingItemQuantity()
	{
		try {
			 // Log navigation action
	        LoggerManager.info("'Add Billing Item Quantity'.");
	        
	        // Click Add button to add Billing Item Quantity
	        waitForElementToBeClickable(addButton);
	        clickElement(addButton);
	        
	        LoggerManager.info("On the 'Add Billing Item Quantity' popup.");
	        
	        scrollToElement(customerDropdown);
	        clickElement(customerDropdown);
	        
	        waitForElementToBeClickable(customerDropdownValue);
	        clickElement(customerDropdownValue);
	        
	        // Wait for the loader icon to disappear
	        LoggerManager.info("Waiting for loader icon to disappear.");
	        waitForInvisibility(loaderIcon);
	        clickElement(billingItemType);
	        clickElement(billingItemTypeValue);
	        
	        clickElement(transactionDate);
	        
	        waitForInvisibility(loaderIcon);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			String setTransactionDate = LocalDate.now().format(formatter);
			enterText(transactionDate, setTransactionDate);

			transactionDate.sendKeys(Keys.TAB);
			
			waitForInvisibility(loaderIcon);
	        
			enterText(billingItemQuantity, "1");
	        
	        enterText(descriptionTextArea, "Description Text");

	        waitForElementToBeClickable(saveButton);

	        clickElement(saveButton);
	        
	        waitForInvisibility(loaderIcon);
	        
	        waitForElementToBeVisible(addConfirmationMessage);
	        
	        waitForInvisibility(loaderIcon);

	        // Check if the confirmation message is seen
	        boolean isMessageCorrect = isElementDisplayed(addConfirmationMessage);
	        LoggerManager.info("Label text validation: " + (isMessageCorrect ? "Passed" : "Failed"));
	        
	        return isMessageCorrect;
		} catch (Exception e) {
	        // Log the error message
	        LoggerManager.error("Error occurred in 'addBillingItemQuantity' method: " + e.getMessage() + e);
	        
	        return false;
	    }
	}

	public Boolean editBillingItemQuantity()
	{
		try {
			 // Log navigation action
			
	        LoggerManager.info("'Edit Billing Item Quantity'.");
	        
	        waitForInvisibility(loaderIcon);
	        waitForElementToBeClickable(dateColumnFilter);
	        clickElement(dateColumnFilter);
	        
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
			String setTransactionDate = LocalDate.now().minusDays(1).format(formatter);
			
	        String dynamicXPath = String.format("(//td//span[contains(text(),'%s')])[1]", setTransactionDate);
	        WebElement element = driver.findElement(By.xpath(dynamicXPath));
	        
	        clickElement(element);
	        waitForElementToBeVisible(actionButton);
	        
	        clickElement(actionButton);

			waitForElementToBeVisible(editMenu);
	        scrollToElement(editMenu);
	
			clickElementJS(editMenu);
			
			waitForElementToBeClickable(saveButton);
			if (isElementDisplayed(saveButton)) 
			{
				clickElement(saveButton);
				
				return true;
			}
			else
				return false;
			
		} catch (Exception e) {
	        // Log the error message
	        LoggerManager.error("Error occurred in 'editBillingItemQuantity' method: " + e.getMessage() + e);
	        
	        return false;
	    }
	}
	
}
