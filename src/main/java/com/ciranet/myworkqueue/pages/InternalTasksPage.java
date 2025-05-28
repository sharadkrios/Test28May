package com.ciranet.myworkqueue.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class InternalTasksPage extends BasePage
{
	public InternalTasksPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// Initialising of object 	
	@FindBy(xpath="//div[@class='header-text']//span[contains(text(),'Internal Tasks')]")
	WebElement internalTaskSideNav;
	
	@FindBy(xpath="//h2[@class='page-header'][contains(.,'Internal Tasks')]")
	WebElement pageTitle;
	
	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayout;

	@FindBy(xpath = "//i[@class='fas fa-star fa-stack-1x dx-theme-accent-as-text-color']")
	WebElement columnChooserIcon;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeColChooser;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-minus-square']")
	WebElement collapseIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandIcon;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//div[@class='cc-owner-search-component-container']//input")
	WebElement ownerSearchBox;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-menu']")
	WebElement toolbarMenu;

	@FindBy(xpath = "//ul[contains(@class,'dx-treeview-node-container dx-treeview-node-container-opened')]//li//div//span[contains(text(),'My Work Queue')]")
	WebElement menuMyWorkQueue;

	@FindBy(xpath = "//div[@class='header-text']//span[normalize-space()='Internal Tasks']")
	WebElement menuInternalTasks;

	@FindBy(xpath ="//a[@class='fas fa-question-circle']")
	WebElement helpInternalTaskIcon;

	@FindBy(xpath = "//span[normalize-space()='Email Settings']")
	WebElement emailButton;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement emailCancel;

	@FindBy(xpath = "//input[@role='combobox'][1]")
	WebElement activeFilterDropdown;

	@FindBy(xpath = "//div[contains(text(),'All Tasks')]")
	WebElement activeFilterValue;

	@FindBy(xpath = "(//div[@class='dx-item-content dx-list-item-content'])[2]")
	WebElement allTasks;

	@FindBy(xpath = "(//div[@class='dx-button-content'][contains(.,'Action')])[1]")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	WebElement editRecord;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement editCancelAction;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement editSaveAction;

	@FindBy(xpath = "//span[normalize-space()='Refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "//div[@class='dx-datagrid-content']//table//tbody//td[@colspan='27']")
	WebElement actionVisibility;

	@FindBy(xpath = "//div[@class='dx-loadpanel-content-wrapper']")
	WebElement loaderIcon;

	@FindBy (xpath="//span[@class='dx-tab-text'][contains(.,'Completed / Closed Tasks')]")
	WebElement completedOrClosedTasksTab;
	
	@FindBy (xpath="//input[@max='3650']")
	WebElement daysTextBox;
	
	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandGridData;
	
	@FindBy(xpath="//i[@class='dx-icon cc-icon far fa-minus-square']")
	WebElement collapseGridData;
	
	@FindBy(xpath="//td[contains(@class,'dx-group-cell dx-cell-focus-disabled')]")
	WebElement gridFirstRow;
	
	Navigation navigationSearch = new Navigation(driver);
	
	String strPassed = "Passed";
	String strFailed = "Failed";
	
	public boolean navigate() 
	{
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigateBySideNavigation(By.xpath("//div[@class='header-text']//span[contains(text(),'Internal Tasks')]")," Internal Tasks ");
			waitForInvisibility(loaderIcon);
			
			scrollToElement(internalTaskSideNav);
			clickElementJS(internalTaskSideNav);
			waitForInvisibility(loaderIcon);
			
			waitForElementToBeVisible(pageTitle);
			
            boolean isPageTitle = pageTitle.getText().equals("Internal Tasks");
	        LoggerManager.info("Page Title validation: " + (isPageTitle ? strPassed : strFailed));

	        return isPageTitle;
            
		} catch (Exception e) {
			LoggerManager.error("Error occurred while navigating to the internal task page: " +  e);
			return false;
		}
		
	}

	public boolean helpInternalTask() {
	    try {
	        LoggerManager.debug("Waiting for loader icon to disappear.");
	        waitForInvisibility(loaderIcon);
	       
	        LoggerManager.debug("Waiting for 'helpInternalTask' element to become visible.");
	        waitForElementToBeVisible(helpInternalTaskIcon);
	        waitForElementToBeClickable(helpInternalTaskIcon);
	       
	        scrollToElement(helpInternalTaskIcon);
	        LoggerManager.debug("Clicking on the 'help' icon.");
	        clickElementJS(helpInternalTaskIcon);

	        LoggerManager.debug("Fetching all browser tabs.");
	        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());

	        if (tabs2.size() > 1) {
	        	 waitForInvisibility(loaderIcon);
	  	       
	            LoggerManager.debug("Switching to the second tab.");
	            driver.switchTo().window(tabs2.get(1));
	            
	        	 waitForInvisibility(loaderIcon);

	            LoggerManager.debug("Switching back to the original tab.");
	            driver.switchTo().window(tabs2.get(0));
	        } else {
	            LoggerManager.error("Only one tab detected. Cannot switch to the second tab.");
	            return false; // Return false to indicate failure
	        }

	        LoggerManager.debug("Successfully completed 'helpInternalTask' method.");
	        return true;

	    } catch (Exception e) {
	        LoggerManager.error("Error occurred in 'helpInternalTask' method: " + e.getMessage() +  e);
	        return false; // Return false to indicate failure
	    }
	}

	public boolean columnChooserClick() {
	    try {
	        LoggerManager.debug("Waiting for loader icon to disappear...");
	        waitForInvisibility(loaderIcon);
	        
	        clickElementJS(resetLayout);
	        LoggerManager.info("Clicked on Reset Layout button.");

	        waitForInvisibility(loaderIcon);
	        
	        clickElement(columnChooserIcon);
	        LoggerManager.info("Clicked on Column Chooser button.");

	        waitForInvisibility(loaderIcon);

	        WebElement columnChooserPopup = driver.findElement(By.xpath("//div[contains(text(),'Column Chooser')]"));
	        waitForElementToBeVisible(columnChooserPopup);
	        
	        boolean checkColumnChooserTitle = columnChooserPopup.getText().equals("Column Chooser");
	        LoggerManager.info("Page Title validation: " + (checkColumnChooserTitle ? strPassed : strFailed));
	        
	        clickElementJS(closeColChooser);
	        LoggerManager.info("Clicked on Close Column Chooser button.");

	        return checkColumnChooserTitle;
	    } catch (Exception e) {
	        LoggerManager.error("Error occurred in columnChooserClick method: " + e.getMessage() +  e);
	        return false;
	    }
	}

	public boolean toolbarFullScreen() {
	    try {
	        LoggerManager.debug("Attempting to enter full-screen mode...");

	        
	        waitForInvisibility(loaderIcon);
	        LoggerManager.debug("Loader icon is not visible, proceeding...");

		       
	        // Click the full-screen icon
	        waitForElementToBeVisible(fullScreenIcon);
	        clickElementJS(fullScreenIcon);
	        LoggerManager.debug("Full-screen icon clicked.");
		       
	        // Wait for the loader icon to disappear again
	        waitForInvisibility(loaderIcon);

	        waitForElementToBeVisible(normalScreenIcon);
	        // Check if the normal screen icon is displayed
	        if (normalScreenIcon.isDisplayed()) {
	            LoggerManager.debug("Normal screen icon is displayed. Full-screen mode successfully activated.");
	            return true;
	        } else {
	            LoggerManager.warn("Normal screen icon is not displayed. Full-screen mode activation failed.");
	            return false;
	        }
	    } catch (Exception e) {
	        LoggerManager.error("Error occurred while attempting to toggle full-screen mode: " + e.getMessage() +  e);
	        return false;
	    }
	}

	public boolean toolBarNormalScreen() {
	    try {
	        LoggerManager.debug("Attempting to exit full-screen mode...");

	        // Wait for the loader icon to disappear
	        waitForInvisibility(loaderIcon);
	        LoggerManager.debug("Loader icon is not visible, proceeding...");

	        // Wait for the normal screen icon to be clickable
	        waitForElementToBeClickable(normalScreenIcon);
	        LoggerManager.debug("Normal screen icon is clickable, attempting to click...");

	        // Click the normal screen icon using JavaScript
	        clickElementJS(normalScreenIcon);
	        LoggerManager.debug("Normal screen icon clicked.");

	        // Wait for the loader icon to disappear again
	        waitForInvisibility(loaderIcon);
	        LoggerManager.debug("Loader icon is not visible after clicking normal screen icon.");

	        waitForElementToBeVisible(fullScreenIcon);
	        
	        // Check if the full-screen icon is displayed
	        if (fullScreenIcon.isDisplayed()) {
	            LoggerManager.debug("NormalScreen icon button clicked successfully. Full-screen icon is now visible.");
	            return true;
	        } else {
	            LoggerManager.warn("NormalScreen icon button click failed. Full-screen icon is not visible.");
	            return false;
	        }
	    } catch (Exception e) {
	        LoggerManager.error("Error occurred while attempting to exit full-screen mode: " + e.getMessage() +  e);
	        return false;
	    }
	}

	public boolean emailSetting() {
	    try {
	        LoggerManager.debug("Attempting to open the email settings...");

	        waitForElementToBeVisible(emailButton);
	        LoggerManager.debug("Email button is visible. Clicking the button...");
	        clickElementJS(emailButton);

	        // Wait for the loader icon to disappear
	        waitForInvisibility(loaderIcon);

	        // Switch to the email settings popup window
	        String emailSettingPopup = driver.getWindowHandle();
	        driver.switchTo().window(emailSettingPopup);
	        LoggerManager.debug("Switched to the email settings popup window.");

	        waitForInvisibility(loaderIcon);
	        
	        // Wait for the email cancel button to be visible
	        waitForElementToBeVisible(emailCancel);
	        LoggerManager.debug("Email cancel button is visible.");

	        
	        // Check if the cancel button is displayed
	        if (isElementDisplayed(emailCancel)) {
	            LoggerManager.debug("Email cancel button is displayed. Attempting to click...");
	            waitForElementToBeClickable(emailCancel);
	            clickElementJS(emailCancel);

	            // Wait for the loader icon to disappear again
	            waitForInvisibility(loaderIcon);
	            LoggerManager.debug("Loader icon is not visible after clicking the cancel button.");

	            LoggerManager.info("Email settings popup handled successfully.");
	            return true;
	        } else {
	            LoggerManager.warn("Email cancel button is not displayed.");
	            return false;
	        }
	    } catch (Exception e) {
	        LoggerManager.error("An error occurred while handling email settings: " + e.getMessage() + e);
	        return false;
	    }
	}

	
	public boolean expandCollapseClick() {
	    try {
	        LoggerManager.info("Attempting to expand the UI section.");
	        waitForInvisibility(loaderIcon);
	        clickElementJS(expandIcon);
	        waitForInvisibility(loaderIcon);

	        LoggerManager.info("Attempting to collapse the UI section.");
	        waitForInvisibility(loaderIcon);
	        waitForElementToBeVisible(collapseIcon);
	        clickElementJS(collapseIcon);
	        waitForInvisibility(loaderIcon);

	        LoggerManager.info("Expand and collapse actions completed successfully.");
	        return true;
	    } catch (Exception e) {
	        LoggerManager.error("Error occurred while performing expand/collapse actions." +  e);
	        return false;
	    }
	}

	public boolean activeFilterSelection() {
	    try {
	        LoggerManager.info("Attempting to select the active filter.");
	        waitForInvisibility(loaderIcon);
	        
	        LoggerManager.info("Clicking the active filter dropdown.");
	        clickElement(activeFilterDropdown);
	        waitForInvisibility(loaderIcon);

	        LoggerManager.info("Waiting for 'All Tasks' option to be visible.");
	        waitForElementToBeVisible(allTasks);

	        LoggerManager.info("Selecting 'All Tasks' from the dropdown.");
	        clickElement(allTasks);
	        waitForInvisibility(loaderIcon);

	        LoggerManager.info("Active filter selection completed successfully.");
	        
            boolean isAllTasksDisplayed = allTasks.getText().equals("All Tasks");
	        LoggerManager.info("All Tasks validation: " + (isAllTasksDisplayed ? strPassed : strFailed));

	        
	        return isAllTasksDisplayed;
	    } catch (Exception e) {
	        LoggerManager.error("Error occurred during active filter selection as All Tasks." +  e);
	        return false;
	    }
	}

	public boolean closedWithinDaysTextbox() {
	    try {
	        LoggerManager.info("Starting 'closedWithinDaysTextbox' method.");

	        LoggerManager.info("Waiting for loader icon to disappear.");
	        waitForInvisibility(loaderIcon);

	        clickElement(completedOrClosedTasksTab);
	        waitForInvisibility(loaderIcon);
	        waitForElementToBeClickable(daysTextBox);

	        clickElement(daysTextBox);

	        enterText(daysTextBox, "400");

	        LoggerManager.info("Clicking on the refresh button.");
	        
	        clickElement(refreshButton);

	        LoggerManager.info("Clicked on Refresh. Waiting for loader icon to disappear.");
	        waitForInvisibility(loaderIcon);
 	        return true;
	    } catch (Exception e) {
	        LoggerManager.error("Error occurred in the method." + e);
	        return false;
	    }
	}

	public boolean verifyCancelInEditRecord() {
	    try {
	        LoggerManager.info("Starting 'verifyCancelInEditRecord' method.");

	        LoggerManager.info("Clicking on the active filter dropdown.");
	        clickElement(activeFilterDropdown);
	        waitForInvisibility(loaderIcon);

	        LoggerManager.info("Selecting 'All Tasks' from the dropdown.");
	        clickElement(allTasks);
	        	        	        
	        waitForInvisibility(loaderIcon);
	        	        
	        LoggerManager.info("Clicking on the expand icon.");
	        waitForElementToBeClickable(expandIcon);
	        clickElementJS(expandIcon);
	        waitForInvisibility(loaderIcon);
	        
	        LoggerManager.info("Waiting for the action button to be visible.");
	        waitForElementToBeVisible(actionButton);
	        clickElement(actionButton);
	        waitForInvisibility(loaderIcon);

	        LoggerManager.info("Clicking on the edit record button.");
	        clickElement(editRecord);
	        waitForInvisibility(loaderIcon);

	        LoggerManager.info("Switching to the edit record popup window.");
	        String editRecordPopup = driver.getWindowHandle();
	        driver.switchTo().window(editRecordPopup);

	        LoggerManager.info("Waiting for the cancel action button in the edit record popup.");
	        wait.until(ExpectedConditions.elementToBeClickable(editCancelAction));
	        waitForElementToBeVisible(editCancelAction);

	        LoggerManager.info("Clicking the cancel action button in the edit record popup.");
	        clickElement(editCancelAction);

	        return true;
	    } catch (Exception e) {
	        LoggerManager.error("An error occurred in 'verifyCancelInEditRecord' method." + e);
	        return false;
	    }
	}

}