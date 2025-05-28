package com.ciranet.quicksearch;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.utilities.LoggerManager;

public class QuickSearch extends BasePage {

	public QuickSearch(WebDriver driver) {
		super(driver);
	}

		@FindBy(xpath = "//i[@class='dx-icon dx-icon-menu']")
	WebElement breadCrumbMenuIcon;

	@FindBy(xpath = "//dx-button[@title='Owner Search']")
	WebElement ownerIcon;

	@FindBy(xpath = "//div[@class='cc-owner-search-component-container']//input")
	WebElement ownerOrPropertySearchBox;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-popup-normal dx-popup-draggable dx-resizable']")
	WebElement searchOwnerWindow;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color cc-hyperlink-hover'])[2]")
	WebElement ownerLink;

	@FindBy(xpath = "(//i[contains(@class,'dx-icon fas fa-search')])[2]")
	WebElement quickSearchIcon;

	@FindBy(xpath = "//div[@class='dx-loadindicator-icon']")
	WebElement loaderIcon;

	@FindBy(xpath = "//dx-button[@title='Community Search']")
	WebElement communityIcon;

	@FindBy(xpath = "//div[@class='cc-community-search-component-container']//input")
	WebElement communitysearchBox;

	public void searchOwner(String ownerSearchKeyword) throws Exception {
	    try {
	        waitForInvisibility(loaderIcon);

	        if (!isElementDisplayed(ownerOrPropertySearchBox)) {
	            clickElement(breadCrumbMenuIcon);
	        }

	        waitForElementToBeClickable(ownerOrPropertySearchBox);
	        clickElement(ownerOrPropertySearchBox);

	        waitForInvisibility(loaderIcon);

	        enterText(ownerOrPropertySearchBox, ownerSearchKeyword);

	        ownerOrPropertySearchBox.sendKeys(Keys.ENTER);

	        String ownerPropertyPopup = driver.getWindowHandle();
	        switchToWindow(ownerPropertyPopup);

	        waitForInvisibility(loaderIcon);

	        switchToNewTabAndVerifyNewURL(ownerLink);

	        LoggerManager.debug("Successfully completed owner search with keyword: " + ownerSearchKeyword);

	    } catch (Exception e) {
	        LoggerManager.error("Error occurred during owner search with keyword: " + ownerSearchKeyword + ". Error: " + e.getMessage());
	        throw e; // Re-throwing the exception after logging it
	    }
	}


	public boolean searchCommunity(String communitySearchKeyword) {
	    try {
	        LoggerManager.info("============ Clicking on Community Search ============");

	        // Wait for the community icon to be visible and click on it
	        waitForElementToBeVisible(communityIcon);
	        clickElementJS(communityIcon);

	        // Wait for the community search box to be visible and click on it
	        waitForElementToBeVisible(communitysearchBox);
	        clickElementJS(communitysearchBox);

	        LoggerManager.info("Entering community search keyword: " + communitySearchKeyword);
	        
	        // Enter the search keyword in the search box
	        enterText(communitysearchBox, communitySearchKeyword);

	        // Press Enter to trigger the search
	        communitysearchBox.sendKeys(Keys.ENTER);

	        // Switch to the popup window
	        String ownerPropertyPopup = driver.getWindowHandle();
	        switchToWindow(ownerPropertyPopup);

	        // Press Escape to close any unwanted elements and wait for loader icon to disappear
	        communitysearchBox.sendKeys(Keys.ESCAPE);
	        waitForInvisibility(loaderIcon);

	        // Find and click on the community link corresponding to the search keyword
	        WebElement communityLink = driver.findElement(By.linkText(communitySearchKeyword));
	        waitForElementToBeVisible(communityLink);

	        LoggerManager.info("Switching to new tab for community: " + communitySearchKeyword);
	        
	        // Switch to the new tab and verify the URL
	        switchToNewTabAndVerifyNewURL(communityLink);

	        return true; // Return true on successful execution

	    } catch (Exception e) {
	        // Log the error with the exception message and rethrow the exception
	        LoggerManager.error("Error occurred during community search with keyword: " 
	                            + communitySearchKeyword + ". Error: " + e.getMessage());
	        throw e; // Rethrow the exception to let it propagate
	    }
	}
}
