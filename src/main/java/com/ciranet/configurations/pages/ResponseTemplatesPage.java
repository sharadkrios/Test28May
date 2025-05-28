package com.ciranet.configurations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ResponseTemplatesPage extends BasePage {

	@FindBy(xpath = "//div//span[normalize-space()='Response Templates']")
	private WebElement responseTemplatesSideNav;

	@FindBy(xpath = "//input[@role='combobox']")
	private WebElement contextDropdown;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[2]")
	private WebElement templateDropdown;

	@FindBy(xpath = "(//div[@class='config-tree-menu-item'])[1]")
	private WebElement templateDropdownValue;

	@FindBy(xpath = "//h2[@class='page-header']")
	private WebElement pageTitle;

	@FindBy(xpath = "dx-loadindicator-icon")
	private WebElement loaderIcon;

	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	private WebElement pageTitleText;

	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	private WebElement selectedFocusedContextValue;

	public ResponseTemplatesPage(WebDriver driver) {
		super(driver);
	}

	Navigation navigationSearch = new Navigation(driver);

	private String contextSearchTextFromParameter = "";

	private String templateValueText = "";

	private String contextSearchValuetext = "";

	// Add getter method
	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}

	// Add setter method
	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	public boolean navigateToResponseTemplates() {
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigate(By.xpath("//div//span[normalize-space()='Response Templates']"),
					"Response Templates");
			LoggerManager.info("Scrolling to Response Templates navigation");
			waitForInvisibility(loaderIcon);
			scrollToElement(responseTemplatesSideNav);

			if (isElementDisplayed(responseTemplatesSideNav)) {
				LoggerManager.info("Response Templates is visible, clicking on it");
				boolean isPageTitle = "Response Templates Configurations".equals(pageTitle.getText());
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.warn("Response Templates is not visible, search failed");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process");
			return false;
		}
	}

	public String contextDropdownValue() {
		try {
			clickElement(contextDropdown);
			contextDropdown.sendKeys(contextSearchTextFromParameter);
			clickElementJS(selectedFocusedContextValue);
			contextSearchValuetext = selectedFocusedContextValue.getText();
			LoggerManager.info("Context Value");
			return contextSearchValuetext;
		} catch (RuntimeException e) {
			LoggerManager.error("Error occurred in contextDropdownValue: " + e.getMessage());
			throw e;
		}
	}

	public boolean validation() {
		try {
			String strLabel = templateValueText + " - " + contextSearchValuetext;
			String textofPageTitle = pageTitleText.getText();
			return strLabel.equals(textofPageTitle);
		} catch (RuntimeException e) {
			LoggerManager.error("Error occurred in validation: " + e.getMessage());
			return false;
		}
	}

	public boolean responseTemplateSelection() {
		try {
			contextDropdownValue();
			clickElement(templateDropdown);
			clickElement(templateDropdownValue);
			templateValueText = templateDropdownValue.getText();
			validation();
			return true;
		} catch (RuntimeException e) {
			LoggerManager.error("An error occurred while verifying the response template selection." + e.getMessage());
			return false;
		}
	}
}