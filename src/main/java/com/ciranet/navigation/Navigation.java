package com.ciranet.navigation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;

import com.ciranet.basepage.BasePage;
import com.ciranet.utilities.LoggerManager;

public class Navigation extends BasePage {

	public Navigation(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//dx-button[@title='Navigation Search']//div[@class='dx-button-content']")
	WebElement navigationIcon;

	@FindBy(xpath = "//dx-button[@title='Community Search']")
	WebElement communitySearchIcon;

	String textboxLocator = "//input[@role='textbox']";
	String skipTestMessage = " is not available. Skipping the test.";
	String elementNotVisibleInTimeMessage = " element not visible within the expected time. Skipping the test.";

	/**
	 * This method is used to search the menu by side navigation. Check the menu is
	 * available otherwise Skip that test.
	 */
	public void navigateBySideNavigation(By locator, String menuToNavigate) {

		try {
			LoggerManager.info("Navigating through the side menu: " + menuToNavigate);

			// Wait for the navigation icon to be visible and click on it
			waitForElementToBeVisible(navigationIcon);
			clickElementJS(navigationIcon);

			// Find the search text box and enter the menu name
			By navigationSearchTextBox = By.xpath(textboxLocator);
			WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(navigationSearchTextBox));

			LoggerManager.info("Entering menu to navigate: " + menuToNavigate);
			enterText(textBox, menuToNavigate);
			textBox.sendKeys(Keys.ENTER);

			// Check if the target element (menu) is visible
			isElementVisible(locator);
			WebElement element = driver.findElement(locator);

			// Verify if the element is displayed; if not, skip the test
			if (!element.isDisplayed()) {
				LoggerManager.warn(menuToNavigate + skipTestMessage);
				throw new SkipException(menuToNavigate + skipTestMessage);
			}

			LoggerManager.info("Successfully navigated " + menuToNavigate);

		} catch (NoSuchElementException e) {
			LoggerManager.error(menuToNavigate + skipTestMessage);
			throw new SkipException(menuToNavigate + skipTestMessage, e);

		} catch (TimeoutException e) {
			LoggerManager.error(menuToNavigate + elementNotVisibleInTimeMessage);
			throw new SkipException(menuToNavigate + elementNotVisibleInTimeMessage, e);

		} catch (Exception e) {
			LoggerManager.error(
					"Unexpected error occurred while navigating to " + menuToNavigate + ".Error: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Useful to test new side navigation modules after 05-02-2025. This method is
	 * used to search the navigation item and click on it. Later the method
	 * "navigateBySideNavigation" written above will get deprecated and this method
	 * will be used.
	 */
	public void navigate(By navigationItemLocator, String navigationItemName) {
		try {
			LoggerManager.info("Navigating through the side navigation: " + navigationItemName);

			clickNavigationSearchIcon();
			inputNavigationSearchText(navigationItemName);
			TimeUnit.SECONDS.sleep(2); // Waits for 2 seconds
			selectNavigationItem(navigationItemLocator, navigationItemName);

			LoggerManager.info("Successfully navigated to " + navigationItemName);
		} catch (StaleElementReferenceException e) {
			clickNavigationItem(navigationItemLocator);
		} catch (TimeoutException e) {
			LoggerManager.error(navigationItemName + elementNotVisibleInTimeMessage);
			throw new SkipException(navigationItemName + elementNotVisibleInTimeMessage, e);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager
					.error("Unexpected error while navigating to " + navigationItemName + ".Error : " + e.getMessage());
			throw new IllegalStateException("Navigation failed for " + navigationItemName, e);
		}
	}

	/**
	 * Handles clicking the navigation search icon.
	 */
	private void clickNavigationSearchIcon() {
		try {
			waitForElementToBeVisible(navigationIcon);
			clickElementJS(navigationIcon);
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Navigation icon not found. Skipping the test.");
			throw new SkipException("Navigation icon not found. Skipping the test.", e);
		}
	}

	/**
	 * Input the navigation item name in the Navigation search text box.
	 */
	private void inputNavigationSearchText(String navigationItemName) {
		try {
			WebElement searchNavigationTextBox = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(textboxLocator))));

			LoggerManager.info("Entering navigation item name to navigate: " + navigationItemName);
			enterText(searchNavigationTextBox, navigationItemName);
			searchNavigationTextBox.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			LoggerManager.error("Search navigation text box not found. Skipping the test.");
			throw new SkipException("Search navigation text box not found. Skipping the test.", e);
		}
	}

	/**
	 * Handles selecting the navigation item.
	 */
	private void selectNavigationItem(By navigationItemLocator, String navigationItemName) {
		if (!isElementVisible(navigationItemLocator)) {
			LoggerManager.warn(navigationItemName + " is not visible. Skipping the test.");
			throw new SkipException(navigationItemName + " is not visible. Skipping the test.");
		}

		try {
			WebElement navigationItemElement = driver.findElement(navigationItemLocator);
			scrollToElement(navigationItemElement);
			TimeUnit.SECONDS.sleep(2); // Waits for 2 seconds

			clickElementJS(navigationItemElement);

			if (!navigationItemElement.isDisplayed()) {
				LoggerManager.warn(navigationItemName + elementNotVisibleInTimeMessage);
				throw new SkipException(navigationItemName + elementNotVisibleInTimeMessage);
			}
		} catch (NoSuchElementException | InterruptedException e) {
			LoggerManager.error(navigationItemName + " element not found. Skipping the test.");
			Thread.currentThread().interrupt();
			throw new SkipException(navigationItemName + " element not found. Skipping the test.", e);
		}
	}

	/**
	 * Click navigation item in case of StaleElementReferenceException.
	 */
	private void clickNavigationItem(By navigationItemLocator) {
		LoggerManager.warn("StaleElementReferenceException encountered. Retrying...");
		try {
			WebElement navigationItemElement = driver.findElement(navigationItemLocator);
			navigationItemElement.click();
		} catch (Exception e) {
			LoggerManager.error("Click failed. Skipping test: " + e.getMessage());
			throw new SkipException("Element became stale and could not be recovered.", e);
		}
	}

	/**
	 * Common method to navigate To Community Context.
	 * 
	 */
	public void navigateToCommunityContext(String communityContext) {
		try {
			LoggerManager.info("Searching the Community Context : " + communityContext);

			clickCommunitySearchIcon();
			inputCommunitySearchText(communityContext);
			selectMatchingCommunityContext(communityContext);

			LoggerManager.info("Navigated successfully to " + communityContext);
		} catch (TimeoutException e) {
			LoggerManager.error(communityContext + elementNotVisibleInTimeMessage);
			throw new SkipException(communityContext + elementNotVisibleInTimeMessage, e);
		} catch (Exception e) {
			LoggerManager
					.error("Unexpected error while navigating to " + communityContext + " . Error: " + e.getMessage());
			throw new IllegalStateException("Navigation failed for " + communityContext, e);
		}
	}

	/**
	 * Handles clicking the Community search icon.
	 */
	private void clickCommunitySearchIcon() {
		try {
			waitForElementToBeVisible(communitySearchIcon);
			clickElementJS(communitySearchIcon);
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Community Search icon not found. Skipping the test.");
			throw new SkipException("Community Search icon not found. Skipping the test.", e);
		}
	}

	/**
	 * Input the Community name in the Community search text box.
	 */
	private void inputCommunitySearchText(String communityContextToSearch) {
		try {
			WebElement searchCommunityTextBox = wait
					.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(textboxLocator))));

			LoggerManager.info("Entering Community name to search: " + communityContextToSearch);
			enterText(searchCommunityTextBox, communityContextToSearch);
			searchCommunityTextBox.sendKeys(Keys.ENTER);
		} catch (NoSuchElementException e) {
			LoggerManager.error("Search Community text box not found. Skipping the test.");
			throw new SkipException("Search Community text box not found. Skipping the test.", e);
		}
	}

	/**
	 * Select matching community from the matching community list.
	 */
	private void selectMatchingCommunityContext(String matchedCommunityContext) {
		LoggerManager.info("Selecting matching community");
		try {

			// Switch to the Matching Community pop up
			String matchingCommunityPopup = driver.getWindowHandle();
			switchToWindow(matchingCommunityPopup);

			// Find and click on the community link corresponding to the search keyword
			WebElement matchedCommunityLink = driver.findElement(By.linkText(matchedCommunityContext));
			waitForElementToBeVisible(matchedCommunityLink);

			LoggerManager.info("Switching to new tab for community: " + matchedCommunityContext);

			// Switch to the new tab and verify the URL
			switchToNewTabAndVerifyNewURL(matchedCommunityLink);
		} catch (Exception e) {
			LoggerManager.error("Error occurred during community search with keyword: " + matchedCommunityContext
					+ ". Error : " + e.getMessage());
			throw new SkipException("Community " + matchedCommunityContext + " not found", e);
		}
	}

}
