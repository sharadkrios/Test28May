package com.ciranet.community.communications.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class MailMergePage extends BasePage {
	public MailMergePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-icon'][1]")
	WebElement labelsOrLettersDropdown;

	@FindBy(xpath = "//div[contains(text(),'Labels')]")
	WebElement labelsDropdownValue;

	@FindBy(xpath = "//div[contains(text(),'Letters')]")
	WebElement lettersDropdownValue;

	@FindBy(xpath = "//span[normalize-space()='Browse'][1]")
	WebElement browseButton;

	@FindBy(xpath = "//span[normalize-space()='Create Labels']")
	WebElement createLabelsButton;

	@FindBy(xpath = "(//span[@class='dx-checkbox-icon'])[2]")
	WebElement checkBoxColumn;

	@FindBy(xpath = "//span[normalize-space()='View/Save Standard Letterhead Template']")
	WebElement viewSaveStandardLetterheadTemplateLink;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color cc-hyperlink-hover'])[1]")
	WebElement customerIdColumn;

	@FindBy(xpath = "(//a[@class='cc-hyperlink dx-theme-accent-as-text-color cc-hyperlink-hover'])[2]")
	WebElement combinedOwnerColumn;

	By closeCommunityAlertsIcon = By.xpath("//div//i[@class='dx-icon fas fa-times']");
	By mailMergeSideNav = By.xpath("//span[normalize-space()='Mail Merge']");

	Navigation navigationSearch = new Navigation(driver);
	
	
/**
 * 
 * @param communityName
 * @return
 */
	public boolean navigateToMailMerge(String communityName) {
		try {
			navigationSearch.navigateToCommunityContext(communityName);
			LoggerManager.info("Community search completed for keyword: {} " + communityName);
			closePopupIfPresent("Community Alerts", closeCommunityAlertsIcon);
			navigationSearch.navigate(mailMergeSideNav, "Mail Merge");
			return verifyPageHeaderTextMatches("Mail Merge");

		} catch (Exception e) {
			LoggerManager.error("An error occurred while navigating to Mail Merge" + e.getMessage());
			return false;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean verifyMailMergeDropdownOptions() {
		try {
			clickElement(labelsOrLettersDropdown);
			LoggerManager.info("Dropdown clicked.");

			if (isElementDisplayed(labelsDropdownValue)) {
				clickElement(labelsDropdownValue);
				LoggerManager.info("Labels option selected");

				clickElement(labelsOrLettersDropdown);
				LoggerManager.info("Dropdown clicked again to select Letters options");

				clickElement(lettersDropdownValue);
				waitForElementToBeVisible(browseButton);
				LoggerManager.info("Letters option selected");
				return true;
			} else {
				LoggerManager.warn("Letters dropdown value not displayed");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in verifying dropdown selection: " + e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	public boolean verifyMailMergeLabelsCreation() {
		try {
			clickElement(labelsOrLettersDropdown);
			LoggerManager.info("Dropdown clicked.");

			if (isElementDisplayed(labelsDropdownValue)) {
				clickElement(labelsDropdownValue);
				LoggerManager.info("Labels option selected");

				clickElement(checkBoxColumn);
				LoggerManager.info("Checkbox clicked.");

				clickElement(createLabelsButton);
				LoggerManager.info("Labels created successfully.");
				return true;
			} else {
				LoggerManager.warn("Labels dropdown value not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in verifying label creation: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public boolean verifyBrowseAndUploadFunctionality(String filePath) {
		try {
			clickElement(labelsOrLettersDropdown);
			LoggerManager.info("Dropdown clicked to select 'Letters'.");
			clickElement(lettersDropdownValue);
			waitForElementToBeVisible(browseButton);
			if (isElementDisplayed(browseButton)) {
				clickElement(browseButton);
				LoggerManager.info("Browse button clicked.");
				Robot robot = new Robot();
				StringSelection filePathSelection = new StringSelection(System.getProperty("user.dir") + filePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				LoggerManager.info("File path pasted.");
				waitForElementToBeVisible(viewSaveStandardLetterheadTemplateLink);
				return true;
			} else {
				LoggerManager.warn("Browse button not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Exception during file upload" + e.getMessage());
			return false;
		}
	}

	/**
	 * 
	 * @return
	 */
	public boolean validateMailMergeViewOrSaveTemplate() {
		try {
			clickElement(labelsOrLettersDropdown);
			LoggerManager.info("Dropdown clicked to select Letters");
			clickElement(lettersDropdownValue);
			if (isElementDisplayed(viewSaveStandardLetterheadTemplateLink)) {
				clickElement(viewSaveStandardLetterheadTemplateLink);
				LoggerManager.info("'View Save Standard Letterhead Template' button clicked.");
				pressESCKey();
				LoggerManager.info("Successfully viewed and saved the Standard Letterhead Template.");
				return true;
			} else {
				LoggerManager.warn("View Save Standard Letterhead Template not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in viewing or saving the Standard Letterhead Template: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * 
	 * @param browserWindowHandles
	 * @return
	 */

	private String getOnlyElement(Set<String> browserWindowHandles) 
	{
		return browserWindowHandles.stream().findFirst().orElse(null);
	}
	

	/**
	 * Verifies that clicking on the Customer ID hyperlink opens a new browser window or tab,
	 * switches to the new window, then closes it and switches back to the original window.
	 * 
	 * @return true if the navigation and window handling succeed, false otherwise
	 */
	public boolean verifyCustomerIdHyperlinkNavigation() {
	    try {
	        // Wait for the Customer ID column element to be visible on the page
	        waitForElementToBeVisible(customerIdColumn);

	        // Check if the Customer ID hyperlink element is displayed
	        if (isElementDisplayed(customerIdColumn)) {
	            // Store the current window handle before clicking the link
	            String currentWindow = driver.getWindowHandle();

	            // Store all window handles currently open before the click
	            Set<String> beforeClickWindows = driver.getWindowHandles();

	            // Click the Customer ID hyperlink which should open a new window or tab
	            clickElement(customerIdColumn);

	            // Get all window handles after the click
	            Set<String> afterClickWindows = driver.getWindowHandles();

	            // Remove all window handles that were already present before the click
	            // This should leave only the new window handle(s)
	            afterClickWindows.removeAll(beforeClickWindows);

	            // Retrieve the new window handle if any
	            String newWindowHandle = getOnlyElement(afterClickWindows);

	            // Verify if a new window/tab was actually opened
	            if (newWindowHandle != null) {
	                // Switch Selenium's context to the new window/tab
	                driver.switchTo().window(newWindowHandle);

	                // Close the new window/tab
	                driver.close();

	                // Switch back to the original window
	                driver.switchTo().window(currentWindow);

	                // Return true indicating successful navigation and window handling
	                return true;
	            } else {
	                // Log a warning if no new window was opened (could be popup blocked)
	                LoggerManager.warn("New browser tab or window not opened. Possibly blocked.");
	                return false;
	            }
	        } else {
	            // Log a warning if the Customer ID hyperlink is not displayed on the page
	            LoggerManager.warn("Customer ID hyperlink not displayed.");
	            return false;
	        }

	    } catch (Exception e) {
	        // Log any exceptions that occur during this verification process
	        LoggerManager.error("Error while verifying Customer ID hyperlink navigation: " + e.getMessage());
	        return false;
	    }
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean verifyCombinedOwnerHyperlinkNavigation() 
	{
		try {
			waitForElementToBeVisible(combinedOwnerColumn);

			if (isElementDisplayed(combinedOwnerColumn)) {
				clickElement(combinedOwnerColumn);
				return true;
			} else {
				LoggerManager.warn("Combined Owner hyperlink not displayed.");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error while verifying Combined Owner hyperlink navigation: " + e.getMessage());
			return false;
		}
	}
}