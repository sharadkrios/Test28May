package com.ciranet.preferences.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.utilities.LoggerManager;

public class PreferencesPage extends BasePage {
	// Initializing the Page Objects:
	public PreferencesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[10]")
	WebElement themeWD;

	@FindBy(xpath = "(//dx-select-box[@valueexpr='value'])[2]")
	WebElement behaviourWD;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[23]")
	WebElement behaviourDropdown;

	@FindBy(xpath = "//span[normalize-space()='Preferences']")
	WebElement preferencesMenu;

	@FindBy(xpath = "//dx-select-box[@valueexpr='name']//input[@role='combobox']")
	WebElement selectedTheme;

	@FindBy(xpath = "(//div[contains(@class,'dx-texteditor-container')])[33]")
	WebElement docFileLinkDropdown;

	@FindBy(xpath = "(//input[contains(@autocomplete,'off')])[33]")
	WebElement documentFileLinks;

	@FindBy(xpath = "(//div[contains(@class,'dx-texteditor-container')])[35]")
	WebElement scrollModeDropdown;

	@FindBy(xpath = "(//input[contains(@autocomplete,'off')])[35]")
	WebElement scrollMode;

	@FindBy(xpath = "(//input[contains(@autocomplete,'off')])[36]")
	WebElement scrollType;

	@FindBy(xpath = "//div[@class='cc-user-panel-name']")
	WebElement userPanel;

	@FindBy(xpath = "//div//span[contains(text(),'Apply')]")
	WebElement applyButton;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']")
	WebElement loaderIcon;

	@FindBy(xpath = "//div[contains(text(),'Preferences')]")
	WebElement preferencesPopupWindow;

	@FindBy(xpath = "//div[contains(text(),'Open in new window')]")
	WebElement openInNewWindowValue;

	@FindBy(xpath = "//div[contains(text(),'Open in same window')]")
	WebElement openInSameWindowValue;

	@FindBy(xpath = "//div[contains(text(),'Teal Light Background')]")
	WebElement tealLightColor;

	@FindBy(xpath = "//div[contains(text(),'Blue Light Background')]")
	WebElement blueLightColor;

	public void verifyPreferencesMenuAvailibility() {
		try {
			checkElementAvailability(By.xpath("//span[normalize-space()='Preferences']"), "Preferences");
		} catch (Exception e) {
			LoggerManager.error("Error in verifying Preferences menu availability: " + e.getMessage());
		}
	}

	private void selectPreferencesMenu() {
		try {
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(userPanel);
			waitForElementToBeClickable(userPanel);
			clickElementJS(userPanel);
			clickElement(preferencesMenu);
		} catch (Exception e) {
			LoggerManager.error("Error in selecting Preferences menu: " + e.getMessage());
		}
	}

	public boolean checkPreferencesMenuVisibility() {
		try {
			selectPreferencesMenu();
			waitForInvisibility(loaderIcon);
			String preferencesPopup = driver.getWindowHandle();
			switchToWindow(preferencesPopup);
			if ("Preferences".equals(getElementText(preferencesPopupWindow))) {
				LoggerManager.info("Popup Title is:" + preferencesPopupWindow.getText());
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("Error in verifying Preferences menu visibility: " + e.getMessage());
			return false;
		}

	}

	public boolean setNavigationToSameWindow() {
		try {
			String preferencesPopUp = driver.getWindowHandle();
			switchToWindow(preferencesPopUp);
			clickElement(behaviourWD); // behaviourDropdown

			if ("Open in same window".equalsIgnoreCase(behaviourDropdown.getAttribute("value"))) {
				clickElementJS(openInNewWindowValue);
				waitForElementToBeClickable(applyButton);
				clickElementJS(applyButton);
				return true;
			} else if ("Open in new window".equalsIgnoreCase(behaviourDropdown.getAttribute("value"))) {
				clickElementJS(openInSameWindowValue);
				waitForElementToBeClickable(applyButton);
				clickElementJS(applyButton);
				return true;
			} else {
				LoggerManager.info("Main Navigation Behaviour dropdown is not clicked");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error(
					"Error in verifying main navigation behaviour for 'Open in same window' value: " + e.getMessage());
			return false;
		}
	}

	public boolean setNavigationToNewWindow() {
		try {
			selectPreferencesMenu();
			waitForInvisibility(loaderIcon);
			String preferencesPopup = driver.getWindowHandle();
			switchToWindow(preferencesPopup);
			clickElement(behaviourDropdown);

			if ("Open in new window".equalsIgnoreCase(behaviourDropdown.getAttribute("value"))) {
				clickElementJS(openInSameWindowValue);
				waitForElementToBeClickable(applyButton);
				clickElementJS(applyButton);
				return true;
			} else if ("Open in same window".equalsIgnoreCase(behaviourDropdown.getAttribute("value"))) {
				clickElementJS(openInNewWindowValue);
				waitForElementToBeClickable(applyButton);
				clickElementJS(applyButton);
				return true;
			} else {
				LoggerManager.info("Main Navigation Behaviour dropdown is not clicked");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error(
					"Error in verifying main navigation behaviour for 'Open in new window' value: " + e.getMessage());
			return false;
		}
	}

	public boolean applyNewTheme() {
		boolean isSuccess = false; 
		try {
			selectPreferencesMenu();
			String preferencesPopup = driver.getWindowHandle();
			switchToWindow(preferencesPopup);
			waitForElementToBeClickable(themeWD);
			clickElementJS(themeWD);
			String themesColor = selectedTheme.getAttribute("value");
			if (themesColor == null) {
				LoggerManager.warn("Theme selection value is null.");
			} else {
				switch (themesColor) {
				case "Blue Light Background":
					  clickElement(tealLightColor);
					  LoggerManager.info("Theme changed to Teal Light Background.");
					  isSuccess = true;
					  break;
				case "Teal Light Background":
					  clickElement(blueLightColor);
					  LoggerManager.info("Theme changed to Blue Light Background.");
					  isSuccess = true;
					  break;
				default:
					  LoggerManager.warn("Unknown theme selected: " + themesColor);
				}
			}
			if (isSuccess) {
				waitForElementToBeClickable(applyButton);
				clickElementJS(applyButton);
				waitForInvisibility(loaderIcon);
			}
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error in verifying Theme Dropdown selection: " + e.getMessage());
		}
		return isSuccess; 
	}

}
