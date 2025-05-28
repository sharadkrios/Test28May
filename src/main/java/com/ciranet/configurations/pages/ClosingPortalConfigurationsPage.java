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

public class ClosingPortalConfigurationsPage extends BasePage {

	@FindBy(xpath = "(//div[@class='tree-item-template'])[8]")
	private WebElement configurationsSideNav;

	@FindBy(xpath = "//div//span[normalize-space()='Closing Portal']")
	private WebElement closingPortalSideNav;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-icon']")
	private WebElement configurationDropdown;

	@FindBy(xpath = "//span[normalize-space()='Account Inquiry Fulfillment']")
	private WebElement accountInquiryFulfillment;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	private WebElement contextDropdown;

	@FindBy(xpath = "//span[normalize-space()='CiraConnect Fee']")
	private WebElement ciraConnectFee;

	@FindBy(xpath = "//span[normalize-space()='Closing Portal Delivery Tiers']")
	private WebElement closingPortalDeliveryTiers;

	@FindBy(xpath = "//span[normalize-space()='Portal Configuration Fees & Charges']")
	private WebElement portalConfigurationFeesCharges;

	@FindBy(xpath = "//h2[@class='page-header']")
	private WebElement pageTitle;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']")
	private WebElement loaderIcon;

	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	private WebElement selectedFocusedContextValue;

	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	private WebElement pageTitleText;

	public ClosingPortalConfigurationsPage(WebDriver driver) {
		super(driver);
	}

	private String contextSearchTextFromParameter = "";

	private String configurationValueText = "";

	public static final int TIMEOUT = 10;

	// Add getter method
	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}

	// Add setter method
	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigateToClosingPortalConfigurations() {
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigate(By.xpath("(//div[@class='tree-item-template'])[8]"), "Configurations");
			LoggerManager.info("Scrolling to Closing Portal Configurations navigation");
			waitForInvisibility(loaderIcon);
			scrollToElement(configurationsSideNav);
			clickElementJS(closingPortalSideNav);
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(closingPortalSideNav)) {
				boolean isPageTitle = "Closing Portal Configurations".equals(pageTitle.getText());
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.warn("Closing Portal Configurations is not visible, search failed");
				return false;
			}
		} catch (RuntimeException e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}
	}

	public boolean selectConfigurations(String configurationDropdownValue) {
		try {
			clickElementJS(configurationDropdown);
			switch (configurationDropdownValue) {
			case "Account Inquiry Fulfillment":
				clickElementJS(accountInquiryFulfillment);
				configurationValueText = accountInquiryFulfillment.getText();
				break;
			case "CiraConnect Fee":
				clickElementJS(ciraConnectFee);
				configurationValueText = ciraConnectFee.getText();
				break;
			case "Closing Portal Delivery Tiers":
				clickElementJS(closingPortalDeliveryTiers);
				configurationValueText = closingPortalDeliveryTiers.getText();
				break;
			case "Portal Configuration Fees & Charges":
				clickElementJS(portalConfigurationFeesCharges);
				configurationValueText = portalConfigurationFeesCharges.getText();
				break;
			default:
				LoggerManager.warn("Dropdown value '" + configurationDropdownValue + "' does not match any case.");
				break;
			}
			waitForElementToBeClickable(contextDropdown);
			contextDropdown.click();
			contextDropdown.sendKeys(contextSearchTextFromParameter);
			clickElementJS(selectedFocusedContextValue);
			String contextValueText = selectedFocusedContextValue.getText();
			String configurationContextTitle = configurationValueText + " - " + contextValueText;
			TimeUnit.SECONDS.sleep(TIMEOUT);
			boolean isLabelCorrect = configurationContextTitle.equals(pageTitleText.getText());
			if (!isLabelCorrect) {
				LoggerManager.error("Validation failed: The label does not match the page title.");
				return false;
			} else {
				return true;
			}
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error(
					"Time out exception or no such element found while selecting in Closing Portal configurations: "
							+ e.getMessage());
			return false;
		}
		
	}
}