package com.ciranet.corporatecirabooks.generalledger.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class UploadBudgetsPage extends BasePage {

	@FindBy(xpath = "//span[contains(.,'Upload Budgets')]")
	private WebElement uploadBudgetsSideNav;

	@FindBy(xpath = "//div//span[normalize-space()='CiraBooks Corporate']")
	private WebElement ciraBooksCorporateSideNav;

	@FindBy(xpath = "//div[@title='General Ledger']")
	private WebElement generalLedgerSideNav;

	@FindBy(xpath = "//dx-select-box[@ng-reflect-display-expr='name']")
	private WebElement managementCompanyDropdown;

	@FindBy(xpath = "//div[contains(text(),'RealManage')]")
	private WebElement realManage;

	@FindBy(xpath = "//span[normalize-space()='Get Template']")
	private WebElement getTemplateButton;

	@FindBy(name = "budgetName")
	private WebElement budgetNameTextbox;

	@FindBy(xpath = "//div[@class='dx-switch-off']")
	private WebElement isPrimaryToggleButton;

	@FindBy(xpath = "//span[normalize-space()='Browse']")
	private WebElement browseButton;

	@FindBy(xpath = "//span[normalize-space()='Upload']")
	private WebElement uploadButton;
	
	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']")
	private WebElement loaderIcon;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alertMessage;

	@FindBy(xpath = "//h2[@class='page-header flex-center-aligned-row']")
	private WebElement pageTitle;

	public UploadBudgetsPage(WebDriver driver) {
		super(driver);
	}

	public static final int TIMEOUT = 10;

	Navigation navigationSearch = new Navigation(driver);

	public boolean navigateToUploadBudgets() {
		try {
			waitForInvisibility(loaderIcon);
			navigationSearch.navigate(By.xpath("//div//span[normalize-space()='CiraBooks Corporate']"),
					"CiraBooks Corporate");
			waitForInvisibility(loaderIcon);
			scrollToElement(generalLedgerSideNav);
			clickElementJS(generalLedgerSideNav);
			waitForInvisibility(loaderIcon);
			scrollToElement(uploadBudgetsSideNav);
			clickElement(uploadBudgetsSideNav);
			if (isElementDisplayed(uploadBudgetsSideNav)) {
				boolean isPageTitle = "Upload Budgets".equals(pageTitle.getText());
				LoggerManager.info("Page Title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.warn("Upload Budgets navigation is not visible, search failed");
				return false;
			}
		} catch (Exception e) {
			LoggerManager.error("An error occurred during the navigation search process: " + e.getMessage());
			return false;
		}
	}

	public boolean verifyBudgetFileUpload(String uploadFilePath) throws AWTException {
		try {
			TimeUnit.SECONDS.sleep(TIMEOUT);
			clickElement(managementCompanyDropdown);
			clickElement(realManage);
			clickElement(getTemplateButton);

			Robot robot = new Robot();
			enterText(budgetNameTextbox, "Test Budget");

			TimeUnit.SECONDS.sleep(TIMEOUT);
			clickElement(isPrimaryToggleButton);

			clickElement(browseButton);

			uploadFilePath = System.getProperty("user.dir") + uploadFilePath;

			StringSelection filePathSelection = new StringSelection(uploadFilePath);

			// Clipboard copy
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

			// pressing ctrl+v
			robot.keyPress(KeyEvent.VK_CONTROL);
			TimeUnit.SECONDS.sleep(TIMEOUT);

			robot.keyPress(KeyEvent.VK_V);
			TimeUnit.SECONDS.sleep(TIMEOUT);

			robot.keyRelease(KeyEvent.VK_V);
			TimeUnit.SECONDS.sleep(TIMEOUT);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			TimeUnit.SECONDS.sleep(TIMEOUT);

			robot.keyPress(KeyEvent.VK_ENTER);
			TimeUnit.SECONDS.sleep(TIMEOUT);

			robot.keyRelease(KeyEvent.VK_ENTER);
			TimeUnit.SECONDS.sleep(TIMEOUT);

			clickElement(uploadButton);

			if (isElementDisplayed(alertMessage)) {
				LoggerManager.info("Alert Message: " + alertMessage.getText());
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException | TimeoutException | InterruptedException e) {
			Thread.currentThread().interrupt();
			LoggerManager.error("An error occurred during the budget upload process: " + e.getMessage());
			return false;
		}
	}
}