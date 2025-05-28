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

public class CommunityAccountingConfigurationsPage extends BasePage {
	public CommunityAccountingConfigurationsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Community Accounting')]")
	WebElement communityAccountingSideNav;

	@FindBy(xpath = "(//div[@class='dx-texteditor-buttons-container'])[2]")
	WebElement configurationDropdown;

	@FindBy(xpath = "//div//span[contains(text(),'AAP Cross Entity Bill')]")
	WebElement aapCrossEntityBill;

	@FindBy(xpath = "//div//span[contains(text(),'AAP Work Flow Auto Action')]")
	WebElement aapWorkFlowAutoAction;

	@FindBy(xpath = "//div//span[contains(text(),'AAP Work Flow CheckList')]")
	WebElement aapWorkFlowCheckList;

	@FindBy(xpath = "//div//span[contains(text(),'AAR Billing Types')]")
	WebElement aarBillingTypes;

	@FindBy(xpath = "//div//span[contains(text(),'AAR Builder Statements')]")
	WebElement aarBuilderStatements;

	@FindBy(xpath = "//div//span[contains(text(),'AAR Misc Invoice Types')]")
	WebElement aarMiscInvoiceTypes;

	@FindBy(xpath = "//div//span[contains(text(),'AAR Payment Application Order')]")
	WebElement aarPaymentApplicationOrder;

	@FindBy(xpath = "//div//span[contains(text(),'AAR Statements')]")
	WebElement aarStatements;

	@FindBy(xpath = "//div//span[contains(text(),'Collections Configuration')]")
	WebElement collectionsConfiguration;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	WebElement contextDropdown;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	WebElement pageTitleText;

	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	WebElement selectedFocusedContextValue;

	@FindBy(xpath = "//div[@class='dx-switch-on']")
	WebElement terminatedOnToggleButton;

	private String contextSearchTextFromParameter = "";

	public String configurationValueText = "";

	public String contextSearchValueText = "";

	public static final int TIMEOUT = 10;

	Navigation navigationSearch = new Navigation(driver);

	// Add getter method
	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}

	// Add setter method
	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	public boolean navigateToCommuityAccountingConfigurations() {
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigate(By.xpath("//span[contains(text(),'Community Accounting')]"),
					"Community Accounting");
			waitForInvisibility(loaderIcon);
			scrollToElement(communityAccountingSideNav);
			waitForInvisibility(loaderIcon);
			if (isElementDisplayed(communityAccountingSideNav)) {
				boolean isPageTitle = pageTitle.getText().equals("Community Accounting Configurations");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				waitForInvisibility(loaderIcon);
				return isPageTitle;
			} else {
				LoggerManager.warn("Community Accounting Configurations is not visible, search failed");
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

	public boolean selectAAPCrossEntityBill() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(aapCrossEntityBill);
			configurationValueText = aapCrossEntityBill.getText();
			waitForElementToBeVisible(terminatedOnToggleButton);
			clickElementJS(terminatedOnToggleButton);
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectAAPCrossEntityBill:" + e.getMessage());
			return false;
		}
	}

	public boolean selectAAPWorkFlowAutoAction() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(aapWorkFlowAutoAction);
			configurationValueText = aapWorkFlowAutoAction.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectAAPWorkFlowAutoAction:" + e.getMessage());
			return false;
		}
	}

	public boolean selectAAPWorkFlowCheckList() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(aapWorkFlowCheckList);
			configurationValueText = aapWorkFlowCheckList.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectAAPWorkFlowCheckList:" + e.getMessage());
			return false;
		}
	}

	public boolean selectAARBillingTypes() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(aarBillingTypes);
			configurationValueText = aarBillingTypes.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectAARBillingTypes:" + e.getMessage());
			return false;
		}
	}

	public boolean selectAARBuilderStatements() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(aarBuilderStatements);
			configurationValueText = aarBuilderStatements.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectAARBuilderStatements:" + e.getMessage());
			return false;
		}
	}

	public boolean selectAARMiscInvoiceTypes() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(aarMiscInvoiceTypes);
			configurationValueText = aarMiscInvoiceTypes.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectAARMiscInvoiceTypes:" + e.getMessage());
			return false;
		}
	}

	public boolean selectAARPaymentApplicationOrder() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(aarPaymentApplicationOrder);
			configurationValueText = aarPaymentApplicationOrder.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectAARPaymentApplicationOrder:" + e.getMessage());
			return false;
		}
	}

	public boolean selectAARStatements() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(aarStatements);
			configurationValueText = aarStatements.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectAARStatements:" + e.getMessage());
			return false;
		}
	}

	public boolean selectCollectionsConfiguration() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(collectionsConfiguration);
			configurationValueText = collectionsConfiguration.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validateConfigName method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("Error in selectCollectionsConfiguration:" + e.getMessage());
			return false;
		}
	}
}