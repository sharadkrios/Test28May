package com.ciranet.configurations.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ServicesConfigurationsPage extends BasePage {

	@FindBy(xpath = "//div//span[normalize-space()='Services']")
	private WebElement servicesSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	private WebElement pageTitle;

	@FindBy(xpath = "(//div[@class='dx-texteditor-buttons-container'])[2]")
	private WebElement configurationDropdown;

	@FindBy(xpath = "//span[contains(text(),'Board Portal')]")
	private WebElement boardPortal;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	private WebElement contextDropdown;

	@FindBy(xpath = "//span[normalize-space()='Branding Configuration']")
	private WebElement brandingConfiguration;

	@FindBy(xpath = "//span[normalize-space()='Business Hours']")
	private WebElement businessHours;

	@FindBy(xpath = "//span[normalize-space()='Calendar Configuration']")
	private WebElement calendarConfiguration;

	@FindBy(xpath = "(//div[@class='dx-template-wrapper dx-item-content dx-menu-item-content'])[5]")
	private WebElement massCommunicationSystemTemplate;

	@FindBy(xpath = "//span[normalize-space()='Resident Portal']")
	private WebElement residentPortal;

	@FindBy(xpath = "//span[normalize-space()='Service Groups']")
	private WebElement serviceGroups;

	@FindBy(xpath = "//span[normalize-space()='Service Roles']")
	private WebElement serviceRoles;

	@FindBy(xpath = "//div[@class='config-tree-menu-item']//span[contains(text(),'Services')]")
	private WebElement services;

	@FindBy(xpath = "dx-loadindicator-icon")
	private WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	private WebElement pageTitleText;

	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	private WebElement selectedFocusedContextValue;

	@FindBy(xpath = "(//div[@class='dx-switch-on'][contains(.,'Yes')])[1]")
	private WebElement terminatedOntoggleButton;

	public ServicesConfigurationsPage(WebDriver driver) {
		super(driver);
	}

	Navigation navigationSearch = new Navigation(driver);

	private String contextSearchTextFromParameter = "";

	public String configurationValueText = "";

	public String contextSearchValuetext = "";

	public static final int TIMEOUT = 10;

	// Add getter method
	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}

	// Add setter method
	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	public boolean navigateToServicesConfigurations() {
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigate(By.xpath("//div//span[normalize-space()='Services']"), "Services");
			waitForInvisibility(loaderIcon);
			scrollToElement(servicesSideNav);
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(servicesSideNav)) {
				boolean isPageTitle = "Services Configurations".equals(pageTitle.getText());
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				waitForInvisibility(loaderIcon);
				return isPageTitle;
			} else {
				LoggerManager.warn("Services Configurations is not visible, search failed");
				return false;
			}
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}
	}

	public void getContextDisplayText() {
		try {
			waitForElementToBeVisible(contextDropdown);
			clickElementJS(contextDropdown);
			contextDropdown.sendKeys(contextSearchTextFromParameter);
			clickElementJS(selectedFocusedContextValue);
			contextSearchValuetext = selectedFocusedContextValue.getText();
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred in contextDropdownValue: " + e.getMessage());
			throw e;
		}
	}

	public boolean validateConfigName() {
		try {
			String configurationContextTitle = configurationValueText + " - " + contextSearchValuetext;
			boolean isLabelCorrect = configurationContextTitle.equals(pageTitleText.getText());
			TimeUnit.SECONDS.sleep(TIMEOUT);
			if (!isLabelCorrect) {
				LoggerManager
						.error("validateConfigName failed: The label does not match the Configuration Context Title.");
				return false;
			} else {
				return true;
			}
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error occurred in validateConfigName: " + e.getMessage());
			return false;
		}
	}

	public boolean selectBoardPortal() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(boardPortal);
			configurationValueText = boardPortal.getText();
			waitForElementToBeVisible(terminatedOntoggleButton);
			clickElementJS(terminatedOntoggleButton);
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in selectBoardPortal method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectBrandingConfiguration() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(brandingConfiguration);
			configurationValueText = brandingConfiguration.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in selectBrandingConfiguration method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectBussinessHours() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(businessHours);
			configurationValueText = businessHours.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in selectBussinessHours method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectCalendarConfiguration() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(calendarConfiguration);
			configurationValueText = calendarConfiguration.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in selectCalendarConfiguration method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectMassCommunicationSystemTemplate() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(massCommunicationSystemTemplate);
			configurationValueText = massCommunicationSystemTemplate.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in selectMassCommunicationSystemTemplate method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectResidentPortal() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(residentPortal);
			configurationValueText = residentPortal.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in selectResidentPortal method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectServiceGroups() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(serviceGroups);
			configurationValueText = serviceGroups.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred in selectServiceGroups method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectServiceRoles() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(serviceRoles);
			configurationValueText = serviceRoles.getText();
			getContextDisplayText();
			waitForInvisibility(loaderIcon);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("An error occurred in selectServiceRoles method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectServices() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(services);
			configurationValueText = services.getText();
			getContextDisplayText();
			waitForInvisibility(loaderIcon);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("An error occurred in selectServices method: " + e.getMessage());
			return false;
		}
	}
}
