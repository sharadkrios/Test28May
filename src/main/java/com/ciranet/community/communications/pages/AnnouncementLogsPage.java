package com.ciranet.community.communications.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class AnnouncementLogsPage extends BasePage {
	public AnnouncementLogsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div//span[contains(.,'Announcement Logs')]")
	WebElement announcementLogsSideNav;

	@FindBy(xpath = "//h2[contains(.,'Announcements')]")
	WebElement pageTitle;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']")
	WebElement loaderIcon;

	@FindBy(xpath = "//div[contains(text(),'Active')]")
	WebElement activeTab;

	@FindBy(xpath = "//div[contains(text(),'Expired')]")
	WebElement expiredTab;

	@FindBy(xpath = "//span[normalize-space()='Add New Announcement']")
	WebElement addNewAnnouncementButton;

	@FindBy(xpath = "//input[contains(@aria-required,'true')]")
	WebElement addEditAnnouncementHeading;

	@FindBy(xpath = "//input[contains(@aria-activedescendant,'dx-201449ea-0020-eae0-abd5-6ab2e7ea47ce')]")
	WebElement addEditAnnouncementReleaseDate;

	@FindBy(xpath = "(//input[@autocomplete='off'])[4]")
	WebElement addEditAnnouncementExpires;

	@FindBy(xpath = "//textarea[contains(@autocomplete,'off')]")
	WebElement addEditAnnouncementContent;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-toast-success dx-toast-content dx-resizable']")
	WebElement editInformativeMessage;

	@FindBy(xpath = "(//I[@class='dx-icon dx-icon-edit'])[1]")
	WebElement editButton;

	@FindBy(xpath = "(//i[@class='dx-icon far fa-trash-alt'])[1]")
	WebElement deleteButton;

	@FindBy(xpath = "//span[@class='dx-button-text'][text()='Yes']")
	WebElement announcementDeleteYesButton;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-toast-success dx-toast-content dx-resizable']")
	WebElement announcementDeleteInformativeMessage;

	@FindBy(xpath = "//a[@class='fas fa-question-circle']")
	WebElement helpAnnouncements;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-toast-success dx-toast-content dx-resizable']")
	WebElement informativeMessage;

	@FindBy(xpath = "//dx-box[@id='workProcessedWidgetwork-processed-widget']//div[@class='dx-datagrid-content']")
	WebElement commuintyAlertsPopup;

	public String communitySearchTextFromParameter;
	Navigation navigationSearch = new Navigation(driver);

	public void pressEscapeKey() 
	{
		try 
		{
			Robot robot = new Robot();

			// Press the Escape key
			robot.keyPress(KeyEvent.VK_ESCAPE);
			LoggerManager.info("Escape key pressed.");

			// Release the Escape key
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			LoggerManager.info("Escape key released.");

		}
		catch (Exception e) 
		{
			LoggerManager.error("Error in pressing the Escape key: " + e.getMessage());
		}
	}

	public boolean navigateToAnnouncementLogs(String communityName) {
		navigationSearch.navigateToCommunityContext(communityName);
		waitForInvisibility(loaderIcon);
		LoggerManager.info("Community search completed for keyword: {} " + communityName);

		try {
			try {
				if (wait.until(ExpectedConditions.visibilityOf(commuintyAlertsPopup)) != null) {
					LoggerManager.info("Popup is visible. Handling it...");
					pressEscapeKey();
				}
			} catch (Exception ignored) {
				LoggerManager.info("Popup not visible, proceeding...");
			}

			navigationSearch.navigate(By.xpath("//span[contains(.,'Announcement Logs')]"), "Announcement Logs");
			waitForInvisibility(loaderIcon);
			scrollToElement(announcementLogsSideNav);
			
			if (isElementDisplayed(announcementLogsSideNav)) 
			{
				boolean isPageTitle = pageTitle.getText().equals("Announcements");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} 
			else 
			{
				LoggerManager.info("Announcement Logs is not visible");
				return false;
			}
		}
			catch (Exception e) 
			{
			LoggerManager.error("An error occurred during the community search process: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyAnnouncementsLogsTabSwitch() {
		try {
			LoggerManager.info("Starting the tab switching process...");
			waitForElementToBeVisible(expiredTab);
			LoggerManager.info("Waiting for the expired tab to be visible.");

			if (isElementDisplayed(expiredTab)) {
				LoggerManager.info("Expired tab is displayed, clicking on it.");
				clickElement(expiredTab);
				waitForInvisibility(loaderIcon);
				waitForElementToBeVisible(activeTab);
				clickElement(activeTab);
				waitForInvisibility(loaderIcon);
				return true;
			} else {
				LoggerManager.error("Expired tab not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred while switching tabs: ");
			return false;
		}
	}

	public boolean verifyNewAnnouncementAddition() 
	{
		try 
		{
			LoggerManager.info("Starting the Add New Announcement process...");
			waitForElementToBeVisible(addNewAnnouncementButton);
			LoggerManager.info("Waiting for the 'Add New Announcement' button to be visible.");

			if (isElementDisplayed(addNewAnnouncementButton)) 
			{
				LoggerManager.info("Add New Announcement button is displayed, clicking on it.");
				clickElement(addNewAnnouncementButton);
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Clicked the 'Add New Announcement' button, loader icon is now invisible.");
				waitForElementToBeVisible(addEditAnnouncementHeading);
				LoggerManager.info("Waiting for the 'Add/Edit Announcement' heading to be visible.");
				clickElement(addEditAnnouncementHeading);
				addEditAnnouncementHeading.sendKeys("Added Announcement");
				LoggerManager.info("Added announcement heading: 'Added Announcement'");
				LocalDate today = LocalDate.now();
				LocalDate tomorrow = today.plusDays(1);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				String tomorrowDate = tomorrow.format(formatter);
				LoggerManager.info("Formatted tomorrow's date: " + tomorrowDate);
				addEditAnnouncementExpires.sendKeys(tomorrowDate);
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Entered tomorrow's expiration date: " + tomorrowDate);
				clickElement(addEditAnnouncementContent);
				addEditAnnouncementContent.sendKeys("Add and Edit Announcement contents");
				LoggerManager.info("Added announcement content.");
				clickElement(saveButton);
				waitForInvisibility(loaderIcon);
				waitForElementToBeVisible(activeTab);
				LoggerManager.info("Clicked Save button, loader icon is now invisible.");
				return true;
			} else {
				LoggerManager.error("Add New Announcement button is not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred while adding a new announcement: ");
			return false;
		}
	}


	public boolean verifyAnnouncementEditing() 
	{
		try 
		{
			waitForElementToBeVisible(activeTab);
			waitForElementToBeVisible(editButton);

			if (isElementDisplayed(editButton)) 
			{
				LoggerManager.info("Edit button is visible. Proceeding with edit...");
				clickElement(editButton);
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Clicked the Edit button, waiting for loader to disappear...");

				// Edit announcement content
				clickElement(addEditAnnouncementContent);
				addEditAnnouncementContent.clear();
				addEditAnnouncementContent.sendKeys("Edited Announcement contents");

				// Save the changes
				clickElement(saveButton);
				waitForInvisibility(loaderIcon);
				LoggerManager.info("Clicked Save and waited for loader to disappear.");

				return true;
			}
			else 
			{
				LoggerManager.error("Edit button is NOT displayed. Cannot edit announcement.");
				return false;
			}
		} 
		catch (Exception e) 
		{
			LoggerManager.error("Error while editing announcement: " + e.getMessage());
			return false;
		}
	}
	public boolean verifyAnnouncementDeletion() 
	{
	    try 
	    {
	        LoggerManager.info("Starting the Delete Announcement process...");

	        // Check if the Delete button is visible before clicking
	        if (isElementDisplayed(deleteButton)) 
	        {
	            LoggerManager.info("Delete button is visible. Proceeding with deletion...");
	            clickElement(deleteButton);
	            waitForInvisibility(loaderIcon);
	            LoggerManager.info("Clicked the Delete button and waited for loader icon to disappear.");

	            // Check if the confirmation button is visible before clicking
	            if (isElementDisplayed(announcementDeleteYesButton)) 
	            {
	                LoggerManager.info("Confirm button is visible. Confirming deletion...");
	                clickElement(announcementDeleteYesButton);
	                waitForInvisibility(loaderIcon);
	                LoggerManager.info("Confirmed deletion by clicking 'Yes' and waited for loader to disappear.");

	                // Ensure deletion success by checking active tab visibility
	                waitForElementToBeVisible(activeTab);
	                LoggerManager.info("Announcement deleted successfully.");

	                return true;
	            } 
	            else 
	            {
	                LoggerManager.error("Confirm button is NOT displayed. Cannot proceed with deletion.");
	                return false;
	            }
	        } 
	        else 
	        {
	            LoggerManager.error("Delete button is NOT displayed. Cannot delete announcement.");
	            return false;
	        }
	    } 
	    catch (Exception e) 
	    {
	        LoggerManager.error("Error while deleting announcement: " + e.getMessage());
	        return false;
	    }
	}
	
	public boolean verifyHelpButtonFunctionality() 
	{
	    try 
	    {
	        LoggerManager.info("Starting the Help Announcements verification process...");
	        waitForInvisibility(loaderIcon);

	        // Check if Help Announcements button is visible before clicking
	        if (isElementDisplayed(helpAnnouncements)) 
	        {
	            LoggerManager.info("Help Announcements button is visible. Clicking...");
	            clickElement(helpAnnouncements);
	        } 
	        else 
	        {
	            LoggerManager.error("Help Announcements button is NOT displayed.");
	            return false;
	        }

	        // Wait for new tab to open
	        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	        if (tabs.size() < 2) 
	        {
	            LoggerManager.error("New Help tab did NOT open.");
	            return false;
	        }

	        // Switch to the newly opened tab
	        driver.switchTo().window(tabs.get(tabs.size() - 1));
	        LoggerManager.info("Switched to the new Help tab.");
	        waitForInvisibility(loaderIcon);

	        // Close the new tab and switch back to the original tab
	        driver.close();
	        LoggerManager.info("Closed the Help tab.");

	        driver.switchTo().window(tabs.get(0));
	        LoggerManager.info("Switched back to the original tab.");
	        waitForElementToBeVisible(helpAnnouncements);

	        return true;
	    } 
	    catch (Exception e) 
	    {
	        LoggerManager.error("Error while verifying Help Announcements: " + e.getMessage());
	        return false;
	    }
	}
}