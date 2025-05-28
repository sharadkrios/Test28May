package com.ciranet.configurations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ReportTemplatesPage extends BasePage {
	public ReportTemplatesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='header-text']//span[contains(text(),'Report Templates')]")
	WebElement reportTemplatesSideNav;

	@FindBy(xpath = "(//div[@class='dx-texteditor-buttons-container'])[2]")
	WebElement configurationDropdown;

	@FindBy(xpath = "//div[@class='config-tree-menu-item']//span[contains(text(),'Letter Templates')]")
	WebElement letterTemplate;

	@FindBy(xpath = "//div[@class='config-tree-menu-item']//span[normalize-space()='Builder Statement Cover Letter']")
	WebElement letterTemplateValue;

	@FindBy(xpath = "//div[@class='config-tree-menu-item']//span[contains(text(),'Letterhead Template')]")
	WebElement letterheadTemplate;

	@FindBy(xpath = "//div[@class='config-tree-menu-item']//span[normalize-space()='Page Footer']")
	WebElement letterheadTemplateValue;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-input-wrapper'])[2]")
	WebElement contextDropdown;

	@FindBy(xpath = "(//div[@class='dx-treelist-content']//td[@Class='dx-treelist-cell-expandable'])[1]")
	WebElement contextValue;

	@FindBy(xpath = "//div[@class='dx-item dx-toolbar-item dx-toolbar-button']//strong[contains(text(),' Letter Templates / Builder Statement Cover Letter - Global ')]")
	WebElement pageTitleLetterTemplate;

	@FindBy(xpath = "//div[@class='dx-item dx-toolbar-item dx-toolbar-button']//strong[contains(text(),' Letterhead Template / Page Footer - Global ')]")
	WebElement pageTitleLetterheadTemplate;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	@FindBy(xpath = "//h2[@class='page-header']")
	WebElement pageTitle;

	@FindBy(xpath = "(//div//input[@role='textbox'])[3]")
	WebElement nameTextBox;

	@FindBy(xpath = "//div//span[normalize-space()='Save']")
	WebElement saveButton;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigate() {
		try {
			navigationSearch.navigateBySideNavigation(
					By.xpath("//div[@class='header-text']//span[contains(text(),'Report Templates')]"),
					" Report Templates ");
			LoggerManager.info("Navigated to 'Report Templates'");
			LoggerManager.info("Scrolling to Report Templates navigation");
			scrollToElement(reportTemplatesSideNav);

			if (isElementDisplayed(reportTemplatesSideNav)) {
				LoggerManager.info("Report Templates is visible, clicking on it");
				clickElementJS(reportTemplatesSideNav);

				waitForInvisibility(loaderIcon);

				LoggerManager.info("Successfully searched for the navigation and accessed  Report Templates ");

				boolean isPageTitle = pageTitle.getText().equals("Report Templates Configurations");
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;

			} else {
				LoggerManager.warn("Report Templates is not visible, search failed");
				return false;
			}

		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process"+ e.getMessage());
			return false;
		}
	}

	public String letterTemplate() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(letterTemplate);
			Actions action = new Actions(driver);
			action.moveToElement(letterTemplateValue).click().build().perform();
			waitForElementToBeVisible(contextDropdown);
			clickElement(contextDropdown);
			action.moveToElement(contextValue).click().build().perform();
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(pageTitleLetterTemplate);
			return pageTitleLetterTemplate.getText();
		} catch (Exception e) {
			LoggerManager.error("An error occurred in letterTemplate method:"+ e.getMessage());
			throw e;
		}
	}

	public String letterheadTemplate() {
		try {
			clickElement(configurationDropdown);
			clickElementJS(letterheadTemplate);
			Actions action = new Actions(driver);
			action.moveToElement(letterheadTemplateValue).click().build().perform();
			waitForElementToBeVisible(contextDropdown);
			clickElement(contextDropdown);
			action.moveToElement(contextValue).click().build().perform();
			waitForInvisibility(loaderIcon);
			waitForElementToBeVisible(pageTitleLetterheadTemplate);
			return pageTitleLetterheadTemplate.getText();
		} catch (Exception e) {
			LoggerManager.error("An error occurred in letterHeadTemplate method:"+ e.getMessage());
			throw e;
		}
	}
}

