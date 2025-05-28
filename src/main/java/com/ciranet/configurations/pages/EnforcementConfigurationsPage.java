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

public class EnforcementConfigurationsPage extends BasePage {

	@FindBy(xpath = "//div[@class='tree-item-template']//span[contains(text(),'Enforcement')]")
	private WebElement enforcementSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-icon']")
	private WebElement configurationDropdown;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	private WebElement contextDropdown;

	@FindBy(xpath = "//div//span[contains(text(),'Architectural Categories')]")
	private WebElement architecturalCategories;

	@FindBy(xpath = "//div//span[contains(text(),'Architectural Forms and Guides')]")
	private WebElement architecturalFormsandGuides;

	@FindBy(xpath = "//div//span[contains(text(),'Violation Category / SubCategory Configuration')]")
	private WebElement violationCategorySubCategoryConfiguration;

	@FindBy(xpath = "//div//span[contains(text(),'Violation Escalation Configuration')]")
	private WebElement violationEscalationConfiguration;

	@FindBy(xpath = "//div//span[contains(text(),' Violation Notification Templates ')]")
	private WebElement violationNotificationTemplates;

	@FindBy(xpath = "//div//span[contains(text(),'Violation Restriction Definition')]")
	private WebElement violationRestrictionDefinition;

	@FindBy(xpath = "dx-loadindicator-icon")
	private WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	private WebElement pageTitleText;

	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	private WebElement selectedFocusedContextValue;

	@FindBy(xpath = "//div[@class='dx-switch-on']")
	private WebElement terminatedOntoggleButton;

	public EnforcementConfigurationsPage(WebDriver driver) {
		super(driver);
	}

	private String contextSearchTextFromParameter = "";

	public String configurationValueText = "";

	public String contextSearchValueText = "";
	
	public static final int TIMEOUT = 2;

	// Add getter method
	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}

	// Add setter method
	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigateToEnforcementConfigurations() {
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigate(
					By.xpath("//div[@class='tree-item-template']//span[contains(text(),'Enforcement')]"),
					"Enforcement");
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Scrolling to Enforcement Configurations navigation");
			scrollToElement(enforcementSideNav);
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(enforcementSideNav)) {
				boolean isPageTitle = "Enforcement Configurations".equals(pageTitle.getText());
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.warn("Enforcement Configurations is not visible, search failed");
				return false;
			}
		} catch (Exception e) {
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
			contextSearchValueText = selectedFocusedContextValue.getText();
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred in getContextDisplayText: " + e.getMessage());
			throw e;
		}
	}

	public boolean validateConfigName() {
		try {
			String configurationContextTitle = configurationValueText + " - " + contextSearchValueText;
			boolean isLabelCorrect = configurationContextTitle.equals(pageTitleText.getText());
			TimeUnit.SECONDS.sleep(TIMEOUT);
			if (!isLabelCorrect) {
				LoggerManager.error("validateConfigName failed: The label does not match the page title.");
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

	public boolean selectArchitecturalCategories() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(architecturalCategories);
			configurationValueText = architecturalCategories.getText();
			waitForElementToBeVisible(terminatedOntoggleButton);
			clickElementJS(terminatedOntoggleButton);
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager
					.error("An error occurred in selectArchitecturalCategories method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectArchitecturalFormsandGuides() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(architecturalFormsandGuides);
			configurationValueText = architecturalFormsandGuides.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error(
					"An error occurred in selectArchitecturalFormsandGuides method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectViolationCategorySubCategoryConfiguration() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(violationCategorySubCategoryConfiguration);
			configurationValueText = violationCategorySubCategoryConfiguration.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error(
					"An error occurred in selectViolationCategorySubCategoryConfiguration method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectViolationEscalationConfiguration() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(violationEscalationConfiguration);
			configurationValueText = violationEscalationConfiguration.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager
					.error("An error occurred in selectViolationEscalationConfiguration method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectViolationNotificationTemplates() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(violationNotificationTemplates);
			configurationValueText = violationNotificationTemplates.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error(
					"An error occurred in selectViolationNotificationTemplates method: " + e.getMessage());
			return false;
		}
	}

	public boolean selectViolationRestrictionDefinition() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(violationRestrictionDefinition);
			configurationValueText = violationRestrictionDefinition.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error(
					"An error occurred in selectViolationRestrictionDefinition method: " + e.getMessage());
			return false;
		}
	}
}
