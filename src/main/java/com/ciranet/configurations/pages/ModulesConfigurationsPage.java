package com.ciranet.configurations.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BaseConfigurationPage;
import com.ciranet.utilities.LoggerManager;

public class ModulesConfigurationsPage extends BaseConfigurationPage {

	@FindBy(xpath = "//div//span[normalize-space()='Modules']")
	WebElement modulesSideNav;

	@FindBy(xpath = "//li[@class='dx-treeview-node dx-treeview-item-without-checkbox']//div//span[normalize-space()='Configurations']")
	WebElement configurationsSideNav;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-icon']")
	WebElement configurationDropdown;

	@FindBy(xpath = "//div//span[contains(text(),'Customer Defined Info')]")
	WebElement customerDefinedInfo;

	@FindBy(xpath = "//div//span[contains(text(),'Egnyte Configuration')]")
	WebElement egnyteConfiguration;

	@FindBy(xpath = "//div//span[contains(text(),'Help')]")
	WebElement help;

	@FindBy(xpath = "//div//span[normalize-space()='Cira Budget Recommendations and Assumptions']")
	WebElement recommendationsAndAssumptions;

	@FindBy(xpath = "//div//span[contains(text(),'Cira Budget Supplemental Information')]")
	WebElement supplementalInformation;

	@FindBy(xpath = "//div//span[contains(text(),'Transition Document')]")
	WebElement transitionDocument;

	@FindBy(xpath = "//div//span[contains(text(),'Transition Task Templates')]")
	WebElement transitionTaskTemplates;

	@FindBy(xpath = "//div//span[contains(text(),'Work Order Work Areas')]")
	WebElement workOrderWorkAreas;

	@FindBy(xpath = "//div[contains(text(),'Tasks')]")
	WebElement labelTransitionTaskTemplates;

	public String contextSearchTextFromParameter = "";

	public ModulesConfigurationsPage(WebDriver driver) {
		super(driver);
	}

	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}

	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	public boolean navigateToModulesConfiguration() {
		return navigateToConfigurationModule(configurationsSideNav, modulesSideNav, "Modules Configurations");
	}

	public boolean selectConfigurationByName(String configurationName, String contextSearchText) {
		try {
			WebElement selectedConfigurationName = null;

			switch (configurationName) {
			case "Cira Budget Recommendations and Assumptions":
				BaseConfigurationPage.contextSearchTextFromParameter = contextSearchText;
				selectedConfigurationName = recommendationsAndAssumptions;
				break;
			case "Cira Budget Supplemental Information":
				selectedConfigurationName = supplementalInformation;
				break;
			case "Customer Defined Info":
				selectedConfigurationName = customerDefinedInfo;
				break;
			case "Egnyte Configuration":
				selectedConfigurationName = egnyteConfiguration;
				break;
			case "Help":
				selectedConfigurationName = help;
				break;
			case "Transition Document":
				selectedConfigurationName = transitionDocument;
				break;
			case "Work Order Work Areas":
				selectedConfigurationName = workOrderWorkAreas;
				break;
			default:
				LoggerManager.error("Invalid configuration option: " + selectedConfigurationName);
			}

			if (selectedConfigurationName != null) {
				return selectConfiguration(selectedConfigurationName);
			} else {
				LoggerManager.error("Failed to select configuration: " + selectedConfigurationName);
				return false;
			}

		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error(
					"Time out or No Such Element Exception occurred while selecting configurations: " + e.getMessage());
			return false;
		}
	}

	public String selectTransitionTaskTemplates() {
		try {
			clickElementJS(configurationDropdown);
			waitForElementToBeClickable(transitionTaskTemplates);
			clickElementJS(transitionTaskTemplates);
			waitForElementToBeVisible(labelTransitionTaskTemplates);
			return labelTransitionTaskTemplates.getText();
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred while selecting Transition Task Templates: " + e.getMessage());
			throw e;
		}
	}
}

