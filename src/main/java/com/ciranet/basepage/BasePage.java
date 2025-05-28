package com.ciranet.basepage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import com.ciranet.utilities.EnvironmentConfig;
import com.ciranet.utilities.LoggerManager;

public abstract class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	boolean isPageHeaderTextMatches = false;

	/**
	 * BasePage Constructor
	 * 
	 * @param driver
	 */
	protected BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * To take DEFAULT_VISIBILITY_MAX_TIMEOUT value from environment properties 
	 * e.g. sandbox.properties
	 * DEFAULT_VISIBILITY_MAX_TIMEOUT=120
	 * 
	 * @return wait
	 */
	protected WebDriverWait getWait() {
		if (wait == null) {
			long timeoutInSeconds = Long
					.parseLong(EnvironmentConfig.environmentSetup().get("DEFAULT_VISIBILITY_MAX_TIMEOUT"));
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		}
		return wait;
	}

	/**
	 * getWait - Function overloading
	 * 
	 * @param maxVisibilityTimeout
	 * @return
	 */
	protected WebDriverWait getWait(Duration maxVisibilityTimeout) {
		return new WebDriverWait(driver, maxVisibilityTimeout);
	}

	/**
	 * Wait for an element to be visible
	 * 
	 * @param element
	 */
	protected void waitForElementToBeVisible(WebElement element) {
		getWait().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * waitForElementToBeVisible - function overloading with WebElement + custom
	 * maxVisibilityTimeout
	 * 
	 * @param element
	 * @param Duration of seconds maxVisibilityTimeout
	 */
	protected void waitForElementToBeVisible(WebElement element, Duration maxVisibilityTimeout) {
		getWait(maxVisibilityTimeout).until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wait for an element to be invisible
	 * 
	 * @param element
	 */
	protected void waitForInvisibility(WebElement element) {
		getWait().until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Wait for an element to be invisible. Function overloading with WebElement +
	 * custom maxVisibilityTimeout
	 * 
	 * @param element
	 */
	protected void waitForInvisibility(WebElement element, Duration maxVisibilityTimeout) {
		getWait(maxVisibilityTimeout).until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Wait for an element to be clicked
	 * 
	 * @param element
	 */
	protected void waitForElementToBeClickable(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait for an element to be clicked. Function overloading with WebElement +
	 * custom maxVisibilityTimeout
	 * 
	 * @param element
	 */
	protected void waitForElementToBeClickable(WebElement element, Duration maxVisibilityTimeout) {
		getWait(maxVisibilityTimeout).until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait for a list of elements to be visible
	 * 
	 * @param WebElements - elements
	 */
	protected void waitForElementsToBeVisible(List<WebElement> elements) {
		getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/**
	 * Wait for a list of elements to be visible. Function overloading with
	 * WebElement + custom maxVisibilityTimeout
	 * 
	 * @param WebElements - elements
	 */
	protected void waitForElementsToBeVisible(List<WebElement> elements, Duration maxVisibilityTimeout) {
		getWait(maxVisibilityTimeout).until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	/**
	 * Click on an element
	 * 
	 * @param element
	 */
	protected void clickElement(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}

	/**
	 * Enter text into an input field
	 * 
	 * @param WebElement - element
	 * @param String     text
	 */
	protected void enterText(WebElement element, String text) {
		waitForElementToBeVisible(element);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Get text from an element
	 * 
	 * @param WebElement element
	 * @return String getText
	 */
	protected String getElementText(WebElement element) {
		waitForElementToBeVisible(element);
		return element.getText();
	}

	/**
	 * Check if an element is displayed
	 * 
	 * @param WebElemnt element
	 * @return boolean value
	 */
	protected boolean isElementDisplayed(WebElement element) {
		try {
			waitForElementToBeVisible(element);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check if an element is enabled
	 * 
	 * @param WebElement element
	 * @return a boolean value
	 */
	protected boolean isElementEnabled(WebElement element) {
		waitForElementToBeVisible(element);
		return element.isEnabled();
	}

	/**
	 * Scroll to an element using JavaScript
	 * 
	 * @param WebElement element
	 */
	protected void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Scroll to an element using JavaScript
	 * 
	 * @param element
	 */
	protected void clickElementJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * Select a value from a drop-down control
	 * 
	 * @param element
	 * @param value
	 */
	protected void selectDropdownByValue(WebElement element, String value) {
		waitForElementToBeClickable(element);
		new Select(element).selectByValue(value);
	}

	/**
	 * Select a value from a drop-down by visible text
	 * 
	 * @param element
	 * @param visibleText
	 */
	protected void selectDropdownByVisibleText(WebElement element, String visibleText) {
		waitForElementToBeClickable(element);
		new Select(element).selectByVisibleText(visibleText);
	}

	/**
	 * Get the current page URL
	 * 
	 * @return
	 */
	protected String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}

	/**
	 * Get the page title
	 * 
	 * @return
	 */
	protected String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Navigate to a URL
	 * 
	 * @param url
	 */
	protected void navigateToURL(String url) {
		driver.navigate().to(url);
	}

	/**
	 * Refresh the page
	 */
	protected void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * Switch to a new window or tab
	 * 
	 * @param windowHandle
	 */
	protected void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	/**
	 * Close the current window
	 */
	protected void closeCurrentWindow() {
		driver.close();
	}

	/**
	 * Accept an alert
	 */
	protected void acceptAlert() {
		getWait().until(ExpectedConditions.alertIsPresent()).accept();
	}

	/**
	 * Accept an alert. Function overloading.
	 */
	protected void acceptAlert(Duration maxVisibilityTimeout) {
		getWait(maxVisibilityTimeout).until(ExpectedConditions.alertIsPresent()).accept();
	}

	/**
	 * Dismiss an alert
	 */
	protected void dismissAlert() {
		getWait().until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	/**
	 * Dismiss an alert. Function overloading
	 */
	protected void dismissAlert(Duration maxVisibilityTimeout) {
		getWait(maxVisibilityTimeout).until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	/**
	 * Get alert text
	 * 
	 * @return
	 */
	protected String getAlertText() {
		return getWait().until(ExpectedConditions.alertIsPresent()).getText();
	}

	/**
	 * Wait For URL
	 * 
	 * @param driver
	 * @param url
	 */
	protected void waitForUrlToBe(WebDriver driver, String url) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.urlToBe(url));
	}

	/**
	 * switch To New Tab And Verify New URL
	 * 
	 * @param link
	 */
	protected void switchToNewTabAndVerifyNewURL(WebElement link) {
		clickElement(link);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String actualURL = driver.getCurrentUrl();
		LoggerManager.info("Current URL : " + actualURL);
	}

	/**
	 * switch To New browser tab And Close New browser tab
	 * 
	 * @param link
	 */
	protected void switchToNewTabAndCloseNewTab(WebElement link) {
		String originalTab = driver.getWindowHandle();
		clickElement(link);
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String actualURL = driver.getCurrentUrl();
		LoggerManager.info("Current URL : " + actualURL);

		driver.close();
		driver.switchTo().window(originalTab);
	}

	/**
	 * Checks whether the Element is visible otherwise checks the Exception
	 * 
	 * @param locator
	 * @return
	 */
	protected boolean isElementVisible(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e) {
			return false;
		}
	}

	/**
	 * Method to click on hamburgerMenu
	 */
	public void hamburgerMenu() {
		try {
			WebElement hamburgerMenuIcon = driver
					.findElement(By.xpath("//dx-button[@title='Hide Menu']//i[@class='dx-icon dx-icon-menu']"));
			clickElement(hamburgerMenuIcon);
			LoggerManager.info("Hamburger menu clicked successfully.");
		} catch (NoSuchElementException e) {
			LoggerManager.error("Hamburger menu not found: " + e.getMessage());
		} catch (Exception e) {
			LoggerManager.error("An error occurred while clicking the hamburger menu: " + e.getMessage());
		}
	}

	/**
	 * Common method to check the menu is available otherwise Skip that test
	 * 
	 * @param locator
	 * @param elementDescription
	 */
	protected void checkElementAvailability(By locator, String elementDescription) {
		try {
			WebElement element = driver.findElement(locator);
			if (!element.isDisplayed()) {
				throw new SkipException(elementDescription + " is not available. Skipping the test.");
			}
		} catch (NoSuchElementException e) {
			throw new SkipException(elementDescription + " element not found. Skipping the test.");
		}
	}

	/**
	 * Common method to close pop ups after navigating to Community / Property
	 * Context. PopupType means "Warning or User Announcement or Owner/Community or
	 * Collection"
	 */
	protected void closePopupIfPresent(String popupType, By popupLocator) {
		try {
			if (isElementVisible(popupLocator)) {
				getWait().until(ExpectedConditions.visibilityOfElementLocated(popupLocator));
				WebElement popup = driver.findElement(popupLocator);
				popup.click();
			} else {
				LoggerManager.info("Popup " + popupType.toLowerCase() + " is not displayed");
			}
			LoggerManager.info("Closing " + popupType.toLowerCase() + " popup");
		} catch (Exception e) {
			LoggerManager.error("Popup " + popupType.toLowerCase() + " not found: ");
		}
	}

	/**
	 * Common method to verify the Page Header Text matches or not.
	 */
	public boolean verifyPageHeaderTextMatches(String pageHeaderText) {
		try {
			String dynamicPageTitleXPath = String.format(
					"//*[(@class='page-header' or @class='tile-header page-header') and contains(.,'%1$s')] "
							+ "| //h1[contains(.,'%1$s')] | //h2[contains(.,'%1$s')] | //h3[contains(.,'%1$s')]",
					pageHeaderText);
			WebElement dynamicPageHeaderText = driver.findElement(By.xpath(dynamicPageTitleXPath));

			if (isElementDisplayed(dynamicPageHeaderText)) {
				isPageHeaderTextMatches = dynamicPageHeaderText.getText().equals(pageHeaderText);
				LoggerManager.info("Page Title validation for '" + pageHeaderText + "': "
						+ (isPageHeaderTextMatches ? "Passed" : "Failed"));
				return isPageHeaderTextMatches;
			} else {
				LoggerManager.error("Page header element not visible for: " + pageHeaderText);
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error(
					"Error occurred while validating page title for '" + pageHeaderText + "': " + e.getMessage());
			return false;
		}
	}

	/**
	 * Common method to Press ESC key.
	 */
	public void pressESCKey() {
		try {
			LoggerManager.info("Pressing Escape key to close any popups if present");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			LoggerManager.error("Error pressing the Escape key: " + e.getMessage());
		}
	}
}