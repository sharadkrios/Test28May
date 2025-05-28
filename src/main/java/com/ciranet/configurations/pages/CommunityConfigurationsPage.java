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

public class CommunityConfigurationsPage extends BasePage {
	
	@FindBy(xpath = "//h2[@class='page-header']")
	private WebElement pageTitle;
	@FindBy(xpath = "//div[@title='Community Configurations']")
	private WebElement communitySideNav;
	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])")
	private WebElement configurationDropdown;
	@FindBy(xpath = "//span[normalize-space()='Access Control Waiver']")
	private WebElement accessControlWaiver;
	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[3]")
	private WebElement contextDropdown;
	@FindBy(xpath = "//span[normalize-space()='Board Approval']")
	private WebElement boardApproval;
	@FindBy(xpath = "//div//span[normalize-space()='Collection Letter Fees']")
	private WebElement collectionLetterFees;
	@FindBy(xpath = "//div//span[normalize-space()='Community Configuration']")
	private WebElement communityConfiguration;
	@FindBy(xpath = "//div//span[contains(text(),'Fulfillment Job Special Pricing Configuration')]")
	private WebElement fulfillmentJobSpecialPricingConfiguration;
	@FindBy(xpath = "//div//span[normalize-space()='Holidays']")
	private WebElement holidays;
	@FindBy(xpath = "//div//span[normalize-space()='Info']")
	private WebElement info;
	@FindBy(xpath = "//div//span[normalize-space()='Mass Communication Configuration']")
	private WebElement massCommunicationConfiguration;
	@FindBy(xpath = "//div//span[normalize-space()='Notes']")
	private WebElement notes;
	@FindBy(xpath = "//div//span[normalize-space()='Owner Fees']")
	private WebElement ownerFees;
	@FindBy(xpath = "//span[normalize-space()='Printing Provider']")
	private WebElement printingProvider;
	@FindBy(xpath = "//div[@class=\"dx-overlay-content dx-resizable dx-loadpanel-content\"]")
	private WebElement loaderIcon;
	@FindBy(xpath = "//div[@class='dx-switch-on']")
	private WebElement terminatedOntoggleButton;
	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	private WebElement selectedFocusedContextValue;
	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	private WebElement pageTitleText;
	Navigation navigationSearch = new Navigation(driver);
	private String contextSearchTextFromParameter = "";
	private String configurationValueText = "";

	public CommunityConfigurationsPage(WebDriver driver) {
		super(driver);
	}
	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}
	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	public boolean navigateToCommunityConfigurations() {
		try {
			navigationSearch.navigate(
					By.xpath("(//div[@class='dx-template-wrapper dx-item-content dx-treeview-item-content'])[8]"),
					"Configurations");
			waitForInvisibility(loaderIcon);
			clickElementJS(communitySideNav);
			waitForInvisibility(loaderIcon);
			LoggerManager.info("Successfully searched for the navigation and accessed  Community Configurations");
			boolean isPageTitle = "Community Configurations".equals(pageTitle.getText());
			LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
			return isPageTitle;
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process:" + e.getMessage());
			return false;
		}
	}

	public boolean selectConfigurations(String configurationDropdownValue) {
		try {
			waitForElementToBeClickable(configurationDropdown);
			clickElement(configurationDropdown);
			waitForInvisibility(loaderIcon);
			switch (configurationDropdownValue) {
			case "Select Access Control Waiver Configuration":
				  clickElement(accessControlWaiver);
				  configurationValueText = accessControlWaiver.getText();
				  waitForElementToBeVisible(terminatedOntoggleButton);
				  clickElementJS(terminatedOntoggleButton);
				  break;
			case "Select Board Approval Configuration":
				  clickElement(boardApproval);
				  configurationValueText = boardApproval.getText();
				  break;
			case "Select Collection Letter Fees Configuration":
				  clickElementJS(collectionLetterFees);
				  configurationValueText = collectionLetterFees.getText();
				  break;
			case "Select Community Configuration":
				  clickElementJS(communityConfiguration);
				  configurationValueText = communityConfiguration.getText();
				  break;
			case "Select Fulfillment Job Special Pricing Configuration":
				  clickElementJS(fulfillmentJobSpecialPricingConfiguration);
				  configurationValueText = fulfillmentJobSpecialPricingConfiguration.getText();
				  break;
			case "Select Holidays Configuration":
				  clickElementJS(holidays );
				  configurationValueText = holidays.getText();
				  break;
			case "Select Info Configuration":
				  clickElementJS(info);
				  configurationValueText = info.getText();
				  break;
			case "Select Mass Communication Configuration":
				  clickElementJS(massCommunicationConfiguration);
				  configurationValueText = massCommunicationConfiguration.getText();
				  break;
			case "Select Notes Configuration":
				  clickElementJS(notes);
				  configurationValueText = notes.getText();
				  break;
			case "Select Owner Fees Configuration":
				  clickElementJS(ownerFees);
				  configurationValueText = ownerFees.getText();
				  break;
			case "Select Printing Provider Configuration":
				  clickElementJS(printingProvider);
				  configurationValueText = printingProvider.getText();
				  break;
			default:
				  LoggerManager.warn("No matching dropdown value found: " + configurationDropdownValue);
				  break;
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
					.error("Time out exception or no such element found while selecting in community configurations: "
							+ e.getMessage());
			return false;
		}
		
	}
}
