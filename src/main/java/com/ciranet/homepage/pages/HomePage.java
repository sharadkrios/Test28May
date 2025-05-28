package com.ciranet.homepage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//dx-button[@title='Community Search']")
	public WebElement communityIcon;
	
	@FindBy(xpath = "//i[@class='dx-icon dx-icon-menu']")
	public WebElement toolbarMenu;
	
	@FindBy(xpath = "//div[@class='cc-community-search-component-container']//input")
	public WebElement communitysearchBox;
	
	@FindBy(xpath = "//div[@class='cc-community-search-component-container']//div[@class='dx-button-content']//i[@class='dx-icon fas fa-search']")
	public WebElement communitysearchButton;
	
	@FindBy(linkText = "Amberwood")
	public WebElement amberwoodLink;
	
	@FindBy(xpath = "//dx-button[@title='Owner Search']")
	public WebElement ownerIcon;
	
	@FindBy(xpath = "//div[@class='cc-owner-search-component-container']//input")
	public WebElement ownersearchBox;
	
	@FindBy(xpath = "//div[@class='dx-scrollable-content']//table[@class='dx-datagrid-table dx-datagrid-table-fixed']//tr//td[7]//div//app-hyperlink-creator")
	public WebElement ownerLink;

	@FindBy(xpath = "//div[@class='cc-owner-search-component-container']//div[@class='dx-button-content']//i[@class='dx-icon fas fa-search']")
	public WebElement ownersearchButton;
	
	@FindBy(xpath= "//div[@class='dx-loadindicator-icon']")
	private WebElement eleLoadIcon;
	
	public boolean searchOwner(String ownerSearchKeyword) {
	    LoggerManager.info("============  Clicking on Owner Search ============");
	    
	    try {
	        if (!ownersearchBox.isDisplayed()) {
	            LoggerManager.info("Owner search box is not displayed. Clicking on toolbar menu.");
	            clickElement(toolbarMenu);
	        }

	        waitForElementToBeVisible(ownersearchBox);
	        clickElement(ownersearchBox);

	        waitForInvisibility(eleLoadIcon);
	        ownersearchBox.sendKeys(ownerSearchKeyword);

	        clickElement(ownersearchButton);

	        waitForInvisibility(eleLoadIcon);
	        waitForElementToBeVisible(ownerLink);

	        waitForInvisibility(eleLoadIcon);
	        LoggerManager.info("Switching to new tab to view owner details.");
	        switchToNewTabAndCloseNewTab(ownerLink);

	        LoggerManager.info("Owner search completed successfully.");
	        return true;
	    } catch (Exception e) {
	        LoggerManager.error("Error occurred during owner search: " + e.getMessage() +  e);
	        return false;
	    }
	}

	
	public boolean searchCommunity(String communitySearchKeyword) {
	    LoggerManager.info("============  Clicking on Community Search ============");

	    try {
	        waitForElementToBeVisible(communityIcon);

	        clickElement(communityIcon);

	        waitForElementToBeVisible(communitysearchBox);

	        LoggerManager.info("Clicking on the community search box.");
	        clickElement(communitysearchBox);

	        communitysearchBox.sendKeys(communitySearchKeyword);

	        clickElement(communitysearchButton);

	        waitForElementToBeVisible(amberwoodLink);

	        LoggerManager.info("Switching to new tab to view community details.");
	        switchToNewTabAndCloseNewTab(amberwoodLink);

	        LoggerManager.info("Community search completed successfully.");
	        return true;
	    } catch (Exception e) {
	        LoggerManager.error("Error occurred during community search: " + e.getMessage() +  e);
	        return false;
	    }
	}
	
}