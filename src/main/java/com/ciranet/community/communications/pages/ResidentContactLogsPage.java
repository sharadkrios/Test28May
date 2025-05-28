package com.ciranet.community.communications.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ResidentContactLogsPage extends BasePage {
	public ResidentContactLogsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//a/span)[1]")
	WebElement historicalHyperlink;

	@FindBy(xpath = "//dx-box[@id='workProcessedWidgetwork-processed-widget']//div[@class='dx-datagrid-content']")
	WebElement communityAlertsPopup;

	By closeCommunityAlertsIcon = By.xpath("//div//i[@class='dx-icon fas fa-times']");
	By residentContactLogsSideNav = By.xpath("//div//span[contains(.,'Resident Contact Logs')]");

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigateToResidentContactLogs(String communityName) {
		try {
			navigationSearch.navigateToCommunityContext(communityName);
			LoggerManager.info("Community search completed for keyword: {} " + communityName);
			closePopupIfPresent("Community Alerts", closeCommunityAlertsIcon);
			navigationSearch.navigate(residentContactLogsSideNav, "Resident Contact Logs");
			return verifyPageHeaderTextMatches("Resident Contact Logs");
		} catch (Exception e) {
			LoggerManager.error("An error occurred while navigating to Resident Contact Logs" + e.getMessage());
			return false;
		}

	}

	public boolean verifyResidentContactLogsHistoricalHyperlink() {
		try {
			waitForElementToBeVisible(historicalHyperlink);
			if (isElementDisplayed(historicalHyperlink)) {
				clickElement(historicalHyperlink);
				LoggerManager.info("Successfully clicked on the Historical Hyperlink.");
				return true;
			} else {
				LoggerManager.warn("Historical Hyperlink is not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred while verifying the Historical Hyperlink: " + e.getMessage());
			return false;
		}
	}
}

