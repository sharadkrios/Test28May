package com.ciranet.basepage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.utilities.LoggerManager;

public abstract class BaseConfigurationPage extends BasePage {

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-icon']")
	WebElement configurationDropdown;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[3]")
	WebElement contextDropdown;

	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	WebElement pageTitleText;

	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	WebElement selectedFocusedContextValue;

	public String configurationValueText = "";
	public static String contextSearchTextFromParameter = "";

	public BaseConfigurationPage(WebDriver driver) {
		super(driver);
	}

	public boolean navigateToConfigurationModule(WebElement configurationSideNavLocator, WebElement configurationGroupSideNavLocator,
			 String configurationGroupTitle) {
		try {
			// Navigate to the configurations
			scrollToElement(configurationSideNavLocator);
			clickElement(configurationSideNavLocator);
			// Navigate to the specific module inside the configurations
			scrollToElement(configurationGroupSideNavLocator);
			waitForElementToBeVisible(configurationGroupSideNavLocator);
			clickElementJS(configurationGroupSideNavLocator);
			return verifyPageHeaderTextMatches(configurationGroupTitle);
		} catch (NoSuchElementException  | TimeoutException e) {
			LoggerManager.error("An error occurred while navigating to configuration Module:" + e.getMessage());
			return false;
		}
	}

	public boolean validateConfigContextTitle() {
		try {
			waitForElementToBeClickable(contextDropdown);
			contextDropdown.click();
			contextDropdown.sendKeys(contextSearchTextFromParameter);
			clickElementJS(selectedFocusedContextValue);
			String contextValueText = selectedFocusedContextValue.getText();
			String strLabel = configurationValueText + " - " + contextValueText;
			waitForElementToBeVisible(pageTitleText);
			boolean isLabelCorrect = strLabel.equals(pageTitleText.getText());
			if (!isLabelCorrect) {
				LoggerManager.error("Validation failed: The configuration and context text does not match with the page title.");
				return false;
			} else {
				return true;
			}
		} catch (NoSuchElementException  | TimeoutException e) {
			LoggerManager.error("Timeout exception or no such element found while selecting context: " + e.getMessage());
			return false;
		}
	}

	public boolean selectConfiguration(WebElement configurationLocator) {
		try {
			clickElement(configurationDropdown);
			clickElementJS(configurationLocator);
			waitForElementToBeVisible(configurationLocator);
			configurationValueText = configurationLocator.getText();
			return validateConfigContextTitle();
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while selecting configuration: " + e.getMessage());
			return false;
		}
	}
}


