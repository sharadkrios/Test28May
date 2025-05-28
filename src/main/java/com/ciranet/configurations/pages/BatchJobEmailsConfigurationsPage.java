package com.ciranet.configurations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class BatchJobEmailsConfigurationsPage extends BasePage {

	@FindBy(xpath = "//div[@title='Batch Job Emails Configurations']")
	private WebElement batchJobEmailsSideNav;

	@FindBy(xpath = "//h2[@class='page-header']")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-icon']")
	private WebElement configurationDropdown;

	@FindBy(xpath = "//div//span[normalize-space()='ACH & Fee Notification Email']")
	private WebElement achFeeNotificationEmail;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[3]")
	private WebElement contextDropdown;

	@FindBy(xpath = "//div//span[normalize-space()='ACH Notification Email']")
	private WebElement achNotificationEmail;

	@FindBy(xpath = "//div//span[normalize-space()='Annual Budget Preparation Kickoff']")
	private WebElement annualBudgetPreparationKickoff;

	@FindBy(xpath = "//div//span[normalize-space()='Annual Budget Submission to CAM']")
	private WebElement annualBudgetSubToCam;

	@FindBy(xpath = "//div//span[normalize-space()='Annual Budget Submission to Client']")
	private WebElement annualBudgetSubToClient;

	@FindBy(xpath = "dx-loadindicator-icon")
	private WebElement loaderIcon;

	@FindBy(xpath = "//div//i[@class='dx-icon far fa-plus-square']")
	private WebElement expandAllIcon;

	@FindBy(xpath = "//div[@class='dx-switch-on']")
	private WebElement terminatedOntoggleButton;

	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	private WebElement selectedFocusedContextValue;

	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	private WebElement pageTitleText;

	private String contextSearchTextFromParameter = "";
	public String configurationValueText = "";

	Navigation navigationSearch = new Navigation(driver);

	public BatchJobEmailsConfigurationsPage(WebDriver driver) {
		super(driver);
	}

	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}

	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	public boolean navigateToBatchJobEmails() {
		try {
			navigationSearch.navigate(
					By.xpath("//div[@title='Batch Job Emails Configurations']"), "Batch Job Emails");
			waitForInvisibility(loaderIcon);
			scrollToElement(batchJobEmailsSideNav);
			if (isElementDisplayed(batchJobEmailsSideNav)) {
				boolean isPageTitle = pageTitle.getText().equals("Batch Job Emails Configurations");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.warn("Batch Job Emails is not visible, search failed");
				return false;
			}
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("An error occurred during the navigation search process:" + e.getMessage());
			return false;
		}
	}

	public boolean selectConfigurations(String strDropdownValue) {
		try {
			clickElementJS(configurationDropdown);
			switch (strDropdownValue) {
			case "Select ACH & Fee Notification Email Configuration":
				  clickElement(achFeeNotificationEmail);
				  configurationValueText = achFeeNotificationEmail.getText();
				  clickElement(terminatedOntoggleButton);
				  break;
			case "Select ACH Notification Email Configuration":
				  clickElement(achNotificationEmail);
				  configurationValueText = achNotificationEmail.getText();
				  break;
			case "Select Annual Budget Preparation Kickoff Configuration":
				  clickElement(annualBudgetPreparationKickoff);
				  configurationValueText = annualBudgetPreparationKickoff.getText();
				  break;
			case "Select Annual Budget Submission to CAM Configuration":
				  clickElement(annualBudgetSubToCam);
				  configurationValueText = annualBudgetSubToCam.getText();
				  break;
			case "Select Annual Budget Submission to Client Configuration":
				  clickElement(annualBudgetSubToClient);
				  configurationValueText = annualBudgetSubToClient.getText();
				  break;
			default:
			}
			waitForElementToBeClickable(contextDropdown);
			contextDropdown.click();
			contextDropdown.sendKeys(contextSearchTextFromParameter);
			clickElementJS(selectedFocusedContextValue);
			String contextValueText = selectedFocusedContextValue.getText();
			String strLabel = configurationValueText + " - " + contextValueText;
			waitForInvisibility(loaderIcon);
			String textOfPageTitle = pageTitleText.getText();
			boolean isLabelCorrect=strLabel.equals(textOfPageTitle);			
			if (!isLabelCorrect) {
				LoggerManager.error("Validation failed: The label does not match the page title.");
				return false;
			}else {
			  return true;
			}  
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager
					.error("Time out exception or no such element found while selecting in Batch Job Emails configurations: "
							+ e.getMessage());
			return false;
		}
		
	}
}